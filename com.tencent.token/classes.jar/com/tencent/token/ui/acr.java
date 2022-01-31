package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.global.e;

final class acr
  implements View.OnClickListener
{
  acr(UnbindUinActivity paramUnbindUinActivity) {}
  
  public final void onClick(View paramView)
  {
    this.a.startTimeTask();
    this.a.showProgressDialog();
    af.a().a("", UnbindUinActivity.access$200(this.a), 1, 3, "", this.a.handler);
    e.a("msg.what=, timetask=" + UnbindUinActivity.access$000(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acr
 * JD-Core Version:    0.7.0.1
 */