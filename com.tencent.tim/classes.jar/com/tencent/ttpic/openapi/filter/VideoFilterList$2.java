package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.Comparator;

class VideoFilterList$2
  implements Comparator<VideoFilterBase>
{
  VideoFilterList$2(VideoFilterList paramVideoFilterList) {}
  
  public int compare(VideoFilterBase paramVideoFilterBase1, VideoFilterBase paramVideoFilterBase2)
  {
    int j = 0;
    if ((paramVideoFilterBase1 instanceof NormalVideoFilter)) {}
    for (int i = ((NormalVideoFilter)paramVideoFilterBase1).getStickerItem().zIndex;; i = 0)
    {
      if ((paramVideoFilterBase2 instanceof NormalVideoFilter)) {
        j = ((NormalVideoFilter)paramVideoFilterBase2).getStickerItem().zIndex;
      }
      return i - j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.VideoFilterList.2
 * JD-Core Version:    0.7.0.1
 */