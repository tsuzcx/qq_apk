package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;

final class sp
  implements View.OnClickListener
{
  sp(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public final void onClick(View paramView)
  {
    af.a().k(0L, OpMsgDisplayActivity.access$300(this.a));
    this.a.showUserDialog(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sp
 * JD-Core Version:    0.7.0.1
 */