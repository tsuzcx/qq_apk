package com.tencent.token.ui.base;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.BaseActivity;

class dh
  implements View.OnClickListener
{
  dh(dd paramdd) {}
  
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
      localcp.a(paramView, this.a.a, 523005419L);
      dd.a(this.a).showProDialog(dd.a(this.a), 2131230843, 2131231298, null);
      dd.a(this.a, 1);
      return;
    }
    dd.a(this.a).showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new di(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dh
 * JD-Core Version:    0.7.0.1
 */