package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RemoteViews.RemoteView;

@RemoteViews.RemoteView
public class BreathAnimationLayout
  extends RelativeLayout
{
  private boolean mAnimating;
  private long mStartTime = -1L;
  
  public BreathAnimationLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public BreathAnimationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BreathAnimationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public void draw(Canvas paramCanvas)
  {
    if (this.mAnimating)
    {
      Drawable localDrawable = getBackground();
      if (localDrawable != null)
      {
        long l = AnimationUtils.currentAnimationTimeMillis();
        if (this.mStartTime == -1L) {
          this.mStartTime = l;
        }
        i = Math.min(255, (int)((Math.sin((l - this.mStartTime) % 1600L / 1600.0D * 6.283185307179586D) + 1.0D) / 2.0D * 255.0D + 0.5D));
        localDrawable.setBounds(0, 0, getWidth(), getHeight());
        localDrawable.setState(View.PRESSED_ENABLED_STATE_SET);
        localDrawable.draw(paramCanvas);
        if (Build.VERSION.SDK_INT <= 21) {
          break label159;
        }
      }
      label159:
      for (int i = paramCanvas.saveLayerAlpha(0.0F, 0.0F, getWidth(), getHeight(), i);; i = paramCanvas.saveLayerAlpha(0.0F, 0.0F, getWidth(), getHeight(), i, 20))
      {
        localDrawable.setState(View.EMPTY_STATE_SET);
        localDrawable.draw(paramCanvas);
        paramCanvas.restoreToCount(i);
        return;
      }
    }
    super.draw(paramCanvas);
  }
  
  public void setAnimating(boolean paramBoolean)
  {
    if (this.mAnimating != paramBoolean)
    {
      this.mAnimating = paramBoolean;
      this.mStartTime = -1L;
      if (!paramBoolean) {
        refreshDrawableState();
      }
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout
 * JD-Core Version:    0.7.0.1
 */