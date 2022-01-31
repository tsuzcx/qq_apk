package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.cx;
import com.tencent.token.dh;
import com.tencent.token.dj;

class db
  implements View.OnClickListener
{
  db(CorrectTokenActivity paramCorrectTokenActivity) {}
  
  public void onClick(View paramView)
  {
    if (CorrectTokenActivity.access$500(this.a) == true)
    {
      cx.c().a.b.a(86630087L);
      CorrectTokenActivity.access$502(this.a, false);
      this.a.startTimeTask();
    }
    this.a.showUserDialog(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.db
 * JD-Core Version:    0.7.0.1
 */