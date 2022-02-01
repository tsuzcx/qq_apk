package com.tencent.mobileqq.activity.aio.rebuild;

import abmf;
import abmh;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import xxh;
import xxh.a;

public class CmGameChatPie$ChatPieMsgListener$10
  implements Runnable
{
  public CmGameChatPie$ChatPieMsgListener$10(xxh.a parama, boolean paramBoolean, xxh paramxxh, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (!this.bkz) {
      if (xxh.a(this.a) != null) {
        xxh.a(this.a).dismiss();
      }
    }
    while (this.a.app == null) {
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.val$gameId, true, "message", this.kT, 1, 0, this.a.sessionInfo.cZ, ApolloGameUtil.a(this.a.app, this.a.sessionInfo.cZ, this.a.sessionInfo.aTl), this.a.sessionInfo.aTl, xxh.c(this.a), null);
    localStartCheckParam.mTempAIOUin = this.a.sessionInfo.aTl;
    localStartCheckParam.mTempAIONickName = this.a.sessionInfo.aTn;
    localStartCheckParam.disableMinGame = true;
    ApolloGameUtil.a(this.a.mActivity, localStartCheckParam);
    xxh.bkr = true;
    if (xxh.a(this.a) != null) {
      xxh.a(this.a).dismiss();
    }
    abmh.b(this.a.app, this.a.sessionInfo.aTl, this.a.sessionInfo.cZ, this.val$gameId, this.kT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.10
 * JD-Core Version:    0.7.0.1
 */