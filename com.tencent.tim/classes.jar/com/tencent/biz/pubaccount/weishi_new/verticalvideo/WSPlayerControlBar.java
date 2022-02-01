package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.view.RotationSeekBar;
import ooz;

public class WSPlayerControlBar
  extends RelativeLayout
{
  private final String TAG = "WS_VIDEO_seekBar";
  private RotationSeekBar a;
  private int aUC = 1;
  private boolean axY;
  private ImageView lv;
  
  public WSPlayerControlBar(Context paramContext)
  {
    super(paramContext);
    initUI(paramContext);
  }
  
  public WSPlayerControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI(paramContext);
  }
  
  public WSPlayerControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI(paramContext);
  }
  
  private void initUI(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560226, null);
    this.a = ((RotationSeekBar)paramContext.findViewById(2131381744));
    this.lv = ((ImageView)paramContext.findViewById(2131381745));
    this.a.setPadding(0, 0, 0, 0);
    this.a.setProgress(0);
    this.a.setMax(1000);
    addView(paramContext);
  }
  
  public void D(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public void J(Runnable paramRunnable)
  {
    if (this.a != null) {
      this.a.removeCallbacks(paramRunnable);
    }
  }
  
  public void bga()
  {
    if (this.lv != null)
    {
      this.lv.setVisibility(0);
      if (this.lv.getBackground() != null) {}
    }
    try
    {
      this.lv.setBackgroundResource(2130842643);
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.lv.getBackground();
      if (localAnimationDrawable != null)
      {
        localAnimationDrawable.setVisible(true, true);
        localAnimationDrawable.setOneShot(false);
        localAnimationDrawable.start();
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ooz.e("WS_VIDEO_seekBar", "showLoadingProgressBar error:" + localOutOfMemoryError);
      }
    }
  }
  
  public void bgb()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WSPlayerControlBar hideLoadingProgressBar() mProgressLoading:").append(this.lv).append(", getVisibility():");
    if (this.lv != null) {}
    for (Object localObject = Integer.valueOf(this.lv.getVisibility());; localObject = "null")
    {
      ooz.d("WS_VIDEO_ProgressBar", localObject);
      if (this.lv != null)
      {
        ooz.d("WS_VIDEO_ProgressBar", "WSPlayerControlBar hideLoadingProgressBar() hide");
        bgc();
        this.lv.setVisibility(8);
      }
      return;
    }
  }
  
  public void bgc()
  {
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.lv.getBackground();
    if ((localAnimationDrawable != null) && (localAnimationDrawable.isRunning()))
    {
      localAnimationDrawable.setOneShot(true);
      localAnimationDrawable.stop();
    }
  }
  
  public void f(Rect paramRect)
  {
    if (this.a != null) {
      this.a.getGlobalVisibleRect(paramRect);
    }
  }
  
  public void setNeedDeepClearScreen(boolean paramBoolean)
  {
    this.axY = paramBoolean;
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.a != null) {
      this.a.setProgress((int)(1000.0F * paramFloat));
    }
  }
  
  public void setSeekBarActivated(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setActivated(paramBoolean);
    }
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.a.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
  }
  
  public void setThumb(Drawable paramDrawable)
  {
    if (this.a != null) {
      this.a.setThumb(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar
 * JD-Core Version:    0.7.0.1
 */