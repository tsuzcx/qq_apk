package com.tencent.mobileqq.teamwork.spread;

import aocq;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.TimerTask;

public class AIOMessageSpreadManager$3
  extends TimerTask
{
  public AIOMessageSpreadManager$3(aocq paramaocq) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.this$0.aoU;
      if (l2 >= 950L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + this.this$0.aoU + "],now[" + l1 + "], dur[" + l2 + "],timeOut start check!");
        }
        i = aocq.a(this.this$0).size() - 1;
        while (i >= 0)
        {
          localMessageRecord = (MessageRecord)aocq.a(this.this$0).get(i);
          this.this$0.Z((ChatMessage)localMessageRecord);
          i -= 1;
        }
        this.this$0.aoU = 0L;
        aocq.a(this.this$0).clear();
      }
      while (!QLog.isColorLevel())
      {
        int i;
        MessageRecord localMessageRecord;
        return;
      }
      QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + this.this$0.aoU + "],now[" + l1 + "], dur[" + l2 + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.3
 * JD-Core Version:    0.7.0.1
 */