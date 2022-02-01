package com.tencent.mobileqq.profile.lifeachivement;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public class LayerImageView
  extends ImageView
{
  public LayerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LayerImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LayerImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getDrawable().setColorFilter(855638016, PorterDuff.Mode.SRC_ATOP);
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      getDrawable().clearColorFilter();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.lifeachivement.LayerImageView
 * JD-Core Version:    0.7.0.1
 */