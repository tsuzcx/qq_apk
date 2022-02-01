package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.view.View;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.a;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView;
import com.tribe.async.dispatch.Dispatcher;
import pmi;
import qul;
import ram;

public class MemoriesVideoListSegment$4
  implements Runnable
{
  public MemoriesVideoListSegment$4(qul paramqul, MemoriesInnerListView paramMemoriesInnerListView, int paramInt, String paramString) {}
  
  public void run()
  {
    View localView = this.b.getChildAt(this.bog);
    if (localView != null)
    {
      ram.b("Q.qqstory.memories.MemoriesVideoListSegment", "doScrollHorizal broadcast close animation %s", this.val$vid);
      pmi.a().dispatch(new StoryPlayerActivity.a(new AnimationParam(localView), this.val$vid));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.4
 * JD-Core Version:    0.7.0.1
 */