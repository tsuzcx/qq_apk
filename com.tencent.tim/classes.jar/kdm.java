import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.1;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.2;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.biz.pubaccount.ecshopassit.ShopCanvasFragment;
import com.tencent.biz.pubaccount.ecshopassit.ShopVideoCeilingFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class kdm
  implements Manager
{
  public static final String Yl = BaseApplication.getContext().getFilesDir() + File.separator + "shop_assit_banner_json.txt";
  public static final String Ym = acbn.SDCARD_PATH + ".shop_assit/image/";
  public static String Yn = "";
  public static String Yo = "";
  public static final String Yp;
  public static final String Yq;
  public static String Yr;
  public static final String Ys = BaseApplicationImpl.getContext().getFilesDir().getAbsoluteFile() + File.separator + "animConfig/red_packet.png";
  public static int aHY;
  public static boolean aem;
  public static HashMap<String, String> da = new HashMap();
  public static HashMap<String, Long> db = new HashMap();
  public static List<String> fX;
  public static List<String> fY;
  public Set<String> H = new HashSet();
  public String Yt;
  public String Yu;
  public String Yv;
  aqdf jdField_a_of_type_Aqdf;
  private kdm.a jdField_a_of_type_Kdm$a;
  final Object aF = new Object();
  public int aHZ;
  public int aIa;
  public int aIb;
  private boolean aek = true;
  private boolean ael;
  public boolean aen;
  public boolean aeo;
  public boolean aep;
  public boolean aeq;
  public boolean aer;
  public BroadcastReceiver ag = new kdn(this);
  aqdf.a b = new kdo(this);
  public String[] be = { "https://gouwu.qq.com/m/cgi-bin/shop/discover?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/haowu.html?_wv=3&max_age=600", "https://gouwu.qq.com/m/cgi-bin/shop/nearby?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/my.html?_wv=3" };
  private Map<String, EcShopData> dt;
  private String mAccount;
  public QQAppInterface mApp;
  public List<EcShopData> mDataList;
  private GdtAppReceiver mGdtAppReceiver;
  private long mLastReadTime;
  public final Object object = new Object();
  public long rM;
  public long rN;
  
  static
  {
    aHY = 600000;
    Yp = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_wl_conf.json";
    Yq = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_jd_conf.json";
    aem = true;
  }
  
  public kdm(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mAccount = paramQQAppInterface.getCurrentAccountUin();
    this.dt = new HashMap();
    synchronized (this.aF)
    {
      this.mDataList = null;
      this.mGdtAppReceiver = new GdtAppReceiver();
      this.mGdtAppReceiver.register(BaseApplicationImpl.getContext());
      ThreadManager.post(new EcShopAssistantManager.1(this), 5, null, true);
      this.jdField_a_of_type_Aqdf = new aqdf(paramQQAppInterface);
      this.jdField_a_of_type_Aqdf.a(this.b);
      this.jdField_a_of_type_Kdm$a = new kdm.a(this);
      return;
    }
  }
  
  public static String a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    if ((fY == null) || (!fY.contains(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!paramString2.contains("qq.com")) || (paramString2.contains("&g_tk="))) {
      return paramString2;
    }
    paramQQAppInterface = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getCurrentAccountUin());
    StringBuilder localStringBuilder = new StringBuilder(paramString2);
    if (paramString2.contains("?")) {}
    for (paramString1 = "&g_tk=";; paramString1 = "?g_tk=")
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append(String.valueOf(apuh.eU(paramQQAppInterface)));
      return localStringBuilder.toString();
    }
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(anqu paramanqu)
  {
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
    if (paramanqu == null) {
      return localAdInfo;
    }
    Object localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo();
    if (!aqmr.isEmpty(paramanqu.chi)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).advertiser_id.set(Long.parseLong(paramanqu.chi));
    }
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).corporate_image_name.set(paramanqu.Wm);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).corporate_logo.set(paramanqu.Wn);
    Object localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).video_url.set(paramanqu.chw);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).media_duration.set(paramanqu.dMd);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).video_file_size.set(paramanqu.dMe);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).tencent_video_id.set(paramanqu.chG);
    qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo localDisplayInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
    localDisplayInfo.advertiser_info.set((MessageMicro)localObject1);
    localDisplayInfo.video_info.set((MessageMicro)localObject2);
    localDisplayInfo.mini_program_type.set(paramanqu.dMb);
    localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    if (!aqmr.isEmpty(paramanqu.chj)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).aid.set(Long.parseLong(paramanqu.chj));
    }
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).traceid.set(paramanqu.chu);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).via.set(paramanqu.chv);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).product_id.set(paramanqu.chr);
    if (!aqmr.isEmpty(paramanqu.chq)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).noco_id.set(Long.parseLong(paramanqu.chq));
    }
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).view_id.set(paramanqu.Wj);
    localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).exposure_url.set(paramanqu.chh);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).click_url.set(paramanqu.chs);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).effect_url.set(paramanqu.chn);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).landing_page_report_url.set(paramanqu.chp);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).trace_info.set((MessageMicro)localObject2);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).negative_feedback_url.set(paramanqu.chB);
    localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls();
    if (!aqmr.isEmpty(paramanqu.chz)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).api_click_monitor_url.set(Arrays.asList(paramanqu.chz.split("\\|")));
    }
    if (!aqmr.isEmpty(paramanqu.bWQ)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).api_exposure_monitor_url.set(Arrays.asList(paramanqu.bWQ.split("\\|")));
    }
    if (!aqmr.isEmpty(paramanqu.chD)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).sdk_click_monitor_url.set(Arrays.asList(paramanqu.chD.split("\\|")));
    }
    if (!aqmr.isEmpty(paramanqu.chC)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).sdk_exposure_monitor_url.set(Arrays.asList(paramanqu.chC.split("\\|")));
    }
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).thirdparty_monitor_urls.set((MessageMicro)localObject2);
    localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).landing_page.set(paramanqu.cho);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).canvas_json.set(paramanqu.chl);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).dest_type.set(paramanqu.dLZ);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).universal_link.set(paramanqu.chE);
    qq_ad_get.QQAdGetRsp.AdInfo.AppInfo localAppInfo = new qq_ad_get.QQAdGetRsp.AdInfo.AppInfo();
    localAppInfo.customized_invoke_url.set(paramanqu.chx);
    localAppInfo.pkg_download_schema.set(paramanqu.chk);
    localAppInfo.app_name.set(paramanqu.mAppName);
    localAppInfo.app_package_name.set(paramanqu.mPkgName);
    localAppInfo.pkg_url.set(paramanqu.chy);
    localAppInfo.android_app_id.set(paramanqu.chr);
    localAppInfo.channel_id.set(paramanqu.cht);
    localAppInfo.app_score_num.set(paramanqu.dMf);
    localAppInfo.download_num.set(paramanqu.dMg);
    localAdInfo.product_type.set(paramanqu.dMa);
    localAdInfo.display_info.set(localDisplayInfo);
    localAdInfo.report_info.set((MessageMicro)localObject1);
    localAdInfo.dest_info.set((MessageMicro)localObject2);
    localAdInfo.app_info.set(localAppInfo);
    localAdInfo.ext_json.set(paramanqu.chF);
    return localAdInfo;
  }
  
  /* Error */
  public static qq_ad_get.QQAdGetRsp.AdInfo a(com.tencent.mobileqq.data.ChatMessage paramChatMessage)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: aload_0
    //   8: instanceof 639
    //   11: ifeq +158 -> 169
    //   14: aload_0
    //   15: checkcast 639	com/tencent/mobileqq/data/MessageForStructing
    //   18: getfield 643	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   21: astore_0
    //   22: aload_3
    //   23: astore_1
    //   24: aload_0
    //   25: instanceof 645
    //   28: ifeq +139 -> 167
    //   31: aload_0
    //   32: checkcast 645	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   35: getfield 648	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mStructMsgItemLists	Ljava/util/List;
    //   38: astore_0
    //   39: aload_3
    //   40: astore_1
    //   41: aload_0
    //   42: ifnull +125 -> 167
    //   45: aload_3
    //   46: astore_1
    //   47: aload_0
    //   48: invokeinterface 651 1 0
    //   53: ifne +114 -> 167
    //   56: aload_0
    //   57: invokeinterface 655 1 0
    //   62: astore_2
    //   63: aload 4
    //   65: astore_0
    //   66: aload_0
    //   67: astore_1
    //   68: aload_2
    //   69: invokeinterface 660 1 0
    //   74: ifeq +93 -> 167
    //   77: aload_2
    //   78: invokeinterface 664 1 0
    //   83: checkcast 295	anqu
    //   86: astore_1
    //   87: aload_1
    //   88: instanceof 666
    //   91: ifeq +61 -> 152
    //   94: aload_1
    //   95: checkcast 666	antz
    //   98: getfield 670	antz:rz	Ljava/util/ArrayList;
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +763 -> 866
    //   106: aload_1
    //   107: invokevirtual 673	java/util/ArrayList:isEmpty	()Z
    //   110: ifne +756 -> 866
    //   113: aload_1
    //   114: invokevirtual 674	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   117: astore_1
    //   118: aload_1
    //   119: invokeinterface 660 1 0
    //   124: ifeq +742 -> 866
    //   127: aload_1
    //   128: invokeinterface 664 1 0
    //   133: checkcast 295	anqu
    //   136: astore_3
    //   137: aload_3
    //   138: instanceof 676
    //   141: ifeq -23 -> 118
    //   144: aload_3
    //   145: invokestatic 678	kdm:a	(Lanqu;)Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;
    //   148: astore_0
    //   149: goto -83 -> 66
    //   152: aload_1
    //   153: instanceof 680
    //   156: ifeq +710 -> 866
    //   159: aload_1
    //   160: checkcast 680	anub
    //   163: invokestatic 678	kdm:a	(Lanqu;)Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;
    //   166: astore_1
    //   167: aload_1
    //   168: areturn
    //   169: aload_3
    //   170: astore_1
    //   171: aload_0
    //   172: instanceof 682
    //   175: ifeq -8 -> 167
    //   178: aload_0
    //   179: checkcast 682	com/tencent/mobileqq/data/MessageForArkApp
    //   182: getfield 686	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   185: astore_0
    //   186: aload_3
    //   187: astore_1
    //   188: aload_0
    //   189: ifnull -22 -> 167
    //   192: aload_0
    //   193: getfield 691	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   196: astore_0
    //   197: aload_3
    //   198: astore_1
    //   199: aload_0
    //   200: invokestatic 303	aqmr:isEmpty	(Ljava/lang/String;)Z
    //   203: ifne -36 -> 167
    //   206: new 693	org/json/JSONObject
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 694	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   214: ldc_w 696
    //   217: invokevirtual 700	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   220: astore_1
    //   221: new 289	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   224: dup
    //   225: invokespecial 290	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   228: astore_0
    //   229: aload_0
    //   230: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   233: getfield 464	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   236: getfield 399	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:aid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   239: aload_1
    //   240: ldc_w 701
    //   243: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: invokestatic 313	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   249: invokevirtual 319	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   252: aload_0
    //   253: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   256: getfield 464	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   259: getfield 402	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   262: aload_1
    //   263: ldc_w 705
    //   266: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   272: aload_0
    //   273: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   276: getfield 439	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   279: aload_1
    //   280: ldc_w 707
    //   283: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   289: aload_0
    //   290: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   293: getfield 464	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   296: getfield 430	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:view_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   299: aload_1
    //   300: ldc_w 708
    //   303: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   309: aload_0
    //   310: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   313: getfield 464	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   316: getfield 408	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:via	Lcom/tencent/mobileqq/pb/PBStringField;
    //   319: aload_1
    //   320: ldc_w 709
    //   323: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   326: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   329: aload_0
    //   330: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   333: getfield 464	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   336: getfield 424	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:noco_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   339: aload_1
    //   340: ldc_w 710
    //   343: invokevirtual 713	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   346: i2l
    //   347: invokevirtual 427	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   350: aload_0
    //   351: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   354: getfield 464	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   357: getfield 414	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:product_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   360: aload_1
    //   361: ldc_w 714
    //   364: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   367: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   370: aload_0
    //   371: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   374: getfield 451	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:effect_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   377: aload_1
    //   378: ldc_w 715
    //   381: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   387: aload_0
    //   388: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   391: getfield 457	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:landing_page_report_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   394: aload_1
    //   395: ldc_w 716
    //   398: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   401: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   404: aload_0
    //   405: getfield 622	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   408: getfield 527	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   411: aload_1
    //   412: ldc_w 717
    //   415: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   418: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   421: aload_0
    //   422: getfield 612	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   425: getfield 376	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:advertiser_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo;
    //   428: getfield 323	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_image_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   431: aload_1
    //   432: ldc_w 718
    //   435: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   438: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   441: aload_0
    //   442: getfield 612	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   445: getfield 376	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:advertiser_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo;
    //   448: getfield 333	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_logo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   451: aload_1
    //   452: ldc_w 719
    //   455: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   458: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   461: aload_0
    //   462: getfield 612	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   465: getfield 376	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:advertiser_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo;
    //   468: getfield 307	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:advertiser_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   471: aload_1
    //   472: ldc_w 720
    //   475: invokevirtual 713	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   478: i2l
    //   479: invokevirtual 319	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   482: aload_0
    //   483: getfield 612	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   486: getfield 383	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:video_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo;
    //   489: getfield 342	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:video_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   492: aload_1
    //   493: ldc_w 721
    //   496: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   499: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   502: aload_0
    //   503: getfield 612	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   506: getfield 724	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:creative_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   509: aload_1
    //   510: ldc_w 725
    //   513: invokevirtual 713	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   516: invokevirtual 357	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   519: aload_0
    //   520: getfield 612	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   523: getfield 387	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:mini_program_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   526: aload_1
    //   527: ldc_w 726
    //   530: invokevirtual 713	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   533: invokevirtual 357	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   536: aload_0
    //   537: getfield 612	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   540: getfield 383	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:video_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo;
    //   543: getfield 366	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:tencent_video_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   546: aload_1
    //   547: ldc_w 727
    //   550: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   553: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   556: aload_0
    //   557: getfield 622	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   560: getfield 533	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:canvas_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   563: aload_1
    //   564: ldc_w 728
    //   567: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   570: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   573: aload_0
    //   574: getfield 627	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo;
    //   577: getfield 554	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:customized_invoke_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   580: aload_1
    //   581: ldc_w 729
    //   584: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   587: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   590: aload_0
    //   591: getfield 627	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo;
    //   594: getfield 593	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   597: aload_1
    //   598: ldc_w 730
    //   601: invokevirtual 713	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   604: invokevirtual 357	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   607: aload_0
    //   608: getfield 627	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo;
    //   611: getfield 599	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:download_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   614: aload_1
    //   615: ldc_w 731
    //   618: invokevirtual 713	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   621: i2l
    //   622: invokevirtual 319	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   625: aload_0
    //   626: getfield 605	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:product_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   629: aload_1
    //   630: ldc_w 732
    //   633: invokevirtual 713	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   636: invokevirtual 357	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   639: aload_1
    //   640: ldc_w 733
    //   643: invokevirtual 700	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   646: astore_2
    //   647: aload_2
    //   648: ifnull +95 -> 743
    //   651: aload_0
    //   652: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   655: getfield 520	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   658: getfield 481	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_click_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   661: aload_2
    //   662: ldc_w 734
    //   665: invokevirtual 738	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   668: invokestatic 744	kec:jsonArrayToList	(Lorg/json/JSONArray;)Ljava/util/List;
    //   671: invokevirtual 498	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   674: aload_0
    //   675: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   678: getfield 520	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   681: getfield 504	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_exposure_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   684: aload_2
    //   685: ldc_w 745
    //   688: invokevirtual 738	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   691: invokestatic 744	kec:jsonArrayToList	(Lorg/json/JSONArray;)Ljava/util/List;
    //   694: invokevirtual 498	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   697: aload_0
    //   698: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   701: getfield 520	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   704: getfield 510	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:sdk_click_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   707: aload_2
    //   708: ldc_w 746
    //   711: invokevirtual 738	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   714: invokestatic 744	kec:jsonArrayToList	(Lorg/json/JSONArray;)Ljava/util/List;
    //   717: invokevirtual 498	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   720: aload_0
    //   721: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   724: getfield 520	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   727: getfield 516	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:sdk_exposure_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   730: aload_2
    //   731: ldc_w 747
    //   734: invokevirtual 738	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   737: invokestatic 744	kec:jsonArrayToList	(Lorg/json/JSONArray;)Ljava/util/List;
    //   740: invokevirtual 498	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   743: aload_0
    //   744: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   747: getfield 464	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   750: getfield 430	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:view_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   753: aload_1
    //   754: ldc_w 708
    //   757: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   760: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   763: aload_0
    //   764: getfield 617	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   767: getfield 468	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:negative_feedback_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   770: aload_1
    //   771: ldc_w 749
    //   774: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   777: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   780: aload_0
    //   781: getfield 612	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   784: getfield 383	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:video_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo;
    //   787: getfield 349	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:media_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   790: aload_1
    //   791: ldc_w 750
    //   794: invokevirtual 713	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   797: invokevirtual 357	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   800: aload_0
    //   801: getfield 612	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   804: getfield 383	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:video_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo;
    //   807: getfield 360	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:video_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   810: aload_1
    //   811: ldc_w 751
    //   814: invokevirtual 713	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   817: invokevirtual 357	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   820: aload_0
    //   821: getfield 622	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   824: getfield 545	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:universal_link	Lcom/tencent/mobileqq/pb/PBStringField;
    //   827: aload_1
    //   828: ldc_w 752
    //   831: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   834: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   837: aload_0
    //   838: getfield 631	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   841: aload_1
    //   842: ldc_w 753
    //   845: invokevirtual 704	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   848: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   851: aload_0
    //   852: areturn
    //   853: astore_1
    //   854: aload_2
    //   855: astore_0
    //   856: aload_1
    //   857: invokevirtual 756	java/lang/Exception:printStackTrace	()V
    //   860: aload_0
    //   861: areturn
    //   862: astore_1
    //   863: goto -7 -> 856
    //   866: goto -717 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	869	0	paramChatMessage	com.tencent.mobileqq.data.ChatMessage
    //   23	819	1	localObject1	Object
    //   853	4	1	localException1	Exception
    //   862	1	1	localException2	Exception
    //   3	852	2	localObject2	Object
    //   1	197	3	localanqu	anqu
    //   5	59	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   178	186	853	java/lang/Exception
    //   192	197	853	java/lang/Exception
    //   199	229	853	java/lang/Exception
    //   229	647	862	java/lang/Exception
    //   651	743	862	java/lang/Exception
    //   743	851	862	java/lang/Exception
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = this.object;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.H.contains(paramString))) {
        this.H.add(paramString);
      }
      aBK();
      return;
    }
    finally {}
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.object)
    {
      if ((paramQQAppInterface.a().A(paramString, 1008) > 0) && (!this.H.contains(paramString))) {
        this.H.add(paramString);
      }
      aBK();
      return;
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    boolean bool = false;
    EcShopData localEcShopData;
    synchronized (this.dt)
    {
      localEcShopData = (EcShopData)this.dt.remove(paramString);
    }
    synchronized (this.aF)
    {
      if (this.mDataList != null) {
        this.mDataList.remove(localEcShopData);
      }
      if (localEcShopData != null) {
        bool = paramEntityManager.remove(localEcShopData);
      }
      QLog.d("EcShopAssistantManager", 2, "removeEcShopData puin: " + paramString);
      if (this.aer)
      {
        paramEntityManager = new Intent("action_on_shop_msg_receive");
        paramEntityManager.putParcelableArrayListExtra("datas", (ArrayList)an());
        BaseApplicationImpl.getContext().sendBroadcast(paramEntityManager);
      }
      return bool;
      paramEntityManager = finally;
      throw paramEntityManager;
    }
  }
  
  private void aBK()
  {
    ThreadManager.executeOnSubThread(new EcShopAssistantManager.2(this));
  }
  
  private void aBN()
  {
    synchronized (this.aF)
    {
      if (this.mDataList == null)
      {
        i = 1;
        if (i != 0) {
          doInit();
        }
        return;
      }
      int i = 0;
    }
  }
  
  private boolean aH(long paramLong)
  {
    if (this.mApp == null) {
      return false;
    }
    Object localObject2 = (acff)this.mApp.getManager(51);
    Object localObject1 = this.mApp.a().a();
    if ((localObject2 == null) || (localObject1 == null)) {
      return false;
    }
    if ((this.aek) && (!this.ael))
    {
      localObject2 = ((acxw)localObject1).a(acbn.blb, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      EcShopData localEcShopData = a();
      if (localEcShopData != null)
      {
        ((RecentUser)localObject2).lastmsgtime = localEcShopData.mLastMsgTime;
        ((RecentUser)localObject2).lastmsgdrafttime = localEcShopData.mLastDraftTime;
        ((acxw)localObject1).e((RecentUser)localObject2);
        QLog.d("EcShopAssistantManager", 2, "update ecshop folder...");
      }
    }
    for (;;)
    {
      localObject1 = this.mApp.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendEmptyMessage(1009);
      }
      return true;
      if (!this.aeq) {
        break;
      }
      ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
      break;
      localObject2 = ((acxw)localObject1).b(acbn.blb, 7120);
      if (localObject2 != null) {
        ((acxw)localObject1).f((RecentUser)localObject2);
      }
      QLog.d("EcShopAssistantManager", 2, "del ecshop folder...");
    }
  }
  
  public static Drawable b(Context paramContext)
  {
    if (!TextUtils.isEmpty(Yo))
    {
      Object localObject1 = paramContext.getResources().getDrawable(2130839767);
      Object localObject2 = Yo.split("/");
      localObject2 = Ym + localObject2[(localObject2.length - 1)];
      String str = Yo;
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_icon", str, (String)localObject2), (Drawable)localObject1, (Drawable)localObject1);
        return localObject1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        return paramContext.getResources().getDrawable(2130847910);
      }
    }
    return paramContext.getResources().getDrawable(2130847910);
  }
  
  public static int cS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 1: 
      return 1;
    case 3000: 
      return 2;
    }
    return 3;
  }
  
  /* Error */
  private void doInit()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: getfield 194	kdm:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: invokevirtual 949	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   12: invokevirtual 955	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: astore_3
    //   16: aload_3
    //   17: ldc_w 794
    //   20: iconst_0
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: ldc_w 957
    //   28: aconst_null
    //   29: invokevirtual 961	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   32: astore_2
    //   33: new 76	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 963
    //   43: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: astore 4
    //   48: aload_2
    //   49: ifnonnull +178 -> 227
    //   52: iconst_0
    //   53: istore_1
    //   54: ldc_w 803
    //   57: iconst_2
    //   58: aload 4
    //   60: iload_1
    //   61: invokevirtual 966	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 811	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: getfield 161	kdm:aF	Ljava/lang/Object;
    //   74: astore 4
    //   76: aload 4
    //   78: monitorenter
    //   79: aload_0
    //   80: aload_2
    //   81: putfield 205	kdm:mDataList	Ljava/util/List;
    //   84: aload_0
    //   85: getfield 205	kdm:mDataList	Ljava/util/List;
    //   88: ifnonnull +16 -> 104
    //   91: aload_0
    //   92: new 672	java/util/ArrayList
    //   95: dup
    //   96: bipush 16
    //   98: invokespecial 968	java/util/ArrayList:<init>	(I)V
    //   101: putfield 205	kdm:mDataList	Ljava/util/List;
    //   104: aload 4
    //   106: monitorexit
    //   107: aload_0
    //   108: getfield 203	kdm:dt	Ljava/util/Map;
    //   111: astore_2
    //   112: aload_2
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield 203	kdm:dt	Ljava/util/Map;
    //   118: invokeinterface 971 1 0
    //   123: aload_0
    //   124: getfield 205	kdm:mDataList	Ljava/util/List;
    //   127: invokeinterface 655 1 0
    //   132: astore 4
    //   134: aload 4
    //   136: invokeinterface 660 1 0
    //   141: ifeq +120 -> 261
    //   144: aload 4
    //   146: invokeinterface 664 1 0
    //   151: checkcast 794	com/tencent/biz/pubaccount/ecshopassit/EcShopData
    //   154: astore 5
    //   156: aload_0
    //   157: getfield 203	kdm:dt	Ljava/util/Map;
    //   160: aload 5
    //   162: getfield 974	com/tencent/biz/pubaccount/ecshopassit/EcShopData:mUin	Ljava/lang/String;
    //   165: aload 5
    //   167: invokeinterface 978 3 0
    //   172: pop
    //   173: goto -39 -> 134
    //   176: astore 4
    //   178: aload_2
    //   179: monitorexit
    //   180: aload 4
    //   182: athrow
    //   183: astore 4
    //   185: aload_3
    //   186: astore_2
    //   187: ldc_w 803
    //   190: iconst_2
    //   191: new 76	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 980
    //   201: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 4
    //   206: invokevirtual 983	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 985	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 988	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   226: return
    //   227: aload_2
    //   228: invokeinterface 992 1 0
    //   233: istore_1
    //   234: goto -180 -> 54
    //   237: astore_2
    //   238: aload 4
    //   240: monitorexit
    //   241: aload_2
    //   242: athrow
    //   243: astore_2
    //   244: aload_3
    //   245: astore 4
    //   247: aload_2
    //   248: astore_3
    //   249: aload 4
    //   251: ifnull +8 -> 259
    //   254: aload 4
    //   256: invokevirtual 988	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   259: aload_3
    //   260: athrow
    //   261: aload_2
    //   262: monitorexit
    //   263: aload_3
    //   264: ifnull -38 -> 226
    //   267: aload_3
    //   268: invokevirtual 988	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   271: return
    //   272: astore_3
    //   273: aload_2
    //   274: astore 4
    //   276: goto -27 -> 249
    //   279: astore 4
    //   281: aload 5
    //   283: astore_3
    //   284: goto -99 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	kdm
    //   53	181	1	i	int
    //   237	5	2	localObject2	Object
    //   243	31	2	localObject3	Object
    //   15	253	3	localObject4	Object
    //   272	1	3	localObject5	Object
    //   283	1	3	localEcShopData1	EcShopData
    //   176	5	4	localObject7	Object
    //   183	56	4	localException1	Exception
    //   245	30	4	localObject8	Object
    //   279	1	4	localException2	Exception
    //   3	279	5	localEcShopData2	EcShopData
    // Exception table:
    //   from	to	target	type
    //   114	134	176	finally
    //   134	173	176	finally
    //   178	180	176	finally
    //   261	263	176	finally
    //   16	48	183	java/lang/Exception
    //   54	79	183	java/lang/Exception
    //   107	114	183	java/lang/Exception
    //   180	183	183	java/lang/Exception
    //   227	234	183	java/lang/Exception
    //   241	243	183	java/lang/Exception
    //   79	104	237	finally
    //   104	107	237	finally
    //   238	241	237	finally
    //   16	48	243	finally
    //   54	79	243	finally
    //   107	114	243	finally
    //   180	183	243	finally
    //   227	234	243	finally
    //   241	243	243	finally
    //   5	16	272	finally
    //   187	218	272	finally
    //   5	16	279	java/lang/Exception
  }
  
  private void g(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.f(paramString);
    }
  }
  
  public static SharedPreferences h()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("ecshop_sp" + str1, 0);
  }
  
  private void lL(boolean paramBoolean)
  {
    if (this.mApp == null) {
      return;
    }
    this.mApp.getApp().getSharedPreferences(this.mApp.getAccount(), 0).edit().putBoolean("is_update_ec_shop_assist", paramBoolean).commit();
  }
  
  private void lT(String paramString)
  {
    synchronized (this.object)
    {
      if ((this.mApp.a().A(paramString, 1008) > 0) && (this.H.contains(paramString))) {
        this.H.remove(paramString);
      }
      aBK();
      return;
    }
  }
  
  public static int nf()
  {
    int j = 0;
    String str = aqgz.getIMSI();
    int i = j;
    if (!TextUtils.isEmpty(str))
    {
      i = j;
      if (str.length() > 5)
      {
        i = j;
        if (str.startsWith("460"))
        {
          str = str.substring(3, 5);
          if ((!str.equals("00")) && (!str.equals("02")) && (!str.equals("04")) && (!str.equals("07"))) {
            break label88;
          }
          i = 1;
        }
      }
    }
    label88:
    do
    {
      return i;
      if ((str.equals("01")) || (str.equals("06")) || (str.equals("09"))) {
        return 2;
      }
      if ((str.equals("03")) || (str.equals("05"))) {
        return 3;
      }
      i = j;
    } while (!str.equals("20"));
    return 4;
  }
  
  private boolean yX()
  {
    return this.mApp.getApp().getSharedPreferences(this.mApp.getAccount(), 0).getBoolean("is_update_ec_shop_assist", true);
  }
  
  public void G(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.mAccount = paramQQAppInterface.getAccount();
      Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences(this.mAccount, 0);
      this.aek = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_show_in_msg", true);
      this.ael = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_deleted", false);
      this.mLastReadTime = ((SharedPreferences)localObject2).getLong("last_read_time", 0L);
      Object localObject3 = am();
      synchronized (this.object)
      {
        this.H = aqmk.a((SharedPreferences)localObject2, "ec_shop_assist_new_unread_list", null);
        if (this.H == null)
        {
          this.H = new HashSet();
          if (yX())
          {
            lL(false);
            localObject2 = paramQQAppInterface.b();
            if (localObject2 == null) {
              return;
            }
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              EcShopData localEcShopData = (EcShopData)((Iterator)localObject3).next();
              QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).a(localEcShopData.mUin, 1008);
              if ((paramQQAppInterface.a().A(localEcShopData.mUin, 1008) > 0) && (localMessage.time > this.mLastReadTime)) {
                a(localMessage.frienduin, paramQQAppInterface);
              }
            }
          }
        }
      }
    }
  }
  
  public void H(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.object)
    {
      if ((this.H != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = this.H.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (paramQQAppInterface.a().A(str, 1008) > 0) {
            paramQQAppInterface.a().h(str, 1008, false);
          }
        }
      }
    }
  }
  
  public void T(long paramLong, boolean paramBoolean)
  {
    if (this.mApp == null) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (acff)this.mApp.getManager(51);
        localObject1 = this.mApp.a().a();
      } while (localObject2 == null);
      this.aeq = paramBoolean;
      Object localObject2 = ((acxw)localObject1).a(acbn.blb, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
      ((acxw)localObject1).e((RecentUser)localObject2);
      localObject1 = this.mApp.getHandler(Conversation.class);
    } while (localObject1 == null);
    ((MqqHandler)localObject1).sendEmptyMessage(1009);
  }
  
  public EcShopData a()
  {
    Object localObject3 = null;
    aBN();
    Object localObject4 = this.aF;
    Object localObject1 = localObject3;
    try
    {
      if (this.mDataList != null)
      {
        localObject1 = localObject3;
        if (this.mDataList.size() > 0) {
          localObject1 = (EcShopData)this.mDataList.get(0);
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public EcShopData a(String paramString)
  {
    aBN();
    synchronized (this.dt)
    {
      EcShopData localEcShopData = (EcShopData)this.dt.get(paramString);
      ??? = localEcShopData;
      if (localEcShopData == null)
      {
        localEcShopData = new EcShopData();
        localEcShopData.mUin = paramString;
        QQMessageFacade localQQMessageFacade = this.mApp.b();
        ??? = localEcShopData;
        if (localQQMessageFacade != null)
        {
          paramString = localQQMessageFacade.a(paramString, 1008);
          ??? = localEcShopData;
          if (paramString != null)
          {
            localEcShopData.mLastDraftTime = paramString.getTime();
            ??? = localEcShopData;
          }
        }
      }
      return ???;
    }
  }
  
  public void a(Intent paramIntent, Context paramContext, int paramInt)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      return;
    }
    Bundle localBundle;
    if (paramIntent.getExtras() == null)
    {
      localBundle = new Bundle();
      localBundle.putParcelableArrayList("datas", (ArrayList)an());
      if (!TextUtils.isEmpty(this.Yu)) {
        localBundle.putString("ad_logo", this.Yu);
      }
      if (!TextUtils.isEmpty(this.Yv)) {
        localBundle.putString("ad_jump", this.Yv);
      }
      if (this.rN != 0L) {
        localBundle.putLong("ad_id", this.rN);
      }
      this.aer = true;
      localBundle.putBoolean("is_tab_show", this.aen);
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
      } while (!"com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName));
    }
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_tool_exist", bool);
      localBundle.putLong("click_time", System.currentTimeMillis());
      localBundle.putStringArray("urls", this.be);
      SharedPreferences localSharedPreferences = h();
      if (localSharedPreferences.getBoolean("folder_tab_red", false)) {}
      for (bool = true;; bool = false)
      {
        paramContext = this.mApp.a().a();
        if (paramInt >= 0)
        {
          if (paramInt <= 0) {
            break label705;
          }
          bool = true;
        }
        label390:
        label685:
        label697:
        label705:
        for (;;)
        {
          label251:
          localBundle.putBoolean("hasUnread", bool);
          localBundle.putLong("last_read_folder", localSharedPreferences.getLong("last_read_folder", 0L));
          localBundle.putLong("latest_time", localSharedPreferences.getLong("latest_time", 0L));
          localBundle.putInt("unReadNum", this.mApp.b().bl());
          localBundle.putBoolean("isDefaultTheme", ThemeUtil.isDefaultOrDIYTheme(false));
          Object localObject = ((acff)this.mApp.getManager(51)).b(this.mApp.getCurrentAccountUin());
          String str = this.be[1];
          if (bool)
          {
            paramContext = "1";
            label370:
            str = aurr.addParameter(str, "has_reddot", paramContext);
            if (localObject != null) {
              break label685;
            }
            paramContext = "0";
            localObject = aurr.addParameter(str, "gender", paramContext);
            localBundle.putInt("PUSH_TASK_ID", localSharedPreferences.getInt("PUSH_TASK_ID", 0));
            localBundle.putString("str_ecshop_diy", localSharedPreferences.getString("str_ecshop_diy", ""));
            localBundle.putInt("PUSH_TASK_TYPE", localSharedPreferences.getInt("PUSH_TASK_TYPE", 0));
            localBundle.putString("PUSH_TASK_INFO", localSharedPreferences.getString("PUSH_TASK_INFO", ""));
            localBundle.putLong("PUSH_RECEIVE_TIME", localSharedPreferences.getLong("PUSH_RECEIVE_TIME", 0L));
            paramContext = (Context)localObject;
            if (!TextUtils.isEmpty(localSharedPreferences.getString("PUSH_JUMP_URL", ""))) {
              paramContext = aurr.addParameter((String)localObject, "jumpUrl", localSharedPreferences.getString("PUSH_JUMP_URL", ""));
            }
            if (!this.aep) {
              break label697;
            }
          }
          for (localObject = String.valueOf(localSharedPreferences.getInt("FOLDER_MSG_TYPE", -1));; localObject = "0")
          {
            paramContext = aurr.addParameter(aurr.addParameter(paramContext, "type", (String)localObject), "taskType", String.valueOf(localSharedPreferences.getInt("PUSH_TASK_TYPE", 0)));
            paramIntent.putExtra("bundle", localBundle);
            paramIntent.putExtra("url", paramContext);
            return;
            localBundle = paramIntent.getExtras();
            break;
            if (paramContext == null) {
              break label705;
            }
            paramContext = paramContext.b(acbn.blb, 7120);
            if (paramContext == null) {
              break label705;
            }
            paramContext = aajt.makeKey(paramContext.uin, paramContext.getType());
            paramContext = aajt.a().a(paramContext);
            if ((paramContext == null) || (paramContext.mUnreadNum <= 0)) {
              break label705;
            }
            bool = true;
            break label251;
            paramContext = "0";
            break label370;
            paramContext = String.valueOf(((Friends)localObject).gender);
            break label390;
          }
        }
      }
    }
  }
  
  public void a(anqu paramanqu, Activity paramActivity)
  {
    if (paramanqu == null) {
      return;
    }
    try
    {
      paramanqu = new GdtAd(a(paramanqu));
      GdtHandler.Params localParams = new GdtHandler.Params();
      localParams.processId = 1;
      localParams.activity = new WeakReference(paramActivity);
      localParams.ad = paramanqu;
      localParams.reportForClick = false;
      localParams.aOV = false;
      localParams.appReceiver = new WeakReference(this.mGdtAppReceiver);
      localParams.p = ShopCanvasFragment.class;
      localParams.n = ShopVideoCeilingFragment.class;
      localParams.videoCeilingSupportedIfNotInstalled = true;
      paramActivity = localParams.extra;
      paramanqu = paramActivity;
      if (paramActivity == null) {
        paramanqu = new Bundle();
      }
      paramanqu.putString("big_brother_ref_source_key", "biz_src_gzh_qqgw");
      localParams.extra = paramanqu;
      GdtHandler.a(localParams);
      return;
    }
    catch (Throwable paramanqu)
    {
      QLog.e("EcShopAssistantManager", 1, "enterGDTVideoActivity throw an exception: " + paramanqu);
    }
  }
  
  public void a(EcShopData paramEcShopData)
  {
    if ((paramEcShopData == null) || (TextUtils.isEmpty(paramEcShopData.mUin))) {
      return;
    }
    synchronized (this.dt)
    {
      this.dt.put(paramEcShopData.mUin, paramEcShopData);
    }
    for (;;)
    {
      synchronized (this.aF)
      {
        if (this.mDataList != null)
        {
          this.mDataList.remove(paramEcShopData);
          i = 0;
          if (i >= this.mDataList.size()) {
            break label285;
          }
          EcShopData localEcShopData = (EcShopData)this.mDataList.get(i);
          if (Math.max(paramEcShopData.mLastMsgTime, paramEcShopData.mLastDraftTime) <= Math.max(localEcShopData.mLastMsgTime, localEcShopData.mLastDraftTime)) {
            continue;
          }
          this.mDataList.add(i, paramEcShopData);
          i = 1;
          if (i == 0) {
            this.mDataList.add(this.mDataList.size(), paramEcShopData);
          }
        }
        ??? = (ProxyManager)this.mApp.getManager(18);
        if (paramEcShopData.getStatus() == 1000)
        {
          ((ProxyManager)???).addMsgQueue(this.mApp.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 3, null);
          QLog.d("EcShopAssistantManager", 2, "saveEcShopData(db&cache) puin: " + paramEcShopData.mUin + ", status: " + paramEcShopData.getStatus());
          return;
          paramEcShopData = finally;
          throw paramEcShopData;
          i += 1;
        }
      }
      ((ProxyManager)???).addMsgQueue(this.mApp.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 4, null);
      continue;
      label285:
      int i = 0;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null) {
      return;
    }
    QLog.d("EcShopAssistantManager", 2, "addMsgToAssist puin: " + paramMessageRecord.senderuin);
    SharedPreferences localSharedPreferences = h();
    String str = paramMessageRecord.frienduin;
    long l1 = paramMessageRecord.time;
    if ((!TextUtils.isEmpty(str)) && (str.equals(Yr)))
    {
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
      }
      Yr = null;
    }
    EcShopData localEcShopData = a(str);
    localEcShopData.mImgInfo = "";
    if ((paramMessageRecord != null) && (paramMessageRecord.time > l1)) {}
    for (localEcShopData.mLastMsgTime = paramMessageRecord.time;; localEcShopData.mLastMsgTime = l1)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.b().a(localEcShopData.mUin, 1008);
      if (localMessage != null)
      {
        long l2 = localMessage.time;
        if (l2 > localEcShopData.mLastMsgTime) {
          localEcShopData.mLastMsgTime = l2;
        }
        if ((l2 > h().getLong("latest_time", 0L)) && (localSharedPreferences != null)) {
          localSharedPreferences.edit().putLong("latest_time", l2).commit();
        }
      }
      a(localEcShopData);
      a(paramMessageRecord, str);
      if (this.ael) {
        lK(false);
      }
      g(paramQQAppInterface, str);
      aH(l1);
      lS(str);
      if (TextUtils.isEmpty(localSharedPreferences.getString("PUSH_JUMP_URL", ""))) {
        break;
      }
      localSharedPreferences.edit().putString("PUSH_JUMP_URL", "").commit();
      return;
    }
  }
  
  public boolean a(anqu paramanqu, Activity paramActivity)
  {
    if (paramanqu == null) {
      return false;
    }
    if (((paramanqu.e instanceof AbsShareMsg)) && (((AbsShareMsg)paramanqu.e).mStructMsgItemLists != null))
    {
      paramanqu = (anqu)((AbsShareMsg)paramanqu.e).mStructMsgItemLists.get(0);
      try
      {
        if (((paramanqu instanceof anqv)) && (paramanqu.dLY == 1))
        {
          paramanqu = new GdtAd(a(paramanqu));
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.processId = 1;
          localParams.activity = new WeakReference(paramActivity);
          localParams.ad = paramanqu;
          localParams.reportForClick = false;
          localParams.aOV = true;
          localParams.appReceiver = new WeakReference(this.mGdtAppReceiver);
          localParams.p = ShopCanvasFragment.class;
          paramActivity = localParams.extra;
          paramanqu = paramActivity;
          if (paramActivity == null) {
            paramanqu = new Bundle();
          }
          paramanqu.putString("big_brother_ref_source_key", "biz_src_gzh_qqgw");
          localParams.extra = paramanqu;
          GdtHandler.a(localParams);
          return true;
        }
        return false;
      }
      catch (Exception paramanqu)
      {
        return false;
      }
    }
    return false;
  }
  
  public void aBL()
  {
    if (this.mApp == null) {}
    EcShopData localEcShopData;
    do
    {
      return;
      localEcShopData = a();
    } while (localEcShopData == null);
    aH(localEcShopData.mLastMsgTime);
  }
  
  public void aBM()
  {
    Object localObject = new File(Yl);
    if (((File)localObject).exists())
    {
      localObject = aqhq.readFileContent((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("shopFolderName")) {
          Yn = ((JSONObject)localObject).getString("shopFolderName");
        }
        if (((JSONObject)localObject).has("shopFolderIcon")) {
          Yo = ((JSONObject)localObject).getString("shopFolderIcon");
        }
        if (!((JSONObject)localObject).has("shopButton")) {
          break label208;
        }
        localObject = ((JSONObject)localObject).getJSONArray("shopButton");
        if (!QLog.isColorLevel()) {
          break label239;
        }
        QLog.i("EcShopAssistantManager", 2, "shopButton info found:" + ((JSONArray)localObject).toString());
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        String str;
        int j;
        if (!QLog.isColorLevel()) {
          break label208;
        }
        QLog.d("EcShopAssistantManager", 2, "parse banner config fail", localException);
      }
      if (i < ((JSONArray)localObject).length())
      {
        localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
        str = localJSONObject.getString("url");
        j = localJSONObject.getInt("id");
        this.be[(j - 1)] = str;
        i += 1;
      }
      else
      {
        label208:
        return;
        QLog.d("EcShopAssistantManager", 2, "banner json config file is not existed path=" + Yl);
        return;
        label239:
        i = 0;
      }
    }
  }
  
  public void aBO()
  {
    for (;;)
    {
      try
      {
        aBN();
        acxw localacxw = this.mApp.a().a();
        Object localObject = localacxw.q(false);
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if ((1008 == localRecentUser.getType()) && (nyn.i(this.mApp, localRecentUser.uin)))
        {
          EcShopData localEcShopData = a(localRecentUser.uin);
          localEcShopData.mLastDraftTime = localRecentUser.lastmsgdrafttime;
          localEcShopData.mLastMsgTime = localRecentUser.lastmsgtime;
          if (localEcShopData.mLastMsgTime == 0L)
          {
            QQMessageFacade.Message localMessage = this.mApp.b().a(localEcShopData.mUin, 1008);
            if (localMessage != null)
            {
              l = localMessage.time;
              localEcShopData.mLastMsgTime = l;
            }
          }
          else
          {
            a(localEcShopData);
            localacxw.f(localRecentUser);
            a(localEcShopData.mUin, this.mApp);
            continue;
          }
          long l = localEcShopData.mLastMsgTime;
        }
      }
      catch (Exception localException)
      {
        QLog.d("EcShopAssistantManager", 1, "initEcShopAssist fail msg:" + localException.getMessage());
        return;
      }
    }
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.mApp.getBusinessHandler(11);
    if (localPublicAccountHandler != null) {
      localPublicAccountHandler.cLi();
    }
    this.mApp.getApp().getSharedPreferences(this.mApp.getAccount(), 0).edit().putBoolean("init_ec_shop_assist", false).commit();
  }
  
  public void aBP()
  {
    if (yY()) {
      aBO();
    }
    aBL();
  }
  
  void aBQ()
  {
    Object localObject1 = am();
    int i;
    Object localObject2;
    SharedPreferences localSharedPreferences;
    boolean bool;
    long l1;
    int k;
    int m;
    long l2;
    int j;
    if (localObject1 == null)
    {
      i = 0;
      localObject2 = (acja)this.mApp.getManager(56);
      localSharedPreferences = h();
      bool = localSharedPreferences.getBoolean("is_ad_added", false);
      l1 = localSharedPreferences.getLong("ad_puin", 0L);
      this.rN = localSharedPreferences.getLong("ad_id", 0L);
      Yr = String.valueOf(l1);
      this.Yu = localSharedPreferences.getString("ad_icon_url", null);
      this.Yv = localSharedPreferences.getString("ad_url", null);
      k = localSharedPreferences.getInt("ad_start", 0);
      m = localSharedPreferences.getInt("ad_end", 0);
      l2 = System.currentTimeMillis() / 1000L;
      if ((!bool) && (localSharedPreferences.contains("ad_id")) && (i > 0))
      {
        if ((l2 <= k) || (l2 >= m) || (((acja)localObject2).f(Long.valueOf(l1)))) {
          break label571;
        }
        localObject2 = new EcShopData();
        ((EcShopData)localObject2).mUin = String.valueOf(l1);
        ((EcShopData)localObject2).mImgInfo = localSharedPreferences.getString("ad_pics", null);
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((j >= i) || (j >= 2))
        {
          a((EcShopData)localObject2);
          i = 1;
          localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
          if ((i != 0) || (!localSharedPreferences.getBoolean("is_ad_added", false))) {
            break label501;
          }
          localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
          label314:
          if (i != 0) {
            break label543;
          }
          Yr = "";
          return;
          i = ((List)localObject1).size();
          break;
        }
        ((EcShopData)localObject2).mLastMsgTime = (((EcShopData)((List)localObject1).get(j)).mLastMsgTime - 1L);
        j += 1;
      }
    }
    if (bool)
    {
      j = 0;
      label370:
      if (j >= i) {
        break label576;
      }
      if (!String.valueOf(l1).equals(((EcShopData)((List)localObject1).get(j)).mUin)) {}
    }
    label543:
    label571:
    label576:
    for (localObject1 = (EcShopData)((List)localObject1).get(j);; localObject1 = null)
    {
      if (((l2 < k) || (l2 > m) || (((acja)localObject2).f(Long.valueOf(l1)))) && (localObject1 != null))
      {
        lU(((EcShopData)localObject1).mUin);
        i = 0;
        break;
        j += 1;
        break label370;
      }
      if (localObject1 != null)
      {
        i = 1;
        localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
        break;
        label501:
        if ((i == 0) || (!QLog.isColorLevel())) {
          break label314;
        }
        QLog.i("EcShopAssistantManager", 2, "show ad ,puin=" + Yr);
        break label314;
        ((kec)this.mApp.getBusinessHandler(88)).a(134246436, null, null, null, null, this.rN, false);
        return;
      }
      i = 0;
      break;
    }
  }
  
  public List<EcShopData> am()
  {
    int j = 0;
    aBN();
    for (;;)
    {
      synchronized (this.aF)
      {
        if (this.mDataList != null)
        {
          i = this.mDataList.size();
          ArrayList localArrayList = new ArrayList(i);
          localArrayList.addAll(this.mDataList);
          ??? = new StringBuilder().append("getAllEcShopAssitData size: ");
          if (localArrayList == null)
          {
            i = j;
            QLog.d("EcShopAssistantManager", 2, i);
            return localArrayList;
          }
        }
        else
        {
          i = 0;
        }
      }
      int i = localObject2.size();
    }
  }
  
  public List<RecentShopParcel> an()
  {
    if (!this.aer) {
      aBQ();
    }
    acja localacja = (acja)this.mApp.getManager(56);
    SharedPreferences localSharedPreferences = h();
    ArrayList localArrayList = new ArrayList();
    EcShopData localEcShopData;
    for (;;)
    {
      synchronized (this.aF)
      {
        Iterator localIterator = this.mDataList.iterator();
        if (!localIterator.hasNext()) {
          break label404;
        }
        localEcShopData = (EcShopData)localIterator.next();
        if ((TextUtils.isEmpty(localEcShopData.mUin)) || (!localEcShopData.mUin.equals(Yr))) {
          break;
        }
        localObject3 = new RecentShopParcel();
        ((RecentShopParcel)localObject3).puin = localEcShopData.mUin;
        ((RecentShopParcel)localObject3).nickName = localSharedPreferences.getString("ad_nick", "");
        ((RecentShopParcel)localObject3).msg = localSharedPreferences.getString("ad_title", "");
        ((RecentShopParcel)localObject3).YF = localEcShopData.mImgInfo;
        if (localSharedPreferences.getBoolean("ad_cert", false))
        {
          ((RecentShopParcel)localObject3).mAuthenIconId = 0;
          ((RecentShopParcel)localObject3).unReadNum = 0;
          ((RecentShopParcel)localObject3).aIi = 1;
          localArrayList.add(localObject3);
        }
      }
      ((RecentShopParcel)localObject3).mAuthenIconId = 0;
    }
    Object localObject3 = new RecentItemEcShop(localEcShopData);
    ((RecentItemEcShop)localObject3).c(this.mApp, BaseApplication.getContext());
    RecentShopParcel localRecentShopParcel = new RecentShopParcel();
    localRecentShopParcel.puin = localEcShopData.mUin;
    localRecentShopParcel.nickName = getNickName(this.mApp, localEcShopData.mUin);
    localRecentShopParcel.time = ((RecentItemEcShop)localObject3).mShowTime;
    localRecentShopParcel.msg = String.valueOf(((RecentItemEcShop)localObject3).mLastMsg);
    localRecentShopParcel.YF = localEcShopData.mImgInfo;
    PublicAccountInfo localPublicAccountInfo = localObject2.c(localEcShopData.mUin);
    if ((localPublicAccountInfo != null) && (localPublicAccountInfo.certifiedGrade > 0L)) {}
    for (localRecentShopParcel.mAuthenIconId = 0;; localRecentShopParcel.mAuthenIconId = 0)
    {
      localRecentShopParcel.unReadNum = ((RecentItemEcShop)localObject3).mUnreadNum;
      localRecentShopParcel.aIi = 0;
      localRecentShopParcel.lastMsgTime = ((RecentItemEcShop)localObject3).eI();
      localRecentShopParcel.rR = localEcShopData.mLastDraftTime;
      localArrayList.add(localRecentShopParcel);
      break;
    }
    label404:
    return localArrayList;
  }
  
  public int b(QQAppInterface paramQQAppInterface)
  {
    int i;
    int j;
    synchronized (this.object)
    {
      if ((this.H != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = this.H.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          j = paramQQAppInterface.a().A(str, 1008);
          if (j <= 0) {
            break label98;
          }
        }
        else
        {
          return i;
        }
      }
      else
      {
        return 0;
      }
    }
    for (;;)
    {
      i += j;
      break;
      label98:
      j = 0;
    }
  }
  
  public void bs(String paramString1, String paramString2)
  {
    QLog.d("EcShopAssistantManager", 2, "refreshSettings.... paUin: " + paramString1 + ", src: " + paramString2);
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramString2 = this.mApp.a().a();
    paramString1 = this.mApp.a().createEntityManager();
    ??? = paramString2.q(false);
    Object localObject4;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).getType() == 1008) && (nyn.i(this.mApp, ((RecentUser)localObject4).uin)) && (!((RecentUser)localObject4).shouldShowInRecentList(this.mApp)))
        {
          ((ArrayList)localObject2).add(localObject4);
          QLog.d("EcShopAssistantManager", 2, "add to ecshop folder puin: " + ((RecentUser)localObject4).uin + ", size: " + ((ArrayList)localObject2).size());
        }
      }
    }
    aBN();
    Object localObject5;
    synchronized (this.aF)
    {
      if ((this.mDataList != null) && (this.mDataList.size() > 0))
      {
        localObject4 = this.mDataList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (EcShopData)((Iterator)localObject4).next();
          if ((!nyn.i(this.mApp, ((EcShopData)localObject5).mUin)) && (!((EcShopData)localObject5).mUin.equalsIgnoreCase(Yr)))
          {
            ((ArrayList)localObject1).add(localObject5);
            QLog.d("EcShopAssistantManager", 2, "remove form ecshop folder puin: " + ((EcShopData)localObject5).mUin);
          }
        }
      }
    }
    QLog.d("EcShopAssistantManager", 2, "toRecentUser size: " + ((ArrayList)localObject1).size());
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject2).next();
        localObject4 = a(((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject5 = this.mApp.b().a(((EcShopData)localObject4).mUin, 1008);
          if (localObject5 == null) {}
        }
        for (((EcShopData)localObject4).mLastMsgTime = ((QQMessageFacade.Message)localObject5).time;; ((EcShopData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a((EcShopData)localObject4);
          paramString2.f((RecentUser)???);
          a(((RecentUser)???).uin, this.mApp);
          break;
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EcShopData)((Iterator)localObject1).next();
        ??? = paramString2.a(((EcShopData)localObject2).mUin, 1008);
        ((RecentUser)???).uin = ((EcShopData)localObject2).mUin;
        ((RecentUser)???).setType(1008);
        ((RecentUser)???).lastmsgtime = ((EcShopData)localObject2).mLastMsgTime;
        ((RecentUser)???).lastmsgdrafttime = ((EcShopData)localObject2).mLastDraftTime;
        if (a(paramString1, ((EcShopData)localObject2).mUin))
        {
          localObject4 = (acja)this.mApp.getManager(56);
          if ((localObject4 != null) && (((acja)localObject4).c(((EcShopData)localObject2).mUin) != null))
          {
            paramString2.e((RecentUser)???);
            QLog.d("EcShopAssistantManager", 2, "add to msgtab puin: " + ((EcShopData)localObject2).mUin);
          }
        }
      }
    }
    paramString2 = a();
    if (paramString2 != null) {
      aH(paramString2.mLastMsgTime);
    }
    if (paramString1 != null) {
      paramString1.close();
    }
    lS(null);
  }
  
  public void checkUpdate()
  {
    aqvc localaqvc = ((aqva)this.mApp.getManager(47)).a(1);
    if (localaqvc != null)
    {
      Object localObject2 = afgc.insertMtype("VIP_shop_assit_cfg", "https://imgcache.qq.com/zzapp/qqshop/banner/qqshop_shopinghelper_conf.json");
      if (localaqvc.a((String)localObject2) == null)
      {
        Object localObject1 = new File(Yl);
        localObject2 = new aquz((String)localObject2, (File)localObject1);
        if (((File)localObject1).exists())
        {
          long l = ((File)localObject1).lastModified();
          ((aquz)localObject2).lastModifiedTime = this.mApp.getPreferences().getLong("last_modified_time", 0L);
          if (Long.valueOf(l).longValue() != ((aquz)localObject2).lastModifiedTime) {
            ((aquz)localObject2).cWv = true;
          }
        }
        ((aquz)localObject2).cWs = true;
        ((aquz)localObject2).cWy = false;
        localObject1 = new Bundle();
        localaqvc.a((aquz)localObject2, this.jdField_a_of_type_Kdm$a, (Bundle)localObject1);
      }
    }
  }
  
  public boolean dr(String paramString)
  {
    return ((fX != null) && (fX.contains(paramString))) || (nyn.i(this.mApp, paramString));
  }
  
  public void eh(long paramLong)
  {
    this.mApp.getApp().getSharedPreferences(this.mApp.getAccount(), 0).edit().putLong("last_read_time", paramLong).commit();
    this.mLastReadTime = paramLong;
    synchronized (this.object)
    {
      this.H.clear();
      aBK();
      return;
    }
  }
  
  public String getNickName(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = "";
    Object localObject1 = str;
    acja localacja;
    if (paramQQAppInterface != null)
    {
      localObject1 = str;
      if (!TextUtils.isEmpty(paramString))
      {
        localacja = (acja)this.mApp.getManager(56);
        localObject1 = str;
        if ((localacja != null) && (!aako.L(paramQQAppInterface))) {
          break label109;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = localacja.a(paramString, true);
        if (localObject1 == null) {
          break label124;
        }
        localObject1 = ((PublicAccountInfo)localObject1).name;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label121;
        }
        paramQQAppInterface = ocp.a(paramQQAppInterface, paramString);
        if (paramQQAppInterface == null) {
          break label121;
        }
        localObject1 = paramQQAppInterface.name;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label119;
        }
        return paramString;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = localacja.b(paramString);
        continue;
      }
      label109:
      Object localObject2 = localacja.b(paramString);
      continue;
      label119:
      return localObject2;
      label121:
      continue;
      label124:
      localObject2 = "";
    }
  }
  
  public void lK(boolean paramBoolean)
  {
    if (this.mApp == null) {
      return;
    }
    this.mApp.getApp().getSharedPreferences(this.mApp.getAccount(), 0).edit().putBoolean("ec_shop_assist_deleted", paramBoolean).commit();
    this.ael = paramBoolean;
  }
  
  public void lM(boolean paramBoolean)
  {
    this.aen = paramBoolean;
    h().edit().putBoolean("folder_tab_show", this.aen).commit();
  }
  
  void lS(String paramString)
  {
    if (this.aer)
    {
      Intent localIntent = new Intent("action_on_shop_msg_receive");
      localIntent.putParcelableArrayListExtra("datas", (ArrayList)an());
      if ((!TextUtils.isEmpty(paramString)) && ((!this.mApp.b().Op()) || (!paramString.equals(this.mApp.b().oA())))) {
        localIntent.putExtra("uin", paramString);
      }
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
  }
  
  public void lU(String paramString)
  {
    ThreadManager.post(new EcShopAssistantManager.3(this, paramString), 5, null, true);
  }
  
  public int ne()
  {
    int i;
    int j;
    Object localObject2;
    if (this.mDataList != null)
    {
      Iterator localIterator = this.mDataList.iterator();
      i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label119;
      }
      localObject1 = (EcShopData)localIterator.next();
      j = ocp.e(this.mApp, ((EcShopData)localObject1).mUin);
      localObject2 = this.mApp.b();
      if (localObject2 == null) {
        break label124;
      }
    }
    label119:
    label124:
    for (Object localObject1 = ((QQMessageFacade)localObject2).a(((EcShopData)localObject1).mUin, j);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = this.mApp.a();
        if (localObject2 != null) {
          i += ((tog)localObject2).A(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        }
      }
      for (;;)
      {
        break;
        j = 0;
        return j;
      }
    }
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.ag);
      if (this.mGdtAppReceiver != null) {
        this.mGdtAppReceiver.unregister(BaseApplicationImpl.getContext());
      }
      label27:
      if (this.jdField_a_of_type_Aqdf != null)
      {
        this.jdField_a_of_type_Aqdf.destory();
        this.jdField_a_of_type_Aqdf = null;
      }
      this.jdField_a_of_type_Kdm$a = null;
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public void y(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString);
    paramString.mLastDraftTime = paramLong;
    a(paramString);
    lS(null);
  }
  
  public boolean yY()
  {
    return this.mApp.getApp().getSharedPreferences(this.mApp.getAccount(), 0).getBoolean("init_ec_shop_assist", true);
  }
  
  public boolean yZ()
  {
    if (!this.aeo) {}
    long l1;
    long l2;
    do
    {
      return false;
      l1 = h().getLong("last_stay_folder", 0L);
      l2 = this.aIb * 1000 * 60 * 60;
    } while ((System.currentTimeMillis() - l1 >= l2 * 24L) || (!this.aen));
    if (QLog.isColorLevel()) {
      QLog.i("EcShopAssistantManager", 2, "lastEnterShop:" + l1 + ",dayLimit:" + this.aIb);
    }
    return true;
  }
  
  static class a
    extends aquy
  {
    private WeakReference<kdm> cb;
    
    a(kdm paramkdm)
    {
      this.cb = new WeakReference(paramkdm);
    }
    
    public void onDone(aquz paramaquz)
    {
      super.onDone(paramaquz);
      if (this.cb != null)
      {
        Object localObject = (kdm)this.cb.get();
        if (localObject != null)
        {
          QQAppInterface localQQAppInterface = ((kdm)localObject).mApp;
          if ((paramaquz.errCode == 0) && (localQQAppInterface != null))
          {
            localQQAppInterface.getPreferences().edit().putLong("last_modified_time", paramaquz.lastModifiedTime).commit();
            ((kdm)localObject).aBM();
          }
          if (QLog.isColorLevel())
          {
            localObject = new File(kdm.Yl);
            long l = 0L;
            if (((File)localObject).exists()) {
              l = ((File)localObject).lastModified();
            }
            QLog.d("EcShopAssistantManager", 2, "download onDone status=" + paramaquz.getStatus() + ",errCode=" + paramaquz.errCode + ",httpCode=" + paramaquz.httpCode + ",local lastModify=" + l + ",server lastModify=" + paramaquz.lastModifiedTime);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdm
 * JD-Core Version:    0.7.0.1
 */