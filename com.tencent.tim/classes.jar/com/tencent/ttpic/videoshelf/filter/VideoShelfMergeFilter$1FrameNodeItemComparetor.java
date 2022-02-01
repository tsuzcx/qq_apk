package com.tencent.ttpic.videoshelf.filter;

import com.tencent.ttpic.videoshelf.model.template.FrameNodeItem;
import java.util.Comparator;

class VideoShelfMergeFilter$1FrameNodeItemComparetor
  implements Comparator<FrameNodeItem>
{
  VideoShelfMergeFilter$1FrameNodeItemComparetor(VideoShelfMergeFilter paramVideoShelfMergeFilter) {}
  
  public int compare(FrameNodeItem paramFrameNodeItem1, FrameNodeItem paramFrameNodeItem2)
  {
    if ((paramFrameNodeItem1.getZIndex() > 10000) && (paramFrameNodeItem2.getZIndex() > 10000)) {
      return paramFrameNodeItem1.getZIndex() - paramFrameNodeItem2.getZIndex();
    }
    if ((paramFrameNodeItem1.getZIndex() < 10000) && (paramFrameNodeItem2.getZIndex() < 10000)) {
      return paramFrameNodeItem2.getZIndex() - paramFrameNodeItem1.getZIndex();
    }
    return paramFrameNodeItem1.getZIndex() - paramFrameNodeItem2.getZIndex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.filter.VideoShelfMergeFilter.1FrameNodeItemComparetor
 * JD-Core Version:    0.7.0.1
 */