package com.tencent.mfsdk.config;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import java.util.concurrent.ConcurrentHashMap;

public class APMConfig
{
  public static ConcurrentHashMap<String, DefaultPluginConfig> sPluginToQapmPluginConfigMap = new ConcurrentHashMap();
  public ConcurrentHashMap<String, APMModuleConfig> modules = new ConcurrentHashMap(6);
  public boolean runDb;
  public boolean runIo;
  public boolean runVip = false;
  
  static
  {
    sPluginToQapmPluginConfigMap.put("looper", PluginCombination.loopStackPlugin);
    sPluginToQapmPluginConfigMap.put("resource", PluginCombination.resourcePlugin);
    sPluginToQapmPluginConfigMap.put("ceilinghprof", PluginCombination.ceilingHprofPlugin);
    sPluginToQapmPluginConfigMap.put("ceilingvalue", PluginCombination.ceilingValuePlugin);
    sPluginToQapmPluginConfigMap.put("leak", PluginCombination.leakPlugin);
    sPluginToQapmPluginConfigMap.put("dropframe", PluginCombination.dropFramePlugin);
    sPluginToQapmPluginConfigMap.put("battery", PluginCombination.batteryPlugin);
  }
  
  public APMModuleConfig getSampleConfig(String paramString)
  {
    return (APMModuleConfig)this.modules.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.config.APMConfig
 * JD-Core Version:    0.7.0.1
 */