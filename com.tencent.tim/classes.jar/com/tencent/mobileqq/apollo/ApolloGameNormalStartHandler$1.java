package com.tencent.mobileqq.apollo;

import abhf;
import android.app.Activity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;

public class ApolloGameNormalStartHandler$1
  implements Runnable
{
  public ApolloGameNormalStartHandler$1(abhf paramabhf, int paramInt1, long paramLong, int paramInt2, int paramInt3, QQAppInterface paramQQAppInterface, String paramString1, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, Activity paramActivity) {}
  
  public void run()
  {
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.val$gameId, true, "normalStart", this.kT, 7, this.val$gameMode, this.cgr, ApolloGameUtil.a(this.val$app, this.cgr, this.bfK), this.bfK, this.coF, this.bfL);
    localStartCheckParam.extendJson = this.bfM;
    localStartCheckParam.mTempAIOUin = this.bfN;
    localStartCheckParam.mTempAIONickName = this.bfO;
    if ((this.coF == 318) || (this.coF == 319)) {
      localStartCheckParam.disableMinGame = true;
    }
    ApolloGameUtil.a(this.val$context, localStartCheckParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler.1
 * JD-Core Version:    0.7.0.1
 */