package com.tencent.biz.qqstory.playvideo;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ppf;
import ram;

public class QQStoryVideoPlayerErrorView
  extends RelativeLayout
{
  protected ImageView mE;
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
  
  public void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131562031, this, true);
    this.mTipsTextView = ((TextView)paramContext.findViewById(2131379724));
    this.mE = ((ImageView)paramContext.findViewById(2131369705));
  }
  
  public void setCloseViewVisibility(boolean paramBoolean)
  {
    ImageView localImageView = this.mE;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mE.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTipsClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mTipsTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void setTipsIcon(int paramInt)
  {
    try
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      this.mTipsTextView.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ram.w("QQStoryVideoPlayerErrorView", "oom ,set tips error");
    }
  }
  
  public void setTipsText(String paramString)
  {
    this.mTipsTextView.setText(paramString);
  }
  
  public void setTipsTextSize(float paramFloat)
  {
    this.mTipsTextView.setTextSize(1, paramFloat);
  }
  
  public void wh(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mTipsTextView.setVisibility(0);
      setTipsText(ppf.getString(2131701953));
      setTipsIcon(2130847282);
      setTipsTextSize(16.0F);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.mTipsTextView.setVisibility(0);
        setTipsText(acfp.m(2131712493));
        setTipsIcon(2130847440);
        setTipsTextSize(14.0F);
        return;
      }
    } while (paramInt != 2);
    this.mTipsTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView
 * JD-Core Version:    0.7.0.1
 */