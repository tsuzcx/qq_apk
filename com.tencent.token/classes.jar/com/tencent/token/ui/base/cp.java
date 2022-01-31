package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.utils.UserTask;

class cp
  implements View.OnClickListener
{
  cp(SecondVerifyDialog paramSecondVerifyDialog) {}
  
  public void onClick(View paramView)
  {
    if (SecondVerifyDialog.a(this.a)) {
      return;
    }
    if (SecondVerifyDialog.b(this.a) != null) {
      SecondVerifyDialog.b(this.a).clearFocus();
    }
    SecondVerifyDialog.a(this.a, true);
    if (this.a.a != null)
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    this.a.a = new ProDialog(SecondVerifyDialog.c(this.a), 2131362182, SecondVerifyDialog.c(this.a).getResources().getString(2131231392));
    this.a.a.show();
    new cq(this).c(new String[] { "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cp
 * JD-Core Version:    0.7.0.1
 */