package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;

class yi
  implements View.OnClickListener
{
  yi(ScanLoginBindActivity paramScanLoginBindActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = do.a().e();
    if (paramView == null) {
      return;
    }
    paramView = "" + paramView.mRealUin;
    cp localcp = cp.a(RqdApplication.l());
    if (!localcp.b(paramView, 523005419L))
    {
      localcp.a(paramView, this.a.mHandler, 523005419L);
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      ScanLoginBindActivity.access$002(this.a, 1);
      return;
    }
    this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new yj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yi
 * JD-Core Version:    0.7.0.1
 */