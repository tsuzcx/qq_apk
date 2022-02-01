package com.tencent.oskplayer.player;

import android.media.MediaPlayer;
import com.tencent.oskplayer.model.SegmentVideoInfo.SegmentInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.IOException;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;

public class HLSMediaPlayer
  extends AndroidMediaPlayer
  implements ISegmentMediaPlayer
{
  private boolean isAllowLooping;
  private boolean isHLSLive;
  private String mProxyUrl;
  
  public long getCurrentPosition()
  {
    if (this.isHLSLive) {
      return 0L;
    }
    return super.getCurrentPosition();
  }
  
  public String getCurrentProxySegmentUrl()
  {
    return this.mProxyUrl;
  }
  
  public String getCurrentSegmentUrl()
  {
    return this.mProxyUrl;
  }
  
  public long getDuration()
  {
    if (this.isHLSLive) {
      return 0L;
    }
    return super.getDuration();
  }
  
  public int getSegmentCount()
  {
    if (this.mProxyUrl == null) {
      return 0;
    }
    return 1;
  }
  
  public boolean isLooping()
  {
    if (this.isAllowLooping) {
      return super.isLooping();
    }
    return false;
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo)
    throws IOException
  {
    if (paramStreamInfo.getCount() > 1) {
      throw new IOException("streamInfo size error");
    }
    String str = paramStreamInfo.getSegment(0).url;
    this.mProxyUrl = VideoManager.getInstance().getUrl(str);
    if (PlayerUtils.isHLSStream(this.mProxyUrl)) {}
    for (this.isAllowLooping = false;; this.isAllowLooping = true)
    {
      this.isHLSLive = paramStreamInfo.isHLSLive;
      getInternalMediaPlayer().setDataSource(this.mProxyUrl);
      return;
    }
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo, int paramInt)
    throws IOException
  {
    setDataSource(paramStreamInfo);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    if (this.isAllowLooping) {
      super.setLooping(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.HLSMediaPlayer
 * JD-Core Version:    0.7.0.1
 */