package com.tencent.mobileqq.apollo.utils;

import abxk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import java.util.ArrayList;

final class ApolloGameUtil$8
  implements Runnable
{
  ApolloGameUtil$8(QQAppInterface paramQQAppInterface, ApolloGameRankData paramApolloGameRankData) {}
  
  public void run()
  {
    if ((this.val$app != null) && (this.a != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.a);
      ((abxk)this.val$app.getManager(155)).d(this.val$app.a().createEntityManager(), localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.8
 * JD-Core Version:    0.7.0.1
 */