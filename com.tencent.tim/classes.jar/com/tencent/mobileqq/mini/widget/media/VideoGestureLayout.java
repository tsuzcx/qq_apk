package com.tencent.mobileqq.mini.widget.media;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class VideoGestureLayout
  extends RelativeLayout
{
  private static final String TAG = "VideoGestureLayout";
  private int duration = 1000;
  private ImageView iv_center;
  private HideRunnable mHideRunnable;
  private ProgressBar pb;
  
  public VideoGestureLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public VideoGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559609, this);
    this.iv_center = ((ImageView)findViewById(2131369691));
    this.pb = ((ProgressBar)findViewById(2131372940));
    this.mHideRunnable = new HideRunnable(null);
    setVisibility(8);
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    this.iv_center.setImageResource(paramInt);
  }
  
  public void setProgress(int paramInt)
  {
    this.pb.setProgress(paramInt);
    Log.d("VideoGestureLayout", "setProgress: " + paramInt);
  }
  
  public void show()
  {
    setVisibility(0);
    removeCallbacks(this.mHideRunnable);
    postDelayed(this.mHideRunnable, this.duration);
  }
  
  class HideRunnable
    implements Runnable
  {
    private HideRunnable() {}
    
    public void run()
    {
      VideoGestureLayout.this.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.VideoGestureLayout
 * JD-Core Version:    0.7.0.1
 */