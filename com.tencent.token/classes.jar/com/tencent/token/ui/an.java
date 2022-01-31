package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;

class an
  implements View.OnClickListener
{
  an(AccountPageActivity paramAccountPageActivity) {}
  
  public void onClick(View paramView)
  {
    if (do.a().e() == null)
    {
      this.a.showNoAccountTipDialog(this.a, 3, 0);
      return;
    }
    if (!do.a().e().mIsBinded)
    {
      this.a.showNoAccountTipDialog(this.a, 3, 1);
      return;
    }
    cw.a().j(0L, this.a.mHandler);
    this.a.showProDialog(this.a, 2131230843, 2131231601, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.an
 * JD-Core Version:    0.7.0.1
 */