package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;

final class rg
  implements View.OnClickListener
{
  rg(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity) {}
  
  public final void onClick(View paramView)
  {
    e.a("interval: " + NetActiveVryMobileNoSmsActivity.access$800(this.a) + "  count: " + NetActiveVryMobileNoSmsActivity.access$900(this.a));
    NetActiveVryMobileNoSmsActivity.access$700(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rg
 * JD-Core Version:    0.7.0.1
 */