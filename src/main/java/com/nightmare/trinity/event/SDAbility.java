package com.nightmare.trinity.event;

import com.nightmare.trinity.content.SDItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.neoforge.event.entity.living.LivingExperienceDropEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;

public final class SDAbility {

    public SDAbility() {
        // no-op
    }

    public static void register() {
        NeoForge.EVENT_BUS.register(new SDAbility());
    }

    // ===== Helper: does player wear full SD armor? =====
    private static boolean hasFullSculkedDiamondArmor(Player player) {
        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

        return !head.isEmpty() && !chest.isEmpty() && !legs.isEmpty() && !feet.isEmpty()
                && head.is(SDItems.SCULKED_DIAMOND_HELMET.get())
                && chest.is(SDItems.SCULKED_DIAMOND_CHESTPLATE.get())
                && legs.is(SDItems.SCULKED_DIAMOND_LEGGINGS.get())
                && feet.is(SDItems.SCULKED_DIAMOND_BOOTS.get());
    }

    // ===== Helper: is this stack an SD weapon/tool for XP doubling? =====
    private static boolean isSculkedDiamondToolOrWeapon(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(SDItems.SCULKED_DIAMOND_SWORD.get())
                || stack.is(SDItems.SCULKED_DIAMOND_PICKAXE.get())
                || stack.is(SDItems.SCULKED_DIAMOND_AXE.get())
                || stack.is(SDItems.SCULKED_DIAMOND_SHOVEL.get())
                || stack.is(SDItems.SCULKED_DIAMOND_HOE.get());
    }

    // ===== 4.1 – Armor tick: darkness immunity + night vision =====

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        if (player.level().isClientSide) return;

        if (hasFullSculkedDiamondArmor(player)) {
            // 1) Darkness immunity
            if (player.hasEffect(MobEffects.DARKNESS)) {
                player.removeEffect(MobEffects.DARKNESS);
            }

            // 2) Night vision (refresh with small buffer to avoid flicker)
            int duration = 220; // 11 seconds
            MobEffectInstance current = player.getEffect(MobEffects.NIGHT_VISION);
            if (current == null || current.getDuration() <= 40) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.NIGHT_VISION,
                        duration,
                        0,
                        false, // ambient
                        false, // show particles
                        true   // show icon
                ));
            }
        }
    }

    // ===== 4.2 – Warden becomes “passive” toward SD players =====

    @SubscribeEvent
    public void onChangeTarget(LivingChangeTargetEvent event) {
        if (!(event.getEntity() instanceof Warden warden)) return;

        LivingEntity newTarget = event.getNewTarget();
        if (newTarget instanceof Player player && hasFullSculkedDiamondArmor(player)) {
            // Warden will not target SD-armored players
            event.setNewTarget(null);
        }
    }

    // (Later we can add extra logic to make the Warden prefer hostile mobs that are attacking the SD player.)

    // ===== 4.3 – XP double on mob kills =====

    @SubscribeEvent
    public void onMobXPDrop(LivingExperienceDropEvent event) {
        Player attacker = event.getAttackingPlayer();
        if (attacker == null) return;

        ItemStack mainHand = attacker.getMainHandItem();
        if (!isSculkedDiamondToolOrWeapon(mainHand)) return;

        int original = event.getDroppedExperience();
        if (original <= 0) return;

        event.setDroppedExperience(original * 2);
    }

    // ===== 4.4 – XP double on block XP when using SD tools =====

    @SubscribeEvent
    public void onBlockDrops(BlockDropsEvent event) {
        Player player = event.getBreaker();
        if (player == null) return;

        ItemStack held = player.getMainHandItem();
        if (!isSculkedDiamondToolOrWeapon(held)) return;

        int xp = event.getDroppedExperience();
        if (xp > 0) {
            event.setDroppedExperience(xp * 2);
        }
    }

    // ===== 4.5 – Warden drops SD upgrade template =====

    @SubscribeEvent
    public void onWardenDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();
        if (level.isClientSide) return;

        if (entity instanceof Warden) {
            // Optional: only drop if killed by player
            DamageSource source = event.getSource();
            if (source.getEntity() instanceof Player) {
                ItemStack drop = new ItemStack(SDItems.SCULKED_DIAMOND_UPGRADE_TEMPLATE.get());
                ItemEntity itemEntity = new ItemEntity(
                        level,
                        entity.getX(),
                        entity.getY() + 0.5,
                        entity.getZ(),
                        drop
                );
                event.getDrops().add(itemEntity);
            }
        }
    }
}
