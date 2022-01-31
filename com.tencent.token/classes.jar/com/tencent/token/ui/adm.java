package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.p;

final class adm
  implements View.OnClickListener
{
  adm(UtilsActivity paramUtilsActivity) {}
  
  public final void onClick(View paramView)
  {
    p.a().a(System.currentTimeMillis(), 60);
    this.a.showNoAccountTipDialog(this.a, 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adm
 * JD-Core Version:    0.7.0.1
 */