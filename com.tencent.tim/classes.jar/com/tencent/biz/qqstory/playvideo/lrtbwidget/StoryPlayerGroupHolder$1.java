package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import java.util.Iterator;
import java.util.List;

class StoryPlayerGroupHolder$1
  implements Runnable
{
  StoryPlayerGroupHolder$1(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void run()
  {
    StoryPlayerGroupHolder.a(this.this$0).onPageSelected(this.this$0.a.getCurrentItem());
    Iterator localIterator = this.this$0.a.bP().iterator();
    while (localIterator.hasNext()) {
      ((XViewPager.f)localIterator.next()).onPageSelected(this.this$0.a.getCurrentItem());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.1
 * JD-Core Version:    0.7.0.1
 */