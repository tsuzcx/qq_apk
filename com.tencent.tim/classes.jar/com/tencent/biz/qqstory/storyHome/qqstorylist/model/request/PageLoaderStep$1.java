package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tribe.async.dispatch.Dispatcher;
import pmi;
import pxf;
import qxi;
import qxo.b;
import ram;

public class PageLoaderStep$1
  implements Runnable
{
  public void run()
  {
    ram.d("Q.qqstory.home.qqstory_step", "finish step plz reference below dump");
    this.this$0.dump();
    this.this$0.state = 2;
    int i = this.this$0.a(this.a);
    if ((i == 0) && (this.this$0.KI()))
    {
      qxi localqxi = this.this$0;
      localqxi.requestCount -= 1;
      this.this$0.b.aPh();
      this.this$0.state = 1;
      return;
    }
    if (i == 2)
    {
      this.this$0.a(this.a);
      pmi.a().unRegisterSubscriber(this.this$0);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.this$0.startTime;
    ram.d("Q.qqstory.home.PageLoaderStep", "finish " + this.this$0.getKey() + " step and cost time=" + (l1 - l2));
    ram.b("Q.qqstory.home.PageLoaderStep", "unRegisterSubscriber %s", this.this$0);
    pmi.a().unRegisterSubscriber(this.this$0);
    if (this.this$0.a != null)
    {
      this.this$0.a.si(this.this$0.getKey());
      return;
    }
    ram.w("Q.qqstory.home.PageLoaderStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.PageLoaderStep.1
 * JD-Core Version:    0.7.0.1
 */