package com.tencent.biz.qqstory.network.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import pxs;

public class GetUserInfoHandler$1
  implements Runnable
{
  public GetUserInfoHandler$1(pxs parampxs) {}
  
  public void run()
  {
    synchronized (pxs.a(this.this$0))
    {
      if (!pxs.a(this.this$0).isEmpty())
      {
        this.this$0.B(1, pxs.a(this.this$0));
        pxs.a(this.this$0, new ArrayList());
      }
      pxs.a(this.this$0).set(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */