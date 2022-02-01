package com.google.common.cache;

import java.util.concurrent.Executor;

final class RemovalListeners$1
  implements RemovalListener<K, V>
{
  RemovalListeners$1(Executor paramExecutor, RemovalListener paramRemovalListener) {}
  
  public void onRemoval(RemovalNotification<K, V> paramRemovalNotification)
  {
    this.val$executor.execute(new RemovalListeners.1.1(this, paramRemovalNotification));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.RemovalListeners.1
 * JD-Core Version:    0.7.0.1
 */