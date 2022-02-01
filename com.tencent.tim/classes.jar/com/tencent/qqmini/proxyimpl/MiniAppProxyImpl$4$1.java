package com.tencent.qqmini.proxyimpl;

import acfp;
import aekv;
import asvg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class MiniAppProxyImpl$4$1
  implements Runnable
{
  public MiniAppProxyImpl$4$1(asvg paramasvg) {}
  
  public void run()
  {
    if (this.a.val$miniAppInfo != null) {
      this.a.val$miniAppInfo.topType = 0;
    }
    if (aekv.needShowMiniAppFullScreen())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131703402) + aekv.getMaxTopNum() + acfp.m(2131703401), 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.4.1
 * JD-Core Version:    0.7.0.1
 */