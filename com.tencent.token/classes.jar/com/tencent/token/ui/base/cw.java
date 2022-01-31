package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.UserTask;

final class cw
  implements View.OnClickListener
{
  cw(SecondVerifyDialog paramSecondVerifyDialog) {}
  
  public final void onClick(View paramView)
  {
    if (SecondVerifyDialog.a(this.a)) {
      return;
    }
    SecondVerifyDialog.a(this.a, true);
    if (this.a.a != null)
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    this.a.a = new ProDialog(SecondVerifyDialog.b(this.a), SecondVerifyDialog.b(this.a).getResources().getString(2131361918));
    this.a.a.show();
    new cx(this).a(new String[] { "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cw
 * JD-Core Version:    0.7.0.1
 */