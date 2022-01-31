package com.tencent.component.network.utils.thread;

final class d
  implements Runnable
{
  d(AsyncTask.d paramd, Runnable paramRunnable) {}
  
  public final void run()
  {
    try
    {
      this.b.run();
      return;
    }
    finally
    {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.d
 * JD-Core Version:    0.7.0.1
 */