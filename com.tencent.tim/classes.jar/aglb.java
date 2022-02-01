import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class aglb
{
  private List<String> Be;
  private List<ProxyIpManager.ProxyIp> Bf;
  private ProxyIpManager.ProxyIp a;
  private String bHX;
  private boolean cdW;
  private Iterator<String> d;
  private Iterator<ProxyIpManager.ProxyIp> e;
  private boolean mIsHttps;
  
  public aglb(QQAppInterface paramQQAppInterface, String paramString)
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
  
  public aglb(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString)
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
  
  public static boolean isIp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i;
      if ((paramString.length() >= 7) && (paramString.length() <= 15))
      {
        paramString = paramString.split("\\.");
        if ((paramString != null) && (paramString.length == 4))
        {
          i = 0;
          if (i >= 4) {}
        }
      }
      try
      {
        int j = Integer.parseInt(paramString[i]);
        if ((j >= 0) && (j <= 255)) {
          i += 1;
        }
      }
      catch (Exception paramString) {}
    }
    return true;
    return false;
  }
  
  public static boolean mp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str2 = null;
    for (;;)
    {
      try
      {
        int i = paramString.indexOf("://");
        if (i == -1)
        {
          i = 0;
          String str1 = paramString.substring(i);
          if (TextUtils.isEmpty(str1)) {
            break;
          }
          int k = str1.indexOf("/");
          int j = k;
          if (-1 == k) {
            j = str1.length() - 1;
          }
          k = paramString.indexOf("&bHost=");
          if (-1 == k)
          {
            str1 = str2;
            if (str2 == null) {
              str1 = paramString.substring(i, j + i);
            }
            if (str1 == null) {
              break;
            }
            i = str1.indexOf(":");
            paramString = str1;
            if (i >= 0) {
              paramString = str1.substring(0, i);
            }
            return isIp(paramString);
          }
          int m = paramString.indexOf("&bPort=", k);
          if (-1 == m) {
            continue;
          }
          str1 = paramString.substring("&bHost=".length() + k, m);
          str2 = paramString.substring("&bPort=".length() + m);
          str2 = str1 + ":" + str2;
          continue;
        }
        i += 3;
      }
      catch (Exception paramString)
      {
        return false;
      }
    }
  }
  
  public void Jj(boolean paramBoolean)
  {
    this.mIsHttps = paramBoolean;
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
    Object localObject1 = null;
    Object localObject2;
    if ((this.Be == null) || (this.Be.size() == 0))
    {
      localObject2 = localObject1;
      if (QLog.isDevelopLevel())
      {
        QLog.d("HttpUrlProcessor", 4, "getNextUrl: no host, so return null");
        localObject2 = localObject1;
      }
      return localObject2;
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
      localObject2 = (String)this.d.next();
      QLog.e("HttpUrlProcessor", 4, "waterLog- getNextUrl: host[" + (String)localObject2 + "]");
      if (!this.cdW) {
        break label418;
      }
      int i = ((String)localObject2).indexOf(":");
      if (i <= 0) {
        break label330;
      }
      localObject1 = ((String)localObject2).substring(0, i);
      String str = ((String)localObject2).substring(i + 1);
      localObject2 = localObject1;
      localObject1 = str;
      label176:
      if (!this.mIsHttps) {
        break label349;
      }
      localObject1 = "https://" + this.a.ip + ":" + this.a.port + this.bHX + "&bHost=" + (String)localObject2 + "&bPort=" + (String)localObject1;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("HttpUrlProcessor", 4, "getNextUrl: url:" + (String)localObject1);
      return localObject1;
      if (this.cdW)
      {
        this.cdW = false;
        this.d = this.Be.iterator();
        break label94;
      }
      localObject2 = localObject1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("HttpUrlProcessor", 4, "getNextUrl: no proxy no host, so return null");
      return null;
      label330:
      if (this.mIsHttps)
      {
        localObject1 = "443";
        break label176;
      }
      localObject1 = "80";
      break label176;
      label349:
      localObject1 = "http://" + this.a.ip + ":" + this.a.port + this.bHX + "&bHost=" + (String)localObject2 + "&bPort=" + (String)localObject1;
      continue;
      label418:
      if (this.mIsHttps) {
        localObject1 = "https://" + (String)localObject2 + this.bHX;
      } else {
        localObject1 = "http://" + (String)localObject2 + this.bHX;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aglb
 * JD-Core Version:    0.7.0.1
 */