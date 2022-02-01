package com.tencent.biz.qqstory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

@TargetApi(14)
public class PressDarkImageView
  extends URLImageView
{
  public static final int[] ATTRS = { 16843210, 16843211 };
  public int mSource = 0;
  public float nR = 1.0F;
  public float nS = 0.5F;
  
  public PressDarkImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PressDarkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressDarkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    this.nR = paramContext.getFloat(0, this.nR);
    this.nS = paramContext.getFloat(1, this.nS);
    paramContext.recycle();
  }
  
  public void bvX()
  {
    if (this.mSource == 1)
    {
      super.clearColorFilter();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setImageAlpha((int)(this.nR * 255.0F));
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.nR);
      return;
    }
    super.clearColorFilter();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (isPressed())
    {
      if (this.mSource == 1)
      {
        super.setColorFilter(436207616);
        return;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        super.setImageAlpha((int)(this.nS * 255.0F));
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.setAlpha(this.nS);
        return;
      }
      super.setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
      return;
    }
    bvX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.PressDarkImageView
 * JD-Core Version:    0.7.0.1
 */