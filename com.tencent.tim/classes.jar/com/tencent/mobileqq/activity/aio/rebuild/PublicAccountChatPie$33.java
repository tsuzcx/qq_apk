package com.tencent.mobileqq.activity.aio.rebuild;

import anpc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import ycd;

public class PublicAccountChatPie$33
  implements Runnable
{
  public PublicAccountChatPie$33(ycd paramycd, String paramString, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    List localList = this.this$0.app.b().k(this.val$uin, this.val$type);
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (localList != null)
    {
      bool1 = bool2;
      if (!localList.isEmpty()) {
        i = localList.size() - 1;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        if ((((MessageRecord)localList.get(i)).msgUid == this.JM) && (((MessageRecord)localList.get(i)).shmsgseq == this.JN)) {
          bool1 = true;
        }
      }
      else
      {
        anpc.a(BaseApplication.getContext()).collectPerformance(this.this$0.app.getCurrentAccountUin(), "show_msg_result", bool1, 0L, 0L, new HashMap(), "");
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "reportShowMsgResult uin = " + this.val$uin + " , type = " + this.val$type + " , msguid = " + this.JM + " , result = " + bool1);
        }
        if ((!bool1) && (QLog.isColorLevel())) {
          QLog.d(this.this$0.TAG, 2, "lost msg uin = " + this.val$uin + " , type = " + this.val$type + " , msguid = " + this.JM + " , msgseq = " + this.JN);
        }
        return;
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.33
 * JD-Core Version:    0.7.0.1
 */