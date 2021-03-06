package com.tencent.mobileqq.apollo.utils;

import abxk;
import aqrb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameScoreData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

final class ApolloGameUtil$7
  implements Runnable
{
  ApolloGameUtil$7(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    aqrb localaqrb;
    String str;
    Object localObject2;
    try
    {
      if (this.val$app == null)
      {
        QLog.e("ApolloGameUtil", 1, "[updateRankInfo] app is null in thread");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "[updateRankInfo] real update " + this.SO);
      }
      localaqrb = (aqrb)this.val$app.getBusinessHandler(71);
      Object localObject1 = (abxk)this.val$app.getManager(155);
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Object localObject5 = ((abxk)localObject1).cN();
      Object localObject3 = ((abxk)localObject1).e(str, ApolloGameUtil.Ab(), (List)localObject5);
      Object localObject4 = ((abxk)localObject1).a(str, this.SO, ApolloGameUtil.Ab(), (List)localObject5);
      if ((localObject3 != null) && (QLog.isColorLevel())) {
        QLog.d("ApolloGameUtil", 2, "[updateRankInfo] self init " + ((List)localObject3).size());
      }
      if ((localObject4 != null) && (QLog.isColorLevel())) {
        QLog.d("ApolloGameUtil", 2, "[updateRankInfo] friend init " + ((List)localObject4).size());
      }
      if (localObject3 != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (((List)localObject3).size() != 0) {
          break label410;
        }
      }
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (localObject5 == null) {
        break label410;
      }
      localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      localObject3 = ((List)localObject5).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ApolloGameData)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject5 = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject5).mUin = str;
          ((ApolloGameScoreData)localObject5).mGameId = ((ApolloGameData)localObject4).gameId;
          ((List)localObject2).add(localObject5);
          localObject5 = new ApolloGameScoreData();
          ((ApolloGameScoreData)localObject5).mUin = this.SO;
          ((ApolloGameScoreData)localObject5).mGameId = ((ApolloGameData)localObject4).gameId;
          ((List)localObject1).add(localObject5);
        }
      }
      if (!QLog.isColorLevel()) {
        break label424;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
      return;
    }
    QLog.d("ApolloGameUtil", 2, "[updateRankInfo] friend expend " + localThrowable.size());
    label410:
    label424:
    for (;;)
    {
      localaqrb.a(str, (List)localObject2, this.SO, localThrowable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.7
 * JD-Core Version:    0.7.0.1
 */