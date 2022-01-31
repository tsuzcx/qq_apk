package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class rn
  implements View.OnClickListener
{
  rn(NetActiveVryOtherListActivity paramNetActiveVryOtherListActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, NetActiveVryQQTokenActivity.class);
    paramView.putExtra("intent.qquser", NetActiveVryOtherListActivity.access$000(this.a));
    paramView.putExtra("intent.upgradedetermin", NetActiveVryOtherListActivity.access$100(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rn
 * JD-Core Version:    0.7.0.1
 */