package com.tencent.mobileqq.mini.share;

import android.app.Activity;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class MiniProgramShareUtils$2
  implements MiniAppCmdInterface
{
  MiniProgramShareUtils$2(int paramInt1, Activity paramActivity, MiniArkShareModel paramMiniArkShareModel, int paramInt2, MiniProgramShareUtils.OnShareListener paramOnShareListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      if ((this.val$finalShareType == 5) && ((this.val$activity instanceof GameActivity)))
      {
        localObject = ((GameActivity)this.val$activity).getGameBrandRuntime();
        if (localObject != null) {
          ((GameBrandRuntime)localObject).shareJson = paramJSONObject.toString();
        }
      }
      if (MiniProgramShareUtils.access$100(this.val$activity, MiniProgramShareUtils.access$000(this.val$miniArkShareModel, paramJSONObject), this.val$miniArkShareModel.getDescription(), this.val$miniArkShareModel.getPicUrl(), this.val$miniArkShareModel.getJumpUrl(), this.val$miniArkShareModel.getEntryModel(), this.val$miniArkShareModel.getShareChatModel(), this.val$miniAppShareFrom, this.val$miniArkShareModel.getShareTarget(), paramJSONObject, this.val$finalShareType, this.val$miniArkShareModel.getAppId(), this.val$miniArkShareModel.getShareBusinessType())) {
        QLog.d("MiniProgramShareUtils [miniappArkShare]", 1, "onCmdListener: share successful " + paramJSONObject.toString());
      }
      return;
    }
    QLog.d("MiniProgramShareUtils [miniappArkShare]", 1, "onCmdListener: share failed " + paramBoolean + " " + paramJSONObject);
    long l = -1L;
    Object localObject = null;
    boolean bool = false;
    if (paramJSONObject != null)
    {
      l = paramJSONObject.optLong("retCode");
      localObject = paramJSONObject.optString("errMsg");
      bool = paramJSONObject.optBoolean("needShareCallBack");
    }
    AppBrandTask.runTaskOnUiThread(new MiniProgramShareUtils.2.1(this, paramBoolean, Boolean.valueOf(bool), l, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramShareUtils.2
 * JD-Core Version:    0.7.0.1
 */