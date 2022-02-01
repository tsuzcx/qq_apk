package com.tencent.mobileqq.apollo.process.chanel;

import abmt;
import aboi;
import abos;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class CmGameToolCmdChannel$5
  implements Runnable
{
  public CmGameToolCmdChannel$5(int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    CmGameStartChecker.StartCheckParam localStartCheckParam;
    try
    {
      abos localabos = abmt.a(this.val$gameId);
      if ((localabos == null) || (localabos.a() == null))
      {
        QLog.e("cmgame_process.CmGameToolCmdChannel", 1, "cmd:" + this.val$cmd + "cmGameLauncher == null || cmGameLauncher.getCheckParam() == null");
        return;
      }
      localStartCheckParam = localabos.a();
      if (TextUtils.isEmpty(localStartCheckParam.mTempAIOUin))
      {
        QLog.e("cmgame_process.CmGameToolCmdChannel", 1, "cmd:" + this.val$cmd + "startCheckParam.mTempAIOUin is empty");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameToolCmdChannel", 1, localException, new Object[0]);
      return;
    }
    JSONObject localJSONObject = new JSONObject(this.bhg);
    localJSONObject.put("friendUin", localStartCheckParam.mTempAIOUin);
    localJSONObject.put("nickName", localStartCheckParam.mTempAIONickName);
    localJSONObject.put("robotOpenId", localStartCheckParam.mRobotOpenId);
    localJSONObject.put("gameId", this.val$gameId);
    aboi.a(this.val$cmd, localJSONObject.toString(), false, null, this.val$gameId);
    Activity localActivity = localException.q();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel.5
 * JD-Core Version:    0.7.0.1
 */