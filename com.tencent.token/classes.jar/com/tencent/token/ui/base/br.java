package com.tencent.token.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.p;

final class br
  implements View.OnClickListener
{
  br(LockPatternVerifyView paramLockPatternVerifyView) {}
  
  public final void onClick(View paramView)
  {
    p.a().a(System.currentTimeMillis(), 26);
    if (LockPatternVerifyView.a(this.a) != null) {
      LockPatternVerifyView.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.br
 * JD-Core Version:    0.7.0.1
 */