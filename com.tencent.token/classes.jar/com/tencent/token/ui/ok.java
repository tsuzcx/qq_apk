package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class ok
  implements View.OnClickListener
{
  ok(LoginMsgIpShareActivity paramLoginMsgIpShareActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, LoginMsgReportLocationActivity.class);
    paramView.putExtra("position", LoginMsgIpShareActivity.access$300(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ok
 * JD-Core Version:    0.7.0.1
 */