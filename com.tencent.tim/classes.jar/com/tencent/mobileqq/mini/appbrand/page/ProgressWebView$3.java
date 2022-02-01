package com.tencent.mobileqq.mini.appbrand.page;

import acfp;
import android.view.View;
import android.view.View.OnLongClickListener;
import ausj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;

class ProgressWebView$3
  implements View.OnLongClickListener
{
  ProgressWebView$3(ProgressWebView paramProgressWebView) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = ProgressWebView.access$500(this.this$0).getHitTestResult();
    if ((paramView.getType() == 5) || (paramView.getType() == 8))
    {
      paramView = paramView.getExtra();
      if (QLog.isColorLevel()) {
        QLog.e("ProgressWebView", 2, "onLongClick : " + paramView);
      }
      ausj localausj = ausj.b(ProgressWebView.access$500(this.this$0).getContext());
      localausj.addButton(acfp.m(2131709967), 7);
      localausj.addButton(acfp.m(2131709969), 7);
      localausj.addCancelButton(acfp.m(2131709980));
      localausj.setOutsideDismissEnableCompat(true);
      localausj.a(new ProgressWebView.3.1(this, localausj, paramView));
      localausj.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.3
 * JD-Core Version:    0.7.0.1
 */