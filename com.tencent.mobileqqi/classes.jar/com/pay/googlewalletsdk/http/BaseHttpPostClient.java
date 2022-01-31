package com.pay.googlewalletsdk.http;

import com.pay.googlewaletsdk.entity.DownloadInfo;
import java.io.PrintStream;
import java.net.HttpURLConnection;

public abstract class BaseHttpPostClient
  extends BaseHttpClient
{
  public BaseHttpPostClient(DownloadInfo paramDownloadInfo)
  {
    super(paramDownloadInfo);
  }
  
  private void setPostMothod()
  {
    try
    {
      this.httpURLConnection.setRequestProperty("Charset", "UTF-8");
      this.httpURLConnection.setRequestMethod("POST");
      this.httpURLConnection.setDoOutput(true);
      this.httpURLConnection.setDoInput(true);
      this.httpURLConnection.setRequestProperty("Connection", "close");
      this.httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected String modifyUrl()
  {
    String str = NetWorkFactory.getInstanceFactory().createEnvUrl(this.downloadInfo);
    System.out.println("url=" + str);
    return str;
  }
  
  public void setHeader()
  {
    setPostMothod();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.http.BaseHttpPostClient
 * JD-Core Version:    0.7.0.1
 */