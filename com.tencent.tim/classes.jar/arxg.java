import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class arxg
{
  protected static final String TAG = arxg.class.getName();
  protected static arxg a;
  protected aryj b;
  protected HashMap<String, arxe> bq;
  
  protected arxg()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.b == null) {
          this.b = aryg.a().a(arxe.class, 0L, "http_cache_table");
        }
        int j = this.b.getCount();
        this.bq = new HashMap(j);
        i = 0;
        if (i < j)
        {
          arxe localarxe = (arxe)this.b.a(i);
          if ((localarxe == null) || (localarxe.urlKey == null)) {
            break label108;
          }
          this.bq.put(localarxe.urlKey, localarxe);
        }
      }
      catch (Exception localException)
      {
        this.bq = new HashMap();
      }
      return;
      label108:
      i += 1;
    }
  }
  
  public static arxg a()
  {
    try
    {
      if (a == null) {
        a = new arxg();
      }
      arxg localarxg = a;
      return localarxg;
    }
    finally {}
  }
  
  public long bm(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.bq != null)
    {
      l1 = l2;
      if (this.bq.size() != 0)
      {
        paramString = arwv.encodeHexStr(paramString);
        l1 = l2;
        if (this.bq.get(paramString) != null) {
          l1 = ((arxe)this.bq.get(paramString)).awJ;
        }
      }
    }
    arwt.d(TAG, "Get lastModify from cache. lastModify=" + l1);
    return l1;
  }
  
  public void c(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        if (("".equals(paramString1.trim())) || (paramString3 == null))
        {
          arwt.e(TAG, "saveResponse error. params error\n url=" + paramString1 + "; ETag=" + paramString2 + "; lastModify=" + paramLong + "; response=" + paramString3);
          return;
        }
        paramString2 = new arxe(paramString1, paramString2, paramLong, paramString3, paramString4);
        paramString1 = arwv.encodeHexStr(paramString1);
        if (this.b == null) {
          break;
        }
        if (this.bq.containsKey(paramString1))
        {
          this.b.b(paramString2, "urlKey='" + paramString1 + "'");
          this.bq.put(paramString1, paramString2);
          arwt.d(TAG, "Get 200, Save response data to cache. urlKey=" + paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      elU();
      this.b.a(paramString2, 1);
    }
  }
  
  public void clearMemoryCache()
  {
    try
    {
      if (this.bq != null) {
        this.bq.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void elU()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.bq.values().iterator();
        long l2 = System.currentTimeMillis();
        long l1 = 9223372036854775807L;
        String str = null;
        if (localIterator.hasNext())
        {
          arxe localarxe = (arxe)localIterator.next();
          if (l2 - localarxe.cacheTime >= 432000000L)
          {
            arwt.d(TAG, "Clear out of date cache. urlkey=" + localarxe.urlKey);
            this.b.Xr("urlKey='" + localarxe.urlKey + "'");
            localIterator.remove();
          }
          else if (l1 > localarxe.cacheTime)
          {
            l1 = localarxe.cacheTime;
            str = localarxe.urlKey;
          }
        }
        else
        {
          if (this.bq.size() >= 50)
          {
            arwt.d(TAG, "Reached max cache count:50. Clear last cache data. urlKey=" + ((arxe)this.bq.get(str)).urlKey);
            this.bq.remove(str);
            this.b.Xr("urlKey='" + str + "'");
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void qD(String paramString)
  {
    try
    {
      paramString = arwv.encodeHexStr(paramString);
      if (paramString != null)
      {
        this.bq.remove(paramString);
        this.b.Xr("urlKey='" + paramString + "'");
      }
      return;
    }
    finally {}
  }
  
  public String qE(String paramString)
  {
    String str2 = "\"\"";
    String str1 = str2;
    if (this.bq != null)
    {
      str1 = str2;
      if (this.bq.size() != 0)
      {
        paramString = arwv.encodeHexStr(paramString);
        str1 = str2;
        if (this.bq.get(paramString) != null) {
          str1 = ((arxe)this.bq.get(paramString)).etag;
        }
      }
    }
    arwt.d(TAG, "Get ETag from cache. ETag=" + str1);
    return str1;
  }
  
  public String qF(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (this.bq != null)
    {
      str1 = str2;
      if (this.bq.size() != 0)
      {
        paramString = arwv.encodeHexStr(paramString);
        str1 = str2;
        if (this.bq.get(paramString) != null) {
          str1 = ((arxe)this.bq.get(paramString)).cCO;
        }
      }
    }
    arwt.d(TAG, "Get lastModify from cache. lastModify=" + str1);
    return str1;
  }
  
  public String qG(String paramString)
  {
    String str1 = "";
    String str2 = str1;
    if (this.bq != null)
    {
      str2 = str1;
      if (this.bq.size() != 0)
      {
        str2 = arwv.encodeHexStr(paramString);
        paramString = str1;
        if (this.bq.get(str2) != null) {
          paramString = ((arxe)this.bq.get(str2)).response;
        }
        arwt.d(TAG, "Get 304, Load response data from cache. urlKey=" + str2);
        str2 = paramString;
      }
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxg
 * JD-Core Version:    0.7.0.1
 */