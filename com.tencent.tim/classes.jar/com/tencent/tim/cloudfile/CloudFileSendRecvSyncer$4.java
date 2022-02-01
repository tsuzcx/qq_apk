package com.tencent.tim.cloudfile;

import android.os.Handler;
import android.os.Looper;
import java.util.TimerTask;

class CloudFileSendRecvSyncer$4
  extends TimerTask
{
  CloudFileSendRecvSyncer$4(CloudFileSendRecvSyncer paramCloudFileSendRecvSyncer) {}
  
  public void run()
  {
    new Handler(Looper.getMainLooper()).post(new CloudFileSendRecvSyncer.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileSendRecvSyncer.4
 * JD-Core Version:    0.7.0.1
 */