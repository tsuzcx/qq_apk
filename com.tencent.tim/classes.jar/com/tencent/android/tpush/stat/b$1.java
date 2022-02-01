package com.tencent.android.tpush.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

class b$1
  extends BroadcastReceiver
{
  b$1(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    CommonWorkingThread.getInstance().execute(new b.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.b.1
 * JD-Core Version:    0.7.0.1
 */