package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.AEFilterBase;
import com.tencent.aekit.openrender.internal.Frame;

public class FilterDummy
  extends AEFilterBase
{
  public FilterDummy()
  {
    super(null, null);
  }
  
  public Frame render(Frame paramFrame)
  {
    return paramFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FilterDummy
 * JD-Core Version:    0.7.0.1
 */