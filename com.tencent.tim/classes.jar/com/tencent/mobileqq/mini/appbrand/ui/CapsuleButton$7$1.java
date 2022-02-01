package com.tencent.mobileqq.mini.appbrand.ui;

import acfp;
import aekv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class CapsuleButton$7$1
  implements Runnable
{
  CapsuleButton$7$1(CapsuleButton.7 param7) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo != null) {
      this.this$1.val$miniAppInfo.topType = 0;
    }
    if (aekv.needShowMiniAppFullScreen())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131703402) + aekv.getMaxTopNum() + acfp.m(2131703401), 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.7.1
 * JD-Core Version:    0.7.0.1
 */