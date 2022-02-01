package com.tencent.component.media.image.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

public class AspectAsyncImageView
  extends AsyncImageView
{
  public AspectAsyncImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AspectAsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AspectAsyncImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    Drawable localDrawable = getDrawable();
    float f;
    int m;
    int n;
    int k;
    int i4;
    int i5;
    int i2;
    int i3;
    if (localDrawable == null)
    {
      j = 0;
      f = 0.0F;
      m = 0;
      n = 0;
      k = 0;
      i4 = getPaddingLeft();
      i5 = getPaddingRight();
      i2 = getPaddingTop();
      i3 = getPaddingBottom();
      if ((m == 0) && (n == 0)) {
        break label338;
      }
      j = resolveSize(j + i4 + i5, paramInt1);
      i = resolveSize(k + i2 + i3, paramInt2);
      if ((f == 0.0F) || (Math.abs((j - i4 - i5) / (i - i2 - i3) - f) <= 1.0E-007D)) {
        break label410;
      }
      k = j;
      if (m == 0) {
        break label401;
      }
      int i1 = (int)((i - i2 - i3) * f) + i4 + i5;
      if (n != 0) {
        j = resolveSize(i1, paramInt1);
      }
      k = j;
      if (i1 > j) {
        break label401;
      }
      k = 1;
      paramInt1 = i1;
      label196:
      j = i;
      if (k != 0) {
        break label393;
      }
      j = i;
      if (n == 0) {
        break label393;
      }
      k = (int)((paramInt1 - i4 - i5) / f) + i2 + i3;
      if (m == 0) {
        i = resolveSize(k, paramInt2);
      }
      j = i;
      if (k > i) {
        break label393;
      }
      paramInt2 = paramInt1;
      paramInt1 = k;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      m = localDrawable.getIntrinsicWidth();
      k = localDrawable.getIntrinsicHeight();
      if (i != 1073741824)
      {
        i = 1;
        label293:
        if (j == 1073741824) {
          break label332;
        }
      }
      label332:
      for (j = 1;; j = 0)
      {
        f = m / k;
        n = j;
        j = m;
        m = i;
        break;
        i = 0;
        break label293;
      }
      label338:
      i = Math.max(j + (i4 + i5), getSuggestedMinimumWidth());
      j = Math.max(k + (i2 + i3), getSuggestedMinimumHeight());
      i = resolveSize(i, paramInt1);
      paramInt1 = resolveSize(j, paramInt2);
      paramInt2 = i;
      continue;
      label393:
      paramInt2 = paramInt1;
      paramInt1 = j;
      continue;
      label401:
      paramInt1 = k;
      k = 0;
      break label196;
      label410:
      paramInt2 = j;
      paramInt1 = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.view.AspectAsyncImageView
 * JD-Core Version:    0.7.0.1
 */