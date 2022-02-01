import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.config.APMModuleConfig;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.memory.leakdetect.LeakInspector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONException;

public class tyo
  extends txq
  implements Application.ActivityLifecycleCallbacks, txk
{
  static boolean aQK;
  static boolean aQL;
  IInspectorListener a = new tyn();
  public IMemoryDumpListener b = new typ(this);
  
  public static void bEY()
  {
    if ((new File(aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_02")).exists()) || (new File(aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_03")).exists()) || (10 == BaseApplicationImpl.sProcessId)) {}
    for (aQK = false; new File(aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_03")).exists(); aQK = true)
    {
      aQL = false;
      return;
    }
    aQL = true;
  }
  
  protected void a(APMModuleConfig paramAPMModuleConfig)
  {
    if (((2 == BaseApplicationImpl.sProcessId) || (8 == BaseApplicationImpl.sProcessId)) && (!LocalMultiProcConfig.getBool("Qzone_setApm_MemLeak", true))) {}
  }
  
  public DumpResult b(String paramString)
  {
    try
    {
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "dumpMemory " + paramString);
      paramString = LeakInspector.dumpMemory(paramString, true, this.b);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "", paramString);
    }
    return new DumpResult();
  }
  
  protected void bER()
  {
    MobileQQ.sMobileQQ.registerActivityLifecycleCallbacks(this);
    bEY();
    com.tencent.qapmsdk.memory.MemoryLeakMonitor.enableFragmentInspect = false;
    QAPM.setProperty(107, this.a);
  }
  
  public String oF()
  {
    return "leak";
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    try
    {
      tyc.bm(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "onActivityDestroyed ", paramActivity);
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void report(long paramLong, String paramString)
  {
    try
    {
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "dumpMemory " + paramString);
      LeakInspector.report(paramLong, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void startInspect(Object paramObject, String paramString)
  {
    if (isStarted())
    {
      LeakInspector.startInspect(paramObject, paramString);
      return;
    }
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "startInspect failedNoStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tyo
 * JD-Core Version:    0.7.0.1
 */