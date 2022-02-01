package com.tencent.thumbplayer.core.player;

import com.tencent.thumbplayer.core.common.TPVideoFrame;

public abstract interface ITPNativePlayerVideoFrameCallback
{
  public static final int FLAG_EOS = 1;
  public static final int FLAG_MULTITRACK_END = 4;
  public static final int FLAG_MULTITRACK_START = 2;
  
  public abstract void onVideoFrame(TPVideoFrame paramTPVideoFrame, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback
 * JD-Core Version:    0.7.0.1
 */