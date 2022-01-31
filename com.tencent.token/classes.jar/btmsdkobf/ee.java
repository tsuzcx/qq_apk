package btmsdkobf;

import android.os.HandlerThread;

public class ee
{
  private static volatile ee od = null;
  private em oc = new em(bc.n());
  private long t = 1L;
  
  public static ee cT()
  {
    if (od == null) {}
    try
    {
      if (od == null) {
        od = new ee();
      }
      return od;
    }
    finally {}
  }
  
  public HandlerThread L(String paramString)
  {
    return this.oc.a(paramString, 0, this.t);
  }
  
  public void addTask(Runnable paramRunnable, String paramString)
  {
    this.oc.a(paramRunnable, paramString, this.t);
  }
  
  public void addUrgentTask(Runnable paramRunnable, String paramString)
  {
    this.oc.b(paramRunnable, paramString, this.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ee
 * JD-Core Version:    0.7.0.1
 */