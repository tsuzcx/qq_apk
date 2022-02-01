package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.log.QMLog;

public class QMBonusBroadCast
  extends BaseBroadcastReceiver
{
  private static final String TAG = "QMBonusBroadCast";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = SafeIntent.createSafeIntet(paramIntent);
    Log.e("mason", "" + paramContext.getAction());
    QMLog.log(4, "QMBonusBroadCast", "onReceive call onLowMemory");
    QMApplicationContext.sharedInstance().onLowMemory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMBonusBroadCast
 * JD-Core Version:    0.7.0.1
 */