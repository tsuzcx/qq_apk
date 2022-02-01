package com.tencent.component.media.gif;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class RenderTask$1
  implements Runnable
{
  RenderTask$1(RenderTask paramRenderTask) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.mGifDrawable.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((AnimationListener)localIterator.next()).onAnimationCompleted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.gif.RenderTask.1
 * JD-Core Version:    0.7.0.1
 */