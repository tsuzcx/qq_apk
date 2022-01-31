package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.w;

class rz
  implements View.OnClickListener
{
  rz(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public void onClick(View paramView)
  {
    if (OpMsgDisplayActivity.access$200(this.a) == 1)
    {
      w.b(this.a, this.a.getString(2131231285));
      return;
    }
    w.b(this.a, this.a.getString(2131231489));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rz
 * JD-Core Version:    0.7.0.1
 */