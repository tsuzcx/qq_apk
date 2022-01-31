package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;

final class qp
  implements View.OnClickListener
{
  qp(MyProtecSubPageActivity paramMyProtecSubPageActivity) {}
  
  public final void onClick(View paramView)
  {
    if ((Integer)paramView.getTag() == null) {
      return;
    }
    af.a().d(0L, MyProtecSubPageActivity.access$300(this.a));
    this.a.showUserDialog(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qp
 * JD-Core Version:    0.7.0.1
 */