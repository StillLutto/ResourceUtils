package me.lutto.resourceutils.listeners;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEventListener;
import net.minecraft.client.sounds.WeighedSoundEvents;

public class SoundListener implements SoundEventListener {

    @Override
    public void onPlaySound(SoundInstance soundInstance, WeighedSoundEvents weighedSoundEvents, float f) {
        System.out.println(soundInstance);
    }

}
