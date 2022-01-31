package com.tencent.token.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;
import com.tencent.token.utils.t;

final class bg
  implements View.OnClickListener
{
  bg(IntroLoginMsgDialog paramIntroLoginMsgDialog) {}
  
  public final void onClick(View paramView)
  {
    e.a("intro dialog store2");
    t.h();
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bg
 * JD-Core Version:    0.7.0.1
 */