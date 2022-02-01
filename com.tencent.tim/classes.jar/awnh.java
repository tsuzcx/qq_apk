import java.lang.ref.WeakReference;

public class awnh
{
  private static awnh b;
  private static int sPoolSize;
  private static final Object sPoolSync = new Object();
  private awnh a;
  public String fileName;
  public WeakReference<awni> jj;
  public String mPath;
  public int mResType;
  public String mUrl;
  public String mUrlKey;
  
  public awnh(String paramString1, int paramInt, String paramString2, WeakReference<awni> paramWeakReference)
  {
    this.mUrl = paramString1;
    this.mResType = paramInt;
    this.mUrlKey = (this.mUrl + " " + paramString2);
    this.jj = paramWeakReference;
  }
  
  public static awnh a(String paramString1, int paramInt, String paramString2, WeakReference<awni> paramWeakReference)
  {
    synchronized (sPoolSync)
    {
      if (b != null)
      {
        awnh localawnh = b;
        b = localawnh.a;
        localawnh.a = null;
        localawnh.mUrl = paramString1;
        localawnh.fileName = paramString2;
        localawnh.mResType = paramInt;
        localawnh.mUrlKey = (paramString1 + " " + paramString2);
        localawnh.jj = paramWeakReference;
        sPoolSize -= 1;
        return localawnh;
      }
      return new awnh(paramString1, paramInt, paramString2, paramWeakReference);
    }
  }
  
  private void clearForRecycle()
  {
    this.mUrl = null;
    this.mUrlKey = null;
    this.mPath = null;
    this.fileName = null;
    this.mResType = -1;
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
 * Qualified Name:     awnh
 * JD-Core Version:    0.7.0.1
 */