package com.tencent.mobileqq.qzoneplayer.ui;

import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.PlayerCallBack;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.Set;

class VideoControllerView$6
  implements SeekBar.OnSeekBarChangeListener
{
  private int mDestProgress;
  private int mStartProgress;
  
  VideoControllerView$6(VideoControllerView paramVideoControllerView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (VideoControllerView.access$200(this.this$0) != null) {
      VideoControllerView.access$200(this.this$0).onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    }
    if (this.this$0.mPlayer == null) {}
    do
    {
      return;
      for (;;)
      {
        this.mDestProgress = paramSeekBar.getProgress();
        if (this.mDestProgress < this.mStartProgress) {
          break;
        }
        if (this.this$0.mPlayer.canSeekForward()) {
          if (paramBoolean)
          {
            int i = this.this$0.mPlayer.getDuration();
            if (i > 0) {
              this.this$0.mVideoDuration = i;
            }
            long l = i * paramInt / 1000L;
            if (VideoControllerView.access$100(this.this$0) != null) {
              VideoControllerView.access$100(this.this$0).setText(this.this$0.mPlayer.time2str((int)l));
            }
            paramSeekBar = PlayerConfig.g().getCallbacks();
            if (paramSeekBar != null)
            {
              paramSeekBar = paramSeekBar.iterator();
              while (paramSeekBar.hasNext())
              {
                PlayerCallBack localPlayerCallBack = (PlayerCallBack)paramSeekBar.next();
                if (localPlayerCallBack != null) {
                  localPlayerCallBack.onMediaEvent(localPlayerCallBack, PlayerCallBack.EVENT_SEEK_BAR_ON_SEEK, null, null);
                }
              }
            }
          }
        }
      }
    } while (this.this$0.mPlayer.canSeekBackward());
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (VideoControllerView.access$200(this.this$0) != null) {
      VideoControllerView.access$200(this.this$0).onStartTrackingTouch(paramSeekBar);
    }
    this.mStartProgress = paramSeekBar.getProgress();
    if (PlayerConfig.g().getVideoReporter() != null)
    {
      if (this.this$0.mPlayer == null) {
        break label153;
      }
      paramSeekBar = PlayerUtils.getVideoUuidFromVideoUrl(this.this$0.mPlayer.getVideoUriWithUuid());
      PlayerConfig.g().getVideoReporter().progressBarSeekingBegin(paramSeekBar, this.this$0.mPlayer.getCurrentPosition(), this.this$0.mPlayer.isPlaying());
    }
    for (;;)
    {
      paramSeekBar = PlayerConfig.g().getCallbacks();
      if (paramSeekBar == null) {
        break;
      }
      paramSeekBar = paramSeekBar.iterator();
      while (paramSeekBar.hasNext())
      {
        PlayerCallBack localPlayerCallBack = (PlayerCallBack)paramSeekBar.next();
        localPlayerCallBack.onMediaEvent(localPlayerCallBack, PlayerCallBack.EVENT_SEEK_BAR_START_SEEK, null, null);
      }
      label153:
      PlayerConfig.g().getVideoReporter().progressBarSeekingBegin(null, -1L, false);
    }
    this.this$0.show(3600000);
    VideoControllerView.access$302(this.this$0, true);
    this.this$0.mHandler.removeMessages(2);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (VideoControllerView.access$200(this.this$0) != null) {
      VideoControllerView.access$200(this.this$0).onStopTrackingTouch(paramSeekBar);
    }
    if (!this.this$0.isShowing()) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      if (this.this$0.mPlayer != null)
      {
        VideoControllerView.access$302(this.this$0, false);
        if (this.mDestProgress >= this.mStartProgress)
        {
          if (this.this$0.mPlayer.canSeekForward()) {
            break;
          }
          this.this$0.mProgress.setProgress(this.mStartProgress);
          PlayerUtils.log(5, "VideoControllerView", "seekforward is not possible");
        }
        else
        {
          if (this.this$0.mPlayer.canSeekBackward()) {
            break;
          }
          this.this$0.mProgress.setProgress(this.mStartProgress);
          PlayerUtils.log(5, "VideoControllerView", "seekbackward is not possible");
        }
      }
    }
    int i = this.this$0.mPlayer.getDuration();
    if (i > 0) {
      this.this$0.mVideoDuration = i;
    }
    int j = paramSeekBar.getProgress();
    Object localObject;
    if ((PlayerConfig.g().getVideoReporter() != null) && (paramSeekBar.getMax() > 0))
    {
      localObject = PlayerUtils.getVideoUuidFromVideoUrl(this.this$0.mPlayer.getVideoUriWithUuid());
      PlayerConfig.g().getVideoReporter().progressBarSeekingEnd((String)localObject, i * j / paramSeekBar.getMax());
    }
    long l1;
    if (j == paramSeekBar.getMax()) {
      if (i > 0)
      {
        long l2 = i - 500;
        i = (int)((float)l2 / i * paramSeekBar.getMax());
        l1 = l2;
        if (this.this$0.mProgress != null)
        {
          this.this$0.mProgress.setProgress(i);
          l1 = l2;
        }
        label299:
        if ((VideoControllerView.access$400(this.this$0) < 0) || (l1 < VideoControllerView.access$400(this.this$0))) {
          break label479;
        }
        this.this$0.mPlayer.seekTo(0);
        this.this$0.mPlayer.pause();
      }
    }
    for (;;)
    {
      this.this$0.postSetProgress();
      this.this$0.updatePausePlay();
      this.this$0.show(VideoControllerView.sDefaultTimeout);
      this.this$0.mHandler.removeMessages(2);
      this.this$0.mHandler.sendEmptyMessage(2);
      localObject = PlayerConfig.g().getCallbacks();
      if (localObject == null) {
        break;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PlayerCallBack localPlayerCallBack = (PlayerCallBack)((Iterator)localObject).next();
        localPlayerCallBack.onMediaEvent(localPlayerCallBack, PlayerCallBack.EVENT_SEEK_BAR_STOP_SEEK, null, null);
      }
      break;
      l1 = i;
      break label299;
      l1 = i;
      l1 = j * l1 / 1000L;
      break label299;
      label479:
      this.this$0.mPlayer.seekTo((int)l1);
      if (VideoControllerView.access$100(this.this$0) != null) {
        VideoControllerView.access$100(this.this$0).setText(this.this$0.mPlayer.time2str((int)l1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.6
 * JD-Core Version:    0.7.0.1
 */