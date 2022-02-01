package com.tencent.ttpic.filter.aifilter;

import com.tencent.aekit.openrender.internal.Frame;

public abstract interface AIFilter
{
  public abstract void apply();
  
  public abstract void clear();
  
  public abstract void init(String paramString);
  
  public abstract boolean isAIFilterCancelled();
  
  public abstract Frame renderAIProcess(Frame paramFrame);
  
  public abstract void setAlphaParam(float paramFloat);
  
  public abstract void setCancel(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.AIFilter
 * JD-Core Version:    0.7.0.1
 */