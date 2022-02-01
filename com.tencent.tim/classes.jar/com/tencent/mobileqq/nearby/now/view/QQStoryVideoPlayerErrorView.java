package com.tencent.mobileqq.nearby.now.view;

import acfp;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;

public class QQStoryVideoPlayerErrorView
  extends FrameLayout
{
  protected TextView Vh;
  protected TextView mTipsTextView;
  
  public QQStoryVideoPlayerErrorView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public QQStoryVideoPlayerErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public void RC(int paramInt)
  {
    this.mTipsTextView.setVisibility(0);
    this.Vh.setVisibility(8);
  }
  
  public void dzW()
  {
    this.Vh.setText(acfp.m(2131712492));
    this.Vh.setVisibility(0);
    this.mTipsTextView.setVisibility(8);
  }
  
  public void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559701, this, true);
    this.Vh = ((TextView)paramContext.findViewById(2131377222));
    this.mTipsTextView = ((TextView)paramContext.findViewById(2131379724));
  }
  
  public void setOnRetryClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Vh.setOnClickListener(paramOnClickListener);
    this.mTipsTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void setText(String paramString)
  {
    this.mTipsTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView
 * JD-Core Version:    0.7.0.1
 */