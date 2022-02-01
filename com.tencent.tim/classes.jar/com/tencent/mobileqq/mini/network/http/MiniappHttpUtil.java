package com.tencent.mobileqq.mini.network.http;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.plato.mqq.network.ProgressRequestBody;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import org.json.JSONObject;

public class MiniappHttpUtil
{
  public static final int C_TIME_OUT = 60000;
  public static final String HTTP_GET = "GET";
  public static final String HTTP_POST = "POST";
  public static final int LOCAL_RET_CODE_ABORTED = -5;
  public static final int LOCAL_RET_CODE_CLIENT_PROTOCOL_EXP = 8;
  public static final int LOCAL_RET_CODE_CONNECT = -2;
  public static final int LOCAL_RET_CODE_CONNECT_CLOSED_EXP = 14;
  public static final int LOCAL_RET_CODE_CONNECT_NOT_OPEN = 50007;
  public static final int LOCAL_RET_CODE_CONNECT_POOL_TIMEOUT_EXP = 13;
  public static final int LOCAL_RET_CODE_CONNECT_REFUSED = 50006;
  public static final int LOCAL_RET_CODE_CONNECT_TIMEOUT_EXP = 10;
  public static final int LOCAL_RET_CODE_CONTENT_LENGTH_VALID = 50002;
  public static final int LOCAL_RET_CODE_EXCEPTION = -1;
  public static final int LOCAL_RET_CODE_EXP = 4;
  public static final int LOCAL_RET_CODE_FNF_EXP = 1;
  public static final int LOCAL_RET_CODE_ILLEGAL_FORMAT_360WIFI = 50001;
  public static final int LOCAL_RET_CODE_ILL_EXP = 5;
  public static final int LOCAL_RET_CODE_IO_EXP = 2;
  public static final int LOCAL_RET_CODE_METHOD_NOT_SUPPORT = -3;
  public static final int LOCAL_RET_CODE_NETWORK_UNREACHABLE = 50004;
  public static final int LOCAL_RET_CODE_NOSPACE_LEFT_ON_DEVICE = 50003;
  public static final int LOCAL_RET_CODE_NO_HTTP_RSP_EXP = 11;
  public static final int LOCAL_RET_CODE_NO_ROUTE_TO_HOST = 50005;
  public static final int LOCAL_RET_CODE_OOM_ERR = 3;
  public static final int LOCAL_RET_CODE_SOCKET_EXP = 6;
  public static final int LOCAL_RET_CODE_SOCKET_TO_EXP = 7;
  public static final int LOCAL_RET_CODE_SSL_HANDSHAKE_EXP = 15;
  public static final int LOCAL_RET_CODE_SSL_PEER_UNVERIFIED_EXP = 12;
  public static final int LOCAL_RET_CODE_UNKNOW_HOST_EXP = 9;
  public static final int LOCAL_RET_CODE_URL_INVALID = -4;
  public static final int R_TIMEOUT = 60000;
  private static final String TAG = "MiniappHttpUtil";
  private static ConcurrentHashMap<String, HttpURLConnection> uploadMap = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, ArrayList<UploadTask>> uploadMapV2 = new ConcurrentHashMap();
  
  private static Request buildRequest(String paramString1, String[] paramArrayOfString, String paramString2, MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    Request.Builder localBuilder = new Request.Builder();
    if (paramArrayOfString != null)
    {
      int i = 0;
      String str1 = null;
      if (i < paramArrayOfString.length)
      {
        if (i % 2 == 0) {
          str1 = paramArrayOfString[i];
        }
        for (;;)
        {
          i += 1;
          break;
          String str2 = paramArrayOfString[i];
          try
          {
            localBuilder.addHeader(str1, str2);
          }
          catch (Throwable localThrowable)
          {
            QLog.e("MiniappHttpUtil", 1, "areqBuilder.addHeader.error: " + localThrowable);
          }
        }
      }
    }
    localBuilder.url(paramString1);
    if ("GET".equals(paramString2)) {
      localBuilder.get();
    }
    for (;;)
    {
      return localBuilder.build();
      paramString1 = localObject;
      if (HttpMethod.requiresRequestBody(paramString2))
      {
        paramString1 = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          paramString1 = new byte[0];
        }
        paramString1 = RequestBody.create(paramMediaType, paramString1);
      }
      localBuilder.method(paramString2, paramString1);
    }
  }
  
  public static void fillErrMsg(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    switch (paramInt)
    {
    case -4: 
    default: 
    case -5: 
      try
      {
        paramJSONObject.put("errMsg", "unknown reason");
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("MiniappHttpUtil", 1, "fillErrMsg", paramString);
        return;
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = "abort";; paramString = paramString + ":fail abort")
      {
        paramJSONObject.put("errMsg", paramString);
        return;
      }
    }
    paramJSONObject.put("errMsg", "request protocol error");
  }
  
  private static String getContentType(String paramString)
  {
    if ((paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg"))) {
      return "image/jpg";
    }
    if (paramString.endsWith(".png")) {
      return "image/png";
    }
    return "application/octet-stream";
  }
  
  public static String getRequestReferer(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    String str3 = "";
    String str2 = "debug";
    String str1 = str2;
    Object localObject = str3;
    if (paramBaseJsPluginEngine != null)
    {
      str1 = str2;
      localObject = str3;
    }
    try
    {
      if (paramBaseJsPluginEngine.appBrandRuntime != null)
      {
        str3 = paramBaseJsPluginEngine.appBrandRuntime.appId;
        str1 = str2;
        localObject = str3;
        if (paramBaseJsPluginEngine.appBrandRuntime.getApkgInfo() != null)
        {
          str1 = str2;
          localObject = str3;
          if (paramBaseJsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null)
          {
            str1 = str2;
            localObject = str3;
            if (paramBaseJsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config != null)
            {
              str1 = paramBaseJsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config.version;
              localObject = str3;
            }
          }
        }
      }
      localObject = new StringBuilder().append("https://appservice.qq.com/").append((String)localObject).append("/");
      paramBaseJsPluginEngine = str1;
      if (TextUtils.isEmpty(str1)) {
        paramBaseJsPluginEngine = "debug";
      }
      paramBaseJsPluginEngine = paramBaseJsPluginEngine + "/page-frame.html";
      return paramBaseJsPluginEngine;
    }
    finally {}
  }
  
  public static int getRetCodeFrom(Throwable paramThrowable, int paramInt)
  {
    if (paramThrowable != null)
    {
      if ((paramThrowable instanceof SSLPeerUnverifiedException)) {
        return 12;
      }
      if ((paramThrowable instanceof UnknownHostException)) {
        return 9;
      }
      if ((paramThrowable instanceof SSLHandshakeException)) {
        return 15;
      }
      if ((paramThrowable instanceof IllegalStateException))
      {
        paramThrowable = Log.getStackTraceString(paramThrowable);
        if ((paramThrowable != null) && (paramThrowable.contains("Connection is not open"))) {
          return 50007;
        }
        return 5;
      }
      if ((paramThrowable instanceof SocketException)) {
        return 6;
      }
      if ((paramThrowable instanceof SocketTimeoutException)) {
        return 7;
      }
      if ((paramThrowable instanceof FileNotFoundException)) {
        return 1;
      }
      if ((paramThrowable instanceof IOException))
      {
        paramThrowable = Log.getStackTraceString(paramThrowable);
        if ((paramThrowable != null) && (paramThrowable.contains("No space left on device"))) {
          return 50003;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("Network is unreachable"))) {
          return 50004;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("No route to host"))) {
          return 50005;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("Connection refused"))) {
          return 50006;
        }
        return 2;
      }
      if ((paramThrowable instanceof Exception)) {
        return 4;
      }
      if ((paramThrowable instanceof OutOfMemoryError)) {
        return 3;
      }
    }
    return paramInt;
  }
  
  private static Call httpConnect(String paramString1, String paramString2, String[] paramArrayOfString, byte[] paramArrayOfByte, HttpCallBack paramHttpCallBack, RequestConfig paramRequestConfig)
  {
    if ((TextUtils.isEmpty(paramString2)) || ((!paramString2.startsWith("https://")) && (!paramString2.startsWith("http://"))))
    {
      paramHttpCallBack.httpCallBack(-4, null, null);
      QLog.e("MiniappHttpUtil", 1, "httpConnect error! url invalid. url:" + paramString2);
      return null;
    }
    paramString1 = MiniOkHttpClientFactory.getRequestClient().newCall(buildRequest(paramString2, paramArrayOfString, paramString1, null, paramArrayOfByte));
    paramString1.enqueue(new MiniappHttpUtil.1(paramString2, paramHttpCallBack));
    return paramString1;
  }
  
  public static Call httpGetV2(String paramString, String[] paramArrayOfString, HttpCallBack paramHttpCallBack, RequestConfig paramRequestConfig)
  {
    return httpConnect("GET", paramString, paramArrayOfString, null, paramHttpCallBack, paramRequestConfig);
  }
  
  public static Call httpPostV2(String paramString, byte[] paramArrayOfByte, String[] paramArrayOfString, HttpCallBack paramHttpCallBack, RequestConfig paramRequestConfig)
  {
    return httpConnect("POST", paramString, paramArrayOfString, paramArrayOfByte, paramHttpCallBack, paramRequestConfig);
  }
  
  public static Call httpSendV2(String paramString1, String paramString2, byte[] paramArrayOfByte, String[] paramArrayOfString, HttpCallBack paramHttpCallBack, RequestConfig paramRequestConfig)
  {
    if ("CONNECT".equals(paramString1))
    {
      paramHttpCallBack.httpCallBack(-3, null, null);
      return null;
    }
    return httpConnect(paramString1, paramString2, paramArrayOfString, paramArrayOfByte, paramHttpCallBack, paramRequestConfig);
  }
  
  public static UploadTask httpUpload(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString4, String paramString5, HttpCallBack paramHttpCallBack)
  {
    return httpUploadInnerV2(paramString1, paramString2, paramString3, paramJSONObject1, paramJSONObject2, paramString4, paramString5, paramHttpCallBack);
  }
  
  private static UploadTask httpUploadInnerV2(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString4, String paramString5, HttpCallBack paramHttpCallBack)
  {
    paramString1 = new UploadTask(paramString1, paramString2, paramString3, paramJSONObject1, paramJSONObject2, paramString4, paramString5, paramHttpCallBack);
    ThreadPools.getNetworkIOThreadPool().execute(paramString1);
    return paramString1;
  }
  
  public static String[] mapToString(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    String[] arrayOfString = new String[paramMap.size() * 2];
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      arrayOfString[i] = str;
      i += 1;
      arrayOfString[i] = ((String)paramMap.get(str));
      i += 1;
    }
    return arrayOfString;
  }
  
  public static class UploadTask
    implements Runnable
  {
    Call call;
    HttpCallBack callBack;
    String filePath;
    JSONObject formDataObj;
    JSONObject headerObj;
    volatile boolean isCanceled = false;
    String method;
    String name;
    String uploadFileName;
    String url;
    
    UploadTask(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString4, String paramString5, HttpCallBack paramHttpCallBack)
    {
      this.method = paramString1;
      this.url = paramString2;
      this.filePath = paramString3;
      this.headerObj = paramJSONObject1;
      this.formDataObj = paramJSONObject2;
      this.name = paramString4;
      this.uploadFileName = paramString5;
      this.callBack = paramHttpCallBack;
    }
    
    private RequestBody buildMultiPartBody(JSONObject paramJSONObject, String paramString1, String paramString2)
    {
      MultipartBody.Builder localBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
      if (paramJSONObject != null)
      {
        localObject1 = paramJSONObject.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localBuilder.addFormDataPart((String)localObject2, paramJSONObject.optString((String)localObject2));
        }
      }
      Object localObject2 = new File(this.filePath);
      Object localObject1 = new ProgressRequestBody(RequestBody.create(MediaType.parse(MiniappHttpUtil.getContentType(this.filePath)), (File)localObject2), new MiniappHttpUtil.UploadTask.2(this));
      paramJSONObject = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramJSONObject = ((File)localObject2).getName();
      }
      localBuilder.addFormDataPart(paramString1, paramJSONObject, (RequestBody)localObject1);
      return localBuilder.build();
    }
    
    public void abort()
    {
      this.isCanceled = true;
      if (this.call != null) {
        this.call.cancel();
      }
    }
    
    public void run()
    {
      Request.Builder localBuilder;
      try
      {
        OkHttpClient localOkHttpClient = MiniOkHttpClientFactory.getUploadClient();
        localBuilder = new Request.Builder();
        localBuilder.tag(localOkHttpClient).url(this.url).addHeader("Charset", "utf-8").addHeader("connection", "keep-alive");
        if (this.headerObj != null)
        {
          Iterator localIterator = this.headerObj.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localBuilder.addHeader(str, this.headerObj.optString(str));
          }
        }
        localBuilder.method(this.method, buildMultiPartBody(this.formDataObj, this.name, this.uploadFileName));
      }
      catch (Throwable localThrowable)
      {
        localThrowable = localThrowable;
        QLog.e("MiniappHttpUtil", 1, "upload err", localThrowable);
        this.callBack.httpCallBack(MiniappHttpUtil.getRetCodeFrom(localThrowable, -1), null, null);
        return;
        if (this.isCanceled)
        {
          this.callBack.httpCallBack(-5, null, null);
          return;
        }
      }
      finally {}
      this.call = localObject.newCall(localBuilder.build());
      this.call.enqueue(new MiniappHttpUtil.UploadTask.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.MiniappHttpUtil
 * JD-Core Version:    0.7.0.1
 */