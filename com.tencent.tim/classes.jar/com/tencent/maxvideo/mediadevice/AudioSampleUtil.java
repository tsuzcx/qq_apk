package com.tencent.maxvideo.mediadevice;

public class AudioSampleUtil
{
  public static int bytesInMillisecond(int paramInt1, int paramInt2, int paramInt3)
  {
    return bytesInSecond(paramInt1, paramInt2, paramInt3) / 1000;
  }
  
  public static int bytesInSecond(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2;
    switch (paramInt2)
    {
    default: 
      paramInt2 = 1;
      switch (paramInt3)
      {
      }
      break;
    }
    for (i = 1;; i = 1)
    {
      return i * paramInt1 * paramInt2;
      paramInt2 = 1;
      break;
      paramInt2 = 2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.maxvideo.mediadevice.AudioSampleUtil
 * JD-Core Version:    0.7.0.1
 */