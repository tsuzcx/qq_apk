package com.tencent.mobileqq.mini.share;

import ahlw;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.webkit.URLUtil;
import arhz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

final class MiniProgramOpenSdkUtil$3
  implements MiniAppCmdInterface
{
  MiniProgramOpenSdkUtil$3(Runnable paramRunnable1, Runnable paramRunnable2, MiniProgramOpenSdkUtil.TimeOutInfo paramTimeOutInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, Context paramContext, Intent paramIntent, String paramString9) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i = 1;
    ahlw.report("KEY_STAGE_1_GET_SHARE_INFO");
    QLog.d("MiniProgramOpenSdkUtil", 1, new Object[] { "arkShareJson:", paramJSONObject.toString() });
    ThreadManager.getUIHandler().removeCallbacks(this.val$timeoutRunnable);
    ThreadManager.getUIHandler().removeCallbacks(this.val$showLoadingRunnable);
    if ((this.val$outInfo.progressDialog != null) && (this.val$outInfo.progressDialog.isShowing())) {
      this.val$outInfo.progressDialog.dismiss();
    }
    if (this.val$outInfo.isTimeout)
    {
      QLog.e("MiniProgramOpenSdkUtil", 1, "forwardShare failed timeout");
      return;
    }
    if (paramBoolean)
    {
      OpenSdkShareModel localOpenSdkShareModel = new OpenSdkShareModel();
      localOpenSdkShareModel.miniAppAppid = this.val$miniProgramAppid;
      localOpenSdkShareModel.miniAppPath = this.val$miniProgramPath;
      localOpenSdkShareModel.miniAppType = this.val$miniProgramType;
      localOpenSdkShareModel.webPageUrl = this.val$url;
      localOpenSdkShareModel.appRichId = this.val$appRichId;
      localOpenSdkShareModel.title = this.val$title;
      localOpenSdkShareModel.desc = this.val$desc;
      if ((!URLUtil.isHttpUrl(this.val$finalNotEmptyPicUri)) && (!URLUtil.isHttpsUrl(this.val$finalNotEmptyPicUri))) {}
      while (i != 0)
      {
        ahlw.Kj("KEY_STAGE_1_UPLOAD_IMAGE");
        MiniArkShareAsyncManager.performUploadArkShareImage(this.val$finalNotEmptyPicUri, new MiniProgramOpenSdkUtil.3.1(this, paramJSONObject, localOpenSdkShareModel));
        return;
        i = 0;
      }
      MiniProgramOpenSdkUtil.access$400(paramJSONObject);
      localOpenSdkShareModel.imageUrl = this.val$previewPicUrl;
      localOpenSdkShareModel.jsonStr = paramJSONObject.toString();
      MiniProgramOpenSdkUtil.access$300(this.val$context, this.val$intent, this.val$finalNotEmptyPicUri, paramJSONObject, localOpenSdkShareModel);
      return;
    }
    QLog.e("MiniProgramOpenSdkUtil", 1, "getShareInfo - failed,  miniProgramJson: " + paramJSONObject);
    paramJSONObject = paramJSONObject.optString("errMsg");
    ThreadManagerV2.getUIHandlerV2().post(new MiniProgramOpenSdkUtil.3.2(this, paramJSONObject));
    MiniProgramOpenSdkUtil.access$100(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.3
 * JD-Core Version:    0.7.0.1
 */