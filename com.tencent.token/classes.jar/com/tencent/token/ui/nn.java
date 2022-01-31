package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class nn
  implements View.OnClickListener
{
  nn(LoginMsgIpShareActivity paramLoginMsgIpShareActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, LoginMsgReportLocationActivity.class);
    paramView.putExtra("position", LoginMsgIpShareActivity.access$300(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nn
 * JD-Core Version:    0.7.0.1
 */