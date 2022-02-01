package com.tencent.image;

import java.lang.ref.WeakReference;

class NativeGifImage$NativeDecodeFrameTask$1
  implements Runnable
{
  NativeGifImage$NativeDecodeFrameTask$1(NativeGifImage.NativeDecodeFrameTask paramNativeDecodeFrameTask) {}
  
  public void run()
  {
    AbstractGifImage.sAccumulativeRunnable.add(new WeakReference[] { new WeakReference(this.this$1.this$0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.NativeGifImage.NativeDecodeFrameTask.1
 * JD-Core Version:    0.7.0.1
 */