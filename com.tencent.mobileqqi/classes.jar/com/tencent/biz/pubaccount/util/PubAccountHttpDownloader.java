package com.tencent.biz.pubaccount.util;

import bre;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AccountNotMatchException;
import org.apache.http.Header;

public class PubAccountHttpDownloader
  extends HttpDownloader
{
  public static final String a = "PubAccountHttpDownloader";
  public static final String b = "pubaccountimage";
  private BaseApplicationImpl a;
  
  public PubAccountHttpDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  public static URL a(String paramString)
  {
    try
    {
      paramString = new URL("pubaccountimage", null, paramString);
      QLog.e("PubAccountHttpDownloader", 2, "<--generateURL urlString", localMalformedURLException1);
    }
    catch (MalformedURLException localMalformedURLException1)
    {
      try
      {
        QLog.d("PubAccountHttpDownloader", 2, "<--generateURL urlString =" + paramString.toString());
        return paramString;
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        break label45;
      }
      localMalformedURLException1 = localMalformedURLException1;
      paramString = null;
    }
    label45:
    return paramString;
  }
  
  private void a(String paramString, long paramLong)
  {
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    for (String[] arrayOfString = { "param_WIFIPublicPlatDownloadFlow", "param_WIFIFlow", "param_Flow" };; arrayOfString = new String[] { "param_XGPublicPlatDownloadFlow", "param_XGFlow", "param_Flow" }) {
      try
      {
        ((QQAppInterface)this.a.getAppRuntime(paramString)).a(paramString, arrayOfString, paramLong);
        QLog.d("PubAccountHttpDownloader", 2, "param_PublicPlatDownloadFlow fileSize: " + paramLong);
        return;
      }
      catch (AccountNotMatchException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams.url = new URL(paramDownloadParams.url.getFile());
    paramDownloadParams.urlStr = paramDownloadParams.url.toString();
    Header[] arrayOfHeader = paramDownloadParams.headers;
    int j = arrayOfHeader.length;
    String str = null;
    int i = 0;
    while (i < j)
    {
      Header localHeader = arrayOfHeader[i];
      if ("my_uin".equals(localHeader.getName())) {
        str = localHeader.getValue();
      }
      i += 1;
    }
    paramOutputStream = new bre(this, paramOutputStream);
    paramDownloadParams = super.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
    if (str != null) {
      a(str, paramOutputStream.a);
    }
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PubAccountHttpDownloader
 * JD-Core Version:    0.7.0.1
 */