package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ax;
import com.tencent.token.p;

final class r
  implements View.OnClickListener
{
  r(AccountPageActivity paramAccountPageActivity) {}
  
  public final void onClick(View paramView)
  {
    if (ax.a().e() == null)
    {
      this.a.showNoAccountTipDialog(this.a, 6, 0);
      return;
    }
    p.a().a(System.currentTimeMillis(), 5);
    paramView = new Intent(this.a, LoginMsgActivity.class);
    paramView.putExtra("skey", AccountPageActivity.access$1500(this.a));
    this.a.startActivity(paramView);
    AccountPageActivity.mNeedShowIpcMsg = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.r
 * JD-Core Version:    0.7.0.1
 */