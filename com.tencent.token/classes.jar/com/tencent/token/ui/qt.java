package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;

final class qt
  implements View.OnClickListener
{
  qt(MyPswSubPageActivity paramMyPswSubPageActivity) {}
  
  public final void onClick(View paramView)
  {
    if ((Integer)paramView.getTag() == null) {
      return;
    }
    af.a().d(0L, MyPswSubPageActivity.access$300(this.a));
    this.a.showUserDialog(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qt
 * JD-Core Version:    0.7.0.1
 */