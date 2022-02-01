package com.tencent.moai.nativepages.component;

public abstract interface ALLandingAutoPlay
{
  public abstract int getIndex();
  
  public abstract boolean isAutoPlaying();
  
  public abstract boolean isNativeAdMode();
  
  public abstract void setALLandingAutoPlayListener(ALLandingAutoPlayListener paramALLandingAutoPlayListener, int paramInt, boolean paramBoolean);
  
  public abstract void setSilence(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.ALLandingAutoPlay
 * JD-Core Version:    0.7.0.1
 */