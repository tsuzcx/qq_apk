package com.tencent.mobileqq.ark.image;

import adrc;
import adst;
import adsu;
import android.os.Bundle;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class ChooseImageIPCModule$1
  implements Runnable
{
  public ChooseImageIPCModule$1(adst paramadst, AppRuntime paramAppRuntime, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    String str = null;
    Object localObject = (ArkAppCenter)this.val$app.getManager(121);
    if (localObject == null)
    {
      QLog.e("ArkApp.ChooseImageIPCModule", 1, "ArkMultiProc.callSendAppMsg  appCenter is null");
      localObject = new Bundle();
      ((Bundle)localObject).putInt("code", -1);
      localObject = EIPCResult.createResult(-102, (Bundle)localObject);
      this.this$0.callbackResult(this.val$callbackId, (EIPCResult)localObject);
      return;
    }
    adrc localadrc = ((ArkAppCenter)localObject).a();
    if (localadrc == null)
    {
      QLog.e("ArkApp.ChooseImageIPCModule", 1, "ArkMultiProc.callSendAppMsg  sso is null");
      localObject = new Bundle();
      ((Bundle)localObject).putInt("code", -1);
      localObject = EIPCResult.createResult(-102, (Bundle)localObject);
      this.this$0.callbackResult(this.val$callbackId, (EIPCResult)localObject);
      return;
    }
    int i;
    if (this.val$bundle != null)
    {
      localObject = this.val$bundle.getString("cmd");
      if (this.val$bundle != null) {
        str = this.val$bundle.getString("msg");
      }
      if (this.val$bundle == null) {
        break label241;
      }
      i = this.val$bundle.getInt("timeOut");
      label169:
      if (this.val$bundle == null) {
        break label246;
      }
    }
    label241:
    label246:
    for (int j = this.val$bundle.getInt("notifyType");; j = 0)
    {
      QLog.d("ArkApp.ChooseImageIPCModule", 1, new Object[] { "ArkMultiProc.callSendAppMsg cmd=", localObject, ", msg=", str });
      localadrc.a((String)localObject, str, i, j, new adsu(this, (String)localObject));
      return;
      localObject = null;
      break;
      i = 0;
      break label169;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.ChooseImageIPCModule.1
 * JD-Core Version:    0.7.0.1
 */