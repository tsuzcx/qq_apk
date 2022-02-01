package com.tencent.mobileqq.mini.appbrand.ui;

import acfp;
import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.widget.QQToast;

class AppLoadingUI$11$3
  implements Runnable
{
  AppLoadingUI$11$3(AppLoadingUI.11 param11) {}
  
  public void run()
  {
    QQToast.a(this.this$1.this$0.getActivity().getApplicationContext(), acfp.m(2131702755), 0).show();
    this.this$1.this$0.uiHandler.postDelayed(new AppLoadingUI.11.3.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.11.3
 * JD-Core Version:    0.7.0.1
 */