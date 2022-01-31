package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.fo;

final class tt
  implements View.OnClickListener
{
  private tt(OpreateMsgActivity paramOpreateMsgActivity, byte paramByte) {}
  
  public final void onClick(View paramView)
  {
    if (OpreateMsgActivity.access$200(this.a).e() <= 0) {
      return;
    }
    OpreateMsgActivity.access$500(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tt
 * JD-Core Version:    0.7.0.1
 */