package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

final class Callables$2
  implements AsyncCallable<T>
{
  Callables$2(ListeningExecutorService paramListeningExecutorService, Callable paramCallable) {}
  
  public ListenableFuture<T> call()
    throws Exception
  {
    return this.val$listeningExecutorService.submit(this.val$callable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Callables.2
 * JD-Core Version:    0.7.0.1
 */