package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.observer.QMNotification;

public class QMMediaBroadCast
  extends BaseBroadcastReceiver
{
  public static final String EX_STORAGE_STATE_MOUNTED = "mounted";
  public static final String EX_STORAGE_STATE_NOTIF = "external_storage_state_notification";
  public static final String EX_STORAGE_STATE_UNMOUNTED = "unmounted";
  private static final String TAG = "tower";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = SafeIntent.createSafeIntet(paramIntent).getAction();
    if ("android.intent.action.MEDIA_MOUNTED".equals(paramContext)) {
      QMNotification.postNotification("external_storage_state_notification", "mounted");
    }
    while (!"android.intent.action.MEDIA_UNMOUNTED".equals(paramContext)) {
      return;
    }
    QMNotification.postNotification("external_storage_state_notification", "unmounted");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMMediaBroadCast
 * JD-Core Version:    0.7.0.1
 */