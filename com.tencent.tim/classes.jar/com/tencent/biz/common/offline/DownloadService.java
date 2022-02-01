package com.tencent.biz.common.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import jqi;

public class DownloadService
  extends BroadcastReceiver
{
  Messenger mClient = null;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (jqi.getNetworkType(paramContext) == 1) {
      BidDownloader.resumeDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.DownloadService
 * JD-Core Version:    0.7.0.1
 */