package okhttp3;

class p
  implements Runnable
{
  p(o paramo) {}
  
  public void run()
  {
    long l1;
    do
    {
      l1 = this.a.a(System.nanoTime());
      if (l1 == -1L) {
        return;
      }
    } while (l1 <= 0L);
    long l2 = l1 / 1000000L;
    try
    {
      label57:
      synchronized (this.a)
      {
        this.a.wait(l2, (int)(l1 - l2 * 1000000L));
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.p
 * JD-Core Version:    0.7.0.1
 */