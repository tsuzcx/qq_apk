package com.tencent.biz.qqstory.takevideo.rmw;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.support.annotation.Nullable;
import rlg;
import rli;

public class RMWService
  extends Service
{
  private static RMWService a;
  private Messenger mMessenger = new Messenger(new rli(this));
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    rlg.i("RMWService", "ON-BIND : " + System.identityHashCode(this) + " : " + paramIntent);
    return this.mMessenger.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    rlg.i("RMWService", "ON-CREATE : " + System.identityHashCode(this));
    a = this;
    new RMWService.2(this).start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    rlg.i("RMWService", "ON-DESTROY : " + System.identityHashCode(this));
    a = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    rlg.d("RMWService", "onStartCommand : " + paramIntent);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    rlg.i("RMWService", "ON-UNBIND : " + System.identityHashCode(this) + " : " + paramIntent);
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService
 * JD-Core Version:    0.7.0.1
 */