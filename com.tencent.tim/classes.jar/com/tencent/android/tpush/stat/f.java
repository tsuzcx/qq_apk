package com.tencent.android.tpush.stat;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.a;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.b.c;
import com.tencent.android.tpush.stat.event.Event;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.HttpHelper;
import com.tencent.tpns.baseapi.base.util.RC4;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.core.net.TlsCompatSocketFactory;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<*>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONObject;

public class f
{
  private static volatile f a = null;
  private static c b = b.b();
  private static Context c = null;
  private StringBuilder d = new StringBuilder(4096);
  private long e = 0L;
  
  private f(Context paramContext)
  {
    try
    {
      c = paramContext.getApplicationContext();
      this.e = (System.currentTimeMillis() / 1000L);
      return;
    }
    catch (Throwable paramContext)
    {
      b.b(paramContext);
    }
  }
  
  static Context a()
  {
    return c;
  }
  
  static void a(Context paramContext)
  {
    c = paramContext.getApplicationContext();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      if (!paramJSONObject.isNull("cfg"))
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("cfg");
        d.a(c, localJSONObject);
      }
      if (!paramJSONObject.isNull("ncts"))
      {
        int i = paramJSONObject.getInt("ncts");
        int j = (int)(i - System.currentTimeMillis() / 1000L);
        if (d.b()) {
          b.b("server time:" + i + ", diff time:" + j);
        }
        b.f(c);
        b.a(c, j);
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      b.d(paramJSONObject);
    }
  }
  
  public static f b(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new f(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public void a(Event paramEvent, e parame)
  {
    b(Arrays.asList(new String[] { paramEvent.toJsonString() }), parame);
  }
  
  void a(List<?> paramList, e parame)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {}
    int j;
    Object localObject1;
    for (;;)
    {
      return;
      if (CloudManager.getInstance(c).shouldRefuse())
      {
        b.d("sendHttpsPost refused by cloud");
        return;
      }
      j = paramList.size();
      try
      {
        this.d.delete(0, this.d.length());
        this.d.append("[");
        for (;;)
        {
          if (i >= j) {
            break label223;
          }
          localObject1 = paramList.get(i).toString();
          try
          {
            if (Util.checkAccessId(new JSONObject((String)localObject1).optLong("accessId", 0L)))
            {
              this.d.append((String)localObject1);
              if (i != j - 1) {
                this.d.append(",");
              }
            }
            i += 1;
          }
          catch (Throwable paramList)
          {
            paramList = b;
            new StringBuilder().append("unexpected for:");
            throw new NullPointerException();
          }
        }
        if (paramList == null) {}
      }
      catch (Throwable paramList) {}
    }
    label172:
    b.a(paramList);
    if (parame != null) {}
    label1566:
    for (;;)
    {
      try
      {
        parame.b();
        if ((paramList instanceof OutOfMemoryError))
        {
          this.d = null;
          System.gc();
          this.d = new StringBuilder(2048);
          return;
          label223:
          this.d.append("]");
          String str1 = this.d.toString();
          i = str1.length();
          localObject4 = XGApiConfig.getStatServerAddr(c);
          Object localObject6 = "";
          localObject5 = "";
          localObject1 = localObject5;
          localObject3 = localObject6;
          try
          {
            paramList = new JSONObject(paramList.get(0).toString());
            localObject1 = localObject5;
            localObject3 = localObject6;
            String str2 = paramList.optString("msgId", "");
            localObject1 = localObject5;
            localObject3 = localObject6;
            localObject6 = paramList.optString("accessId", "");
            localObject1 = localObject5;
            localObject3 = localObject6;
            localObject5 = paramList.optString("sdkVersion", "");
            localObject1 = localObject5;
            localObject3 = localObject6;
            if (TextUtils.isEmpty(str2)) {
              continue;
            }
            localObject1 = localObject5;
            localObject3 = localObject6;
            b.h("stat for pushAction");
            paramList = (List<?>)localObject4;
            localObject1 = localObject6;
            localObject3 = localObject5;
            localObject4 = paramList;
          }
          catch (Throwable paramList)
          {
            b.f("parse event to json error: " + paramList.toString());
            paramList = (List<?>)localObject3;
            localObject3 = localObject2;
            Object localObject2 = paramList;
            continue;
            paramList = (HttpURLConnection)paramList.openConnection();
            continue;
            if (!((String)localObject4).equalsIgnoreCase("gzip,rc4")) {
              continue;
            }
            paramList = new String(RC4.decrypt(b.a((byte[])localObject5)), Charset.forName("UTF-8"));
            continue;
            if (!((String)localObject4).equalsIgnoreCase("rc4,gzip")) {
              continue;
            }
            paramList = new String(b.a(RC4.decrypt((byte[])localObject5)), Charset.forName("UTF-8"));
            continue;
            if (!((String)localObject4).equalsIgnoreCase("gzip")) {
              continue;
            }
            paramList = new String(b.a((byte[])localObject5), Charset.forName("UTF-8"));
            continue;
            if (!((String)localObject4).equalsIgnoreCase("rc4")) {
              continue;
            }
            paramList = new String(RC4.decrypt((byte[])localObject5), Charset.forName("UTF-8"));
            continue;
            b.e("http response error data ret_code = " + i);
            parame.b();
            continue;
            b.e("http response data null");
            parame.b();
            continue;
            b.e("Server response error code:" + j + ", error:" + (String)localObject5);
            if (parame == null) {
              continue;
            }
            parame.b();
            continue;
          }
          if (d.b()) {
            b.b("[" + (String)localObject4 + "]Send request(" + i + "bytes), content:" + str1);
          }
          paramList = new URL((String)localObject4);
          if (paramList.getProtocol().toLowerCase().equals("https"))
          {
            paramList = (HttpsURLConnection)paramList.openConnection();
            ((HttpsURLConnection)paramList).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            if (Build.VERSION.SDK_INT >= 20) {
              break label1566;
            }
            ((HttpsURLConnection)paramList).setSSLSocketFactory(new TlsCompatSocketFactory(((HttpsURLConnection)paramList).getSSLSocketFactory()));
            paramList.setReadTimeout(10000);
            paramList.setConnectTimeout(15000);
            paramList.setDoInput(true);
            paramList.setDoOutput(true);
            paramList.setUseCaches(false);
            paramList.setRequestMethod("POST");
            paramList.setRequestProperty("Connection", "Keep-Alive");
            paramList.setRequestProperty("Accept-Encoding", "gzip");
            if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
              paramList.setRequestProperty("AccessId", (String)localObject1);
            }
            if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
              paramList.setRequestProperty("SdkVersion", (String)localObject3);
            }
            localObject3 = new ByteArrayOutputStream(i);
            localObject5 = str1.getBytes("utf-8");
            i = localObject5.length;
            localObject4 = new GZIPOutputStream((OutputStream)localObject3);
            ((GZIPOutputStream)localObject4).write((byte[])localObject5);
            ((GZIPOutputStream)localObject4).close();
            localObject4 = ((ByteArrayOutputStream)localObject3).toByteArray();
            if (d.b()) {
              b.h("before Gzip:" + i + " bytes, after Gzip:" + localObject4.length + " bytes");
            }
            paramList.setRequestProperty("ContentAuth", a.a((byte[])localObject5));
            paramList.setRequestProperty("ContentGzipAuth", a.a((byte[])localObject4));
            paramList.setRequestProperty("Content-Encoding", "gzip");
            try
            {
              localObject1 = HttpHelper.getSignAuthHeader((String)localObject1 + "", XGApiConfig.getAccessKey(c), (byte[])localObject4);
              if (localObject1 != null)
              {
                localObject1 = ((Map)localObject1).entrySet().iterator();
                if (((Iterator)localObject1).hasNext())
                {
                  localObject6 = (Map.Entry)((Iterator)localObject1).next();
                  localObject5 = (String)((Map.Entry)localObject6).getKey();
                  localObject6 = (String)((Map.Entry)localObject6).getValue();
                  if ((Util.isNullOrEmptyString((String)localObject5)) || (localObject6 == null)) {
                    continue;
                  }
                  paramList.setRequestProperty((String)localObject5, ((String)localObject6).trim());
                  continue;
                }
              }
              paramList = paramList.getInputStream();
            }
            catch (Throwable localThrowable)
            {
              localObject2 = new DataOutputStream(paramList.getOutputStream());
              ((DataOutputStream)localObject2).write((byte[])localObject4);
              ((DataOutputStream)localObject2).flush();
              j = paramList.getResponseCode();
              localObject5 = paramList.getResponseMessage();
              i = paramList.getContentLength();
              localObject4 = paramList.getHeaderField("Content-Encoding");
              if (d.b()) {
                b.b("http recv response status code:" + j + ", responseMsg:" + (String)localObject5 + ",contentLength:" + i + ",contentEncoding:" + (String)localObject4);
              }
              if (j != 200) {
                continue;
              }
            }
            localObject6 = new DataInputStream(paramList);
            localObject5 = new byte[i];
            ((DataInputStream)localObject6).readFully((byte[])localObject5);
            paramList.close();
            ((DataInputStream)localObject6).close();
            paramList = "";
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              continue;
            }
            paramList = new String((byte[])localObject5, Charset.forName("UTF-8"));
            b.b("http recv response data: " + paramList);
            if ((paramList == null) || (paramList.length() <= 0)) {
              continue;
            }
            paramList = new JSONObject(paramList);
            a(paramList);
            if (parame != null)
            {
              i = paramList.optInt("ret_code", -1);
              if (i != 0) {
                continue;
              }
              b.b("http data upload ok");
              parame.a();
              b.b("send Event success:" + str1);
            }
            ((DataOutputStream)localObject2).close();
            ((ByteArrayOutputStream)localObject3).close();
            paramList = null;
            break label172;
            localObject2 = localObject5;
            localObject3 = localObject6;
            if (paramList.has("customEvent"))
            {
              localObject2 = localObject5;
              localObject3 = localObject6;
              paramList = XGApiConfig.getCustomEvenServerAddr(c);
              continue;
            }
            localObject2 = localObject5;
            localObject3 = localObject6;
            paramList = XGApiConfig.getErrCodeServerAddr(c);
            continue;
          }
        }
      }
      catch (Throwable parame)
      {
        Object localObject4;
        Object localObject5;
        Object localObject3;
        b.b(parame);
        continue;
      }
      if (((paramList instanceof UnknownHostException)) || (!(paramList instanceof SocketTimeoutException))) {
        break;
      }
      return;
    }
  }
  
  void b(List<?> paramList, e parame)
  {
    try
    {
      if (i.b(GuidInfoManager.getToken(c)))
      {
        if (parame != null) {
          parame.a();
        }
      }
      else
      {
        a(paramList, parame);
        return;
      }
    }
    catch (Throwable paramList)
    {
      b.c("unexpected for sendList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.f
 * JD-Core Version:    0.7.0.1
 */