package com.google.common.util.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

final class Futures$3
  implements Runnable
{
  Futures$3(ConcurrentLinkedQueue paramConcurrentLinkedQueue, ListenableFuture paramListenableFuture) {}
  
  public void run()
  {
    ((SettableFuture)this.val$delegates.remove()).setFuture(this.val$future);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.3
 * JD-Core Version:    0.7.0.1
 */