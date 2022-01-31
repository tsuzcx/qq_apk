package com.tencent.tmassistantsdk.downloadservice;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class m
  extends Handler
{
  private WeakReference a;
  
  public m(NetworkMonitorReceiver paramNetworkMonitorReceiver)
  {
    this.a = new WeakReference(paramNetworkMonitorReceiver);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    NetworkMonitorReceiver localNetworkMonitorReceiver = (NetworkMonitorReceiver)this.a.get();
    if ((paramMessage.what == 67) && (localNetworkMonitorReceiver != null)) {
      localNetworkMonitorReceiver.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.m
 * JD-Core Version:    0.7.0.1
 */