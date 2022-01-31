package com.pay.googlewalletsdk.module.changekey;

import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewaletsdk.entity.RequestInfo.keytype;
import com.pay.googlewaletsdk.tool.APToolAES;
import com.pay.googlewaletsdk.tool.PayUtil;
import com.pay.googlewalletsdk.config.BaseConfig;
import com.pay.googlewalletsdk.http.BaseHttpClient;
import com.pay.googlewalletsdk.http.BaseHttpResolve;
import com.pay.googlewalletsdk.http.HttpClientHandle;
import java.io.PrintStream;
import java.util.HashMap;
import org.json.JSONObject;

public class HttpChangeKeyResovle
  extends BaseHttpResolve
{
  private String realkey;
  
  public HttpChangeKeyResovle(HttpClientHandle paramHttpClientHandle, HashMap<String, BaseHttpClient> paramHashMap)
  {
    super(paramHttpClientHandle, paramHashMap);
  }
  
  public String getRealkey()
  {
    return this.realkey;
  }
  
  public void onDownLoadingResolve(byte[] paramArrayOfByte, int paramInt, long paramLong, BaseHttpClient paramBaseHttpClient) {}
  
  public void onErrorResolve() {}
  
  public void onFinishresolve(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = PayUtil.convertStreamToString(paramArrayOfByte, "utf-8");
    System.out.println("con=" + paramArrayOfByte);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      int i;
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte);
        i = paramArrayOfByte.getInt("ret");
        if (i != 0)
        {
          this.isError = true;
          this.errorCode = i;
          this.errorMessage = paramArrayOfByte.getString("msg");
          return;
        }
        Object localObject = paramArrayOfByte.getString("key_info");
        i = paramArrayOfByte.getInt("key_info_len");
        if (((RequestInfo)this.downloadInfo).keyType == RequestInfo.keytype.BaseKey)
        {
          paramArrayOfByte = "SAjUAcATIzxnw4v3";
          paramArrayOfByte = APToolAES.doDecode((String)localObject, paramArrayOfByte).substring(0, i).split("&");
          int j = paramArrayOfByte.length;
          i = 0;
          if (i >= j) {
            break label215;
          }
          localObject = paramArrayOfByte[i];
          if (!((String)localObject).contains("key")) {
            break label216;
          }
          int k = ((String)localObject).indexOf("=");
          if (k == -1) {
            break label216;
          }
          this.realkey = ((String)localObject).substring(k + 1);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        this.isError = true;
        this.errorMessage = "系统错误";
        return;
      }
      paramArrayOfByte = BaseConfig.sercretKey;
      continue;
      this.isError = true;
      this.errorCode = -1;
      this.errorMessage = "服务器错误";
      label215:
      return;
      label216:
      i += 1;
    }
  }
  
  public void onPauseResolve() {}
  
  public void onReadyResolve() {}
  
  public void onStartResolve() {}
  
  public void onStopResolve() {}
  
  public void setRealkey(String paramString)
  {
    this.realkey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.module.changekey.HttpChangeKeyResovle
 * JD-Core Version:    0.7.0.1
 */