import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.gson.JsonArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoySSOHandlerThread;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.1;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.10;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.11;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.13;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.16;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.17;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.19;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.2;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.20;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.21;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.22;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.23;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.24;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.3;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.4;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.5;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.6;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.7;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.h;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.j;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.l;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.o;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.s;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.u;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PreloadManager.a;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.util.NetworkState;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspTraceRecord;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class kxm
{
  private static Integer A;
  private static Object LOCK;
  private static ReadInJoySSOHandlerThread jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread;
  public static final KandianRedDotInfo.a a;
  private static final BigInteger jdField_a_of_type_JavaMathBigInteger = BigInteger.ONE.shiftLeft(64);
  public static int aMA;
  private static int aMB;
  public static int aMC;
  public static int aMt;
  public static int aMu;
  public static int aMv;
  public static int aMw;
  public static int aMx;
  private static int aMy;
  private static int aMz;
  private static Handler aU;
  public static String adp;
  public static String adq;
  public static String adr;
  public static String ads;
  private static String adt;
  private static String adu;
  private static String adv;
  private static String adw;
  private static String adx;
  public static volatile boolean aih;
  public static boolean aii;
  private static boolean aij;
  public static boolean aik;
  private static volatile boolean ail;
  private static volatile boolean aim;
  public static volatile boolean ain;
  private static boolean aip;
  private static volatile boolean aiq;
  public static boolean air;
  public static boolean ais;
  public static ArticleInfo c;
  private static SosoInterface.SosoLbsInfo c;
  public static HashMap<Integer, kfr> dy;
  private static Map<String, MessageForStructing> eb;
  public static boolean isFromAIO;
  private static Queue<Integer> k;
  private static long lastClickTime;
  private static Handler mMainThreadHandler;
  public static SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
  private static long su;
  public static long ta;
  private static long tb;
  
  static
  {
    adq = "0";
    adr = "1";
    ads = "2";
    aMt = 7;
    aMv = -2;
    aim = true;
    eb = new HashMap();
    LOCK = new Object();
    su = 300000L;
    aMx = -1;
    adt = "";
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a = new KandianRedDotInfo.a();
    k = new LinkedBlockingQueue(100);
    aMA = -1;
    aMB = 1;
    dy = new HashMap();
    adv = "";
    adw = "";
    aMC = 0;
  }
  
  public static boolean A(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 24) && (paramBaseArticleInfo.mNewPolymericInfo != null);
  }
  
  public static boolean AE()
  {
    return kvu.AE();
  }
  
  public static boolean AI()
  {
    return getAppRuntime() instanceof QQAppInterface;
  }
  
  public static boolean AJ()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    return (localBaseActivity != null) && (((localBaseActivity instanceof ReadInJoyNewFeedsActivity)) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("kandian")) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("readinjoy")));
  }
  
  public static boolean AK()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!(localBaseActivity instanceof SplashActivity)) {
      return false;
    }
    if (((SplashActivity)localBaseActivity).getCurrentTab() == MainFragment.bIq) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean AL()
  {
    return (AJ()) || (AK());
  }
  
  public static boolean AM()
  {
    if (!AI()) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Conversation)localObject1).a().dv();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData))
        {
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + localException.toString());
    }
    for (;;)
    {
      int j = localException.size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (RecentBaseData)localException.get(i);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if ((!TextUtils.equals(((RecentUserBaseData)localObject1).qx(), acbn.blx)) && (((RecentUserBaseData)localObject1).ng() != 5000))
          {
            int m = ((RecentUserBaseData)localObject1).wU();
            if (m > 0) {
              return true;
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public static boolean AN()
  {
    boolean bool = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(315);
    if (!anwa.aze()) {}
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "showStudyGradeEntry ! res= " + localAladdinConfig.toString());
      return bool;
      if (localAladdinConfig.getIntegerFromString("study_mode_select_grade_entry_enable", 0) == 1) {
        bool = true;
      }
    }
  }
  
  public static boolean AO()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(obt.Yi)) {}
    try
    {
      bool = new JSONObject(obt.Yi).optBoolean("useNewLogic", false);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean AP()
  {
    boolean bool = false;
    if (awit.w(getAppRuntime()) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean AQ()
  {
    if (!aii)
    {
      Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.KDCfg.name(), null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 2) {
          aij = localObject[1].equals("1");
        }
        aii = true;
      }
    }
    return aij;
  }
  
  public static boolean AR()
  {
    return (((Boolean)awit.f("preload_controller", Boolean.valueOf(true))).booleanValue()) && (awit.Vs());
  }
  
  public static boolean AS()
  {
    return Aladdin.getConfig(154).getIntegerFromString("need_show_social_bottom_view", 1) == 1;
  }
  
  public static boolean AT()
  {
    return Aladdin.getConfig(176).getIntegerFromString("artical_interact_area", 0) == 1;
  }
  
  public static boolean AU()
  {
    return Aladdin.getConfig(176).getIntegerFromString("ad_relative_pos", 0) == 1;
  }
  
  public static boolean AV()
  {
    return Aladdin.getConfig(190).getIntegerFromString("readinjoy_feeds_overdraw_optimize_switch", 1) == 1;
  }
  
  public static boolean AW()
  {
    return Aladdin.getConfig(253).getIntegerFromString("enable_use_exposure_data", 0) == 1;
  }
  
  public static boolean AX()
  {
    return Aladdin.getConfig(255).getIntegerFromString("allow_yaobu_icon_click_report", 0) == 1;
  }
  
  public static boolean AY()
  {
    return Aladdin.getConfig(245).getIntegerFromString("kandian_feeds_card_style", 0) == 1;
  }
  
  public static boolean AZ()
  {
    return (Ba()) && (!Bb());
  }
  
  public static boolean B(BaseArticleInfo paramBaseArticleInfo)
  {
    return paramBaseArticleInfo.mNewPolymericInfo != null;
  }
  
  public static boolean Ba()
  {
    return nY() == 2;
  }
  
  public static boolean Bb()
  {
    return (ReadinjoyTabFrame.Dx()) || (ReadInJoyDailyFragment.BV()) || (ReadInJoyNewFeedsActivity.zs());
  }
  
  public static boolean Bc()
  {
    return aik;
  }
  
  public static boolean Bd()
  {
    return Aladdin.getConfig(276).getIntegerFromString("supportPreloadWebProcess", 1) == 1;
  }
  
  public static boolean Be()
  {
    return ((Integer)awit.f("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1;
  }
  
  public static void C(Context paramContext, String paramString)
  {
    QLog.d("ReadInJoyUtils", 1, "jumToUrl: " + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("mqqapi:")) {
        break label97;
      }
      QQAppInterface localQQAppInterface = ndi.getApp();
      if (localQQAppInterface == null) {
        break label63;
      }
      aqik.c(localQQAppInterface, paramContext, paramString).ace();
    }
    label63:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyUtils", 2, "jumpToUrl failed for appInterface is null, url:" + paramString);
    return;
    label97:
    aM(paramContext, paramString);
  }
  
  public static boolean C(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mFeedType == 29);
  }
  
  public static boolean D(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 20) && (paramBaseArticleInfo.mRecommendFollowInfos != null);
  }
  
  public static String E(String paramString, int paramInt)
  {
    String str = paramString;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = 0;
      j = 0;
      if (i >= paramString.length()) {
        break label144;
      }
      int m = paramString.charAt(i);
      if (((97 > m) || (m > 122)) && ((65 > m) || (m > 90)) && ((48 > m) || (m > 57))) {
        break label130;
      }
      j += 1;
      label75:
      if (j <= paramInt) {
        break label137;
      }
    }
    label130:
    label137:
    label144:
    for (int j = 1;; j = 0)
    {
      str = paramString;
      if (j != 0)
      {
        j = i;
        if (i == paramInt) {
          j = i - 1;
        }
        str = paramString.substring(0, j) + "…";
      }
      return str;
      j += 2;
      break label75;
      i += 1;
      break;
    }
  }
  
  public static void E(int paramInt, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyUtils.23(paramInt, System.currentTimeMillis() - paramLong));
  }
  
  public static boolean E(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {
      if ((paramBaseArticleInfo.mNewPolymericInfo.aRX != 7) && (paramBaseArticleInfo.mNewPolymericInfo.aRX != 8))
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.mNewPolymericInfo.aRX != 9) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean F(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && ((paramBaseArticleInfo instanceof ArticleInfo)) && (!ndi.aa((ArticleInfo)paramBaseArticleInfo)) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa == 6);
  }
  
  public static boolean G(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool = false;
    switch (paramBaseArticleInfo.mFeedType)
    {
    default: 
      bool = j(paramBaseArticleInfo);
    }
    do
    {
      return bool;
    } while (paramBaseArticleInfo.mProteusTemplateBean == null);
    return dr(lrj.d(paramBaseArticleInfo.mProteusTemplateBean));
  }
  
  public static boolean H(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBaseArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "isImageArticle, flag= " + bool1);
      return bool1;
      bool1 = bool2;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.mFeedType == 36)
        {
          bool1 = bool2;
          if (!paramBaseArticleInfo.isPGCShortContent())
          {
            bool1 = bool2;
            if (paramBaseArticleInfo.mSocialFeedInfo.aSG != 4)
            {
              bool1 = bool2;
              if (paramBaseArticleInfo.mSocialFeedInfo.aSG != 5)
              {
                bool1 = bool2;
                if (paramBaseArticleInfo.mSocialFeedInfo.aSG != 6)
                {
                  QLog.d("ReadInJoyUtils", 1, "isImageArticle, style= " + paramBaseArticleInfo.mSocialFeedInfo.aSG);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean I(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBaseArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "isStructCard, flag= " + bool1);
      return bool1;
      if (paramBaseArticleInfo.isPGCShortContent())
      {
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if ((paramBaseArticleInfo instanceof ArticleInfo))
        {
          bool1 = bool2;
          if (ndi.S((ArticleInfo)paramBaseArticleInfo)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static boolean J(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBaseArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "isVideoCommentBiu, flag= " + bool1);
      return bool1;
      bool1 = bool2;
      if (paramBaseArticleInfo.mFeedType == 36) {
        if (j(paramBaseArticleInfo))
        {
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (paramBaseArticleInfo.mSocialFeedInfo != null) {
            if ((paramBaseArticleInfo.mSocialFeedInfo.aSG != 4) && (paramBaseArticleInfo.mSocialFeedInfo.aSG != 5))
            {
              bool1 = bool2;
              if (paramBaseArticleInfo.mSocialFeedInfo.aSG != 6) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  public static void K(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new ReadInJoyUtils.1(paramQQAppInterface), 8, null, false);
  }
  
  public static void L(QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramQQAppInterface.getAccount());
    localHashMap.put("param_cpu", String.valueOf(aqgz.getCpuNumber()));
    localHashMap.put("param_totalMem", String.valueOf(aqgz.getSystemTotalMemory()));
    localHashMap.put("param_availableMem", String.valueOf(aqgz.getSystemAvaialbeMemory()));
    localHashMap.put("param_version", "3.4.4");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actUserDeviceInfoReport", true, 100L, 0L, localHashMap, "", true);
  }
  
  public static void M(QQAppInterface paramQQAppInterface)
  {
    if (aim)
    {
      aim = false;
      aHS();
    }
    if (awit.Vs())
    {
      lbz.a().qr(0);
      lbz.a().qr(56);
      lbz.a().qs(40677);
      if (kys.du(kys.getChannelId())) {
        lbz.a().qr(kys.getChannelId());
      }
    }
    ail = true;
    ThreadManager.post(new ReadInJoyUtils.3(paramQQAppInterface), 8, null, false);
  }
  
  public static void N(QQAppInterface paramQQAppInterface)
  {
    ail = false;
  }
  
  public static void O(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, false);
  }
  
  public static void O(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      MessageForStructing localMessageForStructing;
      QQMessageFacade localQQMessageFacade;
      do
      {
        do
        {
          return;
          localMessageForStructing = a(paramQQAppInterface);
        } while ((e(paramQQAppInterface)) || (localMessageForStructing == null));
        localQQMessageFacade = paramQQAppInterface.b();
      } while (localQQMessageFacade == null);
      localMessageForStructing.time = NetConnInfoCenter.getServerTime();
      MessageRecord localMessageRecord = ((KandianMergeManager)paramQQAppInterface.getManager(162)).a(localMessageForStructing);
      if (localMessageRecord != null) {
        localQQMessageFacade.b(localMessageRecord, paramQQAppInterface.getCurrentUin());
      }
      localQQMessageFacade.b(localMessageForStructing, paramQQAppInterface.getCurrentUin());
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyUtils", 2, "notifyXinKandianMsg");
  }
  
  public static String P(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "", "", false);
  }
  
  public static void P(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.b();
    if (localObject == null) {
      return;
    }
    MessageRecord localMessageRecord = ((QQMessageFacade)localObject).d(acbn.blx, 7220);
    localObject = localMessageRecord;
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.c != null) {
      if (localMessageRecord != null)
      {
        localObject = localMessageRecord;
        if (localMessageRecord.time > jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.c.time) {}
      }
      else
      {
        localObject = jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.c;
      }
    }
    a(paramQQAppInterface, (MessageRecord)localObject);
  }
  
  public static void Q(QQAppInterface paramQQAppInterface)
  {
    
    if (paramQQAppInterface == null) {
      return;
    }
    long l1 = paramQQAppInterface.getLongAccountUin();
    long l2 = System.currentTimeMillis();
    adu = String.valueOf(l1) + "_" + String.valueOf(l2);
  }
  
  private static void T(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (!anwa.aze()) {
      return;
    }
    try
    {
      paramJSONObject.put("study_mode_selected_grade", i());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("ReadInJoyUtils", 1, "addSelectedGrades error! msg= " + paramJSONObject);
    }
  }
  
  public static void U(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "0X800A189";; str = "0X800A18A")
    {
      kbp.a(null, null, str, str, 0, 0, "", "", "", new nce.a(null, null, null, null).e(paramLong).a().toJsonString(), false);
      return;
    }
  }
  
  public static String V(Context paramContext)
  {
    bS(paramContext);
    return adv;
  }
  
  public static String W(Context paramContext)
  {
    bS(paramContext);
    return adw;
  }
  
  public static String X(@NotNull Context paramContext)
  {
    return Aladdin.getConfig(264).getString("push_title", paramContext.getResources().getString(2131718432));
  }
  
  public static boolean X(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (;;)
    {
      return false;
      float f = awit.b(getAppRuntime());
      if (f > 0.0F) {}
      while (paramInt1 / paramInt2 <= f)
      {
        return true;
        f = 0.75F;
      }
    }
  }
  
  public static int Y(Context paramContext)
  {
    int j = aqiw.getSystemNetwork(paramContext);
    int i;
    if (j >= 1)
    {
      i = j;
      if (j <= 4) {}
    }
    else
    {
      i = 5;
    }
    return i;
  }
  
  public static boolean Y(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 3) {}
    do
    {
      return true;
      if ((Aladdin.getConfig(254).getIntegerFromString("is_fix_below_15min_click_flag", 0) == 1) && (paramInt1 == 0) && (odv.GF())) {
        return false;
      }
    } while (Aladdin.getConfig(251).getIntegerFromString("bt_fix", 0) != 1);
    return false;
  }
  
  public static int a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u == null) || ((!paramBoolean) && (paramArticleInfo.mFeedType != 21) && (paramArticleInfo.mFeedType != 22)) || ((paramBoolean) && (!u(paramArticleInfo)))) {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyUtils", 1, "something is null.");
      }
    }
    do
    {
      return 7;
      if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTb == 3)) {
        return 75;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTb == 3) {
        return 74;
      }
      if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTb == 4)) {
        return 73;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTb == 4) {
        return 72;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyUtils", 1, "error ugcFeedsSrc = " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTb);
    return 7;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int i = 10;
    int m = ndi.k((ArticleInfo)paramBaseArticleInfo);
    switch (m)
    {
    case 13: 
    case 70: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 94: 
    case 95: 
    case 97: 
    case 98: 
    case 99: 
    case 100: 
    case 119: 
    case 121: 
    case 122: 
    case 127: 
    case 131: 
    case 132: 
    case 133: 
    case 134: 
    case 135: 
    case 136: 
    default: 
      i = 0;
    }
    for (;;)
    {
      label590:
      int j = i;
      if (mde.h((ArticleInfo)paramBaseArticleInfo) == 3) {
        j = i;
      }
      switch (m)
      {
      default: 
        j = i;
      case 5: 
      case 6: 
        label658:
        if (B(paramBaseArticleInfo)) {
          if (v(paramBaseArticleInfo))
          {
            j = 67;
            label675:
            if (paramBaseArticleInfo.isTwoItem) {
              j = 43;
            }
            if (mhc.ad(paramBaseArticleInfo)) {
              j = 69;
            }
            switch (paramBaseArticleInfo.mFeedType)
            {
            }
          }
        }
        break;
      }
      for (;;)
      {
        if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j != null)) {}
        switch (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.aSS)
        {
        default: 
          return j;
          if ((paramBaseArticleInfo instanceof AdvertisementInfo))
          {
            i = 55;
            break label590;
          }
          i = 1;
          break label590;
          if ((paramBaseArticleInfo instanceof AdvertisementInfo))
          {
            i = 57;
            break label590;
          }
          i = 2;
          break label590;
          if ((paramBaseArticleInfo instanceof AdvertisementInfo))
          {
            i = 58;
            break label590;
          }
          i = 3;
          break label590;
          i = 4;
          break label590;
          if ((paramBaseArticleInfo instanceof AdvertisementInfo))
          {
            i = 56;
            break label590;
          }
          i = 5;
          break label590;
          if ((paramBaseArticleInfo instanceof AdvertisementInfo))
          {
            i = 59;
            break label590;
          }
          i = 6;
          break label590;
          i = 7;
          break label590;
          i = 8;
          break label590;
          i = 9;
          break label590;
          i = 11;
          break label590;
          i = 19;
          break label590;
          i = 20;
          break label590;
          i = 18;
          break label590;
          i = 101;
          break label590;
          i = 22;
          break label590;
          i = 21;
          break label590;
          i = 2005;
          break label590;
          i = 23;
          break label590;
          i = 30;
          break label590;
          i = 29;
          break label590;
          if (kxr.d(paramBaseArticleInfo) == 32)
          {
            i = 2006;
            break label590;
          }
          i = 31;
          break label590;
          i = 24;
          break label590;
          i = 26;
          break label590;
          i = 32;
          break label590;
          i = 33;
          break label590;
          i = 34;
          break label590;
          i = 25;
          break label590;
          i = 27;
          break label590;
          i = 28;
          break label590;
          i = 28;
          break label590;
          i = 28;
          break label590;
          i = 35;
          break label590;
          i = 36;
          break label590;
          i = 37;
          break label590;
          i = 38;
          break label590;
          i = 39;
          break label590;
          i = 40;
          break label590;
          if (i((ArticleInfo)paramBaseArticleInfo))
          {
            i = 41;
            break label590;
          }
          i = 42;
          break label590;
          i = 19;
          break label590;
          i = 37;
          break label590;
          i = 43;
          break label590;
          if (l((ArticleInfo)paramBaseArticleInfo))
          {
            i = 45;
            break label590;
          }
          i = 46;
          break label590;
          i = 29;
          break label590;
          i = 30;
          break label590;
          i = 31;
          break label590;
          i = 47;
          break label590;
          if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!TextUtils.isEmpty(((ArticleInfo)paramBaseArticleInfo).mArticleSubscriptText)))
          {
            i = 79;
            break label590;
          }
          i = 48;
          break label590;
          i = 1005;
          break label590;
          i = 1006;
          break label590;
          i = 1007;
          break label590;
          if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!TextUtils.isEmpty(((ArticleInfo)paramBaseArticleInfo).mArticleSubscriptText)))
          {
            i = 78;
            break label590;
          }
          i = 49;
          break label590;
          i = 80;
          break label590;
          i = 50;
          break label590;
          i = 51;
          break label590;
          i = 52;
          break label590;
          i = 53;
          break label590;
          i = 54;
          break label590;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.amO)
          {
            i = 62;
            break label590;
          }
          i = 61;
          break label590;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.amO)
          {
            i = 64;
            break label590;
          }
          i = 63;
          break label590;
          i = 65;
          break label590;
          i = 66;
          break label590;
          i = 70;
          break label590;
          i = 73;
          break label590;
          i = 74;
          break label590;
          i = 72;
          break label590;
          i = 71;
          break label590;
          if ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$h == null)) {
            break label1666;
          }
          i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$h.appType;
          break label590;
          i = 75;
          break label590;
          i = 77;
          break label590;
          i = 999;
          break label590;
          i = 998;
          break label590;
          i = 1023;
          break label590;
          i = 1024;
          break label590;
          i = 1025;
          break label590;
          i = 1028;
          break label590;
          i = 1032;
          break label590;
          i = 1033;
          break label590;
          i = 1034;
          break label590;
          i = 1035;
          break label590;
          i = 2004;
          break label590;
          i = 1043;
          break label590;
          j = 12;
          break label658;
          j = 13;
          break label658;
          j = 14;
          break label658;
          j = 15;
          break label658;
          j = 16;
          break label658;
          j = 17;
          break label658;
          if (y(paramBaseArticleInfo))
          {
            j = 82;
            break label675;
          }
          if (x(paramBaseArticleInfo))
          {
            j = 83;
            break label675;
          }
          j = 68;
          break label675;
          if (u(paramBaseArticleInfo))
          {
            j = 54;
            break label675;
          }
          if (!r(paramBaseArticleInfo)) {
            break label675;
          }
          j = 47;
          break label675;
          j = 1031;
          continue;
          if (paramBaseArticleInfo.mProteusTemplateBean != null) {
            j = lrj.d(paramBaseArticleInfo.mProteusTemplateBean);
          }
          break;
        }
      }
      return 1038;
      return 1040;
      return 1041;
      return 1039;
      return 1042;
      label1666:
      i = 0;
    }
  }
  
  public static int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return 1;
    }
    String str;
    if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null)) {
      str = ((MessageForStructing)paramMessageRecord).structingMsg.mExtraData;
    }
    for (;;)
    {
      try
      {
        i = new JSONObject(str).optInt("sceneType", 1);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUtils", 2, "isDailyLockScreen, ret=" + i + ", mr=" + paramMessageRecord);
        }
        return i;
      }
      catch (JSONException localJSONException)
      {
        i = 1;
        continue;
      }
      int i = 1;
    }
  }
  
  public static int a(Long paramLong)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return 0;
    }
    if (!TextUtils.isEmpty(((KandianMergeManager)localQQAppInterface.getManager(162)).b(paramLong))) {}
    for (int i = 1;; i = 0) {
      return i;
    }
  }
  
  public static long a(ArticleInfo paramArticleInfo, int paramInt)
  {
    long l2 = 0L;
    long l1;
    if ((ndi.K(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
    {
      l1 = l2;
      if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  try
                  {
                    l1 = Long.parseLong(paramArticleInfo.mSubscribeID);
                    return l1;
                  }
                  catch (NumberFormatException paramArticleInfo)
                  {
                    paramArticleInfo.printStackTrace();
                    return 0L;
                  }
                  if ((!ndi.ak(paramArticleInfo)) && (paramInt != 72) && (paramInt != 74)) {
                    break;
                  }
                  l1 = l2;
                } while (paramArticleInfo.mSocialFeedInfo == null);
                l1 = l2;
              } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null);
              return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
              if (paramInt != 76) {
                break;
              }
              l1 = l2;
            } while (paramArticleInfo.mSocialFeedInfo == null);
            l1 = l2;
          } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null);
          return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
          if ((ndi.P(paramArticleInfo)) || (paramInt == 73)) {
            break;
          }
          l1 = l2;
        } while (paramInt != 75);
        l1 = l2;
      } while (paramArticleInfo.mSocialFeedInfo == null);
      l1 = l2;
    } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null);
    return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    int i3 = 0;
    long l1 = NetConnInfoCenter.getServerTime();
    int i = aMt;
    int j = i - 2;
    if ((paramQQAppInterface == null) || (i <= 0))
    {
      QLog.d("ReadInJoyUtils", 1, "break insert individual push time:" + l1);
      return l1;
    }
    Object localObject1 = new ArrayList();
    Object localObject2;
    int i2;
    int n;
    try
    {
      localObject2 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject2 != null) {
        break label201;
      }
      QLog.d("ReadInJoyUtils", 1, "conversation frame is null");
      return l1;
    }
    catch (Exception paramQQAppInterface)
    {
      i2 = 0;
      n = i;
    }
    label106:
    QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + paramQQAppInterface.toString());
    int m = n;
    i = i2;
    label143:
    if (i != 0)
    {
      i = 0;
      label149:
      n = i3;
      if (i >= m) {}
    }
    for (;;)
    {
      long l2;
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(i);
        if (paramQQAppInterface != null)
        {
          l2 = ((RecentUserBaseData)paramQQAppInterface).mUser.showUpTime;
          if (l2 <= 0L) {}
        }
        else
        {
          i += 1;
          break label149;
          label201:
          localObject2 = ((Conversation)localObject2).a().dv();
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((List)localObject2).iterator();
          Object localObject3;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (!(localObject3 instanceof RecentBaseData)) {
              continue;
            }
            ((List)localObject1).add((RecentBaseData)localObject3);
            continue;
          }
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RecentBaseData)((Iterator)localObject2).next();
            if (localObject3 == null) {
              continue;
            }
            localObject3 = (RecentUserBaseData)localObject3;
            if ((((RecentUserBaseData)localObject3).mUser == null) || (((RecentUserBaseData)localObject3).mUser.getType() != 1008) || (!nyn.f(paramQQAppInterface, ((RecentUserBaseData)localObject3).mUser.uin))) {
              continue;
            }
            ((Iterator)localObject2).remove();
            continue;
          }
          m = ((List)localObject1).size();
          n = i;
          if (i > m) {
            n = m;
          }
          i1 = 0;
          i = 0;
          if (i1 < n) {
            i2 = i;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int i1;
        boolean bool;
        QLog.d("ReadInJoyUtils", 1, "failed to construct individual push time " + paramQQAppInterface.toString());
      }
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(i1);
        i2 = i;
        if (paramQQAppInterface == null) {
          break label748;
        }
        i2 = i;
        paramQQAppInterface = (RecentUserBaseData)paramQQAppInterface;
        m = i;
        i2 = i;
        if (paramQQAppInterface.mUnreadNum > 0) {
          m = 1;
        }
        i2 = m;
        bool = TextUtils.equals(paramQQAppInterface.qx(), acbn.blx);
        i2 = m;
        if (!bool) {
          break label748;
        }
        i = i1;
        j = m;
        i1 += 1;
        m = j;
        j = i;
        i = m;
      }
      catch (Exception paramQQAppInterface) {}
      m = n;
      break label143;
      n = i;
      if (n >= j)
      {
        QLog.d("ReadInJoyUtils", 1, "insert individual push time:" + l1);
        return l1;
      }
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "insert individual push time:" + l1);
        return l1;
        i = (int)(Math.random() * (j - n)) + 1 + n;
        paramQQAppInterface = (RecentUserBaseData)((List)localObject1).get(i - 1);
        localObject1 = (RecentUserBaseData)((List)localObject1).get(i);
        l2 = Math.max(paramQQAppInterface.mUser.lastmsgtime, paramQQAppInterface.mUser.lastmsgdrafttime);
        long l3 = Math.max(((RecentUserBaseData)localObject1).mUser.lastmsgtime, ((RecentUserBaseData)localObject1).mUser.lastmsgdrafttime);
        double d = Math.random();
        l1 = l2 - ((l2 - l3) * d) - 1L;
        continue;
        QLog.d("ReadInJoyUtils", 1, "construct individual push first " + m + " msg no red point");
      }
      break label106;
      label748:
      i = j;
      j = i2;
    }
  }
  
  public static Intent a(Activity paramActivity, ArticleInfo paramArticleInfo, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("banner_activityName", FastWebActivity.class.getName());
    localIntent.putExtra("banner_webViewUrl", paramArticleInfo.mArticleContentUrl);
    paramActivity = paramArticleInfo.mArticleContentUrl;
    if (!TextUtils.isEmpty(paramActivity))
    {
      paramActivity = Uri.parse(paramActivity);
      if (paramActivity.isHierarchical()) {
        localIntent.putExtra("banner_businessCategory", "WebView_" + paramActivity.getHost());
      }
    }
    paramActivity = new Bundle();
    paramActivity.putParcelable("fast_web_article_info", paramArticleInfo);
    paramActivity.putInt("fast_web_banner_from_channel_id", (int)paramArticleInfo.mChannelID);
    paramActivity.putBoolean("fast_web_from_article_recommend", paramBoolean);
    localIntent.putExtra("banner_webview_extra", paramActivity);
    return localIntent;
  }
  
  public static Intent a(Intent paramIntent, ArticleInfo paramArticleInfo, int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2, int paramInt3)
  {
    if (paramIntent == null) {
      return paramIntent;
    }
    new ArticleInfo();
    ArticleInfo localArticleInfo = paramArticleInfo.clone();
    if (paramArticleInfo.mSocialFeedInfo != null) {
      localArticleInfo.mSocialFeedInfo = paramArticleInfo.mSocialFeedInfo.a();
    }
    if (localArticleInfo.mSocialFeedInfo == null) {
      localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    }
    if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = new SocializeFeedsInfo.c();
    }
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT = new ArrayList();
    paramArticleInfo = new SocializeFeedsInfo.BiuCommentInfo();
    paramArticleInfo.i = Long.valueOf(paramLong);
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString1))) {
      paramArticleInfo.ahU = (": " + paramString1);
    }
    ReadInJoyUserInfoModule.C(paramLong, paramString2);
    paramArticleInfo.aLh = localArticleInfo.mFeedType;
    paramArticleInfo.aSO = paramInt2;
    paramArticleInfo.x = Long.valueOf(localArticleInfo.mFeedId);
    QLog.d("ReadInJoyUtils", 2, "biuCommentInfo " + paramArticleInfo.toString());
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.add(paramArticleInfo);
    paramIntent.putExtra("arg_article_info", localArticleInfo);
    paramIntent.putExtra("biu_rowkey", localArticleInfo.innerUniqueID);
    paramIntent.putExtra("feedsType", localArticleInfo.mFeedType);
    paramIntent.putExtra("arg_from_type", paramInt3);
    paramIntent.putExtra("biu_src", paramInt1);
    paramIntent.putExtra("feed_id", localArticleInfo.mFeedId);
    paramIntent.putExtra("feedsType", localArticleInfo.mFeedType);
    QLog.d("ReadInJoyUtils", 2, "readytoJump  biuType: " + paramInt1 + "feed_id : " + localArticleInfo.mFeedId + "feeds_type : " + localArticleInfo.mFeedType + "articleID : " + localArticleInfo.mArticleID);
    return paramIntent;
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, Drawable paramDrawable)
  {
    Object localObject2 = null;
    boolean bool = false;
    Object localObject1 = paramQQAppInterface.b();
    if (localObject1 == null) {}
    do
    {
      return paramDrawable;
      localObject1 = ((QQMessageFacade)localObject1).d(acbn.blx, 7220);
    } while ((localObject1 == null) || (((MessageRecord)localObject1).isread));
    QLog.d("ReadInJoyUtils", 2, "getSpecAggregateAvatarForKandian run !");
    for (;;)
    {
      try
      {
        localResources = BaseApplicationImpl.getApplication().getResources();
        JSONObject localJSONObject = new JSONObject(((MessageRecord)localObject1).extStr);
        if (localJSONObject.has("kdUin"))
        {
          localObject1 = localJSONObject.getString("kdUin");
          QLog.d("ReadInJoyUtils", 2, "got tipUin from kdUin: " + (String)localObject1);
          if (localJSONObject.has("kdDefaultSourceAvatarUrl"))
          {
            localObject2 = localJSONObject.getString("kdDefaultSourceAvatarUrl");
            QLog.d("ReadInJoyUtils", 2, "got defaultAvatarUrl from kdDefaultSourceAvatarUrl: " + (String)localObject2);
          }
          if (localJSONObject.has("kdShouldShowMergedAvatar"))
          {
            bool = localJSONObject.getBoolean("kdShouldShowMergedAvatar");
            QLog.d("ReadInJoyUtils", 2, "got shouldShowMergedAvatar from kdShouldShowMergedAvatar: " + bool);
          }
          if (!bool)
          {
            QLog.d("ReadInJoyUtils", 2, "shouldn't show merged icon, give up");
            return paramDrawable;
          }
        }
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        Resources localResources;
        paramQQAppInterface.printStackTrace();
        QLog.d("ReadInJoyUtils", 2, "get merge icon has error : " + paramQQAppInterface);
        return paramDrawable;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramQQAppInterface = paramQQAppInterface.a(1, "kd_" + (String)localObject1, (byte)1, 0, 100, true);
          localObject2 = (noq)aqgs.a(paramQQAppInterface);
          if (localObject2 != null)
          {
            QLog.d("ReadInJoyUtils", 2, "getMergeIcon From cache ! key : " + paramQQAppInterface + ", tipUin : " + (String)localObject1);
            return localObject2;
          }
          localObject2 = aqhu.g(paramDrawable);
          if (localObject2 == null) {
            break;
          }
          localObject1 = new noq((Bitmap)localObject2, wja.dp2px(50.0F, localResources), localResources, (String)localObject1, 1);
          aqgs.a(paramQQAppInterface, (Sizeable)localObject1);
          return localObject1;
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        paramQQAppInterface = aqhu.g(paramDrawable);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface = new noq(paramQQAppInterface, (String)localObject2, wja.dp2px(50.0F, localResources), localResources, 1);
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        QLog.d("ReadInJoyUtils", 2, "get merge icon has error : " + paramQQAppInterface);
        return paramDrawable;
      }
      localObject1 = null;
    }
  }
  
  public static android.util.Pair<Integer, Integer> a(android.util.Pair<Integer, Integer>[] paramArrayOfPair, int paramInt1, int paramInt2)
  {
    int j = paramArrayOfPair.length;
    double d2 = 1.0D * paramInt2 / paramInt1;
    double d1 = 1.7976931348623157E+308D;
    android.util.Pair<Integer, Integer> localPair = null;
    int i = 0;
    double d3;
    double d4;
    if (i < j)
    {
      d3 = 1.0D * ((Integer)paramArrayOfPair[i].second).intValue() / ((Integer)paramArrayOfPair[i].first).intValue();
      d4 = Math.abs(d3 - d2);
      if (d4 < d1)
      {
        d1 = Math.abs(d3 - d2);
        localPair = paramArrayOfPair[i];
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if ((d4 == d1) && (localPair != null))
      {
        int m = Math.abs(((Integer)localPair.second).intValue() - paramInt2);
        int n = Math.abs(((Integer)localPair.first).intValue() - paramInt1);
        int i1 = Math.abs(((Integer)paramArrayOfPair[i].second).intValue() - paramInt2);
        if (m + n > Math.abs(((Integer)paramArrayOfPair[i].first).intValue() - paramInt1) + i1)
        {
          d1 = Math.abs(d3 - d2);
          localPair = paramArrayOfPair[i];
          continue;
          return localPair;
        }
      }
    }
  }
  
  private static JsonArray a(long paramLong)
  {
    Object localObject = lty.h(paramLong);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      JsonArray localJsonArray = new JsonArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
        if ((localArticleInfo != null) && (localArticleInfo.mProteusTemplateBean.getData() != null)) {
          localJsonArray.add(localArticleInfo.mProteusTemplateBean.getData().optString("rowkey"));
        }
      }
      return localJsonArray;
    }
    return null;
  }
  
  public static ArticleInfo a(String paramString)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    Object localObject5;
    long l1;
    Object localObject6;
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        localObject5 = new JSONObject(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyUtils", 2, "web json:" + ((JSONObject)localObject5).toString());
        }
        localObject3 = ((JSONObject)localObject5).optString("title");
        localObject1 = ((JSONObject)localObject5).optString("sourceName");
        l2 = 0L;
        l3 = 0L;
        l7 = 0L;
        l11 = 0L;
      }
      catch (Exception paramString)
      {
        Object localObject3;
        long l11;
        long l8;
        long l9;
        long l10;
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyUtils", 2, "Exception error=" + paramString.getMessage());
        }
        return localArticleInfo;
      }
      for (;;)
      {
        try
        {
          paramString = new String(aqgo.decode((String)localObject3, 0));
        }
        catch (Exception localException3)
        {
          Object localObject4;
          paramString = (String)localObject1;
          l6 = l7;
          localObject1 = localObject4;
          break;
          if (j == 4) {
            continue;
          }
          if (j != 5) {
            continue;
          }
          continue;
        }
        try
        {
          localObject3 = new String(aqgo.decode((String)localObject1, 0));
          l6 = l7;
          l5 = l3;
          l4 = l2;
        }
        catch (Exception localException1)
        {
          localObject4 = paramString;
          paramString = (String)localObject1;
          l6 = l7;
          localObject1 = localObject4;
          break;
        }
      }
      try
      {
        localObject1 = ((JSONObject)localObject5).optString("feedsId");
        l1 = l2;
        l6 = l7;
        l5 = l3;
        l4 = l2;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l3;
          l4 = l2;
          l1 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l7;
        l5 = l3;
        l4 = l1;
        localObject1 = ((JSONObject)localObject5).optString("ariticleId");
        l2 = l3;
        l6 = l7;
        l5 = l3;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l3;
          l4 = l1;
          l2 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l7;
        l5 = l2;
        l4 = l1;
        localObject1 = ((JSONObject)localObject5).optString("originFeedsId");
        l3 = l7;
        l6 = l7;
        l5 = l2;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l2;
          l4 = l1;
          l3 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l3;
        l5 = l2;
        l4 = l1;
        localObject6 = ((JSONObject)localObject5).optString("businessId");
        l7 = l11;
        localObject2 = localObject3;
        l8 = l3;
        l9 = l2;
        l10 = l1;
        localObject1 = paramString;
        l6 = l3;
        l5 = l2;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject6))
        {
          l6 = l3;
          l5 = l2;
          l4 = l1;
          l7 = new BigInteger((String)localObject6).longValue();
          localObject1 = paramString;
          l10 = l1;
          l9 = l2;
          l8 = l3;
          localObject2 = localObject3;
        }
        l1 = ((JSONObject)localObject5).optLong("originFeedsType", 1L);
        paramString = ((JSONObject)localObject5).optString("picurl");
        i = ((JSONObject)localObject5).optInt("duration");
        ((JSONObject)localObject5).optString("callback");
        localObject3 = new String(aqgo.decode(((JSONObject)localObject5).optString("accountDesc"), 0));
        j = ((JSONObject)localObject5).optInt("feedsType", 1);
        localArticleInfo.mArticleID = l9;
        localArticleInfo.mTitle = ((String)localObject1);
        localArticleInfo.mSubscribeName = ((String)localObject2);
        localArticleInfo.mFirstPagePicUrl = paramString;
        localArticleInfo.mVideoDuration = i;
        localArticleInfo.mFeedId = l10;
        localArticleInfo.mFeedType = j;
        localArticleInfo.mSummary = ((String)localObject3);
        localArticleInfo.businessId = l7;
        paramString = ((JSONObject)localObject5).getJSONArray("biuLevelList");
        localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = new SocializeFeedsInfo.c();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y = Long.valueOf(l8);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z = Long.valueOf(l1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT = new ArrayList();
        if (paramString == null) {
          break label914;
        }
        i = 0;
        if (i >= paramString.length()) {
          break label914;
        }
        localObject2 = new SocializeFeedsInfo.BiuCommentInfo();
        localObject3 = paramString.getJSONObject(i);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).i = Long.valueOf(((JSONObject)localObject3).optLong("uin"));
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).ahU = ((JSONObject)localObject3).optString("comment");
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).aRW = ((JSONObject)localObject3).optInt("biuTime");
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).aLh = ((JSONObject)localObject3).optInt("feeds_type", 1);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).aSO = ((JSONObject)localObject3).optInt("op_type");
      }
      catch (Exception localException2)
      {
        localObject1 = paramString;
        paramString = (String)localObject4;
        l3 = l5;
        l2 = l4;
        continue;
      }
      try
      {
        localObject3 = ((JSONObject)localObject3).optString("feedsId");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((SocializeFeedsInfo.BiuCommentInfo)localObject2).x = Long.valueOf(new BigInteger((String)localObject3).longValue());
        }
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).ahU = new String(aqgo.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject2).ahU, 0));
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).ahj = ((SocializeFeedsInfo.BiuCommentInfo)localObject2).ahU;
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        continue;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.add(localObject2);
      i += 1;
      continue;
      ((Exception)localObject2).printStackTrace();
      l7 = l11;
      localObject2 = paramString;
      l8 = l6;
      l9 = l3;
      l10 = l2;
    }
    label914:
    paramString = ((JSONObject)localObject5).optJSONObject("ugcInfo");
    if ((paramString != null) && ((j == 4) || (j == 5) || ((j == 1) && ((l1 == 4L) || (l1 == 5L)))))
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r = new SocializeFeedsInfo.r();
      j = paramString.optInt("ugcType", 0);
      localObject2 = paramString.optString("ugcComment");
      localObject4 = paramString.optJSONArray("ugcAtLevelList");
      if (localObject4 != null)
      {
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b = new SocializeFeedsInfo.c();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.iT = new ArrayList();
        i = 0;
        for (;;)
        {
          if (i >= ((JSONArray)localObject4).length()) {
            break label1249;
          }
          localObject5 = new SocializeFeedsInfo.BiuCommentInfo();
          localObject6 = ((JSONArray)localObject4).getJSONObject(i);
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).i = Long.valueOf(((JSONObject)localObject6).optLong("uin"));
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahU = ((JSONObject)localObject6).optString("comment");
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).aRW = ((JSONObject)localObject6).optInt("biuTime");
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).aLh = ((JSONObject)localObject6).optInt("feeds_type", 1);
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).aSO = ((JSONObject)localObject6).optInt("op_type");
          try
          {
            localObject6 = ((JSONObject)localObject6).optString("feedsId");
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {
              ((SocializeFeedsInfo.BiuCommentInfo)localObject5).x = Long.valueOf(new BigInteger((String)localObject6).longValue());
            }
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahU = new String(aqgo.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahU, 0));
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahj = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahU;
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              localException5.printStackTrace();
            }
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.iT.add(localObject5);
          i += 1;
        }
      }
      label1249:
      localArticleInfo.mTitle = new String(aqgo.decode((String)localObject2, 0));
      localArticleInfo.mSummary = "";
      if ((j != 3) && (j != 2)) {
        break label1584;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la = new ArrayList();
      localObject1 = new SocializeFeedsInfo.s();
      paramString = paramString.optJSONArray("ugcPicInfo");
      if ((paramString != null) && (paramString.length() > 0))
      {
        ((SocializeFeedsInfo.s)localObject1).aii = paramString.getJSONObject(0).optString("ugcPicUrl");
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.add(localObject1);
      }
    }
    for (;;)
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa = j;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.ail = localArticleInfo.mTitle;
      localArticleInfo.mSocialFeedInfo.ahL = "";
      localArticleInfo.mSocialFeedInfo.ahN = "";
      localArticleInfo.mSocialFeedInfo.ahM = "";
      return localArticleInfo;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb = new ArrayList();
      localObject2 = new SocializeFeedsInfo.t();
      paramString = paramString.optJSONObject("ugcVideoInfo");
      if (paramString != null)
      {
        ((SocializeFeedsInfo.t)localObject2).pic_url = paramString.optString("ugcVideoCoverUrl");
        ((SocializeFeedsInfo.t)localObject2).duration = paramString.optInt("ugcVideoDuration");
        ((SocializeFeedsInfo.t)localObject2).title = ((String)localObject1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.add(localObject2);
        continue;
        if (j == 1) {
          localArticleInfo.mFirstPagePicUrl = "";
        }
      }
    }
  }
  
  public static ReadinjoyTabFrame a(Context paramContext)
  {
    try
    {
      if ((paramContext instanceof SplashActivity))
      {
        paramContext = FrameHelperActivity.a((BaseActivity)paramContext);
        if (paramContext == null) {
          return null;
        }
        paramContext = (ReadinjoyTabFrame)paramContext.a(ReadinjoyTabFrame.class);
        return paramContext;
      }
    }
    catch (RuntimeException paramContext)
    {
      QLog.e("ReadInJoyUtils", 1, paramContext, new Object[0]);
    }
    return null;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static SosoInterface.SosoLbsInfo a()
  {
    long l = System.currentTimeMillis();
    if (l - tb > su)
    {
      jdField_c_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = aczc.a("readinjoy_anti_cheating");
      tb = l;
    }
    return jdField_c_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  }
  
  public static MessageForStructing a(QQAppInterface paramQQAppInterface)
  {
    synchronized (LOCK)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)eb.get(paramQQAppInterface.getCurrentAccountUin());
      eb.remove(paramQQAppInterface.getCurrentAccountUin());
      return localMessageForStructing;
    }
  }
  
  public static SystemBarCompact a(Activity paramActivity)
  {
    return new SystemBarCompact(paramActivity, true, -1);
  }
  
  public static Object a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramAppRuntime = awit.a(paramAppRuntime, true, paramBoolean);
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.getString(paramString, "");
          if (!TextUtils.isEmpty(paramAppRuntime))
          {
            paramAppRuntime = new ObjectInputStream(new ByteArrayInputStream(aqoj.ag(paramAppRuntime)));
            paramString = paramAppRuntime.readObject();
            paramAppRuntime.close();
            return paramString;
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
      }
    }
    return null;
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = Integer.toString(nQ());
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", aMw);
        localJSONObject.put("source", str);
        localJSONObject.put("feeds_type", paramInt3);
        localJSONObject.put("kandian_mode", nR());
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localJSONObject.put("rowkey", paramString2);
        localJSONObject.put("pic_number", paramInt1);
        if (paramInt2 > 0) {
          localJSONObject.put("pic_position", "" + paramInt2);
        }
        if (paramArticleInfo != null) {
          localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        }
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyUtils", 2, "transGridImageClickR5 json exception.");
        paramString1.printStackTrace();
        continue;
      }
      return localJSONObject.toString();
      localJSONObject.put("rowkey", "0");
    }
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, ArticleInfo paramArticleInfo)
  {
    localJSONObject = new JSONObject();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = Integer.toString(nQ());
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", aMw);
        if (TextUtils.isEmpty(paramString3)) {
          continue;
        }
        localJSONObject.put("feeds_source", paramString3);
        localJSONObject.put("feeds_type", paramInt3);
        localJSONObject.put("kandian_mode", nR());
        localJSONObject.put("source", str);
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localJSONObject.put("rowkey", paramString2);
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyUtils", 2, "transGridImageClickR5 json exception.");
        paramString1.printStackTrace();
        continue;
        localJSONObject.put("rowkey", "0");
        continue;
      }
      localJSONObject.put("pic_number", paramInt1);
      if (paramInt2 > 0) {
        localJSONObject.put("pic_position", "" + paramInt2);
      }
      if (paramArticleInfo != null)
      {
        localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localJSONObject.put("channel_id", paramArticleInfo.mChannelID);
      }
      return localJSONObject.toString();
      localJSONObject.put("feeds_source", "0");
    }
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("folder_status", aMw);
      ((JSONObject)localObject).put("feeds_type", paramInt1);
      ((JSONObject)localObject).put("channel_id", paramInt2);
      ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
      ((JSONObject)localObject).put("session_id", adt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, ArticleInfo paramArticleInfo)
  {
    try
    {
      paramString1 = a(paramLong, paramInt1, paramInt2, paramBoolean, paramString1, paramString3, paramString4, paramInt5, nQ(), paramArticleInfo).toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, ArticleInfo paramArticleInfo)
  {
    return a(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString1, paramString2, paramString3, paramString4, 0, paramArticleInfo);
  }
  
  public static String a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, ArticleInfo paramArticleInfo, long paramLong2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean2, int paramInt9, int paramInt10, int paramInt11)
  {
    paramString2 = a(paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramString1, paramString2, paramString3, paramString4, paramArticleInfo);
    for (;;)
    {
      try
      {
        paramString3 = new JSONObject(paramString2);
        paramString3.put("kandian_mode", paramInt7);
        paramString3.put("kandian_mode_new", kct.nd());
        paramString3.put("tab_source", paramInt6);
        if (paramInt11 >= 0) {
          paramString3.put("entry_path", paramInt11);
        }
        if (paramInt5 >= 0) {
          paramString3.put("behavior_type", paramInt5);
        }
        if (paramLong2 > 0L) {
          paramString3.put("stay_duration", paramLong2);
        }
        paramString3.put("video_inserted", paramBoolean2);
        paramString3.put("video_strategyid", paramInt8);
        paramString3.put("proteus_bid", awit.sn("default_feeds_proteus_offline_bid"));
        paramString3.put("ads_jump", paramInt9);
        paramString3.put("ads_source", paramInt10);
        paramString3.put("star_logo", e(paramArticleInfo));
        if (aqux.Mv() == 1)
        {
          paramString1 = "1";
          paramString3.put("simCardType", paramString1);
          if ((kys.dv(paramInt2)) && (paramArticleInfo != null))
          {
            paramLong1 = ((Long)awit.f("readinjoy_daily_article_first_exposure_" + paramArticleInfo.mArticleID, Long.valueOf(0L))).longValue();
            if (paramLong1 != 0L) {
              paramString3.put("daily_article_first_timestamp", paramLong1 + "");
            }
          }
          if (paramArticleInfo != null)
          {
            if (!paramArticleInfo.isShowGif) {
              continue;
            }
            paramString3.put("short_content_gif", 1);
          }
          if (paramArticleInfo != null) {
            paramString3.put("account_expose_card", c(paramArticleInfo));
          }
          if (paramArticleInfo != null) {
            paramString3.put("picture_click_jumptype", Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0));
          }
          if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 0L) && (p(paramArticleInfo)))
          {
            if (paramArticleInfo.mCommentCount > 100L) {
              break label716;
            }
            if (paramArticleInfo.mVideoCommentCount <= 100) {
              break label680;
            }
            break label716;
            paramString3.put("comment_exposure", paramInt1);
          }
          if (paramArticleInfo != null)
          {
            if ((lhn.oC() == -1) || (lhn.oC() == 0)) {
              break label685;
            }
            paramString3.put("mainfeeds_showcase", lhn.oC());
            paramString3.put("configchannel_name", lhn.jr());
          }
          if ((paramArticleInfo != null) && (mgn.Z(paramArticleInfo))) {
            paramString3.put("jump_src", mgn.j(paramArticleInfo));
          }
          if ((paramArticleInfo != null) && (paramArticleInfo.isPGCShortContent())) {
            paramString3.put("short_content_size", ComponentPGCShortContentBig.agf);
          }
          paramString3.put("default_feeds_aladdin_keys", awit.f("default_feeds_aladdin_keys", ""));
          if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo == null) || (!paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo.uint32_is_topic.has())) {
            break label698;
          }
          paramString3.put("istopic", 1);
          paramString1 = paramString3.toString();
          paramString2 = paramString1;
          if (paramArticleInfo == null) {}
        }
      }
      catch (JSONException paramString3)
      {
        paramString1 = paramString2;
        paramString2 = paramString3;
        paramString2.printStackTrace();
        return paramString1;
      }
      try
      {
        paramString2 = new nce.a(paramString1).c(paramArticleInfo).d(paramArticleInfo).a(paramArticleInfo.videoReportInfo).a(paramArticleInfo, true).a().toJsonString();
        return paramString2;
      }
      catch (JSONException paramString2)
      {
        continue;
      }
      paramString1 = "0";
      continue;
      paramString3.put("short_content_gif", 0);
      continue;
      label680:
      paramInt1 = 2;
      continue;
      label685:
      paramString3.put("mainfeeds_showcase", 0);
      continue;
      label698:
      paramString3.put("istopic", 0);
      continue;
      label716:
      paramInt1 = 1;
    }
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, ArticleInfo paramArticleInfo, String paramString3)
  {
    paramString1 = a(paramLong, paramInt1, paramInt2, 0, 0, paramBoolean, paramString1, null, paramString2, null, 0, paramArticleInfo);
    try
    {
      paramString2 = new JSONObject(paramString1);
      paramString2.put("topicid", paramString3);
      paramString2.put("proteus_bid", awit.sn("default_feeds_proteus_offline_bid"));
      return paramString2.toString();
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String a(VideoInfo paramVideoInfo, int paramInt)
  {
    nce.a locala = new nce.a(null, null, null, null);
    locala.T(ReadinjoyTabFrame.aYY).U(paramInt);
    if (paramVideoInfo != null) {
      if (paramVideoInfo.adF) {
        if (paramVideoInfo.isUseGif)
        {
          paramInt = 3;
          locala.a("status", Integer.valueOf(paramInt)).h(paramVideoInfo.Wz).e(paramVideoInfo.algorithmID).e(paramVideoInfo.vid).V(0).a(0);
        }
      }
    }
    for (;;)
    {
      return locala.a().toJsonString();
      paramInt = 2;
      break;
      paramInt = 4;
      break;
      locala.a("status", Integer.valueOf(1));
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    if (paramArticleInfo == null)
    {
      QLog.d("ReadInJoyUtils", 1, "transMergeKandianReportR5BaseForFastWeb articleInfo is null.");
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithm_id", paramArticleInfo.mAlgorithmID);
      localJSONObject.put("puin_type", paramString);
      localJSONObject.put("source", dc(paramInt));
      localJSONObject.put("kandian_mode", nR());
      localJSONObject.put("mp_article_id", paramArticleInfo.mArticleID);
      localJSONObject.put("channel_id", paramInt);
      return localJSONObject.toString();
    }
    catch (JSONException paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      a(localJSONObject, paramArticleInfo);
      if (paramBoolean) {}
      for (paramArticleInfo = "1";; paramArticleInfo = "0")
      {
        localJSONObject.put("fast_biu", paramArticleInfo);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    String str;
    if (dF(paramString)) {
      str = b(paramString, paramBaseArticleInfo);
    }
    do
    {
      return str;
      str = paramString;
    } while (!dG(paramString));
    return c(paramString, paramBaseArticleInfo);
  }
  
  public static String a(PBBytesField paramPBBytesField)
  {
    if (a(paramPBBytesField)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  @Deprecated
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!awit.r(getAppRuntime())) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
    }
    android.util.Pair localPair;
    do
    {
      return paramString;
      localPair = a(kwt.a, paramInt2, paramInt1);
    } while (localPair == null);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUtils", 2, "the picture size : w : " + paramInt2 + " h : " + paramInt1 + ", select scale : " + localPair.first + ":" + localPair.second + " from : " + paramInt3);
    }
    Object localObject = paramString.split("/");
    localObject = localObject[(localObject.length - 1)];
    return paramString.replace("_open/" + (String)localObject, "_open_" + localPair.first + "_" + localPair.second + "/" + (String)localObject);
  }
  
  public static String a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", aMw);
      localJSONObject.put("algorithm_id", paramLong);
      localJSONObject.put("feeds_friends_interaction", paramInt);
      localJSONObject.put("session_id", adt);
      localJSONObject.put("os", "1");
      localJSONObject.put("version", "3.4.4".replace(".", ""));
      localJSONObject.put("rowkey", paramString);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mTopicRecommendFeedsInfo == null) || (paramArticleInfo.mTopicRecommendFeedsInfo.ld == null) || (paramArticleInfo.mTopicRecommendFeedsInfo.ld.isEmpty())) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", aMw);
      localJSONObject.put("feeds_source", ((mih.b)paramArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).businessId);
      localJSONObject.put("feeds_type", "" + a(paramArticleInfo));
      localJSONObject.put("entry_mode", paramString);
      localJSONObject.put("kandian_mode", "" + nR());
      localJSONObject.put("tab_source", "" + nQ());
      localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
      localJSONObject.put("channel_id", paramArticleInfo.mChannelID);
      localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString, ArticleInfo paramArticleInfo, long paramLong)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return "";
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", aMw);
      if (ndi.K(paramArticleInfo)) {
        localJSONObject.put("feeds_source", paramArticleInfo.mSubscribeID);
      }
      for (;;)
      {
        localJSONObject.put("feeds_type", "" + a(paramArticleInfo));
        localJSONObject.put("entry_mode", paramString);
        localJSONObject.put("kandian_mode", "" + nR());
        localJSONObject.put("tab_source", "" + nQ());
        localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
        localJSONObject.put("channel_id", paramArticleInfo.mChannelID);
        localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localJSONObject.put("enter_uin", paramLong);
        return localJSONObject.toString();
        localJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
      }
      return "";
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String a(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    paramString = c(paramString);
    Object localObject2;
    long l2;
    Object localObject1;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject2 = paramString.optJSONObject(0);
      if (localObject2 != null)
      {
        String str2 = ((JSONObject)localObject2).optString("vid");
        int m = ((JSONObject)localObject2).optInt("duration");
        String str3 = ((JSONObject)localObject2).optString("thirdIcon");
        String str4 = ((JSONObject)localObject2).optString("thirdName");
        String str5 = ((JSONObject)localObject2).optString("thirdAction");
        String str6 = ((JSONObject)localObject2).optString("innerUniqueID");
        String str7 = ((JSONObject)localObject2).optString("width", "0");
        String str8 = ((JSONObject)localObject2).optString("height", "0");
        int j = ((JSONObject)localObject2).optInt("busiType");
        int i = j;
        if (j == 0) {
          i = 1;
        }
        String str9 = ((JSONObject)localObject2).optString("third_uin", "");
        String str10 = ((JSONObject)localObject2).optString("third_uin_name", "");
        paramString = "0";
        String str1 = "";
        l2 = 0L;
        if (!ndi.an(paramBaseArticleInfo)) {
          paramString = String.valueOf(((JSONObject)localObject2).optLong("file_size"));
        }
        paramBaseArticleInfo = str1;
        localObject1 = paramString;
        for (;;)
        {
          try
          {
            JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("video_info");
            localObject3 = str1;
            l1 = l2;
            localObject2 = paramString;
            if (localJSONArray != null)
            {
              j = 0;
              localObject3 = str1;
              l1 = l2;
              localObject2 = paramString;
              paramBaseArticleInfo = str1;
              localObject1 = paramString;
              if (j < localJSONArray.length())
              {
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                JSONObject localJSONObject = localJSONArray.optJSONObject(j);
                if (localJSONObject == null) {
                  continue;
                }
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                int n = localJSONObject.optInt("network_type");
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                l1 = localJSONObject.optLong("file_size");
                if (n != 2) {
                  continue;
                }
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                localObject2 = String.valueOf(l1);
                paramBaseArticleInfo = str1;
                localObject1 = localObject2;
                localObject3 = localJSONObject.optString("url", "");
                paramBaseArticleInfo = (BaseArticleInfo)localObject3;
                localObject1 = localObject2;
                l1 = localJSONObject.optLong("url_expire_time");
              }
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            Object localObject3 = paramBaseArticleInfo;
            long l1 = l2;
            localObject2 = localObject1;
            continue;
          }
          return str2 + ";" + m + ";" + str3 + ";" + str4 + ";" + str5 + ";" + str6 + ";" + i + ";" + str7 + ";" + str8 + ";" + str9 + ";" + str10 + ";" + (String)localObject2 + ";" + (String)localObject3 + ";" + l1;
          j += 1;
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", aMw);
      localJSONObject.put("kandian_mode", nR());
      localJSONObject.put("tab_source", nQ());
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("feeds_type", a(paramArticleInfo));
      localJSONObject.put("topicId", paramString2);
      localJSONObject.put("proteus_bid", awit.sn("default_feeds_proteus_offline_bid"));
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return Long.toString(System.currentTimeMillis());
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    int j = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", aMw);
      localJSONObject.put("time", System.currentTimeMillis());
      localJSONObject.put("algorithm_id", paramString1);
      localJSONObject.put("session_id", adt);
      if (paramBoolean)
      {
        i = 1;
        localJSONObject.put("avatar", i);
        localJSONObject.put("kd_pos", aMx);
        if (!TextUtils.isEmpty(paramString3)) {
          localJSONObject.put("stick", paramString3);
        }
        if (aMw == 6)
        {
          localJSONObject.put("id", paramString2);
          localJSONObject.put("social_uin", paramString4);
        }
        if (!AM()) {
          break label231;
        }
        i = 1;
        label143:
        localJSONObject.put("message_status", i);
        if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label237;
        }
        i = 1;
        label170:
        localJSONObject.put("reddot_style", i);
        if (!awit.Q(getAppRuntime())) {
          break label243;
        }
      }
      label231:
      label237:
      label243:
      for (int i = j;; i = 0)
      {
        localJSONObject.put("hemera_switch", i);
        localJSONObject.put("kandian_mode_new", kct.nd());
        paramString1 = localJSONObject.toString();
        return paramString1;
        i = 0;
        break;
        i = 0;
        break label143;
        i = 0;
        break label170;
      }
      return "";
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static String a(String paramString, mhr.a parama, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (parama != null)
    {
      localObject = paramString;
      if (paramBaseArticleInfo != null)
      {
        localObject = paramString;
        if (TextUtils.isEmpty(parama.ahr)) {}
      }
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3").append("&channelID=").append(paramBaseArticleInfo.mChannelID).append("&strategyId=").append(parama.strategyID).append("&algorithmID=").append(parama.algorithmID).append("&title=").append(parama.articleTitle).append("&firstPagePicUrl=").append(URLEncoder.encode(parama.ahr, "UTF-8")).append("&articleID=").append(parama.articleID).append("&subscribeName=").append(parama.subscribeName).append("&rowKey=").append(parama.ahs).append("&subscribeID=").append(parama.subscribeID).append("&articleContentUrl=").append(URLEncoder.encode(paramString, "UTF-8")).append("&readinjoyNotDecodeUrl=1");
      localObject = ((StringBuilder)localObject).toString();
      QLog.d("ReadInJoyUtils", 1, "getJumpNativeArticleScheme | polymeric articleScheme : " + (String)localObject);
      return localObject;
    }
    catch (UnsupportedEncodingException parama)
    {
      for (;;)
      {
        localObject = paramString;
      }
    }
  }
  
  public static String a(String paramString, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (paramJSONObject != null)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("card_info");
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            if (!str.equalsIgnoreCase("reportInfo"))
            {
              paramJSONObject = localJSONObject.getString(str);
              localStringBuilder.append("&");
              paramString = paramJSONObject;
              if (paramJSONObject.contains("&")) {
                paramString = URLEncoder.encode(paramJSONObject, "utf-8");
              }
              localStringBuilder.append(str + "=" + paramString);
            }
          }
          catch (Exception paramString) {}
        }
      }
    }
    localStringBuilder.append("&");
    localStringBuilder.append("readinjoyNotDecodeUrl=1");
    return localStringBuilder.toString();
  }
  
  private static String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap != null) && (!paramMap.containsKey(paramString1))) {
      return "&" + paramString1 + "=" + paramString2;
    }
    return "";
  }
  
  public static String a(articlesummary.ChannelInfo paramChannelInfo)
  {
    if (paramChannelInfo == null) {
      return null;
    }
    return paramChannelInfo.bytes_channel_name.get().toStringUtf8();
  }
  
  public static URL a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramBaseArticleInfo = c(paramString);
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.length() > 0))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.optJSONObject(0);
      if (paramBaseArticleInfo != null) {
        try
        {
          paramBaseArticleInfo = obs.a(paramBaseArticleInfo.optString("picture"), 3);
          return paramBaseArticleInfo;
        }
        catch (Exception paramBaseArticleInfo)
        {
          paramBaseArticleInfo.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static URL a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (dA(paramString)) {
      if (!paramBoolean1) {
        break label57;
      }
    }
    label57:
    for (localObject = kwz.i();; localObject = kwz.d())
    {
      localObject = a(paramString, ((Integer)((android.util.Pair)localObject).second).intValue(), ((Integer)((android.util.Pair)localObject).first).intValue(), 3);
      return b((String)localObject);
    }
  }
  
  public static List<String> a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForStructing))) {}
    do
    {
      do
      {
        return null;
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        paramMessageRecord.parse();
      } while ((paramMessageRecord.structingMsg == null) || (TextUtils.isEmpty(paramMessageRecord.structingMsg.mArticleIds)));
      paramMessageRecord = paramMessageRecord.structingMsg.mArticleIds.split("\\|");
    } while (paramMessageRecord.length <= 0);
    return Arrays.asList(paramMessageRecord);
  }
  
  public static Properties a(String paramString)
  {
    Properties localProperties = new Properties();
    try
    {
      localProperties.load(new StringReader(paramString));
      return localProperties;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static kxm.b a()
  {
    kxm.b localb = new kxm.b();
    try
    {
      localb.j();
      localb.k();
      localb.l();
      localb.n();
      localb.m();
      return localb;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localb;
  }
  
  public static kxm.b a(int paramInt1, long paramLong, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    kxm.b localb = new kxm.b();
    try
    {
      paramString1 = localb.a(paramLong).c().d().k(paramInt2).a(paramInt1).m().c(paramString1).k().l().b(paramString2).f(paramInt3).g(paramInt4).h(paramInt5).i(paramInt6).j(paramInt7).e().f().g().h();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localb;
  }
  
  public static kxm.b a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    localb1 = new kxm.b();
    try
    {
      kxm.b localb2 = localb1.c().d().a(paramInt1).f().g().h().i().a(paramString).d(paramInt2).e(paramInt3).b();
      if (paramBoolean) {}
      for (paramString = "1";; paramString = "2")
      {
        localb2.a("refresh_way", paramString).j().n();
        if (paramInt4 == -1) {
          break;
        }
        localb1.a("pull_image", String.valueOf(paramInt4));
        return localb1;
      }
      return localb1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static kxm.b a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null))
    {
      SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
      Object localObject;
      int i;
      if (ndi.K(paramArticleInfo))
      {
        localObject = paramArticleInfo.mSubscribeID;
        if (localSocializeFeedsInfo.iS == null) {
          break label171;
        }
        i = localSocializeFeedsInfo.iS.size();
        label49:
        if (!TextUtils.isEmpty(localSocializeFeedsInfo.ahL)) {
          break label176;
        }
      }
      label171:
      label176:
      for (int j = 0;; j = 1)
      {
        int m = localSocializeFeedsInfo.mLikeCount;
        int n = localSocializeFeedsInfo.mCommentCount;
        int i1 = localSocializeFeedsInfo.aSI;
        return a((int)paramArticleInfo.mChannelID, paramArticleInfo.mAlgorithmID, paramArticleInfo.mFeedType, (String)localObject, paramArticleInfo.innerUniqueID, i + 1, j, m, n, i1);
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {}
        for (localObject = Long.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);; localObject = "")
        {
          localObject = localObject;
          break;
        }
        i = 0;
        break label49;
      }
    }
    return new kxm.b();
  }
  
  public static JSONObject a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt3, int paramInt4, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    label148:
    label178:
    int i;
    try
    {
      localJSONObject.put("algorithm_id", paramLong);
      localJSONObject.put("folder_status", bf(paramInt2));
      localJSONObject.put("feeds_type", paramInt1);
      localJSONObject.put("time", System.currentTimeMillis());
      localJSONObject.put("channel_id", paramInt2);
      if (!paramBoolean) {
        break label1405;
      }
      paramInt1 = 2;
      localJSONObject.put("network_type", paramInt1);
      localJSONObject.put("feeds_source", paramString1);
      localJSONObject.put("imei", iT());
      localJSONObject.put("imsi", iU());
      localJSONObject.put("session_id", adt);
      if ((paramInt2 == 0) || (kys.dv(paramInt2)))
      {
        if (paramInt2 != 0) {
          break label1410;
        }
        paramString1 = odv.acA;
        localJSONObject.put("r_session_id", paramString1);
        if (paramArticleInfo != null)
        {
          if (paramInt2 != 0) {
            break label1418;
          }
          paramString1 = odv.a(paramArticleInfo.mArticleID);
          if (paramString1 != null)
          {
            localJSONObject.put("r_session_position", paramString1.first);
            localJSONObject.put("r_session_ispush", paramString1.second);
          }
        }
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("rowkey", paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("account_type", paramString3);
      }
      if ((!g(paramArticleInfo)) && (!ndi.ak(paramArticleInfo)) && (!ndi.S(paramArticleInfo)) && (!ndi.X(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) {
        break label1522;
      }
      if (paramArticleInfo.mSocialFeedInfo.iS == null) {
        break label3594;
      }
      paramInt1 = paramArticleInfo.mSocialFeedInfo.iS.size();
      localJSONObject.put("number", paramInt1 + 1);
      i = 0;
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT == null)) {
        break label1500;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() <= 1) {
        break label1431;
      }
      paramInt1 = 2;
      label384:
      localJSONObject.put("words", paramInt1);
      localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.mLikeCount);
      localJSONObject.put("comment", paramArticleInfo.mSocialFeedInfo.mCommentCount);
      localJSONObject.put("biu", paramArticleInfo.mSocialFeedInfo.aSI);
      label445:
      if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
        break label3599;
      }
      paramInt1 = 1;
      label460:
      localJSONObject.put("reddot_style", paramInt1);
      localJSONObject.put("feeds_type", a(paramArticleInfo));
      localJSONObject.put("kandian_mode", nR());
      localJSONObject.put("kandian_mode_new", kct.nd());
      localJSONObject.put("tab_source", paramInt4);
      localJSONObject.put("jump_to_channel", paramInt3);
      if ((paramArticleInfo != null) && (paramArticleInfo.feedsFirstExposurePos != -1)) {
        localJSONObject.put("card_pos", paramArticleInfo.feedsFirstExposurePos);
      }
      if (!awit.Q(getAppRuntime())) {
        break label3604;
      }
      paramInt1 = 1;
      label569:
      localJSONObject.put("hemera_switch", paramInt1);
      localJSONObject.put("proteus_bid", awit.sn("default_feeds_proteus_offline_bid"));
      paramString1 = awit.y("kd_topic_recommend_card_jump_switch");
      if (!(paramString1 instanceof Boolean)) {
        break label3574;
      }
      paramBoolean = ((Boolean)paramString1).booleanValue();
    }
    catch (JSONException paramString1)
    {
      label623:
      long l;
      paramString1.printStackTrace();
    }
    localJSONObject.put("jump_mode", paramString1);
    localJSONObject.put("star_logo", e(paramArticleInfo));
    l = 0L;
    paramLong = l;
    if (paramArticleInfo != null)
    {
      if ((!ndi.am(paramArticleInfo)) && (!ndi.X(paramArticleInfo)) && (!ndi.T(paramArticleInfo))) {
        break label1575;
      }
      paramLong = l;
      if (paramArticleInfo.mTopicRecommendFeedsInfo != null)
      {
        paramLong = l;
        if (paramArticleInfo.mTopicRecommendFeedsInfo.ld != null)
        {
          paramLong = l;
          if (paramArticleInfo.mTopicRecommendFeedsInfo.ld.size() > 0)
          {
            paramLong = l;
            if (paramArticleInfo.mTopicRecommendFeedsInfo.ld.get(0) != null) {
              paramLong = ((mih.b)paramArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).businessId;
            }
          }
        }
      }
      label763:
      if ((paramArticleInfo.recommentFlag & 0x1000) == 0) {
        break label1630;
      }
      localJSONObject.put("msg_back", "1");
    }
    for (;;)
    {
      localJSONObject.put("topicid", paramLong);
      if (kct.XU == null) {
        kct.XU = "3.4.4".replace(".", "");
      }
      localJSONObject.put("version", kct.XU);
      localJSONObject.put("os", "1");
      if (paramInt2 == 0) {
        localJSONObject.put("preload_flag", lhf.Cj());
      }
      if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 26))
      {
        if (!TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
          localJSONObject.put("touin", paramArticleInfo.mSubscribeID);
        }
        localJSONObject.put("uin", getLongAccountUin());
        if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a != null)) {
          localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a.aRt);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("ans_rowkey", paramString2);
        }
        if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a.agH))) {
          localJSONObject.put("rowkey", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a.agH);
        }
      }
      kct.e(localJSONObject);
      if (aqux.Mv() != 1) {
        break label3616;
      }
      paramString1 = "1";
      label1075:
      localJSONObject.put("simCardType", paramString1);
      if ((paramArticleInfo != null) && (paramArticleInfo.hotWordInfo != null) && (paramArticleInfo.mFeedType == 28))
      {
        if (paramArticleInfo.hotWordInfo.iN == null) {
          break label3623;
        }
        paramInt1 = paramArticleInfo.hotWordInfo.iN.size();
        label1134:
        localJSONObject.put("hotword_card_num", paramInt1);
      }
      if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 0L) && (p(paramArticleInfo)))
      {
        if (paramArticleInfo.mCommentCount > 100L) {
          break label3589;
        }
        if (paramArticleInfo.mVideoCommentCount <= 100) {
          break label3628;
        }
        break label3589;
        label1192:
        localJSONObject.put("comment_exposure", paramInt1);
      }
      if ((paramArticleInfo != null) && (ndi.P(paramArticleInfo)))
      {
        paramString1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c;
        if (paramString1 != null) {
          localJSONObject.put("ori_feeds_id", paramString1.y);
        }
      }
      paramInt1 = ReadInJoyBaseFragment.di(paramInt2);
      if (paramInt1 >= 0) {
        localJSONObject.put("entry_path", paramInt1);
      }
      if ((paramArticleInfo == null) || (paramArticleInfo.mProteusTemplateBean == null)) {
        break label1644;
      }
      paramString1 = paramArticleInfo.mProteusTemplateBean.getDataAttribute(null);
      if ((paramString1 == null) || (paramString1.entrySet() == null)) {
        break label1644;
      }
      paramString1 = paramString1.entrySet().iterator();
      while ((paramString1 != null) && (paramString1.hasNext()))
      {
        paramString3 = (Map.Entry)paramString1.next();
        paramString2 = (String)paramString3.getKey();
        paramString3 = paramString3.getValue();
        localJSONObject.put(paramString2, "" + paramString3);
      }
      label1402:
      return localJSONObject;
      label1405:
      paramInt1 = 1;
      break;
      label1410:
      paramString1 = kvs.acA;
      break label148;
      label1418:
      paramString1 = kvs.a(paramArticleInfo.mArticleID);
      break label178;
      label1431:
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() == 1)
      {
        paramInt1 = 1;
        break label384;
      }
      paramInt1 = i;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() != 0) {
        break label384;
      }
      paramInt1 = i;
      if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.ahL)) {
        break label384;
      }
      paramInt1 = 1;
      break label384;
      label1500:
      paramInt1 = i;
      if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.ahL)) {
        break label384;
      }
      paramInt1 = 1;
      break label384;
      label1522:
      localJSONObject.put("number", 0);
      localJSONObject.put("words", 0);
      localJSONObject.put("likes", 0);
      localJSONObject.put("comment", 0);
      localJSONObject.put("biu", 0);
      break label445;
      label1575:
      if ((r(paramArticleInfo)) && ((paramArticleInfo.mPolymericInfo.aRX == 7) || (paramArticleInfo.mPolymericInfo.aRX == 8)))
      {
        paramLong = paramArticleInfo.mPolymericInfo.vr;
        break label763;
      }
      paramLong = paramArticleInfo.businessId;
      break label763;
      label1630:
      localJSONObject.put("msg_back", "0");
    }
    label1644:
    if (kys.dv(paramInt2)) {
      localJSONObject.put("cmd", awit.Hf());
    }
    label1726:
    label1868:
    label1893:
    label1918:
    String str2;
    if (AS())
    {
      paramInt1 = 1;
      localJSONObject.put("interact_bar", paramInt1);
      paramBoolean = false;
      if (paramArticleInfo != null)
      {
        paramBoolean = paramArticleInfo.isPGCShortContent();
        if ((TextUtils.isEmpty(paramArticleInfo.proteusItemsData)) || (!paramArticleInfo.proteusItemsData.contains("article_main_body_text"))) {
          break label3660;
        }
        paramInt1 = 1;
        break label3633;
        paramString1 = odv.a(paramArticleInfo.mChannelID);
        if ((paramString1 != null) && (paramString1.get(Long.valueOf(paramArticleInfo.mArticleID)) != null))
        {
          localJSONObject.put("main_text_read_time", ((odv.b)paramString1.get(Long.valueOf(paramArticleInfo.mArticleID))).duringTime);
          break label3645;
          label1792:
          localJSONObject.put("short_content_rsc", paramInt1);
          paramString1 = new StringBuilder().append("");
          if (paramArticleInfo == null) {
            break label3673;
          }
          paramInt1 = paramArticleInfo.isSuperTop;
          label1827:
          localJSONObject.put("keep_top", paramInt1);
          if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramArticleInfo.mReportCommonData))) {
            break label3678;
          }
          paramString1 = paramArticleInfo.mReportCommonData;
          localJSONObject.put("report_common_data", paramString1);
          if (TextUtils.isEmpty(Build.BRAND)) {
            break label3685;
          }
          paramString1 = Build.BRAND;
          localJSONObject.put("device_brand", paramString1);
          if (TextUtils.isEmpty(Build.MODEL)) {
            break label3692;
          }
          paramString1 = Build.MODEL;
          localJSONObject.put("device_type", paramString1);
          if ((paramArticleInfo != null) && ((paramArticleInfo.isPGCShortContent()) || (paramArticleInfo.isAccountShown)))
          {
            localJSONObject.put("click_area", paramArticleInfo.click_area);
            paramArticleInfo.click_area = 0;
            localJSONObject.put("target", paramArticleInfo.click_jump_target);
            paramArticleInfo.click_jump_target = "-1";
            localJSONObject.put("short_content_size", ComponentPGCShortContentBig.agf);
            if (!paramArticleInfo.isShowGif) {
              break label2634;
            }
            localJSONObject.put("short_content_gif", 1);
            localJSONObject.put("gif_playmode", ComponentPGCShortContentBig.aQq);
          }
          localJSONObject.put("account_expose_card", c(paramArticleInfo));
          if (paramArticleInfo == null) {
            break label3699;
          }
          paramString1 = paramArticleInfo.getProteusItemData();
          label2060:
          if (paramString1 != null)
          {
            localJSONObject.put("jump_page", paramString1.optString("jump_page_fg_button"));
            localJSONObject.put("jump_src", paramString1.optString("jump_src_fg_button"));
          }
          if ((paramArticleInfo != null) && (paramArticleInfo.isPGCShortContent())) {
            localJSONObject.put("picture_click_jumptype", Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0));
          }
          if ((localJSONObject.has("jump_src")) || (!mgk.a().a(paramArticleInfo, false, mgk.aRi))) {
            break label2647;
          }
          localJSONObject.put("jump_src", mgn.j(paramArticleInfo));
          label2174:
          if ((paramInt2 == 0) && (paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.adReportCommonData))) {
            localJSONObject.put("bytes_ad_report_common_data", paramArticleInfo.adReportCommonData);
          }
          if (paramInt2 == 41695)
          {
            paramString1 = lbz.a().a();
            if (paramString1 != null)
            {
              paramString1 = paramString1.a();
              if (paramString1 != null)
              {
                localJSONObject.put("channel_city", paramString1.city);
                if (QLog.isColorLevel()) {
                  QLog.i("ReadInJoyUtils", 2, "reportReadArticle CHANNEL_ID_LOCAL r5Str = " + localJSONObject);
                }
              }
            }
          }
          if (paramArticleInfo != null)
          {
            if ((lhn.oC() == -1) || (lhn.oC() == 0)) {
              break label2681;
            }
            localJSONObject.put("mainfeeds_showcase", lhn.oC());
            localJSONObject.put("configchannel_name", lhn.jr());
          }
        }
        for (;;)
        {
          if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 34) && (paramArticleInfo.scripCmsInfo != null))
          {
            paramString3 = paramArticleInfo.scripCmsInfo;
            paramString2 = "";
            paramString1 = paramString2;
            if (BaseApplicationImpl.getApplication() != null)
            {
              paramString1 = paramString2;
              if (BaseApplicationImpl.getApplication().getRuntime() != null) {
                paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              }
            }
            localJSONObject.put("uin", paramString1);
            localJSONObject.put("fromuin", "" + paramString3.fromUin);
            localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
            localJSONObject.put("zhitiao_num_daily", ljp.n(BaseApplicationImpl.getApplication(), paramString1));
            localJSONObject.put("zhitiao_sum", mhz.aSE);
            localJSONObject.put("tag", paramString3.tag);
            localJSONObject.put("zhitiao_show", paramString3.showType);
          }
          if ((paramArticleInfo == null) || (paramArticleInfo.mFeedType != 35) || (paramArticleInfo.multiVideoColumnInfo == null)) {
            break label2784;
          }
          paramString1 = paramArticleInfo.multiVideoColumnInfo;
          localJSONObject.put("column_id", paramString1.aHc);
          if (paramString1.iO.size() <= 0) {
            break label2705;
          }
          paramString2 = new JsonArray();
          paramString3 = paramString1.iO.iterator();
          while (paramString3.hasNext()) {
            paramString2.add(((mie)paramString3.next()).rowKey);
          }
          localJSONObject.put("main_text_read_time", 0);
          break label3665;
          label2634:
          localJSONObject.put("short_content_gif", 0);
          break;
          label2647:
          if ((paramArticleInfo == null) || (!a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
            break label2174;
          }
          localJSONObject.put("jump_src", nV());
          break label2174;
          label2681:
          localJSONObject.put("mainfeeds_showcase", 0);
        }
        localJSONObject.put("all_rowkey", paramString2);
        label2705:
        paramInt1 = 0;
        if (paramString1.amw) {
          paramInt1 = 1;
        }
        localJSONObject.put("subscribe", paramInt1);
        paramString2 = a(paramArticleInfo.mArticleID);
        if (paramString2 != null) {
          localJSONObject.put("rowkey", paramString2);
        }
        if (!TextUtils.isEmpty(paramString1.d.WT)) {
          localJSONObject.put("jump_report_info", paramString1.d.WT);
        }
        label2784:
        if ((paramArticleInfo != null) && (paramArticleInfo.mNewPolymericInfo != null) && (paramArticleInfo.mNewPolymericInfo.aRX == 15))
        {
          localJSONObject.put("feeds_type", 1036);
          localJSONObject.put("feeds_size", paramArticleInfo.mNewPolymericInfo.aRZ);
          localJSONObject.put("feeds_head", paramArticleInfo.mNewPolymericInfo.aRY);
          localJSONObject.put("column_id", paramArticleInfo.mNewPolymericInfo.aHc);
          if (paramArticleInfo.mNewPolymericInfo.aRY == 3)
          {
            localJSONObject.put("column_id", paramArticleInfo.mNewPolymericInfo.aHc);
            localJSONObject.put("subscribe_flag", paramArticleInfo.mNewPolymericInfo.aSa);
          }
          localJSONObject.put("report_common_data", paramArticleInfo.mReportCommonData);
          paramString1 = a(paramArticleInfo.mArticleID);
          if (paramString1 != null) {
            localJSONObject.put("rowkey", paramString1);
          }
        }
        if (isFromAIO)
        {
          paramInt1 = 1;
          label2967:
          localJSONObject.put("from_aio", paramInt1);
          paramString3 = "";
          str2 = "";
          paramString2 = paramString3;
        }
        try
        {
          if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$b.rowKey)) {
            break label3466;
          }
          paramString2 = paramString3;
          paramString1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$b.rowKey;
          label3029:
          str1 = str2;
          paramString3 = paramString1;
          paramString2 = paramString1;
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$l.aig))
          {
            paramString2 = paramString1;
            str1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$l.aig;
            paramString3 = paramString1;
          }
        }
        catch (NullPointerException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            String str1 = str2;
            paramString3 = paramString2;
            continue;
            localJSONObject.put("is_column", "0");
            continue;
            localJSONObject.put("istopic", 0);
            continue;
            paramInt1 = 0;
            continue;
            paramInt1 = 2050;
          }
        }
        if (!TextUtils.isEmpty(paramString3)) {
          localJSONObject.put("rowkey1", paramString3);
        }
        if (!TextUtils.isEmpty(str1)) {
          localJSONObject.put("url", str1);
        }
        if ((paramArticleInfo != null) && (paramArticleInfo.columnEntrances != null) && (paramArticleInfo.columnEntrances.size() > 0))
        {
          paramString1 = (VideoColumnInfo)paramArticleInfo.columnEntrances.get(0);
          if (paramString1.aHc == 0) {
            break label3535;
          }
          localJSONObject.put("is_column", "1");
          localJSONObject.put("column_id", String.valueOf(paramString1.aHc));
          if (!paramString1.amw) {
            break label3705;
          }
        }
      }
    }
    label3466:
    label3535:
    label3562:
    label3567:
    label3574:
    label3705:
    for (paramString1 = "1";; paramString1 = "2")
    {
      localJSONObject.put("subscribe_flag", paramString1);
      localJSONObject.put("default_feeds_aladdin_keys", awit.f("default_feeds_aladdin_keys", ""));
      if ((paramArticleInfo != null) && (paramArticleInfo.mArticleID > 0L)) {
        localJSONObject.put("is_push", a(Long.valueOf(paramArticleInfo.mArticleID)));
      }
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo.uint32_is_topic.has()))
      {
        localJSONObject.put("istopic", 1);
        if (!paramArticleInfo.hasWalletIcon) {
          break label3562;
        }
        paramInt1 = 1;
        localJSONObject.put("is_redpack", paramInt1);
        if ((paramArticleInfo.mFeedType != 38) && (paramArticleInfo.mFeedType != 39)) {
          break label1402;
        }
        if (paramArticleInfo.mSmallMiniGameInfo != null) {
          localJSONObject.put("gamelist", paramArticleInfo.mSmallMiniGameInfo.abd + "," + paramArticleInfo.mSmallMiniGameInfo.abe + "," + paramArticleInfo.mSmallMiniGameInfo.abf);
        }
        if (paramArticleInfo.mFeedType != 38) {
          break label3567;
        }
        paramInt1 = 2051;
        localJSONObject.put("feeds_type", paramInt1);
        return localJSONObject;
        paramInt1 = 0;
        break label2967;
        paramString1 = paramString3;
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.rowkey)) {
          break label3029;
        }
        paramString2 = paramString3;
        paramString1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.rowkey;
        break label3029;
      }
      paramBoolean = false;
      if (paramBoolean)
      {
        paramString1 = "2";
        break label623;
        paramInt1 = 1;
        break label1192;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label460;
        paramInt1 = 0;
        break label569;
      }
      paramString1 = "1";
      break label623;
      paramString1 = "0";
      break label1075;
      paramInt1 = 0;
      break label1134;
      paramInt1 = 2;
      break label1192;
      if (!paramBoolean)
      {
        if (paramInt1 == 0) {
          break label3665;
        }
        break label1726;
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label3668;
        }
        paramInt1 = 1;
        break label1792;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label3633;
        break label1726;
      }
      paramInt1 = 0;
      break label1792;
      paramInt1 = 0;
      break label1827;
      paramString1 = "";
      break label1868;
      paramString1 = "";
      break label1893;
      paramString1 = "";
      break label1918;
      paramString1 = null;
      break label2060;
    }
  }
  
  public static JSONObject a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("algorithm_id", paramArticleInfo.mAlgorithmID);
        localJSONObject.put("puin_type", paramString);
        localJSONObject.put("feeds_type", a(paramArticleInfo));
        localJSONObject.put("source", dc(paramInt));
        localJSONObject.put("is_fans", c(paramArticleInfo));
        localJSONObject.put("kandian_mode", nR());
        localJSONObject.put("session_id", adt);
        localJSONObject.put("mp_article_id", paramArticleInfo.mArticleID);
        localJSONObject.put("channel_id", paramInt);
        if (aqiw.isWifiConnected(paramContext))
        {
          paramInt = 1;
          localJSONObject.put("network_type", paramInt);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "3.4.4".replace(".", ""));
          localJSONObject.put("imei", iT());
          localJSONObject.put("imsi", iU());
          if (g(paramArticleInfo))
          {
            localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.mLikeCount);
            localJSONObject.put("biu", paramArticleInfo.mSocialFeedInfo.aSI);
            return localJSONObject;
          }
          localJSONObject.put("likes", 0);
          localJSONObject.put("biu", 0);
          return localJSONObject;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return localJSONObject;
      }
      paramInt = 2;
    }
  }
  
  public static JSONObject a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = a(paramContext, paramArticleInfo, paramInt1, paramString);
    try
    {
      paramContext.put("biu_state", paramInt2);
      return paramContext;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return paramContext;
  }
  
  public static JSONObject a(String paramString1, String paramString2, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("hotword", paramString1);
      localJSONObject.put("rowKey", paramString2);
      localJSONObject.put("hotword_number", paramInt);
      localJSONObject.put("jump_type", 0);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      QLog.e("ReadInJoyUtils", 1, "transMergeKandianPeportR5WithTime, hotword = , rowKey = " + paramString2 + ", hotword_number = " + paramInt + ", jump_type = " + 0);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(mhs parammhs)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", aMw);
        localJSONObject.put("kandian_mode", String.valueOf(nR()));
        localJSONObject.put("tab_source", nQ());
        i = -1;
        switch (parammhs.aRX)
        {
        default: 
          localJSONObject.put("use_type", i);
          if (i == 2)
          {
            l = parammhs.uin;
            localJSONObject.put("type_id", l);
            localJSONObject.put("algorithm_id", parammhs.algorithmID);
            return localJSONObject;
          }
          long l = parammhs.vr;
          continue;
          continue;
        }
      }
      catch (JSONException parammhs)
      {
        parammhs.printStackTrace();
        return localJSONObject;
      }
      int i = 2;
      continue;
      i = 1;
      continue;
      i = 3;
    }
  }
  
  public static void a(float paramFloat, Resources paramResources)
  {
    if ((paramFloat == 0.0F) || (paramResources == null)) {
      return;
    }
    aMt = (int)(paramFloat / paramResources.getDimensionPixelSize(2131299267) + 0.5F);
  }
  
  public static void a(int paramInt, long paramLong, mye.b paramb, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    nce.a locala = new nce.a("", "", "", "").a(paramInt).b(paramLong);
    if (paramb != null) {
      locala.e(paramb.algorithmID).c(paramb.strategyId);
    }
    if (paramBaseArticleInfo != null) {
      locala.g(paramBaseArticleInfo.innerUniqueID).F(a(paramBaseArticleInfo));
    }
    if (paramBoolean) {}
    for (paramb = "1";; paramb = "0")
    {
      kbp.a(null, "", "0X8007DBB", "0X8007DBB", 0, 0, paramb, "", "", locala.a().toJsonString(), false);
      return;
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mOperation = paramInt1;
      localReportInfo.mSourceArticleId = Long.valueOf(paramString1).longValue();
      localReportInfo.mAlgorithmId = Integer.valueOf(paramString3).intValue();
      localReportInfo.mStrategyId = Integer.valueOf(paramString2).intValue();
      localReportInfo.mUin = getLongAccountUin();
      if (TextUtils.isEmpty(paramString4)) {}
      for (long l = -1L;; l = Long.valueOf(paramString4).longValue())
      {
        localReportInfo.mPuin = l;
        paramInt1 = paramInt2;
        if (paramInt2 == -1) {
          paramInt1 = aMw;
        }
        localReportInfo.mFolderStatus = paramInt1;
        localArrayList.add(localReportInfo);
        new ljc(null, null, lun.a(), null).cB(localArrayList);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("ReadInJoyUtils", 1, "reportRealTimeKandianAction error ", paramString1);
    }
  }
  
  public static void a(int paramInt, List<TopicInfo> paramList, String paramString)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TopicInfo localTopicInfo = (TopicInfo)paramList.next();
        if (localTopicInfo != null) {
          a("0X8009817", paramInt, localTopicInfo.cO(), paramString);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if ((paramArticleInfo.mArticleContentUrl != null) && (paramArticleInfo.mArticleContentUrl.startsWith("mqqapi:")))
    {
      C(paramActivity, paramArticleInfo.mArticleContentUrl);
      b(paramArticleInfo, paramArticleInfo.mArticleContentUrl);
      return;
    }
    nnw.J("FastWebActivity.show");
    lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
    Intent localIntent = new Intent(paramActivity, FastWebActivity.class);
    localIntent.putExtra("fast_web_article_info", paramArticleInfo);
    paramActivity.startActivityForResult(localIntent, 10922);
    QLog.d("ReadInJoyUtils", 1, "startWebFastActivity, rowkey= " + paramArticleInfo.innerUniqueID);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, ndi paramndi, int paramInt)
  {
    a(paramActivity, paramArticleInfo, paramndi, paramInt);
    lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramndi.notifyDataSetChanged();
    if (oub.ad(paramArticleInfo))
    {
      paramndi = new Intent(paramActivity, PublicAccountImageCollectionMainActivity.class);
      paramndi.putExtra("source_for_report", 9);
      oub.a(paramActivity, paramndi, String.valueOf(paramArticleInfo.innerUniqueID));
      return;
    }
    paramInt = paramndi.nh();
    long l = paramArticleInfo.mRecommendSeq;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (ndi.al(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!ndi.ap(paramArticleInfo)) {
        localObject1 = ((mih.b)paramArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0)).businessUrl;
      }
    }
    localObject2 = localObject1;
    if (!(paramArticleInfo instanceof AdvertisementInfo)) {
      if (!((String)localObject1).contains("?")) {
        break label229;
      }
    }
    label229:
    for (localObject1 = (String)localObject1 + "&";; localObject1 = (String)localObject1 + "?")
    {
      localObject2 = (String)localObject1 + "from=0";
      if (!dC((String)localObject2)) {
        break;
      }
      aL(paramActivity, (String)localObject2);
      return;
    }
    localBundle.putString("url", (String)localObject2);
    localBundle.putBoolean("hide_operation_bar", true);
    localBundle.putString("from", String.valueOf(53));
    localBundle.putString("subscribename", paramArticleInfo.mSubscribeName);
    localBundle.putLong("articleid", paramArticleInfo.mArticleID);
    localBundle.putLong("recommendSeq", l);
    localBundle.putInt("channelid", paramInt);
    localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
    localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
    localBundle.putInt("articalChannelId", 9);
    localBundle.putStringArray("insertPluginsArray", new String[] { "pubAccountPreload" });
    localBundle.putBoolean("ip_connect", obt.aec);
    l = System.currentTimeMillis();
    localBundle.putLong("startOpenPageTime", l);
    localBundle.putLong("click_time", l);
    localBundle.putLong("available_memory", aqgz.getSystemAvaialbeMemory());
    localBundle.putBoolean("preload_tool_white_list", AO());
    Intent localIntent = new Intent(paramActivity, ReadInJoyArticleDetailActivity.class);
    localObject2 = PreloadManager.fk((String)localObject2);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if ((aqhq.fileExistsAndNotEmpty(acbn.bnB + (String)localObject1)) && (PreloadManager.a().k((String)localObject1) != null))
    {
      localBundle.putString("read_in_joy_from_cache", (String)localObject1);
      if (!paramndi.m(paramInt, paramArticleInfo.mArticleID))
      {
        paramArticleInfo = PreloadManager.a();
        if ((NetworkState.getNetworkType() != 1) && (NetworkState.getNetworkType() != 4) && (NetworkState.getNetworkType() != 5)) {
          break label655;
        }
        paramndi = paramArticleInfo.s((String)localObject1);
        if ((paramndi != null) && (paramndi.size() > 0))
        {
          ThreadManager.post(new ReadInJoyUtils.22(paramArticleInfo, (PreloadManager.a)paramndi.get(0)), 5, null, false);
          if (paramndi.size() <= 1) {
            break label643;
          }
          localBundle.putString("preload_iamge_url", ((PreloadManager.a)paramndi.get(1)).url);
        }
      }
    }
    for (;;)
    {
      localIntent.putExtras(localBundle);
      paramActivity.startActivityForResult(localIntent, 9991);
      return;
      label643:
      localBundle.putString("preload_iamge_url", null);
      continue;
      label655:
      paramArticleInfo = paramArticleInfo.s((String)localObject1);
      if ((paramArticleInfo != null) && (paramArticleInfo.size() > 0)) {
        localBundle.putString("preload_iamge_url", ((PreloadManager.a)paramArticleInfo.get(0)).url);
      } else {
        localBundle.putString("preload_iamge_url", null);
      }
    }
  }
  
  public static void a(Activity paramActivity, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    UniteSearchActivity.a(paramActivity, "", 25, 0L, paramHotSearchItem, 0);
    kbp.a(null, "CliOper", "", "", "0X80067D3", "0X80067D3", 0, 0, "", "", "", iQ(), false);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, SystemBarCompact paramSystemBarCompact)
  {
    if ((paramActivity == null) || (paramSystemBarCompact == null)) {}
    while ((!paramBoolean) || (ImmersiveUtils.isSupporImmersive() != 1)) {
      return;
    }
    paramActivity.getWindow().addFlags(67108864);
    paramSystemBarCompact.init();
    if (ThemeUtil.isNowThemeIsNight(getAppRuntime(), false, null))
    {
      if ((!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        paramSystemBarCompact.setStatusBarColor(-7829368);
        return;
      }
      paramSystemBarCompact.setStatusBarColor(-7829368);
      paramSystemBarCompact.setStatusBarDarkMode(true);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      e(paramActivity, true);
      paramSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!aqfo.isFlyme())
    {
      paramSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    paramSystemBarCompact.setStatusBarColor(-1);
    paramSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    a(paramContext, paramInt, paramBoolean, "");
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)getAppRuntime().getManager(162);
    int i = localKandianMergeManager.oj();
    Object localObject1 = localKandianMergeManager.a();
    String str;
    if ((localObject1 == null) || (TextUtils.isEmpty(((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl)))
    {
      str = kwt.acG + i + "&message_entry=" + paramInt;
      localObject1 = ntp.c(getAppRuntime()) + "&adtag=1&privateLetters=" + i + "&message_entry=" + paramInt;
      Object localObject2 = localObject1;
      if (paramBoolean)
      {
        i = aqcx.px2dip(paramContext, (float)aqgz.getHeight()) / 3;
        localObject2 = (String)localObject1 + "&v_present_radius=10&v_present=2&v_rij_floating=1&v_present_bar=0&v_nav_immer=1&hideNav=1&v_present_auto_top=0&v_present_top=" + i;
      }
      if (!TextUtils.isEmpty(paramString)) {
        new StringBuilder().append((String)localObject2).append("&msgId=").append(paramString).toString();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "person message box url: " + str);
      }
      if (!Boolean.valueOf(awit.H(getAppRuntime())).booleanValue()) {
        break label401;
      }
      paramContext = new Bundle();
      if (paramInt != 6) {
        break label391;
      }
      paramInt = 2;
    }
    for (;;)
    {
      label265:
      if (paramInt != -1) {
        paramContext.putInt("floating_window_scene", paramInt);
      }
      paramContext.putInt("requestCode", 20001);
      for (;;)
      {
        ThreadManager.excute(new ReadInJoyUtils.21(localKandianMergeManager), 64, null, true);
        return;
        str = ((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl + "&privateLetters=" + i + "&message_entry=" + paramInt;
        localObject1 = ntp.c(getAppRuntime()) + "&adtag=2&privateLetters=" + i + "&message_entry=" + paramInt;
        break;
        label391:
        if (paramInt != 5) {
          break label429;
        }
        paramInt = 3;
        break label265;
        label401:
        paramString = new Bundle();
        paramString.putInt("requestCode", 20001);
        a(paramContext, str, paramString);
      }
      label429:
      paramInt = -1;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
    {
      paramArticleInfo = Uri.parse(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8()).buildUpon();
      paramArticleInfo.appendQueryParameter("showComment", "1");
      paramArticleInfo = paramArticleInfo.toString();
      C(paramContext, paramArticleInfo);
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyUtils", 2, "jumpToGallery url=" + paramArticleInfo);
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramContext, paramArticleInfo, paramInt, false, 0, false);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyUtils", 1, "jumpNewSocialSecondPage: " + paramArticleInfo + " type: " + paramInt1 + " shallNotReport: " + paramBoolean + " from: " + paramInt2 + " jumpType: " + paramInt3);
    if ((paramContext == null) || (paramArticleInfo == null)) {
      return;
    }
    jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    Object localObject3 = kwt.acD;
    Object localObject1;
    if (((String)localObject3).contains("uin=")) {
      if ((paramInt1 == 0) || (paramInt1 == 6) || (paramInt1 == 8))
      {
        if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null)) {
          break label1392;
        }
        localObject1 = ((String)localObject3).replace("uin=", "uin=" + aqgo.encodeToString(String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin).getBytes(), 0).replace('\n', ' ').trim());
      }
    }
    for (;;)
    {
      label190:
      localObject3 = localObject1;
      label279:
      Object localObject4;
      label365:
      boolean bool;
      if (((String)localObject1).contains("&feedstype="))
      {
        if (((!ndi.S(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) || ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 5) || (paramInt1 == 7))) {
          localObject3 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z);
        }
      }
      else
      {
        localObject4 = Long.valueOf(0L);
        if ((paramInt1 != 3) && (paramInt1 != 5) && (paramInt1 != 2) && (paramInt1 != 7)) {
          break label1259;
        }
        localObject1 = localObject4;
        if (paramArticleInfo.mSocialFeedInfo != null)
        {
          localObject1 = localObject4;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null) {
            localObject1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y;
          }
        }
        localObject1 = (String)localObject3 + localObject1;
        localObject4 = new Bundle();
        if (msg.J(paramArticleInfo))
        {
          localObject3 = msg.a();
          if ((paramInt1 != 1) && (paramInt1 != 3)) {
            break label1293;
          }
          bool = true;
          label399:
          ((msg)localObject3).a(paramArticleInfo, bool, (String)localObject1);
        }
        localObject3 = localObject1;
        if (paramInt3 >= 0) {
          localObject3 = (String)localObject1 + "&jumptype=" + paramInt3;
        }
        QLog.d("ReadInJoyUtils", 1, "jumpNewSocialSecondPage, url:" + (String)localObject3);
        a(paramContext, (String)localObject3, (Bundle)localObject4);
        if ((paramBoolean) || ((!g(paramArticleInfo)) && (!ndi.K(paramArticleInfo)) && (!ndi.ak(paramArticleInfo)) && (!ndi.S(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo)))) {
          break;
        }
        paramContext = "";
      }
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", aMw);
          if (paramInt1 != 1) {
            continue;
          }
          ((JSONObject)localObject1).put("feeds_source", paramArticleInfo.mSubscribeID);
          ((JSONObject)localObject1).put("rowkey", paramArticleInfo.innerUniqueID);
          ((JSONObject)localObject1).put("feeds_type", "" + a(paramArticleInfo));
          ((JSONObject)localObject1).put("kandian_mode", "" + nR());
          ((JSONObject)localObject1).put("tab_source", "" + nQ());
          if (paramInt2 > 0) {
            ((JSONObject)localObject1).put("entry_mode", "" + paramInt2);
          }
          ((JSONObject)localObject1).put("channel_id", "" + paramArticleInfo.mChannelID);
          ((JSONObject)localObject1).put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
          localObject1 = ((JSONObject)localObject1).toString();
          paramContext = (Context)localObject1;
        }
        catch (JSONException localJSONException)
        {
          long l;
          label1259:
          localJSONException.printStackTrace();
          label1293:
          continue;
          localObject2 = "0X8007B64";
          continue;
          kbp.a(null, paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramContext, false);
          return;
        }
        if (!odv.aT(paramArticleInfo.mChannelID)) {
          continue;
        }
        localObject1 = "0X800935D";
        if ((!ndi.ak(paramArticleInfo)) && (!ndi.S(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) {
          continue;
        }
        if (ndi.Y(paramArticleInfo)) {
          break;
        }
        kbp.a(null, String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(paramArticleInfo.mFeedId), "0", "" + paramArticleInfo.mStrategyId, paramContext, false);
        return;
        if ((paramInt1 == 1) || (paramInt1 == 3))
        {
          localObject4 = paramArticleInfo.mSubscribeID;
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = "";
          }
          localObject1 = ((String)localObject3).replace("uin=", "uin=" + aqgo.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());
          break label190;
        }
        if ((paramInt1 == 2) || (paramInt1 == 4))
        {
          if (ndi.Y(paramArticleInfo)) {
            break label1392;
          }
          l = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
          localObject1 = ((String)localObject3).replace("uin=", "uin=" + aqgo.encodeToString(String.valueOf(l).getBytes(), 0).replace('\n', ' ').trim());
          break label190;
        }
        if (paramInt1 == 5)
        {
          l = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
          localObject1 = ((String)localObject3).replace("uin=", "uin=" + aqgo.encodeToString(String.valueOf(l).getBytes(), 0).replace('\n', ' ').trim());
          break label190;
        }
        if (paramInt1 != 7) {
          break label1392;
        }
        localObject1 = "";
        if (!ndi.Y(paramArticleInfo))
        {
          localObject1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin);
          localObject1 = ((String)localObject3).replace("uin=", "uin=" + aqgo.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());
          break label190;
        }
        if (!TextUtils.isEmpty(paramArticleInfo.mSubscribeID))
        {
          localObject1 = paramArticleInfo.mSubscribeID;
          continue;
          localObject3 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mFeedType);
          break label279;
          l = paramArticleInfo.mFeedId;
          localObject1 = (String)localObject3 + Long.valueOf(l);
          break label365;
          bool = false;
          break label399;
          ((JSONObject)localObject1).put("feeds_source", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
        }
      }
      label1392:
      Object localObject2 = localObject3;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (int i = 2;; i = 0)
    {
      a(paramContext, paramArticleInfo, paramInt1, paramBoolean1, paramInt2, i);
      return;
    }
  }
  
  @Deprecated
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, ndi paramndi, int paramInt)
  {
    if ((paramArticleInfo == null) || (paramndi == null)) {
      return;
    }
    int m = paramndi.nh();
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label577;
      }
    }
    Object localObject;
    label577:
    for (int j = 0;; j = 1)
    {
      paramndi = f(paramArticleInfo);
      kbp.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), m, i), false);
      kbp.d("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, i));
      localObject = odv.aB(m);
      kbp.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject, (String)localObject, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), m, i, j, aqiw.isWifiConnected(paramContext), paramndi, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, h(paramArticleInfo), paramArticleInfo), false);
      kbp.d((String)localObject, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), m, i, j, aqiw.isWifiConnected(paramContext), paramndi, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, h(paramArticleInfo), paramArticleInfo));
      paramContext = new ArrayList();
      paramndi = new ReportInfo();
      paramndi.mUin = getLongAccountUin();
      paramndi.mSource = 0;
      paramndi.mSourceArticleId = paramArticleInfo.mArticleID;
      paramndi.mChannelId = m;
      paramndi.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      paramndi.mStrategyId = paramArticleInfo.mStrategyId;
      paramndi.mOperation = 1;
      paramndi.mServerContext = paramArticleInfo.mServerContext;
      paramndi.mReadTimeLength = -1;
      paramndi.mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!mgn.Z(paramArticleInfo)) && (!kxj.a().AH()) && (a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        paramndi.noDifferenceJump = 1;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label589;
      }
      localObject = new ReportInfo.a();
      ((ReportInfo.a)localObject).vd = paramArticleInfo.mSocialFeedInfo.mFeedId;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
        ((ReportInfo.a)localObject).vg = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
      }
      ((ReportInfo.a)localObject).aSx = paramArticleInfo.mSocialFeedInfo.mLikeCount;
      ((ReportInfo.a)localObject).aSy = paramArticleInfo.mSocialFeedInfo.mCommentCount;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.iS;
      if ((paramArticleInfo == null) || (paramArticleInfo.isEmpty())) {
        break label583;
      }
      ((ReportInfo.a)localObject).iR = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        SocializeFeedsInfo.e locale = (SocializeFeedsInfo.e)paramArticleInfo.next();
        if (locale != null) {
          ((ReportInfo.a)localObject).iR.add(Long.valueOf(locale.uin));
        }
      }
      i = 0;
      break;
    }
    label583:
    paramndi.mFeedsReportData = ((ReportInfo.a)localObject);
    label589:
    paramArticleInfo = kxj.a().a();
    if (paramArticleInfo != null) {
      paramndi.srtClickInfo = paramArticleInfo;
    }
    paramContext.add(paramndi);
    lbz.a().cb(paramContext);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    a(paramContext, paramArticleInfo, 0, false, 0, paramBoolean);
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramContext != null) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null)) {}
    try
    {
      kgj localkgj = paramBaseArticleInfo.mSocialFeedInfo.b;
      b(localkgj, paramBaseArticleInfo);
      a(paramContext, localkgj);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramString = a(paramBaseArticleInfo, paramString);
    QLog.d("ReadInJoyUtils", 1, "jumpTo |  scheme : " + paramString);
    b(paramBaseArticleInfo, paramString);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      QLog.d("ReadInJoyUtils", 1, "context or scehme null");
    }
    while (lfw.F(paramContext, paramString)) {
      return;
    }
    a(paramContext, paramString, null);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    QLog.d("ReadInJoyUtils", 1, "jumTo: " + paramString + " extraData: " + paramBundle);
    if ((paramContext == null) || (paramString == null)) {}
    do
    {
      return;
      if (!(paramContext instanceof BasePluginActivity)) {
        break;
      }
      paramContext = ((BasePluginActivity)paramContext).getOutActivity();
    } while (paramContext == null);
    for (;;)
    {
      Object localObject = ntp.fd(paramString);
      if ((ntp.ek(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        ntp.b(paramContext, null, (String)localObject, paramBundle);
        return;
      }
      if ((paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) || (paramString.startsWith("http://clientui.3g.qq.com/mqq/")) || (paramString.startsWith("http://qm.qq.com/cgi-bin/")) || (paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("url", paramString);
          ((Bundle)localObject).putBoolean("hide_operation_bar", true);
          paramString = new Intent(paramContext, QQBrowserActivity.class);
          paramString.putExtra("big_brother_source_key", bg(0));
          paramString.putExtras((Bundle)localObject);
          paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
          if (paramBundle != null)
          {
            paramString.putExtras(paramBundle);
            if ((paramBundle.containsKey("requestCode")) && ((paramContext instanceof Activity)))
            {
              ((Activity)paramContext).startActivityForResult(paramString, paramBundle.getInt("requestCode", -1));
              return;
            }
          }
          paramContext.startActivity(paramString);
          return;
        }
        paramBundle = new Intent(paramContext, JumpActivity.class);
        paramString = Uri.parse(paramString);
        paramBundle.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        paramBundle.putExtra("big_brother_source_key", bg(0));
        paramBundle.setData(paramString);
        paramContext.startActivity(paramBundle);
        return;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    ThreadManager.post(new ReadInJoyUtils.6(paramContext, paramString, paramHashMap), 5, null, true);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(Y(paramContext)));
    ThreadManager.post(new ReadInJoyUtils.4(paramHashMap, paramBoolean, paramContext, paramString), 5, null, true);
  }
  
  public static void a(Context paramContext, kgj paramkgj)
  {
    if ((paramContext != null) && (paramkgj != null) && (!TextUtils.isEmpty(paramkgj.mJumpUrl)))
    {
      if (1 == paramkgj.aIC) {
        C(paramContext, paramkgj.mJumpUrl);
      }
      kbp.a(null, null, "0X8009BD5", "0X8009BD5", 0, 0, "", "", "", paramkgj.jdMethod_if(), false);
    }
  }
  
  public static void a(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2)
  {
    paramView2.post(new ReadInJoyUtils.19(paramView1, paramInt1, paramInt2, paramInt3, paramInt4, paramView2));
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    for (;;)
    {
      try
      {
        if ((paramBaseArticleInfo.mDislikeInfos == null) || (paramBaseArticleInfo.mDislikeInfos.size() <= 0)) {
          paramBaseArticleInfo.mDislikeInfos = DislikeInfo.r(paramBaseArticleInfo.mDiskLikeInfoString);
        }
        paramBaseArticleInfo.mPictures = a(paramBaseArticleInfo.mJsonPictureList, paramBaseArticleInfo);
        if ((ndi.al(paramBaseArticleInfo)) && (!ndi.ap(paramBaseArticleInfo)))
        {
          paramBaseArticleInfo.mSinglePicture = a(((mih.b)paramBaseArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0)).picUrl, true, true);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "preParseArticleJsonParam mJsonVideoList = " + paramBaseArticleInfo.mJsonVideoList);
          }
          if (TextUtils.isEmpty(paramBaseArticleInfo.mJsonVideoList)) {
            break label539;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "preParseArticleJsonParam article.mArticleID:" + paramBaseArticleInfo.mArticleID + " article.mTitle:" + paramBaseArticleInfo.mTitle + " article.mSummary:" + paramBaseArticleInfo.mSummary + "mJsonVideoList:" + paramBaseArticleInfo.mJsonVideoList);
          }
          paramBaseArticleInfo.mVideoCoverUrl = a(paramBaseArticleInfo, paramBaseArticleInfo.mJsonVideoList);
          localObject = a(paramBaseArticleInfo.mJsonVideoList, paramBaseArticleInfo);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = ((String)localObject).split(";");
            paramBaseArticleInfo.mVideoVid = localObject[0];
            paramBaseArticleInfo.mVideoDuration = Integer.valueOf(localObject[1]).intValue();
            paramBaseArticleInfo.thirdIcon = localObject[2];
            paramBaseArticleInfo.thirdName = localObject[3];
            paramBaseArticleInfo.thirdAction = localObject[4];
            if ((paramBaseArticleInfo.mFeedType != 3) && (TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))) {
              paramBaseArticleInfo.innerUniqueID = localObject[5];
            }
            paramBaseArticleInfo.busiType = Integer.valueOf(localObject[6]).intValue();
            paramBaseArticleInfo.mVideoJsonWidth = Integer.valueOf(localObject[7]).intValue();
            paramBaseArticleInfo.mVideoJsonHeight = Integer.valueOf(localObject[8]).intValue();
            paramBaseArticleInfo.thirdUin = localObject[9];
            paramBaseArticleInfo.thirdUinName = localObject[10];
            paramBaseArticleInfo.mXGFileSize = Long.valueOf(localObject[11]).longValue();
            paramBaseArticleInfo.mThirdVideoURL = localObject[12];
            paramBaseArticleInfo.mThirdVideoURLExpireTime = Long.valueOf(localObject[13]).longValue();
          }
          a(paramBaseArticleInfo, paramBaseArticleInfo.mJsonVideoList);
          return;
        }
        if (((paramBaseArticleInfo instanceof ArticleInfo)) && ((ndi.K((ArticleInfo)paramBaseArticleInfo)) || (ndi.P((ArticleInfo)paramBaseArticleInfo))))
        {
          paramBaseArticleInfo.mSinglePicture = a(paramBaseArticleInfo.mFirstPagePicUrl, ndi.Q((ArticleInfo)paramBaseArticleInfo), true);
          continue;
        }
        if (!k(paramBaseArticleInfo)) {
          break;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        paramBaseArticleInfo.printStackTrace();
        return;
      }
      if (paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() != 1) {
        break;
      }
      paramBaseArticleInfo.mSinglePicture = b(paramBaseArticleInfo.mFirstPagePicUrl, ndi.Q((ArticleInfo)paramBaseArticleInfo), true);
    }
    Object localObject = paramBaseArticleInfo.mFirstPagePicUrl;
    boolean bool2 = paramBaseArticleInfo.mShowBigPicture;
    if (paramBaseArticleInfo.mVideoType == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramBaseArticleInfo.mSinglePicture = a((String)localObject, bool2, bool1);
      break;
      label539:
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!ndi.aa((ArticleInfo)paramBaseArticleInfo))) {
        paramBaseArticleInfo.busiType = ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aSY;
      }
      return;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return;
    }
    paramBaseArticleInfo.setFirstFrameUrl(b(paramString.optString("first_frame")));
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, mgu parammgu)
  {
    if ((paramBaseArticleInfo == null) || (!z(paramBaseArticleInfo))) {
      return;
    }
    parammgu = new nce.a(null, null, null, null).W(Integer.valueOf("2007").intValue());
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    parammgu.r(paramBaseArticleInfo.mKdLiveInfo.aha);
    kbp.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", parammgu.a().toJsonString(), false);
    parammgu.r(localBaseArticleInfo.mKdLiveInfo.aha);
    kbp.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", parammgu.a().toJsonString(), false);
  }
  
  public static void a(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord, Intent paramIntent)
  {
    label713:
    label733:
    label739:
    label746:
    label752:
    label758:
    label764:
    for (;;)
    {
      try
      {
        localMessageRecord = paramQQMessageFacade.d(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (localMessageRecord != null)
        {
          if (TextUtils.isEmpty(localMessageRecord.extStr)) {
            continue;
          }
          localObject1 = new JSONObject(localMessageRecord.extStr);
          ((JSONObject)localObject1).put("sp_last_locksc_kadnian_red_pnt_exposure_time_key", NetConnInfoCenter.getServerTime());
          localMessageRecord.extStr = ((JSONObject)localObject1).toString();
          paramQQMessageFacade.a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, "extStr", localMessageRecord.extStr);
        }
        if (!(localMessageRecord instanceof MessageForStructing)) {
          break label758;
        }
        localMessageForStructing = (MessageForStructing)localMessageRecord;
        if (localMessageForStructing.structingMsg != null) {
          break label764;
        }
        localMessageForStructing.parse();
      }
      catch (JSONException paramQQMessageFacade)
      {
        MessageRecord localMessageRecord;
        Object localObject4;
        Object localObject3;
        QLog.d("ReadInJoyUtils", 1, "reportForLockScreenExposure parse json error");
        return;
        if (localMessageRecord.extInt != 5) {
          break label713;
        }
        localObject1 = "";
        str = "";
        paramQQMessageFacade = "0";
        localObject2 = "";
        paramIntent = "0";
        continue;
      }
      catch (NumberFormatException paramQQMessageFacade)
      {
        QLog.d("ReadInJoyUtils", 1, "reportForLockScreenExposure number format error");
        return;
      }
      if ((localMessageForStructing != null) && (localMessageForStructing.extInt == 1))
      {
        if (localMessageForStructing.structingMsg == null) {
          break label713;
        }
        if (TextUtils.isEmpty(localMessageForStructing.structingMsg.mArticleIds)) {
          break label752;
        }
        paramQQMessageFacade = localMessageForStructing.structingMsg.mArticleIds.split("\\|")[0];
        if (localMessageForStructing.structingMsg.mStrategyIds == null) {
          break label746;
        }
        localObject1 = localMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
        if (localMessageForStructing.structingMsg.mAlgorithmIds == null) {
          break label739;
        }
        str = localMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
        if (localMessageForStructing.structingMsg.mExtraData != null) {
          paramIntent.putExtra("arg_channel_cover_id", Integer.parseInt(new JSONObject(localMessageForStructing.structingMsg.mExtraData).optString("channel_id", "0")));
        }
        if (TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgActionData)) {
          break label733;
        }
        paramIntent = new JSONObject(localMessageForStructing.structingMsg.mMsgActionData).optString("push_rowkey");
        localObject4 = localMessageForStructing.structingMsg.reportEventFolderStatusValue;
        localObject3 = localObject1;
        localObject2 = paramIntent;
        localObject1 = localObject4;
        paramIntent = (Intent)localObject3;
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("algorithm_id", str);
        ((JSONObject)localObject3).put("rowkey", localObject2);
        ((JSONObject)localObject3).put("folder_status", localObject1);
        ((JSONObject)localObject3).put("report_time", NetConnInfoCenter.getServerTimeMillis());
        if (!localMessageRecord.isread)
        {
          localObject2 = localMessageRecord.senderuin;
          localObject4 = new JSONObject(localMessageRecord.extStr);
          if (((JSONObject)localObject4).has("kdUin")) {
            localObject2 = ((JSONObject)localObject4).getString("kdUin");
          }
          ((JSONObject)localObject3).put("feeds_source", localObject2);
          if ((localMessageForStructing != null) && (localMessageForStructing.structingMsg != null))
          {
            ((JSONObject)localObject3).put("load_mode", aL(localMessageForStructing.structingMsg.mExtraData));
            ((JSONObject)localObject3).put("push_type", aM(localMessageForStructing.structingMsg.mExtraData));
            ((JSONObject)localObject3).put("landing_type", a(localMessageRecord));
          }
        }
        kbp.a(null, "CliOper", "", paramMessageRecord.senderuin, "0X80081DC", "0X80081DC", 0, 0, "", paramQQMessageFacade, paramIntent, ((JSONObject)localObject3).toString(), false);
        lcm.o(40, Integer.parseInt((String)localObject1), Integer.parseInt(str), Integer.parseInt(paramIntent));
        paramMessageRecord = new ReportInfo();
        paramMessageRecord.mUin = getLongAccountUin();
        paramMessageRecord.mSourceArticleId = new BigInteger(paramQQMessageFacade).longValue();
        paramMessageRecord.mAlgorithmId = Integer.parseInt(str);
        paramMessageRecord.mStrategyId = Integer.parseInt(paramIntent);
        paramMessageRecord.mOperation = 54;
        paramMessageRecord.mFolderStatus = Integer.parseInt((String)localObject1);
        paramQQMessageFacade = new ArrayList();
        paramQQMessageFacade.add(paramMessageRecord);
        lbz.a().cb(paramQQMessageFacade);
        return;
        localObject1 = new JSONObject();
      }
      Object localObject2 = "";
      String str = "";
      paramIntent = "0";
      paramQQMessageFacade = "";
      Object localObject1 = "";
      continue;
      paramIntent = "";
      continue;
      str = "";
      continue;
      localObject1 = "0";
      continue;
      paramQQMessageFacade = "";
      continue;
      MessageForStructing localMessageForStructing = null;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    a(paramBaseActivity, -1);
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBaseActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(paramBaseActivity.getWindow(), true);
      if (paramBaseActivity.mSystemBarComp == null) {
        paramBaseActivity.mSystemBarComp = new SystemBarCompact(paramBaseActivity, true, -1);
      }
      paramBaseActivity.mSystemBarComp.init();
      if ((Build.VERSION.SDK_INT < 23) || (aqfo.isMIUI()) || (aqfo.isFlyme())) {
        break label116;
      }
      paramBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      if (ThemeUtil.isInNightMode(paramBaseActivity.app)) {
        paramBaseActivity.mSystemBarComp.setStatusBarColor(1996488704);
      }
    }
    else
    {
      return;
    }
    paramBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
    return;
    label116:
    if (!aqfo.isFlyme())
    {
      paramBaseActivity.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    paramBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
    paramBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView)
  {
    anpc.a(paramBaseActivity).collectPerformance(getAccount(), "actReadInJoyDDShowPopupMenu", true, 0L, 0L, null, "");
    ArrayList localArrayList = new ArrayList();
    m(awit.w(getAppRuntime()), localArrayList);
    if (localArrayList.size() == 0) {
      m(31, localArrayList);
    }
    auuw.a(paramBaseActivity, localArrayList, new kxn(paramBaseActivity), new kxo(), wja.dp2px(125.0F, paramBaseActivity.getResources()), false, 2130843652, 2131755037).showAsDropDown(paramView);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    aMx = -1;
    Object localObject3 = (KandianMergeManager)paramQQAppInterface.getManager(162);
    paramQQAppInterface = "";
    Object localObject1 = "";
    Object localObject2 = "";
    int i;
    if (paramMessageRecord != null)
    {
      if (!paramMessageRecord.isread) {
        break label152;
      }
      i = 1;
    }
    for (;;)
    {
      pV(i);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.aRV = i;
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.aeN = ((String)localObject1);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.ahf = paramQQAppInterface;
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.Wz = ((String)localObject2);
      if ((!TextUtils.isEmpty(paramMessageRecord.extStr)) && (!paramMessageRecord.isread)) {}
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              paramQQAppInterface = new JSONObject(paramMessageRecord.extStr);
              jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.vk = paramQQAppInterface.optLong("sp_last_kadnian_red_pnt_exposure_time_key", 0L);
              long l = paramQQAppInterface.optLong("sp_last_locksc_kadnian_red_pnt_exposure_time_key", -1L);
              if (l > 0L) {
                jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.vk = l;
              }
            }
            catch (Exception paramQQAppInterface)
            {
              label152:
              Object localObject6;
              Object localObject5;
              MessageForStructing localMessageForStructing;
              Object localObject4;
              paramQQAppInterface.printStackTrace();
              continue;
            }
            jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.vl = paramMessageRecord.time;
            return;
            if ((paramMessageRecord.extInt != 1) && (paramMessageRecord.extInt != 3)) {
              continue;
            }
            if ((localObject3 != null) && (((KandianMergeManager)localObject3).b(paramMessageRecord) == 1))
            {
              i = 5;
              break;
            }
            localObject6 = paramQQAppInterface;
            localObject5 = localObject1;
            localObject3 = localObject2;
            if ((paramMessageRecord instanceof MessageForStructing))
            {
              localMessageForStructing = (MessageForStructing)paramMessageRecord;
              localMessageForStructing.parse();
              localObject6 = paramQQAppInterface;
              localObject5 = localObject1;
              localObject3 = localObject2;
              if (localMessageForStructing.structingMsg != null)
              {
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mStrategyIds)) {
                  paramQQAppInterface = localMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
                }
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mAlgorithmIds)) {
                  localObject1 = localMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
                }
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mArticleIds)) {
                  localObject2 = localMessageForStructing.structingMsg.mArticleIds.split("\\|")[0];
                }
                localObject6 = paramQQAppInterface;
                localObject5 = localObject1;
                localObject3 = localObject2;
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.reportEventFolderStatusValue)) {
                  try
                  {
                    i = Integer.parseInt(localMessageForStructing.structingMsg.reportEventFolderStatusValue);
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                    localObject4 = localObject2;
                    localObject5 = localObject1;
                    localObject6 = paramQQAppInterface;
                  }
                }
              }
            }
          }
          i = 3;
          paramQQAppInterface = (QQAppInterface)localObject6;
          localObject1 = localObject5;
          localObject2 = localObject4;
          break;
          if ((paramMessageRecord.extInt == 2) || (paramMessageRecord.extInt == 4))
          {
            i = 2;
            break;
          }
          if (paramMessageRecord.extInt == 5)
          {
            i = 6;
            break;
          }
          if (paramMessageRecord.extInt != 6) {
            break label578;
          }
          localObject5 = paramQQAppInterface;
          localObject4 = localObject1;
          try
          {
            localObject6 = new JSONObject(paramMessageRecord.extStr);
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            i = ((JSONObject)localObject6).getInt("folder_status");
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            paramQQAppInterface = ((JSONObject)localObject6).getString("strategy_id");
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            localObject1 = ((JSONObject)localObject6).getString("algorithm_id");
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            localObject6 = ((JSONObject)localObject6).getString("article_id");
            localObject2 = localObject6;
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            i = 10;
            paramQQAppInterface = (QQAppInterface)localObject5;
            localObject1 = localObject4;
          }
        }
        break;
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.vk = 0L;
      }
      label578:
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (!awit.aMG()) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyUtils.16(paramQQAppInterface));
    ThreadManager.executeOnSubThread(new ReadInJoyUtils.17(paramRedTypeInfo, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      SettingCloneUtil.writeValue(localMobileQQ, paramQQAppInterface, null, "qqsetting_kandian_key", paramBoolean);
      return;
    }
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    String str = "-1";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1)) {}
      try
      {
        kbp.a(null, "", paramString1, paramString1, 0, 0, String.valueOf(paramLong), str, paramString2, "", false);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("ReadInJoyUtils", 1, "reportSelectedTopic error:" + paramString1.toString());
      }
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
    }
  }
  
  public static void a(String paramString, Runnable paramRunnable, ExecutorService paramExecutorService)
  {
    if ((paramExecutorService == null) || (paramExecutorService.isShutdown()))
    {
      QLog.d("ReadInJoyUtils", 2, new Object[] { paramString, " runInSubThread failed, executorService is null or shutdown." });
      return;
    }
    paramExecutorService.execute(paramRunnable);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, kxm.a parama)
  {
    ThreadManager.executeOnNetWorkThread(new ReadInJoyUtils.13(paramString4, paramString3, paramString2, paramString1, parama));
  }
  
  public static void a(String paramString, mgu parammgu, nce.a parama)
  {
    if (parammgu.j == null) {}
    long l;
    do
    {
      return;
      l = parammgu.j.mArticleID;
      localObject1 = lty.h(l);
    } while (localObject1 == null);
    parama = new nce.a(parama.a().toJsonString());
    Object localObject1 = ((List)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject1).next();
      if ((localArticleInfo != null) && (localArticleInfo.mProteusTemplateBean != null))
      {
        Object localObject2 = localArticleInfo.mProteusTemplateBean.getDataAttribute(null);
        if ((localObject2 != null) && (((Map)localObject2).entrySet() != null))
        {
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while ((localObject2 != null) && (((Iterator)localObject2).hasNext()))
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            parama.a((String)localEntry.getKey(), localEntry.getValue().toString());
          }
        }
        QLog.d("ReadInJoyUtils", 1, "reportArticleItemExpose: " + localArticleInfo + "  bean :" + localArticleInfo.mProteusTemplateBean.getDataAttribute(null));
      }
      for (;;)
      {
        kbp.a(null, "CliOper", "", parammgu.agN, paramString, paramString, 0, 0, Long.toString(parammgu.j.mFeedId), Long.toString(parammgu.v.longValue()), Integer.toString(parammgu.mStrategyId), parama.a().toJsonString(), false);
        break;
        QLog.d("ReadInJoyUtils", 1, "reportArticleItemExpose: " + localArticleInfo);
      }
    }
    lty.eB(l);
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    paramStringBuilder.append("\"");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("\":");
    paramStringBuilder.append("\"");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append("\"");
  }
  
  public static void a(kgj paramkgj)
  {
    if (paramkgj == null) {
      return;
    }
    kbp.a(null, null, "0X8009BD4", "0X8009BD4", 0, 0, "", "", "", paramkgj.jdMethod_if(), false);
  }
  
  public static void a(kgj paramkgj, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramkgj != null) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      b(paramkgj, paramBaseArticleInfo);
      a(paramkgj);
    }
  }
  
  public static void a(mgu parammgu, String paramString1, String paramString2)
  {
    if ((parammgu == null) || (parammgu.j == null)) {}
    for (;;)
    {
      return;
      try
      {
        if ((lty.aV() != null) && (parammgu.j.mNewPolymericInfo != null) && (parammgu.j.mNewPolymericInfo.iP != null))
        {
          paramString1 = new JSONObject(paramString1);
          if (parammgu.j.mProteusTemplateBean != null)
          {
            localObject1 = parammgu.j.mProteusTemplateBean.getDataAttribute(null);
            if ((localObject1 != null) && (((Map)localObject1).entrySet() != null))
            {
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while ((localObject1 != null) && (((Iterator)localObject1).hasNext()))
              {
                localObject2 = (Map.Entry)((Iterator)localObject1).next();
                paramString1.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue().toString());
              }
            }
          }
          Object localObject1 = parammgu.j.mNewPolymericInfo.iP;
          Object localObject2 = lty.aV().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Integer localInteger = (Integer)((Iterator)localObject2).next();
            if ((localInteger.intValue() < ((List)localObject1).size()) && (((List)localObject1).get(localInteger.intValue()) != null))
            {
              paramString1.put("rowkey", ((mhr.a)((List)localObject1).get(localInteger.intValue())).ahs);
              kbp.a(null, "CliOper", "", parammgu.agN, paramString2, paramString2, 0, 0, Long.toString(parammgu.j.mFeedId), Long.toString(parammgu.v.longValue()), Integer.toString(parammgu.mStrategyId), paramString1.toString(), false);
            }
          }
          lty.aNv();
          return;
        }
      }
      catch (JSONException parammgu) {}
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, List<oidb_cmd0x68b.RspTraceRecord> paramList)
  {
    if ((paramAppRuntime == null) || (paramList == null) || (paramList.size() < 1)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x68b.RspTraceRecord localRspTraceRecord = (oidb_cmd0x68b.RspTraceRecord)paramList.next();
      localHashMap.put(localRspTraceRecord.bytes_method.get().toStringUtf8(), String.valueOf(localRspTraceRecord.uint32_cost.get()));
    }
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actKandianRefreshBackEndTrace", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_ERROR_CODE", Integer.toString(paramInt));
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actWebRenderLoopEvent", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_STEP", Integer.toString(paramInt));
    localHashMap.put("LOOP_STEP_COST", Long.toString(paramLong));
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actWebRenderLoopEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 30000L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actKandianGetShareJsonSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt1));
    localHashMap.put("param_OpCode", String.valueOf(paramInt2));
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actKandian0x83eResult", paramBoolean, paramLong, 0L, localHashMap, null);
    QLog.d("ReadInJoyUtils", 1, "reportKandian83eMonitorData| actKandian0x83eResult | retCode ： " + paramInt1 + "| param_OpCode : " + paramInt2);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 50000L)) {
      return;
    }
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(getAccount(), "actKandianRefreshSuccAndCost", paramBoolean, paramLong, 0L, paramHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PLUGIN_STEP", paramString);
    localHashMap.put("PLUGIN_CAN_RENDER", Integer.toString(paramInt));
    localHashMap.put("PLUGIN_STEP_COST_FROM_CLICK", Long.toString(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUtils", 2, "reportWebRenderPluginEventCost PLUGIN_STEP : [" + paramString + "];PLUGIN_CAN_RENDER :[" + paramInt + "]; + PLUGIN_STEP_COST_FROM_CLICK : [" + paramLong + " ms];");
    }
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actreportWebRenderPluginEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actKanDianViolaData", paramBoolean, -1L, -1L, paramHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramAppRuntime == null) {
      return;
    }
    ThreadManager.post(new ReadInJoyUtils.7(paramJSONObject, paramAppRuntime, paramBoolean), 5, null, true);
  }
  
  public static void a(JSONObject paramJSONObject, ArticleInfo paramArticleInfo)
  {
    for (;;)
    {
      try
      {
        SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
        paramJSONObject.put("folder_status", aMw);
        if (ndi.K(paramArticleInfo))
        {
          paramJSONObject.put("feeds_source", paramArticleInfo.mSubscribeID);
          paramJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
          paramJSONObject.put("feeds_type", "" + a(paramArticleInfo));
          paramJSONObject.put("kandian_mode", "" + nR());
          paramJSONObject.put("tab_source", "" + nQ());
          paramJSONObject.put("channel_id", paramArticleInfo.mChannelID);
          paramJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
          if (paramArticleInfo.isPGCShortContent())
          {
            paramArticleInfo = "1";
            paramJSONObject.put("content_source", paramArticleInfo);
          }
        }
        else
        {
          if ((localSocializeFeedsInfo == null) || (localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null)) {
            continue;
          }
          paramJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
          continue;
        }
        paramArticleInfo = "0";
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, kgj paramkgj)
  {
    if ((paramJSONObject == null) || (paramkgj == null)) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramkgj.Zb)) {}
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "bindMedalData : " + paramJSONObject.toString());
        return;
        if ((paramkgj.mPicWidth > 0) && (paramkgj.mPicHeight > 0))
        {
          paramJSONObject.put("header_medal_jump_url", paramkgj.mJumpUrl);
          paramJSONObject.put("header_medal_wh_rate", Double.valueOf(paramkgj.mPicWidth).doubleValue() / paramkgj.mPicHeight);
          paramJSONObject.put("header_medal_image_url", paramkgj.Zb);
        }
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int j = 1;
    Object localObject1 = (QQAppInterface)getAppRuntime();
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = ((QQAppInterface)localObject1).b();
      } while (localObject1 == null);
      localObject2 = ((QQMessageFacade)localObject1).d(acbn.blx, 7220);
    } while (localObject2 == null);
    if ((localObject2 instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)localObject2;
      if (((MessageForStructing)localObject1).structingMsg == null) {
        ((MessageForStructing)localObject1).parse();
      }
    }
    for (;;)
    {
      int i;
      if (!paramBoolean)
      {
        i = 1;
        label80:
        if (((MessageRecord)localObject2).isread) {
          break label209;
        }
      }
      for (;;)
      {
        for (;;)
        {
          if ((i | j) == 0) {
            break label212;
          }
          String str = ((MessageRecord)localObject2).senderuin;
          try
          {
            localObject2 = new JSONObject(((MessageRecord)localObject2).extStr);
            if (((JSONObject)localObject2).has("kdUin")) {
              str = ((JSONObject)localObject2).getString("kdUin");
            }
            paramJSONObject.put("feeds_source", str);
            if ((localObject1 == null) || (((MessageForStructing)localObject1).structingMsg == null)) {
              break;
            }
            paramJSONObject.put("load_mode", aL(((MessageForStructing)localObject1).structingMsg.mExtraData));
            paramJSONObject.put("push_type", aM(((MessageForStructing)localObject1).structingMsg.mExtraData));
            return;
          }
          catch (Exception paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return;
          }
        }
        i = 0;
        break label80;
        label209:
        j = 0;
      }
      label212:
      break;
      localObject1 = null;
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject, mgu parammgu)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      parammgu = new nce.a(null, null, null, null).W(Integer.valueOf("1031").intValue()).s(paramJSONObject.optString("double_videocard_jump_page")).t(paramJSONObject.optString("double_videocard_jump_src")).f(parammgu.j);
      String str;
      if (paramBoolean)
      {
        str = paramJSONObject.optString("column_id");
        if (!TextUtils.isEmpty(str)) {
          parammgu.a("columnId", str);
        }
        parammgu.h(paramJSONObject.optString("all_rowkey"));
        parammgu.u(paramJSONObject.optString("subscript"));
        kbp.a(null, null, "0X800A5A8", "0X800A5A8", 0, 0, "", "", "", parammgu.a().toJsonString(), false);
        return;
      }
      int i = 0;
      while (i < 2)
      {
        str = paramJSONObject.optString("columnId_" + (i + 1));
        if (!TextUtils.isEmpty(str)) {
          parammgu.a("columnId", str);
        }
        parammgu.h(paramJSONObject.optString("rowKey_" + (i + 1)));
        parammgu.u(paramJSONObject.optString("subscript_" + (i + 1)));
        parammgu.ab(i);
        kbp.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", parammgu.a().toJsonString(), false);
        i += 1;
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString1, String paramString2)
  {
    ThreadManagerV2.executeOnSubThread(new ReadInJoyUtils.5(paramBoolean2, paramInt1, paramInt3, paramInt2, paramLong, paramString1, paramBoolean1, paramString2));
  }
  
  public static boolean a(Context paramContext, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mProteusTemplateBean == null) {}
    for (String str = "";; str = paramBaseArticleInfo.mProteusTemplateBean.getStyleName()) {
      return a(paramContext, paramBaseArticleInfo, str);
    }
  }
  
  public static boolean a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    boolean bool1 = true;
    if ((paramBaseArticleInfo.mChannelID != 0L) && (!kys.dv((int)paramBaseArticleInfo.mChannelID))) {
      QLog.e("ReadInJoyUtils", 1, "judgeShouldNoDifferenceJumpToApp channelID: " + paramBaseArticleInfo.mChannelID);
    }
    int i;
    label188:
    label203:
    label216:
    label235:
    label363:
    label365:
    do
    {
      for (;;)
      {
        return false;
        AladdinConfig localAladdinConfig = Aladdin.getConfig(199);
        if (localAladdinConfig == null)
        {
          QLog.e("ReadInJoyUtils", 1, "judgeShouldNoDifferenceJumpToApp AladdinConfig is empty.");
          return false;
        }
        boolean bool2 = awit.aMV();
        if (!bool2)
        {
          QLog.e("ReadInJoyUtils", 1, "judgeShouldNoDifferenceJumpToApp is not first no difference jump app today.");
          return false;
        }
        i = ndi.k((ArticleInfo)paramBaseArticleInfo);
        int j;
        int m;
        boolean bool3;
        if ((paramBaseArticleInfo.mFeedType == 0) && ((i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 6)))
        {
          j = 1;
          if ((paramBaseArticleInfo.mFeedType != 29) || ((!paramString.equalsIgnoreCase("ReadInjoy_daily_small_img_cell")) && (!paramString.equalsIgnoreCase("ReadInjoy_daily_triple_img_cell")) && (!paramString.equalsIgnoreCase("ReadInjoy_daily_large_img_cell")))) {
            break label336;
          }
          m = 1;
          if (localAladdinConfig.getIntegerFromString("no_difference_jump_app_switch", 0) != 1) {
            break label342;
          }
          i = 1;
          if ((j == 0) && (m == 0)) {
            break label347;
          }
          j = 1;
          bool3 = TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText);
          if (paramBaseArticleInfo.isSuperTop != 0) {
            break label353;
          }
          m = 1;
          if ((TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)) || ((!paramBaseArticleInfo.mArticleContentUrl.startsWith("mqqapi")) && (!paramBaseArticleInfo.mArticleContentUrl.contains("target=4")))) {
            break label359;
          }
        }
        for (int n = 1;; n = 0)
        {
          if ((i == 0) || (!bool2) || (j == 0) || (!bool3) || (m == 0) || (n != 0)) {
            break label363;
          }
          i = localAladdinConfig.getIntegerFromString("no_difference_jump_app_type", 0);
          paramBaseArticleInfo = localAladdinConfig.getString("no_difference_jump_app_package_name", "");
          if (i != 0) {
            break label365;
          }
          return true;
          j = 0;
          break;
          m = 0;
          break label188;
          i = 0;
          break label203;
          j = 0;
          break label216;
          m = 0;
          break label235;
        }
      }
      if (i == 1)
      {
        if (!aqiz.isAppInstalled(paramContext, paramBaseArticleInfo)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (i != 2);
    label336:
    label342:
    label347:
    label353:
    label359:
    return aqiz.isAppInstalled(paramContext, paramBaseArticleInfo);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    String str = kvx.b(paramArticleInfo);
    if ((!TextUtils.isEmpty(str)) && (paramContext != null))
    {
      if (mgn.dV(str)) {
        a(paramContext, paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "tryJumpToUgUrl,title=" + paramArticleInfo.mTitle);
        return true;
        muj.aP(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (q(paramBaseArticleInfo1))
    {
      bool1 = bool2;
      if (q(paramBaseArticleInfo2))
      {
        bool1 = bool2;
        if (paramBaseArticleInfo1.mPolymericInfo.vq == paramBaseArticleInfo2.mPolymericInfo.vq) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(SocializeFeedsInfo.r paramr)
  {
    return (paramr != null) && (paramr.b != null) && (paramr.b.iT != null) && ((paramr.b.iT.size() > 1) || ((paramr.b.iT.size() == 1) && (!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramr.b.iT.get(0)).ahj))));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extInt != 5) {
      return e(paramMessageRecord);
    }
    return ((KandianMergeManager)paramQQAppInterface.getManager(162)).Bz();
  }
  
  public static boolean a(PBBytesField paramPBBytesField)
  {
    return (paramPBBytesField != null) && (paramPBBytesField.has()) && (paramPBBytesField.get() != null);
  }
  
  public static boolean a(String paramString, long paramLong, ArticleInfo paramArticleInfo)
  {
    if (!awit.Q(getAppRuntime())) {
      return false;
    }
    if ((paramArticleInfo instanceof AdvertisementInfo)) {
      return false;
    }
    if (paramLong == 1000000L) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = aurr.getArgumentsFromURL(paramString);
      if ((paramString.containsKey("article_type")) && (!TextUtils.equals("1", (CharSequence)paramString.get("article_type")))) {
        return false;
      }
    }
    return h(paramArticleInfo);
  }
  
  public static int[] a(Activity paramActivity)
  {
    Object localObject = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    int j;
    int i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      ((Display)localObject).getRealSize(localPoint);
      j = localPoint.x;
      i = localPoint.y;
    }
    for (;;)
    {
      return new int[] { j, i };
      if (Build.VERSION.SDK_INT >= 15)
      {
        ((Display)localObject).getSize(localPoint);
        j = localPoint.x;
        i = localPoint.y;
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).widthPixels;
        i = ((DisplayMetrics)localObject).heightPixels;
      }
    }
  }
  
  public static URL[] a(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label214;
        }
        JSONArray localJSONArray = paramString.optJSONArray("pictures");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          URL[] arrayOfURL = new URL[localJSONArray.length()];
          paramString = kwz.d();
          if (!k(paramBaseArticleInfo)) {
            break label211;
          }
          i = paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
          if (i == 2)
          {
            paramString = kwz.f();
            break label216;
            if (i < localJSONArray.length())
            {
              paramBaseArticleInfo = localJSONArray.optJSONObject(i).optString("picture");
              if (TextUtils.isEmpty(paramBaseArticleInfo)) {
                break label221;
              }
              if (!dA(paramBaseArticleInfo)) {
                break label208;
              }
              paramBaseArticleInfo = a(paramBaseArticleInfo, ((Integer)paramString.second).intValue(), ((Integer)paramString.first).intValue(), 1);
              arrayOfURL[i] = obs.a(paramBaseArticleInfo, 3);
              break label221;
            }
          }
          else
          {
            if (i == 3)
            {
              paramString = kwz.h();
              break label216;
            }
            if (i != 1) {
              break label211;
            }
            paramString = kwz.g();
            break label216;
          }
          return arrayOfURL;
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      label208:
      continue;
      label211:
      break label216;
      label214:
      return null;
      label216:
      int i = 0;
      continue;
      label221:
      i += 1;
    }
  }
  
  public static void aH(Activity paramActivity)
  {
    a(paramActivity, null);
  }
  
  private static void aHS()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      if (!((QQAppInterface)localAppRuntime).a.He()) {
        lcm.aJX();
      }
    }
    else {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyUtils.2(), 500L);
  }
  
  public static void aHT()
  {
    j = 0;
    try
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label169;
      }
      localObject = ((QQAppInterface)localObject).b();
      if (localObject == null) {
        break label169;
      }
      localObject = ((QQMessageFacade)localObject).d(acbn.blx, 7220);
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((MessageRecord)localObject).extInt != 1)
        {
          if (((MessageRecord)localObject).extInt != 3) {
            break label205;
          }
          i = j;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          boolean bool;
          aMw = Integer.parseInt(((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "update mergefolder status " + aMw);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "current mergefolder status is " + aMw);
          }
          return;
          if (((MessageRecord)localObject).extInt != 2)
          {
            i = j;
            if (((MessageRecord)localObject).extInt != 4) {
              continue;
            }
            continue;
            if (i == 0)
            {
              aMw = 3;
              continue;
              localException1 = localException1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ReadInJoyUtils", 2, "obtainMergeKandianFolderStatus except " + localException1.toString());
              continue;
            }
            if (i != 1) {
              continue;
            }
            aMw = 2;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
          int i = 1;
        }
      }
    }
    if ((localObject != null) && (((MessageRecord)localObject).isread))
    {
      aMw = 1;
      if ((localObject != null) && ((localObject instanceof MessageForStructing)))
      {
        localObject = (MessageForStructing)localObject;
        if (((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue != null)
        {
          bool = TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
          if (bool) {}
        }
      }
    }
  }
  
  public static void aHU()
  {
    if (k != null) {
      k.clear();
    }
  }
  
  public static void aHV()
  {
    aMA = -1;
  }
  
  public static void aHW()
  {
    if (!ReadinjoyTabFrame.Dx()) {
      mP(false);
    }
  }
  
  public static void aHX()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.c != null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.c.isread = true;
    }
  }
  
  public static void aHY()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    b(((KandianMergeManager)localQQAppInterface.getManager(162)).c());
  }
  
  public static void aHZ()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    b(((KandianMergeManager)localQQAppInterface.getManager(162)).d());
  }
  
  public static void aIa()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    b(((KandianDailyManager)localQQAppInterface.getManager(296)).a());
  }
  
  public static void aIb()
  {
    ThreadManagerV2.excute(new ReadInJoyUtils.24(), 64, null, true);
  }
  
  public static void aJ(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null);
  }
  
  public static void aK(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramContext;
      if (!(paramContext instanceof BasePluginActivity)) {
        break;
      }
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
    } while (localObject == null);
    paramContext = new Bundle();
    paramContext.putString("url", paramString);
    paramContext.putBoolean("hide_operation_bar", true);
    paramString = new Intent((Context)localObject, QQBrowserActivity.class);
    paramString.putExtras(paramContext);
    ((Context)localObject).startActivity(paramString);
  }
  
  private static int aL(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("jumpType", 0);
        return i;
      }
      catch (JSONException paramString)
      {
        QLog.e("ReadInJoyUtils", 1, "getReportLoadModeFromLockScreenMsg: ", paramString);
      }
    }
    return -1;
  }
  
  public static void aL(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    Uri localUri;
    if (!TextUtils.isEmpty(paramString))
    {
      localUri = Uri.parse(paramString);
      if (TextUtils.isEmpty(localUri.getPath())) {
        break label164;
      }
      if (!localUri.getPath().equals("/mqq/vue/wendadetail")) {
        break label97;
      }
      new Bundle().putString("url", paramString);
      paramContext = localUri.getQuery();
      if (!TextUtils.isEmpty(paramContext)) {
        new StringBuilder().append("https://kandian.qq.com/viola/bundle_wendadetail.js?v_bid=3256&hideNav=1&statusColor=1").append("&").append(paramContext).toString();
      }
    }
    label97:
    do
    {
      return;
      if (!localUri.getPath().equals("/mqq/vue/wenda")) {
        break;
      }
      new Bundle().putString("url", paramString);
      paramContext = localUri.getQuery();
    } while (TextUtils.isEmpty(paramContext));
    new StringBuilder().append("https://kandian.qq.com/viola/bundle_wenda.js?v_bid=3256&hideNav=1&statusColor=1").append("&").append(paramContext).toString();
    return;
    label164:
    a(paramContext, paramString, localBundle);
  }
  
  public static boolean aL(long paramLong)
  {
    return (paramLong == 41516L) || (paramLong == 41522L) || (paramLong == 41523L);
  }
  
  private static int aM(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("contentType", 0);
        return i;
      }
      catch (JSONException paramString)
      {
        QLog.e("ReadInJoyUtils", 1, "getReportPushTypeFromeLockScreenMsg: ", paramString);
      }
    }
    return -1;
  }
  
  public static void aM(Context paramContext, String paramString)
  {
    QLog.d("ReadInJoyUtils", 1, "jumToWeb: " + paramString);
    if ((!TextUtils.isEmpty(paramString)) && (ntp.ek(paramString))) {
      ntp.b(paramContext, null, ntp.fd(paramString), null);
    }
    Intent localIntent;
    do
    {
      return;
      if (amxk.oO(paramString))
      {
        amxk.E(paramContext, amxk.nj(paramString), paramString);
        return;
      }
      localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", bg(0));
    } while (TextUtils.isEmpty(paramString));
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean aM(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = System.currentTimeMillis();
    }
    paramLong = l - awit.s((QQAppInterface)getAppRuntime());
    if (QLog.isColorLevel()) {
      if (paramLong >= kxa.aMo) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ReadInJoyUtils", 2, new Object[] { "isNeedToRememberHistoryPos, timeInterval = ", Long.valueOf(paramLong), " , isNeedToRemember = ", Boolean.valueOf(bool) });
      if (paramLong >= kxa.aMo) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static void af(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnFileThread(new ReadInJoyUtils.10(paramBoolean, paramString));
  }
  
  public static String aq(long paramLong)
  {
    boolean bool;
    String str;
    int i;
    if (nR() == 6)
    {
      bool = true;
      str = adr;
      if (paramLong != 1004L) {
        break label94;
      }
      if (!bool) {
        break label80;
      }
      i = awit.c(BaseApplicationImpl.getApplication().getRuntime(), 0);
      label38:
      if (i != 0) {
        break label124;
      }
      str = ads;
    }
    for (;;)
    {
      localObject = awit.a(getAppRuntime(), true, false);
      if (localObject != null) {
        break label150;
      }
      QLog.d("ReadInJoyUtils", 1, "getVideoAutoPlaySetting failed to get sp");
      return str;
      bool = false;
      break;
      label80:
      i = awit.b(BaseApplicationImpl.getApplication().getRuntime(), 0);
      break label38;
      label94:
      if (bool)
      {
        i = awit.h(BaseApplicationImpl.getApplication().getRuntime());
        break label38;
      }
      i = awit.g(BaseApplicationImpl.getApplication().getRuntime());
      break label38;
      label124:
      if (i == 1) {
        str = adr;
      } else if (i == 2) {
        str = adq;
      }
    }
    label150:
    if (bool) {}
    for (Object localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", str);; localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "getVideoAutoPlaySetting(),isVideoFlowEnter = " + bool + ", autoSetting = " + (String)localObject + ",localSettingDefaultValue=" + str + ", remoteSettingDefaultValue=" + i + " channelFrom:" + paramLong);
      }
      return localObject;
    }
  }
  
  private static List<RecentBaseData> ay()
  {
    localArrayList = new ArrayList();
    try
    {
      QQAppInterface localQQAppInterface = a();
      Object localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null)
      {
        QLog.d("ReadInJoyUtils", 1, "conversation frame is null");
        return localArrayList;
      }
      localObject1 = ((Conversation)localObject1).a().dv();
      if (localObject1 == null) {
        return localArrayList;
      }
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData)) {
          localArrayList.add((RecentBaseData)localObject2);
        }
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (RecentUserBaseData)localObject2;
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (nyn.f(localQQAppInterface, ((RecentUserBaseData)localObject2).mUser.uin))) {
            ((Iterator)localObject1).remove();
          }
        }
      }
      return localArrayList;
    }
    catch (Exception localException) {}
  }
  
  public static List<Integer> az()
  {
    ArrayList localArrayList = new ArrayList();
    if (k != null)
    {
      Iterator localIterator = k.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Integer)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public static int b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt2 != 0))
    {
      if (paramInt1 + 1 == paramInt2) {
        return 1;
      }
      return 0;
    }
    return -1;
  }
  
  public static int b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0;
    }
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.amO) {
        return 4;
      }
      return 2;
    }
    if (paramArticleInfo.isSuperTopic) {
      return 1;
    }
    return 3;
  }
  
  public static int b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mNewPolymericInfo == null) || (paramBaseArticleInfo.mNewPolymericInfo.iP == null) || (paramBaseArticleInfo.mNewPolymericInfo.iP.isEmpty()) || (!paramBaseArticleInfo.mNewPolymericInfo.amx))
    {
      QLog.e("ReadInJoyUtils", 1, "articleInfo = null");
      return 0;
    }
    mhr.a locala = (mhr.a)paramBaseArticleInfo.mNewPolymericInfo.iP.get(0);
    if (E(paramBaseArticleInfo)) {
      return 79;
    }
    if (paramBaseArticleInfo.mNewPolymericInfo.aRX == 15) {
      return 131;
    }
    if (locala.feedsType == 10) {
      return 78;
    }
    if ((locala.feedsType == 4) || (locala.feedsType == 5)) {
      return 76;
    }
    if ((locala.feedsType == 6) || (locala.feedsType == 7) || (locala.feedsType == 8) || (locala.feedsType == 9) || (locala.feedsType == 12)) {
      return 77;
    }
    if (locala.feedsType == 0) {
      return 77;
    }
    QLog.e("FeedItemCellTypeNewPolymericBaseHeader", 1, "新聚合类卡片没有找到对应的FeedCell feedType = " + locala.feedsType);
    return 77;
  }
  
  public static String b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("folder_status", aMw);
      ((JSONObject)localObject).put("feeds_type", paramInt1);
      ((JSONObject)localObject).put("time", System.currentTimeMillis());
      ((JSONObject)localObject).put("channel_id", paramInt2);
      ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
      ((JSONObject)localObject).put("session_id", adt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String b(QQAppInterface paramQQAppInterface)
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.ahf;
  }
  
  public static String b(@NotNull String paramString, long paramLong, int paramInt)
    throws UnsupportedEncodingException
  {
    if (paramString.isEmpty()) {}
    do
    {
      return paramString;
      localObject = aurr.getArgumentsFromURL(paramString);
      if (!"6".equals((String)((Map)localObject).get("target"))) {
        break;
      }
      localObject = (String)((Map)localObject).get("v_url_base64");
    } while ((localObject == null) || (((String)localObject).isEmpty()));
    Object localObject = aqgo.encodeToString(Uri.parse(new String(aqgo.decode((String)localObject, 0))).buildUpon().appendQueryParameter("percentage", String.valueOf(paramLong)).appendQueryParameter("mutestate", String.valueOf(paramInt)).build().toString().getBytes("utf-8"), 2);
    return aurr.L(aurr.deleteParameter(paramString, "v_url_base64"), "v_url_base64", (String)localObject);
    return Uri.parse(paramString).buildUpon().appendQueryParameter("percentage", String.valueOf(paramLong)).appendQueryParameter("mutestate", String.valueOf(paramInt)).build().toString();
  }
  
  public static String b(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramBaseArticleInfo != null) {}
    try
    {
      localObject = new StringBuilder();
      Map localMap = aurr.getArgumentsFromURL(paramString);
      ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3").append(a(localMap, "channelID", paramBaseArticleInfo.mChannelID + "")).append(a(localMap, "strategyId", paramBaseArticleInfo.mStrategyId + "")).append(a(localMap, "algorithmID", paramBaseArticleInfo.mAlgorithmID + "")).append(a(localMap, "title", paramBaseArticleInfo.mTitle)).append(a(localMap, "firstPagePicUrl", URLEncoder.encode(paramBaseArticleInfo.mFirstPagePicUrl, "UTF-8"))).append(a(localMap, "articleID", paramBaseArticleInfo.mArticleID + "")).append(a(localMap, "subscribeName", paramBaseArticleInfo.mSubscribeName)).append(a(localMap, "rowKey", paramBaseArticleInfo.innerUniqueID)).append(a(localMap, "subscribeID", paramBaseArticleInfo.mSubscribeID)).append(a(localMap, "articleContentUrl", URLEncoder.encode(paramString, "UTF-8"))).append("&").append("readinjoyNotDecodeUrl=1");
      localObject = ((StringBuilder)localObject).toString();
      QLog.d("ReadInJoyUtils", 1, "getJumpNativeArticleScheme |  articleScheme : " + (String)localObject);
      return localObject;
    }
    catch (UnsupportedEncodingException paramBaseArticleInfo)
    {
      for (;;)
      {
        localObject = paramString;
      }
    }
  }
  
  public static URL b(String paramString)
  {
    return b(paramString, true);
  }
  
  public static URL b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!paramBoolean) {
      try
      {
        paramString = new URL(paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString.fillInStackTrace();
        return null;
      }
    }
    return obs.a(paramString, 3);
  }
  
  public static URL b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (dA(paramString))
    {
      localObject = kwz.g();
      localObject = a(paramString, ((Integer)((android.util.Pair)localObject).second).intValue(), ((Integer)((android.util.Pair)localObject).first).intValue(), 3);
    }
    return b((String)localObject);
  }
  
  public static JSONArray b(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (paramJSONArray2 == null) {
      return paramJSONArray1;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramJSONArray1.length()) || (i >= paramJSONArray2.length())) {
          break;
        }
        if (((paramJSONArray2.get(i) instanceof JSONObject)) && ((paramJSONArray1.get(i) instanceof JSONObject)))
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONArray2.get(i);
          JSONObject localJSONObject2 = (JSONObject)paramJSONArray1.get(i);
          Iterator localIterator = localJSONObject1.keys();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject2.put(str, localJSONObject1.get(str));
            continue;
          }
        }
        i += 1;
      }
      catch (Exception paramJSONArray2)
      {
        QLog.e("ReadInJoyUtils", 2, "setCellArray:remoteArray: ", paramJSONArray2);
        return paramJSONArray1;
      }
    }
  }
  
  public static void b(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramActivity == null))
    {
      QLog.d("ReadInJoyUtils", 1, "clickCommentBiuCardWrapper error!");
      return;
    }
    if ((kqc.Aq()) && (x(paramArticleInfo))) {}
    for (String str = paramArticleInfo.getCardJumpUrl();; str = "")
    {
      if (!TextUtils.isEmpty(str)) {
        C(paramActivity, str);
      }
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "clickCommentBiuCardWrapper,jumpUrl=" + str);
        return;
        if (paramArticleInfo.isPGCShortContent())
        {
          if (a(paramArticleInfo, paramActivity))
          {
            QLog.d("ReadInJoyUtils", 1, "tryJumpToUgUrl: true");
          }
          else
          {
            QLog.d("ReadInJoyUtils", 1, "short content redirectToOtherPage!");
            lrm.b(paramActivity, paramArticleInfo);
          }
        }
        else if (J(paramArticleInfo))
        {
          muj.a(paramActivity, null, 28, paramArticleInfo);
        }
        else if (y(paramArticleInfo))
        {
          QLog.d("ReadInJoyUtils", 1, "startWebFastActivity");
          a(paramActivity, paramArticleInfo);
        }
        else
        {
          QLog.d("ReadInJoyUtils", 1, "jumpNewSocialSecondPage");
          a(paramActivity, paramArticleInfo, 7, false, 0, false);
        }
      }
    }
  }
  
  public static void b(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label527;
      }
    }
    Object localObject1;
    Object localObject2;
    label527:
    for (int j = 0;; j = 1)
    {
      localObject1 = f(paramArticleInfo);
      kbp.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, i), false);
      kbp.d("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, i));
      localObject2 = odv.aB(paramInt);
      kbp.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, i, j, aqiw.isWifiConnected(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, h(paramArticleInfo), paramArticleInfo), false);
      kbp.d((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, i, j, aqiw.isWifiConnected(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, h(paramArticleInfo), paramArticleInfo));
      paramContext = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = getLongAccountUin();
      ((ReportInfo)localObject1).mSource = 0;
      ((ReportInfo)localObject1).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = paramInt;
      ((ReportInfo)localObject1).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mOperation = 1;
      ((ReportInfo)localObject1).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      ((ReportInfo)localObject1).mInnerId = paramArticleInfo.innerUniqueID;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label540;
      }
      localObject2 = new ReportInfo.a();
      ((ReportInfo.a)localObject2).vd = paramArticleInfo.mSocialFeedInfo.mFeedId;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
        ((ReportInfo.a)localObject2).vg = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
      }
      ((ReportInfo.a)localObject2).aSx = paramArticleInfo.mSocialFeedInfo.mLikeCount;
      ((ReportInfo.a)localObject2).aSy = paramArticleInfo.mSocialFeedInfo.mCommentCount;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.iS;
      if ((paramArticleInfo == null) || (paramArticleInfo.isEmpty())) {
        break label533;
      }
      ((ReportInfo.a)localObject2).iR = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        SocializeFeedsInfo.e locale = (SocializeFeedsInfo.e)paramArticleInfo.next();
        if (locale != null) {
          ((ReportInfo.a)localObject2).iR.add(Long.valueOf(locale.uin));
        }
      }
      i = 0;
      break;
    }
    label533:
    ((ReportInfo)localObject1).mFeedsReportData = ((ReportInfo.a)localObject2);
    label540:
    paramContext.add(localObject1);
    lbz.a().cb(paramContext);
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(Y(paramContext)));
    anpc.a(paramContext).collectPerformance(paramString, "actKandianVideoPreload", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    localReportInfo.mChannelId = paramInt;
    localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    localReportInfo.mOperation = 1;
    localReportInfo.mServerContext = paramArticleInfo.mServerContext;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramArticleInfo.innerUniqueID;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      ReportInfo.a locala = new ReportInfo.a();
      locala.vd = paramArticleInfo.mSocialFeedInfo.mFeedId;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
        locala.vg = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
      }
      locala.aSx = paramArticleInfo.mSocialFeedInfo.mLikeCount;
      locala.aSy = paramArticleInfo.mSocialFeedInfo.mCommentCount;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.iS;
      if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
      {
        locala.iR = new ArrayList();
        paramArticleInfo = paramArticleInfo.iterator();
        while (paramArticleInfo.hasNext())
        {
          SocializeFeedsInfo.e locale = (SocializeFeedsInfo.e)paramArticleInfo.next();
          if (locale != null) {
            locala.iR.add(Long.valueOf(locale.uin));
          }
        }
      }
      localReportInfo.mFeedsReportData = locala;
    }
    localArrayList.add(localReportInfo);
    lbz.a().cb(localArrayList);
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    kbp.a(null, null, "0X800A5AB", "0X800A5AB", 0, 0, "", "", "", new nce.a(null, null, null, null).W(54).h(paramBaseArticleInfo.getInnerUniqueID()).x(paramInt + 1).a().toJsonString(), false);
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramString.contains("mqqapi://readinjoy/open")) && (paramString.contains("target=4"))) {
        paramBaseArticleInfo.mJumpType = 2;
      }
    }
    else {
      return;
    }
    paramBaseArticleInfo.mJumpType = 1;
  }
  
  public static void b(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo != null) {}
    try
    {
      if (paramKandianRedDotInfo.hasArticleID())
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("algorithm_id", paramKandianRedDotInfo.algorithmID);
        MessageForStructing localMessageForStructing = (MessageForStructing)paramKandianRedDotInfo.getMessageRecord();
        if ((localMessageForStructing != null) && (localMessageForStructing.structingMsg != null))
        {
          ((JSONObject)localObject).put("rowkey", paramKandianRedDotInfo.getRowkey());
          ((JSONObject)localObject).put("load_mode", aL(localMessageForStructing.structingMsg.mExtraData));
          ((JSONObject)localObject).put("push_type", aM(localMessageForStructing.structingMsg.mExtraData));
          ((JSONObject)localObject).put("landing_type", a(paramKandianRedDotInfo.getMessageRecord()));
        }
        ((JSONObject)localObject).put("folder_status", paramKandianRedDotInfo.forderStatus);
        ((JSONObject)localObject).put("report_time", NetConnInfoCenter.getServerTimeMillis());
        ((JSONObject)localObject).put("articleID", paramKandianRedDotInfo.articleIDList.get(0));
        kbp.a(null, "CliOper", "", "", "0X80081DB", "0X80081DB", 0, 0, "", paramKandianRedDotInfo.articleIDList.get(0) + "", paramKandianRedDotInfo.strategyID + "", ((JSONObject)localObject).toString(), false);
        lcm.o(41, Integer.parseInt(paramKandianRedDotInfo.forderStatus), (int)paramKandianRedDotInfo.algorithmID, (int)paramKandianRedDotInfo.strategyID);
        localObject = new ReportInfo();
        ((ReportInfo)localObject).mUin = getLongAccountUin();
        ((ReportInfo)localObject).mSourceArticleId = ((Long)paramKandianRedDotInfo.articleIDList.get(0)).longValue();
        ((ReportInfo)localObject).mAlgorithmId = ((int)paramKandianRedDotInfo.algorithmID);
        ((ReportInfo)localObject).mStrategyId = ((int)paramKandianRedDotInfo.strategyID);
        ((ReportInfo)localObject).mOperation = 55;
        ((ReportInfo)localObject).mFolderStatus = Integer.parseInt(paramKandianRedDotInfo.forderStatus);
        paramKandianRedDotInfo = new ArrayList();
        paramKandianRedDotInfo.add(localObject);
        lbz.a().cb(paramKandianRedDotInfo);
      }
      return;
    }
    catch (Exception paramKandianRedDotInfo)
    {
      QLog.e("ReadInJoyUtils", 1, paramKandianRedDotInfo, new Object[0]);
    }
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramQQAppInterface.b();
      } while (localObject == null);
      localObject = ((QQMessageFacade)localObject).a();
    } while ((localObject == null) || (((tog)localObject).A(paramString, 1008) <= 0));
    ThreadManager.post(new ReadInJoyUtils.20(paramString, paramQQAppInterface), 8, null, false);
  }
  
  public static void b(String paramString, Object paramObject, boolean paramBoolean)
  {
    if (!(paramObject instanceof Serializable)) {
      throw new RuntimeException("the data obj must implement Serializable interface ! ");
    }
    ThreadManager.executeOnFileThread(new ReadInJoyUtils.11(paramString, paramObject, paramBoolean));
  }
  
  public static void b(kgj paramkgj, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramkgj != null) {}
    try
    {
      paramkgj.Zc = String.valueOf(paramBaseArticleInfo.mChannelID);
      paramkgj.Zf = String.valueOf(paramBaseArticleInfo.mFeedId);
      paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo;
      paramkgj.Zg = String.valueOf(paramBaseArticleInfo.mSubscribeID);
      if ((ndi.ak(paramBaseArticleInfo)) || (ndi.K(paramBaseArticleInfo))) {
        paramkgj.Ze = "5";
      }
      for (;;)
      {
        paramkgj.Zd = "2";
        return;
        if (ndi.O(paramBaseArticleInfo)) {
          paramkgj.Ze = "4";
        } else {
          paramkgj.Ze = "0";
        }
      }
      return;
    }
    catch (Exception paramkgj) {}
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 30000L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actKandianGetUserInfoSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actKanDianViolaHttpData", paramBoolean, -1L, -1L, paramHashMap, null, true);
  }
  
  public static void bA(String paramString1, String paramString2)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", aMw);
      localJSONObject.put("releasetype", paramString2);
      localJSONObject.put("tab_source", paramString1);
      paramString1 = localJSONObject.toString();
      kbp.a(null, "", "0X8008C5D", "0X8008C5D", 0, 0, "", "", "", paramString1, false);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString1 = str;
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoyUtils", 2, "secondClassDeliverOperationReport:" + paramString2.toString());
          paramString1 = str;
        }
      }
    }
  }
  
  private static void bQ(Context paramContext)
  {
    bR(paramContext);
    anpc.a(paramContext).collectPerformance(getAppRuntime().getAccount(), "actReadInJoyDDShowVideoAS", true, 0L, 0L, null, "");
  }
  
  private static void bR(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_dian_dian", true);
    kqi.f(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772306, 2130772079);
  }
  
  private static void bS(Context paramContext)
  {
    if ((!aiq) && (paramContext != null))
    {
      paramContext = paramContext.getApplicationContext();
      aiq = true;
      AppNetConnInfo.registerNetChangeReceiver(paramContext, new kxp(paramContext));
      bT(paramContext);
    }
  }
  
  private static void bT(Context paramContext)
  {
    WifiInfo localWifiInfo;
    if (paramContext != null)
    {
      localWifiInfo = alkz.a((WifiManager)paramContext.getSystemService("wifi"));
      if (localWifiInfo != null)
      {
        if (!TextUtils.isEmpty(localWifiInfo.getBSSID())) {
          break label56;
        }
        paramContext = "";
        adv = paramContext;
        if (!TextUtils.isEmpty(adv)) {
          break label64;
        }
      }
    }
    label56:
    label64:
    for (paramContext = "";; paramContext = localWifiInfo.getSSID())
    {
      adw = paramContext;
      return;
      paramContext = localWifiInfo.getBSSID();
      break;
    }
  }
  
  public static String bb(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", aMw);
      ((JSONObject)localObject).put("session_id", adt);
      ((JSONObject)localObject).put("failed_reason", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String bc(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", aMw);
      ((JSONObject)localObject).put("time", System.currentTimeMillis());
      ((JSONObject)localObject).put("channel_id", paramInt);
      ((JSONObject)localObject).put("kandian_mode", nR());
      ((JSONObject)localObject).put("kandian_mode_new", kct.nd());
      ((JSONObject)localObject).put("tab_source", nQ());
      ((JSONObject)localObject).put("session_id", adt);
      ((JSONObject)localObject).put("os", 1);
      ((JSONObject)localObject).put("version", kct.XU);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String bd(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", aMw);
      ((JSONObject)localObject).put("reddot_num", paramInt);
      ((JSONObject)localObject).put("kandian_mode", nR());
      ((JSONObject)localObject).put("session_id", adt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String be(int paramInt)
  {
    Object localObject = a();
    int j = Math.max(10, aMt);
    if (localObject == null) {
      return "";
    }
    List localList = ay();
    StringBuilder localStringBuilder = new StringBuilder(aMt + ":");
    int i = localList.size();
    if (0 + j < i) {
      i = 0 + j;
    }
    for (;;)
    {
      tog localtog = ((QQAppInterface)localObject).a();
      j = 0;
      if (j < i)
      {
        localObject = (RecentBaseData)localList.get(j);
        RecentUserBaseData localRecentUserBaseData;
        int m;
        if (localObject != null)
        {
          localRecentUserBaseData = (RecentUserBaseData)localObject;
          if ((localRecentUserBaseData.mUser != null) && ((localRecentUserBaseData.mUser.getType() == paramInt) || (paramInt == -1)))
          {
            m = localtog.A(localRecentUserBaseData.qx(), localRecentUserBaseData.mUser.getType());
            if (localRecentUserBaseData.mUnreadFlag == 3) {
              m = 0;
            }
            if (localRecentUserBaseData.mUser.getType() != 1008) {
              break label244;
            }
          }
        }
        label244:
        for (localObject = "1";; localObject = "0")
        {
          localStringBuilder.append((String)localObject).append("_").append(localRecentUserBaseData.qx()).append("_").append(m);
          if (j != i - 1) {
            localStringBuilder.append(":");
          }
          j += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "getScreenPaInfo : " + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
  }
  
  public static String bf(int paramInt)
  {
    String str;
    if (paramInt == lhn.oC()) {
      str = aMw + "";
    }
    for (;;)
    {
      try
      {
        Integer.parseInt(str);
        return str;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        wja.a("ReadInJoyUtils", "fs is not number", localNumberFormatException);
      }
      switch (paramInt)
      {
      default: 
        if (kys.dv(paramInt)) {
          str = kvs.iL();
        }
        break;
      case 0: 
        str = aMw + "";
        break;
      case 70: 
        str = kvv.iM();
        if (nQ() == 6)
        {
          str = aMw + "";
          continue;
          str = aMw + "";
        }
        break;
      }
    }
    return "1";
  }
  
  public static String bg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (kys.dv(paramInt)) {
        return "biz_src_gzh_kandiandaily";
      }
      break;
    case 0: 
      return "biz_src_feeds_kandian";
    case 40677: 
      return "biz_src_gzh_weishi";
    }
    return "biz_src_feeds_kandian";
  }
  
  public static int c(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (ndi.P(paramArticleInfo)) {
      if (ndi.N(paramArticleInfo)) {
        switch (localSocializeFeedsInfo.aSG)
        {
        }
      }
    }
    do
    {
      do
      {
        return 0;
        return 4;
        return 3;
        if (k(paramArticleInfo)) {
          return 6;
        }
        if (w(paramArticleInfo)) {
          return 10;
        }
      } while (!v(paramArticleInfo));
      return 8;
      if ((!ndi.K(paramArticleInfo)) && (paramArticleInfo.mFeedType != 10)) {
        break;
      }
    } while (localSocializeFeedsInfo == null);
    switch (localSocializeFeedsInfo.aSG)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
    switch (paramArticleInfo.mFeedType)
    {
    default: 
      return 0;
    case 21: 
      return 7;
    case 23: 
      return 5;
    }
    return 9;
  }
  
  public static int c(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mPartnerAccountInfo == null)) {}
    while (!paramBaseArticleInfo.mPartnerAccountInfo.uint32_is_account_display.has()) {
      return 0;
    }
    return paramBaseArticleInfo.mPartnerAccountInfo.uint32_is_account_display.get();
  }
  
  private static String c(ArticleInfo paramArticleInfo)
  {
    if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
      return "0";
    }
    long l = Long.parseLong(paramArticleInfo.mSubscribeID);
    try
    {
      bool = ((acja)BaseApplicationImpl.getApplication().getRuntime().getManager(56)).a(Long.valueOf(l), true);
      if (bool) {
        return "1";
      }
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return "2";
  }
  
  public static String c(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!m(paramBaseArticleInfo))) {
      paramBaseArticleInfo = null;
    }
    String str;
    do
    {
      return paramBaseArticleInfo;
      if ((paramBaseArticleInfo.mGalleryFeedsInfo == null) || (!paramBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) || (TextUtils.isEmpty(paramBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8()))) {
        break;
      }
      paramBaseArticleInfo = paramBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
      str = ntp.fd(paramBaseArticleInfo);
      if (!ntp.ek(paramBaseArticleInfo)) {
        break;
      }
      paramBaseArticleInfo = str;
    } while (!TextUtils.isEmpty(str));
    return null;
  }
  
  public static String c(String paramString, int paramInt1, int paramInt2)
  {
    if (!awit.r(getAppRuntime())) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
    }
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return paramString;
        } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http://qqpublic.qpic.cn")));
        localObject2 = paramString.split("/");
      } while (localObject2.length < 2);
      localObject1 = localObject2[(localObject2.length - 2)].split("_");
    } while (localObject1.length < 1);
    Object localObject3 = localObject1[(localObject1.length - 1)];
    if ("open".equals(localObject3)) {}
    for (Object localObject1 = kwt.a;; localObject1 = kwt.b)
    {
      localObject1 = a((android.util.Pair[])localObject1, paramInt1, paramInt2);
      if (localObject1 == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "the picture size : w : " + paramInt1 + " h : " + paramInt2 + ", select scale : " + ((android.util.Pair)localObject1).first + ":" + ((android.util.Pair)localObject1).second);
      }
      localObject2 = localObject2[(localObject2.length - 1)];
      return paramString.replace(String.format("_%s/%s", new Object[] { localObject3, localObject2 }), String.format("_%s_%d_%d/%s", new Object[] { localObject3, ((android.util.Pair)localObject1).first, ((android.util.Pair)localObject1).second, localObject2 }));
      if (!"vsmcut".equals(localObject3)) {
        break;
      }
    }
  }
  
  public static String c(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramBaseArticleInfo != null) {}
    try
    {
      localObject = new StringBuilder(paramString);
      Map localMap = aurr.getArgumentsFromURL(paramString);
      ((StringBuilder)localObject).append(a(localMap, "videoType", paramBaseArticleInfo.busiType + "")).append(a(localMap, "videoVid", paramBaseArticleInfo.mVideoVid)).append(a(localMap, "videoWidth", paramBaseArticleInfo.mVideoJsonWidth + "")).append(a(localMap, "videoHeight", paramBaseArticleInfo.mVideoJsonHeight + "")).append(a(localMap, "videoDuration", paramBaseArticleInfo.mVideoDuration + "")).append(a(localMap, "title", paramBaseArticleInfo.mTitle)).append(a(localMap, "firstPagePicUrl", URLEncoder.encode(paramBaseArticleInfo.mVideoCoverUrl.getPath(), "UTF-8"))).append(a(localMap, "articleContentUrl", URLEncoder.encode(paramBaseArticleInfo.mArticleContentUrl, "UTF-8"))).append(a(localMap, "subscribeName", paramBaseArticleInfo.mSubscribeName)).append(a(localMap, "subscribeID", paramBaseArticleInfo.mSubscribeID)).append(a(localMap, "readinjoyNotDecodeUrl", "1"));
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.d("ReadInJoyUtils", 2, paramBaseArticleInfo.getMessage());
    }
    return paramString;
  }
  
  public static String c(String paramString, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfString == null)) {}
    label65:
    for (;;)
    {
      return null;
      int j = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label65;
        }
        String str = paramArrayOfString[i];
        if (str.contains(paramString))
        {
          paramString = str.split("=");
          if ((paramString == null) || (paramString.length != 2)) {
            break;
          }
          return paramString[1];
        }
        i += 1;
      }
    }
  }
  
  private static JSONArray c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.toString())))
        {
          paramString = paramString.optJSONArray("videos");
          if (paramString != null)
          {
            int i = paramString.length();
            if (i >= 1) {
              continue;
            }
          }
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private static JSONObject c(String paramString)
  {
    paramString = c(paramString);
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return paramString.optJSONObject(0);
  }
  
  public static void c(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo == null) || (paramContext == null))
    {
      QLog.d("ReadInJoyUtils", 1, "clickCommentBiuCard error!");
      return;
    }
    String str;
    if ((paramInt == 6) && (kqc.Ap()))
    {
      if ((paramArticleInfo.isCardJumpUrlAvailable != 1) || (TextUtils.isEmpty(paramArticleInfo.getCardJumpUrl()))) {
        break label146;
      }
      str = paramArticleInfo.getCardJumpUrl();
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str)) {
        a(paramContext, paramArticleInfo, paramInt, false, 0, false);
      }
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "clickCommentBiuCard,clickType=" + paramInt + " ,jumpUrl=" + str);
        return;
        if ((paramInt != 8) || (!kqc.Ar()) || (TextUtils.isEmpty(paramArticleInfo.commentBtnJumpUrl))) {
          break label146;
        }
        str = paramArticleInfo.commentBtnJumpUrl;
        break;
        C(paramContext, str);
      }
      label146:
      str = "";
    }
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null) {
      paramHashMap.put("param_networkDetail", Integer.toString(Y(paramContext)));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramHashMap != null)
      {
        Iterator localIterator = paramHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(" ");
        }
      }
      QLog.d("Q.readinjoy.video", 2, "actKandianVideoGetUrl, success =" + paramBoolean + ",  data=" + localStringBuilder.toString());
    }
    anpc.a(paramContext).collectPerformance(paramString, "actKandianVideoGetUrl", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void c(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mVideoColumnInfo == null)) {
      return;
    }
    kbp.a(null, null, "0X800A1C3", "0X800A1C3", 0, 0, "", "", "", new nce.a(null, null, null, null).h(paramBaseArticleInfo.innerUniqueID).c(paramBaseArticleInfo).d(paramBaseArticleInfo).R(paramInt).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo, false).a().toJsonString(), false);
  }
  
  public static void c(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mGroupSubArticleList == null) || (paramBaseArticleInfo.mGroupSubArticleList.isEmpty())) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[");
    int j = paramBaseArticleInfo.mGroupSubArticleList.size();
    int i = 0;
    while (i < j)
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(i);
      String str = localBaseArticleInfo.getInnerUniqueID();
      int m = localBaseArticleInfo.mPolymericInfo.aSh;
      if (localBaseArticleInfo.mPolymericInfo.hasExposed)
      {
        localStringBuilder.append(str);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUtils", 2, "position：" + m + ", rowKey: " + str);
        }
      }
      if ((j != 1) && (i != j - 1)) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    kbp.a(null, null, "0X800A5AA", "0X800A5AA", 0, 0, "", "", "", new nce.a(paramString, null, null, null, null).W(54).h(localStringBuilder.toString()).a().toJsonString(), false);
  }
  
  public static void c(String paramString, Object paramObject, boolean paramBoolean)
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      paramObject = aqoj.C(((ByteArrayOutputStream)localObject).toByteArray());
      localObject = awit.a(getAppRuntime(), true, paramBoolean);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramObject);
        ((SharedPreferences.Editor)localObject).commit();
      }
      QLog.d("ReadInJoyUtils", 2, "asyncWriteDataToSP successful !  key : " + paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.d("ReadInJoyUtils", 2, "write hb info to storage , error : " + paramString.toString());
    }
  }
  
  public static void c(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actKanDianViolaJsError", paramBoolean, -1L, -1L, paramHashMap, null, true);
  }
  
  public static void cn(View paramView)
  {
    if (paramView != null)
    {
      paramView.setBackgroundResource(0);
      if (ThemeUtil.isNowThemeIsNight(getAppRuntime(), false, null)) {
        paramView.setBackgroundColor(Color.parseColor("#888888"));
      }
    }
    else
    {
      return;
    }
    paramView.setBackgroundColor(-1);
  }
  
  public static String d(ArticleInfo paramArticleInfo)
  {
    return a(paramArticleInfo, false);
  }
  
  public static String d(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    do
    {
      do
      {
        return null;
      } while ((paramBaseArticleInfo.isCardJumpUrlAvailable != 1) || (TextUtils.isEmpty(paramBaseArticleInfo.mCardJumpUrl)));
      paramBaseArticleInfo = nwl.fh(paramBaseArticleInfo.mCardJumpUrl);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "shortContentUrl: " + paramBaseArticleInfo);
      }
    } while (!ntp.ek(paramBaseArticleInfo));
    return ntp.fd(paramBaseArticleInfo);
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    anpc.a(paramContext).collectPerformance(paramString, "actVideoFeedsStartTime", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void d(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView.getParent() instanceof View)) {
      a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, (View)paramView.getParent());
    }
  }
  
  @Deprecated
  public static boolean dA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = paramString.split("/");
      } while (paramString.length < 2);
      paramString = paramString[(paramString.length - 2)].split("_");
    } while (paramString.length < 1);
    return "open".equals(paramString[(paramString.length - 1)]);
  }
  
  public static boolean dB(String paramString)
  {
    Object localObject1 = new ArrayList();
    label50:
    int i;
    do
    {
      do
      {
        while (!((Iterator)localObject1).hasNext()) {
          try
          {
            localObject2 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
            if (localObject2 == null) {
              return false;
            }
            localObject2 = ((Conversation)localObject2).a().dv();
            if (localObject2 == null) {
              return false;
            }
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              if (!(localObject3 instanceof RecentBaseData)) {
                break label50;
              }
              ((List)localObject1).add((RecentBaseData)localObject3);
              break label50;
            }
            localObject1 = ((List)localObject1).iterator();
          }
          catch (Exception paramString)
          {
            QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + paramString.toString());
            return false;
          }
        }
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
      } while (localObject2 == null);
      Object localObject2 = (RecentUserBaseData)localObject2;
      if (TextUtils.equals(((RecentUserBaseData)localObject2).qx(), paramString)) {
        return true;
      }
      i = ((RecentUserBaseData)localObject2).mMenuFlag;
    } while ((i & 0x20) != 0);
    return false;
  }
  
  public static boolean dC(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString.getHost()))
      {
        bool1 = bool2;
        if (paramString.getHost().equals("kandian.qq.com"))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString.getPath())) {
            if (!paramString.getPath().equals("/mqq/vue/wendadetail"))
            {
              bool1 = bool2;
              if (!paramString.getPath().equals("/mqq/vue/wenda")) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean dD(String paramString)
  {
    return TextUtils.equals(acbn.blN, paramString);
  }
  
  public static boolean dE(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label49;
      }
    }
    label49:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null) {
        return ((acja)((AppInterface)localObject).getManager(56)).f(Long.valueOf(paramString));
      }
      return false;
    }
  }
  
  public static boolean dF(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = aurr.getArgumentsFromURL(paramString);
      return (paramString != null) && ("1".equalsIgnoreCase((String)paramString.get("jump_android_hemera")));
    }
    return false;
  }
  
  public static boolean dG(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = aurr.getArgumentsFromURL(paramString);
      return (paramString != null) && ("5".equalsIgnoreCase((String)paramString.get("target")));
    }
    return false;
  }
  
  public static int dc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public static boolean dq(int paramInt)
  {
    return paramInt == 9999;
  }
  
  public static boolean dr(int paramInt)
  {
    boolean bool = false;
    int i;
    if ((paramInt != 5) && (paramInt != 6))
    {
      if (paramInt != 43) {
        break label39;
      }
      i = 1;
      if (paramInt != 18) {
        break label44;
      }
    }
    label39:
    label44:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt | i) != 0) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public static boolean ds(int paramInt)
  {
    boolean bool = true;
    if ((paramInt != 0) && (!kys.du(paramInt))) {
      return false;
    }
    if (Aladdin.getConfig(256).getIntegerFromString("enable_delete_article_after_refresh", 0) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean dz(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.startsWith("http://qqpublic.qpic.cn"))
      {
        paramString = paramString.split("/");
        bool1 = bool2;
        if (paramString.length >= 2)
        {
          paramString = paramString[(paramString.length - 2)].split("_");
          bool1 = bool2;
          if (paramString.length >= 1)
          {
            paramString = paramString[(paramString.length - 1)];
            if (!TextUtils.equals("open", paramString))
            {
              bool1 = bool2;
              if (!TextUtils.equals("vsmcut", paramString)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static String e(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.DD())) {
      return "1";
    }
    return "0";
  }
  
  public static String e(BaseArticleInfo paramBaseArticleInfo)
  {
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramBaseArticleInfo != null)
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)) {
        break label22;
      }
      localObject = localStringBuilder;
    }
    label22:
    do
    {
      do
      {
        return localObject;
        paramBaseArticleInfo = nwl.fh(paramBaseArticleInfo.mArticleContentUrl);
        localObject = localStringBuilder;
      } while (!ntp.ek(paramBaseArticleInfo));
      paramBaseArticleInfo = ntp.fd(paramBaseArticleInfo);
      localObject = paramBaseArticleInfo;
    } while (!QLog.isColorLevel());
    localStringBuilder = new StringBuilder().append("get viola url from articleContentUrl: ");
    if (paramBaseArticleInfo != null) {}
    for (localObject = paramBaseArticleInfo;; localObject = "null")
    {
      QLog.d("ReadInJoyUtils", 2, (String)localObject);
      return paramBaseArticleInfo;
    }
  }
  
  public static String e(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      if (paramInt > 0) {
        localJSONObject.put("from", paramInt);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("video_session_id", paramString2);
      }
      paramString2 = localJSONObject.toString();
      return paramString2;
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  @TargetApi(23)
  public static void e(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public static void e(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    anpc.a(paramContext).collectPerformance(paramString, "actVideoFeedsScrollIntervalTime", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void e(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramArticleInfo.proteusItemsData))) {}
    for (;;)
    {
      return;
      lux.w(paramArticleInfo);
      try
      {
        Object localObject = new JSONObject(paramArticleInfo.proteusItemsData);
        QLog.d("ReadInJoyUtils", 2, new Object[] { "mArticleInfo.proteusItemsData = ", paramArticleInfo.proteusItemsData });
        localObject = ((JSONObject)localObject).keys();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!"id_super_topic".equals((String)((Iterator)localObject).next()));
        paramArticleInfo.isSuperTopic = true;
        return;
      }
      catch (JSONException paramArticleInfo)
      {
        QLog.d("ReadInJoyUtils", 2, "preParseProteusItemData", paramArticleInfo);
      }
    }
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentUin(), null, "qqsetting_kandian_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "isDeleteNewKandian, flag = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public static boolean e(MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord.extStr != null) && ((paramMessageRecord.extLong & 0x1) == 1) && (paramMessageRecord.extStr.contains("lockDisplay")) && (paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "neadForceNotification, ret=" + bool + ", mr=" + paramMessageRecord);
      }
      return bool;
      bool = false;
    }
  }
  
  public static String eA(String paramString)
  {
    Object localObject1 = Aladdin.getConfig(199);
    Object localObject2 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_schema", "");
    String str1 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_h5_android", "");
    String str2 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_package_name", "");
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("${rowkey}", paramString).replace("${uin}", getAccount());
    }
    localObject2 = str1;
    if (!TextUtils.isEmpty(str1)) {
      localObject2 = str1.replace("${rowkey}", paramString).replace("${uin}", getAccount());
    }
    paramString = new StringBuilder();
    try
    {
      paramString.append("mqqapi://readinjoy/open?src_type=internal&target=4").append("&defaultURL=").append(URLEncoder.encode((String)localObject2, "utf-8")).append("&appSchema=").append(URLEncoder.encode((String)localObject1, "utf-8")).append("&appPackageName=").append(str2).append("&readinjoyNotDecodeUrl=1").append("&version=1").append("&isCancelJump=0");
      QLog.e("ReadInJoyUtils", 1, "getNoDifferenceJumpToAppSchema schema: " + paramString.toString());
      awit.eDO();
      paramString = paramString.toString();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.e("ReadInJoyUtils", 1, "getNoDifferenceJumpToAppSchema UnsupportedEncodingException: " + paramString);
    }
    return "";
  }
  
  public static String et(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wording", paramString);
      localJSONObject.put("folder_status", aMw);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String eu(String paramString)
  {
    return P(paramString, "");
  }
  
  public static String ev(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.length() < 8) {
      return paramString + "|" + paramString.length();
    }
    return paramString.substring(0, 8) + "|" + paramString.length();
  }
  
  public static String ew(String paramString)
  {
    if (aqgz.hL() > 720L) {
      return E(paramString, 18);
    }
    return E(paramString, 24);
  }
  
  public static String ex(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("&tp=webp"))) {
      return paramString;
    }
    return paramString.replace("&tp=webp", "");
  }
  
  public static String ey(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        paramString = new BigInteger(paramString);
        QLog.d("ReadInJoyUtils", 2, new Object[] { "convertArticleID bigInteger long value = ", Long.valueOf(paramString.longValue()) });
        return "" + paramString.longValue();
        paramString = "0";
      }
      return "0";
    }
    catch (Exception paramString)
    {
      QLog.d("ReadInJoyUtils", 1, new Object[] { "convertArticleID e = ", paramString.toString() });
    }
  }
  
  public static String ez(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return kwt.acF + aqgo.encodeToString(paramString.getBytes(), 2);
  }
  
  public static String f(Context paramContext, String paramString1, String paramString2)
  {
    int i = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", aMw);
      localJSONObject.put("session_id", adt);
      if (aqiw.isWifiConnected(paramContext)) {
        i = 0;
      }
      for (;;)
      {
        localJSONObject.put("network", i);
        localJSONObject.put("version", paramString1);
        localJSONObject.put("os", 1);
        localJSONObject.put("uin", paramString2);
        return localJSONObject.toString();
        boolean bool = aqiw.is3Gor4G(paramContext);
        if (!bool) {
          i = 2;
        }
      }
      return "";
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String f(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return "";
    }
    Object localObject2 = kwt.acD;
    Object localObject1 = "";
    if (((String)localObject2).contains("uin")) {
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin > 0L)) {
        localObject1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
      }
    }
    for (localObject1 = ((String)localObject2).replace("uin=", "uin=" + aqgo.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (((String)localObject1).contains("&feedstype=")) {
        localObject2 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mFeedType);
      }
      paramArticleInfo = (String)localObject2 + String.valueOf(paramArticleInfo.mFeedId);
      QLog.d("ReadInJoyUtils", 2, new Object[] { "getNewSocialSecondUrl = ", paramArticleInfo });
      return paramArticleInfo;
      if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
        break;
      }
      localObject1 = paramArticleInfo.mSubscribeID;
      break;
    }
  }
  
  public static String f(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject2 = "";
    Object localObject1;
    if (g((ArticleInfo)paramBaseArticleInfo))
    {
      localObject1 = localObject2;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        localObject1 = localObject2;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
          localObject1 = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (mde.h((ArticleInfo)paramBaseArticleInfo) == 2)
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).addAll(((articlesummary.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
            paramBaseArticleInfo = "";
            int i = 0;
            while (i < ((ArrayList)localObject2).size())
            {
              localObject1 = paramBaseArticleInfo + ((ArrayList)localObject2).get(i);
              paramBaseArticleInfo = (BaseArticleInfo)localObject1;
              if (i != ((ArrayList)localObject2).size() - 1) {
                paramBaseArticleInfo = (String)localObject1 + ",";
              }
              i += 1;
            }
            return paramBaseArticleInfo;
          }
          if (mde.h((ArticleInfo)paramBaseArticleInfo) == 1) {
            return ((articlesummary.SpecialTopicInfo)paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
          }
          if (mde.h((ArticleInfo)paramBaseArticleInfo) == 3) {
            return paramBaseArticleInfo.mSubscribeID;
          }
          if (ndi.K((ArticleInfo)paramBaseArticleInfo)) {
            return paramBaseArticleInfo.mSubscribeID;
          }
          if ((!ndi.ak(paramBaseArticleInfo)) && (!ndi.S((ArticleInfo)paramBaseArticleInfo)) && (!ndi.T((ArticleInfo)paramBaseArticleInfo)) && (!ndi.U((ArticleInfo)paramBaseArticleInfo))) {
            break;
          }
          localObject1 = localObject2;
        } while (paramBaseArticleInfo.mSocialFeedInfo == null);
        localObject1 = localObject2;
      } while (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null);
      return String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
      if (ndi.am(paramBaseArticleInfo)) {
        return paramBaseArticleInfo.mSubscribeID;
      }
      if (ndi.X((ArticleInfo)paramBaseArticleInfo)) {
        return paramBaseArticleInfo.mSubscribeID;
      }
      if (B(paramBaseArticleInfo)) {
        return paramBaseArticleInfo.mSubscribeID;
      }
      if (paramBaseArticleInfo.isPGCShortContent()) {
        return paramBaseArticleInfo.mSubscribeID;
      }
      localObject1 = localObject2;
    } while (!paramBaseArticleInfo.isAccountShown);
    return paramBaseArticleInfo.mSubscribeID;
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(Y(paramContext)));
    anpc.a(paramContext).collectPerformance(paramString, "actKandianVideoBehaviors", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface)
  {
    int j = aMt;
    if ((paramQQAppInterface == null) || (j <= 0)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = aajt.a().fl;
      if (localObject1 != null) {
        localArrayList.addAll((Collection)localObject1);
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (RecentUserBaseData)localObject2;
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (nyn.f(paramQQAppInterface, ((RecentUserBaseData)localObject2).mUser.uin)))
          {
            ((Iterator)localObject1).remove();
            continue;
            return false;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + paramQQAppInterface.toString());
    }
    for (;;)
    {
      int m = localArrayList.size();
      int i = j;
      if (j > m) {
        i = m;
      }
      while (j < i)
      {
        paramQQAppInterface = (RecentBaseData)localArrayList.get(j);
        if (paramQQAppInterface != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)paramQQAppInterface).qx(), acbn.blx);
          if (bool) {
            return true;
          }
        }
        j += 1;
        continue;
        j = 0;
      }
    }
  }
  
  public static boolean f(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (!paramMessageRecord.mIsParsed) {
        paramMessageRecord.parse();
      }
      if (paramMessageRecord.structingMsg != null) {
        break label32;
      }
    }
    for (;;)
    {
      return true;
      label32:
      if (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mExtraData)) {
        try
        {
          int i = new JSONObject(paramMessageRecord.structingMsg.mExtraData).optInt("keyguard_jump", 1);
          if (i != 1) {
            return false;
          }
        }
        catch (JSONException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return true;
  }
  
  public static String g(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.isSubscriptFeed()) {
      return "3";
    }
    if ((paramBaseArticleInfo.mPackInfoObj == null) || (!paramBaseArticleInfo.mPackInfoObj.pack_type.has())) {
      return "";
    }
    int i = paramBaseArticleInfo.mPackInfoObj.pack_type.get();
    if ((i == 3) && (paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) && (((articlesummary.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.has())) {
      return "1";
    }
    if ((i == 2) && (paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.has())) {
      return "2";
    }
    return "";
  }
  
  public static void g(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(Y(paramContext)));
    anpc.a(paramContext).collectPerformance(paramString, "actKandianVideoBehaviorsSeq", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static boolean g(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    return mde.dP(ndi.k(paramArticleInfo));
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface)
  {
    KeyguardManager localKeyguardManager = (KeyguardManager)BaseApplicationImpl.getContext().getApplicationContext().getSystemService("keyguard");
    return (paramQQAppInterface.isBackground_Pause) || (paramQQAppInterface.isBackground_Stop) || (localKeyguardManager.inKeyguardRestrictedInputMode());
  }
  
  public static boolean g(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord) == 1;
  }
  
  public static String getAccount()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 != null) {
      localObject1 = ((BaseApplicationImpl)localObject2).getRuntime();
    }
    if (localObject1 == null) {
      localObject1 = "0";
    }
    do
    {
      return localObject1;
      localObject2 = ((AppRuntime)localObject1).getAccount();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return "0";
  }
  
  public static AppRuntime getAppRuntime()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static long getLongAccountUin()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    if (localAppRuntime == null) {
      return 0L;
    }
    return localAppRuntime.getLongAccountUin();
  }
  
  public static int getSeq()
  {
    try
    {
      aMu += 1;
      int i = aMu;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static String getStackTrace(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 4998	java/io/StringWriter
    //   5: dup
    //   6: invokespecial 4999	java/io/StringWriter:<init>	()V
    //   9: astore_1
    //   10: new 5001	java/io/PrintWriter
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 5004	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   18: astore_3
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 5007	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   24: aload_3
    //   25: invokevirtual 5008	java/io/PrintWriter:flush	()V
    //   28: aload_1
    //   29: invokevirtual 5009	java/io/StringWriter:flush	()V
    //   32: aload_1
    //   33: ifnull +7 -> 40
    //   36: aload_1
    //   37: invokevirtual 5010	java/io/StringWriter:close	()V
    //   40: aload_3
    //   41: ifnull +7 -> 48
    //   44: aload_3
    //   45: invokevirtual 5011	java/io/PrintWriter:close	()V
    //   48: aload_1
    //   49: invokevirtual 5012	java/io/StringWriter:toString	()Ljava/lang/String;
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 2175	java/io/IOException:printStackTrace	()V
    //   58: goto -18 -> 40
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 5010	java/io/StringWriter:close	()V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 5011	java/io/PrintWriter:close	()V
    //   80: aload_0
    //   81: athrow
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 2175	java/io/IOException:printStackTrace	()V
    //   87: goto -15 -> 72
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_3
    //   93: aload_1
    //   94: astore_2
    //   95: aload_3
    //   96: astore_1
    //   97: goto -33 -> 64
    //   100: astore_0
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: astore_1
    //   105: goto -41 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramThrowable	Throwable
    //   9	96	1	localObject1	Object
    //   1	68	2	localObject2	Object
    //   82	2	2	localIOException	IOException
    //   94	9	2	localObject3	Object
    //   18	86	3	localPrintWriter	java.io.PrintWriter
    // Exception table:
    //   from	to	target	type
    //   36	40	53	java/io/IOException
    //   2	10	61	finally
    //   68	72	82	java/io/IOException
    //   10	19	90	finally
    //   19	32	100	finally
  }
  
  public static String getString(int paramInt)
  {
    return BaseApplication.getContext().getResources().getString(paramInt);
  }
  
  public static int getUserMode()
  {
    int i = 0;
    if (anwa.aze()) {
      i = 1;
    }
    while (!Be()) {
      return i;
    }
    return 2;
  }
  
  public static String getWifiMacAddress(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = alkz.a(paramContext).getBSSID();
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      paramContext = "";
    }
  }
  
  public static String h(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    if (paramBaseArticleInfo.isSubscriptFeed()) {
      return "1";
    }
    if ((paramBaseArticleInfo.mPackInfoObj != null) && (paramBaseArticleInfo.mPackInfoObj.has()) && (paramBaseArticleInfo.mPackInfoObj.pack_type.get() == 3)) {
      return "2";
    }
    return "";
  }
  
  private static boolean h(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.isAccountShown) {
      return false;
    }
    switch (paramArticleInfo.mFeedType)
    {
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return false;
    case 0: 
    case 8: 
    case 10: 
    case 12: 
    case 16: 
    case 17: 
      return true;
    }
    switch (ndi.k(paramArticleInfo))
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static String i(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!kys.dv((int)paramBaseArticleInfo.mChannelID)) || (TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData))) {
      return "";
    }
    try
    {
      paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.proteusItemsData).optString("card_report_params");
      return paramBaseArticleInfo;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("ReadInJoyUtils", 1, paramBaseArticleInfo, new Object[0]);
    }
    return "";
  }
  
  public static String i(JSONObject paramJSONObject)
  {
    int i = 1;
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("folder_status", aMw);
      if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        localJSONObject.put("reddot_style", i);
        localJSONObject.put("kandian_mode", nR());
        localJSONObject.put("kandian_mode_new", kct.nd());
        localJSONObject.put("tab_source", nQ());
        localJSONObject.put("session_id", adt);
        paramJSONObject = localJSONObject.toString();
        return paramJSONObject;
        i = 0;
      }
      return "";
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static JSONArray i()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Object localObject = (String)awit.f("key_study_mode_grade_choose", "");
      QLog.d("ReadInJoyUtils", 1, "getSelectedGrades error! result= " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONArray((String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyUtils", 1, "getSelectedGrades error! msg= " + localException);
    }
    return localJSONArray;
  }
  
  public static boolean i(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 17) {
      return false;
    }
    return true;
  }
  
  public static String iP()
  {
    return aq(-1L);
  }
  
  public static String iQ()
  {
    int i = 1;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", aMw);
      if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        ((JSONObject)localObject).put("reddot_style", i);
        ((JSONObject)localObject).put("kandian_mode", nR());
        ((JSONObject)localObject).put("kandian_mode_new", kct.nd());
        ((JSONObject)localObject).put("tab_source", nQ());
        ((JSONObject)localObject).put("session_id", adt);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
        i = 0;
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public static String iR()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", aMw);
      localJSONObject.put("kandian_mode", String.valueOf(nR()));
      localJSONObject.put("kandian_mode_new", kct.nd());
      localJSONObject.put("session_id", adt);
      if (lhf.Ci()) {}
      for (String str = "1";; str = "0")
      {
        localJSONObject.put("is_requesting_articles", str);
        localJSONObject.put("os", 1);
        localJSONObject.put("version", kct.XU);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public static String iS()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", aMw);
      ((JSONObject)localObject).put("session_id", adt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String iT()
  {
    Object localObject;
    if (aMy >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = auri.aT("d059d3", 5);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    aMy += 1;
    return "null";
  }
  
  public static String iU()
  {
    Object localObject;
    if (aMz >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = auri.aU("d059d3", 5);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    aMz += 1;
    return "null";
  }
  
  public static String iV()
  {
    if (TextUtils.isEmpty(adp))
    {
      Object localObject2 = iT();
      String str = iU();
      if ((!((String)localObject2).equals("null")) && (!str.equals("null")))
      {
        adp = "0," + (String)localObject2 + "," + str;
        return adp;
      }
      Object localObject1 = localObject2;
      if (((String)localObject2).equals("null")) {
        localObject1 = "0";
      }
      localObject2 = str;
      if (str.equals("null")) {
        localObject2 = "0";
      }
      return "0," + (String)localObject1 + "," + (String)localObject2;
    }
    return adp;
  }
  
  public static String iW()
  {
    JSONObject localJSONObject = new JSONObject();
    T(localJSONObject);
    return localJSONObject.toString();
  }
  
  public static String iX()
  {
    if (adu == null) {
      return "0";
    }
    return adu;
  }
  
  public static String iY()
  {
    oel.bdR();
    StringBuilder localStringBuilder = new StringBuilder("{");
    a(localStringBuilder, "probesize", Long.valueOf(awit.iT()));
    localStringBuilder.append(",");
    a(localStringBuilder, "isFFProbelistSwitch", Boolean.valueOf(awit.aMO()));
    localStringBuilder.append(",");
    a(localStringBuilder, "isDownloadAsyncIo", Boolean.valueOf(awit.aMP()));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static boolean isAppOnForeground(Context paramContext)
  {
    paramContext = getAppRuntime();
    if (paramContext == null) {}
    while ((paramContext.isBackground_Pause) || (paramContext.isBackground_Stop)) {
      return false;
    }
    return true;
  }
  
  public static boolean isInMainThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static String j(ArrayList<DislikeInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return "";
    }
    localJSONArray = new JSONArray();
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", localDislikeInfo.type);
        localJSONObject.put("name", localDislikeInfo.agQ);
        localJSONObject.put("tagid", localDislikeInfo.vf);
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray.toString();
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public static void j(MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.c = paramMessageRecord;
  }
  
  public static boolean j(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 16) {
      return false;
    }
    return true;
  }
  
  public static boolean j(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.mVideoCoverUrl == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mVideoVid))) {
      return false;
    }
    return true;
  }
  
  public static boolean k(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.longValue() == 23L);
  }
  
  public static boolean k(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    if ((paramBaseArticleInfo.mFeedType == 0) && (paramBaseArticleInfo.mIsGallery > 0) && (paramBaseArticleInfo.mGalleryFeedsInfo != null))
    {
      int i = paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
      if ((i == 3) || (i == 2) || (i == 1))
      {
        paramBaseArticleInfo.mIsGalleryChannel = true;
        return true;
      }
    }
    paramBaseArticleInfo.mIsGalleryChannel = false;
    return false;
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 19) {
      return false;
    }
    return true;
  }
  
  public static boolean l(BaseArticleInfo paramBaseArticleInfo)
  {
    if (B(paramBaseArticleInfo))
    {
      paramBaseArticleInfo = (mhr.a)paramBaseArticleInfo.mNewPolymericInfo.iP.get(0);
      return (paramBaseArticleInfo.a != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.a.vid));
    }
    return false;
  }
  
  public static void m(int paramInt, List<auuw.a> paramList)
  {
    auuw.a locala;
    if ((paramInt & 0x1) != 0)
    {
      locala = new auuw.a();
      locala.id = 0;
      locala.iconId = 2130843671;
      paramList.add(locala);
    }
    if ((paramInt & 0x2) != 0)
    {
      locala = new auuw.a();
      locala.id = 1;
      locala.iconId = 2130843672;
      paramList.add(locala);
    }
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 18) {
      return false;
    }
    return true;
  }
  
  public static boolean m(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = true;
    if (paramBaseArticleInfo == null) {
      return false;
    }
    if ((paramBaseArticleInfo.mShowBigPicture) && (paramBaseArticleInfo.mIsGallery == 1))
    {
      bool1 = bool2;
      if (paramBaseArticleInfo.articleStyle != 3)
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.articleStyle != 4)
        {
          bool1 = bool2;
          if (paramBaseArticleInfo.articleStyle != 5)
          {
            bool1 = bool2;
            if (paramBaseArticleInfo.articleStyle != 6) {
              if (!k(paramBaseArticleInfo)) {
                break label75;
              }
            }
          }
        }
      }
    }
    label75:
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static void mC(String paramString)
  {
    Object localObject = awit.a(getAppRuntime(), true, false);
    if (localObject == null)
    {
      QLog.d("ReadInJoyUtils", 1, "updateVideoAutoPlaySetting failed to get sp");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (nR() == 6) {
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", paramString);
    }
    for (;;)
    {
      awit.a((SharedPreferences.Editor)localObject, true);
      return;
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", paramString);
    }
  }
  
  public static void mD(String paramString)
  {
    adt = paramString;
  }
  
  public static void mE(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      awit.H("key_study_mode_grade_choose", paramString);
      lcc.a().a(new kxq(paramString));
    }
    QLog.d("ReadInJoyUtils", 1, "updateSelectedGrades ! res= " + paramString);
  }
  
  public static void mF(String paramString)
  {
    try
    {
      kxm.b localb = new kxm.b();
      localb.m();
      localb.n();
      kbp.a(null, "", paramString, paramString, 0, 0, "", "", "", localb.build(), false);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("ReadInJoyUtils", 1, "gradeEntryReport error! e= " + paramString);
    }
  }
  
  public static void mG(String paramString)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", aMw);
      localJSONObject.put("tab_source", paramString);
      paramString = localJSONObject.toString();
      kbp.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", paramString, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramString = str;
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoyUtils", 2, "firstClassDeliverOperationReport:" + localJSONException.toString());
          paramString = str;
        }
      }
    }
  }
  
  public static void mH(String paramString)
  {
    if (adx != null) {
      kxy.mI(adx);
    }
    adx = paramString;
  }
  
  public static void mO(boolean paramBoolean)
  {
    aip = paramBoolean;
  }
  
  public static void mP(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        if (a() == null) {
          break label261;
        }
        if (!awit.aMG()) {
          return;
        }
        Object localObject = (KandianMergeManager)a().getManager(162);
        JSONObject localJSONObject = v();
        if ((!((KandianMergeManager)localObject).Bv()) && (!((KandianMergeManager)localObject).BD()))
        {
          i = 1;
          if (i != 3) {
            break label245;
          }
          localObject = ((KandianMergeManager)localObject).ol() + "";
          localJSONObject.put("tab_status", i);
          localJSONObject.put("kandian_mode_new", kct.nd());
          if (i == 3) {
            localJSONObject.put("reddot_num", localObject);
          }
          a(true, localJSONObject);
          if (aMC != 0) {
            break label251;
          }
          i = 0;
          localJSONObject.put("button_state", i);
          localJSONObject.put("os", 1);
          localJSONObject.put("version", kct.XU);
          if (!ReadinjoyTabFrame.Dx()) {
            break label256;
          }
          i = 1;
          localJSONObject.put("isInKandian", i);
          if (kfv.a != null) {
            localJSONObject.put("channel_id", kfv.a.mChannelCoverId);
          }
          kbp.a(null, "CliOper", "", null, "0X80081C3", "0X80081C3", 0, 1, null, ey(jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.Wz), jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.ahf, localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      if (localJSONException.ol() > 0)
      {
        i = 3;
        continue;
        label245:
        String str = "0";
        continue;
        label251:
        i = 1;
        continue;
        label256:
        i = 0;
      }
      else
      {
        label261:
        i = 2;
      }
    }
  }
  
  public static void n(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    while (!paramString.contains("dailyJumpSrc")) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dailyJumpSrc", c("dailyJumpSrc", paramString.split("&")));
      localJSONObject.put("jumpSuccess", paramInt1);
      localJSONObject.put("fullScheme", paramString);
      localJSONObject.put("isCancelJump", paramInt2);
      kbp.a(null, null, "0X8009CCD", "0X8009CCD", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean n(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.longValue() != 17L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.longValue() != 16L)) {
      return false;
    }
    return true;
  }
  
  public static boolean n(BaseArticleInfo paramBaseArticleInfo)
  {
    return paramBaseArticleInfo.mIsPolymericGallery;
  }
  
  public static int nO()
  {
    if (getAppRuntime() == null) {
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((Conversation)localObject1).a().dv();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData))
        {
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          return -1;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      int i = 0;
      while (i < localException.size())
      {
        localObject1 = (RecentBaseData)localException.get(i);
        if (localObject1 != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)localObject1).qx(), acbn.blx);
          if (bool) {
            return i;
          }
        }
        i += 1;
      }
    }
  }
  
  public static int nP()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((Conversation)localObject1).a().dv();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData)) {
          localArrayList.add((RecentBaseData)localObject2);
        }
      }
      j = localException.size();
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + localException.toString());
      return -1;
    }
    int j;
    int m;
    if (j > aMt)
    {
      j = aMt;
      break label244;
      if (m < j)
      {
        localObject1 = (RecentBaseData)localException.get(m);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if (!TextUtils.equals(((RecentUserBaseData)localObject1).qx(), acbn.blx))
          {
            if (((RecentUserBaseData)localObject1).ng() == 5000) {
              break label249;
            }
            if (((RecentUserBaseData)localObject1).wU() > 0)
            {
              int n = ((RecentUserBaseData)localObject1).wU();
              i = n + i;
              break label249;
            }
          }
        }
      }
      else
      {
        return i;
      }
    }
    for (;;)
    {
      label244:
      m = 0;
      break;
      label249:
      m += 1;
      break;
    }
  }
  
  public static int nQ()
  {
    int i = 1;
    if (aMA != -1) {
      return aMA;
    }
    if (awit.aMG())
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        return -1;
      }
      Object localObject;
      if ((localBaseActivity instanceof SplashActivity))
      {
        localObject = FrameHelperActivity.a(BaseActivity.sTopActivity);
        if (localObject != null) {}
      }
      for (;;)
      {
        return -1;
        localObject = (ReadinjoyTabFrame)((FrameHelperActivity)localObject).a(ReadinjoyTabFrame.class);
        if (localObject != null)
        {
          if (awit.aMH()) {
            return 2;
          }
          int j = ((ReadinjoyTabFrame)localObject).getCurrentTab();
          if (j == 0) {
            return 1;
          }
          if (j == 2) {
            return 3;
          }
          if (j == 1) {
            return 2;
          }
          if ((localBaseActivity instanceof PublicFragmentActivity))
          {
            if ((localBaseActivity.getIntent() != null) && (QLog.isColorLevel())) {
              QLog.d("ReadInJoyUtils", 2, new Object[] { "ClassName: ", localBaseActivity.getIntent().getStringExtra("public_fragment_class") });
            }
            if ((localBaseActivity.getIntent() != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class").equals("com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment"))) {
              return 3;
            }
            if ((localBaseActivity.getIntent() != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class").equals("com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment"))) {
              return 6;
            }
          }
          if ((localBaseActivity instanceof ReadInJoyNewFeedsActivity)) {
            return ReadInJoyNewFeedsActivity.aJe + 1;
          }
          if ((localBaseActivity instanceof ReadInJoyChannelActivity))
          {
            if (localBaseActivity.getIntent().getIntExtra("channel_id", 0) == 56) {}
            while (i != 0)
            {
              return 2;
              i = 0;
            }
          }
        }
      }
    }
    return ReadInJoyNewFeedsActivity.aJe + 1;
  }
  
  public static int nR()
  {
    return aMB;
  }
  
  public static int nS()
  {
    boolean bool2 = false;
    int n = 1024;
    int i1 = 100;
    int i2 = 2;
    int i;
    int j;
    int m;
    boolean bool1;
    if (!TextUtils.isEmpty(obt.Yi))
    {
      i = i2;
      j = i1;
      m = n;
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(obt.Yi);
        i = i2;
        j = i1;
        m = n;
        bool1 = bool2;
        bool2 = localJSONObject.optBoolean("useNewLogic", false);
        i = i2;
        j = i1;
        m = n;
        bool1 = bool2;
        n = localJSONObject.optInt("minTotalMem", 1024);
        i = i2;
        j = i1;
        m = n;
        bool1 = bool2;
        i1 = localJSONObject.optInt("minAvailableMem", 100);
        i = i2;
        j = i1;
        m = n;
        bool1 = bool2;
        i2 = localJSONObject.optInt("minCpuNum", 2);
        i = i2;
        j = i1;
        m = n;
        bool1 = bool2;
        int i3 = localJSONObject.optInt("minCpuFreq", 1000);
        bool1 = bool2;
        m = i1;
        j = i2;
        i = i3;
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        long l3;
        n = m;
        m = j;
        j = i;
        i = 1000;
        continue;
        if (l2 >>> 20 < m) {
          continue;
        }
        return 2;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        return 1;
        return 0;
      }
      if (bool1)
      {
        l1 = aqgz.getSystemTotalMemory();
        l2 = aqgz.getSystemAvaialbeMemory();
        i1 = aqgz.getCpuNumber();
        l3 = aqgz.getCpuFrequency();
        if ((l1 >>> 20 >= n) && (i1 >= j) && (l3 >= i)) {
          return 1;
        }
      }
      if (Build.VERSION.SDK_INT >= 19) {
        return 1;
      }
      return 0;
      bool1 = false;
      n = 1024;
      m = 100;
      j = 2;
      i = 1000;
    }
  }
  
  public static int nT()
  {
    return KandianVideoUploadService.pj();
  }
  
  public static int nU()
  {
    return Aladdin.getConfig(196).getIntegerFromString("artical_interact_type", 0);
  }
  
  public static int nV()
  {
    return Aladdin.getConfig(199).getIntegerFromString("no_difference_jump_app_jump_src", 0);
  }
  
  public static int nW()
  {
    A = null;
    return nX();
  }
  
  public static int nX()
  {
    if (A == null)
    {
      A = Integer.valueOf(Aladdin.getConfig(215).getIntegerFromString("message_reddot_style", 1));
      if ((!awit.aMG()) && (A.intValue() == 0)) {
        A = Integer.valueOf(1);
      }
      if ((A.intValue() == 2) && (a() != null))
      {
        KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)a().getManager(162)).a();
        if ((localKandianMsgBoxRedPntInfo == null) || (localKandianMsgBoxRedPntInfo.dataType == 1)) {
          break label146;
        }
        A = Integer.valueOf(1);
      }
    }
    label146:
    for (int i = 2;; i = 1)
    {
      QLog.d("ReadInJoyUtils", 1, "init msgboxUIMode : " + A + ", rule : " + i);
      return A.intValue();
    }
  }
  
  public static int nY()
  {
    return Aladdin.getConfig(264).getIntegerFromString("show_timing", 1);
  }
  
  public static int nZ()
  {
    return Aladdin.getConfig(264).getIntegerFromString("open_type", 1);
  }
  
  public static Handler o()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread == null)
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread = new ReadInJoySSOHandlerThread("kandian_network_thread");
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread.start();
        aU = new Handler(jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread.getLooper());
      }
      Handler localHandler = aU;
      return localHandler;
    }
    finally {}
  }
  
  public static boolean o(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.longValue() != 19L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.longValue() != 18L)) {
      return false;
    }
    return true;
  }
  
  public static boolean o(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() > 0);
  }
  
  public static Handler p()
  {
    if (mMainThreadHandler == null) {}
    try
    {
      if (mMainThreadHandler == null) {
        mMainThreadHandler = new Handler(Looper.getMainLooper());
      }
      return mMainThreadHandler;
    }
    finally {}
  }
  
  public static void p(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
    long l = awit.iS();
    if ((l != -1L) && (System.currentTimeMillis() - l < 600000L)) {}
  }
  
  public static boolean p(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 26) {
      return false;
    }
    return true;
  }
  
  public static boolean p(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    int i = ndi.k((ArticleInfo)paramBaseArticleInfo);
    if ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return false;
    }
    switch (i)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static void pV(int paramInt)
  {
    aMw = paramInt;
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.aRV = aMw;
    SPEventReportSwitch.qK(paramInt);
    QLog.d("ReadInJoyUtils", 1, new Object[] { "update fs : ", Integer.valueOf(paramInt) });
  }
  
  public static void pW(int paramInt)
  {
    if (k == null) {
      k = new LinkedBlockingQueue(100);
    }
    if (!k.offer(Integer.valueOf(paramInt)))
    {
      k.poll();
      k.offer(Integer.valueOf(paramInt));
    }
  }
  
  public static void pX(int paramInt)
  {
    aMA = paramInt;
  }
  
  public static void pY(int paramInt)
  {
    aMB = paramInt;
  }
  
  public static boolean q(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.iX == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.iX.size() <= 0) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a.cardStyle != 1);
  }
  
  public static boolean q(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mPolymericInfo != null) && (paramBaseArticleInfo.mPolymericInfo.aRX >= 6);
  }
  
  public static boolean qH()
  {
    long l = System.currentTimeMillis();
    if (l - lastClickTime <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "click too fast");
      }
      lastClickTime = l;
      return true;
    }
    lastClickTime = l;
    return false;
  }
  
  public static boolean r(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u == null)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (paramArticleInfo.mFeedType != 21) {
          break;
        }
      } while (a(paramArticleInfo, false) == 74);
      return false;
      if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.intValue() != 21)) {
        break;
      }
    } while (a(paramArticleInfo, true) == 75);
    return false;
    return false;
  }
  
  public static boolean r(BaseArticleInfo paramBaseArticleInfo)
  {
    return (q(paramBaseArticleInfo)) && (paramBaseArticleInfo.mIsInPolymeric);
  }
  
  public static boolean s(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u == null)) {
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (paramArticleInfo.mFeedType != 22) {
            break;
          }
        } while (a(paramArticleInfo, false) == 72);
        return false;
        if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.intValue() != 22)) {
          break;
        }
      } while (a(paramArticleInfo, true) == 73);
      return false;
    } while ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTb == 4));
    return false;
  }
  
  public static boolean s(BaseArticleInfo paramBaseArticleInfo)
  {
    return (q(paramBaseArticleInfo)) && (paramBaseArticleInfo.mGroupSubArticleList != null);
  }
  
  public static boolean t(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u == null)) {}
    while (paramArticleInfo.mFeedType != 21) {
      return false;
    }
    return true;
  }
  
  public static boolean t(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if ((paramBaseArticleInfo.aSN == 1) && (!TextUtils.isEmpty(paramBaseArticleInfo.ahQ)) && (!TextUtils.isEmpty(paramBaseArticleInfo.ahR))) {
        return true;
      }
    }
    return false;
  }
  
  public static BigInteger toBigInteger(long paramLong)
  {
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    if (paramLong >= 0L) {
      return localBigInteger;
    }
    return localBigInteger.add(jdField_a_of_type_JavaMathBigInteger);
  }
  
  public static boolean u(ArticleInfo paramArticleInfo)
  {
    return (v(paramArticleInfo)) || (w(paramArticleInfo));
  }
  
  public static boolean u(BaseArticleInfo paramBaseArticleInfo)
  {
    return (q(paramBaseArticleInfo)) && ((paramBaseArticleInfo.mPolymericInfo.aRX == 9) || (paramBaseArticleInfo.mPolymericInfo.aRX == 10) || (paramBaseArticleInfo.mPolymericInfo.aRX == 11));
  }
  
  public static JSONObject v()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", aMw);
      localJSONObject.put("session_id", adt);
      localJSONObject.put("kandian_mode_new", kct.nd());
      localJSONObject.put("algorithm_id", jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$a.aeN);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static boolean v(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.intValue() != 21) {
      return false;
    }
    return true;
  }
  
  public static boolean v(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {}
    for (int i = 1; (i != 0) && ((paramBaseArticleInfo.mNewPolymericInfo.aRX == 9) || (paramBaseArticleInfo.mNewPolymericInfo.aRX == 10) || (paramBaseArticleInfo.mNewPolymericInfo.aRX == 11)); i = 0) {
      return true;
    }
    return false;
  }
  
  public static JSONObject w()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", aMw);
      localJSONObject.put("kandian_mode", nR());
      localJSONObject.put("kandian_mode_new", kct.nd());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static boolean w(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.intValue() != 22) {
      return false;
    }
    return true;
  }
  
  public static boolean w(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.aRX == 15);
  }
  
  public static boolean x(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "commentBiuCanJump, canJump= " + bool1);
      return bool1;
      bool1 = bool2;
      if (paramArticleInfo.mFeedType == 36)
      {
        bool1 = bool2;
        if (paramArticleInfo.isCardJumpUrlAvailable == 1)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramArticleInfo.getCardJumpUrl())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static boolean x(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.aRX == 12);
  }
  
  public static boolean y(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "canOpenNativeArticle,articleInfo=" + paramArticleInfo);
      return bool1;
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramArticleInfo.mArticleContentUrl)) {
          bool1 = true;
        }
      }
    }
  }
  
  public static boolean y(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.aRX == 13);
  }
  
  public static boolean z(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mKdLiveInfo != null) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mSubArtilceList.get(0) != null) && (((ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0)).mKdLiveInfo != null);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2);
  }
  
  public static class b
  {
    int aMI = -1;
    int aMJ = -1;
    String adC = null;
    boolean aiA = false;
    boolean aiB = false;
    boolean aiC = false;
    boolean aiD = false;
    boolean aiE = false;
    boolean aiw = false;
    boolean aix = false;
    boolean aiy = false;
    boolean aiz = false;
    JSONObject al = new JSONObject();
    int channelId = -1;
    String skinId = null;
    
    public b() {}
    
    public b(JSONObject paramJSONObject)
    {
      if (paramJSONObject != null) {
        this.al = paramJSONObject;
      }
    }
    
    public b a(int paramInt)
    {
      this.channelId = paramInt;
      return this;
    }
    
    public b a(long paramLong)
      throws JSONException
    {
      this.al.put("algorithm_id", paramLong);
      return this;
    }
    
    public b a(String paramString)
    {
      this.skinId = paramString;
      return this;
    }
    
    public b a(String paramString, int paramInt)
      throws JSONException
    {
      this.al.put(paramString, paramInt);
      return this;
    }
    
    public b a(String paramString, long paramLong)
    {
      try
      {
        this.al.put(paramString, paramLong);
        return this;
      }
      catch (JSONException localJSONException)
      {
        wja.a("ReadInJoyUtils", "", new IllegalArgumentException(paramString + " : " + paramLong));
      }
      return this;
    }
    
    public b a(String paramString, Object paramObject)
    {
      try
      {
        this.al.put(paramString, paramObject);
        return this;
      }
      catch (JSONException localJSONException)
      {
        wja.a("ReadInJoyUtils", "", new IllegalArgumentException(paramString + " : " + paramObject));
      }
      return this;
    }
    
    public b a(String paramString1, String paramString2)
      throws JSONException
    {
      this.al.put(paramString1, paramString2);
      return this;
    }
    
    public b a(@NotNull JSONObject paramJSONObject)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramJSONObject.opt(str);
        try
        {
          this.al.put(str, localObject);
        }
        catch (JSONException localJSONException)
        {
          wja.a("ReadInJoyUtils", "", new IllegalArgumentException(str + " : " + localObject));
        }
      }
      return this;
    }
    
    public b a(boolean paramBoolean)
      throws JSONException
    {
      JSONObject localJSONObject = this.al;
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        localJSONObject.put("reddot", i);
        return this;
      }
    }
    
    public b b()
    {
      this.aiD = true;
      return this;
    }
    
    public b b(int paramInt)
      throws JSONException
    {
      this.al.put("location", paramInt);
      return this;
    }
    
    public b b(long paramLong)
      throws JSONException
    {
      this.al.put("strategy_id", paramLong);
      return this;
    }
    
    public b b(String paramString)
      throws JSONException
    {
      this.al.put("rowkey", paramString);
      return this;
    }
    
    public b b(String paramString, int paramInt)
    {
      try
      {
        this.al.put(paramString, paramInt);
        return this;
      }
      catch (JSONException localJSONException)
      {
        wja.a("ReadInJoyUtils", "", new IllegalArgumentException(paramString + " : " + paramInt));
      }
      return this;
    }
    
    public b b(String paramString1, String paramString2)
    {
      try
      {
        this.al.put(paramString1, paramString2);
        return this;
      }
      catch (JSONException localJSONException)
      {
        wja.a("ReadInJoyUtils", "", new IllegalArgumentException(paramString1 + " : " + paramString2));
      }
      return this;
    }
    
    public b b(boolean paramBoolean)
      throws JSONException
    {
      JSONObject localJSONObject = this.al;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        localJSONObject.put("button_state", i);
        return this;
      }
    }
    
    public String build()
    {
      int i = 1;
      try
      {
        if (this.aiw) {
          this.al.put("folder_status", kxm.aMw);
        }
        if (this.aix) {
          this.al.put("time", System.currentTimeMillis());
        }
        if (this.channelId != -1) {
          this.al.put("channel_id", this.channelId);
        }
        if (this.aiy) {
          this.al.put("kandian_mode", kxm.nR());
        }
        if (this.aiz) {
          this.al.put("kandian_mode_new", kct.nd());
        }
        if (this.aiA) {
          this.al.put("tab_source", kxm.nQ());
        }
        if (this.aiB) {
          this.al.put("session_id", kxm.adt);
        }
        if (this.skinId != null) {
          this.al.put("skin_id", this.skinId);
        }
        if (this.aMI != -1) {
          this.al.put("skin_voice", this.aMI);
        }
        if (this.aMJ != -1) {
          this.al.put("skin_type", this.aMJ);
        }
        Object localObject;
        if (this.aiC)
        {
          localObject = this.al;
          if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label286;
          }
        }
        for (;;)
        {
          ((JSONObject)localObject).put("reddot_style", i);
          if (this.aiD) {
            kct.e(this.al);
          }
          if (this.aiE) {
            this.al.put("os", "1");
          }
          localObject = this.al.toString();
          return localObject;
          label286:
          i = 0;
        }
        return "";
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    
    public b c()
    {
      this.aiw = true;
      return this;
    }
    
    public b c(int paramInt)
      throws JSONException
    {
      this.al.put("type", paramInt);
      return this;
    }
    
    public b c(long paramLong)
      throws JSONException
    {
      this.al.put("article_id", paramLong);
      return this;
    }
    
    public b c(String paramString)
      throws JSONException
    {
      this.al.put("feeds_source", paramString);
      return this;
    }
    
    public b c(boolean paramBoolean)
      throws JSONException
    {
      JSONObject localJSONObject = this.al;
      if (paramBoolean) {}
      for (int i = 2;; i = 0)
      {
        localJSONObject.put("reddot_status", i);
        return this;
      }
    }
    
    public b d()
    {
      this.aix = true;
      return this;
    }
    
    public b d(int paramInt)
    {
      this.aMI = paramInt;
      return this;
    }
    
    public b d(long paramLong)
      throws JSONException
    {
      this.al.put("topicid", paramLong);
      return this;
    }
    
    public b d(String paramString)
      throws JSONException
    {
      JSONObject localJSONObject = this.al;
      if (paramString != null) {}
      for (;;)
      {
        localJSONObject.put("channel_version", paramString);
        return this;
        paramString = "";
      }
    }
    
    public b e()
    {
      this.aiC = true;
      return this;
    }
    
    public b e(int paramInt)
    {
      this.aMJ = paramInt;
      return this;
    }
    
    public b e(String paramString)
      throws JSONException
    {
      JSONObject localJSONObject = this.al;
      if (paramString != null) {}
      for (;;)
      {
        localJSONObject.put("channel_city", paramString);
        return this;
        paramString = "";
      }
    }
    
    public b f()
    {
      this.aiy = true;
      return this;
    }
    
    public b f(int paramInt)
      throws JSONException
    {
      this.al.put("number", paramInt);
      return this;
    }
    
    public b g()
    {
      this.aiz = true;
      return this;
    }
    
    public b g(int paramInt)
      throws JSONException
    {
      this.al.put("words", paramInt);
      return this;
    }
    
    public b h()
    {
      this.aiA = true;
      return this;
    }
    
    public b h(int paramInt)
      throws JSONException
    {
      this.al.put("likes", paramInt);
      return this;
    }
    
    public b i()
    {
      this.aiB = true;
      return this;
    }
    
    public b i(int paramInt)
      throws JSONException
    {
      this.al.put("comment", paramInt);
      return this;
    }
    
    public b j()
    {
      this.aiE = true;
      return this;
    }
    
    public b j(int paramInt)
      throws JSONException
    {
      this.al.put("biu", paramInt);
      return this;
    }
    
    public b k()
      throws JSONException
    {
      this.al.put("imei", kxm.iT());
      return this;
    }
    
    public b k(int paramInt)
      throws JSONException
    {
      this.al.put("feeds_type", paramInt);
      return this;
    }
    
    public b l()
      throws JSONException
    {
      this.al.put("imsi", kxm.iU());
      return this;
    }
    
    public b l(int paramInt)
      throws JSONException
    {
      this.al.put("reddot_num", paramInt);
      return this;
    }
    
    public b m()
      throws JSONException
    {
      JSONObject localJSONObject = this.al;
      if (aqiw.isWifiConnected(null)) {}
      for (int i = 2;; i = 1)
      {
        localJSONObject.put("network_type", i);
        return this;
      }
    }
    
    public b m(int paramInt)
      throws JSONException
    {
      this.al.put("content_type", paramInt);
      return this;
    }
    
    public b n()
    {
      return b("version", kct.XU);
    }
    
    public b n(int paramInt)
      throws JSONException
    {
      this.al.put("reddot_status", paramInt + 1);
      return this;
    }
    
    public b o(int paramInt)
      throws JSONException
    {
      this.al.put("share_option", paramInt);
      return this;
    }
    
    public JSONObject x()
    {
      return this.al;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kxm
 * JD-Core Version:    0.7.0.1
 */