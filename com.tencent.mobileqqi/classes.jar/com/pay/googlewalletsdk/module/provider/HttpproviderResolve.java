package com.pay.googlewalletsdk.module.provider;

import com.pay.googlewaletsdk.tool.PayUtil;
import com.pay.googlewalletsdk.http.BaseHttpClient;
import com.pay.googlewalletsdk.http.BaseHttpResolve;
import com.pay.googlewalletsdk.http.HttpClientHandle;
import java.io.PrintStream;
import java.util.HashMap;
import org.json.JSONObject;

public class HttpproviderResolve
  extends BaseHttpResolve
{
  public HttpproviderResolve(HttpClientHandle paramHttpClientHandle, HashMap<String, BaseHttpClient> paramHashMap)
  {
    super(paramHttpClientHandle, paramHashMap);
  }
  
  public void onDownLoadingResolve(byte[] paramArrayOfByte, int paramInt, long paramLong, BaseHttpClient paramBaseHttpClient) {}
  
  public void onErrorResolve() {}
  
  public void onFinishresolve(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = PayUtil.convertStreamToString(paramArrayOfByte, "utf-8");
    System.out.println("con=" + paramArrayOfByte);
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      int i = paramArrayOfByte.getInt("ret");
      if (i == 0) {
        return;
      }
      this.isError = true;
      this.errorCode = i;
      this.errorMessage = paramArrayOfByte.getString("msg");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      this.isError = true;
      this.errorMessage = "系统错误";
    }
    this.isError = true;
    this.errorCode = -1;
    this.errorMessage = "服务器错误";
    return;
  }
  
  public void onPauseResolve() {}
  
  public void onReadyResolve() {}
  
  public void onStartResolve() {}
  
  public void onStopResolve() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.module.provider.HttpproviderResolve
 * JD-Core Version:    0.7.0.1
 */