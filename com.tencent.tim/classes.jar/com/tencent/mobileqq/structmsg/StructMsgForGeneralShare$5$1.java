package com.tencent.mobileqq.structmsg;

import anrl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kbp;
import ycd;

public class StructMsgForGeneralShare$5$1
  implements Runnable
{
  public StructMsgForGeneralShare$5$1(anrl paramanrl, StructMsgForGeneralShare paramStructMsgForGeneralShare, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (ycd.d(this.a.uin, this.val$app)) {}
    for (int i = 1;; i = 0)
    {
      kbp.a(this.val$app, "CliOper", "", this.a.uin, "0X80055C7", "0X80055C7", 0, 0, Long.toString(l), Long.toString(this.a.msgId), this.a.mMsgAction, Integer.toString(i), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5.1
 * JD-Core Version:    0.7.0.1
 */