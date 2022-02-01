package com.tencent.ttpic.filter;

import com.tencent.ttpic.model.RenderParam;
import java.util.Comparator;

class FastRenderFilter$1
  implements Comparator<RenderParam>
{
  FastRenderFilter$1(FastRenderFilter paramFastRenderFilter) {}
  
  public int compare(RenderParam paramRenderParam1, RenderParam paramRenderParam2)
  {
    return paramRenderParam1.texture - paramRenderParam2.texture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.FastRenderFilter.1
 * JD-Core Version:    0.7.0.1
 */