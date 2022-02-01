package com.tencent.qqmini.proxyimpl;

import acfp;
import android.app.Activity;
import arhz;
import aswo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;

public class ShareProxyImpl$5
  implements Runnable
{
  public ShareProxyImpl$5(aswo paramaswo, Activity paramActivity, InnerShareData paramInnerShareData) {}
  
  public void run()
  {
    arhz localarhz = new arhz(this.val$activity);
    localarhz.setMessage(acfp.m(2131704610));
    localarhz.show();
    ThreadManager.excute(new ShareProxyImpl.5.1(this, localarhz), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */