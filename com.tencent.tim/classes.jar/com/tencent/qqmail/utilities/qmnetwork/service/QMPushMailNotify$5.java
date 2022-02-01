package com.tencent.qqmail.utilities.qmnetwork.service;

import java.util.Comparator;

class QMPushMailNotify$5
  implements Comparator<PushMailBody>
{
  QMPushMailNotify$5(QMPushMailNotify paramQMPushMailNotify) {}
  
  public int compare(PushMailBody paramPushMailBody1, PushMailBody paramPushMailBody2)
  {
    if (paramPushMailBody2.fromtime > paramPushMailBody1.fromtime) {
      return 1;
    }
    if (paramPushMailBody2.fromtime < paramPushMailBody1.fromtime) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify.5
 * JD-Core Version:    0.7.0.1
 */