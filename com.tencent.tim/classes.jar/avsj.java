import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import cooperation.qzone.util.QZLog;

public class avsj
{
  public static String TAG = "WatchActivityManager";
  public avsj.a a = new avsj.a(null);
  private Activity activity;
  private boolean mActivityStopped;
  private boolean mPressHomeKey;
  private boolean mPressMenuKey;
  private boolean mPressScreenOff;
  
  private void registKeyReceiver()
  {
    if (this.activity != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.activity.registerReceiver(this.a, localIntentFilter);
    }
  }
  
  private void resetKeyFlag()
  {
    this.mPressScreenOff = false;
    this.mPressHomeKey = false;
    this.mPressMenuKey = false;
    this.mActivityStopped = false;
  }
  
  private void unRegistKeyReceiver()
  {
    if (this.activity != null) {
      this.activity.unregisterReceiver(this.a);
    }
  }
  
  public boolean aLu()
  {
    QZLog.i(TAG, 4, "ljh, mActivityStopped = " + this.mActivityStopped + ", mPressScreenOff = " + this.mPressScreenOff + ", mPressMenuKey = " + this.mPressMenuKey + ", mPressHomeKey = " + this.mPressHomeKey);
    return (this.mActivityStopped) && (!this.mPressScreenOff) && (!this.mPressMenuKey) && (!this.mPressHomeKey);
  }
  
  public void b(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.mPressMenuKey = true;
  }
  
  public void onCreate(Activity paramActivity)
  {
    this.activity = paramActivity;
    registKeyReceiver();
  }
  
  public void onDestroy()
  {
    unRegistKeyReceiver();
  }
  
  public void onResume()
  {
    resetKeyFlag();
  }
  
  public void onStop()
  {
    this.mActivityStopped = true;
  }
  
  class a
    extends BroadcastReceiver
  {
    private String action;
    
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      this.action = paramIntent.getAction();
      if (!TextUtils.isEmpty(this.action))
      {
        if (!"android.intent.action.SCREEN_OFF".equals(this.action)) {
          break label40;
        }
        avsj.a(avsj.this, true);
      }
      label40:
      while (!this.action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
        return;
      }
      avsj.b(avsj.this, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsj
 * JD-Core Version:    0.7.0.1
 */