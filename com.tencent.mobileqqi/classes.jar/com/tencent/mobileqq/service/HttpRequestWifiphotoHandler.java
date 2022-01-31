package com.tencent.mobileqq.service;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore.Images.Media;
import com.dataline.util.file.FileUtil;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wifiphoto.WifiPhotoDataCenter;
import wifiphoto.WifiPhotoDataCenter.WpBucketData;
import wifiphoto.WifiPhotoDataCenter.WpPhotoData;
import wifiphoto.WifiPhotoStatusMgr;
import wifiphoto.WifiPhotoUrlParser;

public class HttpRequestWifiphotoHandler
  implements HttpRequestHandler
{
  public void a(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, String paramString)
  {
    int i;
    int j;
    if (DataLineHandler.a.b.containsKey(paramString))
    {
      paramString = (WifiPhotoDataCenter.WpPhotoData)DataLineHandler.a.b.get(paramString);
      if (paramString.d != null) {
        break label251;
      }
      paramString.d = FileUtil.b(BaseApplication.getContext(), paramString.c);
      if (paramString.d == null) {
        break label285;
      }
      paramHttpResponse.setStatusCode(200);
      paramString = new File(paramString.d);
      paramHttpRequest = paramHttpRequest.getFirstHeader("Range");
      if (paramHttpRequest == null) {
        break label483;
      }
      paramHttpRequest = paramHttpRequest.getValue();
      i = paramHttpRequest.indexOf("=");
      j = paramHttpRequest.indexOf("-");
      if ((i <= 0) || (j <= 0) || (j <= i)) {
        break label483;
      }
      paramHttpRequest = Long.valueOf(Long.parseLong(paramHttpRequest.substring(i + 1, j)));
      if (paramHttpRequest.longValue() <= 0L) {
        break label483;
      }
    }
    label285:
    label483:
    for (long l1 = paramHttpRequest.longValue();; l1 = 0L)
    {
      long l2 = paramString.length();
      paramHttpResponse.addHeader("Content-Range", "bytes : " + String.valueOf(l1) + "-" + String.valueOf(l2 - 1L) + "/" + String.valueOf(l2));
      paramHttpResponse.setEntity(new DataLineHttpFileEntity(paramString, l1, 0L, "text/html", null));
      return;
      label251:
      if (new File(paramString.d).exists()) {
        break;
      }
      paramString.d = FileUtil.b(BaseApplication.getContext(), paramString.c);
      break;
      paramHttpResponse.setStatusCode(404);
      paramString = new File(paramString.c);
      paramHttpRequest = paramHttpRequest.getFirstHeader("Range");
      if (paramHttpRequest != null)
      {
        paramHttpRequest = paramHttpRequest.getValue();
        i = paramHttpRequest.indexOf("=");
        j = paramHttpRequest.indexOf("-");
        if ((i > 0) && (j > 0) && (j > i))
        {
          paramHttpRequest = Long.valueOf(Long.parseLong(paramHttpRequest.substring(i + 1, j)));
          if (paramHttpRequest.longValue() <= 0L) {}
        }
      }
      for (l1 = paramHttpRequest.longValue();; l1 = 0L)
      {
        l2 = paramString.length();
        paramHttpResponse.addHeader("Content-Range", "bytes : " + String.valueOf(l1) + "-" + String.valueOf(l2 - 1L) + "/" + String.valueOf(l2));
        paramHttpResponse.setEntity(new DataLineHttpFileEntity(paramString, l1, 0L, "text/html", null));
        return;
      }
    }
  }
  
  public void a(HttpResponse paramHttpResponse)
  {
    Object localObject1 = new JSONArray();
    Object localObject2 = DataLineHandler.a.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      WifiPhotoDataCenter.WpBucketData localWpBucketData = (WifiPhotoDataCenter.WpBucketData)((Map.Entry)((Iterator)localObject2).next()).getValue();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("name", localWpBucketData.jdField_a_of_type_JavaLangString);
        localJSONObject.put("thumb", String.format("?action=groupthumb&iid=%s", new Object[] { localWpBucketData.c }));
        localJSONObject.put("id", localWpBucketData.b);
        localJSONObject.put("index", localWpBucketData.jdField_a_of_type_Int);
        localJSONObject.put("count", localWpBucketData.jdField_a_of_type_JavaUtilList.size());
        ((JSONArray)localObject1).put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    localObject1 = ((JSONArray)localObject1).toString();
    localObject2 = DataLineHandler.a.jdField_a_of_type_JavaLangString;
    localObject1 = Base64Util.a(new Cryptor().encrypt(((String)localObject1).getBytes(), ((String)localObject2).getBytes()), 0);
    paramHttpResponse.setStatusCode(200);
    paramHttpResponse.setEntity(new StringEntity((String)localObject1));
  }
  
  public void a(HttpResponse paramHttpResponse, String paramString)
  {
    if (!DataLineHandler.a.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {}
    do
    {
      return;
      localObject = new JSONArray();
      paramString = (WifiPhotoDataCenter.WpBucketData)DataLineHandler.a.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    Iterator localIterator = paramString.jdField_a_of_type_JavaUtilList.iterator();
    i = 0;
    if (localIterator.hasNext())
    {
      paramString = (String)localIterator.next();
      j = i;
      WifiPhotoDataCenter.WpPhotoData localWpPhotoData;
      JSONObject localJSONObject;
      if (DataLineHandler.a.b.containsKey(paramString))
      {
        localWpPhotoData = (WifiPhotoDataCenter.WpPhotoData)DataLineHandler.a.b.get(paramString);
        j = i;
        if (localWpPhotoData != null) {
          localJSONObject = new JSONObject();
        }
      }
      for (;;)
      {
        try
        {
          localJSONObject.put("imageid", paramString);
          localJSONObject.put("time", localWpPhotoData.b);
          localJSONObject.put("name", localWpPhotoData.f);
          localJSONObject.put("size", localWpPhotoData.g);
          localJSONObject.put("md5key", localWpPhotoData.e);
          localJSONObject.put("thumb", String.format("?action=imagethumb&iid=%s", new Object[] { paramString }));
          localJSONObject.put("origin", String.format("?action=imageorigin&iid=%s", new Object[] { paramString }));
          j = i + 1;
        }
        catch (JSONException paramString)
        {
          try
          {
            localJSONObject.put("index", i);
            ((JSONArray)localObject).put(localJSONObject);
            i = j;
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              i = j;
            }
          }
          paramString = paramString;
        }
        paramString.printStackTrace();
        j = i;
        i = j;
      }
    }
    paramString = ((JSONArray)localObject).toString();
    Object localObject = DataLineHandler.a.jdField_a_of_type_JavaLangString;
    paramString = Base64Util.a(new Cryptor().encrypt(paramString.getBytes(), ((String)localObject).getBytes()), 0);
    paramHttpResponse.setStatusCode(200);
    paramHttpResponse.setEntity(new StringEntity(paramString));
  }
  
  public void b(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, String paramString)
  {
    if (DataLineHandler.a.b.containsKey(paramString))
    {
      paramString = (WifiPhotoDataCenter.WpPhotoData)DataLineHandler.a.b.get(paramString);
      paramHttpResponse.setStatusCode(200);
      paramString = new File(paramString.c);
      paramHttpRequest = paramHttpRequest.getFirstHeader("Range");
      if (paramHttpRequest == null) {
        break label242;
      }
      paramHttpRequest = paramHttpRequest.getValue();
      int i = paramHttpRequest.indexOf("=");
      int j = paramHttpRequest.indexOf("-");
      if ((i <= 0) || (j <= 0) || (j <= i)) {
        break label242;
      }
      paramHttpRequest = Long.valueOf(Long.parseLong(paramHttpRequest.substring(i + 1, j)));
      if (paramHttpRequest.longValue() <= 0L) {
        break label242;
      }
    }
    label242:
    for (long l1 = paramHttpRequest.longValue();; l1 = 0L)
    {
      long l2 = paramString.length();
      paramHttpResponse.addHeader("Content-Range", "bytes : " + String.valueOf(l1) + "-" + String.valueOf(l2 - 1L) + "/" + String.valueOf(l2));
      paramHttpResponse.setEntity(new DataLineHttpFileEntity(paramString, l1, 0L, "text/html", null));
      return;
      QLog.d("wifiphoto", 2, "handleImageOrigin not found the imageid");
      c(paramHttpResponse, "no such image");
      return;
    }
  }
  
  public void b(HttpResponse paramHttpResponse)
  {
    paramHttpResponse.setStatusCode(200);
    paramHttpResponse.setEntity(new StringEntity("0"));
  }
  
  public void b(HttpResponse paramHttpResponse, String paramString)
  {
    Object localObject;
    boolean bool1;
    if (DataLineHandler.a.b.containsKey(paramString))
    {
      localObject = (WifiPhotoDataCenter.WpPhotoData)DataLineHandler.a.b.get(paramString);
      if (((WifiPhotoDataCenter.WpPhotoData)localObject).c != null)
      {
        File localFile = new File(((WifiPhotoDataCenter.WpPhotoData)localObject).c);
        if ((localFile.exists()) && (localFile.delete()))
        {
          bool1 = true;
          BaseApplication.getContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data='" + ((WifiPhotoDataCenter.WpPhotoData)localObject).c + "'", null);
          bool2 = bool1;
          if (((WifiPhotoDataCenter.WpPhotoData)localObject).d != null)
          {
            localObject = new File(((WifiPhotoDataCenter.WpPhotoData)localObject).d);
            bool2 = bool1;
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("imageid", paramString);
        ((JSONObject)localObject).put("deleteresult", bool2);
        paramString = ((JSONObject)localObject).toString();
        localObject = DataLineHandler.a.jdField_a_of_type_JavaLangString;
        paramString = Base64Util.a(new Cryptor().encrypt(paramString.getBytes(), ((String)localObject).getBytes()), 0);
        paramHttpResponse.setStatusCode(200);
        paramHttpResponse.setEntity(new StringEntity(paramString));
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      bool1 = false;
      break;
    }
  }
  
  public void c(HttpResponse paramHttpResponse, String paramString)
  {
    paramHttpResponse.setStatusCode(404);
    paramHttpResponse.setEntity(new StringEntity(paramString));
  }
  
  public void handle(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    QLog.d("wifiphoto", 2, "HttpRequestWifiphotoHandler begin");
    if (!DataLineHandler.a.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.a())
    {
      QLog.d("wifiphoto", 2, "HttpRequestWifiphotoHandler wifiphoto is not open");
      c(paramHttpResponse, "wifi photo closed");
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramHttpContext = paramHttpRequest.getRequestLine().getUri();
              QLog.d("wifiphoto", 2, "HttpRequestWifiphotoHandler target is :" + paramHttpContext);
              paramHttpContext = paramHttpContext.trim();
              if (!paramHttpContext.startsWith("/wifiphoto"))
              {
                QLog.d("wifiphoto", 2, "HttpRequestWifiphotoHandler target is not start with wifiphoto");
                c(paramHttpResponse, "not start with wifiphoto");
                return;
              }
              paramHttpContext = new WifiPhotoUrlParser(paramHttpContext);
              if (!paramHttpContext.a())
              {
                QLog.d("wifiphoto", 2, "HttpRequestWifiphotoHandler target is url parse error");
                c(paramHttpResponse, "url parse error");
                return;
              }
              paramHttpContext = paramHttpContext.a();
              if (paramHttpContext == null)
              {
                QLog.d("wifiphoto", 2, "HttpRequestWifiphotoHandler no params");
                c(paramHttpResponse, "no params");
                return;
              }
              if (!paramHttpContext.containsKey("action"))
              {
                QLog.d("wifiphoto", 2, "HttpRequestWifiphotoHandler no action");
                c(paramHttpResponse, "no action");
                return;
              }
              localObject = new Intent();
              if (localObject != null)
              {
                ((Intent)localObject).setAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CONNECTED");
                BaseApplication.getContext().sendBroadcast((Intent)localObject);
              }
              localObject = (String)paramHttpContext.get("action");
              try
              {
                DataLineHandler.a.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.c();
                DataLineHandler.a.jdField_a_of_type_Long = System.currentTimeMillis();
                if (((String)localObject).equalsIgnoreCase("grouplist"))
                {
                  a(paramHttpResponse);
                  return;
                }
              }
              catch (Throwable paramHttpRequest)
              {
                c(paramHttpResponse, "error");
                return;
              }
              if (!((String)localObject).equalsIgnoreCase("imagelist")) {
                break;
              }
            } while (!paramHttpContext.containsKey("gid"));
            a(paramHttpResponse, (String)paramHttpContext.get("gid"));
            return;
            if (!((String)localObject).equalsIgnoreCase("groupthumb")) {
              break;
            }
          } while (!paramHttpContext.containsKey("iid"));
          a(paramHttpRequest, paramHttpResponse, (String)paramHttpContext.get("iid"));
          return;
          if (!((String)localObject).equalsIgnoreCase("imagethumb")) {
            break;
          }
        } while (!paramHttpContext.containsKey("iid"));
        a(paramHttpRequest, paramHttpResponse, (String)paramHttpContext.get("iid"));
        return;
        if (!((String)localObject).equalsIgnoreCase("imageorigin")) {
          break;
        }
      } while (!paramHttpContext.containsKey("iid"));
      b(paramHttpRequest, paramHttpResponse, (String)paramHttpContext.get("iid"));
      return;
      if (((String)localObject).equalsIgnoreCase("heartbeat"))
      {
        b(paramHttpResponse);
        return;
      }
      if (!((String)localObject).equalsIgnoreCase("imagedelete")) {
        break;
      }
    } while (!paramHttpContext.containsKey("iid"));
    b(paramHttpResponse, (String)paramHttpContext.get("iid"));
    return;
    QLog.d("wifiphoto", 2, "HttpRequestWifiphotoHandler out of case");
    c(paramHttpResponse, "out of case");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.HttpRequestWifiphotoHandler
 * JD-Core Version:    0.7.0.1
 */