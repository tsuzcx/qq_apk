package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class re
  implements View.OnClickListener
{
  re(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, NetActiveVryOtherListActivity.class);
    paramView.putExtra("intent.qquser", NetActiveVryMobileNoSmsActivity.access$400(this.a));
    paramView.putExtra("intent.upgradedetermin", NetActiveVryMobileNoSmsActivity.access$200(this.a));
    paramView.putExtra("page_id", NetActiveVryMobileNoSmsActivity.access$500(this.a));
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.re
 * JD-Core Version:    0.7.0.1
 */