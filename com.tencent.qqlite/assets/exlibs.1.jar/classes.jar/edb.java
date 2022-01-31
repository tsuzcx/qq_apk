import com.tencent.mobileqq.service.HttpNotify;
import com.tencent.mobileqq.service.HttpRequestWifiphotoHandler;
import java.util.HashMap;

public class edb
  implements HttpNotify
{
  public edb(HttpRequestWifiphotoHandler paramHttpRequestWifiphotoHandler) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    HashMap localHashMap;
    if (this.a.a != null)
    {
      localHashMap = this.a.a;
      if (!paramBoolean) {
        break label45;
      }
    }
    label45:
    for (String str = "0";; str = "3")
    {
      localHashMap.put("wifiphoto_qualityReport_ErrCode", str);
      this.a.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     edb
 * JD-Core Version:    0.7.0.1
 */