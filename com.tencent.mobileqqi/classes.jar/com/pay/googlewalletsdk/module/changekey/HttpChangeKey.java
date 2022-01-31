package com.pay.googlewalletsdk.module.changekey;

import com.pay.googlewaletsdk.entity.DownloadInfo;
import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewaletsdk.entity.RequestInfo.keytype;
import com.pay.googlewaletsdk.tool.APToolAES;
import com.pay.googlewalletsdk.config.BaseConfig;
import com.pay.googlewalletsdk.http.BaseHttpPostClient;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class HttpChangeKey
  extends BaseHttpPostClient
{
  StringBuffer body;
  StringBuffer encryptbody;
  
  public HttpChangeKey(DownloadInfo paramDownloadInfo)
  {
    super(paramDownloadInfo);
  }
  
  private void createSSLConnection()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, null, new SecureRandom());
      HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void encryptBody()
  {
    this.encryptbody = new StringBuffer();
    Object localObject = (RequestInfo)this.downloadInfo;
    this.encryptbody.append("openid=" + ((RequestInfo)localObject).openid);
    this.encryptbody.append("&openkey=" + ((RequestInfo)localObject).openkey);
    this.encryptbody.append("&session_id=" + ((RequestInfo)localObject).session_id);
    this.encryptbody.append("&session_type=" + ((RequestInfo)localObject).session_type);
    if (((RequestInfo)localObject).keyType == RequestInfo.keytype.BaseKey) {}
    for (localObject = "SAjUAcATIzxnw4v3";; localObject = BaseConfig.sercretKey)
    {
      this.encryptbody.append("&key=" + (String)localObject);
      int i = this.encryptbody.length();
      localObject = APToolAES.doEncode(this.encryptbody.toString(), (String)localObject);
      this.body.append("&msg_len=" + i);
      this.body.append("&encrypt_msg=" + (String)localObject);
      return;
    }
  }
  
  public void setBody()
  {
    RequestInfo localRequestInfo = (RequestInfo)this.downloadInfo;
    this.body = new StringBuffer();
    this.body.append("pf=" + localRequestInfo.pf);
    this.body.append("&pfkey=" + localRequestInfo.pfkey);
    this.body.append("&openid=" + localRequestInfo.openid);
    if (localRequestInfo.keyType == RequestInfo.keytype.BaseKey)
    {
      this.body.append("&type=secret");
      this.body.append("&vid=cpay_1.1.1");
    }
    for (;;)
    {
      encryptBody();
      try
      {
        System.out.println("body=" + this.body);
        this.httpURLConnection.getOutputStream().write(this.body.toString().getBytes());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.body.append("&type=crypto");
    }
  }
  
  public void setHeader()
  {
    createSSLConnection();
    super.setHeader();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.module.changekey.HttpChangeKey
 * JD-Core Version:    0.7.0.1
 */