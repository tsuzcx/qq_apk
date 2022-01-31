package com.tencent.token.ui;

import android.view.View;
import android.widget.Button;
import com.tencent.token.widget.InputMethodRelativeLayout;
import com.tencent.token.widget.a;

class pb
  implements a
{
  pb(ModifyQQPwdActivity paramModifyQQPwdActivity) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      int[] arrayOfInt = new int[2];
      ModifyQQPwdActivity.access$200(this.a).getLocationInWindow(arrayOfInt);
      paramInt1 = arrayOfInt[1];
      this.a.mRootLayout.getLocationInWindow(arrayOfInt);
      paramInt1 = paramInt1 - arrayOfInt[1] + ModifyQQPwdActivity.access$200(this.a).getHeight() - paramInt2;
      if (paramInt1 > 0) {
        this.a.mScrollAreaLayout.setPadding(this.a.mScrollAreaLayout.getPaddingLeft(), this.a.mScrollAreaLayout.getPaddingTop() - paramInt1, this.a.mScrollAreaLayout.getPaddingRight(), this.a.mScrollAreaLayout.getPaddingBottom());
      }
      return;
    }
    this.a.mScrollAreaLayout.setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pb
 * JD-Core Version:    0.7.0.1
 */