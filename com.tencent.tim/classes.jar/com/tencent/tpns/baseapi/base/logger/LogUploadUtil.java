package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.core.a;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

public class LogUploadUtil
{
  private static int a = 0;
  
  private static void a(Context paramContext, File paramFile, String paramString, HttpRequestCallback paramHttpRequestCallback)
  {
    String str1 = "TPNS" + System.currentTimeMillis();
    Object localObject;
    try
    {
      localObject = (HttpURLConnection)new URL(paramString).openConnection();
      ((HttpURLConnection)localObject).setReadTimeout(10000);
      ((HttpURLConnection)localObject).setConnectTimeout(10000);
      ((HttpURLConnection)localObject).setDoInput(true);
      ((HttpURLConnection)localObject).setDoOutput(true);
      ((HttpURLConnection)localObject).setUseCaches(false);
      ((HttpURLConnection)localObject).setRequestMethod("POST");
      ((HttpURLConnection)localObject).setRequestProperty("Charset", "utf-8");
      ((HttpURLConnection)localObject).setRequestProperty("connection", "keep-alive");
      ((HttpURLConnection)localObject).setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + str1);
      long l = XGApiConfig.getAccessId(paramContext);
      paramContext = XGApiConfig.getAccessKey(paramContext);
      String str2 = "Basic " + Base64.encodeToString(new StringBuilder().append(l).append(":").append(paramContext).toString().getBytes("UTF-8"), 0);
      ((HttpURLConnection)localObject).addRequestProperty("Authorization", str2);
      TBaseLogger.d("LogUploadUtil - TPush", "Authorization Basic: " + l + ":" + paramContext + ", auth:" + str2);
      if (paramFile != null)
      {
        TBaseLogger.v("LogUploadUtil - TPush", "action - uploadFile, filename:" + paramFile.getName() + ", url:" + paramString);
        paramContext = new DataOutputStream(((HttpURLConnection)localObject).getOutputStream());
        paramString = new StringBuffer();
        paramString.append("--");
        paramString.append(str1);
        paramString.append("\r\n");
        paramString.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + paramFile.getName() + "\"" + "\r\n");
        paramString.append("Content-Type: application/octet-stream; charset=utf-8" + "\r\n");
        paramString.append("\r\n");
        paramContext.write(paramString.toString().getBytes());
        paramFile = new FileInputStream(paramFile);
        paramString = new byte[1024];
        for (;;)
        {
          i = paramFile.read(paramString);
          if (i == -1) {
            break;
          }
          paramContext.write(paramString, 0, i);
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      TBaseLogger.e("LogUploadUtil - TPush", "unexpected for doUploadFile:", paramContext);
      a(paramHttpRequestCallback, -1, "unexpected exception for uploadFile:" + paramContext.getMessage());
    }
    paramFile.close();
    paramContext.write("\r\n".getBytes());
    paramContext.write(("--" + str1 + "--" + "\r\n").getBytes());
    paramContext.flush();
    int i = ((HttpURLConnection)localObject).getResponseCode();
    paramContext = ((HttpURLConnection)localObject).getResponseMessage();
    TBaseLogger.v("LogUploadUtil - TPush", "response code:" + i + ", msg:" + paramContext);
    if (i == 200)
    {
      paramFile = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject).getInputStream()));
      paramString = new StringBuffer();
      for (;;)
      {
        localObject = paramFile.readLine();
        if (localObject == null) {
          break;
        }
        paramString.append((String)localObject);
      }
      TBaseLogger.i("LogUploadUtil - TPush", "HttpPost response data:" + paramString.toString());
      a(paramHttpRequestCallback, i, paramContext, paramString.toString());
      paramFile.close();
      return;
    }
    TBaseLogger.e("LogUploadUtil - TPush", "HttpPost Server response error");
    a(paramHttpRequestCallback, i, paramContext);
  }
  
  private static void a(HttpRequestCallback paramHttpRequestCallback, int paramInt, String paramString)
  {
    if (paramHttpRequestCallback != null) {
      paramHttpRequestCallback.onFailure(paramInt, paramString);
    }
  }
  
  private static void a(HttpRequestCallback paramHttpRequestCallback, int paramInt, String paramString1, String paramString2)
  {
    if (paramHttpRequestCallback != null) {}
    try
    {
      String str = new JSONObject(paramString2).optString("url", "");
      TBaseLogger.v("LogUploadUtil - TPush", "fileUrl:" + str);
      paramHttpRequestCallback.onSuccess(str);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramHttpRequestCallback.onFailure(paramInt, paramString1 + "\n" + paramString2);
    }
  }
  
  private static void a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    label29:
    File localFile;
    if (i < j)
    {
      localFile = paramFile[i];
      if (localFile != null)
      {
        if (!localFile.isFile()) {
          break label61;
        }
        localFile.delete();
      }
    }
    for (;;)
    {
      i += 1;
      break label29;
      break;
      label61:
      if (localFile.isDirectory()) {
        a(localFile);
      }
    }
  }
  
  private static void a(String paramString)
  {
    a(new File(paramString));
  }
  
  private static void a(String paramString1, String paramString2)
  {
    TBaseLogger.v("LogUploadUtil - TPush", "zipFolder, srcFile:" + paramString1 + ", zipFile:" + paramString2);
    paramString2 = new ZipOutputStream(new FileOutputStream(paramString2));
    paramString1 = new File(paramString1);
    String[] arrayOfString = paramString1.list();
    if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
      throw new NoSuchFieldException("no log files");
    }
    a(paramString1.getParent() + File.separator, paramString1.getName(), paramString2);
    paramString2.finish();
    paramString2.close();
  }
  
  private static void a(String paramString1, String paramString2, ZipOutputStream paramZipOutputStream)
  {
    int j = 0;
    TBaseLogger.v("LogUploadUtil - TPush", "zipFiles, folder:" + paramString1 + ", fileName:" + paramString2);
    if (paramZipOutputStream == null) {}
    for (;;)
    {
      return;
      Object localObject = new File(paramString1 + paramString2);
      if (((File)localObject).isFile()) {
        paramString2 = new ZipEntry(paramString2);
      }
      try
      {
        paramString1 = new FileInputStream((File)localObject);
        try
        {
          paramZipOutputStream.putNextEntry(paramString2);
          paramString2 = new byte[4096];
          for (;;)
          {
            i = paramString1.read(paramString2);
            if (i == -1) {
              break;
            }
            paramZipOutputStream.write(paramString2, 0, i);
          }
          if (paramString1 == null) {
            continue;
          }
        }
        catch (Throwable paramString2) {}
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          int i;
          paramString1 = null;
        }
      }
      paramString1.close();
      return;
      paramZipOutputStream.closeEntry();
      paramString1.close();
      return;
      localObject = ((File)localObject).list();
      if (localObject != null)
      {
        i = j;
        if (localObject.length <= 0)
        {
          paramZipOutputStream.putNextEntry(new ZipEntry(paramString2 + File.separator));
          paramZipOutputStream.closeEntry();
          i = j;
        }
        while (i < localObject.length)
        {
          a(paramString1, paramString2 + File.separator + localObject[i], paramZipOutputStream);
          i += 1;
        }
      }
    }
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, HttpRequestCallback paramHttpRequestCallback)
  {
    if (paramContext == null)
    {
      TBaseLogger.w("LogUploadUtil - TPush", "unexpected for uploadFile, context is null");
      a(paramHttpRequestCallback, -1, "context is null");
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      TBaseLogger.w("LogUploadUtil - TPush", "unexpected for uploadFile, log cannot be found");
      a(paramHttpRequestCallback, -1, "unexpected for uploadFile, log cannot be found");
      return;
    }
    long l;
    try
    {
      l = XGApiConfig.getAccessId(paramContext);
      if (l == -1L)
      {
        a(paramHttpRequestCallback, -1, "unexpected for uploadFile, log cannot be found");
        return;
      }
    }
    catch (Throwable paramContext)
    {
      TBaseLogger.w("LogUploadUtil - TPush", "unexpected exception for uploadFile:" + paramContext.getMessage());
      a(paramHttpRequestCallback, -1, "unexpected exception for uploadFile:" + paramContext.getMessage());
      return;
    }
    Object localObject = GuidInfoManager.getToken(paramContext);
    paramString2 = paramString1 + File.separator + paramString2;
    paramString1 = paramString1 + File.separator + paramString3;
    paramString3 = paramString1 + File.separator + l + "_" + (String)localObject + "_" + LogUtil.getTodayDateTimeForFilename() + ".zip";
    localObject = new File(paramString3);
    ((File)localObject).getParentFile().mkdirs();
    if ((!((File)localObject).exists()) && (!((File)localObject).createNewFile())) {
      TBaseLogger.w("LogUploadUtil - TPush", "unexpected createNewFile return false");
    }
    a(paramString2, paramString3);
    if (((File)localObject).length() > 104857600L)
    {
      a(paramHttpRequestCallback, -1, "log upload error, please try again.");
      a(paramString1);
      int i = a + 1;
      a = i;
      TBaseLogger.removeOldDebugLogFiles(i);
      return;
    }
    a(paramContext, (File)localObject, a.h(paramContext), paramHttpRequestCallback);
    a(paramString1);
    a(paramString2);
  }
  
  public static void uploadFile(Context paramContext, String paramString1, String paramString2, String paramString3, HttpRequestCallback paramHttpRequestCallback)
  {
    CommonWorkingThread.getInstance().execute(new LogUploadUtil.1(paramContext, paramString1, paramString2, paramString3, paramHttpRequestCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.logger.LogUploadUtil
 * JD-Core Version:    0.7.0.1
 */