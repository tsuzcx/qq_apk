package com.pay.googlewalletsdk.module.resprovider;

import com.pay.googlewaletsdk.entity.DownloadInfo;
import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewalletsdk.http.BaseHttpPostClient;
import com.pay.googlewalletsdk.util.APBase64;
import com.pay.googlewalletsdk.util.Purchase;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;

public class HttpResProvider
  extends BaseHttpPostClient
{
  StringBuffer body;
  
  public HttpResProvider(DownloadInfo paramDownloadInfo)
  {
    super(paramDownloadInfo);
  }
  
  public void setBody()
  {
    this.body = new StringBuffer();
    Object localObject = ((RequestInfo)this.downloadInfo).purchase;
    String str = ((Purchase)localObject).getSignature();
    localObject = APBase64.encode(((Purchase)localObject).getOriginalJson().getBytes());
    this.body.append("dataSignature=" + str);
    this.body.append("&purchaseData=" + (String)localObject);
    try
    {
      System.out.println("body.toString()=" + this.body.toString());
      this.httpURLConnection.getOutputStream().write(this.body.toString().getBytes());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.module.resprovider.HttpResProvider
 * JD-Core Version:    0.7.0.1
 */