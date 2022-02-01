package com.tencent.qqmail.view.listscroller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class FreeRelativeLayout
  extends RelativeLayout
{
  public FreeRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @SuppressLint({"WrongCall"})
  public void layoutSelf(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @SuppressLint({"WrongCall"})
  public void measureSelf(int paramInt1, int paramInt2)
  {
    onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.listscroller.FreeRelativeLayout
 * JD-Core Version:    0.7.0.1
 */