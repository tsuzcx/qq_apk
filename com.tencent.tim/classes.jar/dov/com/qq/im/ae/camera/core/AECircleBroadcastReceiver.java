package dov.com.qq.im.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import axiy;

public class AECircleBroadcastReceiver
  extends BroadcastReceiver
{
  private a a;
  private boolean dtg;
  
  public AECircleBroadcastReceiver(a parama)
  {
    this.a = parama;
  }
  
  private IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("new_qq_android_native_short_filter_");
    localIntentFilter.addAction("new_qq_android_native_ptu_res_");
    return localIntentFilter;
  }
  
  public void cO(Activity paramActivity)
  {
    if (!this.dtg)
    {
      paramActivity.registerReceiver(this, b());
      this.dtg = true;
    }
  }
  
  public void cP(Activity paramActivity)
  {
    if (this.dtg)
    {
      paramActivity.unregisterReceiver(this);
      this.dtg = false;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("ae_camera_res_downloadfinish_path");
    if (("new_qq_android_native_short_filter_".equals(paramContext)) && (this.a != null))
    {
      this.a.qr(paramIntent);
      axiy.d("AECircleBroadcastReceiver", "[onReceive]");
    }
  }
  
  public static abstract interface a
  {
    public abstract void qr(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */