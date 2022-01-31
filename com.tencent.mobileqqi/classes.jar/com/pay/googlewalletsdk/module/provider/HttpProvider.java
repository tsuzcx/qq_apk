package com.pay.googlewalletsdk.module.provider;

import com.pay.googlewaletsdk.entity.DownloadInfo;
import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewaletsdk.tool.APToolAES;
import com.pay.googlewalletsdk.config.BaseConfig;
import com.pay.googlewalletsdk.http.BaseHttpPostClient;
import com.pay.googlewalletsdk.util.APBase64;
import com.pay.googlewalletsdk.util.APMD5;
import com.pay.googlewalletsdk.util.Purchase;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class HttpProvider
  extends BaseHttpPostClient
{
  StringBuffer body;
  StringBuffer encryptbody;
  
  public HttpProvider(DownloadInfo paramDownloadInfo)
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
    String str = APBase64.encode(((RequestInfo)localObject).purchase.getOriginalJson().getBytes());
    this.encryptbody.append("&sig=" + APMD5.toMd5(str.getBytes()));
    this.encryptbody.append("&amt=" + ((RequestInfo)localObject).amt);
    int i = this.encryptbody.length();
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
    Object localObject2 = localRequestInfo.from;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "default";
    }
    this.body.append("&from=" + (String)localObject1);
    localObject2 = localRequestInfo.varItem;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.body.append("&varitem=" + (String)localObject1);
    this.body.append("&billno=" + localRequestInfo.billno);
    localObject2 = localRequestInfo.purchase;
    localObject1 = ((Purchase)localObject2).getSignature();
    localObject2 = APBase64.encode(((Purchase)localObject2).getOriginalJson().getBytes());
    this.body.append("&dataSignature=" + (String)localObject1);
    this.body.append("&purchaseData=" + (String)localObject2);
    if (localRequestInfo.currencyType != null) {
      this.body.append("&currencyType=" + localRequestInfo.currencyType);
    }
    encryptBody();
    try
    {
      this.httpURLConnection.getOutputStream().write(this.body.toString().getBytes());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.module.provider.HttpProvider
 * JD-Core Version:    0.7.0.1
 */