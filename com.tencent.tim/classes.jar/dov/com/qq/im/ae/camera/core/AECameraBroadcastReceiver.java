package dov.com.qq.im.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import awtq;

public class AECameraBroadcastReceiver
  extends BroadcastReceiver
{
  private awtq b;
  
  public AECameraBroadcastReceiver(awtq paramawtq)
  {
    this.b = paramawtq;
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
    paramActivity.registerReceiver(this, b());
  }
  
  public void cP(Activity paramActivity)
  {
    paramActivity.unregisterReceiver(this);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.b.getActivity();
    if ((paramContext == null) || (paramContext.isFinishing())) {}
    while (!"new_qq_android_native_ptu_res_".equals(paramIntent.getAction())) {
      return;
    }
    angh.cFq = true;
    this.b.eGe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */