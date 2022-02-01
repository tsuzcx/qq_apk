package com.tencent.token.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class InputMethodRelativeLayout
  extends RelativeLayout
{
  public a a;
  private int b;
  private int c;
  private int d;
  private int e;
  private boolean f = false;
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
    this.d = paramContext.getWidth();
    this.e = paramContext.getHeight();
  }
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a != null) && (paramInt1 == paramInt3) && (paramInt3 != 0) && (paramInt4 != 0)) {
      if ((paramInt2 >= paramInt4) || (Math.abs(paramInt2 - paramInt4) <= 50)) {
        break label87;
      }
    }
    for (this.f = true;; this.f = false)
    {
      this.a.a(this.f, paramInt4, paramInt2);
      measure(this.b - paramInt1 + getWidth(), this.c - paramInt2 + getHeight());
      label87:
      do
      {
        return;
      } while ((paramInt2 <= paramInt4) || (Math.abs(paramInt2 - paramInt4) <= 50));
    }
  }
  
  public void setOnSizeChangedListenner(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.InputMethodRelativeLayout
 * JD-Core Version:    0.7.0.1
 */