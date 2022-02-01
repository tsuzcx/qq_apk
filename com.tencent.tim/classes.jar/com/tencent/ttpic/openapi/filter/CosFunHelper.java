package com.tencent.ttpic.openapi.filter;

import com.tencent.ttpic.openapi.model.VideoMaterial;

public class CosFunHelper
{
  public static CountDownListener countDownListener = null;
  public static boolean isRestart = false;
  
  public static void setCountDownListener(CountDownListener paramCountDownListener)
  {
    countDownListener = paramCountDownListener;
  }
  
  public static abstract interface CountDownListener
  {
    public abstract void onCountDownEnd();
    
    public abstract void onCountDownStart(VideoMaterial paramVideoMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CosFunHelper
 * JD-Core Version:    0.7.0.1
 */