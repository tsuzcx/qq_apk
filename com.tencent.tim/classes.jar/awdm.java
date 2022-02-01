import java.lang.ref.WeakReference;

public class awdm
{
  private static awdm b;
  private static int sPoolSize;
  private static final Object sPoolSync = new Object();
  private awdm a;
  public String fileName;
  public WeakReference<awdk.a> jj;
  public String mPath;
  public String mUrl;
  public String mUrlKey;
  public int type;
  
  public awdm(int paramInt, String paramString)
  {
    this.mUrlKey = (paramInt + " " + paramString);
  }
  
  public static awdm a(int paramInt, String paramString)
  {
    synchronized (sPoolSync)
    {
      if (b != null)
      {
        awdm localawdm = b;
        b = localawdm.a;
        localawdm.a = null;
        localawdm.mUrlKey = (paramInt + " " + paramString);
        localawdm.type = paramInt;
        sPoolSize -= 1;
        return localawdm;
      }
      return new awdm(paramInt, paramString);
    }
  }
  
  private void clearForRecycle()
  {
    this.mUrl = null;
    this.mUrlKey = null;
    this.mPath = null;
    this.fileName = null;
    this.jj = null;
  }
  
  public void recycle()
  {
    clearForRecycle();
    synchronized (sPoolSync)
    {
      if (sPoolSize < 100)
      {
        this.a = b;
        b = this;
        sPoolSize += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdm
 * JD-Core Version:    0.7.0.1
 */