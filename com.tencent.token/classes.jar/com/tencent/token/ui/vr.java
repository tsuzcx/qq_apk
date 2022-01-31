package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class vr
  implements View.OnClickListener
{
  vr(RealNameProtectActivity paramRealNameProtectActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, RealNameActivity.class);
    paramView.putExtra("realname_result", RealNameProtectActivity.access$000(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vr
 * JD-Core Version:    0.7.0.1
 */