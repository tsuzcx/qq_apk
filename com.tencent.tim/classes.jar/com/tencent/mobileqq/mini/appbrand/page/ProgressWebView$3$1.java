package com.tencent.mobileqq.mini.appbrand.page;

import acfp;
import android.view.View;
import ausj;
import ausj.a;

class ProgressWebView$3$1
  implements ausj.a
{
  ProgressWebView$3$1(ProgressWebView.3 param3, ausj paramausj, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    paramView = this.val$actionSheet.getContent(paramInt);
    if (acfp.m(2131709976).equals(paramView)) {
      ProgressWebView.access$600(this.this$1.this$0, this.val$pic);
    }
    while (!acfp.m(2131709970).equals(paramView)) {
      return;
    }
    ProgressWebView.access$700(this.this$1.this$0, this.val$pic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3.1
 * JD-Core Version:    0.7.0.1
 */