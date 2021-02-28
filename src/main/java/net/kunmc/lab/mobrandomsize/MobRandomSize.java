package net.kunmc.lab.mobrandomsize;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.teamfruit.gulliver.GulliverCommands;
import net.teamfruit.gulliver.GulliverConfig;
import org.apache.commons.lang3.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MobRandomSize.MODID)
public class MobRandomSize {
    public static final String MODID = "mobrandomsize";
    public static final String NAME = "Mob Random Size";
    public static final Logger LOGGER = LogManager.getLogger(NAME);

    private GulliverCommands commands = new GulliverCommands();

    public MobRandomSize() {
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::preInit);
    }

    public void preInit(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerFall(LivingSpawnEvent.SpecialSpawn event) {
        float x = RandomUtils.nextFloat(0f, 1f);
        float f = x == 0 ? 0 : (float) Math.pow(2, 10 * x - 10);
        float g = f * (10f - .3f) + .3f;
        commands.changeSize(event.getEntityLiving(), g);
    }
}
