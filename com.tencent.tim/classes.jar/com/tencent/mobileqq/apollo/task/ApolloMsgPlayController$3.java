package com.tencent.mobileqq.apollo.task;

import abvl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ApolloMsgPlayController$3
  implements Runnable
{
  public ApolloMsgPlayController$3(abvl paramabvl, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (QQMessageFacade)((AppRuntime)localObject).getManager(20);
      if (localObject != null) {
        ((QQMessageFacade)localObject).a(this.p.frienduin, this.p.istroop, this.p.uniseq, "extStr", this.p.extStr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloMsgPlayController.3
 * JD-Core Version:    0.7.0.1
 */