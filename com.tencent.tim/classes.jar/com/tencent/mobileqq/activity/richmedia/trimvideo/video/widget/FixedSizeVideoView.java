package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import aauu;
import aauv;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FixedSizeVideoView
  extends VideoView
  implements Handler.Callback
{
  public a a;
  private int byH = -1;
  private int ckH;
  private int ckI;
  private Handler mPlayHandler = new Handler(Looper.getMainLooper(), this);
  
  public FixedSizeVideoView(Context paramContext)
  {
    super(paramContext);
    super.setOnCompletionListener(new aauu(this));
  }
  
  public FixedSizeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnCompletionListener(new aauv(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.a != null) {
        this.a.a(this, this.ckI, this.byH);
      }
    }
  }
  
  public void pause()
  {
    super.pause();
    this.mPlayHandler.removeMessages(0);
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnFixVDPlayCompelteListener(a parama)
  {
    if (parama != null) {
      this.a = parama;
    }
  }
  
  public void setPlayDuration(int paramInt)
  {
    setPlayDuration(0, paramInt);
  }
  
  public void setPlayDuration(int paramInt1, int paramInt2)
  {
    try
    {
      int i = getDuration();
      if (paramInt1 >= i) {
        return;
      }
      int j = paramInt2 + paramInt1;
      this.ckH = j;
      if (j > i) {
        this.ckH = i;
      }
      this.ckI = paramInt1;
      this.byH = paramInt2;
      seekTo(paramInt1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void start()
  {
    int i = getCurrentPosition();
    i = this.ckH - i;
    if (i >= 0)
    {
      super.start();
      this.mPlayHandler.removeMessages(0);
      this.mPlayHandler.sendEmptyMessageDelayed(0, i);
    }
  }
  
  public int zh()
  {
    return this.byH;
  }
  
  public static abstract interface a
  {
    public abstract void a(FixedSizeVideoView paramFixedSizeVideoView, int paramInt1, int paramInt2);
    
    public abstract void b(MediaPlayer paramMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView
 * JD-Core Version:    0.7.0.1
 */