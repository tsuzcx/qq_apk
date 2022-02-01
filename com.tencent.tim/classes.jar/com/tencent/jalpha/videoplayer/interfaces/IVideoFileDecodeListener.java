package com.tencent.jalpha.videoplayer.interfaces;

import android.media.MediaFormat;

public abstract interface IVideoFileDecodeListener
{
  public static final int ERROR_CREATE_CODEC = -5;
  public static final int ERROR_FILE_PATH = -1;
  public static final int ERROR_FORMAT_NOT_VIDEO = -3;
  public static final int ERROR_IN_DECODING = -101;
  public static final int ERROR_SELECT_VIDEO_TRACK_FORMAT = -2;
  
  public abstract void onVideoDecodeEnd();
  
  public abstract void onVideoDecodeError(int paramInt);
  
  public abstract void onVideoDecodeFrame(long paramLong, byte[] paramArrayOfByte);
  
  public abstract void onVideoDecodeStart();
  
  public abstract void onVideoDecoderCreated(boolean paramBoolean);
  
  public abstract void onVideoFormat(MediaFormat paramMediaFormat);
  
  public abstract void onVideoSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
 * JD-Core Version:    0.7.0.1
 */