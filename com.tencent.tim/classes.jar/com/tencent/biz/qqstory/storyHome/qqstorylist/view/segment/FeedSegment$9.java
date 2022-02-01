package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.Rect;
import com.tribe.async.dispatch.Dispatcher;
import pmi;
import qyk;
import qyk.b;
import ram;

public class FeedSegment$9
  implements Runnable
{
  public FeedSegment$9(qyk paramqyk, Rect paramRect) {}
  
  public void run()
  {
    qyk.b localb = new qyk.b(this.val$rect.top, this.val$rect.left, this.val$rect.right, this.val$rect.bottom);
    pmi.a().dispatch(localb);
    ram.d("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.9
 * JD-Core Version:    0.7.0.1
 */