package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class PreloadingFragment$3$1
  implements Runnable
{
  PreloadingFragment$3$1(PreloadingFragment.3 param3, String paramString, long paramLong) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, "" + this.val$errMsg, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */