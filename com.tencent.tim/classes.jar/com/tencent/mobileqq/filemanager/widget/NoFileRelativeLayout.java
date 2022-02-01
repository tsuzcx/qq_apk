package com.tencent.mobileqq.filemanager.widget;

import ahcy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aobw;

public class NoFileRelativeLayout
  extends RelativeLayout
{
  View Dl;
  TextView Ti;
  Context context;
  private View.OnClickListener fd;
  ImageView imageView;
  int mHeight = 0;
  int mWidth = 0;
  LinearLayout rootView = null;
  TextView textView;
  
  public NoFileRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NoFileRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NoFileRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561017, this);
    this.rootView = ((LinearLayout)paramAttributeSet.findViewById(2131372448));
    this.textView = ((TextView)paramAttributeSet.findViewById(2131379419));
    this.Ti = ((TextView)paramAttributeSet.findViewById(2131379433));
    this.fd = new ahcy(this);
    aobw.a(this.Ti, this.fd);
    this.Ti.setVisibility(8);
    this.imageView = ((ImageView)paramAttributeSet.findViewById(2131368846));
    this.Dl = paramAttributeSet.findViewById(2131380067);
    this.context = paramContext;
  }
  
  public void dmx()
  {
    this.Ti.setVisibility(0);
  }
  
  public void dmy()
  {
    this.Ti.setVisibility(8);
  }
  
  public void setGone()
  {
    this.rootView.setVisibility(8);
    this.textView.setVisibility(8);
    this.imageView.setVisibility(8);
  }
  
  public void setImageViewBackGround(int paramInt)
  {
    this.imageView.setImageResource(paramInt);
  }
  
  public void setLayoutParams(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 20)) {}
    while ((this.mWidth == paramInt1) && (this.mHeight == paramInt2)) {
      return;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight - 20);
    this.rootView.setLayoutParams(localLayoutParams);
    this.rootView.invalidate();
  }
  
  public void setText(int paramInt)
  {
    this.textView.setText(paramInt);
  }
  
  public void setTextLeftDrawable(int paramInt)
  {
    Drawable localDrawable = this.context.getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.textView.setCompoundDrawables(localDrawable, null, null, null);
  }
  
  public void setTopViewHeight(float paramFloat)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Dl.getLayoutParams();
    localLayoutParams.weight = paramFloat;
    this.Dl.setLayoutParams(localLayoutParams);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.rootView.setVisibility(0);
      this.textView.setVisibility(0);
      this.imageView.setVisibility(0);
      return;
    }
    this.rootView.setVisibility(4);
    this.textView.setVisibility(4);
    this.imageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout
 * JD-Core Version:    0.7.0.1
 */