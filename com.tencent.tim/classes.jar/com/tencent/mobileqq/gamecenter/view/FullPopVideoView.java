package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FullPopVideoView
  extends FrameLayout
{
  private a a;
  
  public FullPopVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FullPopVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setListener(a parama)
  {
    this.a = parama;
  }
  
  public void stop() {}
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.FullPopVideoView
 * JD-Core Version:    0.7.0.1
 */