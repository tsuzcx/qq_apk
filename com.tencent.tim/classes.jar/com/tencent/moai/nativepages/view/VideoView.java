package com.tencent.moai.nativepages.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.moai.nativepages.util.DataUtil;

public class VideoView
  extends FrameLayout
{
  private String cid;
  private ViewGroup controlArea;
  private TextView durationTv;
  private boolean isPlaying = false;
  private long maxPlayPosition;
  private boolean pauseByUser = false;
  private ImageView playStateBtn;
  private TextView positionTv;
  private ProgressBar progressBar;
  private SeekBar seekbar;
  private ImageView soundBtn;
  private boolean soundOn = false;
  private SurfaceView surfaceView;
  private long videoDuration;
  private VideoPlayer videoPlayer;
  private long videoPosition;
  
  public VideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }
  
  private String formatTimeString(long paramLong)
  {
    int j = (int)(paramLong / 1000L);
    int i = j / 60;
    j %= 60;
    String str1;
    if (i > 9)
    {
      str1 = "" + i;
      if (j <= 9) {
        break label127;
      }
    }
    label127:
    for (String str2 = "" + j;; str2 = "0" + j)
    {
      return str1 + ":" + str2;
      str1 = "0" + i;
      break;
    }
  }
  
  private void reset()
  {
    this.videoPlayer.seekTo(0);
    this.videoPlayer.pause();
    this.positionTv.setText(formatTimeString(0L));
    this.seekbar.setProgress(0);
    this.playStateBtn.setImageResource(2130851866);
  }
  
  public void hideControlArea()
  {
    this.controlArea.setBackgroundColor(0);
    this.positionTv.setVisibility(4);
    this.durationTv.setVisibility(4);
    this.seekbar.setVisibility(4);
    this.playStateBtn.setVisibility(4);
  }
  
  public void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    LayoutInflater.from(paramContext).inflate(2131563317, this);
    this.controlArea = ((ViewGroup)findViewById(2131365405));
    this.controlArea.setOnTouchListener(new VideoView.1(this));
    this.durationTv = ((TextView)findViewById(2131377101));
    this.positionTv = ((TextView)findViewById(2131373401));
    this.seekbar = ((SeekBar)findViewById(2131377920));
    this.progressBar = ((ProgressBar)findViewById(2131373700));
    this.seekbar.setMax(100);
    this.seekbar.setOnTouchListener(new VideoView.2(this));
    this.playStateBtn = ((ImageView)findViewById(2131373368));
    this.playStateBtn.setOnClickListener(new VideoView.3(this));
    this.soundBtn = ((ImageView)findViewById(2131378571));
    this.soundBtn.setOnClickListener(new VideoView.4(this));
    this.surfaceView = ((SurfaceView)findViewById(2131379020));
    this.videoPlayer = new VideoPlayer(this.surfaceView);
    this.videoPlayer.setVideoStateCallback(new VideoView.5(this));
  }
  
  public boolean isPauseByUser()
  {
    return this.pauseByUser;
  }
  
  public boolean isPlaying()
  {
    return this.isPlaying;
  }
  
  public void pause()
  {
    this.isPlaying = false;
    this.videoPlayer.pause();
    this.playStateBtn.setImageResource(2130851866);
    DataUtil.collect(this.cid, "Event_Native_AD_Component_Stream_Video_Pause_Click", 1L);
  }
  
  public void play(String paramString)
  {
    this.isPlaying = true;
    if (!this.videoPlayer.isSurfaceDestroy())
    {
      if (this.videoPosition != 0L) {
        break label60;
      }
      this.videoPlayer.play(paramString);
      soundOn(this.soundOn);
    }
    for (;;)
    {
      DataUtil.collect(this.cid, "Event_Native_AD_Component_Stream_Video_Play_Count", 1L);
      this.playStateBtn.setImageResource(2130851865);
      return;
      label60:
      resume();
    }
  }
  
  public void resume()
  {
    this.isPlaying = true;
    this.videoPlayer.toggleSound(this.soundOn);
    this.videoPlayer.resume();
    this.playStateBtn.setImageResource(2130851865);
  }
  
  public void setCid(String paramString)
  {
    this.cid = paramString;
  }
  
  public void setPlaying(boolean paramBoolean)
  {
    this.isPlaying = paramBoolean;
  }
  
  public void soundOn(boolean paramBoolean)
  {
    this.soundOn = paramBoolean;
    this.videoPlayer.toggleSound(paramBoolean);
    if (paramBoolean)
    {
      this.soundBtn.setImageResource(2130851868);
      return;
    }
    this.soundBtn.setImageResource(2130851867);
  }
  
  public void stop()
  {
    this.videoPosition = 0L;
    this.playStateBtn.setImageResource(2130851866);
    if (this.videoPlayer.isStop())
    {
      DataUtil.collect(this.cid, "Event_Native_AD_Component_Stream_Video_Length", this.videoDuration);
      this.maxPlayPosition = Math.min(this.videoDuration, this.maxPlayPosition);
      DataUtil.collect(this.cid, "Event_Native_AD_Component_Stream_Video_Play_Time", this.maxPlayPosition);
    }
    this.isPlaying = false;
    this.videoPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.VideoView
 * JD-Core Version:    0.7.0.1
 */