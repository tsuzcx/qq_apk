package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import qvj;
import qvq;
import qvt;
import qvt.f;
import ram;

public class HomeFeedPresenter$2
  implements Runnable
{
  public HomeFeedPresenter$2(qvt paramqvt, qvq paramqvq) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.b.isFirstPage) && (this.b.b.isSuccess())) {
      qvt.a(this.this$0).clear();
    }
    qvt.a(this.this$0).addAll(this.b.or);
    this.this$0.eG(qvt.a(this.this$0));
    Collections.sort(qvt.a(this.this$0), qvj.a);
    qvt.a(this.this$0, this.b.isEnd);
    this.b.or = qvt.a(this.this$0);
    ram.b("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(qvt.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (qvt.a(this.this$0) != null) {
      qvt.a(this.this$0).am(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */