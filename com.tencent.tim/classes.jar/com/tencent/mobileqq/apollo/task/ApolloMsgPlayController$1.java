package com.tencent.mobileqq.apollo.task;

import abht;
import abvl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPush;

public class ApolloMsgPlayController$1
  implements Runnable
{
  public ApolloMsgPlayController$1(abvl paramabvl, QQAppInterface paramQQAppInterface, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    if (this.val$app != null) {
      ((abht)this.val$app.getManager(227)).a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloMsgPlayController.1
 * JD-Core Version:    0.7.0.1
 */