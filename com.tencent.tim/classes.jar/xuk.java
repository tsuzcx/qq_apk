import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class xuk
{
  private static int bXe = 900000;
  public ConcurrentHashMap<Long, xuk.b> cX = new ConcurrentHashMap();
  
  public static final xuk a()
  {
    return xuk.a.b();
  }
  
  public xuk.b a(long paramLong)
  {
    if (this.cX.containsKey(Long.valueOf(paramLong))) {
      return (xuk.b)this.cX.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a(long paramLong1, String[] paramArrayOfString, long paramLong2, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
  {
    this.cX.put(Long.valueOf(paramLong1), new xuk.b(paramArrayOfString, paramLong2, paramMessageForShortVideo, paramInt, paramString));
  }
  
  public void clearCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d(" LongVideoUrlCacheManager", 2, "LongVideoUrlCacheManager,clearCache");
    }
    this.cX.clear();
  }
  
  static class a
  {
    private static final xuk a = new xuk(null);
  }
  
  public class b
  {
    public long JA;
    String domain;
    public int fileType;
    public MessageForShortVideo l;
    public String[] mUrls;
    
    public b(String[] paramArrayOfString, long paramLong, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
    {
      this.mUrls = paramArrayOfString;
      this.JA = paramLong;
      this.l = paramMessageForShortVideo;
      this.fileType = paramInt;
      this.domain = paramString;
    }
    
    public boolean isValid()
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.JA;
      if (QLog.isColorLevel()) {
        QLog.d(" LongVideoUrlCacheManager", 2, "UrlsCacheBean, now=  " + l1 + ", mGetTime" + this.JA + " diff=" + l2 + " urlTimeValidDiff=" + xuk.bXe);
      }
      return l2 < xuk.bXe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xuk
 * JD-Core Version:    0.7.0.1
 */