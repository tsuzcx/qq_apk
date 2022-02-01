package com.tencent.qapmsdk.base.config;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "", "plugin", "", "mode", "threshold", "maxReportNum", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "curReportNum", "(IIIIFILjava/lang/String;Ljava/lang/String;I)V", "toString", "AnrPlugin", "BatteryPlugin", "BreadCrumbPlugin", "CeilingHprofPlugin", "CeilingValuePlugin", "CrashPlugin", "DBPlugin", "DevicePlugin", "DropFramePlugin", "HttpPlugin", "IOPlugin", "JsErrorPlugin", "LeakPlugin", "LoopStackPlugin", "ResourcePlugin", "StatisticsPlugin", "WebViewPlugin", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$DropFramePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$LoopStackPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$DBPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$IOPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$LeakPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$CeilingHprofPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$CeilingValuePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$BatteryPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$DevicePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$ResourcePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$CrashPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$AnrPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$WebViewPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$HttpPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$JsErrorPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$BreadCrumbPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$StatisticsPlugin;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract class DefaultPluginConfig
{
  @JvmField
  public int curReportNum;
  @JvmField
  @NotNull
  public String entrance;
  @JvmField
  public float eventSampleRatio;
  @JvmField
  public int maxReportNum;
  @JvmField
  public final int mode;
  @JvmField
  public final int plugin;
  @JvmField
  @NotNull
  public String pluginName;
  @JvmField
  public int stackDepth;
  @JvmField
  public int threshold;
  
  private DefaultPluginConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, String paramString1, String paramString2, int paramInt6)
  {
    this.plugin = paramInt1;
    this.mode = paramInt2;
    this.threshold = paramInt3;
    this.maxReportNum = paramInt4;
    this.eventSampleRatio = paramFloat;
    this.stackDepth = paramInt5;
    this.pluginName = paramString1;
    this.entrance = paramString2;
    this.curReportNum = paramInt6;
  }
  
  @NotNull
  public String toString()
  {
    return "DefaultPluginConfig(plugin=" + this.plugin + ", mode=" + this.mode + ", threshold=" + this.threshold + ", maxReportNum=" + this.maxReportNum + ", eventSampleRatio=" + this.eventSampleRatio + ", stackDepth=" + this.stackDepth + ", pluginName='" + this.pluginName + "', entrance='" + this.entrance + "', curReportNum=" + this.curReportNum + ')';
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$AnrPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class AnrPlugin
    extends DefaultPluginConfig
  {
    public AnrPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public AnrPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$BatteryPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class BatteryPlugin
    extends DefaultPluginConfig
  {
    public BatteryPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public BatteryPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$BreadCrumbPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class BreadCrumbPlugin
    extends DefaultPluginConfig
  {
    public BreadCrumbPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public BreadCrumbPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$CeilingHprofPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class CeilingHprofPlugin
    extends DefaultPluginConfig
  {
    public CeilingHprofPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public CeilingHprofPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$CeilingValuePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class CeilingValuePlugin
    extends DefaultPluginConfig
  {
    public CeilingValuePlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public CeilingValuePlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$CrashPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class CrashPlugin
    extends DefaultPluginConfig
  {
    public CrashPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public CrashPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$DBPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class DBPlugin
    extends DefaultPluginConfig
  {
    public DBPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public DBPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$DevicePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class DevicePlugin
    extends DefaultPluginConfig
  {
    public DevicePlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public DevicePlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$DropFramePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class DropFramePlugin
    extends DefaultPluginConfig
  {
    public DropFramePlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public DropFramePlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$HttpPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class HttpPlugin
    extends DefaultPluginConfig
  {
    public HttpPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public HttpPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$IOPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class IOPlugin
    extends DefaultPluginConfig
  {
    public IOPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public IOPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$JsErrorPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class JsErrorPlugin
    extends DefaultPluginConfig
  {
    public JsErrorPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public JsErrorPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$LeakPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class LeakPlugin
    extends DefaultPluginConfig
  {
    public LeakPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public LeakPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$LoopStackPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class LoopStackPlugin
    extends DefaultPluginConfig
  {
    public LoopStackPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public LoopStackPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$ResourcePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "ResourceType", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class ResourcePlugin
    extends DefaultPluginConfig
  {
    public ResourcePlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public ResourcePlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$ResourcePlugin$ResourceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OPEN_RESOURCE", "OPEN_TAG", "OPEN_AUTO", "qapmbase_release"}, k=1, mv={1, 1, 15})
    public static enum ResourceType
    {
      private final int value;
      
      static
      {
        ResourceType localResourceType1 = new ResourceType("OPEN_RESOURCE", 0, 1);
        OPEN_RESOURCE = localResourceType1;
        ResourceType localResourceType2 = new ResourceType("OPEN_TAG", 1, 2);
        OPEN_TAG = localResourceType2;
        ResourceType localResourceType3 = new ResourceType("OPEN_AUTO", 2, 7);
        OPEN_AUTO = localResourceType3;
        $VALUES = new ResourceType[] { localResourceType1, localResourceType2, localResourceType3 };
      }
      
      private ResourceType(int paramInt)
      {
        this.value = paramInt;
      }
      
      public final int getValue()
      {
        return this.value;
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$StatisticsPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class StatisticsPlugin
    extends DefaultPluginConfig
  {
    public StatisticsPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public StatisticsPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$WebViewPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class WebViewPlugin
    extends DefaultPluginConfig
  {
    public WebViewPlugin()
    {
      this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    }
    
    public WebViewPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
    {
      super(paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.DefaultPluginConfig
 * JD-Core Version:    0.7.0.1
 */