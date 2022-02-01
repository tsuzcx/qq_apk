package com.tencent.trackrecordlib.e;

class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public void run()
  {
    while (!c.a(this.a)) {
      try
      {
        int i = c.b(this.a);
        if (i != c.c(this.a)) {
          com.tencent.trackrecordlib.core.c.a().b(i);
        }
        c.a(this.a, i);
        Thread.sleep(1000L);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.e.c.1
 * JD-Core Version:    0.7.0.1
 */