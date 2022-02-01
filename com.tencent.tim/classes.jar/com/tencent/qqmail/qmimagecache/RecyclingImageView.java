package com.tencent.qqmail.qmimagecache;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RecyclingImageView
  extends ImageView
{
  public RecyclingImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecyclingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void notifyDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    if ((paramDrawable instanceof RecyclingBitmapDrawable)) {
      ((RecyclingBitmapDrawable)paramDrawable).setIsDisplayed(paramBoolean);
    }
    for (;;)
    {
      return;
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int i = 0;
        int j = paramDrawable.getNumberOfLayers();
        while (i < j)
        {
          notifyDrawable(paramDrawable.getDrawable(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    setImageDrawable(null);
    super.onDetachedFromWindow();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = getDrawable();
    super.setImageDrawable(paramDrawable);
    notifyDrawable(paramDrawable, true);
    notifyDrawable(localDrawable, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.RecyclingImageView
 * JD-Core Version:    0.7.0.1
 */