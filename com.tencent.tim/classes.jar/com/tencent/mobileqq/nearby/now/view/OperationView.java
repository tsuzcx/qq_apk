package com.tencent.mobileqq.nearby.now.view;

import ajzv;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class OperationView
  extends FrameLayout
{
  ajzv a;
  public QQAppInterface app;
  VideoData b;
  
  public OperationView(Context paramContext)
  {
    super(paramContext);
  }
  
  public OperationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OperationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void Mu(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    this.a.Mu(paramBoolean);
  }
  
  public ajzv a()
  {
    return this.a;
  }
  
  public void b(VideoData paramVideoData)
  {
    this.b = paramVideoData;
    this.a.d(paramVideoData);
  }
  
  public void destroy()
  {
    this.a.destroy();
  }
  
  public void dzV()
  {
    if (this.b.type != 4) {
      this.a.dzV();
    }
  }
  
  public void init()
  {
    this.a = new ajzv(LayoutInflater.from(getContext()).inflate(2131561463, this, true), this.app);
  }
  
  public void setCurrentAnchorUin(long paramLong)
  {
    if (this.a != null) {
      this.a.setCurrentAnchorUin(paramLong);
    }
  }
  
  public void setOnCloseListener(StuffContainerView.b paramb)
  {
    if (this.a != null) {
      this.a.setOnCloseListener(paramb);
    }
  }
  
  public void setOnCommentClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.a != null) {
      this.a.setOnCommentClickListener(paramOnClickListener);
    }
  }
  
  public void setVideoPageSource(int paramInt)
  {
    this.a.setVideoPageSource(paramInt);
  }
  
  public void setWatchCount(int paramInt)
  {
    if (this.b == null) {}
    while (this.b.type == 1) {
      return;
    }
    this.a.setWatchCount(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.OperationView
 * JD-Core Version:    0.7.0.1
 */