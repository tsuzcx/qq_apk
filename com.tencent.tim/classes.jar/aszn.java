import java.util.concurrent.atomic.AtomicInteger;

public class aszn
{
  private AtomicInteger co = new AtomicInteger(0);
  
  public boolean aIQ()
  {
    int i;
    do
    {
      i = this.co.get();
      if ((i & 0x1) != 0) {
        return false;
      }
    } while (!this.co.compareAndSet(i, i + 2));
    return true;
  }
  
  public void esL()
  {
    if (this.co.compareAndSet(0, 1)) {}
    while (this.co.compareAndSet(1, 1)) {
      return;
    }
    int i;
    do
    {
      i = this.co.get();
    } while (!this.co.compareAndSet(i, i | 0x1));
    try
    {
      synchronized (this.co)
      {
        this.co.wait();
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public void release()
  {
    int i;
    do
    {
      i = this.co.get();
      if ((i & 0xFFFFFFFE) == 0) {}
      do
      {
        return;
        if ((i & 0x1) == 0) {
          break;
        }
      } while ((this.co.addAndGet(-2) & 0xFFFFFFFE) != 0);
      synchronized (this.co)
      {
        this.co.notifyAll();
        return;
      }
    } while (!this.co.compareAndSet(i, i - 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszn
 * JD-Core Version:    0.7.0.1
 */