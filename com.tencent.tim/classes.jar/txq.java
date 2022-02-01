import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.config.APMConfig;
import com.tencent.mfsdk.config.APMModuleConfig;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public abstract class txq
  implements txg
{
  private Boolean S;
  APMModuleConfig a = null;
  private volatile boolean mStarted;
  
  private DefaultPluginConfig a()
  {
    return (DefaultPluginConfig)APMConfig.sPluginToQapmPluginConfigMap.get(oF());
  }
  
  public boolean Ot()
  {
    if (this.S == null) {
      this.S = Boolean.valueOf(Ow());
    }
    return this.S.booleanValue();
  }
  
  protected boolean Ow()
  {
    return b().canOpenPlugin();
  }
  
  protected APMModuleConfig a()
  {
    APMModuleConfig localAPMModuleConfig = new APMModuleConfig();
    localAPMModuleConfig.userRatio = 0.0F;
    localAPMModuleConfig.evenRatio = 0.0F;
    localAPMModuleConfig.threshold = 100;
    localAPMModuleConfig.maxReport = 0;
    return localAPMModuleConfig;
  }
  
  protected void a(APMModuleConfig paramAPMModuleConfig) {}
  
  public APMModuleConfig b()
  {
    if (this.a == null)
    {
      APMConfig localAPMConfig = MagnifierSDK.a().a();
      this.a = localAPMConfig.getSampleConfig(oF());
      if (this.a == null) {
        this.a = a();
      }
      if ((localAPMConfig.runVip) && (UnifiedMonitor.ayG()) && ((!QLog.isColorLevel()) || (!"dropframe".equals(oF())))) {
        break label125;
      }
    }
    for (;;)
    {
      a(this.a);
      QLog.i("MagnifierSDK.QAPM", 1, "getMyConfig " + oF() + " " + this.a);
      return this.a;
      label125:
      this.a.evenRatio = 1.0F;
      this.a.threshold = a().threshold;
      this.a.userRatio = 1.0F;
      this.a.maxReport = 2147483647;
      this.a.stackDepth = 6;
    }
  }
  
  protected abstract void bER();
  
  public boolean isStarted()
  {
    return this.mStarted;
  }
  
  public abstract String oF();
  
  protected void onAfterStart() {}
  
  public final boolean start()
  {
    boolean bool = Ot();
    QLog.i("MagnifierSDK.QAPM", 1, "lifecycle " + oF() + " canStart " + bool);
    if (bool)
    {
      txr.bES();
      DefaultPluginConfig localDefaultPluginConfig = a();
      bER();
      APMModuleConfig localAPMModuleConfig = b();
      localDefaultPluginConfig.eventSampleRatio = localAPMModuleConfig.evenRatio;
      localDefaultPluginConfig.threshold = localAPMModuleConfig.threshold;
      localDefaultPluginConfig.maxReportNum = localAPMModuleConfig.maxReport;
      localDefaultPluginConfig.stackDepth = localAPMModuleConfig.stackDepth;
      QAPM.beginScene("SCENE_ALL", localDefaultPluginConfig.mode);
      this.mStarted = true;
      onAfterStart();
    }
    return this.mStarted;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     txq
 * JD-Core Version:    0.7.0.1
 */