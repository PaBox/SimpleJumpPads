package io.github._4drian3d.simplejumppads.configuration;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Comment;

@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal", "CanBeFinal"})
@ConfigSerializable
public class Configuration {
    @Comment("Configure which types of JumpPads you want to use")
    private Section[] sections = { new Section() };

    public Section[] getSections() {
        return sections;
    }

    @ConfigSerializable
    public static class Section {
        @Comment("Sets the name of this JumpPad")
        private String name = "default";

        @Comment("Sets the material of this JumpPad")
        private Material material = Material.HEAVY_WEIGHTED_PRESSURE_PLATE;

        @Comment("Sets the dimension of this PumpPad")
        private World world = null;

        @Comment("Sets the X location of this PumpPad")
        private double locationX = Double.NaN;

        @Comment("Sets the Y location of this JumpPad")
        private double locationY = Double.NaN;

        @Comment("Sets the Z location of this JumpPad")
        private double locationZ = Double.NaN;

        @Comment("Sets the player rotation of this PumpPad")
        private double fixRotation = Double.NaN;

        @Comment("Sets the player launch angle of this JumpPad")
        private double fixAngle = Double.NaN;

        @Comment("Sets the horizontal multiplier of this PumpPad")
        private double multiplyX = 1.0;

        @Comment("Sets the vertical multiplier of this JumpPad")
        private double multiplyY = 1.0;

        @Comment("Enable sound when using this JumpPad")
        private boolean enableSound = true;

        @Comment("Enables particles to be displayed when using this JumpPad")
        private boolean enableParticle = false;

        @Comment("Sets what sound will be played when using this JumpPad if sounds are enabled")
        private Sound sound = Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.PLAYER, 1, 1);

        @Comment("Sets which particle will be displayed when using this JumpPad if particles are enabled")
        private Particle particle = Particle.CLOUD;

        public Material getMaterial() {
            return material;
        }

        public Location getLocation() {
            return new Location(world, locationX, locationY, locationZ);
        }

        public double getFixRotation() {
            return fixRotation;
        }

        public double getFixAngle() {
            return fixAngle;
        }

        public double getMultiplyX() {
            return multiplyX;
        }

        public double getMultiplyY() {
            return multiplyY;
        }

        public boolean isEnableParticle() {
            return enableParticle;
        }

        public boolean isEnableSound() {
            return enableSound;
        }

        public Particle getParticle() {
            return particle;
        }

        public Sound getSound() {
            return sound;
        }

        @Override
        public boolean equals(final Object o) {
            if (!(o instanceof final Section section)) {
                return false;
            }
            return section.material == this.material;
        }
    }
}
