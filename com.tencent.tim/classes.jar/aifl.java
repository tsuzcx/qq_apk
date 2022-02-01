import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.intervideo.nowproxy.InitData;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.QQKandianInterface;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.common.login.LoginType;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedChannel;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDns;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedRecord;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;
import com.tencent.intervideo.nowproxy.qqshare.CustomizedShareForQQ;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.TicketManager;

public class aifl
  implements aihd, Manager
{
  static adwr jdField_a_of_type_Adwr = new aifr();
  public static int aII = -1;
  private final AtomicLong B = new AtomicLong(System.currentTimeMillis() - 1800000L);
  public aigd a;
  aigg jdField_a_of_type_Aigg;
  protected QQKandianInterface a;
  private LoginType jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType = LoginType.QQConnect;
  protected CustomizedChannel a;
  protected CustomizedRecord a;
  protected CustomizedShareForQQ a;
  private final long abv = 1800000L;
  public String accessToken;
  private BroadcastReceiver accountReceiver = new aifv(this);
  aihg b = new aifs(this);
  private tzg f;
  private QQAppInterface mApp;
  protected CustomizedDns mCustomDns = new aifq(this);
  protected CustomizedDownloader mCustomizedDownloader = new aiga(this);
  protected CustomizedLoading mCustomizedLoading = new aify(this);
  protected CustomizedLog mCustomizedLog = new aifw(this);
  protected CustomizedReport mCustomizedReport = new aifz(this);
  protected CustomizedWebView mCustomizedWebView = new aifp(this);
  public String openId;
  
  public aifl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedChannel = new aifx(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedRecord = new aigb(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyQqshareCustomizedShareForQQ = new aifn(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyQQKandianInterface = new aifo(this);
    try
    {
      QLog.i("XProxy|NowProxy", 1, "DynamicNowManager create app = " + paramQQAppInterface);
      this.mApp = paramQQAppInterface;
      aicg.setILoggerFactory();
      aigi.a().z(paramQQAppInterface);
      dsn();
      dso();
      this.jdField_a_of_type_Aigd = new aigd(paramQQAppInterface);
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      paramQQAppInterface.addAction("mqq.intent.action.ACCOUNT_KICKED");
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("XProxy|NowProxy", 1, "initNowSdk exception ", paramQQAppInterface);
    }
  }
  
  private Bundle a(Bundle paramBundle, NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    paramBundle.putString("KEY_GROUP_UIN", paramNewTogetherRoomMessageData.QD);
    paramBundle.putString("KEY_GROUP_OWNER_UIN", paramNewTogetherRoomMessageData.bNH);
    paramBundle.putInt("KEY_ROOM_TYPE", paramNewTogetherRoomMessageData.ddo);
    paramBundle.putLong("KEY_ROOM_ID", paramNewTogetherRoomMessageData.abz);
    paramBundle.putInt("KEY_OLD_ROOM_TYPE", paramNewTogetherRoomMessageData.ddq);
    paramBundle.putLong("KEY_OLD_ROOM_ID", paramNewTogetherRoomMessageData.abA);
    paramBundle.putString("KEY_ROOM_NAME", paramNewTogetherRoomMessageData.roomName);
    paramBundle.putString("KEY_JUMP_SCHEME", paramNewTogetherRoomMessageData.wV);
    paramBundle.putString("KEY_ROOM_COVER", paramNewTogetherRoomMessageData.aif);
    paramBundle.putString("KEY_FROM_ID", paramNewTogetherRoomMessageData.bNJ);
    return paramBundle;
  }
  
  public static boolean aoW()
  {
    return aqiz.isAppInstalled(BaseApplicationImpl.getContext(), "com.tencent.now");
  }
  
  public static void cM(Bundle paramBundle)
  {
    if (aoW())
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tnow://openpage/startlive?from=1"));
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      localIntent.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    s(0L, "https://a.app.qq.com/o/simple.jsp?pkgname=com.tencent.now&ckey=CK1339000284644", "beginLive");
  }
  
  public static int dm(String paramString)
  {
    int i = 2;
    if ((paramString.equals("1")) || (paramString.equals("2"))) {
      i = 1;
    }
    return i;
  }
  
  private void dsn()
  {
    this.jdField_a_of_type_Aigg = new aigg();
    InitData localInitData = new InitData();
    localInitData.mAppID = "2";
    localInitData.mSourceVersion = String.valueOf(aewh.getVersionCode(BaseApplicationImpl.getContext()));
    localInitData.mSourceUid = this.mApp.getCurrentAccountUin();
    localInitData.mIsCpu64bit = false;
    NowLive.setShadowImp(this.jdField_a_of_type_Aigg);
    NowLive.start(BaseApplicationImpl.getContext(), localInitData);
  }
  
  private void dso()
  {
    NowLive.setCustomizedLog(this.mCustomizedLog);
    NowLive.setCustomChannel(this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedChannel);
    NowLive.setCustomizedLoading(this.mCustomizedLoading);
    NowLive.setCustomizeReport(this.mCustomizedReport);
    NowLive.setCustomizedDownloader(this.mCustomizedDownloader);
    NowLive.setCustomizedRecord(this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedRecord);
    NowLive.setCustomizedShareForQQ(this.jdField_a_of_type_ComTencentIntervideoNowproxyQqshareCustomizedShareForQQ);
    NowLive.setQQKandianInterface(this.jdField_a_of_type_ComTencentIntervideoNowproxyQQKandianInterface);
    NowLive.setCustomizedWebView(this.mCustomizedWebView);
    NowLive.setCustomizedDns(this.mCustomDns);
  }
  
  private void dsp()
  {
    LoginData localLoginData;
    if (System.currentTimeMillis() - this.B.get() > 1800000L)
    {
      localLoginData = new LoginData();
      TicketManager localTicketManager = (TicketManager)this.mApp.getManager(2);
      String str = this.mApp.getCurrentAccountUin();
      localTicketManager.getA2(str);
      localLoginData.setLoginType(this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType);
      localLoginData.setLoginAppid(16L);
      localLoginData.setSkey(localTicketManager.getSkey(str).getBytes());
      localLoginData.setST(localTicketManager.getSt(str, 16));
      localLoginData.setSTKey(localTicketManager.getStkey(str, 16));
      localLoginData.setUserId(str);
      if ((TextUtils.isEmpty(this.accessToken)) || (TextUtils.isEmpty(this.openId))) {
        NowLive.login(localLoginData);
      }
    }
    else
    {
      return;
    }
    localLoginData.setKey(this.accessToken.getBytes());
    localLoginData.setAuthAppId("101490787");
    localLoginData.setOriginalId(this.openId);
    NowLive.login(localLoginData);
    this.B.set(System.currentTimeMillis());
  }
  
  public static void dsq()
  {
    aII = adxf.a().a(jdField_a_of_type_Adwr);
  }
  
  public static QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new InvalidParameterException("can't get AppInterface");
  }
  
  private static void s(long paramLong, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      if (paramLong != 0L) {
        break label195;
      }
    }
    label195:
    for (str = "https://now.qq.com/qq/play.html?_bid=2374&_wv=16778245&from=50320";; str = "https://now.qq.com/h5/index.html?_bid=2336&_wv=16778245&from=50320&roomid=" + paramLong)
    {
      long l = System.currentTimeMillis();
      paramString1 = str + "&_t=" + l;
      aigi.a().a().J("", String.valueOf(paramLong), paramString2, paramString1);
      paramString2 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      paramString2.putExtra("hide_operation_bar", true);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("op_type", "now_live");
      paramString2.putExtra("key_isReadModeEnabled", true);
      paramString2.setFlags(268435456);
      paramString2.putExtra("insertPluginsArray", new String[] { "nowlive" });
      QLog.i("XProxy|NowProxy", 1, "跳转web页面 URL = " + paramString1 + " time = " + l);
      wgv.c(BaseApplicationImpl.getContext(), paramString2, paramString1);
      return;
    }
  }
  
  public void F(ConfigurationService.Config paramConfig) {}
  
  public void a(Bundle paramBundle, aifl.a parama) {}
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, aihf paramaihf) {}
  
  public aihg b()
  {
    return this.b;
  }
  
  public void b(Bundle paramBundle, aifl.a parama)
  {
    paramBundle.putInt("ctrl_cmd", 1);
    NowLive.closeRoom(paramBundle, new aift(this, parama));
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, aihf paramaihf)
  {
    b(a(paramBundle, paramNewTogetherRoomMessageData), new aifm(this, paramaihf));
  }
  
  public void cL(Bundle paramBundle)
  {
    QLog.i("XProxy|NowProxy", 1, "enter login_type = " + this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType.ordinal());
    a(paramBundle, null);
  }
  
  public void d(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    preload();
  }
  
  public void dsl()
  {
    BaseApplicationImpl.getContext().sendBroadcast(new Intent("room.close.audio"));
  }
  
  public void dsm()
  {
    if (this.mApp != null) {
      aifb.nL(this.mApp.getCurrentUin());
    }
  }
  
  public void m(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      QLog.e("XProxy|NowProxy", 1, "activity or bundle is null");
      return;
    }
    paramBundle.putBoolean("is_cpu_64bit", false);
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)ajrb.c(this.mApp.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(0L))).longValue();
    QLog.d("XProxy|NowProxy", 1, "now qq connect auth time diff = " + (l1 - l2) / 1000L);
    if ((this.f == null) || (l1 - l2 > 1728000000L))
    {
      ajrb.c(this.mApp.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(l1));
      tzk.prepare();
      this.f = tzk.a(paramActivity, 6, "101490787");
    }
    paramActivity = new WeakReference(paramActivity);
    this.f.a("loginSilent", null, new aifu(this, paramActivity, paramBundle));
  }
  
  public void onDestroy()
  {
    QLog.i("XProxy|NowProxy", 1, "DynamicNowManager onDestroy mApp = " + this.mApp);
    NowLive.killPluginProcess();
    aigi.destroyInstance();
    ((aihv)this.mApp.getManager(338)).PQ(1);
    this.jdField_a_of_type_Aigd.unInit();
    this.mApp = null;
    this.f = null;
    NowLive.setCustomizedLog(null);
    NowLive.setCustomChannel(null);
    NowLive.setCustomizedLoading(null);
    NowLive.setCustomizeReport(null);
    NowLive.setCustomizedDownloader(null);
    NowLive.setCustomizedRecord(null);
    NowLive.setCustomizedShareForQQ(null);
    NowLive.setQQKandianInterface(null);
    NowLive.setCustomizedWebView(null);
    NowLive.setCustomizedDns(null);
  }
  
  public void preload() {}
  
  public static abstract interface a
  {
    public abstract void callback(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aifl
 * JD-Core Version:    0.7.0.1
 */