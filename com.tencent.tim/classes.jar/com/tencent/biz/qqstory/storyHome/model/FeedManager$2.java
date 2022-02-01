package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import qve.b;
import qvf;
import ram;

public class FeedManager$2
  implements Runnable
{
  public FeedManager$2(qvf paramqvf) {}
  
  public void run()
  {
    if (qvf.a(this.this$0) == 0L)
    {
      ram.w("Q.qqstory.home.position", "cache in use");
      return;
    }
    this.this$0.nk.clear();
    if (this.this$0.c != null) {
      this.this$0.c.reset();
    }
    ram.w("Q.qqstory.home.position", "release cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.2
 * JD-Core Version:    0.7.0.1
 */