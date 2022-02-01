package com.tencent.viola.core;

import android.text.TextUtils;
import com.tencent.viola.utils.ViolaLogUtils;

final class ViolaSDKEngine$1
  implements Runnable
{
  ViolaSDKEngine$1(InitConfig paramInitConfig, ViolaSDKEngine.InitCallback paramInitCallback, String paramString) {}
  
  public void run()
  {
    System.currentTimeMillis();
    ViolaSDKManager localViolaSDKManager = ViolaSDKManager.getInstance();
    if (this.val$config != null) {
      localViolaSDKManager.setInitConfig(this.val$config);
    }
    if ((this.val$config != null) && (!TextUtils.isEmpty(this.val$config.getFrameworkLoaclPath())))
    {
      localViolaSDKManager.initScriptsFramework(this.val$config.getFrameworkLoaclPath(), this.val$initCallback, this.val$data);
      return;
    }
    if ((this.val$config != null) && (!TextUtils.isEmpty(this.val$config.getFramework())))
    {
      localViolaSDKManager.initScriptsFrameworkString(this.val$config.getFramework(), this.val$initCallback, this.val$data);
      return;
    }
    if (this.val$initCallback != null) {
      this.val$initCallback.onFinish(100, 0L, " main js path is null");
    }
    ViolaLogUtils.e("ViolaSDKEngine", " main js path is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.ViolaSDKEngine.1
 * JD-Core Version:    0.7.0.1
 */