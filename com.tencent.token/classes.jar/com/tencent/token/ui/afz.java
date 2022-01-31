package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class afz
  implements View.OnClickListener
{
  afz(UtilsTokenLabActivity paramUtilsTokenLabActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, RealNameProtectActivity.class);
    paramView.putExtra("realname_result", UtilsTokenLabActivity.access$100(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afz
 * JD-Core Version:    0.7.0.1
 */