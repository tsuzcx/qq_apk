package com.tencent.av.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.SeekBar;
import jlz;

public class BidirectionSeekBar
  extends SeekBar
{
  private int height;
  private int width;
  
  public BidirectionSeekBar(Context paramContext)
  {
    super(paramContext);
    initDrawable();
  }
  
  public BidirectionSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initDrawable();
  }
  
  public BidirectionSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initDrawable();
  }
  
  @TargetApi(11)
  private void initDrawable()
  {
    if (getThumbOffset() != 0) {
      setThumbOffset(0);
    }
    int i = getResources().getDrawable(2130842798).getIntrinsicWidth();
    Object localObject = getProgressDrawable();
    if ((localObject instanceof LayerDrawable))
    {
      localObject = (LayerDrawable)localObject;
      Drawable localDrawable = ((LayerDrawable)localObject).findDrawableByLayerId(16908301);
      jlz localjlz = new jlz(getResources().getDrawable(2130842790), getResources().getDrawable(2130842793), 1, i);
      localjlz.setLevel(localDrawable.getLevel());
      ((LayerDrawable)localObject).setDrawableByLayerId(16908301, localjlz);
    }
    if (Build.VERSION.SDK_INT >= 11) {}
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setThumb(Drawable paramDrawable)
  {
    super.setThumb(paramDrawable);
    setThumbOffset(0);
    onSizeChanged(this.width, this.height, this.width, this.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.widget.BidirectionSeekBar
 * JD-Core Version:    0.7.0.1
 */