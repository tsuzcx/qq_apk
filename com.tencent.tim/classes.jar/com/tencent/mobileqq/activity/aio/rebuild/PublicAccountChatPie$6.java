package com.tencent.mobileqq.activity.aio.rebuild;

import aqrb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import ycd;

public class PublicAccountChatPie$6
  implements Runnable
{
  public PublicAccountChatPie$6(ycd paramycd) {}
  
  public void run()
  {
    int j = ycd.a(this.this$0);
    int i = j;
    if (j > 2) {
      i = 2;
    }
    List localList = this.this$0.app.b().i("2747277822", 1008, i);
    ((aqrb)this.this$0.app.getBusinessHandler(71)).Z(2, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.6
 * JD-Core Version:    0.7.0.1
 */