package com.tencent.token.ui.base;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class cr
  implements View.OnClickListener
{
  cr(SecondVerifyDialog paramSecondVerifyDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (SecondVerifyDialog.e(this.a) != null)
    {
      paramView = new Message();
      paramView.what = 1013;
      paramView.arg1 = SecondVerifyDialog.d(this.a);
      SecondVerifyDialog.e(this.a).sendMessage(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cr
 * JD-Core Version:    0.7.0.1
 */