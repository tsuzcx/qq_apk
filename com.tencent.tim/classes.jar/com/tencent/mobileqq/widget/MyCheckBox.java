package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.CompoundButton;

public class MyCheckBox
  extends CompoundButton
{
  private Paint aJ = new Paint();
  private Bitmap gL;
  private Drawable gj;
  
  public MyCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MyCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842860);
  }
  
  public MyCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.gj != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.gj.setState(arrayOfInt);
      invalidate();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    return 0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Drawable localDrawable = this.gj;
    int j;
    int i;
    if (localDrawable != null)
    {
      int k = getGravity();
      j = localDrawable.getIntrinsicHeight();
      i = 0;
      switch (k & 0x70)
      {
      }
    }
    for (;;)
    {
      localDrawable.setBounds(getWidth() - localDrawable.getIntrinsicWidth(), i, getWidth(), i + j);
      localDrawable.draw(paramCanvas);
      if (this.gL == null) {
        this.gL = BitmapFactory.decodeResource(getResources(), 2130851506);
      }
      if (!isChecked()) {
        break;
      }
      this.aJ.setColor(-1);
      f = getResources().getDisplayMetrics().density;
      this.aJ.setTextSize(getResources().getDimension(2131297359));
      this.aJ.setAntiAlias(true);
      this.aJ.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(getResources().getString(2131721087), getWidth() - localDrawable.getIntrinsicWidth() * 2 / 3 - 2.0F * f, f * 4.0F + (j / 2 + i), this.aJ);
      paramCanvas.drawBitmap(this.gL, getWidth() - this.gL.getWidth(), i, null);
      return;
      i = getHeight() - j;
      continue;
      i = (getHeight() - j) / 2;
    }
    this.aJ.setColor(-8814455);
    float f = getResources().getDisplayMetrics().density;
    this.aJ.setTextSize(getResources().getDimension(2131297359));
    this.aJ.setAntiAlias(true);
    this.aJ.setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawText(getResources().getString(2131721086), getWidth() - localDrawable.getIntrinsicWidth() / 3 + 2.0F * f, f * 4.0F + (j / 2 + i), this.aJ);
    paramCanvas.drawBitmap(this.gL, getWidth() - localDrawable.getIntrinsicWidth(), i, null);
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (this.gj != null)
      {
        this.gj.setCallback(null);
        unscheduleDrawable(this.gj);
      }
      paramDrawable.setCallback(this);
      paramDrawable.setState(getDrawableState());
      if (getVisibility() != 0) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.gj = paramDrawable;
      setMinHeight(this.gj.getIntrinsicHeight());
      refreshDrawableState();
      return;
    }
  }
  
  public void setButtonGray(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.gj.setAlpha(255);
      return;
    }
    this.gj.setAlpha(128);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.gj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MyCheckBox
 * JD-Core Version:    0.7.0.1
 */