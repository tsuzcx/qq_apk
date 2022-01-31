package btmsdkobf;

import android.os.HandlerThread;

public class eo
  extends HandlerThread
{
  private eq.a oN;
  private long t;
  
  public eo(String paramString, int paramInt, long paramLong)
  {
    super(paramString, paramInt);
    this.t = paramLong;
  }
  
  private eq.a df()
  {
    if (this.oN == null) {
      this.oN = ep.dh();
    }
    return this.oN;
  }
  
  public long bF()
  {
    return this.t;
  }
  
  public void run()
  {
    df().beforeExecute(this, null);
    super.run();
    df().b(this, null);
  }
  
  public void start()
  {
    try
    {
      df().a(this, null);
      super.start();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.eo
 * JD-Core Version:    0.7.0.1
 */