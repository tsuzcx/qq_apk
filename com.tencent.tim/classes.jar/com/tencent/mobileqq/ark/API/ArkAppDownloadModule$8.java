package com.tencent.mobileqq.ark.API;

import adnc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class ArkAppDownloadModule$8
  implements Runnable
{
  public ArkAppDownloadModule$8(adnc paramadnc, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      QQToast.a(localBaseActivity, this.val$msg, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.8
 * JD-Core Version:    0.7.0.1
 */