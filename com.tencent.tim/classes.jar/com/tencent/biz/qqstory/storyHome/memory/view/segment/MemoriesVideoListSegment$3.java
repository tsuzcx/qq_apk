package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import qul;
import ram;

public class MemoriesVideoListSegment$3
  implements Runnable
{
  public MemoriesVideoListSegment$3(qul paramqul, int paramInt, VideoCollectionItem paramVideoCollectionItem, String paramString) {}
  
  public void run()
  {
    ram.d("Q.qqstory.memories.MemoriesVideoListSegment", "doScrollHorizal, findViewHolder, null, waiting done");
    qul.a(this.this$0, this.val$feedPosition, this.d, this.val$vid, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.3
 * JD-Core Version:    0.7.0.1
 */