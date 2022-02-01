package com.tencent.video.decode;

import android.graphics.Bitmap;

public abstract class AbstractAVDecode
{
  public static final int STREAM_AUDIO = 1096108367;
  public static final int STREAM_VIDEO = 1447642447;
  private static volatile boolean sInitedStatus = false;
  public static boolean soLoaded = false;
  public final AVAudioParam audioParam = new AVAudioParam();
  public final AVVideoParam videoParam = new AVVideoParam();
  
  static void checkSoLoaded()
  {
    if (!isLoadDecodeLib()) {
      AVDecodeError.throwException(-202);
    }
  }
  
  private static boolean isLoadDecodeLib()
  {
    if (!sInitedStatus) {
      if (ShortVideoSoLoad.getShortVideoSoLoadStatus() != 0) {
        break label26;
      }
    }
    label26:
    for (boolean bool = true;; bool = false)
    {
      soLoaded = bool;
      sInitedStatus = true;
      return soLoaded;
    }
  }
  
  public abstract void close();
  
  public abstract void resetVideoPlayer(AVDecodeOption paramAVDecodeOption);
  
  public abstract byte[] seekToNextAudioByteFrame()
    throws AVideoException;
  
  public abstract float[] seekToNextAudioFloatFrame()
    throws AVideoException;
  
  public abstract short[] seekToNextAudioShortFrame()
    throws AVideoException;
  
  public abstract void seekToNextFrame(Bitmap paramBitmap)
    throws AVideoException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.video.decode.AbstractAVDecode
 * JD-Core Version:    0.7.0.1
 */