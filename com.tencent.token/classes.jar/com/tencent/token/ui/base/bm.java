package com.tencent.token.ui.base;

import android.widget.ImageView;

class bm
  implements Runnable
{
  bm(LockPatternVerifyView paramLockPatternVerifyView) {}
  
  public void run()
  {
    if (LockPatternVerifyView.c(this.a) != null) {
      LockPatternVerifyView.d(this.a).setImageBitmap(LockPatternVerifyView.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bm
 * JD-Core Version:    0.7.0.1
 */