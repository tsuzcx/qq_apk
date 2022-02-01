package com.tencent.oskplayer.player;

import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaPlayerProxy;

public class SegmentMediaPlayerProxy
  extends MediaPlayerProxy
  implements ISegmentMediaPlayer
{
  public SegmentMediaPlayerProxy(IMediaPlayer paramIMediaPlayer)
  {
    super(paramIMediaPlayer);
  }
  
  public String getCurrentProxySegmentUrl()
    throws UnsupportedOperationException
  {
    if ((this.mBackEndMediaPlayer instanceof ISegmentMediaPlayer)) {
      return ((ISegmentMediaPlayer)this.mBackEndMediaPlayer).getCurrentProxySegmentUrl();
    }
    throw new UnsupportedOperationException();
  }
  
  public String getCurrentSegmentUrl()
    throws UnsupportedOperationException
  {
    if ((this.mBackEndMediaPlayer instanceof ISegmentMediaPlayer)) {
      return ((ISegmentMediaPlayer)this.mBackEndMediaPlayer).getCurrentSegmentUrl();
    }
    throw new UnsupportedOperationException();
  }
  
  public int getSegmentCount()
    throws UnsupportedOperationException
  {
    if ((this.mBackEndMediaPlayer instanceof ISegmentMediaPlayer)) {
      return ((ISegmentMediaPlayer)this.mBackEndMediaPlayer).getSegmentCount();
    }
    throw new UnsupportedOperationException();
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo)
    throws IOException, UnsupportedOperationException
  {
    if ((this.mBackEndMediaPlayer instanceof ISegmentMediaPlayer))
    {
      ((ISegmentMediaPlayer)this.mBackEndMediaPlayer).setDataSource(paramStreamInfo);
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo, int paramInt)
    throws IOException, UnsupportedOperationException
  {
    if ((this.mBackEndMediaPlayer instanceof ISegmentMediaPlayer))
    {
      ((ISegmentMediaPlayer)this.mBackEndMediaPlayer).setDataSource(paramStreamInfo, paramInt);
      return;
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.SegmentMediaPlayerProxy
 * JD-Core Version:    0.7.0.1
 */