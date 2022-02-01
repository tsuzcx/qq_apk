import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;

public class aicf
  implements aibz
{
  private final String TAG = "shadow::PluginManagerWrapper";
  private IVPluginDataReporter a = new IVPluginDataReporter();
  private final DynamicPluginManager b;
  private final String bME;
  
  public aicf(String paramString, DynamicPluginManager paramDynamicPluginManager)
  {
    this.b = paramDynamicPluginManager;
    this.bME = paramString;
  }
  
  public void a(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    boolean bool = TextUtils.isEmpty(aice.a().wN());
    if (bool) {}
    for (String str = "idle";; str = "busy")
    {
      QLog.i("shadow::PluginManagerWrapper", 1, String.format("doPreLoad pps status is %s ", new Object[] { str }));
      if (bool) {
        enter(paramContext, paramLong, paramBundle, paramEnterCallback);
      }
      return;
    }
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("shadow::PluginManagerWrapper", 2, "enter formId:" + paramLong + " enterCallback:" + paramEnterCallback);
    }
    aice.a().a(this.bME, this.b);
    this.b.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
    if ("Now".equals(this.bME)) {}
    for (paramContext = "33669800";; paramContext = "33669805")
    {
      aids.report(paramContext);
      this.a.opDepartment("shadow").opName(this.bME).opType("enter").d1(paramLong + "").report();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicf
 * JD-Core Version:    0.7.0.1
 */