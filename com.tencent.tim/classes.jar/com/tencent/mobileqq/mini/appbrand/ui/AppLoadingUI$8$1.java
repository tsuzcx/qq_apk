package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class AppLoadingUI$8$1
  implements Runnable
{
  AppLoadingUI$8$1(AppLoadingUI.8 param8, String paramString, long paramLong) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, "" + this.val$errMsg, 1).show();
    this.this$1.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.8.1
 * JD-Core Version:    0.7.0.1
 */