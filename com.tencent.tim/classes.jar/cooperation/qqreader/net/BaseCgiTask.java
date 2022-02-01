package cooperation.qqreader.net;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import auri;
import avni;
import avnk;
import avoc;
import avoh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import cooperation.qqreader.QRBridgeUtil;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import okhttp3.MediaType;

public abstract class BaseCgiTask
  implements Runnable
{
  public static String CHANNEL = "QQPLUGIN_B";
  public static String jr = "3.4.4.0001";
  public static String jt = "AND";
  private avni c;
  protected Context mContext = BaseApplicationImpl.getApplication();
  private WeakReference<avni> mListenerRef;
  
  private String FU()
  {
    return QRBridgeUtil.getPSkey(getUin(), "books.qq.com");
  }
  
  private String FV()
  {
    String str1 = getUin();
    String str2 = getSKey();
    String str3 = FU();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("o_cookie=").append(str1).append(";p_skey=").append(str3).append(";skey=").append(str2).append(";uin=o");
    int j = str1.length();
    int i = 0;
    while (i < 10 - j)
    {
      localStringBuilder.append("0");
      i += 1;
    }
    localStringBuilder.append(str1);
    return localStringBuilder.toString();
  }
  
  private String Y(String paramString)
  {
    localObject1 = null;
    try
    {
      localObject2 = p();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2;
        avoc.e("BaseCgiTask", "getRequestContent", localIOException);
        continue;
        localObject1 = m(new String((byte[])localObject1), 100);
      }
    }
    localObject2 = new StringBuilder().append(" request content: ");
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject1 = (String)localObject1;
      return "Request: " + getUrl() + (String)localObject1 + " Response is: " + m(paramString, 300);
    }
  }
  
  private avni a()
  {
    if (this.c != null) {
      return this.c;
    }
    if (this.mListenerRef != null) {
      return (avni)this.mListenerRef.get();
    }
    return null;
  }
  
  private void a(BaseCgiTask paramBaseCgiTask, Exception paramException)
  {
    avni localavni = a();
    if (localavni != null)
    {
      avoc.e("BaseCgiTask", Y("failed task:" + getClass().getName()), paramException);
      ThreadManager.getUIHandler().post(new BaseCgiTask.2(this, localavni, paramBaseCgiTask, paramException));
      return;
    }
    avoc.u("BaseCgiTask", getClass().getName() + "onConnectionError callback null");
  }
  
  public static String aW()
  {
    String str1 = URLEncoder.encode(Build.PRODUCT);
    String str2 = URLEncoder.encode(Build.DEVICE);
    return str1 + "#" + str2 + "#" + Build.VERSION.SDK;
  }
  
  private void b(avnk paramavnk)
  {
    avni localavni = a();
    if (localavni != null)
    {
      localavni.c(paramavnk);
      ThreadManager.getUIHandler().post(new BaseCgiTask.1(this, localavni, paramavnk));
      return;
    }
    avoc.u("BaseCgiTask", getClass().getName() + " request: " + getUrl() + " onConnectionReceiveData callback null");
  }
  
  public static String getIMEI()
  {
    String str2 = auri.getIMEI("674ef4");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.trim().length() != 0) {}
    }
    else
    {
      str1 = Build.ID + "-" + Build.DEVICE;
    }
    return str1;
  }
  
  private String getSKey()
  {
    Object localObject2 = "";
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("ReaderIPCModule", "get_skey", new Bundle());
    Object localObject1 = localObject2;
    if (localEIPCResult != null)
    {
      localObject1 = localObject2;
      if (localEIPCResult.code == 0)
      {
        localObject1 = localObject2;
        if (localEIPCResult.data != null) {
          localObject1 = localEIPCResult.data.getString("get_skey_value");
        }
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = "";
      avoc.e("BaseCgiTask", "skey is null");
    }
    return localObject2;
  }
  
  private String getUin()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() + "";
  }
  
  private static String m(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramInt > paramString.length())) {
      return paramString;
    }
    return paramString.substring(0, paramInt);
  }
  
  protected abstract RequestType a();
  
  protected MediaType a()
  {
    return MediaType.parse("application/json");
  }
  
  public void a(avni paramavni, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c = paramavni;
      return;
    }
    this.mListenerRef = new WeakReference(paramavni);
  }
  
  public void execute()
  {
    ThreadManagerV2.excute(this, 128, null, true);
  }
  
  protected HashMap<String, String> f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qq_version", "3.4.4");
    localHashMap.put("c_platform", "mqqandroid");
    localHashMap.put("qqnum", getUin());
    localHashMap.put("client_version", jr);
    localHashMap.put("client_platform", jt);
    localHashMap.put("channel", CHANNEL);
    localHashMap.put("sid", getUin());
    localHashMap.put("skey", getSKey());
    localHashMap.put("p_skey", FU());
    localHashMap.put("imei", getIMEI());
    localHashMap.put("ua", aW());
    localHashMap.put("Referer", "https://readercentera.qq.com");
    localHashMap.put("cookie", FV());
    localHashMap.put("identify", "skey");
    localHashMap.put("resolution", avoh.getScreenWidth() + "*" + avoh.getScreenHeight());
    localHashMap.put("timi", getUin());
    return localHashMap;
  }
  
  protected abstract HashMap<String, String> getHeaders();
  
  protected abstract String getUrl();
  
  protected byte[] p()
    throws IOException
  {
    return null;
  }
  
  public void run()
  {
    try
    {
      if (RequestType.POST.equals(a())) {}
      for (Object localObject = OkHttpHelper.HttpMethodType.POST;; localObject = OkHttpHelper.HttpMethodType.GET)
      {
        localObject = OkHttpHelper.a(getUrl(), (OkHttpHelper.HttpMethodType)localObject, getHeaders(), a(), p());
        b(new avnk(this, (String)localObject));
        avoc.u("BaseCgiTask", Y((String)localObject));
        return;
      }
      return;
    }
    catch (HttpResponseException localHttpResponseException)
    {
      a(this, localHttpResponseException);
      return;
    }
    catch (IOException localIOException)
    {
      a(this, localIOException);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      a(this, localIllegalArgumentException);
    }
  }
  
  public static enum RequestType
  {
    GET,  POST;
    
    private RequestType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.net.BaseCgiTask
 * JD-Core Version:    0.7.0.1
 */