package com.tencent.token.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;

class bk
  implements View.OnClickListener
{
  bk(LockPatternVerifyView paramLockPatternVerifyView) {}
  
  public void onClick(View paramView)
  {
    ch.a().a(System.currentTimeMillis(), 26);
    if (LockPatternVerifyView.a(this.a) != null) {
      LockPatternVerifyView.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bk
 * JD-Core Version:    0.7.0.1
 */