package com.tencent.mobileqq.activity.aio.rebuild;

import acff;
import aqmr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import ujt;
import ybt;

public class NearbyChatPie$1
  implements Runnable
{
  public NearbyChatPie$1(ybt paramybt) {}
  
  public void run()
  {
    try
    {
      Card localCard = ((acff)this.this$0.app.getManager(51)).b(this.this$0.sessionInfo.aTl);
      if (localCard == null)
      {
        if (aqmr.verifyUin(this.this$0.sessionInfo.aTl)) {
          ((CardHandler)this.this$0.app.getBusinessHandler(2)).a(this.this$0.app.getCurrentAccountUin(), this.this$0.sessionInfo.aTl, (byte)1, 0);
        }
      }
      else if ((localCard != null) && (localCard.strCertificationInfo != null) && (!localCard.strCertificationInfo.equals("")))
      {
        ujt.h(this.this$0.app, this.this$0.sessionInfo);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.1
 * JD-Core Version:    0.7.0.1
 */