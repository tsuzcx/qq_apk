package com.tencent.token.ui;

import android.view.View;
import android.widget.Button;
import com.tencent.token.widget.InputMethodRelativeLayout;
import com.tencent.token.widget.a;

final class pq
  implements a
{
  pq(ModifyQQPwdActivity paramModifyQQPwdActivity) {}
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      int[] arrayOfInt = new int[2];
      ModifyQQPwdActivity.access$200(this.a).getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1];
      this.a.mRootLayout.getLocationInWindow(arrayOfInt);
      paramInt = i - arrayOfInt[1] + ModifyQQPwdActivity.access$200(this.a).getHeight() - paramInt;
      if (paramInt > 0) {
        this.a.mScrollAreaLayout.setPadding(this.a.mScrollAreaLayout.getPaddingLeft(), this.a.mScrollAreaLayout.getPaddingTop() - paramInt, this.a.mScrollAreaLayout.getPaddingRight(), this.a.mScrollAreaLayout.getPaddingBottom());
      }
      return;
    }
    this.a.mScrollAreaLayout.setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pq
 * JD-Core Version:    0.7.0.1
 */