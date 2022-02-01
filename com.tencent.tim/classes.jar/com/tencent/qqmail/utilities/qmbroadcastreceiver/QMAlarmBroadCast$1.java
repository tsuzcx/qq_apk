package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import com.tencent.qqmail.utilities.sharedpreference.SPManager.OnChangedListener;

final class QMAlarmBroadCast$1
  implements SPManager.OnChangedListener
{
  public void onChanged(String paramString)
  {
    QMAlarmBroadCast.access$000();
    QMAlarmBroadCast.register();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMAlarmBroadCast.1
 * JD-Core Version:    0.7.0.1
 */