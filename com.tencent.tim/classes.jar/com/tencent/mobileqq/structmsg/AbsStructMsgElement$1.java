package com.tencent.mobileqq.structmsg;

import android.text.TextUtils;
import anqu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kbp;
import ycd;

public class AbsStructMsgElement$1
  implements Runnable
{
  public AbsStructMsgElement$1(anqu paramanqu1, anqu paramanqu2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(this.a.chH)) {}
    try
    {
      i = Integer.parseInt(this.this$0.chH);
      if (ycd.d(this.a.uin, this.val$app))
      {
        j = 1;
        kbp.a(this.val$app, "CliOper", "", this.a.uin, "0X80055C7", "0X80055C7", i, 0, Long.toString(l), Long.toString(this.a.msgId), this.a.cgX, Integer.toString(j), false);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i = j;
        continue;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgElement.1
 * JD-Core Version:    0.7.0.1
 */