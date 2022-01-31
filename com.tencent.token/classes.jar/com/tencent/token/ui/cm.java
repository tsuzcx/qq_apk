package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ag;
import com.tencent.token.aq;
import com.tencent.token.as;

final class cm
  implements View.OnClickListener
{
  cm(CorrectTokenActivity paramCorrectTokenActivity) {}
  
  public final void onClick(View paramView)
  {
    if (CorrectTokenActivity.access$500(this.a) == true)
    {
      ag.c().a.b.a();
      CorrectTokenActivity.access$502(this.a, false);
      this.a.startTimeTask();
    }
    this.a.showUserDialog(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cm
 * JD-Core Version:    0.7.0.1
 */