package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;

class sm
  implements View.OnClickListener
{
  sm(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public void onClick(View paramView)
  {
    ch.a().a(System.currentTimeMillis(), 63);
    paramView = new Intent(this.a, LoginMsgIpShareActivity.class);
    paramView.putExtra("position", OpMsgDisplayActivity.access$400(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sm
 * JD-Core Version:    0.7.0.1
 */