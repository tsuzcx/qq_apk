package com.tencent.maxvideo.common;

public class AVIOStruct
  implements Cloneable
{
  public int aBitrate;
  public int aChannel;
  public int aFormat;
  public int aSampleRate;
  public int pBlockIndex;
  public int pCodec;
  public int pControlFlag;
  public int pFrameIndex;
  public int vBitrate;
  public int vFPS;
  public int vFormat;
  public long vFrameTime;
  public int vHeight;
  public int vOrientation;
  public int vWidth;
  
  public Object clone()
  {
    try
    {
      AVIOStruct localAVIOStruct = (AVIOStruct)super.clone();
      return localAVIOStruct;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public boolean isWriteFrame()
  {
    return (this.pControlFlag == ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue()) || (this.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA.getValue()) || (this.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue());
  }
  
  public String toString()
  {
    return "AVIOStruct [pBlockIndex=" + this.pBlockIndex + ", pFrameIndex=" + this.pFrameIndex + ", pCodec=" + this.pCodec + ", pControlFlag=" + this.pControlFlag + ", vWidth=" + this.vWidth + ", vHeight=" + this.vHeight + ", vOrientation=" + this.vOrientation + ", vFPS=" + this.vFPS + ", vFormat=" + this.vFormat + ", vBitrate=" + this.vBitrate + ", aSampleRate=" + this.aSampleRate + ", aChannel=" + this.aChannel + ", aFormat=" + this.aFormat + ", aBitrate=" + this.aBitrate + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.maxvideo.common.AVIOStruct
 * JD-Core Version:    0.7.0.1
 */