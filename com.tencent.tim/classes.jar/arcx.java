import com.tencent.mobileqq.webview.webso.HttpRequestPackage;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import wns_proxy.HttpRsp;

public class arcx
{
  private final String CRLF = "\r\n";
  public String czD;
  public String czE;
  public String czF;
  public String entity_body;
  
  public arcx(HttpRsp paramHttpRsp)
  {
    Wj(paramHttpRsp.rspinfo);
    this.entity_body = paramHttpRsp.body;
  }
  
  private void Wj(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramString = paramString.substring(0, paramString.indexOf("\r\n\r\n") - 1).split("\r\n");
        int j = paramString.length;
        if (i < j) {
          if (i == 0)
          {
            Wk(paramString[i]);
          }
          else
          {
            Object localObject = paramString[i];
            int k = localObject.indexOf(":");
            put(localObject.substring(0, k).trim(), localObject.substring(k + 1, localObject.length()));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("HttpResponsePackage", 1, paramString.toString());
      }
      return;
      i += 1;
    }
  }
  
  private void Wk(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = paramString.split(" ");
      if ((paramString != null) && (paramString.length == 3))
      {
        this.czE = paramString[0];
        this.czD = paramString[1];
        this.czF = paramString[2];
      }
    }
  }
  
  private void put(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        paramString1 = HttpRequestPackage.class.getDeclaredField(paramString1);
        if (paramString1 != null)
        {
          paramString1.set(this, paramString2);
          return;
        }
      }
      catch (NoSuchFieldException paramString1) {}catch (IllegalArgumentException paramString1) {}catch (IllegalAccessException paramString1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcx
 * JD-Core Version:    0.7.0.1
 */