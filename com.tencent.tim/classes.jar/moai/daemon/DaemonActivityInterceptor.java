package moai.daemon;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import moai.daemon.utils.DeviceUtils;
import moai.daemon.utils.Log;

public class DaemonActivityInterceptor
{
  private static final String TAG = "DaemonActivityInterceptor";
  private static IDaemonActivityInterceptor sInterceptor = new Interceptor(null);
  
  static boolean canDaemonActivityStart()
  {
    return sInterceptor.onPermit();
  }
  
  static void onDaemonActivityCreate(Activity paramActivity)
  {
    sInterceptor.onCreate(paramActivity);
  }
  
  static void onDaemonActivityDestroy(long paramLong)
  {
    sInterceptor.onDestroy(paramLong);
  }
  
  static void setDaemonActivityInterceptor(IDaemonActivityInterceptor paramIDaemonActivityInterceptor)
  {
    sInterceptor = new Interceptor(paramIDaemonActivityInterceptor);
  }
  
  public static abstract interface IDaemonActivityInterceptor
  {
    public abstract void onCreate(Activity paramActivity);
    
    public abstract void onDestroy(long paramLong);
    
    public abstract boolean onPermit();
  }
  
  static class Interceptor
    implements DaemonActivityInterceptor.IDaemonActivityInterceptor
  {
    private DaemonActivityInterceptor.IDaemonActivityInterceptor mInterceptor;
    
    Interceptor(DaemonActivityInterceptor.IDaemonActivityInterceptor paramIDaemonActivityInterceptor)
    {
      this.mInterceptor = paramIDaemonActivityInterceptor;
    }
    
    public void onCreate(Activity paramActivity)
    {
      if (this.mInterceptor != null) {
        this.mInterceptor.onCreate(paramActivity);
      }
    }
    
    public void onDestroy(long paramLong)
    {
      if (this.mInterceptor != null) {
        this.mInterceptor.onDestroy(paramLong);
      }
    }
    
    public boolean onPermit()
    {
      Context localContext = DaemonManager.getContext();
      if (localContext == null)
      {
        Log.w("DaemonActivityInterceptor", "cannot start DaemonActiviy due to no context");
        return false;
      }
      if (DeviceUtils.isScreenOn())
      {
        Log.w("DaemonActivityInterceptor", "screen is on, do not start DaemonActivity");
        return false;
      }
      if (DeviceUtils.isInstalled("com.sec.enterprise.knox.cloudmdm.smdms.agent.myknox"))
      {
        Log.w("DaemonActivityInterceptor", "Samsung Myknox is installed, do not start DaemonActivity");
        return false;
      }
      int i = ((TelephonyManager)localContext.getSystemService("phone")).getCallState();
      if (i != 0)
      {
        Log.w("DaemonActivityInterceptor", "do not start DaemonActivity when calling: " + i);
        return false;
      }
      if ((this.mInterceptor == null) || (this.mInterceptor.onPermit())) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.daemon.DaemonActivityInterceptor
 * JD-Core Version:    0.7.0.1
 */