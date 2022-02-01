package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class CapsuleButton$7
  implements EIPCResultCallback
{
  CapsuleButton$7(CapsuleButton paramCapsuleButton, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.code == -100))
    {
      AppBrandTask.runTaskOnUiThread(new CapsuleButton.7.1(this));
      return;
    }
    CapsuleButton.access$800(this.this$0, this.val$miniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.7
 * JD-Core Version:    0.7.0.1
 */