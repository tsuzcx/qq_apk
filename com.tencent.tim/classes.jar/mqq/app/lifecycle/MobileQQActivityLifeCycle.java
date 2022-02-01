package mqq.app.lifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public final class MobileQQActivityLifeCycle
  implements Application.ActivityLifecycleCallbacks, Handler.Callback
{
  private static final int DELAY_BROADCAST = 100;
  private static final int MSG_BACK = 0;
  private static final int MSG_FORE = 1;
  public static final String TAG = "MobileQQLife";
  private Context mContext;
  public int mCountActivity;
  public int mCountResume;
  private Handler mHandler;
  private String mProcessName;
  
  public MobileQQActivityLifeCycle(Context paramContext, Looper paramLooper, String paramString)
  {
    this.mProcessName = paramString;
    this.mContext = paramContext;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l = paramMessage.arg1 << 32 | paramMessage.arg2 & 0xFFFFFFFF;
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, paramMessage.what + ", " + this.mProcessName + ", " + l + ", " + this.mCountActivity);
    }
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      if (this.mCountActivity > 0) {
        MsfServiceSdk.get().onProcessViewableChanged(true, l);
      }
    } while (this.mCountActivity != 0);
    MsfServiceSdk.get().onProcessViewableChanged(false, l);
    return true;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    this.mCountResume -= 1;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    this.mCountResume += 1;
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.mCountActivity += 1;
    if ((this.mCountActivity == 1) || (this.mCountActivity == 2))
    {
      long l = SystemClock.uptimeMillis();
      paramActivity = this.mHandler.obtainMessage(1, (int)(l >>> 32), (int)(l & 0xFFFFFFFF));
      this.mHandler.sendMessageDelayed(paramActivity, 100L);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = this.mCountActivity - 1;
    this.mCountActivity = i;
    if (i == 0)
    {
      long l = SystemClock.uptimeMillis();
      paramActivity = this.mHandler.obtainMessage(0, (int)(l >>> 32), (int)(l & 0xFFFFFFFF));
      this.mHandler.sendMessageDelayed(paramActivity, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.lifecycle.MobileQQActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */