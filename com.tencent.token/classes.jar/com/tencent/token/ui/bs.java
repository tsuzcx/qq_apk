package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.global.e;

final class bs
  implements View.OnClickListener
{
  bs(BindUinActivity paramBindUinActivity) {}
  
  public final void onClick(View paramView)
  {
    e.b("startTimeTask mSmsListener");
    this.a.startTimeTask(2);
    this.a.showProgressDialog();
    if (BindUinActivity.access$200(this.a) == 13)
    {
      af.a().a("", Long.parseLong(BindUinActivity.access$300(this.a)), 1, 5, "", this.a.mHandler);
      return;
    }
    af.a().a("", Long.parseLong(BindUinActivity.access$300(this.a)), 1, 1, "", this.a.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bs
 * JD-Core Version:    0.7.0.1
 */