import java.util.concurrent.atomic.AtomicInteger;

public class azcb
{
  private azca[] a;
  private AtomicInteger bT;
  
  private boolean ayj()
  {
    return this.bT.get() == 1;
  }
  
  public boolean ayi()
  {
    if (!ayj()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.a.length)
      {
        if (this.a[i].getTexureCurrentStatus() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public azca b()
  {
    if (!ayj()) {
      return null;
    }
    int i = 0;
    azca localazca;
    if (i < this.a.length) {
      if (this.a[i].JU() == 0)
      {
        localazca = this.a[i];
        localazca.makeBusy();
      }
    }
    for (;;)
    {
      return localazca;
      i += 1;
      break;
      localazca = null;
    }
  }
  
  public azca c()
  {
    if (!ayj()) {
      return null;
    }
    int i = 0;
    azca localazca;
    if (i < this.a.length)
    {
      if (this.a[i].JV() == 0) {}
      while (this.a[i].getTexureCurrentStatus() != 0)
      {
        i += 1;
        break;
      }
      localazca = this.a[i];
      localazca.makeBusy();
    }
    for (;;)
    {
      return localazca;
      localazca = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azcb
 * JD-Core Version:    0.7.0.1
 */