package com.tencent.component.network.module.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.component.network.utils.thread.PriorityThreadPool;

final class c
  extends BroadcastReceiver
{
  c(b paramb) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
      PriorityThreadPool.getDefault().submit(new d(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.c
 * JD-Core Version:    0.7.0.1
 */