package com.tencent.biz.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import bhw;
import bhx;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareToQZone
{
  public static Context a;
  public static Bundle a;
  public static Handler a;
  public static ShareToQZoneBack a;
  public static Runnable a;
  public static String a;
  public static String b;
  private static final String c = "\r\n";
  private static final String d = "---------------------soijfoejoijfasoe";
  
  static
  {
    jdField_a_of_type_JavaLangString = "ShareToQZone";
    b = null;
    jdField_a_of_type_AndroidOsHandler = new bhw();
    jdField_a_of_type_JavaLangRunnable = new bhx();
  }
  
  public static int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "======postToQZone =========");
    }
    String str4 = jdField_a_of_type_AndroidOsBundle.getString("vkey");
    String str5 = jdField_a_of_type_AndroidOsBundle.getString("uin");
    Object localObject = jdField_a_of_type_AndroidOsBundle.getString("title");
    String str2 = jdField_a_of_type_AndroidOsBundle.getString("summary");
    String str3 = jdField_a_of_type_AndroidOsBundle.getString("imageUrl");
    String str6 = jdField_a_of_type_AndroidOsBundle.getString("url");
    String str7 = jdField_a_of_type_AndroidOsBundle.getString("site");
    String str8 = jdField_a_of_type_AndroidOsBundle.getString("fromUrl");
    String str1 = jdField_a_of_type_AndroidOsBundle.getString("comment");
    String str9 = jdField_a_of_type_AndroidOsBundle.getString("sdk_type");
    Long localLong = Long.valueOf(jdField_a_of_type_AndroidOsBundle.getLong("res_share_id", 0L));
    boolean bool = jdField_a_of_type_AndroidOsBundle.getBoolean("picOnly", false);
    Bundle localBundle = new Bundle();
    localBundle.putString("platform", "androidqz");
    localBundle.putString("sdk_type", str9);
    localBundle.putString("title", (String)localObject);
    localBundle.putString("url", str6);
    localBundle.putString("site", str7);
    localBundle.putString("fromurl", str8);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, str7 + ",fromUrl:" + str8);
    }
    localObject = str1;
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() > 400) {
        localObject = str1.substring(0, 400) + "...";
      }
    }
    localBundle.putString("comment", (String)localObject);
    localBundle.putString("type", "4");
    localBundle.putString("format", "json");
    if (localLong.longValue() > 0L) {
      localBundle.putString("oauth_consumer_key", Long.toString(localLong.longValue()));
    }
    str1 = "vkey=" + str4 + ";uin=" + str5;
    localObject = new Bundle();
    ((Bundle)localObject).putString("Cookie", str1);
    if (bool) {
      return a(str3, "http://openmobile.qq.com/api/share/add_share_pic?t=" + System.currentTimeMillis(), str1, localBundle);
    }
    str1 = "http://openmobile.qq.com/api/share/add_share?t=" + System.currentTimeMillis();
    localBundle.putString("summary", str2);
    localBundle.putString("images", str3);
    try
    {
      localObject = new JSONObject(HttpUtil.a(jdField_a_of_type_AndroidContentContext, str1, "POST", localBundle, (Bundle)localObject));
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "HttpUtil post :json:" + ((JSONObject)localObject).toString());
      }
      if (jdField_a_of_type_ComTencentBizCommonUtilShareToQZoneBack != null)
      {
        b = ((JSONObject)localObject).getString("msg");
        return ((JSONObject)localObject).getInt("ret");
      }
      b = "http error";
      return 4;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      b = "JSONException";
      return 1;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      localClientProtocolException.printStackTrace();
      b = "ClientProtocolException";
      return 1;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      b = "IOException";
    }
    return 3;
  }
  
  private static int a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramString2 = new HttpPost(paramString2);
    paramString2.setHeader("Connection", "keep-alive");
    paramString2.setHeader("cookie", paramString3);
    paramString2.setHeader("Referer", "http://openmobile.qq.com/");
    paramString2.setHeader("Content-Type", "multipart/form-data;boundary=" + "---------------------soijfoejoijfasoe");
    paramString3 = new ByteArrayOutputStream();
    File localFile = new File(paramString1);
    try
    {
      if (!paramBundle.isEmpty())
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = paramBundle.getString(str1);
          if (str2 != null)
          {
            paramString3.write("\r\n-----------------------soijfoejoijfasoe\r\n".getBytes());
            paramString3.write(("Content-Disposition: form-data; name=\"" + str1 + "\"" + "\r\n" + "\r\n").getBytes());
            paramString3.write(str2.getBytes());
          }
        }
      }
      paramString3.write("\r\n-----------------------soijfoejoijfasoe\r\n".getBytes());
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      b = "IOException";
      return 5;
    }
    paramString3.write(("Content-Disposition: form-data; name=\"picture\";filename=\"" + localFile.getName() + "\"" + "\r\n").getBytes());
    paramString3.write("Content-Type: image/jpeg\r\n\r\n".getBytes());
    paramString1 = a(paramString1, 640, 10000);
    if (paramString1 == null)
    {
      paramString3.close();
      b = "CompressImageError";
      return 7;
    }
    paramString3.write(paramString1);
    paramString3.write("\r\n-----------------------soijfoejoijfasoe--\r\n".getBytes());
    paramString1 = paramString3.toByteArray();
    paramString3.close();
    paramString2.setEntity(new ByteArrayEntity(paramString1));
    try
    {
      paramString1 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(paramString1, 15000);
      HttpConnectionParams.setSoTimeout(paramString1, 30000);
      paramString1 = new DefaultHttpClient(paramString1).execute(paramString2);
      paramString2 = paramString1.getStatusLine();
      if ((paramString2 != null) && (paramString2.getStatusCode() == 200))
      {
        paramString1 = new JSONObject(HttpUtil.a(paramString1));
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "HttpUtil post :json:" + paramString1.toString());
        }
        if (jdField_a_of_type_ComTencentBizCommonUtilShareToQZoneBack != null)
        {
          b = paramString1.getString("msg");
          return paramString1.getInt("ret");
        }
        b = "http error";
        return 4;
      }
    }
    catch (ClientProtocolException paramString1)
    {
      paramString1.printStackTrace();
      b = "ClientProtocolException";
      return 1;
      throw new IOException("Http statusCode:" + paramString2.getStatusCode());
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      b = "IOException";
      return 3;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      b = "JSONException";
    }
    return 1;
  }
  
  public static void a(Context paramContext, Bundle paramBundle, ShareToQZoneBack paramShareToQZoneBack)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "======ShareToQZone: share =========");
    }
    jdField_a_of_type_AndroidOsBundle = paramBundle;
    jdField_a_of_type_ComTencentBizCommonUtilShareToQZoneBack = paramShareToQZoneBack;
    jdField_a_of_type_AndroidContentContext = paramContext;
    new Thread(jdField_a_of_type_JavaLangRunnable).start();
  }
  
  public static byte[] a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramInt1 = Math.max(Math.min(j, k) / paramInt1, Math.max(j, k) / paramInt2);
    if (paramInt1 < 0) {
      paramInt1 = i;
    }
    for (;;)
    {
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt1;
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (paramString == null) {
        return null;
      }
      localObject = new ByteArrayOutputStream();
      paramString.compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.ShareToQZone
 * JD-Core Version:    0.7.0.1
 */