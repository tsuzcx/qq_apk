package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import atau.a;
import com.tencent.image.URLImageView;

public class TintableImageView
  extends URLImageView
{
  ColorStateList s;
  
  public TintableImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TintableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet, 0);
  }
  
  public TintableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }
  
  private void exv()
  {
    setColorFilter(this.s.getColorForState(getDrawableState(), 0));
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sy, paramInt, 0);
    this.s = paramContext.getColorStateList(0);
    paramContext.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.s != null) && (this.s.isStateful())) {
      exv();
    }
  }
  
  public void setColorFilter(ColorStateList paramColorStateList)
  {
    this.s = paramColorStateList;
    super.setColorFilter(paramColorStateList.getColorForState(getDrawableState(), 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.TintableImageView
 * JD-Core Version:    0.7.0.1
 */