package com.tencent.mobileqq.apollo.utils;

import abhh;
import abxk;
import android.util.SparseArray;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import java.util.concurrent.ConcurrentHashMap;

final class ApolloGameUtil$23
  implements Runnable
{
  ApolloGameUtil$23(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void run()
  {
    Object localObject = (abxk)this.val$app.getManager(155);
    ((abxk)localObject).In(this.val$startCheckParam.game.gameId);
    abhh localabhh = (abhh)this.val$app.getManager(153);
    if ((((abxk)localObject).dE != null) && (((abxk)localObject).dE.containsKey(Integer.valueOf(this.val$startCheckParam.game.gameId))))
    {
      localObject = (String)((abxk)localObject).dE.get(Integer.valueOf(this.val$startCheckParam.game.gameId));
      localabhh.bG(this.val$startCheckParam.game.gameId, (String)localObject);
    }
    if (ApolloGameUtil.f() != null) {
      ApolloGameUtil.f().put(this.val$startCheckParam.gameId, Integer.valueOf(this.val$startCheckParam.viewMode));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.23
 * JD-Core Version:    0.7.0.1
 */