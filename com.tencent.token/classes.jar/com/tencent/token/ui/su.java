package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.s;

final class su
  implements View.OnClickListener
{
  su(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public final void onClick(View paramView)
  {
    if (OpMsgDisplayActivity.access$200(this.a) == 1)
    {
      s.b(this.a, this.a.getString(2131361985));
      return;
    }
    s.b(this.a, this.a.getString(2131361982));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.su
 * JD-Core Version:    0.7.0.1
 */