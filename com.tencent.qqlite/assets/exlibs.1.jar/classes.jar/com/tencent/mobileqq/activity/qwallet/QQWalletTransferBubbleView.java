package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class QQWalletTransferBubbleView
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  LightingColorFilter jdField_a_of_type_AndroidGraphicsLightingColorFilter;
  boolean jdField_a_of_type_Boolean;
  
  public QQWalletTransferBubbleView(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  public QQWalletTransferBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  public QQWalletTransferBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsLightingColorFilter == null) {
      return;
    }
    Drawable localDrawable = getResources().getDrawable(this.jdField_a_of_type_Int);
    localDrawable.setBounds(0, 0, getWidth(), getHeight());
    localDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsLightingColorFilter);
    localDrawable.setAlpha(255);
    if (this.jdField_a_of_type_Boolean)
    {
      localDrawable.draw(paramCanvas);
      return;
    }
    paramCanvas.save();
    paramCanvas.scale(-1.0F, 1.0F, getWidth() / 2, getHeight() / 2);
    localDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setBubbleBackground(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidGraphicsLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView
 * JD-Core Version:    0.7.0.1
 */