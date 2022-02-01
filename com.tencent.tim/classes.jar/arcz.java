import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.webso.HttpRequestPackage;
import com.tencent.mobileqq.webview.webso.HybridWebReporter;
import com.tencent.mobileqq.webview.webso.HybridWebReporter.a;
import com.tencent.mobileqq.webview.webso.WebSoServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.EnumHttpMethod;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class arcz
  implements BusinessObserver
{
  private static volatile arcz a;
  private static final Object cK = new Object();
  private boolean bKr;
  private ConcurrentHashMap<String, arcz.b> jj = new ConcurrentHashMap();
  
  private void Z(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key_uni_key");
    String str2 = paramBundle.getString("url");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    arcz.b localb = (arcz.b)this.jj.get(str1);
    if (localb == null)
    {
      QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + str1 + ",map size=" + this.jj.size());
      a(paramBoolean, paramBundle, a(str1));
      return;
    }
    localb.reqState = 2;
    localb.resultCode = 0;
    a(paramBoolean, paramBundle, localb);
    this.jj.remove(str1);
    QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + paramBoolean + "), url:" + str2 + " ,map size=" + this.jj.size());
  }
  
  private arcz.b a(String paramString)
  {
    arcz.b localb = new arcz.b();
    localb.uniKey = paramString;
    localb.reqState = 4;
    localb.resultCode = 10006;
    return localb;
  }
  
  public static arcz a()
  {
    if (a == null) {}
    synchronized (cK)
    {
      if (a == null) {
        a = new arcz();
      }
      return a;
    }
  }
  
  private void a(Handler paramHandler, arcz.b paramb)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = paramb;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, arcz.b paramb)
  {
    if (paramb.a == null)
    {
      paramb.a = new HybridWebReporter.a();
      paramb.a.uin = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      paramb.a.url = paramb.currentUrl;
      paramb.a.cYY = true;
    }
    if (!paramBoolean) {
      paramb.a.eeG = 1;
    }
    paramb.a.czK = paramBundle.getString("key_user_ip");
    paramb.a.czL = paramBundle.getString("key_dns_result");
    paramb.a.cnH = paramBundle.getString("key_server_ip");
    paramb.a.port = paramBundle.getString("key_server_port");
    paramb.a.eeB = paramBundle.getInt("key_time_cost");
    paramb.a.eeC = paramBundle.getInt("rsp_code");
    paramb.a.eeD = 0;
    paramb.a.detail = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      paramb.resultCode = paramBundle.getInt("rsp_code", 10002);
      paramb.errorMsg = paramBundle.getString("rsp_message");
      b(paramb);
      QLog.w("WebSoCgiService", 1, "state=" + paramb);
    }
    Object localObject1;
    int i;
    do
    {
      return;
      localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
      paramBundle = null;
      if (localObject1 != null) {
        paramBundle = new arcx((HttpRsp)localObject1);
      }
      if (localObject1 == null)
      {
        paramb.resultCode = 10002;
        paramb.errorMsg = "rsp is null";
        b(paramb);
        QLog.w("WebSoCgiService", 1, "state=" + paramb);
        return;
      }
      localObject1 = ((HttpRsp)localObject1).rspinfo;
      i = ((String)localObject1).indexOf("\r\n\r\n");
      paramBundle = paramBundle.entity_body;
    } while (i < 1);
    String[] arrayOfString1 = ((String)localObject1).substring(0, i - 1).split("\r\n");
    int j = arrayOfString1.length;
    if (j >= 1)
    {
      Object localObject2 = arrayOfString1[0].split(" ");
      if (localObject2.length >= 2) {}
      try
      {
        paramb.eeH = Integer.valueOf(localObject2[1].trim()).intValue();
        paramb.a.czJ = localObject2[1].trim();
        localObject2 = new JSONObject();
        i = 1;
        if (i < j)
        {
          arrayOfString2 = arrayOfString1[i].split(":");
          if (arrayOfString2.length <= 1) {}
        }
      }
      catch (Exception localException)
      {
        try
        {
          for (;;)
          {
            String[] arrayOfString2;
            ((JSONObject)localObject2).put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
            i += 1;
          }
          localException = localException;
          localException.printStackTrace();
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        paramb.header = localException.toString();
      }
    }
    paramb.resultCode = 0;
    paramb.czO = paramBundle;
    long l1 = System.currentTimeMillis();
    long l2 = paramb.startTime;
    QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (l1 - l2) + " ms");
    b(paramb);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.w("WebSoCgiService", 1, "html body empty, rspinfo is: " + (String)localObject1);
      return;
    }
    QLog.i("WebSoCgiService", 1, "succ htmlBody len=" + paramBundle.length());
  }
  
  private void b(arcz.b paramb)
  {
    Handler localHandler;
    if ((paramb != null) && (paramb.handler != null))
    {
      localHandler = paramb.handler;
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, paramb);
    HybridWebReporter.a().a(paramb.a);
  }
  
  public boolean a(arcz.a parama, Handler paramHandler)
  {
    return a(parama, paramHandler, SwiftBrowserCookieMonster.pZ(parama.url));
  }
  
  public boolean a(arcz.a parama, Handler paramHandler, String paramString)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.url)))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + parama);
      return false;
    }
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + parama);
      return false;
    }
    String str1 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + parama + ",uniKey=" + str1);
    }
    arcz.b localb = new arcz.b();
    localb.uniKey = str1;
    localb.currentUrl = parama.url;
    localb.cZc = parama.cZb;
    localb.reqState = 1;
    localb.czP = parama.callback;
    localb.fF = parama.fF;
    localb.a = new HybridWebReporter.a();
    localb.a.uin = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    localb.a.url = parama.url;
    localb.a.cYY = true;
    this.jj.put(str1, localb);
    long l1 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    String str3 = avpq.getQUA3();
    String str2 = ardk.CN();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", parama.method.toUpperCase());
      localJSONObject.put("entity_body", parama.body);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("content_type", parama.contentType);
      localJSONObject.put("uri", parama.url);
      if (parama.method.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(parama.body))
        {
          if (!parama.url.contains("?")) {
            break label705;
          }
          localJSONObject.put("uri", parama.url + "&" + parama.body);
        }
        for (;;)
        {
          localJSONObject.put("cookie", paramString + "; qua=" + str3 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          paramString = new HttpRequestPackage(str2, localJSONObject);
          paramString.addHeader(parama.jsonHeader);
          paramString = new HttpReq(EnumHttpMethod.convert("e" + paramString.method).value(), paramString.getHeaderString(), paramString.getBodyString(), paramString.host);
          localb.handler = paramHandler;
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l1, parama.url, paramString, "", parama.timeout, 1101, str1, arcz.class);
          if (!this.bKr)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.bKr = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          l1 = System.currentTimeMillis();
          long l2 = localb.startTime;
          QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (l1 - l2) + " ms");
          return true;
          label705:
          localJSONObject.put("uri", parama.url + "?" + parama.body);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(parama.body)) {
          localJSONObject.put("content_length", parama.body.length());
        }
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1101) {
      Z(paramBoolean, paramBundle);
    }
  }
  
  public static class a
  {
    public String body;
    public boolean cZb;
    public String callback;
    public String contentType;
    public Object fF;
    public String jsonHeader;
    public String method;
    public int timeout;
    public String url;
    
    public String toString()
    {
      return "url=" + this.url + " ,method=" + this.method + " ,jsonHeader=" + this.jsonHeader + " ,body=" + this.body + " ," + this.contentType + " ,rspBase64=" + this.cZb + " ,timeout=" + this.timeout + " ,userInfo=" + this.fF;
    }
  }
  
  public static class b
  {
    public HybridWebReporter.a a;
    public boolean cZc;
    public String currentUrl;
    public volatile String czO;
    public String czP;
    public int eeH = -1;
    public String errorMsg = "";
    public Object fF;
    public Handler handler;
    public String header;
    public int reqState = 0;
    public int resultCode = 0;
    public long startTime = System.currentTimeMillis();
    public String uniKey;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("unikey=").append(this.uniKey).append(",url=").append(this.currentUrl).append(" ,header=").append(this.header).append(",htmlbody len=");
      if (TextUtils.isEmpty(this.czO)) {}
      for (int i = 0;; i = this.czO.length()) {
        return i + ",reqState=" + this.reqState + ",httpStatusCode=" + this.eeH + ",needBase64Rsp=" + this.cZc + ",jsCallback=" + this.czP + ",resultCode=" + this.resultCode + ",errorMsg=" + this.errorMsg;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcz
 * JD-Core Version:    0.7.0.1
 */