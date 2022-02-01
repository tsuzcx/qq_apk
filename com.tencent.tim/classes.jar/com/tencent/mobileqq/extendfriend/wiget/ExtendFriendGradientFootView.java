package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ExtendFriendGradientFootView
  extends View
{
  LinearGradient h;
  private Paint paint = new Paint();
  
  public ExtendFriendGradientFootView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendGradientFootView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendGradientFootView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paint);
  }
  
  public void setColor(int paramInt)
  {
    this.h = new LinearGradient(0.0F, 0.0F, 0.0F, getHeight(), 0, paramInt, Shader.TileMode.CLAMP);
    this.paint.setShader(this.h);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendGradientFootView
 * JD-Core Version:    0.7.0.1
 */