import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

public class iig
{
  private iig.a a;
  private Object as;
  private Map<String, Integer> cO;
  private VideoAppInterface mApp;
  
  public iig(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  public void X(String paramString, int paramInt)
  {
    try
    {
      this.cO.put(paramString, Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void amw()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return;
      if (this.a != null) {
        if (QLog.isColorLevel()) {
          QLog.d("GCameraAvailabilityMonitor", 2, "UnRegister camera availability change receiver");
        }
      }
      try
      {
        this.mApp.getApplication().unregisterReceiver(this.a);
        this.a = null;
        if (QLog.isColorLevel()) {
          QLog.d("GCameraAvailabilityMonitor", 2, "UnRegister camera availability change callback");
        }
        if (this.as == null) {
          continue;
        }
        jjj.a(jjj.a(), this.as, "unRegisterAvailabilityCb", null, null);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("GCameraAvailabilityMonitor", 2, "regist e = " + localException);
          }
        }
      }
    }
  }
  
  public void amx()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    DexClassLoader localDexClassLoader;
    do
    {
      return;
      localDexClassLoader = jjj.a();
      if (this.cO == null) {
        this.cO = new HashMap();
      }
      if (this.a == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GCameraAvailabilityMonitor", 2, "register camera availability change receiver");
        }
        this.a = new iig.a();
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mobileqq.qav.camera.availability");
        this.mApp.getApplication().registerReceiver(this.a, (IntentFilter)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("GCameraAvailabilityMonitor", 2, "register camera availability change callback");
      }
    } while ((Build.VERSION.RELEASE.equalsIgnoreCase("7.1.2")) || (Build.MODEL.equalsIgnoreCase("vivo x9")));
    this.as = jjj.a(localDexClassLoader, "com.tencent.av.camera2.CameraManagerWrapper");
    Object localObject = this.as;
    Context localContext = this.mApp.getApplication().getApplicationContext();
    String str = this.mApp.getApplication().getPackageName();
    jjj.a(localDexClassLoader, localObject, "registerAvailabilityCb", new Class[] { Context.class, String.class, Handler.class }, new Object[] { localContext, str, null });
  }
  
  public Map<String, Integer> u()
  {
    try
    {
      Map localMap = this.cO;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((iig.this.u() != null) && (paramIntent != null))
      {
        long l = jlc.a(paramIntent);
        paramContext = paramIntent.getStringExtra("camera_id");
        int i = paramIntent.getIntExtra("availability", 1);
        iig.this.X(paramContext, i);
        if (QLog.isColorLevel()) {
          QLog.w("GCameraAvailabilityMonitor", 1, "CameraAvailabilityReceiver, id[" + paramContext + "], available[" + i + "], seq[" + l + "]");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iig
 * JD-Core Version:    0.7.0.1
 */