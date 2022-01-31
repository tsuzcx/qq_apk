package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.cw;
import com.tencent.token.global.h;

class abb
  implements View.OnClickListener
{
  abb(UnbindUinActivity paramUnbindUinActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startTimeTask();
    this.a.showProgressDialog();
    cw.a().a("", UnbindUinActivity.access$200(this.a), 1, 3, "", this.a.handler);
    h.a("msg.what=, timetask=" + UnbindUinActivity.access$000(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abb
 * JD-Core Version:    0.7.0.1
 */