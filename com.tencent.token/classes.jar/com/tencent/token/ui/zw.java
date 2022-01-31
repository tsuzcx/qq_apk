package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.ag;

final class zw
  implements View.OnClickListener
{
  zw(SettingPageActivity paramSettingPageActivity) {}
  
  public final void onClick(View paramView)
  {
    this.a.showProDialog(this.a, 2131361808, 2131362203, null);
    if (ag.c().g()) {
      af.a().a(this.a.mHandler);
    }
    for (;;)
    {
      SettingPageActivity.mShowUtilNew = false;
      return;
      af.a().h(this.a.mHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zw
 * JD-Core Version:    0.7.0.1
 */