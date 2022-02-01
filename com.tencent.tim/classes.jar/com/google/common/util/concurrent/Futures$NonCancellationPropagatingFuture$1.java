package com.google.common.util.concurrent;

class Futures$NonCancellationPropagatingFuture$1
  implements Runnable
{
  Futures$NonCancellationPropagatingFuture$1(Futures.NonCancellationPropagatingFuture paramNonCancellationPropagatingFuture, ListenableFuture paramListenableFuture) {}
  
  public void run()
  {
    this.this$0.setFuture(this.val$delegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.NonCancellationPropagatingFuture.1
 * JD-Core Version:    0.7.0.1
 */