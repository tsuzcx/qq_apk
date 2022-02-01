import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountManager.1;
import com.tencent.biz.pubaccount.PublicAccountManager.16;
import com.tencent.biz.pubaccount.PublicAccountManager.4;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.mobileqq_mp.ActionInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SendPublicAccountMessageReceiptRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SetRefuseFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class kaw
{
  private static final kaw a = new kaw();
  String VJ = null;
  public String VK = null;
  int aGR = 0;
  public boolean adq;
  public boolean adr = false;
  BroadcastReceiver ae = null;
  BroadcastReceiver af = null;
  public WeakReference<Context> bZ = new WeakReference(null);
  private WeakReference<BusinessObserver> ca = new WeakReference(null);
  protected Runnable ct = new PublicAccountManager.4(this);
  public Map<String, Long> dp = new HashMap();
  Map<String, Integer> dq = new HashMap();
  public Map<String, List<mobileqq_mp.ButtonInfo>> dr = new HashMap();
  public Map<String, Integer> ds = new HashMap();
  private long ib;
  private String mCurrentUin;
  public WeakReference<QQAppInterface> n = new WeakReference(null);
  private long rl;
  BroadcastReceiver scanResultReceiver = null;
  
  public static int a(String paramString, AppInterface paramAppInterface)
  {
    paramString = ((acja)paramAppInterface.getManager(56)).b(paramString + "");
    if ((paramString != null) && (paramString.extendType == 2)) {
      return 1;
    }
    return 2;
  }
  
  private mobileqq_mp.SendMenuEventRequest a(int paramInt, String paramString, boolean paramBoolean)
  {
    String str = this.VJ;
    try
    {
      long l = Long.valueOf(str).longValue();
      mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = new mobileqq_mp.SendMenuEventRequest();
      localSendMenuEventRequest.uin.set((int)l);
      localSendMenuEventRequest.type.set(paramInt);
      localSendMenuEventRequest.key.set(paramString);
      localSendMenuEventRequest.msg_id.set(0L);
      localSendMenuEventRequest.s_type.set(1);
      localSendMenuEventRequest.versionInfo.set("3.4.4,3,3058");
      localSendMenuEventRequest.menu_type.set(aI(str));
      if (paramBoolean) {
        localSendMenuEventRequest.is_new_menu.set(paramBoolean);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-init:", 2, "type:" + localSendMenuEventRequest.type.get() + " uin:" + localSendMenuEventRequest.uin.get() + " key:" + localSendMenuEventRequest.key.get() + " msg_id:" + localSendMenuEventRequest.msg_id.get() + " s_type:" + localSendMenuEventRequest.s_type.get() + " versionInfo:" + localSendMenuEventRequest.versionInfo.get() + " is_new_menu:" + localSendMenuEventRequest.is_new_menu.get());
      }
      return localSendMenuEventRequest;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountManager", 2, "puin is invalid format:" + str);
      }
    }
    return null;
  }
  
  private String a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {
      return "";
    }
    List localList = ((ProxyManager)localObject).a().q(true);
    if (localList == null) {
      return "";
    }
    int m = localList.size();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i1;
    int i;
    for (;;)
    {
      if (j < m)
      {
        localObject = (RecentUser)localList.get(j);
        if (((RecentUser)localObject).showUpTime == 0L)
        {
          j += 1;
        }
        else
        {
          i1 = a(((RecentUser)localObject).uin, ((RecentUser)localObject).getType(), paramQQAppInterface);
          i = paramQQAppInterface.a().A(((RecentUser)localObject).uin, ((RecentUser)localObject).getType());
          if (((RecentUser)localObject).getType() == 7120)
          {
            if (((kdm)paramQQAppInterface.getManager(88)).b(paramQQAppInterface) == 0) {
              break label421;
            }
            i = 1;
          }
        }
      }
    }
    label153:
    label421:
    for (;;)
    {
      int k = i;
      if (i != 0) {
        k = 1;
      }
      if ((i1 == 1) || (i1 == 2)) {}
      for (localObject = ((RecentUser)localObject).uin;; localObject = "0")
      {
        localObject = i1 + "&" + (String)localObject + "&" + (j + 1) + "&" + k;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountManager", 2, "startReport s size= " + ((String)localObject).length());
        }
        localArrayList.add(localObject);
        break;
        if (((RecentUser)localObject).getType() == 7210)
        {
          if (oac.n(paramQQAppInterface))
          {
            i = 1;
            break label153;
          }
          if (oan.a().g(paramQQAppInterface) != 0) {
            i = 1;
          }
          break label153;
        }
        if ((((RecentUser)localObject).getType() != 7230) || (nyn.a().rc() == 0)) {
          break label421;
        }
        i = 1;
        break label153;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountManager", 2, "startReport reportStr size= " + localArrayList.toString().length() + "  length=" + localArrayList.size());
        }
        if (localArrayList.size() != 0) {
          return localArrayList.toString();
        }
        return "";
      }
    }
  }
  
  public static kaw a()
  {
    return a;
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://ti.qq.com/v2/city-selector/index?_wv=5127&redirect_url=%2F%2Fweather.mp.qq.com%2F&from=aio");
    localIntent.putExtra("fromAio", true);
    localIntent.putExtra("big_brother_source_key", "biz_src_gzh_weather");
    paramContext.startActivity(localIntent);
    abcx.a().E(paramQQAppInterface, "aio_othercity_click");
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (AudioHelper.isForbidByRubbishMeizu(0))
    {
      aqha.a(paramContext, 230, paramContext.getString(2131700589), paramContext.getString(2131700590), new kbk(this), null).show();
      return;
    }
    if (AudioHelper.mr(0))
    {
      aqha.a(paramContext, 230, paramContext.getString(2131700589), paramContext.getString(2131700591), new kbl(this), null).show();
      return;
    }
    if (paramQQAppInterface.getApp().checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) != 0)
    {
      aqha.a(paramContext, 230, paramContext.getString(2131700589), acfp.m(2131709778), new kay(this), null).show();
      return;
    }
    paramQQAppInterface.a().dWq();
    wmj.a(paramQQAppInterface, (BaseActivity)paramContext, 1, 0);
    ((BaseActivity)paramContext).setCanLock(false);
    if (this.ae != null) {}
    try
    {
      paramContext.unregisterReceiver(this.ae);
      label174:
      this.ae = null;
      this.ae = new kaz(this);
      paramQQAppInterface = new IntentFilter("com.tencent.biz.pubaccount.picResultAction");
      paramContext.registerReceiver(this.ae, paramQQAppInterface, "com.tencent.tim.msg.permission.pushnotify", null);
      this.aGR = 1;
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      break label174;
    }
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    Object localObject;
    if ((paramContext instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)paramContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject instanceof ycd))
        {
          localObject = (ycd)localObject;
          ((ycd)localObject).bYy += 1;
        }
      }
    }
    if (paramButtonInfo.url.has())
    {
      paramButtonInfo = paramButtonInfo.url.get();
      paramButtonInfo = new StringBuilder(paramButtonInfo);
      if (paramButtonInfo.indexOf("?") >= 0) {
        break label289;
      }
      paramButtonInfo.append("?");
    }
    for (;;)
    {
      paramButtonInfo.append("uin=" + paramQQAppInterface.getCurrentAccountUin());
      paramButtonInfo.append("&puin=" + paramString);
      localObject = new Intent(paramContext, PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("from", QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramButtonInfo.toString());
      ((Intent)localObject).putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject).putExtra("puin", paramString);
      ((Intent)localObject).putExtra("assignBackText", paramContext.getResources().getString(2131691039));
      ((Intent)localObject).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
      ((Intent)localObject).putExtra("big_brother_source_key", ocp.fq(paramString));
      if (paramString.equalsIgnoreCase("2632129500")) {
        ((Intent)localObject).putExtra("hide_operation_bar", true);
      }
      paramContext.startActivity((Intent)localObject);
      return;
      paramButtonInfo = "";
      break;
      label289:
      if (paramButtonInfo.indexOf("?") < paramButtonInfo.length() - 1) {
        if (paramButtonInfo.indexOf("&") < 0) {
          paramButtonInfo.append("&");
        } else if (paramButtonInfo.lastIndexOf("&") < paramButtonInfo.length() - 1) {
          paramButtonInfo.append("&");
        }
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
    localIntent.putExtra("from", QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("click_from", paramString3);
    localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("puin", paramString2);
    localIntent.putExtra("assignBackText", paramContext.getResources().getString(2131691039));
    localIntent.putExtra("big_brother_source_key", ocp.fq(paramString2));
    paramContext.startActivity(localIntent);
  }
  
  private void a(Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ScannerActivity.class);
    localIntent.putExtra("from", kaw.class.getName());
    localIntent.putExtra("finishAfterSucc", true);
    localIntent.putExtra("scanForResult", paramBoolean);
    if (this.scanResultReceiver != null) {}
    try
    {
      paramContext.unregisterReceiver(this.scanResultReceiver);
      label62:
      this.scanResultReceiver = null;
      this.scanResultReceiver = new kbj(this, paramBoolean, paramMqqHandler);
      paramMqqHandler = new IntentFilter("com.tencent.biz.pubaccount.scanResultAction");
      paramContext.registerReceiver(this.scanResultReceiver, paramMqqHandler, "com.tencent.tim.msg.permission.pushnotify", null);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    ocp.a(localIntent, paramQQAppInterface, paramContext, paramString, -1);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if ((paramContext instanceof FragmentActivity))
    {
      Object localObject = (FragmentActivity)paramContext;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a();
        if ((localObject instanceof ycd)) {
          ((ycd)localObject).b.dqV();
        }
      }
    }
    if ((paramButtonInfo.item_id.has()) && (paramButtonInfo.item_id.get() == 5))
    {
      paramQQAppInterface = new Intent(paramContext, CouponActivity.class);
      paramQQAppInterface.putExtra("url", "https://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
      paramQQAppInterface.putExtra("source", "1");
      paramQQAppInterface.putExtra("from", 5);
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
    if ((paramButtonInfo.item_id.has()) && (paramButtonInfo.item_id.get() == 6))
    {
      paramQQAppInterface = new Intent(paramContext, CouponActivity.class);
      if (paramButtonInfo.url.has()) {
        paramQQAppInterface.putExtra("url", paramButtonInfo.url.get());
      }
      paramQQAppInterface.putExtra("webStyle", "noBottomBar");
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
    if ((paramButtonInfo.url.has()) && (com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.isMiniAppScheme(paramButtonInfo.url.get())))
    {
      com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScheme(paramContext, paramButtonInfo.url.get(), 1209);
      return;
    }
    if ((paramButtonInfo.url.has()) && (com.tencent.mobileqq.mini.sdk.MiniAppLauncher.isMiniAppUrl(paramButtonInfo.url.get())))
    {
      com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(paramContext, paramButtonInfo.url.get(), 1035, null);
      return;
    }
    a(paramContext, paramQQAppInterface, paramString, paramButtonInfo);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, mobileqq_mp.ButtonInfo paramButtonInfo, String paramString2)
  {
    boolean bool = true;
    long l = paramButtonInfo.actionInfo.appid.get();
    Object localObject = Uri.parse(paramString2);
    paramString2 = ((Uri)localObject).getScheme();
    localObject = ((Uri)localObject).getHost();
    if ((!TextUtils.isEmpty(paramString2)) && (arxn.appIsExists(paramString2)))
    {
      anan localanan = new anan();
      int i;
      Bundle localBundle;
      int j;
      if (anan.ea((String)localObject) == 0)
      {
        i = 0;
        localBundle = anan.f((String)localObject);
        j = localBundle.getInt("a_launch_mode", 268435456);
        if (i == 0) {
          break label136;
        }
        localanan.a(paramQQAppInterface, paramContext, String.valueOf(l), (String)localObject, paramString2, j);
      }
      for (;;)
      {
        if (!bool) {
          a(paramQQAppInterface, paramContext, paramString1, paramButtonInfo);
        }
        return;
        i = 1;
        break;
        label136:
        bool = arxn.a(paramContext, paramString2, localBundle, j);
      }
    }
    a(paramQQAppInterface, paramContext, paramString1, paramButtonInfo);
  }
  
  private void a(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler)
  {
    if (paramMqqHandler != null) {
      paramMqqHandler.sendEmptyMessage(19);
    }
    paramMqqHandler = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    float f1 = paramMqqHandler.getFloat("search_lbs_logitude", 0.0F);
    float f2 = paramMqqHandler.getFloat("search_lbs_latitude", 0.0F);
    ((PublicAccountHandler)paramQQAppInterface.getBusinessHandler(11)).J(0, (int)(f2 * 1000000.0F), (int)(f1 * 1000000.0F), 0);
    abcx.a().E(paramQQAppInterface, "aio_news_click");
  }
  
  private void a(mobileqq_mp.SendMenuEventRequest paramSendMenuEventRequest)
  {
    BusinessObserver localBusinessObserver = (BusinessObserver)this.ca.get();
    Context localContext = (Context)this.bZ.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.n.get();
    String str1 = this.VJ;
    NewIntent localNewIntent = new NewIntent(localContext, kbt.class);
    localNewIntent.putExtra("cmd", "CertifiedAccountSvc.certified_account_write.SendMenuEvent");
    Object localObject = new PROTOCAL.StQWebReq();
    ((PROTOCAL.StQWebReq)localObject).Seq.set(-1L);
    ((PROTOCAL.StQWebReq)localObject).qua.set(avpq.getQUA3());
    ((PROTOCAL.StQWebReq)localObject).deviceInfo.set(avpp.a().getDeviceInfor());
    ((PROTOCAL.StQWebReq)localObject).busiBuff.set(ByteStringMicro.copyFrom(paramSendMenuEventRequest.toByteArray()));
    String str2 = sfx.getTraceId();
    if (!TextUtils.isEmpty(str2)) {
      ((PROTOCAL.StQWebReq)localObject).traceid.set(str2);
    }
    localObject = ((PROTOCAL.StQWebReq)localObject).toByteArray();
    paramSendMenuEventRequest = (mobileqq_mp.SendMenuEventRequest)localObject;
    if (localObject == null) {
      paramSendMenuEventRequest = new byte[4];
    }
    localNewIntent.putExtra("traceid", str2);
    localNewIntent.putExtra("data", paramSendMenuEventRequest);
    localNewIntent.setObserver(new kbd(this, localNewIntent, localContext, str1, localBusinessObserver, localQQAppInterface));
    if (localQQAppInterface != null) {
      localQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  private void b(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface.a().dWq();
    Uri localUri = aqcv.d();
    if (localUri != null)
    {
      ausj localausj = ausj.b((BaseActivity)paramContext);
      String[] arrayOfString = paramContext.getResources().getStringArray(2130969877);
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localausj.addButton(arrayOfString[i]);
        i += 1;
      }
      localausj.addCancelButton(2131721058);
      localausj.a(new kba(this, paramQQAppInterface, paramContext, localUri, paramSessionInfo, localausj));
      localausj.show();
    }
    for (;;)
    {
      if (this.ae != null) {}
      try
      {
        paramContext.unregisterReceiver(this.ae);
        label120:
        this.ae = null;
        this.ae = new kbb(this);
        paramQQAppInterface = new IntentFilter("com.tencent.biz.pubaccount.picResultAction");
        paramContext.registerReceiver(this.ae, paramQQAppInterface, "com.tencent.tim.msg.permission.pushnotify", null);
        this.aGR = 2;
        return;
        wmj.a(paramQQAppInterface, (Activity)paramContext, paramSessionInfo, null, null);
        paramQQAppInterface = (acms)paramQQAppInterface.getBusinessHandler(20);
        if ((!TextUtils.isEmpty(paramSessionInfo.aTl)) && (paramSessionInfo.cZ == 1)) {
          paramQQAppInterface.bM(paramSessionInfo.aTl, true);
        }
        ((BaseActivity)paramContext).setCanLock(false);
      }
      catch (Exception paramQQAppInterface)
      {
        break label120;
      }
    }
  }
  
  private void c(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = this.VK;
    boolean bool = this.adr;
    try
    {
      ((FragmentActivity)paramContext).getChatFragment().a().bIs();
      Intent localIntent = new Intent(paramContext, PoiMapActivity.class);
      localIntent.putExtra("uintype", paramSessionInfo.cZ);
      ((FragmentActivity)paramContext).startActivityForResult(localIntent, 18);
      ((BaseActivity)paramContext).setCanLock(false);
      if (this.af == null) {}
    }
    catch (Exception paramSessionInfo)
    {
      try
      {
        paramContext.unregisterReceiver(this.af);
        label84:
        this.af = null;
        this.af = new kbc(this, paramQQAppInterface, bool);
        paramQQAppInterface = new IntentFilter("com.tencent.biz.pubaccount.locationResultAction");
        paramContext.registerReceiver(this.af, paramQQAppInterface, "com.tencent.tim.msg.permission.pushnotify", null);
        return;
        paramSessionInfo = paramSessionInfo;
        paramSessionInfo.printStackTrace();
      }
      catch (Exception paramSessionInfo)
      {
        break label84;
      }
    }
  }
  
  private boolean c(String paramString, Context paramContext)
  {
    if (this.dp.containsKey(paramString))
    {
      long l3 = ((Long)this.dp.get(paramString)).longValue();
      long l4 = System.currentTimeMillis();
      long l2 = paramContext.getSharedPreferences("menuEventSharePre", 0).getLong("menuCacheTime", -1L);
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 21600000L;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-Menu", 2, "cacheTime(ms):" + l1);
      }
      return l4 - l3 >= l1;
    }
    return true;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    paramQQAppInterface = (acja)paramQQAppInterface.getManager(56);
    PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramString.toString());
    if (localPublicAccountInfo == null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      if (paramQQAppInterface == null) {
        return false;
      }
      if ((paramQQAppInterface.accountFlag & 0x8EA00000) == 0) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    if ((localPublicAccountInfo.accountFlag & 0x8EA00000) == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    while (!d(paramQQAppInterface, paramString)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    acxw localacxw = paramQQAppInterface.a().a();
    RecentUser localRecentUser = localacxw.a(paramString, 1008);
    if (localRecentUser.lastmsgtime < l)
    {
      localRecentUser.lastmsgtime = l;
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager", 2, "addPublicAccountToRu->pUin:" + paramString + ", currentTime:" + l);
      }
    }
    localacxw.e(localRecentUser);
    ThreadManager.executeOnSubThread(new PublicAccountManager.16(paramQQAppInterface, paramString));
  }
  
  private void x(String paramString, long paramLong)
  {
    this.dp.put(paramString, Long.valueOf(paramLong));
  }
  
  public void A(QQAppInterface paramQQAppInterface)
  {
    if (this.ib == 0L)
    {
      localObject = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
      if (localObject != null) {
        this.ib = ((SharedPreferences)localObject).getLong("recentlist_reported", 0L);
      }
    }
    Object localObject = new Date(this.ib);
    Date localDate = new Date(NetConnInfoCenter.getServerTimeMillis());
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountManager", 2, "reportRecentList today = " + localSimpleDateFormat.format(localDate) + ";lastdate = " + localSimpleDateFormat.format((Date)localObject));
    }
    if (localSimpleDateFormat.format(localDate).equals(localSimpleDateFormat.format((Date)localObject))) {}
    do
    {
      return;
      localObject = a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager", 2, "reportRecentList recentList= " + (String)localObject);
      }
      anot.a(null, "dc01160", "Pb_account_lifeservice", "", "0X800661D", "0X800661D", 0, 0, "", "", (String)localObject, "");
      this.ib = NetConnInfoCenter.getServerTimeMillis();
      paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putLong("recentlist_reported", this.ib);
    paramQQAppInterface.commit();
  }
  
  protected int a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
    case 1008: 
    case 1024: 
      do
      {
        do
        {
          return 0;
        } while (!d(paramQQAppInterface, paramString));
        return 1;
      } while (!jqs.b(paramQQAppInterface, paramString));
      return 2;
    case 0: 
      return 3;
    case 1: 
      return 4;
    case 3000: 
      return 5;
    case 7210: 
      return 6;
    case 7120: 
      return 7;
    case 5000: 
      return 8;
    case 9000: 
      return 9;
    case 4000: 
      return 10;
    case 6000: 
      return 11;
    case 1001: 
      return 12;
    case 7000: 
      return 13;
    case 7230: 
      return 14;
    }
    return 15;
  }
  
  public long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("history_msg_params_" + paramQQAppInterface.getAccount(), 0).getLong(paramString + "_msgid", 0L);
  }
  
  public mobileqq_mp.ButtonInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    List localList = b(paramQQAppInterface, paramString);
    if ((localList == null) || (localList.isEmpty()))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    int i = 0;
    for (;;)
    {
      if (i >= localList.size()) {
        break label190;
      }
      paramString = (mobileqq_mp.ButtonInfo)localList.get(i);
      if (paramString.id.has())
      {
        paramQQAppInterface = paramString;
        if (paramString.id.get() == paramInt) {
          break;
        }
      }
      if (paramString.sub_button.has())
      {
        paramQQAppInterface = paramString.sub_button.get();
        if (paramQQAppInterface.size() > 0)
        {
          int j = 0;
          while (j < paramQQAppInterface.size())
          {
            if ((((mobileqq_mp.ButtonInfo)paramQQAppInterface.get(j)).id.has()) && (((mobileqq_mp.ButtonInfo)paramQQAppInterface.get(j)).id.get() == paramInt)) {
              return (mobileqq_mp.ButtonInfo)paramQQAppInterface.get(j);
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    label190:
    return null;
  }
  
  public List<mobileqq_mp.ButtonInfo> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return b(paramQQAppInterface, paramString);
  }
  
  public NewIntent a(Context paramContext, AppInterface paramAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountManager", 2, String.format("sendMsgArriveReceipt request: msgId:%d msgOp:%d pcuin:%d cuin:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt) }));
    }
    paramContext = new NewIntent(paramContext, kbs.class);
    paramContext.putExtra("cmd", "send_msg_receipt");
    mobileqq_mp.SendPublicAccountMessageReceiptRequest localSendPublicAccountMessageReceiptRequest = new mobileqq_mp.SendPublicAccountMessageReceiptRequest();
    if (paramInt == 1)
    {
      localSendPublicAccountMessageReceiptRequest.uint64_unique_id.set(paramLong1);
      localSendPublicAccountMessageReceiptRequest.uint32_op.set(paramLong2);
    }
    for (;;)
    {
      localSendPublicAccountMessageReceiptRequest.receipt_type.set(paramInt);
      localSendPublicAccountMessageReceiptRequest.pcuin.set(paramLong3);
      localSendPublicAccountMessageReceiptRequest.cuin.set(paramLong4);
      paramContext.putExtra("data", localSendPublicAccountMessageReceiptRequest.toByteArray());
      paramContext.setObserver(new kbi(this, paramContext));
      if (paramAppInterface != null)
      {
        paramAppInterface.startServlet(paramContext);
        if (TextUtils.equals("2290230341", String.valueOf(paramLong3))) {
          ((avto)paramAppInterface.getManager(293)).eBV();
        }
      }
      return paramContext;
      if (paramInt == 2) {
        localSendPublicAccountMessageReceiptRequest.unique_ids.set(paramList);
      }
    }
  }
  
  public NewIntent a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    Object localObject1 = null;
    label105:
    NewIntent localNewIntent;
    do
    {
      long l;
      try
      {
        l = Long.valueOf(paramString).longValue();
        if ((paramBoolean) || (c("" + l, paramContext))) {
          break label105;
        }
        paramContext = (Context)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.i("PublicAccountManager", 2, "menu setting not outdate yet--");
          paramContext = (Context)localObject1;
        }
      }
      catch (NumberFormatException paramContext)
      {
        do
        {
          paramContext = (Context)localObject1;
        } while (!QLog.isColorLevel());
        QLog.e("PublicAccountManager", 2, "puin is invalid format:" + paramString);
        return null;
      }
      return paramContext;
      int i = 0;
      if (this.dq.containsKey("" + l)) {
        i = ((Integer)this.dq.get("" + l)).intValue();
      }
      Object localObject2 = new mobileqq_mp.GetPublicAccountMenuRequest();
      ((mobileqq_mp.GetPublicAccountMenuRequest)localObject2).seqno.set(i);
      ((mobileqq_mp.GetPublicAccountMenuRequest)localObject2).uin.set((int)l);
      localNewIntent = new NewIntent(paramContext, kbt.class);
      localNewIntent.putExtra("cmd", "CertifiedAccountSvc.certified_account_read.GetAccountMenu");
      localObject1 = new PROTOCAL.StQWebReq();
      ((PROTOCAL.StQWebReq)localObject1).Seq.set(-1L);
      ((PROTOCAL.StQWebReq)localObject1).qua.set(avpq.getQUA3());
      ((PROTOCAL.StQWebReq)localObject1).deviceInfo.set(avpp.a().getDeviceInfor());
      ((PROTOCAL.StQWebReq)localObject1).busiBuff.set(ByteStringMicro.copyFrom(((mobileqq_mp.GetPublicAccountMenuRequest)localObject2).toByteArray()));
      String str = sfx.getTraceId();
      if (!TextUtils.isEmpty(str)) {
        ((PROTOCAL.StQWebReq)localObject1).traceid.set(str);
      }
      localObject2 = ((PROTOCAL.StQWebReq)localObject1).toByteArray();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      localNewIntent.putExtra("traceid", str);
      localNewIntent.putExtra("data", (byte[])localObject1);
      localNewIntent.setObserver(new kbe(this, localNewIntent, paramQQAppInterface, paramString, paramContext, paramBusinessObserver));
      paramContext = localNewIntent;
    } while (paramQQAppInterface == null);
    paramQQAppInterface.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  public NewIntent a(String paramString, int paramInt, boolean paramBoolean, Context paramContext, AppInterface paramAppInterface, kaw.b paramb)
  {
    paramContext = new NewIntent(paramContext, kbs.class);
    paramContext.putExtra("cmd", "set_refuse_follow");
    mobileqq_mp.SetRefuseFollowRequest localSetRefuseFollowRequest = new mobileqq_mp.SetRefuseFollowRequest();
    localSetRefuseFollowRequest.luin.set(Long.parseLong(paramString));
    localSetRefuseFollowRequest.account_type.set(1);
    localSetRefuseFollowRequest.refuse_forever.set(paramBoolean);
    if (!paramBoolean) {
      localSetRefuseFollowRequest.refuse_period.set(paramInt);
    }
    paramContext.putExtra("data", localSetRefuseFollowRequest.toByteArray());
    paramContext.setObserver(new kbh(this, paramContext, paramb));
    if (paramAppInterface != null) {
      paramAppInterface.startServlet(paramContext);
    }
    return paramContext;
  }
  
  public void a(double paramDouble1, double paramDouble2, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = a(3, paramString2, paramBoolean);
    if (paramString2 != null)
    {
      paramString2.is_need_lbs.set(true);
      paramString2.latitude.set(paramDouble1);
      paramString2.longitude.set(paramDouble2);
      paramString2.event_id.set(15);
      if (paramString1 != null) {
        paramString2.lbsAddressLabel.set(paramString1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-Location:", 2, "event_id:" + paramString2.event_id.get() + " is_need_lbs:" + paramString2.is_need_lbs.get() + " latitude:" + paramString2.latitude.get() + " longitude:" + paramString2.longitude.get() + " lbsAddressLabel:" + paramString2.lbsAddressLabel.get());
      }
      a(paramString2);
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, kaw.a parama)
  {
    if ((paramString1 != null) && (!paramString1.equals(this.mCurrentUin))) {
      lN(paramString1);
    }
    this.mCurrentUin = paramString1;
    ThreadManager.executeOnSubThread(new PublicAccountManager.1(this, paramString2, paramQQAppInterface, parama, paramContext));
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2, BusinessObserver paramBusinessObserver)
  {
    a(paramContext, paramQQAppInterface, paramString1, paramString2, paramBoolean, paramDouble1, paramDouble2, paramBusinessObserver, 1, 0L, 0);
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2, BusinessObserver paramBusinessObserver, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("reportsendMenuEventequest", 2, "key:" + paramString2 + "uin:" + paramString1 + "type:" + paramInt1 + "msg_id:" + paramLong + "s_type" + paramInt2);
    }
    try
    {
      long l = Long.valueOf(paramString1).longValue();
      Object localObject = new mobileqq_mp.SendMenuEventRequest();
      ((mobileqq_mp.SendMenuEventRequest)localObject).key.set(paramString2);
      ((mobileqq_mp.SendMenuEventRequest)localObject).uin.set((int)l);
      ((mobileqq_mp.SendMenuEventRequest)localObject).type.set(paramInt1);
      ((mobileqq_mp.SendMenuEventRequest)localObject).msg_id.set(paramLong);
      ((mobileqq_mp.SendMenuEventRequest)localObject).s_type.set(paramInt2);
      ((mobileqq_mp.SendMenuEventRequest)localObject).menu_type.set(aI(paramString1));
      if (paramBoolean)
      {
        ((mobileqq_mp.SendMenuEventRequest)localObject).is_need_lbs.set(true);
        ((mobileqq_mp.SendMenuEventRequest)localObject).latitude.set(paramDouble1);
        ((mobileqq_mp.SendMenuEventRequest)localObject).longitude.set(paramDouble2);
      }
      NewIntent localNewIntent = new NewIntent(paramContext, kbt.class);
      localNewIntent.putExtra("cmd", "CertifiedAccountSvc.certified_account_write.SendMenuEvent");
      paramString2 = new PROTOCAL.StQWebReq();
      paramString2.Seq.set(-1L);
      paramString2.qua.set(avpq.getQUA3());
      paramString2.deviceInfo.set(avpp.a().getDeviceInfor());
      paramString2.busiBuff.set(ByteStringMicro.copyFrom(((mobileqq_mp.SendMenuEventRequest)localObject).toByteArray()));
      String str = sfx.getTraceId();
      if (!TextUtils.isEmpty(str)) {
        paramString2.traceid.set(str);
      }
      localObject = paramString2.toByteArray();
      paramString2 = (String)localObject;
      if (localObject == null) {
        paramString2 = new byte[4];
      }
      localNewIntent.putExtra("traceid", str);
      localNewIntent.putExtra("data", paramString2);
      localNewIntent.setObserver(new kbf(this, localNewIntent, paramContext, paramString1, paramBusinessObserver, paramQQAppInterface));
      if (paramQQAppInterface != null) {
        paramQQAppInterface.startServlet(localNewIntent);
      }
      return;
    }
    catch (NumberFormatException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublicAccountManager", 2, "puin is invalid format:" + paramString1);
    }
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, BusinessObserver paramBusinessObserver)
  {
    this.VJ = paramString1;
    this.bZ = new WeakReference(paramBaseActivity);
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("app", "QD");
      if (paramString2 != null) {
        paramString1.put("assignType", Long.parseLong(paramString2));
      }
      if (paramString3 != null) {
        paramString1.put("assignKey", Long.parseLong(paramString3));
      }
      if (paramString4 != null) {
        paramString1.put("ext", paramString4);
      }
      i = 0;
    }
    catch (Exception paramString2)
    {
      do
      {
        for (;;)
        {
          int i = 1;
          continue;
          paramString1 = paramString1.toString();
        }
        paramString1.menu_type.set(1001);
        paramString2 = (QQAppInterface)this.n.get();
        paramString2 = this.VJ;
        paramString3 = new NewIntent(paramBaseActivity, kbt.class);
        paramString3.putExtra("cmd", "CertifiedAccountSvc.certified_account_write.SendMenuEvent");
        paramString2 = new PROTOCAL.StQWebReq();
        paramString2.Seq.set(-1L);
        paramString2.qua.set(avpq.getQUA3());
        paramString2.deviceInfo.set(avpp.a().getDeviceInfor());
        paramString2.busiBuff.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
        paramString4 = sfx.getTraceId();
        if (!TextUtils.isEmpty(paramString4)) {
          paramString2.traceid.set(paramString4);
        }
        paramString2 = paramString2.toByteArray();
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = new byte[4];
        }
        paramString3.putExtra("traceid", paramString4);
        paramString3.putExtra("data", paramString1);
        paramString3.setObserver(paramBusinessObserver);
      } while (paramBaseActivity.app == null);
      paramBaseActivity.app.startServlet(paramString3);
    }
    if (i != 0)
    {
      paramString1 = "QD";
      paramString1 = a(1, paramString1, false);
      if (paramString1 != null) {
        break label125;
      }
    }
    label125:
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface.getApp().getSharedPreferences("history_msg_params_" + paramQQAppInterface.getAccount(), 0).edit().putLong(paramString + "_msgid", paramLong).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountManager", 4, "savePublicAccountMenuSetting");
    }
    if (paramGetPublicAccountMenuResponse == null) {}
    label19:
    int i;
    label43:
    Object localObject;
    PublicAccountMenuEntity localPublicAccountMenuEntity1;
    label137:
    label206:
    do
    {
      do
      {
        break label19;
        do
        {
          return;
        } while (paramQQAppInterface == null);
        if (!paramGetPublicAccountMenuResponse.seqno.has()) {
          break;
        }
        i = paramGetPublicAccountMenuResponse.seqno.get();
        ax(paramString, i);
        l = System.currentTimeMillis();
        x(paramString, l);
      } while (paramGetPublicAccountMenuResponse.toByteArray() == null);
      localObject = paramQQAppInterface.a().createEntityManager();
      localPublicAccountMenuEntity1 = new PublicAccountMenuEntity(paramString, paramGetPublicAccountMenuResponse, l);
      if (((EntityManager)localObject).find(PublicAccountMenuEntity.class, paramString) == null) {
        break label391;
      }
      PublicAccountMenuEntity localPublicAccountMenuEntity2 = (PublicAccountMenuEntity)((EntityManager)localObject).find(PublicAccountMenuEntity.class, paramString);
      if (localPublicAccountMenuEntity2 == null) {
        break label381;
      }
      localPublicAccountMenuEntity2.clone(localPublicAccountMenuEntity1);
      ((EntityManager)localObject).update(localPublicAccountMenuEntity2);
      ((EntityManager)localObject).close();
      localObject = paramGetPublicAccountMenuResponse.button_info.get();
      long l = localPublicAccountMenuEntity1.savedDateTime;
      this.dp.put(paramString, Long.valueOf(l));
      this.dr.put(paramString, localObject);
      if (!paramGetPublicAccountMenuResponse.menu_type.has()) {
        break label401;
      }
      i = paramGetPublicAccountMenuResponse.menu_type.get();
      this.ds.put(paramString, Integer.valueOf(i));
    } while (i == 0);
    if (i == 1) {}
    for (paramGetPublicAccountMenuResponse = "icon";; paramGetPublicAccountMenuResponse = "text")
    {
      anot.c(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC2", "0X8005EC2", 0, 0, paramString, paramGetPublicAccountMenuResponse, "", "");
      if ((((List)localObject).size() <= 0) || (((List)localObject).get(0) == null) || (!((mobileqq_mp.ButtonInfo)((List)localObject).get(0)).sub_button.has()) || (((mobileqq_mp.ButtonInfo)((List)localObject).get(0)).sub_button.get() == null)) {
        break;
      }
      anot.c(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC3", "0X8005EC3", 0, 0, paramString, String.valueOf(((mobileqq_mp.ButtonInfo)((List)localObject).get(0)).sub_button.get().size()), "", "");
      return;
      i = 0;
      break label43;
      label381:
      ((EntityManager)localObject).persist(localPublicAccountMenuEntity1);
      break label137;
      label391:
      ((EntityManager)localObject).persist(localPublicAccountMenuEntity1);
      break label137;
      label401:
      i = 0;
      break label206;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, List<String> paramList)
  {
    mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = a(3, this.VK, this.adr);
    if (localSendMenuEventRequest != null)
    {
      localSendMenuEventRequest.event_id.set(paramInt2);
      if (paramString != null)
      {
        localSendMenuEventRequest.scan_result.set(paramString);
        localSendMenuEventRequest.scanType.set(paramInt1);
      }
      if (paramInt3 >= 0) {
        localSendMenuEventRequest.pictureCount.set(paramInt3);
      }
      if (paramList != null) {
        localSendMenuEventRequest.picture_Md5s.set(paramList);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-Event:", 2, "event_id:" + localSendMenuEventRequest.event_id.get() + " scan_result:" + localSendMenuEventRequest.scan_result.get() + " pictureCount:" + localSendMenuEventRequest.pictureCount.get());
      }
      a(localSendMenuEventRequest);
    }
  }
  
  public void a(String paramString1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2, int paramInt1, BusinessObserver paramBusinessObserver, MqqHandler paramMqqHandler, int paramInt2, SessionInfo paramSessionInfo)
  {
    mobileqq_mp.ButtonInfo localButtonInfo = a(paramQQAppInterface, paramString2, paramInt1);
    if (localButtonInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountManager", 2, "Can't find menu via menu id:" + paramInt1 + ".");
      }
    }
    label117:
    do
    {
      return;
      if ((paramSessionInfo.cZ == 1008) && (((paramInt2 == 1) && (!localButtonInfo.sub_button.has())) || (paramInt2 == 2))) {
        f(paramQQAppInterface, paramString2);
      }
      int i;
      Object localObject;
      if (localButtonInfo.type.has())
      {
        i = localButtonInfo.type.get();
        if (!localButtonInfo.name.has()) {
          break label562;
        }
        paramString1 = localButtonInfo.name.get();
        kbp.a(null, "P_CliOper", "Pb_account_lifeservice", paramString2, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(paramInt2), String.valueOf(paramInt1), paramString1, String.valueOf(i), false);
        lcm.a().a(paramString2, paramInt1, paramInt2, localButtonInfo);
        localObject = new StringBuilder();
        paramString1 = "";
        if (i == 2)
        {
          if (!localButtonInfo.url.has()) {
            break label568;
          }
          paramString1 = anqu.nH(localButtonInfo.url.get());
        }
        StringBuilder localStringBuilder = ((StringBuilder)localObject).append("MENUID=").append(String.valueOf(paramInt1)).append(";LEVELID=").append(String.valueOf(paramInt2)).append(";NAME=");
        if (!localButtonInfo.name.has()) {
          break label574;
        }
        localObject = localButtonInfo.name.get();
        kbp.a(null, "P_CliOper", "Pb_account_lifeservice", paramString2, "0X8005D4B", "0X8005D4B", 0, 0, (String)localObject + ";REFERRER=" + paramString1, "", "", "", false);
        this.ca = new WeakReference(paramBusinessObserver);
        this.n = new WeakReference(paramQQAppInterface);
        this.bZ = new WeakReference(paramContext);
        this.VJ = paramString2;
        if (!localButtonInfo.key.has()) {
          break label581;
        }
        paramString1 = localButtonInfo.key.get();
        this.VK = paramString1;
        if (!localButtonInfo.is_new_menu.has()) {
          break label587;
        }
      }
      for (boolean bool = localButtonInfo.is_new_menu.get();; bool = false)
      {
        this.adr = bool;
        if ((paramContext instanceof FragmentActivity))
        {
          paramString1 = ((FragmentActivity)paramContext).getChatFragment();
          if (paramString1 != null)
          {
            paramString1 = paramString1.a();
            if ((paramString1 instanceof ycd))
            {
              paramString1 = (ycd)paramString1;
              paramString1.bYw += 1;
            }
          }
        }
        switch (i)
        {
        default: 
          return;
        case 1: 
          if (paramMqqHandler != null) {
            paramMqqHandler.sendEmptyMessage(1001);
          }
          if ((!localButtonInfo.is_need_lbs.has()) || (!localButtonInfo.is_need_lbs.get())) {
            break label593;
          }
          new Thread(this.ct).start();
          return;
          i = 0;
          break label117;
          paramString1 = "";
          break label137;
          paramString1 = "";
          break label229;
          localObject = "";
          break label288;
          paramString1 = "";
          break label398;
        }
      }
      if (paramMqqHandler != null) {
        paramMqqHandler.sendEmptyMessage(19);
      }
      if (localButtonInfo.media_id.has()) {}
      for (paramString1 = localButtonInfo.media_id.get();; paramString1 = null)
      {
        a(false, 0.0D, 0.0D, null, paramString1, this.VK, this.adr);
        return;
      }
      if (paramMqqHandler != null) {
        paramMqqHandler.sendEmptyMessage(1001);
      }
      if (paramMqqHandler != null) {
        paramMqqHandler.sendEmptyMessage(1001);
      }
      paramString1 = localButtonInfo.actionInfo.a_actionData.get();
      paramBusinessObserver = localButtonInfo.actionInfo.actionData.get();
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = paramBusinessObserver;
        if (!localButtonInfo.url.has()) {
          break label793;
        }
        paramBusinessObserver = localButtonInfo.url.get();
        if (!localButtonInfo.media_id.has()) {
          break label800;
        }
      }
      for (paramMqqHandler = localButtonInfo.media_id.get();; paramMqqHandler = null)
      {
        if (!TextUtils.isEmpty(paramString1)) {
          break label806;
        }
        a(paramQQAppInterface, paramContext, paramString2, localButtonInfo);
        a(paramBusinessObserver, (mobileqq_mp.ActionInfo)localButtonInfo.actionInfo.get(), paramMqqHandler);
        return;
        break;
        paramBusinessObserver = "";
        break label733;
      }
      paramSessionInfo = aqik.c(paramQQAppInterface, paramContext, paramString1);
      if (paramSessionInfo == null)
      {
        if (localButtonInfo.actionInfo.appid.has())
        {
          a(paramQQAppInterface, paramContext, paramString2, localButtonInfo, paramString1);
          return;
        }
        a(paramQQAppInterface, paramContext, paramString2, localButtonInfo);
        a(paramBusinessObserver, (mobileqq_mp.ActionInfo)localButtonInfo.actionInfo.get(), paramMqqHandler);
        return;
      }
      if (TextUtils.isEmpty(paramSessionInfo.getServerName()))
      {
        a(paramQQAppInterface, paramContext, paramString2, localButtonInfo, paramString1);
        return;
      }
    } while (paramSessionInfo.ace());
    label137:
    label229:
    a(paramQQAppInterface, paramContext, paramString2, localButtonInfo);
    label288:
    label562:
    label568:
    label574:
    label581:
    label587:
    label593:
    label733:
    a(paramBusinessObserver, (mobileqq_mp.ActionInfo)localButtonInfo.actionInfo.get(), paramMqqHandler);
    label398:
    label793:
    label800:
    label806:
    return;
    if (localButtonInfo.event_id.has()) {}
    for (paramInt1 = localButtonInfo.event_id.get();; paramInt1 = 0) {
      switch (paramInt1)
      {
      default: 
        return;
      case 1: 
        a(paramQQAppInterface, paramContext, paramString2);
        a(null, 0, 1, -1, null);
        return;
      }
    }
    a(paramContext, paramMqqHandler, false);
    return;
    a(paramContext, paramMqqHandler, true);
    return;
    a(paramContext, paramQQAppInterface, paramSessionInfo);
    return;
    b(paramContext, paramQQAppInterface, paramSessionInfo);
    return;
    c(paramContext, paramQQAppInterface, paramSessionInfo);
    return;
    a(paramQQAppInterface, paramMqqHandler);
    return;
    a(paramContext, paramQQAppInterface);
  }
  
  public void a(String paramString1, mobileqq_mp.ActionInfo paramActionInfo, String paramString2)
  {
    mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = a(2, this.VK, this.adr);
    if (localSendMenuEventRequest != null)
    {
      localSendMenuEventRequest.url.set(paramString1);
      localSendMenuEventRequest.actionInfo.set(paramActionInfo);
      if (paramString2 != null) {
        localSendMenuEventRequest.media_id.set(paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-Url:", 2, "url:" + localSendMenuEventRequest.url.get() + " actionInfo:" + localSendMenuEventRequest.actionInfo.get() + " media_id:" + localSendMenuEventRequest.media_id.get());
      }
      a(localSendMenuEventRequest);
    }
  }
  
  public void a(boolean paramBoolean1, double paramDouble1, double paramDouble2, String paramString1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    paramString3 = a(1, paramString3, paramBoolean2);
    if (paramString3 != null)
    {
      if (paramBoolean1)
      {
        paramString3.is_need_lbs.set(true);
        paramString3.latitude.set(paramDouble1);
        paramString3.longitude.set(paramDouble2);
      }
      if (paramString1 != null) {
        paramString3.lbsAddressLabel.set(paramString1);
      }
      if (paramString2 != null) {
        paramString3.media_id.set(paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-Click:", 2, "is_need_lbs:" + paramString3.is_need_lbs.get() + " latitude:" + paramString3.latitude.get() + " longitude:" + paramString3.longitude.get() + " lbsAddressLabel:" + paramString3.lbsAddressLabel.get() + " media_id:" + paramString3.media_id.get());
      }
      a(paramString3);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (NetConnInfoCenter.getServerTimeMillis() < this.rl + 35000L) {}
    do
    {
      return false;
      this.rl = NetConnInfoCenter.getServerTimeMillis();
    } while ((aqgz.aCG()) || (aqhq.getAvailableInnernalMemorySize() <= 1.048576E+008F));
    paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.egu();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountManager", 2, "startWebProcess  startWebProcess by userlist ad");
    }
    return true;
  }
  
  public int aH(String paramString)
  {
    if (this.dq.containsKey(paramString)) {
      return ((Integer)this.dq.get(paramString)).intValue();
    }
    return 0;
  }
  
  public int aI(String paramString)
  {
    if (this.ds.containsKey(paramString)) {
      return ((Integer)this.ds.get(paramString)).intValue();
    }
    return 0;
  }
  
  public void ax(String paramString, int paramInt)
  {
    this.dq.put(paramString, Integer.valueOf(paramInt));
  }
  
  List<mobileqq_mp.ButtonInfo> b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return (List)this.dr.get(paramString);
  }
  
  public void b(NewIntent paramNewIntent)
  {
    if (paramNewIntent != null) {
      paramNewIntent.setObserver(null);
    }
  }
  
  public void bL(Context paramContext)
  {
    if (this.scanResultReceiver != null) {}
    try
    {
      paramContext.unregisterReceiver(this.scanResultReceiver);
      label15:
      this.scanResultReceiver = null;
      if (this.ae != null) {}
      try
      {
        paramContext.unregisterReceiver(this.ae);
        label35:
        this.ae = null;
        if (this.af != null) {}
        try
        {
          paramContext.unregisterReceiver(this.af);
          label55:
          this.af = null;
          return;
        }
        catch (Exception paramContext)
        {
          break label55;
        }
      }
      catch (Exception localException1)
      {
        break label35;
      }
    }
    catch (Exception localException2)
    {
      break label15;
    }
  }
  
  public void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.getApp().getSharedPreferences("history_msg_params_" + paramQQAppInterface.getAccount(), 0).edit().remove(paramString + "_msgid").commit();
  }
  
  public void lN(String paramString)
  {
    this.dp.remove(paramString);
    this.dq.remove(paramString);
    this.dr.remove(paramString);
    this.ds.remove(paramString);
    this.ib = 0L;
    if (QLog.isColorLevel()) {
      QLog.e("PublicAccountManager", 2, "left menu size:" + this.dr.size());
    }
  }
  
  public static abstract interface a
  {
    public abstract void aBC();
  }
  
  public static abstract interface b
  {
    public abstract void aB(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kaw
 * JD-Core Version:    0.7.0.1
 */