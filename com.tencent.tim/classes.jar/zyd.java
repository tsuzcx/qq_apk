import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.im.qqwallet.QWalletPubAdReport.QueryReq;
import tencent.im.qqwallet.QWalletPubAdReport.QueryRsp;
import tencent.im.qqwallet.QWalletPubAdReport.ReportReq;
import tencent.im.qqwallet.QWalletPubAdReport.TerminalInfor;

public class zyd
  implements Manager
{
  private volatile long LF;
  private boolean buy;
  private volatile GdtAd jdField_c_of_type_ComTencentGdtadAditemGdtAd;
  private GdtAppReceiver jdField_c_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private tgc.a jdField_c_of_type_Tgc$a;
  private volatile int cfy;
  
  public zyd(QQAppInterface paramQQAppInterface) {}
  
  private boolean VW()
  {
    return false;
  }
  
  private static qq_ad_get.QQAdGet a(long paramLong, String paramString, int paramInt)
  {
    qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
    localPositionInfo.pos_id.set(paramString);
    localPositionInfo.ad_count.set(paramInt);
    paramString = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    paramString.deep_link_version.set(1);
    localPositionInfo.pos_ext.set(paramString);
    paramString = new qq_ad_get.QQAdGet.UserInfo();
    paramString.qq.set(paramLong);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localQQAdGet.position_info.add(localPositionInfo);
    localQQAdGet.user_info.set(paramString);
    return localQQAdGet;
  }
  
  @NotNull
  private QWalletPubAdReport.QueryReq a(String paramString, Context paramContext)
  {
    QWalletPubAdReport.QueryReq localQueryReq = new QWalletPubAdReport.QueryReq();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localQueryReq.uin.set(str);
    localQueryReq.pskey.set(paramString);
    localQueryReq.channel.set(1);
    localQueryReq.terminal_infor.set(a(paramContext));
    return localQueryReq;
  }
  
  @NotNull
  private QWalletPubAdReport.ReportReq a(String paramString, int paramInt, Context paramContext)
  {
    QWalletPubAdReport.ReportReq localReportReq = new QWalletPubAdReport.ReportReq();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localReportReq.uin.set(str);
    localReportReq.pskey.set(paramString);
    localReportReq.channel.set(1);
    localReportReq.ad_reslut.set(paramInt);
    localReportReq.terminal_infor.set(a(paramContext));
    return localReportReq;
  }
  
  @NotNull
  private QWalletPubAdReport.TerminalInfor a(Context paramContext)
  {
    QWalletPubAdReport.TerminalInfor localTerminalInfor = new QWalletPubAdReport.TerminalInfor();
    localTerminalInfor.model.set("android_mqq");
    localTerminalInfor.appid.set(AppSetting.getAppId() + "");
    localTerminalInfor.qq_version.set("3.4.4");
    localTerminalInfor.device_name.set(Build.MODEL);
    localTerminalInfor.client_os.set(Build.VERSION.RELEASE + ",sdk" + Build.VERSION.SDK_INT);
    Object localObject = localTerminalInfor.root_flag;
    if (QWalletHelper.isPhoneRooted()) {}
    for (int i = 1;; i = 0)
    {
      ((PBInt32Field)localObject).set(i);
      try
      {
        String str = QWalletHelper.getQWDevId();
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = QWalletHelper.getMacAddress(paramContext);
        }
        localTerminalInfor.device_id.set((String)localObject);
        return localTerminalInfor;
      }
      catch (Throwable paramContext)
      {
        QLog.e("QWalletGdtAdManager", 1, paramContext, new Object[0]);
      }
    }
    return localTerminalInfor;
  }
  
  private void a(Context paramContext, String paramString, int paramInt, tgc.a parama)
  {
    tgc.b localb = new tgc.b();
    localb.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin(), paramString, paramInt);
    new tgc(localb, new WeakReference(parama)).c(new WeakReference(paramContext));
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "doReqAds start");
    }
  }
  
  private void a(QWalletPubAdReport.QueryRsp paramQueryRsp)
  {
    int j = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("sp_wallet_gdt", 4);
    int k = paramQueryRsp.pv_flag.get();
    int m = paramQueryRsp.uv_flag.get();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    long l;
    if (k == 1)
    {
      l = paramQueryRsp.pv_timestamp.get();
      localEditor.putLong("sp_key_pv_timestamp", l).apply();
      localEditor = ((SharedPreferences)localObject).edit();
      if (m != 1) {
        break label252;
      }
    }
    label252:
    for (int i = paramQueryRsp.uv_day_freq.get();; i = 0)
    {
      localEditor.putInt("sp_key_day_freq", i).apply();
      localObject = ((SharedPreferences)localObject).edit();
      i = j;
      if (m == 1) {
        i = paramQueryRsp.uv_week_freq.get();
      }
      ((SharedPreferences.Editor)localObject).putInt("sp_key_week_freq", i).apply();
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "saveUvControl...pv_flag:" + k + ",uv_flag:" + m + ",pv_timestamp:" + paramQueryRsp.pv_timestamp.get() + ",uv_day_freq:" + paramQueryRsp.uv_day_freq.get() + ",uv_week_freq:" + paramQueryRsp.uv_week_freq.get());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private void b(BaseActivity paramBaseActivity, BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = new zye(this, NetConnInfoCenter.getServerTimeMillis(), paramBaseChatPie);
    this.jdField_c_of_type_Tgc$a = paramBaseChatPie;
    a(paramBaseActivity, "6001902438716523", 1, paramBaseChatPie);
  }
  
  private void b(tgc paramtgc)
  {
    if (QLog.isColorLevel())
    {
      if (paramtgc != null) {
        break label20;
      }
      QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse ret fail,loader null");
    }
    label20:
    do
    {
      return;
      if (paramtgc.a() == null)
      {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse ret fail,getSession null");
        return;
      }
      if (paramtgc.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null)
      {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse ret fail,loader.getSession().response null");
        return;
      }
    } while (paramtgc.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get() == 0);
    QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse ret fail,loader.getSession().response.ret.get " + paramtgc.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get());
  }
  
  private void csq()
  {
    if (this.buy) {
      l("public.tailplace.show", "", "", "2", "");
    }
  }
  
  private void i(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.a != null)) {
      paramBaseChatPie.a.notifyDataSetChanged();
    }
  }
  
  private void k(BaseActivity paramBaseActivity)
  {
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if (localQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "doReqAdsControl start");
    }
    avor.a(localQQAppInterface, "tenpay.com", new zyf(this, paramBaseActivity, localQQAppInterface, NetConnInfoCenter.getServerTimeMillis()));
  }
  
  public static void l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if (localQQAppInterface == null) {
      return;
    }
    anot.a(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramString1, 0, 0, paramString2, paramString3, paramString4, paramString5);
  }
  
  public boolean VX()
  {
    return true;
  }
  
  public GdtAd a()
  {
    return this.jdField_c_of_type_ComTencentGdtadAditemGdtAd;
  }
  
  public GdtAppReceiver a(Context paramContext)
  {
    if (this.jdField_c_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
    {
      this.jdField_c_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_c_of_type_ComTencentGdtadAditemGdtAppReceiver.register(paramContext);
    }
    return this.jdField_c_of_type_ComTencentGdtadAditemGdtAppReceiver;
  }
  
  public void a(BaseActivity paramBaseActivity, BaseChatPie paramBaseChatPie)
  {
    this.jdField_c_of_type_ComTencentGdtadAditemGdtAd = null;
    this.cfy = 0;
    if (VX()) {}
    long l1;
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      if (VW())
      {
        k(paramBaseActivity);
        b(paramBaseActivity, paramBaseChatPie);
        return;
      }
      l1 = NetConnInfoCenter.getServerTimeMillis();
      localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("sp_wallet_gdt", 4);
      this.LF = (localSharedPreferences.getLong("sp_key_pv_timestamp", 0L) * 1000L);
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "handleWhenPubEnter...currentTime:" + l1 + ",mPvTimestamp:" + this.LF + ",mPvFlag:" + this.cfy);
      }
      if (l1 >= this.LF) {
        break;
      }
      csq();
    } while (!QLog.isColorLevel());
    QLog.i("QWalletGdtAdManager", 2, "handleWhenPubEnter...timeLimit,return");
    return;
    int i1 = localSharedPreferences.getInt("sp_key_day_freq", 0);
    int i = localSharedPreferences.getInt("sp_key_week_freq", 0);
    int n;
    if (i1 != 0)
    {
      n = i;
      if (i != 0) {}
    }
    else
    {
      localObject = (aaai)paramBaseActivity.app.getManager(245);
      i1 = ((aaai)localObject).a("common", 1, new String[] { "pub_ad_control", "gdt_day_freq" });
      n = ((aaai)localObject).a("common", 4, new String[] { "pub_ad_control", "gdt_week_freq" });
    }
    int i2 = 0;
    int i5 = 0;
    int i4 = 0;
    int i6 = 0;
    int i7 = 0;
    int i3 = 0;
    Object localObject = localSharedPreferences.getString("sp_key_show_ad_times", "");
    int m = i7;
    i = i5;
    int j;
    int k;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      j = i6;
      k = i2;
    }
    for (;;)
    {
      JSONArray localJSONArray;
      try
      {
        localObject = new JSONArray((String)localObject);
        j = i6;
        k = i2;
        m = i7;
        i = i5;
        if (((JSONArray)localObject).length() > 0)
        {
          j = i6;
          k = i2;
          localJSONArray = new JSONArray();
          i2 = 0;
          i = i4;
          m = i3;
          j = m;
          k = i;
          if (i2 >= ((JSONArray)localObject).length()) {
            break label686;
          }
          j = m;
          k = i;
          long l2 = ((JSONArray)localObject).getLong(i2);
          long l3 = l1 - 1000L * l2;
          if (l3 < 604800000L)
          {
            i3 = m + 1;
            m = i;
            if (l3 < 86400000L) {
              m = i + 1;
            }
            j = i3;
            k = m;
            localJSONArray.put(l2);
            i4 = m;
          }
          else
          {
            j = m;
            k = i;
            i3 = m;
            i4 = i;
            if (QLog.isColorLevel())
            {
              j = m;
              k = i;
              QLog.i("QWalletGdtAdManager", 2, "handleWhenPubEnter...this time is over 1 week,just ignore,time:" + l2);
              i3 = m;
              i4 = i;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QWalletGdtAdManager", 1, localThrowable, new Object[0]);
        localSharedPreferences.edit().remove("sp_key_show_ad_times").apply();
        i = k;
        m = j;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "handleWhenPubEnter...last24HourAdCount:" + i + ",gdt_day_freq:" + i1 + ",last7DayAdCount:" + m + ",gdt_week_freq:" + n);
        }
        if ((i < i1) && (m < n)) {
          break label721;
        }
        csq();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QWalletGdtAdManager", 2, "handleWhenPubEnter...frequency limited,just return");
        return;
        label686:
        j = m;
        k = i;
        localSharedPreferences.edit().putString("sp_key_show_ad_times", localJSONArray.toString()).apply();
      }
      label721:
      k(paramBaseActivity);
      b(paramBaseActivity, paramBaseChatPie);
      return;
      i2 += 1;
      m = i3;
      i = i4;
    }
  }
  
  public void ad(Context paramContext, int paramInt)
  {
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if (localQQAppInterface == null) {
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "doReqAdsStatistics start,adResult:" + paramInt);
    }
    SharedPreferences localSharedPreferences;
    Object localObject1;
    if (paramInt == 1)
    {
      localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_wallet_gdt", 4);
      localObject1 = localSharedPreferences.getString("sp_key_show_ad_times", "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label223;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new JSONArray();
        }
        ((JSONArray)localObject3).put(l / 1000L);
        localSharedPreferences.edit().putString("sp_key_show_ad_times", ((JSONArray)localObject3).toString()).apply();
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "doReqAdsStatistics recordShowTimeString:" + ((JSONArray)localObject3).toString());
        }
        avor.a(localQQAppInterface, "tenpay.com", new zyh(this, paramInt, paramContext, localQQAppInterface, l));
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QWalletGdtAdManager", 1, localThrowable, new Object[0]);
      }
      label223:
      Object localObject2 = null;
    }
  }
  
  public void cD(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 1, "reportUrlByHttpGet...reportUrl:" + paramString);
      }
      ThreadManager.executeOnNetWorkThread(new QWalletGdtAdManager.4(this, paramString));
    }
  }
  
  public void csr()
  {
    Iterator localIterator = antu.AT.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityResume();
    }
  }
  
  public void css()
  {
    Iterator localIterator = antu.AT.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityPause();
    }
  }
  
  public void du(Context paramContext)
  {
    this.jdField_c_of_type_ComTencentGdtadAditemGdtAd = null;
    this.cfy = 0;
    this.LF = 0L;
    this.buy = false;
    if (this.jdField_c_of_type_ComTencentGdtadAditemGdtAppReceiver != null)
    {
      this.jdField_c_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(paramContext);
      this.jdField_c_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
    }
    this.jdField_c_of_type_Tgc$a = null;
    paramContext = antu.AT.iterator();
    while (paramContext.hasNext())
    {
      AdExposureChecker localAdExposureChecker = (AdExposureChecker)paramContext.next();
      localAdExposureChecker.onActivityDestroy();
      localAdExposureChecker.setCallback(null);
    }
    antu.AT.clear();
    antu.a = null;
  }
  
  public void hs(List<ChatMessage> paramList)
  {
    this.buy = false;
    if (VX()) {
      return;
    }
    int i = paramList.size() - 1;
    label22:
    ChatMessage localChatMessage;
    if (i >= 0)
    {
      localChatMessage = (ChatMessage)paramList.get(i);
      if ((this.buy) || (!(localChatMessage instanceof MessageForStructing)) || (!"1".equals(localChatMessage.getExtInfoFromExtStr("wallet_ad_msg")))) {
        break label139;
      }
      localChatMessage.isShowQWalletPubAd = true;
      this.buy = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletGdtAdManager", 2, "list,time:" + aqmu.bR(localChatMessage.time * 1000L) + ",isShowQWalletPubAd:" + localChatMessage.isShowQWalletPubAd);
      }
      i -= 1;
      break label22;
      break;
      label139:
      localChatMessage.isShowQWalletPubAd = false;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyd
 * JD-Core Version:    0.7.0.1
 */