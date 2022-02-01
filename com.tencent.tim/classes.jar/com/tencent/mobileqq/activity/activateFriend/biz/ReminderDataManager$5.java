package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import wii;
import wii.a;

public class ReminderDataManager$5
  implements Runnable
{
  public ReminderDataManager$5(wii paramwii, String paramString, wii.a parama) {}
  
  public void run()
  {
    File[] arrayOfFile = wii.b(this.this$0, wii.a(this.this$0));
    int j;
    int i;
    if (arrayOfFile.length > 0)
    {
      j = arrayOfFile.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        AcsMsg localAcsMsg = this.this$0.a(localFile);
        if ((localAcsMsg == null) || (!localAcsMsg.msg_id.equals(this.val$msgId))) {
          break label190;
        }
        if (QLog.isColorLevel()) {
          QLog.d(wii.access$500(), 2, "deleteReminderFilesByMsgId msgId: " + this.val$msgId);
        }
        if (!aqhq.deleteFile(localFile.getAbsolutePath())) {
          break label158;
        }
        wii.a(this.this$0, localAcsMsg);
        if (QLog.isColorLevel()) {
          QLog.d(wii.access$500(), 2, "cancelAlarmById alarmId: " + localAcsMsg.hashCode());
        }
      }
      label158:
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(wii.access$500(), 2, " deleteFile fail ");
        }
      } while (this.a == null);
      this.a.bYk();
      return;
      label190:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.5
 * JD-Core Version:    0.7.0.1
 */