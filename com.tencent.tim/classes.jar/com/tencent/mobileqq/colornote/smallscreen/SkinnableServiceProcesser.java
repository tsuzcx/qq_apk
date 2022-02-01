package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;

public class SkinnableServiceProcesser
  extends BroadcastReceiver
{
  private final a a;
  private final Service mService;
  
  public SkinnableServiceProcesser(Service paramService, a parama)
  {
    this.mService = paramService;
    this.a = parama;
    try
    {
      this.mService.registerReceiver(this, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.tim.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception paramService) {}
  }
  
  public void destory()
  {
    try
    {
      this.mService.unregisterReceiver(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {
      return;
    }
    QLog.d("SkinEngine", 1, "SkinnableActivityProcesser on pre theme changed");
    if (this.a != null) {
      this.a.onPostThemeChanged();
    }
    QLog.d("SkinEngine", 1, "SkinnableActivityProcesser on post theme changed");
  }
  
  public static abstract interface a
  {
    public abstract void onPostThemeChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.SkinnableServiceProcesser
 * JD-Core Version:    0.7.0.1
 */