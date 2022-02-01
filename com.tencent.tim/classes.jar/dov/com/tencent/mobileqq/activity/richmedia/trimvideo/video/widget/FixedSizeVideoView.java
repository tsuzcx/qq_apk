package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.AttributeSet;
import android.widget.VideoView;
import ayvn;
import ayvo;

public class FixedSizeVideoView
  extends VideoView
{
  public a a;
  private int byH = -1;
  private int ckH;
  private int ckI;
  private Runnable iT = new FixedSizeVideoView.1(this);
  
  public FixedSizeVideoView(Context paramContext)
  {
    super(paramContext);
    super.setOnCompletionListener(new ayvn(this));
  }
  
  public FixedSizeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnCompletionListener(new ayvo(this));
  }
  
  public void pause()
  {
    super.pause();
    removeCallbacks(this.iT);
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
      removeCallbacks(this.iT);
      postDelayed(this.iT, i);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(FixedSizeVideoView paramFixedSizeVideoView, int paramInt1, int paramInt2);
    
    public abstract void b(MediaPlayer paramMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView
 * JD-Core Version:    0.7.0.1
 */