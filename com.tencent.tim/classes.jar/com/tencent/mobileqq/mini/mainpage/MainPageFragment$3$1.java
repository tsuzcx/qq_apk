package com.tencent.mobileqq.mini.mainpage;

import acfp;
import aekv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class MainPageFragment$3$1
  implements Runnable
{
  MainPageFragment$3$1(MainPageFragment.3 param3) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo != null)
    {
      this.this$1.val$miniAppInfo.topType = 0;
      MainPageFragment.access$500(this.this$1.this$0, this.this$1.val$miniAppInfo);
    }
    if (aekv.needShowMiniAppFullScreen())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131708013) + aekv.getMaxTopNum() + acfp.m(2131708009), 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131695941), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.3.1
 * JD-Core Version:    0.7.0.1
 */