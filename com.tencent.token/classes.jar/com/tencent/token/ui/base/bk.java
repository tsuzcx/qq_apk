package com.tencent.token.ui.base;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.x;

final class bk
  implements View.OnClickListener
{
  bk(bh parambh) {}
  
  public final void onClick(View paramView)
  {
    paramView = ax.a().e();
    if (paramView == null) {
      return;
    }
    paramView = "" + paramView.mRealUin;
    x localx = x.a(RqdApplication.i());
    if (!localx.b(paramView, 523005425L))
    {
      localx.a(paramView, this.a.a, 523005425L);
      bh.a(this.a).showProDialog(bh.a(this.a), 2131361808, 2131361817, null);
      return;
    }
    bh.a(this.a).showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new bl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bk
 * JD-Core Version:    0.7.0.1
 */