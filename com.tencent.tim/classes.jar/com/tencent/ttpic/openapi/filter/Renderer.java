package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.Frame;

public abstract interface Renderer
{
  public abstract Frame process(Frame paramFrame);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.Renderer
 * JD-Core Version:    0.7.0.1
 */