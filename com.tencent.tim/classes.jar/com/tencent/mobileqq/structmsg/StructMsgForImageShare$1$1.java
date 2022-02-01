package com.tencent.mobileqq.structmsg;

import anrt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kbp;
import ycd;

public class StructMsgForImageShare$1$1
  implements Runnable
{
  public StructMsgForImageShare$1$1(anrt paramanrt, StructMsgForImageShare paramStructMsgForImageShare, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (ycd.d(this.c.uin, this.val$app)) {}
    kbp.a(this.val$app, "CliOper", "", this.c.uin, "0X80055C7", "0X80055C7", 0, 0, Long.toString(l), Long.toString(this.c.msgId), this.c.mMsgAction, Integer.toString(this.c.mPromotionType), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare.1.1
 * JD-Core Version:    0.7.0.1
 */