package com.tencent.qqmini.miniapp.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.NumberPicker;

@TargetApi(16)
public class MiniNumberPicker
  extends NumberPicker
{
  public MiniNumberPicker(Context paramContext)
  {
    super(paramContext);
  }
  
  public MiniNumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MiniNumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setEditTextStyle(View paramView)
  {
    if ((paramView instanceof EditText)) {
      ((EditText)paramView).setTextSize(1, 14.0F);
    }
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    setEditTextStyle(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    super.addView(paramView, paramInt);
    setEditTextStyle(paramView);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    super.addView(paramView, paramInt1, paramInt2);
    setEditTextStyle(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    setEditTextStyle(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramLayoutParams);
    setEditTextStyle(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.MiniNumberPicker
 * JD-Core Version:    0.7.0.1
 */