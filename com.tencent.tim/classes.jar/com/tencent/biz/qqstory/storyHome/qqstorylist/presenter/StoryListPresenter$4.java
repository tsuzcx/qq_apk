package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.os.Handler;
import qxq;
import rox;

public class StoryListPresenter$4
  implements Runnable
{
  public StoryListPresenter$4(qxq paramqxq) {}
  
  public void run()
  {
    String str = rox.q(this.this$0.context, "qqstory_upgrade_guide.mp4");
    if (str != null) {
      this.this$0.mainHandler.post(new StoryListPresenter.4.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4
 * JD-Core Version:    0.7.0.1
 */