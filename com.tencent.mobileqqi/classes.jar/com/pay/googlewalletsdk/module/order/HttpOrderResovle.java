package com.pay.googlewalletsdk.module.order;

import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewaletsdk.tool.PayUtil;
import com.pay.googlewalletsdk.http.BaseHttpClient;
import com.pay.googlewalletsdk.http.BaseHttpResolve;
import com.pay.googlewalletsdk.http.HttpClientHandle;
import java.io.PrintStream;
import java.util.HashMap;
import org.json.JSONObject;

public class HttpOrderResovle
  extends BaseHttpResolve
{
  private String billno;
  
  public HttpOrderResovle(HttpClientHandle paramHttpClientHandle, HashMap<String, BaseHttpClient> paramHashMap)
  {
    super(paramHttpClientHandle, paramHashMap);
  }
  
  public String getBillno()
  {
    return this.billno;
  }
  
  public void onDownLoadingResolve(byte[] paramArrayOfByte, int paramInt, long paramLong, BaseHttpClient paramBaseHttpClient) {}
  
  public void onErrorResolve() {}
  
  public void onFinishresolve(byte[] paramArrayOfByte)
  {
    Object localObject = PayUtil.convertStreamToString(paramArrayOfByte, "utf-8");
    System.out.println("con=" + (String)localObject);
    paramArrayOfByte = (RequestInfo)this.downloadInfo;
    if (localObject != null) {
      try
      {
        localObject = new JSONObject((String)localObject);
        int i = ((JSONObject)localObject).getInt("ret");
        if (i != 0)
        {
          this.isError = true;
          this.errorCode = i;
          this.errorMessage = ((JSONObject)localObject).getString("msg");
          return;
        }
        this.billno = ((JSONObject)localObject).getString("billno");
        paramArrayOfByte.billno = this.billno;
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        this.isError = true;
        this.errorMessage = "系统错误";
        return;
      }
    }
    this.isError = true;
    this.errorCode = -1;
    this.errorMessage = "服务器错误";
  }
  
  public void onPauseResolve() {}
  
  public void onReadyResolve() {}
  
  public void onStartResolve() {}
  
  public void onStopResolve() {}
  
  public void setBillno(String paramString)
  {
    this.billno = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.module.order.HttpOrderResovle
 * JD-Core Version:    0.7.0.1
 */