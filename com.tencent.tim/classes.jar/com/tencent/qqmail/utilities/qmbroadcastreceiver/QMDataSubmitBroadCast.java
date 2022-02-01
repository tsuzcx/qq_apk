package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.osslog.QMOssClient;

public class QMDataSubmitBroadCast
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d("donald data", "submit");
    DataCollector.submit();
    QMOssClient.getInstance().submit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMDataSubmitBroadCast
 * JD-Core Version:    0.7.0.1
 */