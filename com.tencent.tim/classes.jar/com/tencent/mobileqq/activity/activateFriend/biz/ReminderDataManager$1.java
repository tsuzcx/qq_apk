package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import aqhq;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import wii;

public class ReminderDataManager$1
  implements Runnable
{
  public ReminderDataManager$1(wii paramwii, AcsMsg paramAcsMsg) {}
  
  public void run()
  {
    synchronized ()
    {
      if (wii.a(this.this$0, wii.a(this.this$0)).length == 3) {
        wii.a(this.this$0, wii.a(this.this$0));
      }
      JceOutputStream localJceOutputStream = new JceOutputStream();
      String str = wii.a(this.this$0) + "_" + this.b.notice_time * 1000L + "_" + this.b.msg_id;
      try
      {
        localJceOutputStream.setServerEncoding("utf-8");
        this.b.writeTo(localJceOutputStream);
        File localFile = new File(wii.a(this.this$0), str);
        aqhq.writeFile(localJceOutputStream.toByteArray(), localFile.getAbsolutePath());
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e(wii.access$500(), 1, "save file : " + str + " fail because throw an exception " + localThrowable);
          wii.a(this.this$0, this.b);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.1
 * JD-Core Version:    0.7.0.1
 */