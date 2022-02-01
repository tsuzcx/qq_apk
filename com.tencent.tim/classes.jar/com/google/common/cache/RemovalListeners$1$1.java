package com.google.common.cache;

class RemovalListeners$1$1
  implements Runnable
{
  RemovalListeners$1$1(RemovalListeners.1 param1, RemovalNotification paramRemovalNotification) {}
  
  public void run()
  {
    this.this$0.val$listener.onRemoval(this.val$notification);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.RemovalListeners.1.1
 * JD-Core Version:    0.7.0.1
 */