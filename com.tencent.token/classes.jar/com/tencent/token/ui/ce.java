package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.cw;
import com.tencent.token.global.h;

class ce
  implements View.OnClickListener
{
  ce(BindUinActivity paramBindUinActivity) {}
  
  public void onClick(View paramView)
  {
    h.b("startTimeTask mSmsListener");
    this.a.startTimeTask();
    this.a.showProgressDialog();
    if (BindUinActivity.access$200(this.a) == 13)
    {
      cw.a().a("", Long.parseLong(BindUinActivity.access$300(this.a)), 1, 5, "", this.a.mHandler);
      return;
    }
    cw.a().a("", Long.parseLong(BindUinActivity.access$300(this.a)), 1, 1, "", this.a.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ce
 * JD-Core Version:    0.7.0.1
 */