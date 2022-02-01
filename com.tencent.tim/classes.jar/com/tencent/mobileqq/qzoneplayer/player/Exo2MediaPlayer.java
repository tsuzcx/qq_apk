package com.tencent.mobileqq.qzoneplayer.player;

import android.content.Context;
import android.graphics.Rect;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ext.mediaplayer.DecoderInfo;
import com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer;
import com.tencent.oskplayer.model.SegmentVideoInfo.SegmentInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import com.tencent.oskplayer.player.IExo2MediaPlayer;
import com.tencent.oskplayer.proxy.VideoManager;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

public class Exo2MediaPlayer
  extends ExoMediaPlayer
  implements IExo2MediaPlayer
{
  private List<String> mProxyUrls;
  private List<String> mSourceUrls;
  
  public Exo2MediaPlayer(Context paramContext)
  {
    super(paramContext);
  }
  
  public String getAudioDecoderName()
  {
    if (this.mAudioDecoderInfo != null) {
      return this.mAudioDecoderInfo.decoderName;
    }
    return null;
  }
  
  public String getAudioMIMEType()
  {
    if (this.mAudioFormat != null) {
      return this.mAudioFormat.sampleMimeType;
    }
    return null;
  }
  
  public String getCurrentProxySegmentUrl()
  {
    if (this.mProxyUrls != null) {
      return (String)this.mProxyUrls.get(0);
    }
    return null;
  }
  
  public String getCurrentSegmentUrl()
  {
    if (this.mSourceUrls != null) {
      return (String)this.mSourceUrls.get(0);
    }
    return null;
  }
  
  public String getDataSource()
  {
    return null;
  }
  
  public MediaInfo getMediaInfo()
  {
    return null;
  }
  
  public int getScore()
  {
    return 0;
  }
  
  public int getSegmentCount()
  {
    return 0;
  }
  
  public ITrackInfo[] getTrackInfo()
  {
    return null;
  }
  
  public int getVideoBitrate()
  {
    if (this.mVideoFormat != null) {
      return this.mVideoFormat.bitrate;
    }
    return -1;
  }
  
  public String getVideoDecoderName()
  {
    if (this.mVideoDecoderInfo != null) {
      return this.mVideoDecoderInfo.decoderName;
    }
    return null;
  }
  
  public Rect getVideoDimension()
  {
    if (this.mVideoFormat != null)
    {
      Rect localRect = new Rect();
      localRect.left = 0;
      localRect.top = 0;
      localRect.right = this.mVideoFormat.width;
      localRect.bottom = this.mVideoFormat.height;
      return localRect;
    }
    return null;
  }
  
  public String getVideoMIMEType()
  {
    if (this.mVideoFormat != null) {
      return this.mVideoFormat.sampleMimeType;
    }
    return null;
  }
  
  public int getVideoSarDen()
  {
    return 1;
  }
  
  public int getVideoSarNum()
  {
    return 1;
  }
  
  public boolean isPlayable()
  {
    return false;
  }
  
  public void seekTo(long paramLong)
    throws IllegalStateException
  {
    super.seekTo(paramLong);
  }
  
  public void setAudioStreamType(int paramInt) {}
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo)
    throws IOException
  {
    if ((paramStreamInfo == null) || (paramStreamInfo.segmentInfos == null) || (paramStreamInfo.segmentInfos.get(0) == null)) {
      return;
    }
    paramStreamInfo = paramStreamInfo.segmentInfos;
    this.mSourceUrls = new ArrayList();
    if (paramStreamInfo != null)
    {
      Iterator localIterator = paramStreamInfo.iterator();
      while (localIterator.hasNext())
      {
        SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)localIterator.next();
        this.mSourceUrls.add(localSegmentInfo.url);
      }
    }
    this.mProxyUrls = VideoManager.getInstance().getUrl(this.mSourceUrls);
    if ((paramStreamInfo != null) && (paramStreamInfo.size() > 1)) {
      throw new UnsupportedOperationException("Exo2MediaPlayer is not support multiple video segment");
    }
    setDataSource((String)this.mProxyUrls.get(0));
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo, int paramInt)
    throws IOException
  {
    setDataSource(paramStreamInfo);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
    throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedOperationException
  {
    throw new UnsupportedOperationException("no support");
  }
  
  public void setDataSource(IMediaDataSource paramIMediaDataSource)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  }
  
  public void setKeepInBackground(boolean paramBoolean) {}
  
  public void setLogEnabled(boolean paramBoolean) {}
  
  public void setNextMediaPlayer(IMediaPlayer paramIMediaPlayer)
    throws UnsupportedOperationException
  {
    super.setNextMediaPlayer(this);
  }
  
  public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    if (paramOnBufferingUpdateListener != null)
    {
      super.setOnBufferingUpdateListener(new Exo2MediaPlayer.4(this, paramOnBufferingUpdateListener));
      return;
    }
    super.setOnBufferingUpdateListener(null);
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (paramOnCompletionListener != null)
    {
      super.setOnCompletionListener(new Exo2MediaPlayer.3(this, paramOnCompletionListener));
      return;
    }
    super.setOnCompletionListener(null);
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    if (paramOnErrorListener != null)
    {
      super.setOnErrorListener(new Exo2MediaPlayer.7(this, paramOnErrorListener));
      return;
    }
    super.setOnErrorListener(null);
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    if (paramOnInfoListener != null)
    {
      super.setOnInfoListener(new Exo2MediaPlayer.8(this, paramOnInfoListener));
      return;
    }
    super.setOnInfoListener(null);
  }
  
  public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    if (paramOnLoopStartListener != null)
    {
      super.setOnLoopStartListener(new Exo2MediaPlayer.1(this, paramOnLoopStartListener));
      return;
    }
    super.setOnLoopStartListener(null);
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    if (paramOnPreparedListener != null)
    {
      super.setOnPreparedListener(new Exo2MediaPlayer.2(this, paramOnPreparedListener));
      return;
    }
    super.setOnPreparedListener(null);
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    if (paramOnSeekCompleteListener != null)
    {
      super.setOnSeekCompleteListener(new Exo2MediaPlayer.5(this, paramOnSeekCompleteListener));
      return;
    }
    super.setOnSeekCompleteListener(null);
  }
  
  public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener paramOnTimedTextListener) {}
  
  public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    if (paramOnVideoSizeChangedListener != null)
    {
      super.setOnVideoSizeChangedListener(new Exo2MediaPlayer.6(this, paramOnVideoSizeChangedListener));
      return;
    }
    super.setOnVideoSizeChangedListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer
 * JD-Core Version:    0.7.0.1
 */