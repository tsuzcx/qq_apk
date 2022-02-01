package com.tencent.qapmsdk.base.config;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/PluginCombination;", "", "()V", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class PluginCombination
{
  public static final Companion Companion = new Companion(null);
  @JvmField
  @NotNull
  public static final DefaultPluginConfig anrPlugin;
  private static final List<DefaultPluginConfig> austerityPlugins = CollectionsKt.listOf(new DefaultPluginConfig[] { dropFramePlugin, dbPlugin, ioPlugin, leakPlugin, ceilingHprofPlugin, ceilingValuePlugin, batteryPlugin, devicePlugin, anrPlugin, crashPlugin, statisticsPlugin });
  @JvmField
  @NotNull
  public static final DefaultPluginConfig batteryPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig ceilingHprofPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig ceilingValuePlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig crashPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig dbPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig devicePlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig dropFramePlugin = (DefaultPluginConfig)new DefaultPluginConfig.DropFramePlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
  @JvmField
  @NotNull
  public static final DefaultPluginConfig httpPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig ioPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig jsErrorPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig leakPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig loopStackPlugin = (DefaultPluginConfig)new DefaultPluginConfig.LoopStackPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
  @NotNull
  private static final List<DefaultPluginConfig> loosePlugins = CollectionsKt.listOf(new DefaultPluginConfig[] { loopStackPlugin, resourcePlugin, webViewPlugin, httpPlugin, jsErrorPlugin, userBreadCrumbPlugin, batteryPlugin });
  @NotNull
  private static final Lazy modeAll$delegate;
  @NotNull
  private static final Lazy modeStable$delegate;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig resourcePlugin;
  private static final List<DefaultPluginConfig> stablePlugins;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig statisticsPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig userBreadCrumbPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig webViewPlugin;
  
  static
  {
    dbPlugin = (DefaultPluginConfig)new DefaultPluginConfig.DBPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    ioPlugin = (DefaultPluginConfig)new DefaultPluginConfig.IOPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    leakPlugin = (DefaultPluginConfig)new DefaultPluginConfig.LeakPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    ceilingHprofPlugin = (DefaultPluginConfig)new DefaultPluginConfig.CeilingHprofPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    ceilingValuePlugin = (DefaultPluginConfig)new DefaultPluginConfig.CeilingValuePlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    batteryPlugin = (DefaultPluginConfig)new DefaultPluginConfig.BatteryPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    devicePlugin = (DefaultPluginConfig)new DefaultPluginConfig.DevicePlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    resourcePlugin = (DefaultPluginConfig)new DefaultPluginConfig.ResourcePlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    crashPlugin = (DefaultPluginConfig)new DefaultPluginConfig.CrashPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    anrPlugin = (DefaultPluginConfig)new DefaultPluginConfig.AnrPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    webViewPlugin = (DefaultPluginConfig)new DefaultPluginConfig.WebViewPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    httpPlugin = (DefaultPluginConfig)new DefaultPluginConfig.HttpPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    jsErrorPlugin = (DefaultPluginConfig)new DefaultPluginConfig.JsErrorPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    userBreadCrumbPlugin = (DefaultPluginConfig)new DefaultPluginConfig.BreadCrumbPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    statisticsPlugin = (DefaultPluginConfig)new DefaultPluginConfig.StatisticsPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    modeAll$delegate = LazyKt.lazy((Function0)PluginCombination.Companion.modeAll.2.INSTANCE);
    modeStable$delegate = LazyKt.lazy((Function0)PluginCombination.Companion.modeStable.2.INSTANCE);
    stablePlugins = CollectionsKt.listOf(new DefaultPluginConfig[] { loopStackPlugin, resourcePlugin, dropFramePlugin, userBreadCrumbPlugin });
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/PluginCombination$Companion;", "", "()V", "anrPlugin", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "austerityPlugins", "", "batteryPlugin", "ceilingHprofPlugin", "ceilingValuePlugin", "crashPlugin", "dbPlugin", "devicePlugin", "dropFramePlugin", "httpPlugin", "ioPlugin", "jsErrorPlugin", "leakPlugin", "loopStackPlugin", "loosePlugins", "getLoosePlugins$qapmbase_release", "()Ljava/util/List;", "modeAll", "", "getModeAll", "()I", "modeAll$delegate", "Lkotlin/Lazy;", "modeStable", "getModeStable", "modeStable$delegate", "resourcePlugin", "stablePlugins", "statisticsPlugin", "userBreadCrumbPlugin", "webViewPlugin", "each", "block", "Lkotlin/Function1;", "handle", "plugin", "isAusterityPlugin", "", "isLoosePlugin", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @Nullable
    public final Object each(@NotNull Function1<? super DefaultPluginConfig, ? extends Object> paramFunction1)
    {
      Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
      Object localObject = null;
      Iterator localIterator1 = ((Iterable)CollectionsKt.listOf(new List[] { PluginCombination.access$getAusterityPlugins$cp(), ((Companion)this).getLoosePlugins$qapmbase_release() })).iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((Iterable)localIterator1.next()).iterator();
        while (localIterator2.hasNext()) {
          localObject = paramFunction1.invoke((DefaultPluginConfig)localIterator2.next());
        }
      }
      return localObject;
    }
    
    @NotNull
    public final List<DefaultPluginConfig> getLoosePlugins$qapmbase_release()
    {
      return PluginCombination.access$getLoosePlugins$cp();
    }
    
    public final int getModeAll()
    {
      Lazy localLazy = PluginCombination.access$getModeAll$cp();
      Object localObject = PluginCombination.Companion;
      localObject = $$delegatedProperties[0];
      return ((Number)localLazy.getValue()).intValue();
    }
    
    public final int getModeStable()
    {
      Lazy localLazy = PluginCombination.access$getModeStable$cp();
      Object localObject = PluginCombination.Companion;
      localObject = $$delegatedProperties[1];
      return ((Number)localLazy.getValue()).intValue();
    }
    
    @Nullable
    public final Object handle(int paramInt, @NotNull Function1<? super DefaultPluginConfig, ? extends Object> paramFunction1)
    {
      Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
      Iterator localIterator1 = ((Iterable)CollectionsKt.listOf(new List[] { PluginCombination.access$getAusterityPlugins$cp(), ((Companion)this).getLoosePlugins$qapmbase_release() })).iterator();
      Object localObject1 = null;
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((Iterable)localIterator1.next()).iterator();
        label72:
        Object localObject2;
        int i;
        if (localIterator2.hasNext())
        {
          localObject2 = localIterator2.next();
          if (((DefaultPluginConfig)localObject2).plugin == paramInt)
          {
            i = 1;
            label105:
            if (i == 0) {
              break label137;
            }
            label109:
            localObject2 = (DefaultPluginConfig)localObject2;
            if (localObject2 == null) {
              break label145;
            }
            localObject1 = paramFunction1.invoke(localObject2);
          }
        }
        label137:
        label145:
        for (;;)
        {
          break;
          i = 0;
          break label105;
          break label72;
          localObject2 = null;
          break label109;
        }
      }
      return localObject1;
    }
    
    public final boolean isAusterityPlugin(int paramInt)
    {
      Object localObject = (Iterable)PluginCombination.access$getAusterityPlugins$cp();
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
        return false;
      }
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        if (((DefaultPluginConfig)((Iterator)localObject).next()).plugin == paramInt) {}
        for (int i = 1; i != 0; i = 0) {
          return true;
        }
      }
      return false;
    }
    
    public final boolean isLoosePlugin(int paramInt)
    {
      Object localObject = (Iterable)((Companion)this).getLoosePlugins$qapmbase_release();
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
        return false;
      }
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        if (((DefaultPluginConfig)((Iterator)localObject).next()).plugin == paramInt) {}
        for (int i = 1; i != 0; i = 0) {
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.PluginCombination
 * JD-Core Version:    0.7.0.1
 */