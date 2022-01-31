package com.pay.googlewalletsdk.http;

import android.text.TextUtils;
import com.pay.googlewaletsdk.entity.DownloadInfo;
import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewalletsdk.config.BaseConfig;
import com.pay.googlewalletsdk.module.changekey.HttpChangeKey;
import com.pay.googlewalletsdk.module.changekey.HttpChangeKeyResovle;
import com.pay.googlewalletsdk.module.order.HttpOrder;
import com.pay.googlewalletsdk.module.order.HttpOrderResovle;
import com.pay.googlewalletsdk.module.provider.HttpProvider;
import com.pay.googlewalletsdk.module.provider.HttpproviderResolve;
import com.pay.googlewalletsdk.module.resprovider.HttpResProvider;
import java.util.HashMap;

public class NetWorkFactory
{
  private static Object lock = new Object();
  private static NetWorkFactory netWorkFactory;
  
  public static NetWorkFactory getInstanceFactory()
  {
    if (netWorkFactory == null) {}
    synchronized (lock)
    {
      if (netWorkFactory == null) {
        netWorkFactory = new NetWorkFactory();
      }
      return netWorkFactory;
    }
  }
  
  public String createEnvUrl(DownloadInfo paramDownloadInfo)
  {
    String str2 = "";
    String str1 = str2;
    String str3;
    String str4;
    if (paramDownloadInfo != null)
    {
      str3 = paramDownloadInfo.getKey();
      paramDownloadInfo = (RequestInfo)paramDownloadInfo;
      str1 = str2;
      if (!TextUtils.isEmpty(str3))
      {
        str4 = BaseConfig.env;
        if (!str4.equals("test")) {
          break label106;
        }
        BaseConfig.domain = "sandbox.api.unipay.qq.com";
        if (!str3.equals("changekey")) {
          break label210;
        }
        if (!str4.equals("test")) {
          break label132;
        }
        paramDownloadInfo = String.format("/v1/r/%s/mobile_get_key", new Object[] { paramDownloadInfo.appid });
        str1 = "https://sandbox.api.unipay.qq.com" + paramDownloadInfo;
      }
    }
    label106:
    do
    {
      return str1;
      if (str4.equals("dev"))
      {
        BaseConfig.domain = "112.90.139.30";
        break;
      }
      BaseConfig.domain = "hk.api.unipay.qq.com";
      break;
      if (str4.equals("dev"))
      {
        paramDownloadInfo = String.format("/cgi-bin/mobile_get_key.fcg", new Object[] { paramDownloadInfo.appid });
        return "https://112.90.139.30" + paramDownloadInfo;
      }
      paramDownloadInfo = String.format("/v1/r/%s/mobile_get_key", new Object[] { paramDownloadInfo.appid });
      return "http://hk.api.unipay.qq.com" + paramDownloadInfo;
      if (str3.equals("order"))
      {
        if (str4.equals("test"))
        {
          paramDownloadInfo = String.format("/cgi-bin/gwallet_proc.fcg", new Object[] { paramDownloadInfo.appid });
          return "http://sandbox.api.unipay.qq.com" + paramDownloadInfo;
        }
        if (str4.equals("dev"))
        {
          paramDownloadInfo = String.format("/cgi-bin/gwallet_proc.fcg", new Object[] { paramDownloadInfo.appid });
          return "http://112.90.139.30" + paramDownloadInfo;
        }
        paramDownloadInfo = String.format("/cgi-bin/gwallet_proc.fcg", new Object[] { paramDownloadInfo.appid });
        return "http://hk.api.unipay.qq.com" + paramDownloadInfo;
      }
      if (str3.equals("provide"))
      {
        if (str4.equals("test"))
        {
          paramDownloadInfo = String.format("/cgi-bin/gwallet_proc.fcg", new Object[] { paramDownloadInfo.appid });
          return "http://sandbox.api.unipay.qq.com" + paramDownloadInfo;
        }
        if (str4.equals("dev"))
        {
          paramDownloadInfo = String.format("/cgi-bin/gwallet_proc.fcg", new Object[] { paramDownloadInfo.appid });
          return "http://112.90.139.30" + paramDownloadInfo;
        }
        paramDownloadInfo = String.format("/cgi-bin/gwallet_proc.fcg", new Object[] { paramDownloadInfo.appid });
        return "http://hk.api.unipay.qq.com" + paramDownloadInfo;
      }
      str1 = str2;
    } while (!str3.equals("restorprovide"));
    label132:
    label210:
    if (str4.equals("test"))
    {
      paramDownloadInfo = String.format("/cgi-bin/gwallet_simple_provide.fcg", new Object[] { paramDownloadInfo.appid });
      return "http://sandbox.api.unipay.qq.com" + paramDownloadInfo;
    }
    if (str4.equals("dev"))
    {
      paramDownloadInfo = String.format("/cgi-bin/gwallet_simple_provide.fcg", new Object[] { paramDownloadInfo.appid });
      return "http://112.90.139.30" + paramDownloadInfo;
    }
    paramDownloadInfo = String.format("/cgi-bin/gwallet_simple_provide.fcg", new Object[] { paramDownloadInfo.appid });
    return "http://hk.api.unipay.qq.com" + paramDownloadInfo;
  }
  
  public BaseHttpClient createHttpClient(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      String str = paramDownloadInfo.getKey();
      if (!TextUtils.isEmpty(str))
      {
        if (str.equals("changekey")) {
          return new HttpChangeKey(paramDownloadInfo);
        }
        if (str.equals("order")) {
          return new HttpOrder(paramDownloadInfo);
        }
        if (str.equals("provide")) {
          return new HttpProvider(paramDownloadInfo);
        }
        if (str.equals("restorprovide")) {
          return new HttpResProvider(paramDownloadInfo);
        }
      }
    }
    return null;
  }
  
  public BaseHttpResolve createHttpResolve(DownloadInfo paramDownloadInfo, HashMap<String, BaseHttpClient> paramHashMap)
  {
    if (paramDownloadInfo != null)
    {
      paramDownloadInfo = paramDownloadInfo.getKey();
      if (!TextUtils.isEmpty(paramDownloadInfo))
      {
        HttpClientHandle localHttpClientHandle = HttpClientHandle.getIntanceHandel();
        if (paramDownloadInfo.equals("changekey")) {
          return new HttpChangeKeyResovle(localHttpClientHandle, paramHashMap);
        }
        if (paramDownloadInfo.equals("order")) {
          return new HttpOrderResovle(localHttpClientHandle, paramHashMap);
        }
        if (paramDownloadInfo.equals("provide")) {
          return new HttpproviderResolve(localHttpClientHandle, paramHashMap);
        }
        if (paramDownloadInfo.equals("restorprovide")) {
          return new HttpproviderResolve(localHttpClientHandle, paramHashMap);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.http.NetWorkFactory
 * JD-Core Version:    0.7.0.1
 */