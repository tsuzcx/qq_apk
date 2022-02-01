package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;

public class AnyScaleTypeImageView
  extends URLTextImageView
{
  private a a;
  private boolean bzJ;
  
  public AnyScaleTypeImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnyScaleTypeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnyScaleTypeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setDisplayRuleDef(a parama)
  {
    this.a = parama;
    if (parama != null) {
      setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.bzJ = true;
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.a != null)
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      setImageMatrix(this.a.a(localDrawable, paramInt3 - paramInt1 - i - j, paramInt4 - paramInt2 - k - m));
    }
    return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((this.bzJ) && (paramDrawable != null) && (this.a != null))
    {
      int i = getWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setImageMatrix(this.a.a(paramDrawable, i - j - k, m - n - i1));
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public static abstract interface a
  {
    public abstract Matrix a(Drawable paramDrawable, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnyScaleTypeImageView
 * JD-Core Version:    0.7.0.1
 */