package com.pay.googlewalletsdk.module.order;

import com.pay.googlewaletsdk.entity.DownloadInfo;
import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewaletsdk.tool.APToolAES;
import com.pay.googlewalletsdk.config.BaseConfig;
import com.pay.googlewalletsdk.http.BaseHttpPostClient;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;

public class HttpOrder
  extends BaseHttpPostClient
{
  StringBuffer body;
  StringBuffer encryptbody;
  
  public HttpOrder(DownloadInfo paramDownloadInfo)
  {
    super(paramDownloadInfo);
  }
  
  private void encryptBody()
  {
    Object localObject = (RequestInfo)this.downloadInfo;
    this.encryptbody = new StringBuffer();
    this.encryptbody.append("productid=" + ((RequestInfo)localObject).productID);
    this.encryptbody.append("&producttype=" + ((RequestInfo)localObject).productType);
    this.encryptbody.append("&payitem=" + ((RequestInfo)localObject).payItem);
    this.encryptbody.append("&skey=" + ((RequestInfo)localObject).openkey + ";" + ((RequestInfo)localObject).session_type);
    this.encryptbody.append("&amt=" + ((RequestInfo)localObject).amt);
    int i = this.encryptbody.length();
    System.out.println("BaseConfig.appKey=" + BaseConfig.appKey + " len=" + i);
    localObject = APToolAES.doEncode(this.encryptbody.toString(), BaseConfig.appKey);
    this.body.append("&msg_len=" + i);
    this.body.append("&encrypt_msg=" + (String)localObject);
  }
  
  public void setBody()
  {
    RequestInfo localRequestInfo = (RequestInfo)this.downloadInfo;
    this.body = new StringBuffer();
    this.body.append("uin=" + localRequestInfo.openid);
    this.body.append("&cmd=" + localRequestInfo.getKey());
    this.body.append("&appid=" + localRequestInfo.appid);
    this.body.append("&ts=" + System.currentTimeMillis());
    this.body.append("&quantity=" + localRequestInfo.quantity);
    this.body.append("&uinType=" + localRequestInfo.session_id);
    this.body.append("&version=1.0.2");
    if (localRequestInfo.pf != null) {
      this.body.append("&pf=" + localRequestInfo.pf);
    }
    if (localRequestInfo.pfkey != null) {
      this.body.append("&pfkey=" + localRequestInfo.pfkey);
    }
    if (localRequestInfo.isDepostGameCoin) {
      this.body.append("&type=save");
    }
    if (localRequestInfo.zoneid != null) {
      this.body.append("&zoneid=" + localRequestInfo.zoneid);
    }
    String str2 = localRequestInfo.from;
    String str1 = str2;
    if (str2 == null) {
      str1 = "default";
    }
    this.body.append("&from=" + str1);
    str2 = localRequestInfo.varItem;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.body.append("&varitem=" + str1);
    this.body.append("&sig=66699C48F");
    if (localRequestInfo.currencyType != null) {
      this.body.append("&currencyType=" + localRequestInfo.currencyType);
    }
    encryptBody();
    try
    {
      this.httpURLConnection.getOutputStream().write(this.body.toString().getBytes());
      System.out.println("orderbody=" + new String(this.body.toString().getBytes(), "utf-8"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.module.order.HttpOrder
 * JD-Core Version:    0.7.0.1
 */