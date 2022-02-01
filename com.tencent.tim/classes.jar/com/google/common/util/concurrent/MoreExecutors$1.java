package com.google.common.util.concurrent;

import java.util.concurrent.BlockingQueue;

final class MoreExecutors$1
  implements Runnable
{
  MoreExecutors$1(BlockingQueue paramBlockingQueue, ListenableFuture paramListenableFuture) {}
  
  public void run()
  {
    this.val$queue.add(this.val$future);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.MoreExecutors.1
 * JD-Core Version:    0.7.0.1
 */