package com.tencent.mobileqq.apollo.utils;

import abhe;
import abhh;
import abmi;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.qphone.base.util.QLog;

final class ApolloGameUtil$22
  implements Runnable
{
  ApolloGameUtil$22(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void run()
  {
    ((abhe)this.val$app.getManager(211)).c(this.val$startCheckParam.game);
    if ((this.val$startCheckParam.src == 318) || (this.val$startCheckParam.src == 319))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "[] update light game list:" + this.val$startCheckParam.gameId);
      }
      ((abhh)this.val$app.getManager(153)).a().Hv(this.val$startCheckParam.gameId);
    }
    ApolloGameUtil.a(this.val$app, this.val$startCheckParam.gameId, false);
    String str2;
    if ((this.val$startCheckParam.game != null) && (this.val$startCheckParam.game.isShow == 1))
    {
      str2 = this.val$startCheckParam.gameId + "";
      if (this.val$startCheckParam.game != null) {
        break label204;
      }
    }
    label204:
    for (String str1 = null;; str1 = this.val$startCheckParam.game.name)
    {
      UsedAppListManager.recordAppStart(new AppInfo(1, str2, str1, null));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.22
 * JD-Core Version:    0.7.0.1
 */