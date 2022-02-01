package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import hlu;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpCgiAsyncTask
  extends HttpAsyncTask
{
  public static final int a = 3;
  public static final String a = "ResultType";
  public static final int b = 0;
  public static final String b = "ResultValue";
  public static final int c = 1;
  public static final String c = "httpdatamodified";
  protected Handler a;
  public HttpCgiAsyncTask.Callback a;
  
  public HttpCgiAsyncTask(String paramString1, String paramString2, HttpCgiAsyncTask.Callback paramCallback)
  {
    super(paramString1, paramString2);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask$Callback = null;
    this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask$Callback = paramCallback;
  }
  
  public static int a(IOException paramIOException)
  {
    if ((paramIOException instanceof CharConversionException)) {
      return -20;
    }
    if ((paramIOException instanceof MalformedInputException)) {
      return -21;
    }
    if ((paramIOException instanceof UnmappableCharacterException)) {
      return -22;
    }
    if ((paramIOException instanceof HttpResponseException)) {
      return -23;
    }
    if ((paramIOException instanceof ClosedChannelException)) {
      return -24;
    }
    if ((paramIOException instanceof ConnectionClosedException)) {
      return -25;
    }
    if ((paramIOException instanceof EOFException)) {
      return -26;
    }
    if ((paramIOException instanceof FileLockInterruptionException)) {
      return -27;
    }
    if ((paramIOException instanceof FileNotFoundException)) {
      return -28;
    }
    if ((paramIOException instanceof HttpRetryException)) {
      return -29;
    }
    if ((paramIOException instanceof ConnectTimeoutException)) {
      return -7;
    }
    if ((paramIOException instanceof SocketTimeoutException)) {
      return -8;
    }
    if ((paramIOException instanceof InvalidPropertiesFormatException)) {
      return -30;
    }
    if ((paramIOException instanceof MalformedChunkCodingException)) {
      return -31;
    }
    if ((paramIOException instanceof MalformedURLException)) {
      return -3;
    }
    if ((paramIOException instanceof NoHttpResponseException)) {
      return -32;
    }
    if ((paramIOException instanceof InvalidClassException)) {
      return -33;
    }
    if ((paramIOException instanceof InvalidObjectException)) {
      return -34;
    }
    if ((paramIOException instanceof NotActiveException)) {
      return -35;
    }
    if ((paramIOException instanceof NotSerializableException)) {
      return -36;
    }
    if ((paramIOException instanceof OptionalDataException)) {
      return -37;
    }
    if ((paramIOException instanceof StreamCorruptedException)) {
      return -38;
    }
    if ((paramIOException instanceof WriteAbortedException)) {
      return -39;
    }
    if ((paramIOException instanceof ProtocolException)) {
      return -40;
    }
    if ((paramIOException instanceof SSLHandshakeException)) {
      return -41;
    }
    if ((paramIOException instanceof SSLKeyException)) {
      return -42;
    }
    if ((paramIOException instanceof SSLPeerUnverifiedException)) {
      return -43;
    }
    if ((paramIOException instanceof SSLProtocolException)) {
      return -44;
    }
    if ((paramIOException instanceof BindException)) {
      return -45;
    }
    if ((paramIOException instanceof ConnectException)) {
      return -46;
    }
    if ((paramIOException instanceof NoRouteToHostException)) {
      return -47;
    }
    if ((paramIOException instanceof PortUnreachableException)) {
      return -48;
    }
    if ((paramIOException instanceof SyncFailedException)) {
      return -49;
    }
    if ((paramIOException instanceof UTFDataFormatException)) {
      return -50;
    }
    if ((paramIOException instanceof UnknownHostException)) {
      return -51;
    }
    if ((paramIOException instanceof UnknownServiceException)) {
      return -52;
    }
    if ((paramIOException instanceof UnsupportedEncodingException)) {
      return -53;
    }
    if ((paramIOException instanceof ZipException)) {
      return -54;
    }
    return -2;
  }
  
  public HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return HttpBaseUtil.a(paramString1, paramString2, paramBundle);
  }
  
  protected HashMap a(Bundle... paramVarArgs)
  {
    return b(paramVarArgs);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask$Callback = null;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  public void a(Bundle paramBundle)
  {
    Executor localExecutor = a();
    if (localExecutor != null)
    {
      executeOnExecutor(localExecutor, new Bundle[] { paramBundle });
      return;
    }
    execute(new Bundle[] { paramBundle });
  }
  
  protected void a(HashMap paramHashMap)
  {
    if (!isCancelled()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new hlu(this, paramHashMap));
    }
  }
  
  public HashMap b(Bundle... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    if (isCancelled()) {
      return localHashMap;
    }
    long l3 = SystemClock.elapsedRealtime();
    long l1 = 0L;
    String str2 = this.h;
    Object localObject = paramVarArgs[0].getString("appid_for_getting_config");
    try
    {
      bool = paramVarArgs[0].getBoolean("from_h5", false);
      j = OpenConfig.a(CommonDataAdapter.a().a(), (String)localObject).a("Common_HttpRetryCount");
      LogUtility.c("OpenConfig_agent", "config 1:Common_HttpRetryCount            config_value:" + j + "   appid:" + (String)localObject + "     url:" + str2);
      if (j == 0)
      {
        j = 3;
        LogUtility.c("OpenConfig_agent", "config 1:Common_HttpRetryCount            result_value:" + j + "   appid:" + (String)localObject + "     url:" + str2);
        i = 0;
        if (!isCancelled()) {
          break label188;
        }
        return localHashMap;
      }
    }
    catch (Exception localException)
    {
      int j;
      int i;
      label188:
      int k;
      long l2;
      long l4;
      long l5;
      label1256:
      for (;;)
      {
        boolean bool = false;
        continue;
        continue;
        k = i + 1;
        l2 = l1;
        l4 = l1;
        for (;;)
        {
          try
          {
            localStatistic = a(this.h, this.i, paramVarArgs[0]);
            l2 = l1;
            l4 = l1;
            str1 = localStatistic.jdField_a_of_type_JavaLangString;
            if (!bool) {
              continue;
            }
            l2 = l1;
            l4 = l1;
            localObject = new JSONObject();
            l2 = l1;
            l4 = l1;
            str1 = HttpBaseUtil.a(str1);
            l2 = l1;
            l4 = l1;
            ((JSONObject)localObject).put("content", str1);
            l2 = l1;
            l4 = l1;
            LogUtility.a("HttpCgiAsyncTask", "response.isModified= " + localStatistic.jdField_a_of_type_Int);
            l2 = l1;
            l4 = l1;
            if (localStatistic.jdField_a_of_type_Int == 0)
            {
              if (!bool) {
                continue;
              }
              l2 = l1;
              l4 = l1;
              JSONObject localJSONObject = new JSONObject();
              l2 = l1;
              l4 = l1;
              localJSONObject.put("httpdatamodified", localStatistic.jdField_a_of_type_Int);
              l2 = l1;
              l4 = l1;
              ((JSONObject)localObject).put("extend", localJSONObject);
            }
            l2 = l1;
            l4 = l1;
            localHashMap.put("ResultType", Integer.valueOf(1));
            l2 = l1;
            l4 = l1;
            localHashMap.put("ResultValue", localObject);
            if (!bool) {
              continue;
            }
            l2 = l1;
            l4 = l1;
            localObject = Pattern.compile("\"(?:ret|resultCode)\"\\s*\\:\\s*(\\d+)").matcher(str1);
            l2 = l1;
            l4 = l1;
            if (!((Matcher)localObject).find()) {
              continue;
            }
            l2 = l1;
            l4 = l1;
            i = Integer.parseInt(((Matcher)localObject).group(1));
          }
          catch (ConnectTimeoutException localConnectTimeoutException)
          {
            HttpBaseUtil.Statistic localStatistic;
            String str1;
            localConnectTimeoutException.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", localConnectTimeoutException);
            i = -7;
            l1 = SystemClock.elapsedRealtime();
            l2 = 0L;
            if (k < j) {
              break label1256;
            }
            l4 = 0L;
            l3 = l1;
            l1 = l4;
            continue;
            i = -55;
            continue;
            l2 = l1;
            l4 = l1;
            try
            {
              i = localConnectTimeoutException.getInt("ret");
            }
            catch (JSONException localJSONException2)
            {
              l2 = l1;
              l4 = l1;
              try
              {
                i = localConnectTimeoutException.getInt("resultCode");
              }
              catch (JSONException localJSONException1)
              {
                i = -55;
              }
            }
            continue;
          }
          catch (SocketTimeoutException localSocketTimeoutException)
          {
            localSocketTimeoutException.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", localSocketTimeoutException);
            i = -8;
            l1 = SystemClock.elapsedRealtime();
            continue;
          }
          catch (JSONException paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            l1 = 0L;
            l2 = 0L;
            i = -4;
            continue;
          }
          catch (HttpBaseUtil.NetworkUnavailableException paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            return localHashMap;
          }
          catch (HttpBaseUtil.HttpStatusException paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            try
            {
              i = Integer.parseInt(paramVarArgs.getMessage().replace("http status code error:", ""));
              ReportManager.a().a(str2, l3, l2, 0L, i, CommonDataAdapter.a().a(), "1000002", null);
              return localHashMap;
            }
            catch (Exception paramVarArgs)
            {
              paramVarArgs.printStackTrace();
              continue;
            }
          }
          catch (IOException paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            i = a(paramVarArgs);
            l1 = 0L;
            l2 = 0L;
            continue;
          }
          catch (Exception paramVarArgs)
          {
            if (!(paramVarArgs instanceof HttpBaseUtil.NetworkUnavailableException)) {
              continue;
            }
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            return localHashMap;
            if (!(paramVarArgs instanceof HttpBaseUtil.HttpStatusException)) {
              continue;
            }
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            try
            {
              i = Integer.parseInt(paramVarArgs.getMessage().replace("http status code error:", ""));
              ReportManager.a().a(str2, l3, l4, 0L, i, CommonDataAdapter.a().a(), "1000002", null);
              return localHashMap;
            }
            catch (Exception paramVarArgs)
            {
              paramVarArgs.printStackTrace();
              continue;
            }
            if (!(paramVarArgs instanceof IOException)) {
              continue;
            }
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            i = a((IOException)paramVarArgs);
            l1 = 0L;
            l2 = 0L;
            continue;
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            i = -6;
            l1 = 0L;
            l2 = 0L;
            continue;
          }
          l2 = l1;
          l4 = l1;
          l1 = localStatistic.jdField_a_of_type_Long;
          l2 = l1;
          l4 = l1;
          l5 = localStatistic.b;
          l2 = l5;
          LogUtility.c("ReportManager", str2 + " | " + l3 + " | " + l1 + " | " + l2 + " | " + i);
          l5 = 0L;
          try
          {
            paramVarArgs = BaseApplicationImpl.a().getFirstSimpleAccount();
            l4 = l5;
            if (paramVarArgs != null) {
              l4 = Long.valueOf(paramVarArgs.getUin()).longValue();
            }
          }
          catch (Exception paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            l4 = l5;
            continue;
            i = k;
            l2 = 0L;
            l3 = l1;
            l1 = l2;
          }
          ReportManager.a().a(str2, l3, l1, l2, i, l4, "1000002", null);
          return localHashMap;
          l2 = l1;
          l4 = l1;
          localObject = HttpBaseUtil.a(str1);
          continue;
          l2 = l1;
          l4 = l1;
          ((JSONObject)localObject).put("httpdatamodified", localStatistic.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask$Callback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCgiAsyncTask
 * JD-Core Version:    0.7.0.1
 */