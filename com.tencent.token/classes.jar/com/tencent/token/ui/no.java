package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.global.e;

final class no
  implements View.OnClickListener
{
  no(JianLingActivity paramJianLingActivity) {}
  
  public final void onClick(View paramView)
  {
    e.c("retry: ");
    af.a().a(0L, this.a.mHandler, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.no
 * JD-Core Version:    0.7.0.1
 */