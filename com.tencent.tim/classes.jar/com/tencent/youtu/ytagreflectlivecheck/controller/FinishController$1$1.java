package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessFinishResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3.UploadVideoResponse;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;

class FinishController$1$1
  implements UploadVideoRequesterV3.UploadVideoResponse
{
  FinishController$1$1(FinishController.1 param1) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    this.this$1.val$checkResult.onFailed(FinishController.access$200(), "Upload video failed.[" + paramInt + "]", "Maybe net error? return code: " + paramInt + " message: " + paramString, this.this$1.val$tag);
  }
  
  public void onSuccess(String paramString)
  {
    try
    {
      LightDiffResponse localLightDiffResponse = (LightDiffResponse)new WeJson().fromJson(paramString, LightDiffResponse.class);
      if (localLightDiffResponse != null)
      {
        if (localLightDiffResponse.errorcode == 0)
        {
          this.this$1.val$checkResult.onSuccess(true, localLightDiffResponse, paramString, this.this$1.val$tag);
          return;
        }
        this.this$1.val$checkResult.onSuccess(false, localLightDiffResponse, paramString, this.this$1.val$tag);
        return;
      }
    }
    catch (Exception localException)
    {
      YTException.report(localException);
      this.this$1.val$checkResult.onFailed(FinishController.access$100(), "Upload video response json decode failed.", "received response: " + paramString, this.this$1.val$tag);
      return;
    }
    this.this$1.val$checkResult.onFailed(FinishController.access$000(), "Upload video call back decode return nil.", "received response: " + paramString, this.this$1.val$tag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.FinishController.1.1
 * JD-Core Version:    0.7.0.1
 */