package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.token.ax;
import com.tencent.token.p;

final class t
  implements View.OnClickListener
{
  t(AccountPageActivity paramAccountPageActivity) {}
  
  public final void onClick(View paramView)
  {
    if (ax.a().e() == null)
    {
      this.a.showNoAccountTipDialog(this.a, 5, 0);
      return;
    }
    p.a().a(System.currentTimeMillis(), 4);
    AccountPageActivity.access$2300(this.a).setVisibility(4);
    paramView = new Intent(this.a, OpreateMsgActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.t
 * JD-Core Version:    0.7.0.1
 */