package com.tencent.mobileqq.ark.image;

import adst;
import adsv;
import android.os.Bundle;
import android.text.TextUtils;
import aquz;
import aqva;
import aqvc;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import mqq.app.AppRuntime;

public class ChooseImageIPCModule$2
  implements Runnable
{
  public ChooseImageIPCModule$2(adst paramadst, Bundle paramBundle, int paramInt, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1;
    boolean bool1;
    label37:
    boolean bool2;
    if (this.val$bundle != null)
    {
      localObject1 = this.val$bundle.getString("url");
      if (this.val$bundle == null) {
        break label196;
      }
      bool1 = this.val$bundle.getBoolean("supportGzip");
      if (this.val$bundle == null) {
        break label201;
      }
      bool2 = this.val$bundle.getBoolean("supportRedirect");
      label54:
      if (this.val$bundle == null) {
        break label206;
      }
      localObject2 = this.val$bundle.getString("Cookie");
      label72:
      if (this.val$bundle == null) {
        break label212;
      }
    }
    label196:
    label201:
    label206:
    label212:
    for (String str = this.val$bundle.getString("Referer");; str = null)
    {
      if (this.val$bundle != null) {
        localObject3 = this.val$bundle.getString("file");
      }
      QLog.i("ArkApp.ChooseImageIPCModule", 1, "ArkMultiProc.callDownload url=" + (String)localObject1);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
        break label218;
      }
      QLog.e("ArkApp.ChooseImageIPCModule", 1, "ArkMultiProc.callDownload for url is null or filepath is null");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("code", -1);
      localObject1 = EIPCResult.createResult(-102, (Bundle)localObject1);
      this.this$0.callbackResult(this.val$callbackId, (EIPCResult)localObject1);
      return;
      localObject1 = null;
      break;
      bool1 = true;
      break label37;
      bool2 = true;
      break label54;
      localObject2 = null;
      break label72;
    }
    label218:
    Object localObject4 = (aqva)this.val$app.getManager(47);
    if (localObject4 == null)
    {
      QLog.e("ArkApp.ChooseImageIPCModule", 1, "ArkMultiProc.callDownload return for factory is null");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("code", -1);
      localObject1 = EIPCResult.createResult(-102, (Bundle)localObject1);
      this.this$0.callbackResult(this.val$callbackId, (EIPCResult)localObject1);
      return;
    }
    localObject4 = ((aqva)localObject4).a(1);
    localObject3 = new aquz((String)localObject1, new File((String)localObject3));
    ((aquz)localObject3).cWw = bool1;
    ((aquz)localObject3).cWy = bool2;
    if (localObject2 != null) {
      ((aquz)localObject3).addHeader("Cookie", (String)localObject2);
    }
    if (str != null) {
      ((aquz)localObject3).addHeader("Referer", str);
    }
    Object localObject2 = new Bundle();
    ((aqvc)localObject4).a((aquz)localObject3, new adsv(this, (String)localObject1), (Bundle)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.ChooseImageIPCModule.2
 * JD-Core Version:    0.7.0.1
 */