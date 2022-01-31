package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;

public class ChatThumbView
  extends URLImageView
{
  private static final int a = 100;
  public boolean a;
  
  public ChatThumbView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChatThumbView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setFadeInImage(false);
    if (this.a)
    {
      paramURLDrawable = new AlphaAnimation(0.0F, 1.0F);
      paramURLDrawable.setDuration(100L);
      startAnimation(paramURLDrawable);
      invalidate();
      return;
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (BaseBubbleBuilder.a)
    {
      int m = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt2);
      int n = View.MeasureSpec.getSize(paramInt1);
      int k = View.MeasureSpec.getSize(paramInt2);
      int i;
      if (m != -2147483648)
      {
        i = paramInt1;
        if (m != 1073741824) {}
      }
      else
      {
        i = paramInt1;
        if (n <= 0) {
          i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
      }
      if (j != -2147483648)
      {
        paramInt1 = paramInt2;
        if (j != 1073741824) {}
      }
      else
      {
        paramInt1 = paramInt2;
        if (k <= 0) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
      }
      super.onMeasure(i, paramInt1);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ChatThumbView
 * JD-Core Version:    0.7.0.1
 */