package com.tencent.biz.pubaccount.readinjoy.ad.utils;

import abyq;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tlm;
import tlm.a;
import tlm.b;

public class ReadInJoyAdPingUrlUtil
{
  private static ExecutorService p;
  
  public static void Q(JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramJSONObject.toString())) {
      d().execute(new URLConnection_Ping_Runner(paramJSONObject));
    }
  }
  
  private static ExecutorService d()
  {
    if (p == null) {
      p = Executors.newFixedThreadPool(3);
    }
    return p;
  }
  
  static class URLConnection_Ping_Runner
    implements Runnable
  {
    private final JSONObject af;
    
    public URLConnection_Ping_Runner(JSONObject paramJSONObject)
    {
      this.af = paramJSONObject;
    }
    
    public void run()
    {
      label202:
      label207:
      HttpURLConnection localHttpURLConnection;
      for (;;)
      {
        try
        {
          if ((this.af == null) || (TextUtils.isEmpty(this.af.toString())))
          {
            if (!QLog.isColorLevel()) {
              break label473;
            }
            QLog.e("ReadInJoyAdPingUrlUtil", 2, " URLConnection_Ping_Runner input requestJsonBody is null: " + this.af);
            return;
          }
          localObject1 = new URL("https://c.mp.qq.com/api/union/report_new");
          if ((TextUtils.isEmpty("https://c.mp.qq.com/api/union/report_new")) || (!"https://c.mp.qq.com/api/union/report_new".contains("https"))) {
            break label207;
          }
          localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection();
          localObject2 = abyq.b();
          localObject3 = new StringBuilder().append(" URLConnection_Ping_Runner https sslContext is not null :");
          if (localObject2 != null) {
            break label202;
          }
          bool = true;
          QLog.d("ReadInJoyAdPingUrlUtil", 2, bool);
          if (localObject2 == null) {
            break label474;
          }
          localObject2 = ((SSLContext)localObject2).getSocketFactory();
          ((HttpsURLConnection)localObject1).setSSLSocketFactory((SSLSocketFactory)localObject2);
        }
        catch (Exception localException)
        {
          Object localObject1;
          if (!QLog.isColorLevel()) {
            break label473;
          }
        }
        if (localObject1 != null) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label473;
        }
        QLog.e("ReadInJoyAdPingUrlUtil", 2, " conn is null: ");
        return;
        QLog.e("ReadInJoyAdPingUrlUtil", 2, "Exception while ping" + localException);
        return;
        boolean bool = false;
        continue;
        localHttpURLConnection = (HttpURLConnection)localException.openConnection();
      }
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setReadTimeout(5000);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      Object localObject3 = new StringBuilder();
      if (this.af.has("uin"))
      {
        ((StringBuilder)localObject3).append("sp-cuin=");
        ((StringBuilder)localObject3).append(this.af.get("uin").toString());
      }
      Object localObject2 = new tlm.a();
      ((tlm.a)localObject2).aJy = "ce2d9f";
      localObject2 = tlm.a(BaseApplication.getContext(), (tlm.a)localObject2);
      if (localObject2 != null) {}
      for (localObject2 = ((tlm.b)localObject2).b;; localObject2 = null)
      {
        if ((localObject2 != null) && (((qq_ad_get.QQAdGet.DeviceInfo)localObject2).client_ipv4.has()))
        {
          ((StringBuilder)localObject3).append(";sp-clientip-union=");
          ((StringBuilder)localObject3).append(((qq_ad_get.QQAdGet.DeviceInfo)localObject2).client_ipv4.get());
        }
        for (;;)
        {
          localHttpURLConnection.setRequestProperty("Cookie", ((StringBuilder)localObject3).toString());
          localObject2 = localHttpURLConnection.getOutputStream();
          localObject3 = new OutputStreamWriter((OutputStream)localObject2, "UTF-8");
          ((OutputStreamWriter)localObject3).write(this.af.toString());
          ((OutputStreamWriter)localObject3).flush();
          ((OutputStreamWriter)localObject3).close();
          ((OutputStream)localObject2).close();
          if (localHttpURLConnection.getResponseCode() != 200) {
            break;
          }
          QLog.d("ReadInJoyAdPingUrlUtil", 2, " URLConnection_Ping_Runner change type 25 sso to cgi success");
          return;
          if (this.af.has("client_ip"))
          {
            ((StringBuilder)localObject3).append(";sp-clientip-union=");
            ((StringBuilder)localObject3).append(this.af.get("client_ip").toString());
          }
        }
        label473:
        return;
        label474:
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyAdPingUrlUtil
 * JD-Core Version:    0.7.0.1
 */