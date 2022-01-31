package oicq.wlogin_sdk.request;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class n
{
  protected y a;
  
  public String a(int paramInt)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "log.wtlogin.qq.com";
    arrayOfString[1] = "log1.wtlogin.qq.com";
    return arrayOfString[java.lang.Math.abs(paramInt % arrayOfString.length)];
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = util.get_rand_16byte(y.a);
    paramArrayOfByte = cryptor.encrypt(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte1);
    byte[] arrayOfByte2 = new byte[paramArrayOfByte.length + arrayOfByte1.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    return arrayOfByte2;
  }
  
  public int b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return 0;
    }
    util.LOGI(getClass().getName() + ":snd_rcv_req_error ...", "" + this.a.f);
    int i = new Random().nextInt();
    int j = 0;
    while (j < 2)
    {
      util.LOGI("try http connect " + j + " ...", "" + this.a.f);
      Object localObject = a(i);
      try
      {
        localObject = new URL("http://" + (String)localObject + "/cgi-bin/wlogin_proxy_log");
        util.LOGI("url=" + localObject, "" + this.a.f);
        localObject = (HttpURLConnection)((URL)localObject).openConnection();
        ((HttpURLConnection)localObject).setRequestMethod("POST");
        ((HttpURLConnection)localObject).setRequestProperty("Content-Type", "application/octet-stream");
        ((HttpURLConnection)localObject).setRequestProperty("Content-Disposition", "attachment; filename=micromsgresp.dat");
        ((HttpURLConnection)localObject).setRequestProperty("Content-Length", new Integer(paramArrayOfByte.length).toString());
        ((HttpURLConnection)localObject).setConnectTimeout(this.a.l);
        ((HttpURLConnection)localObject).setReadTimeout(this.a.l);
        ((HttpURLConnection)localObject).setDoOutput(true);
        util.LOGI("http request connect ...", "" + this.a.f);
        if (!m.a((HttpURLConnection)localObject, this.a.l))
        {
          util.LOGI("http request connect failed", "" + this.a.f);
          j += 1;
          i += 1;
        }
        else
        {
          util.LOGI("http request write ...", "" + this.a.f);
          OutputStream localOutputStream = ((HttpURLConnection)localObject).getOutputStream();
          localOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
          localOutputStream.flush();
          int k = ((HttpURLConnection)localObject).getResponseCode();
          util.LOGI("http request response code=" + k, "" + this.a.f);
          if (200 == k) {
            break;
          }
          util.LOGD("use http ret=" + k + " msg=" + ((HttpURLConnection)localObject).getResponseMessage());
          j += 1;
          i += 1;
        }
      }
      catch (Exception localException)
      {
        util.printException(localException, "" + this.a.f);
        j += 1;
        i += 1;
      }
    }
    if (j >= 1) {}
    for (i = -1000;; i = 0)
    {
      util.LOGI(getClass().getName() + ":snd_rcv_req_error ret=" + i, "" + this.a.f);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.n
 * JD-Core Version:    0.7.0.1
 */