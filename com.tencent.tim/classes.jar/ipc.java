public class ipc
{
  private static ipc d;
  private static int sPoolSize;
  public static final Object sPoolSync = new Object();
  public int arB;
  public int arC;
  private ipc c;
  
  private ipc(int paramInt1, int paramInt2)
  {
    this.arB = paramInt1;
    this.arC = paramInt2;
  }
  
  public static ipc a(int paramInt1, int paramInt2)
  {
    synchronized (sPoolSync)
    {
      if (d != null)
      {
        ipc localipc = d;
        d = localipc.c;
        localipc.c = null;
        localipc.arB = paramInt1;
        localipc.arC = paramInt2;
        sPoolSize -= 1;
        return localipc;
      }
      return new ipc(paramInt1, paramInt2);
    }
  }
  
  public void recycle()
  {
    this.arB = -1;
    this.arC = -1;
    synchronized (sPoolSync)
    {
      if (sPoolSize < 4)
      {
        this.c = d;
        d = this;
        sPoolSize += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipc
 * JD-Core Version:    0.7.0.1
 */