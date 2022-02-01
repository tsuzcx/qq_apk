package com.tencent.mobileqq.apollo;

import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$8
  extends IApolloRunnableTask
{
  public String aV()
  {
    return "updateMouseButton";
  }
  
  public void run()
  {
    this.this$0.mLock.lock();
    try
    {
      this.this$0.a.a(this.val$action, this.coY, this.val$x, this.val$y);
      return;
    }
    finally
    {
      this.this$0.mLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.8
 * JD-Core Version:    0.7.0.1
 */