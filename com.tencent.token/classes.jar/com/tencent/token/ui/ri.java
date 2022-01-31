package com.tencent.token.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.token.global.h;
import com.tencent.token.widget.InputMethodRelativeLayout;
import com.tencent.token.widget.a;

class ri
  implements a
{
  ri(NetActiveVryQuesActivity paramNetActiveVryQuesActivity) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      localObject = new int[2];
      this.a.mConfirmBtn.getLocationInWindow((int[])localObject);
      paramInt1 = localObject[1];
      this.a.mRootLayout.getLocationInWindow((int[])localObject);
      int i = localObject[1];
      if (NetActiveVryQuesActivity.access$1300(this.a))
      {
        NetActiveVryQuesActivity.access$1402(this.a, paramInt1);
        NetActiveVryQuesActivity.access$1502(this.a, i);
        NetActiveVryQuesActivity.access$1602(this.a, paramInt2);
      }
      do
      {
        return;
        paramInt1 = NetActiveVryQuesActivity.access$1400(this.a);
        paramInt2 = NetActiveVryQuesActivity.access$1500(this.a);
        i = NetActiveVryQuesActivity.access$1600(this.a);
        paramInt1 = paramInt1 - paramInt2 + this.a.mConfirmBtn.getHeight() - i;
      } while (paramInt1 <= 0);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(this.a.mScrollAreaLayout.getPaddingLeft(), this.a.mScrollAreaLayout.getPaddingTop() - paramInt1, this.a.mScrollAreaLayout.getPaddingRight(), this.a.mScrollAreaLayout.getPaddingBottom());
      this.a.mScrollAreaLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      h.c("mScrollAreaLayout.getPaddingTop()-paddingY = " + (this.a.mScrollAreaLayout.getPaddingTop() - paramInt1) + "paddingY = " + paramInt1);
      return;
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(this.a.mScrollAreaLayout.getPaddingLeft(), this.a.mScrollAreaLayout.getPaddingTop(), this.a.mScrollAreaLayout.getPaddingRight(), this.a.mScrollAreaLayout.getPaddingBottom());
    this.a.mScrollAreaLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ri
 * JD-Core Version:    0.7.0.1
 */