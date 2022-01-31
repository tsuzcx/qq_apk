package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.er;

class sx
  implements View.OnClickListener
{
  private sx(OpreateMsgActivity paramOpreateMsgActivity) {}
  
  public void onClick(View paramView)
  {
    if (OpreateMsgActivity.access$200(this.a).e() <= 0) {
      return;
    }
    OpreateMsgActivity.access$500(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sx
 * JD-Core Version:    0.7.0.1
 */