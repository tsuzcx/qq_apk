package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import atau.a;
import com.tencent.mobileqq.widget.presseffect.PressEffectLinearLayout;

public class ReadInjoyMenuIconView
  extends PressEffectLinearLayout
{
  private int aYN;
  private String alr;
  private Drawable mIconDrawable;
  private int mIconHeight;
  private int mIconWidth;
  private int mTextColor;
  private int mTextSize;
  
  public ReadInjoyMenuIconView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInjoyMenuIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rF);
    this.mTextColor = paramContext.getColor(3, -16777216);
    this.mTextSize = paramContext.getDimensionPixelSize(5, 16);
    this.alr = paramContext.getString(6);
    this.aYN = paramContext.getDimensionPixelSize(4, 10);
    this.mIconWidth = paramContext.getDimensionPixelSize(2, 10);
    this.mIconHeight = paramContext.getDimensionPixelSize(1, 10);
    this.mIconDrawable = paramContext.getDrawable(0);
    paramContext.recycle();
  }
  
  private void initView(Context paramContext)
  {
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setGravity(17);
    paramContext = LayoutInflater.from(paramContext).inflate(2131560410, this);
    TextView localTextView = (TextView)paramContext.findViewById(2131381966);
    localTextView.setTextSize(0, this.mTextSize);
    localTextView.setTextColor(this.mTextColor);
    if (!TextUtils.isEmpty(this.alr)) {
      localTextView.setText(this.alr);
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
    localLayoutParams.topMargin = this.aYN;
    localTextView.setLayoutParams(localLayoutParams);
    paramContext = (KandianUrlImageView)paramContext.findViewById(2131381918);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.mIconWidth, this.mIconHeight));
    if (this.mIconDrawable != null) {
      paramContext.setImageDrawable(this.mIconDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyMenuIconView
 * JD-Core Version:    0.7.0.1
 */