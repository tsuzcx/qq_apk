import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import mqq.util.WeakReference;

public class aigi
{
  private static volatile aigi a;
  public aifc a;
  private aiex c;
  boolean isInited = false;
  QQAppInterface mApp;
  
  public static aigi a()
  {
    if (jdField_a_of_type_Aigi == null) {}
    try
    {
      if (jdField_a_of_type_Aigi == null) {
        jdField_a_of_type_Aigi = new aigi();
      }
      return jdField_a_of_type_Aigi;
    }
    finally {}
  }
  
  public static void destroyInstance()
  {
    if (jdField_a_of_type_Aigi != null) {
      jdField_a_of_type_Aigi.unInit();
    }
  }
  
  public aifc a()
  {
    return this.jdField_a_of_type_Aifc;
  }
  
  public void a(Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    try
    {
      String str = paramBundle.getString("url", "");
      paramBundle = paramBundle.getString("path", "");
      this.c = aiex.a;
      this.c.init(BaseApplicationImpl.getContext());
      this.c.a(str, new aigk(this, paramDownloadCallback, str));
      this.c.b(aiez.a(str, "com.tencent.now", paramBundle));
      return;
    }
    finally
    {
      paramBundle = finally;
      throw paramBundle;
    }
  }
  
  public void a(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    String str1 = paramBundle.getString("serviceName");
    String str2 = paramBundle.getString("serviceCmd");
    paramBundle = paramBundle.getByteArray("buffer");
    ((aigq)this.mApp.getBusinessHandler(145)).a(str1, str2, paramBundle, paramCommonCallback);
  }
  
  public void cP(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("url", "");
    QLog.i("PluginManagerInterfaceImpl", 1, "跳转web页面 URL = " + (String)localObject);
    localObject = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtras(paramBundle);
    ((Intent)localObject).addFlags(268435456);
    BaseApplicationImpl.getContext().startActivity((Intent)localObject);
  }
  
  public void cQ(Bundle paramBundle)
  {
    QLog.i(paramBundle.getString("tag", "nowplugin_dynamic"), 1, paramBundle.getString("msg", ""));
  }
  
  public Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return acmo.a(128).submit(new aigm(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public Future<Bundle> getAccessToken(String paramString1, String paramString2)
  {
    return acmo.a(128).submit(new aigi.a(this, paramString2, paramString1));
  }
  
  public void getRecordInfo(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    jsr localjsr = (jsr)this.mApp.getBusinessHandler(130);
    localjsr.a(paramBundle.getString("fromId"), paramBundle.getLong("roomId"), this.mApp.getCurrentAccountUin(), new aigl(this, localjsr, paramCommonCallback));
  }
  
  public void jumpToKandianBiu(Bundle paramBundle)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ReadInJoyDeliverBiuActivity.class);
    localIntent.putExtra("arg_title", paramBundle.getString("title"));
    localIntent.putExtra("arg_src", paramBundle.getString("anchor_name"));
    localIntent.putExtra("arg_cover", paramBundle.getString("cover_url"));
    localIntent.putExtra("arg_source_url", paramBundle.getString("room_url"));
    localIntent.putExtra("biu_src", 24);
    localIntent.putExtra("arg_now_live_vid", paramBundle.getString("vid"));
    localIntent.putExtra("arg_now_anchor_uin", paramBundle.getLong("qq_number"));
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public String reqDns(String paramString)
  {
    return aopd.a().aC(paramString, 1017);
  }
  
  public void shareToQQ(Bundle paramBundle)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ShareToQQActivity.class);
    localIntent.addFlags(268435456);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("uin", this.mApp.getCurrentUin());
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public void unInit()
  {
    jdField_a_of_type_Aigi = null;
    this.mApp = null;
    this.jdField_a_of_type_Aifc = null;
    if (this.c != null)
    {
      this.c.unInit();
      this.c = null;
    }
  }
  
  public void z(QQAppInterface paramQQAppInterface)
  {
    if (this.isInited) {
      return;
    }
    if (this.mApp == null) {
      this.mApp = paramQQAppInterface;
    }
    if (this.jdField_a_of_type_Aifc == null) {
      this.jdField_a_of_type_Aifc = new aifc(this.mApp);
    }
    NowLive.setCustomizedTicket(new aigj(this));
    this.isInited = true;
  }
  
  static final class a
    implements Callable<Bundle>
  {
    private final WeakReference<aigi> aG;
    private final String appId;
    private final String bNG;
    
    a(aigi paramaigi, String paramString1, String paramString2)
    {
      this.appId = paramString1;
      this.bNG = paramString2;
      this.aG = new WeakReference(paramaigi);
    }
    
    public Bundle call()
      throws Exception
    {
      Object localObject = (aigi)this.aG.get();
      Bundle[] arrayOfBundle = new Bundle[1];
      if (localObject != null)
      {
        aica localaica = new aica();
        CountDownLatch localCountDownLatch = new CountDownLatch(1);
        localaica.a(((aigi)localObject).mApp, this.bNG, BaseApplicationImpl.getContext(), this.appId, new aigo(this, localaica, arrayOfBundle, localCountDownLatch));
        localCountDownLatch.await();
        return arrayOfBundle[0];
      }
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("isSuccess", false);
      ((Bundle)localObject).putInt("code", -1000);
      arrayOfBundle[0] = localObject;
      return arrayOfBundle[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigi
 * JD-Core Version:    0.7.0.1
 */