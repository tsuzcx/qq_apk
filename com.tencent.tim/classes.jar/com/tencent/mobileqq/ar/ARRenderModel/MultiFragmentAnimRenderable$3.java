package com.tencent.mobileqq.ar.ARRenderModel;

import adcy;
import adds;
import java.util.concurrent.locks.ReentrantLock;

public class MultiFragmentAnimRenderable$3
  implements Runnable
{
  public MultiFragmentAnimRenderable$3(adds paramadds) {}
  
  public void run()
  {
    adds.a(this.this$0).lock();
    if (adds.a(this.this$0) != null)
    {
      adds.a(this.this$0).onDestroy();
      adds.a(this.this$0, null);
    }
    adds.a(this.this$0).unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.3
 * JD-Core Version:    0.7.0.1
 */