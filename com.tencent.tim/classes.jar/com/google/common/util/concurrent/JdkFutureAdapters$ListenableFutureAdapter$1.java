package com.google.common.util.concurrent;

class JdkFutureAdapters$ListenableFutureAdapter$1
  implements Runnable
{
  JdkFutureAdapters$ListenableFutureAdapter$1(JdkFutureAdapters.ListenableFutureAdapter paramListenableFutureAdapter) {}
  
  public void run()
  {
    try
    {
      Uninterruptibles.getUninterruptibly(JdkFutureAdapters.ListenableFutureAdapter.access$000(this.this$0));
      label11:
      JdkFutureAdapters.ListenableFutureAdapter.access$100(this.this$0).execute();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label11;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.JdkFutureAdapters.ListenableFutureAdapter.1
 * JD-Core Version:    0.7.0.1
 */