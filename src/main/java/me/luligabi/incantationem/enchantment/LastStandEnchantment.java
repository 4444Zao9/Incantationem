package me.luligabi.incantationem.enchantment;

import me.luligabi.incantationem.Util;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class LastStandEnchantment extends Enchantment {

    public LastStandEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }

    public int getMinPower(int level) { return 10 + 20 * (level - 1); }

    public int getMaxPower(int level) {
        return 50;
    }

    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (user.getHealth() < (level * 1.5)) {
            if (Util.randomNumber(user.getRandom(), 0, 10) < level * 1.25) {
                Util.applyEffectIfNotPresent(user, StatusEffects.STRENGTH, (int) Math.ceil(level * 2.5), 1);
                if (user instanceof PlayerEntity) { //TODO: Add config setting to show message.
                    ((PlayerEntity) user).sendMessage(new TranslatableText("message.incantationem.last_stand.applied").setStyle(Style.EMPTY.withColor(Formatting.GREEN)), true);
                }
            }
            super.onUserDamaged(user, attacker, level);
        }
    }
}