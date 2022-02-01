package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ReadInJoyTipsView
  extends LinearLayout
{
  public int aYG = 0;
  private RelativeLayout fn;
  private ImageView mArrowView;
  private ImageView mIconView;
  private View.OnClickListener mOnClickListener;
  private TextView mTipsTextView;
  
  public ReadInJoyTipsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2131560488, this);
  }
  
  private void initUI()
  {
    this.mIconView = ((ImageView)findViewById(2131376784));
    this.mTipsTextView = ((TextView)findViewById(2131376787));
    this.mArrowView = ((ImageView)findViewById(2131376786));
    this.fn = ((RelativeLayout)findViewById(2131376785));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    initUI();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.mOnClickListener = paramOnClickListener;
      return;
    }
    this.fn.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyTipsView
 * JD-Core Version:    0.7.0.1
 */