package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import pmi;
import psn;
import psx;
import qua;
import qua.a;
import ram;

public class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((psn)psx.a(19)).O(this.this$0.mUnionId);
    qua.a locala = new qua.a(new ErrorMessage(), qua.a(this.this$0));
    locala.aCu = true;
    locala.isEnd = true;
    locala.isFirstPage = true;
    locala.oo = ((List)???);
    locala.bob = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.aCy)
      {
        pmi.a().dispatch(locala);
        ram.b("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", locala);
        return;
      }
      ram.w("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */