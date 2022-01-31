package com.tencent.token.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.token.global.e;
import com.tencent.token.widget.InputMethodRelativeLayout;
import com.tencent.token.widget.a;

final class se
  implements a
{
  se(NetActiveVryQuesActivity paramNetActiveVryQuesActivity) {}
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      localObject = new int[2];
      this.a.mConfirmBtn.getLocationInWindow((int[])localObject);
      int i = localObject[1];
      this.a.mRootLayout.getLocationInWindow((int[])localObject);
      int j = localObject[1];
      if (NetActiveVryQuesActivity.access$1600(this.a))
      {
        NetActiveVryQuesActivity.access$1702(this.a, i);
        NetActiveVryQuesActivity.access$1802(this.a, j);
        NetActiveVryQuesActivity.access$1902(this.a, paramInt);
      }
      do
      {
        return;
        paramInt = NetActiveVryQuesActivity.access$1700(this.a);
        i = NetActiveVryQuesActivity.access$1800(this.a);
        j = NetActiveVryQuesActivity.access$1900(this.a);
        paramInt = paramInt - i + this.a.mConfirmBtn.getHeight() - j;
      } while (paramInt <= 0);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(this.a.mScrollAreaLayout.getPaddingLeft(), this.a.mScrollAreaLayout.getPaddingTop() - paramInt, this.a.mScrollAreaLayout.getPaddingRight(), this.a.mScrollAreaLayout.getPaddingBottom());
      this.a.mScrollAreaLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      e.c("mScrollAreaLayout.getPaddingTop()-paddingY = " + (this.a.mScrollAreaLayout.getPaddingTop() - paramInt) + "paddingY = " + paramInt);
      return;
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(this.a.mScrollAreaLayout.getPaddingLeft(), this.a.mScrollAreaLayout.getPaddingTop(), this.a.mScrollAreaLayout.getPaddingRight(), this.a.mScrollAreaLayout.getPaddingBottom());
    this.a.mScrollAreaLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.se
 * JD-Core Version:    0.7.0.1
 */