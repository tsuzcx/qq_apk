package com.tencent.mobileqq.mini.sdk;

import acfp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class MiniAppLauncher$3
  implements Runnable
{
  MiniAppLauncher$3(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131708387) + this.val$appId, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher.3
 * JD-Core Version:    0.7.0.1
 */