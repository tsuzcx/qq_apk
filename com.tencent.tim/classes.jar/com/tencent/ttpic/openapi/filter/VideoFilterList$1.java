package com.tencent.ttpic.openapi.filter;

import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.Comparator;

class VideoFilterList$1
  implements Comparator<RenderItem>
{
  VideoFilterList$1(VideoFilterList paramVideoFilterList) {}
  
  public int compare(RenderItem paramRenderItem1, RenderItem paramRenderItem2)
  {
    int j = 0;
    if ((paramRenderItem1.filter instanceof NormalVideoFilter)) {}
    for (int i = ((NormalVideoFilter)paramRenderItem1.filter).getStickerItem().zIndex;; i = 0)
    {
      if ((paramRenderItem2.filter instanceof NormalVideoFilter)) {
        j = ((NormalVideoFilter)paramRenderItem2.filter).getStickerItem().zIndex;
      }
      return i - j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.VideoFilterList.1
 * JD-Core Version:    0.7.0.1
 */