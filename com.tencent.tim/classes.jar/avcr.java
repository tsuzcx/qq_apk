import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipProxyPreLoadComicProcess;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;

public class avcr
  extends avcn
{
  public final avcm.a a;
  private String cJh = "";
  private boolean dmu;
  private int ewE = 0;
  
  avcr(int paramInt)
  {
    this.mProcessName = "com.tencent.mobileqq:tool";
    this.dmf = true;
    this.mPluginID = "comic_plugin.apk";
    this.cdu = 2;
    this.cJf = "comic_plugin.apk";
    this.dmg = true;
    this.ewp = paramInt;
    this.a = new avcm.a(this.cdu, this.ewp);
    if (paramInt == 6) {
      this.a.a = new ahyh("comic_leba_preload", this.mProcessName, this.mPluginID);
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        this.a.a = new ahyh("comic_activity_preload", this.mProcessName, this.mPluginID);
        return;
      }
    } while (paramInt != 9999);
    this.a.a = new ahyh("comic_web_preload", this.mProcessName, this.mPluginID);
  }
  
  private String Fx()
  {
    return this.cJh;
  }
  
  public void a(avco.a parama)
  {
    if (parama == null) {
      return;
    }
    this.ewE = parama.ewq;
    this.cJh = parama.cJg;
  }
  
  protected boolean a(avco.a parama)
  {
    Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|24|0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 4) {}
    }
    for (boolean bool = "1".equals(localObject[2]);; bool = false)
    {
      if (parama != null)
      {
        parama.ewq = 2;
        if (!bool) {
          break label132;
        }
      }
      label132:
      for (localObject = "preload:ok:dpc";; localObject = "preload:fail:dpc")
      {
        parama.cJg = ((String)localObject);
        parama = (avcq)BaseApplicationImpl.getApplication().getRuntime().getManager(142);
        if (parama != null)
        {
          parama.ezt();
          if (parama.f.get() != null)
          {
            this.ewr = ((avcn.c)parama.f.get()).ewC;
            this.dmu = ((avcn.c)parama.f.get()).dms;
          }
        }
        return bool;
      }
    }
  }
  
  protected void aBp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload start");
    }
    if (!QIPCServerHelper.getInstance().isModuleRunning(this.cJf)) {
      VasWebviewUtil.reportVasStatus("qqcomic", "launch_plugin_action", "0", 0, 201);
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), VipProxyPreLoadComicProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("isPreloadProcess", true);
    localIntent.putExtra("preloadEntry", this.ewp);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    avea.a(BaseApplicationImpl.getApplication().getRuntime(), 1, 1, 0L);
    aveb.ei(localIntent);
    if ((aqqj.aB() instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)aqqj.aB());
    }
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "comic_plugin.apk";
    locald.mPluginName = "comic_plugin";
    locald.mUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    locald.cKu = "com.qqcomic.app.VipPreloadComicProcess";
    this.a.ad(this.ewE, Fx(), this.mStrategyId);
    locald.a = this.a.a;
    locald.mIntent = localIntent;
    avfw.b(BaseApplicationImpl.getContext(), locald);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload end");
    }
  }
  
  protected boolean b(avco.a parama)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parama == null) {
      parama = new avco.a();
    }
    for (;;)
    {
      avcq localavcq = (avcq)BaseApplicationImpl.getApplication().getRuntime().getManager(142);
      int i;
      if (localavcq != null) {
        if ((localavcq.f.get() != null) && (((avcn.c)localavcq.f.get()).aqY))
        {
          i = 1;
          if (this.ewp != 5) {
            break label218;
          }
          if ((i != 0) && (localavcq.cq.get() != -1)) {
            break label164;
          }
          parama.ewq = 1;
          parama.cJg = "preload:ok:publicaccount";
          label105:
          bool2 = bool1;
          if (localavcq.g.get() != null) {
            this.mStrategyId = ((avcn.b)localavcq.g.get()).ewt;
          }
        }
      }
      for (bool2 = bool1;; bool2 = false)
      {
        this.ewE = parama.ewq;
        this.cJh = parama.cJg;
        return bool2;
        i = 0;
        break;
        label164:
        if (localavcq.cq.get() == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          if (!bool1) {
            break label203;
          }
          parama.ewq = 2;
          parama.cJg = "preload:ok:publicaccount";
          break;
        }
        label203:
        parama.ewq = 2;
        parama.cJg = "preload:fail:publicaccount";
        break label105;
        label218:
        if (this.ewp == 6)
        {
          if ((i != 0) && (localavcq.g.get() != null))
          {
            bool1 = a((avcn.b)localavcq.g.get(), String.valueOf(1113), localavcq.mApp, "com.android.animation", localavcq.PB(), localavcq.iL(), localavcq.ak(), parama);
            break label105;
          }
          parama.ewq = 1;
          parama.cJg = "preload:fail:normal";
          bool1 = false;
          break label105;
        }
        if (this.ewp == 9999)
        {
          parama.ewq = 1;
          parama.cJg = "preload:ok:web";
          break label105;
        }
        parama.ewq = 1;
        parama.cJg = "preload:fail:unknownentry";
        bool1 = false;
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcr
 * JD-Core Version:    0.7.0.1
 */