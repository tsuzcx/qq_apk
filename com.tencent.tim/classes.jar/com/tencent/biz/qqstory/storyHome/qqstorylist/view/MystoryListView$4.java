package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

class MystoryListView$4
  implements Runnable
{
  MystoryListView$4(MystoryListView paramMystoryListView) {}
  
  public void run()
  {
    if (this.this$0.mScrollRunnable != null)
    {
      this.this$0.postDelayed(this.this$0.mScrollRunnable, 100L);
      this.this$0.mScrollRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.4
 * JD-Core Version:    0.7.0.1
 */