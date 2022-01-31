package okio;

final class d
  extends Thread
{
  d()
  {
    super("Okio Watchdog");
    setDaemon(true);
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        try
        {
          a locala = a.e();
          if (locala != null) {
            break label27;
          }
          continue;
        }
        finally {}
        continue;
      }
      catch (InterruptedException localInterruptedException) {}
      label27:
      if (localInterruptedException == a.b)
      {
        a.b = null;
        return;
      }
      localInterruptedException.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.d
 * JD-Core Version:    0.7.0.1
 */