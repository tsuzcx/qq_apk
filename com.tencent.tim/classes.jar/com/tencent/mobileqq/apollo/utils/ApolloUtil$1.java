package com.tencent.mobileqq.apollo.utils;

import aczw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApollo;

final class ApolloUtil$1
  implements Runnable
{
  ApolloUtil$1(MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      this.d.hasPlayed = true;
      this.d.mApolloMessage.isPlayed = true;
      this.d.msgData = aczw.b(this.d.mApolloMessage);
      this.val$app.b().c(this.Mu, this.alR, this.d.uniseq, this.d.msgData);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.1
 * JD-Core Version:    0.7.0.1
 */