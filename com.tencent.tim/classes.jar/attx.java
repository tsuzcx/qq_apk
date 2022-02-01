import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class attx
{
  private List<String> Be;
  private List<ProxyIpManager.ProxyIp> Bf;
  private ProxyIpManager.ProxyIp a;
  private String bHX;
  private boolean cdW;
  private Iterator<String> d;
  private Iterator<ProxyIpManager.ProxyIp> e;
  
  public attx(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = paramString.indexOf("://");
    int j;
    if (i == -1)
    {
      i = 0;
      j = paramString.substring(i).indexOf("/") + i;
      if ((-1 != j) || (-1 != j)) {
        break label116;
      }
      paramString = null;
    }
    for (;;)
    {
      if ((localObject != null) && (paramString != null))
      {
        this.Be = new ArrayList(1);
        this.Be.add(localObject);
        this.d = this.Be.iterator();
        this.bHX = paramString;
      }
      cT(paramQQAppInterface);
      return;
      i += 3;
      break;
      label116:
      int k = paramString.indexOf("&bHost=");
      if (-1 == k) {
        localObject = str;
      }
      for (;;)
      {
        if (localObject != null) {
          break label238;
        }
        localObject = paramString.substring(i, j);
        paramString = paramString.substring(j);
        break;
        int m = paramString.indexOf("&bPort=", k);
        localObject = str;
        if (-1 != m)
        {
          localObject = paramString.substring("&bHost=".length() + k, m);
          str = paramString.substring(m + "&bPort=".length());
          localObject = (String)localObject + ":" + str;
        }
      }
      label238:
      paramString = paramString.substring(j, k);
    }
  }
  
  public attx(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString)
  {
    this.Be = paramList;
    this.bHX = paramString;
    if (this.Be != null) {
      this.d = this.Be.iterator();
    }
    cT(paramQQAppInterface);
  }
  
  private void cT(QQAppInterface paramQQAppInterface)
  {
    this.Bf = ((ProxyIpManager)paramQQAppInterface.getManager(3)).getProxyIp(5);
    if (this.Bf == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("HttpUrlProcessor", 4, "HttpUrlProcessor: getProxyIp return null, so new empty ProxyList");
      }
      this.Bf = new ArrayList();
    }
    dhD();
  }
  
  public void dhD()
  {
    this.e = this.Bf.iterator();
    if (this.e.hasNext()) {
      this.a = ((ProxyIpManager.ProxyIp)this.e.next());
    }
    for (this.cdW = true;; this.cdW = false)
    {
      if (this.Be != null) {
        this.d = this.Be.iterator();
      }
      return;
    }
  }
  
  public String vg()
  {
    String str1 = null;
    String str2;
    if ((this.Be == null) || (this.Be.size() == 0))
    {
      str2 = str1;
      if (QLog.isDevelopLevel())
      {
        QLog.d("HttpUrlProcessor", 4, "getNextUrl: no host, so return null");
        str2 = str1;
      }
      return str2;
    }
    if (!this.d.hasNext())
    {
      if (this.e.hasNext())
      {
        this.a = ((ProxyIpManager.ProxyIp)this.e.next());
        this.d = this.Be.iterator();
      }
    }
    else
    {
      label94:
      str1 = (String)this.d.next();
      if (!this.cdW) {
        break label295;
      }
      int i = str1.indexOf(":");
      if (i <= 0) {
        break label287;
      }
      str2 = str1.substring(0, i);
      str1 = str1.substring(i + 1);
    }
    label140:
    label287:
    label295:
    for (str1 = "http://" + this.a.ip + ":" + this.a.port + this.bHX + "&bHost=" + str2 + "&bPort=" + str1;; str1 = "http://" + str1 + this.bHX)
    {
      str2 = str1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("HttpUrlProcessor", 4, "getNextUrl: url:" + str1);
      return str1;
      if (this.cdW)
      {
        this.cdW = false;
        this.d = this.Be.iterator();
        break label94;
      }
      str2 = str1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("HttpUrlProcessor", 4, "getNextUrl: no proxy no host, so return null");
      return null;
      str2 = str1;
      str1 = "80";
      break label140;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     attx
 * JD-Core Version:    0.7.0.1
 */