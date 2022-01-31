package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.h;

class qm
  implements View.OnClickListener
{
  qm(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity) {}
  
  public void onClick(View paramView)
  {
    h.a("interval: " + NetActiveVryMobileNoSmsActivity.access$600(this.a) + "  count: " + NetActiveVryMobileNoSmsActivity.access$700(this.a));
    NetActiveVryMobileNoSmsActivity.access$500(this.a, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qm
 * JD-Core Version:    0.7.0.1
 */