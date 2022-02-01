package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class BreathAnimationLayout
  extends RelativeLayout
{
  private long jdField_a_of_type_Long = -1L;
  private boolean jdField_a_of_type_Boolean = false;
  
  public BreathAnimationLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Drawable localDrawable = getBackground();
      if (localDrawable != null)
      {
        long l = AnimationUtils.currentAnimationTimeMillis();
        if (this.jdField_a_of_type_Long == -1L) {
          this.jdField_a_of_type_Long = l;
        }
        i = Math.min(255, (int)((Math.sin((l - this.jdField_a_of_type_Long) % 1600L / 1600.0D * 6.283185307179586D) + 1.0D) / 2.0D * 255.0D + 0.5D));
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
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Long = -1L;
      if (!paramBoolean) {
        refreshDrawableState();
      }
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout
 * JD-Core Version:    0.7.0.1
 */