package com.tencent.ttpic.filter;

import com.tencent.ttpic.model.CanvasItem;
import java.util.Comparator;

final class ActFilters$1
  implements Comparator<CanvasItem>
{
  public int compare(CanvasItem paramCanvasItem1, CanvasItem paramCanvasItem2)
  {
    return paramCanvasItem1.zIndex - paramCanvasItem2.zIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.ActFilters.1
 * JD-Core Version:    0.7.0.1
 */