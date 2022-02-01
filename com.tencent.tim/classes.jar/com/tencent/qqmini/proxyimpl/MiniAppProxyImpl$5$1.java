package com.tencent.qqmini.proxyimpl;

import asvh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class MiniAppProxyImpl$5$1
  implements Runnable
{
  public MiniAppProxyImpl$5$1(asvh paramasvh) {}
  
  public void run()
  {
    if (this.a.val$miniAppInfo.topType == 1)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2131720021, 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 2131720022, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.5.1
 * JD-Core Version:    0.7.0.1
 */