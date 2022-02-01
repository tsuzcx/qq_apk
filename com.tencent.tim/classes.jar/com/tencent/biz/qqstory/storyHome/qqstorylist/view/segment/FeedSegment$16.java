package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import qwa;
import qyk;
import ram;

public class FeedSegment$16
  implements Runnable
{
  public FeedSegment$16(qyk paramqyk, int paramInt, qwa paramqwa, String paramString) {}
  
  public void run()
  {
    ram.d("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting done");
    qyk.a(this.this$0, this.val$feedPosition, this.c, this.val$vid, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.16
 * JD-Core Version:    0.7.0.1
 */