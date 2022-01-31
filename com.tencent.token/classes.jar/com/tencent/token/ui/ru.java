package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ru
  implements View.OnClickListener
{
  ru(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, UtilsLoginProtectActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ru
 * JD-Core Version:    0.7.0.1
 */