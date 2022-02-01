package com.tencent.tmdownloader.internal.downloadclient;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantsdk.internal.b.b;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchSDKDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaResponse;
import com.tencent.tmdownloader.t;
import com.tencent.tmdownloader.u;

public class c
{
  private static String a = "TMAssistantYYBManager";
  private volatile b b;
  private u c;
  private Context d;
  private String e;
  private String f;
  private com.tencent.tmassistantsdk.internal.b.a g = new d(this);
  private com.tencent.tmdownloader.e h = new f(this);
  
  public static byte[] a(JceStruct paramJceStruct, String paramString)
  {
    ab.c(a, "jceStruct = " + paramJceStruct);
    paramJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramJceStruct, paramString);
    if (paramJceStruct != null)
    {
      paramJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramJceStruct);
      if ((paramJceStruct != null) && (paramJceStruct.length > 0))
      {
        ab.c(a, "return sendData length = " + paramJceStruct.length);
        return paramJceStruct;
      }
      ab.c(a, "handleUriAction sendData = null");
      return null;
    }
    ab.c(a, "handleUriAction IPCRequest = null");
    return null;
  }
  
  public void a()
  {
    t.a().post(new e(this));
  }
  
  public void a(Context paramContext, String paramString)
  {
    this.d = paramContext;
    this.e = paramString;
    ab.c(a, "initYYBClient yybOpenClient......" + this.b);
    if (this.b == null) {
      try
      {
        this.b = new b(paramContext, paramString, "com.tencent.android.qqdownloader.SDKService");
        this.b.initTMAssistantDownloadSDK();
        this.b.a(this.g);
        return;
      }
      finally {}
    }
  }
  
  public void a(BatchSDKDownloadActionResponse paramBatchSDKDownloadActionResponse)
  {
    if (this.c == null)
    {
      this.c = new u(this.d, this.f);
      this.c.a(this.h);
    }
    try
    {
      this.c.a(paramBatchSDKDownloadActionResponse);
      return;
    }
    catch (Exception paramBatchSDKDownloadActionResponse)
    {
      paramBatchSDKDownloadActionResponse.printStackTrace();
    }
  }
  
  public void a(SubScribeSDKDownloadTaskByViaResponse paramSubScribeSDKDownloadTaskByViaResponse)
  {
    if (this.c == null)
    {
      this.c = new u(this.d, this.f);
      this.c.a(this.h);
    }
    try
    {
      this.c.a(paramSubScribeSDKDownloadTaskByViaResponse);
      return;
    }
    catch (Exception paramSubScribeSDKDownloadTaskByViaResponse)
    {
      paramSubScribeSDKDownloadTaskByViaResponse.printStackTrace();
    }
  }
  
  public void b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.d = paramContext;
      this.f = paramString;
    } while (this.c != null);
    this.f = paramString;
    this.c = new u(paramContext, paramString);
    this.c.a(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.c
 * JD-Core Version:    0.7.0.1
 */