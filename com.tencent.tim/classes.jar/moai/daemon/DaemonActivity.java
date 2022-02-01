package moai.daemon;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.ref.WeakReference;
import moai.daemon.utils.Log;

public class DaemonActivity
  extends Activity
{
  private static final String TAG = "DaemonActivity";
  public static WeakReference<DaemonActivity> instance;
  private long mBegin = SystemClock.elapsedRealtime();
  private String mHashCode = Integer.toHexString(hashCode());
  
  public void finish()
  {
    Log.i("DaemonActivity", "finish@" + this.mHashCode);
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("DaemonActivity", "onCreate@" + this.mHashCode);
    super.onCreate(paramBundle);
    DaemonActivityInterceptor.onDaemonActivityCreate(this);
    instance = new WeakReference(this);
    paramBundle = getWindow();
    paramBundle.setGravity(51);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    localLayoutParams.width = 1;
    localLayoutParams.height = 1;
    paramBundle.setAttributes(localLayoutParams);
  }
  
  protected void onDestroy()
  {
    long l = SystemClock.elapsedRealtime() - this.mBegin;
    Log.i("DaemonActivity", "onDestroy@" + this.mHashCode + ", exist: " + l + "ms");
    DaemonActivityInterceptor.onDaemonActivityDestroy(l);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    Log.i("DaemonActivity", "onResume@" + this.mHashCode);
    super.onResume();
  }
  
  protected void onStop()
  {
    Log.i("DaemonActivity", "onStop@" + this.mHashCode);
    super.onStop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Log.i("DaemonActivity", "onTouchEvent@" + this.mHashCode);
    finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.daemon.DaemonActivity
 * JD-Core Version:    0.7.0.1
 */