package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import atau.a;

public class OCRBottomTabView
  extends LinearLayout
{
  private ImageView nv;
  private TextView tv;
  
  public OCRBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public OCRBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2131561514, this, true);
    this.tv = ((TextView)findViewById(2131380507));
    this.nv = ((ImageView)findViewById(2131369555));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rg);
    paramAttributeSet = paramContext.getString(1);
    Drawable localDrawable = paramContext.getDrawable(0);
    paramContext.recycle();
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      this.tv.setText(paramAttributeSet);
    }
    if (localDrawable != null) {
      this.nv.setImageDrawable(localDrawable);
    }
  }
  
  public CharSequence A()
  {
    return this.tv.getText();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.nv.setEnabled(paramBoolean);
    this.tv.setEnabled(paramBoolean);
  }
  
  public void setTabImage(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.nv.setImageDrawable(paramDrawable);
    }
  }
  
  public void setTabText(String paramString)
  {
    if (paramString != null) {
      this.tv.setText(paramString);
    }
  }
  
  public void setTabTextColor(int paramInt)
  {
    ColorStateList localColorStateList = ColorStateList.valueOf(paramInt);
    this.tv.setTextColor(localColorStateList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OCRBottomTabView
 * JD-Core Version:    0.7.0.1
 */