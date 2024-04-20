package com.gensokyo.nucleardelight.datagenerator;

import com.gensokyo.nucleardelight.NuclearDelight;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {
    @SubscribeEvent
    public static void dataGen(GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        List<Item> items = NuclearDelight.RegisteredItems.stream().map(RegistryObject::get).toList();
        event.getGenerator().addProvider(true, new SingleTextureItemModelGenerator(items, packOutput, existingFileHelper));
    }
}
