package oicq.wlogin_sdk.request;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class k
{
  protected t a;
  
  public String a(int paramInt)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "log.wtlogin.qq.com";
    arrayOfString[1] = "log1.wtlogin.qq.com";
    return arrayOfString[java.lang.Math.abs(paramInt % arrayOfString.length)];
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = util.get_rand_16byte(t.a);
    paramArrayOfByte = cryptor.encrypt(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte1);
    byte[] arrayOfByte2 = new byte[paramArrayOfByte.length + arrayOfByte1.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    return arrayOfByte2;
  }
  
  public int b(byte[] paramArrayOfByte)
  {
    int k = 0;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return 0;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getClass().getName());
      ((StringBuilder)localObject1).append(":snd_rcv_req_error ...");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.a.f);
      util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
      int j = new Random().nextInt();
      int i = 0;
      while (i < 2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("try http connect ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" ...");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.a.f);
        util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
        localObject1 = a(j);
        try
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("http://");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("/cgi-bin/wlogin_proxy_log");
          localObject1 = new URL(((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("url=");
          ((StringBuilder)localObject2).append(localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("");
          localStringBuilder2.append(this.a.f);
          util.LOGI((String)localObject2, localStringBuilder2.toString());
          localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
          ((HttpURLConnection)localObject1).setRequestMethod("POST");
          ((HttpURLConnection)localObject1).setRequestProperty("Content-Type", "application/octet-stream");
          ((HttpURLConnection)localObject1).setRequestProperty("Content-Disposition", "attachment; filename=micromsgresp.dat");
          ((HttpURLConnection)localObject1).setRequestProperty("Content-Length", new Integer(paramArrayOfByte.length).toString());
          ((HttpURLConnection)localObject1).setConnectTimeout(this.a.l);
          ((HttpURLConnection)localObject1).setReadTimeout(this.a.l);
          ((HttpURLConnection)localObject1).setDoOutput(true);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(this.a.f);
          util.LOGI("http request connect ...", ((StringBuilder)localObject2).toString());
          if (!j.a((HttpURLConnection)localObject1, this.a.l))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(this.a.f);
            util.LOGI("http request connect failed", ((StringBuilder)localObject1).toString());
            i += 1;
            j += 1;
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(this.a.f);
            util.LOGI("http request write ...", ((StringBuilder)localObject2).toString());
            localObject2 = ((HttpURLConnection)localObject1).getOutputStream();
            ((OutputStream)localObject2).write(paramArrayOfByte, 0, paramArrayOfByte.length);
            ((OutputStream)localObject2).flush();
            int m = ((HttpURLConnection)localObject1).getResponseCode();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("http request response code=");
            ((StringBuilder)localObject1).append(m);
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(this.a.f);
            util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
            if (200 == m) {
              break;
            }
            i += 1;
            j += 1;
          }
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(this.a.f);
          util.printException(localException, ((StringBuilder)localObject2).toString());
          i += 1;
          j += 1;
        }
      }
      j = k;
      if (i >= 1) {
        j = -1000;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(getClass().getName());
      paramArrayOfByte.append(":snd_rcv_req_error ret=");
      paramArrayOfByte.append(j);
      paramArrayOfByte = paramArrayOfByte.toString();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("");
      localStringBuilder1.append(this.a.f);
      util.LOGI(paramArrayOfByte, localStringBuilder1.toString());
      return j;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.k
 * JD-Core Version:    0.7.0.1
 */