package com.tencent.biz.qqstory.storyHome.model;

import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import qve;
import qve.b;
import qve.e;

public class FeedListPageLoaderBase$1
  implements Runnable
{
  public FeedListPageLoaderBase$1(qve paramqve) {}
  
  public void run()
  {
    if (qve.a(this.this$0) != null) {
      qve.a(this.this$0).cancel();
    }
    qve.a(this.this$0, Stream.of(Integer.valueOf(this.this$0.a.bol)).map(new ThreadOffFunction("Q.qqstory.home.data.FeedListPageLoaderBase", 2)).map(this.this$0.a(this.this$0.a)).map(this.this$0.a()));
    qve.a(this.this$0).subscribe(new qve.e(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.1
 * JD-Core Version:    0.7.0.1
 */