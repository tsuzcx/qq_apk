package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class td
  implements View.OnClickListener
{
  td(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, UtilsGameProtectActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.td
 * JD-Core Version:    0.7.0.1
 */