import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.Aladdin.InitParams;
import com.tencent.aladdin.config.Aladdin.InitParams.Builder;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.video.LikeAnimationInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper.1;
import cooperation.readinjoy.ReadInJoyHelper.2;
import cooperation.readinjoy.ReadInJoyHelper.3;
import cooperation.readinjoy.ReadInJoyHelper.4;
import cooperation.readinjoy.ReadInJoyHelper.5;
import cooperation.readinjoy.ReadInJoyHelper.6;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class awit
{
  private static List<liw.a> LT;
  private static long aAY;
  private static long aAZ;
  private static long aBa;
  private static long aBb;
  private static long aBc;
  private static long aBd = -1L;
  private static long aBe = -1L;
  public static final String cQB = acfp.m(2131713635);
  public static String cQC;
  public static String cQD;
  private static String cQE;
  private static String cQF;
  private static String cQG;
  private static String cQH;
  private static String cQI;
  private static String cQJ;
  private static String cQK;
  private static AtomicInteger cv;
  protected static boolean dqs = true;
  private static boolean dqt;
  private static boolean dqu;
  private static boolean dqv;
  private static int eAF;
  private static int eAG;
  private static int eAH;
  private static int eAI;
  private static int eAJ;
  private static int eAK;
  private static int eAL;
  private static int eAM;
  private static int eAN;
  private static int eAO;
  private static int eAP;
  private static int eAQ;
  private static int eAR;
  private static int eAS;
  private static int eAT;
  private static int eAU;
  private static int eAV;
  private static int eAW;
  private static int eAX;
  private static int eAY;
  private static int eAZ;
  private static int eBa;
  private static int eBb;
  private static int eBc;
  private static int eBd;
  private static int eBe;
  private static int eBf = -1;
  public static final String[] je;
  private static ConcurrentHashMap<String, Integer> kg;
  private static HashMap<String, Boolean> qO;
  private static Map<String, Integer> qp;
  private static Map<String, Integer> qq;
  private static Map<String, Boolean> qr;
  
  static
  {
    cQC = "kandian_new_channel_style";
    cQD = "_mode_videochannel_";
    qO = new HashMap();
    je = new String[] { "collectbox", "homepage", "messagebox_V3", "messagebox_pendant_V3", "commentpage", "recommend_friends", "accountpage", "topicvideo", "mytopic", "myhistory", "myfollow", "myfans", "mynotify", "collectbox_V2", "mycomment", "myliked" };
    eAF = -1;
    eAG = -1;
    eAH = -1;
    eAI = -1;
    aAY = -1L;
    eAJ = -1;
    eAK = -1;
    eAL = -1;
    eAM = -1;
    eAN = -1;
    eAO = -1;
    eAP = -1;
    eAQ = -1;
    eAR = -1;
    eAS = -1;
    eAT = -1;
    eAU = -1;
    eAV = -1;
    eAW = -1;
    eAX = -1;
    eAY = -1;
    aBb = -1L;
    eBb = -1;
    eBc = -1;
    eBd = -1;
    cQK = "try_stick_flag";
    qp = new ConcurrentHashMap();
    cv = new AtomicInteger(0);
    aBc = System.currentTimeMillis();
    qq = Collections.synchronizedMap(new HashMap());
    qr = Collections.synchronizedMap(new HashMap());
    kg = new ConcurrentHashMap();
  }
  
  public static int A(AppRuntime paramAppRuntime)
  {
    if ((eAX == 0) || (eAX == 1)) {
      return eAX;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentAtSwitch() failed");
      return 0;
    }
    eAX = paramAppRuntime.getInt("kandian_comment_at_switch", 0);
    return eAX;
  }
  
  private static void A(AppRuntime paramAppRuntime)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyHelper.4(paramAppRuntime));
  }
  
  public static void A(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommendOperator() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoDynamicRecommendOperator() num=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_dynamic_recommend_operator", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void A(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() parseInt failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_biu_profile_at_switch", i);
    a(paramAppRuntime, true);
    eAT = i;
  }
  
  public static boolean A(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("qboss_splash_debug_switch", true);
  }
  
  public static int B(AppRuntime paramAppRuntime)
  {
    if (eAY > 0) {
      return eAY;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigDefaultBitRate() failed");
      return kwt.aMl;
    }
    eAY = paramAppRuntime.getInt("kandian_default_bit_rate", kwt.aMl);
    return eAY;
  }
  
  public static void B(AppRuntime paramAppRuntime)
  {
    dqu = true;
  }
  
  public static void B(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateWebRenderConfig() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateWebRenderConfig() value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramAppRuntime.putBoolean("web_native_render", bool);
      a(paramAppRuntime, true);
      return;
    }
  }
  
  public static void B(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch()parseInt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("diandian_right_button_at_switch_new", i);
    a(paramAppRuntime, true);
  }
  
  public static boolean B(AppRuntime paramAppRuntime)
  {
    if (eAF == -1) {
      ThreadManager.post(new ReadInJoyHelper.2(paramAppRuntime), 8, null, true);
    }
    while (eAF == 1) {
      return true;
    }
    return false;
  }
  
  public static int C(AppRuntime paramAppRuntime)
  {
    if (eBb == -1)
    {
      paramAppRuntime = a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getKandianFollowCount() failed");
        return -1;
      }
      eBb = paramAppRuntime.getInt("kandian_user_is_vip", -1);
    }
    return eBb;
  }
  
  public static void C(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateWebRenderModeConfig() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateWebRenderModeConfig() value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramAppRuntime.putBoolean("web_native_render_mode_start", bool);
      a(paramAppRuntime, true);
      return;
    }
  }
  
  public static void C(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKanDianConfigRightButtonAtSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKanDianConfigRightButtonAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKanDianConfigRightButtonAtSwitch()parseInt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_right_button_at_switch_new", i);
    a(paramAppRuntime, true);
  }
  
  public static boolean C(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKanDianReportTTSwitch() failed");
      return false;
    }
    return paramAppRuntime.getBoolean("KANDIAN_REPORT_TT_SWITCH", false);
  }
  
  public static int D(AppRuntime paramAppRuntime)
  {
    if (eAZ > 0) {
      return eAZ;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianFollowCount() failed");
      return 0;
    }
    eAZ = paramAppRuntime.getInt("kandian_user_follow_count", 0);
    return eAZ;
  }
  
  public static void D(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateViolaDynamicConfig() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateViolaDynamicConfig() value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramAppRuntime.putBoolean("VIOLA_DYNAMIC", bool);
      a(paramAppRuntime, true);
      return;
    }
  }
  
  public static void D(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateReadinjoyQAsquareAutoTimeval() failed");
      return;
    }
    float f;
    try
    {
      f = Float.valueOf(paramString).floatValue();
      if (f < 0.0F)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateReadinjoyQAsquareAutoTimeval() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateReadinjoyQAsquareAutoTimeval()parseFloat failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putFloat("readinjoy_QA_square_autoTimeval", f);
    a(paramAppRuntime, true);
  }
  
  public static boolean D(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getWebRenderConfig() failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("web_native_render", false);
    QLog.d("Q.readinjoy.tt_report", 1, "getWebRenderConfig() result=" + bool);
    return bool;
  }
  
  public static int E(AppRuntime paramAppRuntime)
  {
    if (eBa > 0) {
      return eBa;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianFansCount() failed");
      return 0;
    }
    eBa = paramAppRuntime.getInt("kandian_user_fans_count", 0);
    return eBa;
  }
  
  public static void E(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateViolaWeishiAdConfig failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateViolaWeishiAdConfig value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramAppRuntime.putBoolean("VIOLA_DYNAMIC_WEISHI", bool);
      a(paramAppRuntime, true);
      return;
    }
  }
  
  public static void E(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "update readinjoy to wx switch failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateReadInjoyToWxAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch()parseInt failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, " updateReadInjoyToWxAtSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_share_to_WX_at_switch", i);
    a(paramAppRuntime, true);
    eAU = i;
  }
  
  public static boolean E(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getCanLoadStartWebRenderModeConfig() failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("web_native_render_mode_start", false);
    QLog.d("Q.readinjoy.tt_report", 1, "getCanLoadStartWebRenderModeConfig() result=" + bool);
    return bool;
  }
  
  public static int F(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoChannelCoverStyle() failed");
      return -1;
    }
    return paramAppRuntime.getInt("video_channel_cover_style", 0);
  }
  
  public static void F(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateViolaDiscoverConfig failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateViolaDiscoverConfig value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramAppRuntime.putBoolean("VIOLA_DYNAMIC_DISCOVER", bool);
      a(paramAppRuntime, true);
      return;
    }
  }
  
  public static void F(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() parseInt failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_comment_biu_switch", i);
    a(paramAppRuntime, true);
    eAV = i;
  }
  
  public static boolean F(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getViolaDynamicConfig() failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("VIOLA_DYNAMIC", false);
    QLog.d("Q.readinjoy.tt_report", 1, "getViolaDynamicConfig() result=" + bool);
    return bool;
  }
  
  public static int G(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getGallerySubChannelHidden() failed");
      return -1;
    }
    return paramAppRuntime.getInt("gallery_sub_channel_hidden", 0);
  }
  
  public static void G(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateViolaMessageBoxConfig failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateViolaMessageBoxConfig value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramAppRuntime.putBoolean("VIOLA_DYNAMIC_MESSAGE_BOX", bool);
      a(paramAppRuntime, true);
      return;
    }
  }
  
  public static void G(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() parseInt failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_native_comment_biu_switch", i);
    a(paramAppRuntime, true);
    eAW = i;
  }
  
  public static boolean G(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getViolaWeishiAdConfig failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("VIOLA_DYNAMIC_WEISHI", false);
    QLog.d("Q.readinjoy.tt_report", 1, "getViolaWeishiAdConfig result=" + bool);
    return bool;
  }
  
  public static String GZ()
  {
    String str = "";
    AladdinConfig localAladdinConfig = Aladdin.getConfig(112);
    if (localAladdinConfig != null) {
      str = localAladdinConfig.getString("readinjoy_video_recommend_entrance_url", "");
    }
    return str;
  }
  
  public static int H(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getGallerySubChannelWaterFallHidden() failed");
      return -1;
    }
    return paramAppRuntime.getInt("gallery_sub_channel_waterfall_hidden", 0);
  }
  
  public static <T> void H(String paramString, T paramT)
  {
    e(paramString, paramT, true);
  }
  
  public static void H(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsShortVideoMaxDrationLimit() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsShortVideoMaxDrationLimit() value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_short_video_max_duration_limit", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void H(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() parseInt failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_comment_at_switch", i);
    a(paramAppRuntime, true);
    eAX = i;
  }
  
  public static boolean H(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getViolaMessageBoxConfig failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("VIOLA_DYNAMIC_MESSAGE_BOX", true);
    QLog.d("Q.readinjoy.tt_report", 1, "getViolaMessageBoxConfig result=" + bool);
    return bool;
  }
  
  public static String Ha()
  {
    String str = (String)f("readinjoy_dynamic_buffer_config", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "getDynamicBufferConfig result=" + str);
    }
    return str;
  }
  
  public static String Hb()
  {
    String str = (String)f("readinjoy_viola_page_open_data", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "getViolaPageOpenData result=" + str);
    }
    return str;
  }
  
  public static String Hc()
  {
    String str = (String)f("readinjoy_kingcard_gudieurl", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "getKingCardGuideUrl result=" + str);
    }
    return str;
  }
  
  public static String Hd()
  {
    String str = (String)f("readinjoy_kingcard_tiptext", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "getKingCardTipText result=" + str);
    }
    return str;
  }
  
  public static String He()
  {
    String str = (String)f("readinjoy_kingcard_jumptext", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "getKingCardJumpText result=" + str);
    }
    return str;
  }
  
  public static String Hf()
  {
    return "0xcba";
  }
  
  private static String Hg()
  {
    return kxm.getLongAccountUin() + "_" + "readinjoy_ugc_account_create_complete";
  }
  
  public static int I(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendStrategy() failed");
      return -1;
    }
    int i = paramAppRuntime.getInt("video_dynamic_recommend_strategyid", -1);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoDynamicRecommendStrategy() result=" + i);
    return i;
  }
  
  public static void I(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsSoftAdConfigLocal() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsSoftAdConfigLocal() value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("VIDEO_FEEDS_SOFT_AD_LOCAL_CONFIG", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void I(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigDefaultBitRate() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i <= 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigDefaultBitRate() bitrate <= 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigDefaultBitRate() parseInt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_default_bit_rate", i);
    a(paramAppRuntime, true);
    eAY = i;
  }
  
  public static boolean I(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getViolaPicDetailConfig failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("VIOLA_DYNAMIC_PIC_DETAIL", false);
    QLog.d("Q.readinjoy.tt_report", 1, "getViolaPicDetailConfig result=" + bool);
    return bool;
  }
  
  public static int J(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendDurationLimit() failed");
      return -1;
    }
    int i = paramAppRuntime.getInt("video_dynamic_recommend_duration_limit", -1);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoDynamicRecommendDurationLimit() result=" + i);
    return i;
  }
  
  public static void J(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true).edit();
    paramAppRuntime.putInt("VIDEO_FEEDS_LIKE_ACTION_SHOW_DOWNLOAD_BAR_COUNT_TODAY", paramInt);
    a(paramAppRuntime, true);
  }
  
  private static void J(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateUserMedal() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("kandian_user_medal", paramString);
    a(paramAppRuntime, true);
  }
  
  public static boolean J(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsPrePlaySwitch() failed");
      return true;
    }
    boolean bool = paramAppRuntime.getBoolean("VIDEO_FEEDS_PREPLAY_SWITCH", true);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsPrePlaySwitch() result=" + bool);
    return bool;
  }
  
  public static int K(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendOperator() failed");
      return -1;
    }
    int i = paramAppRuntime.getInt("video_dynamic_recommend_operator", 0);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoDynamicRecommendOperator() result=" + i);
    return i;
  }
  
  public static void K(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBadgeSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_badge_switch", paramInt);
    a(paramAppRuntime, true);
    eBd = paramInt;
  }
  
  public static void K(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelHidden() failed");
      return;
    }
    QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelHidden() value" + paramString);
    try
    {
      int i = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("gallery_sub_channel_hidden", i);
      a(paramAppRuntime, true);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelHidden() Exception");
    }
  }
  
  public static boolean K(AppRuntime paramAppRuntime)
  {
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    localObject = i + j + k;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsInterruptedAdLocalConfigToday() failed");
      return false;
    }
    String str = paramAppRuntime.getString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG_DATE_NEW", null);
    QLog.d("Q.readinjoy.tt_report", 1, "checkIsVideoFeedsInterruptedAdLocalConfigToday localDate = " + str);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG_DATE_NEW", (String)localObject);
    a(paramAppRuntime, true);
    return false;
  }
  
  public static int L(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsSoftAdConfigLocal() failed");
      return 0;
    }
    int i = paramAppRuntime.getInt("VIDEO_FEEDS_SOFT_AD_LOCAL_CONFIG", 0);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsSoftAdConfigLocal() result=" + i);
    return i;
  }
  
  public static void L(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianDeleteOutDateArticleInterval failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_delete_outdate_article_feeds_cnt", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void L(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelWaterFallHidden() failed");
      return;
    }
    QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelWaterFallHidden() value" + paramString);
    try
    {
      int i = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("gallery_sub_channel_waterfall_hidden", i);
      a(paramAppRuntime, true);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelWaterFallHidden() Exception");
    }
  }
  
  private static boolean L(AppRuntime paramAppRuntime)
  {
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    localObject = i + j + k;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsLikeActionDownloadBarRecordToday() failed");
      return false;
    }
    String str = paramAppRuntime.getString("VIDEO_FEEDS_LIKE_ACTION_SHOW_DOWNLOAD_BAR_RECORD_DATE", null);
    QLog.d("Q.readinjoy.tt_report", 1, "checkIsVideoFeedsLikeActionDownloadBarRecordToday localDate = " + str);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_LIKE_ACTION_SHOW_DOWNLOAD_BAR_RECORD_DATE", (String)localObject);
    a(paramAppRuntime, true);
    return false;
  }
  
  public static int M(AppRuntime paramAppRuntime)
  {
    if (!L(paramAppRuntime))
    {
      J(paramAppRuntime, 0);
      return 0;
    }
    return a(paramAppRuntime, true, true).getInt("VIDEO_FEEDS_LIKE_ACTION_SHOW_DOWNLOAD_BAR_COUNT_TODAY", 0);
  }
  
  public static void M(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateWeishiDeleteOutArticleFeedsCnt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("weishi_delete_outdate_article_feeds_cnt", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void M(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoComponentConfig() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoComponentConfig() value=" + paramString);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("sp_video_component_con", paramString);
    a(paramAppRuntime, true);
  }
  
  public static boolean M(AppRuntime paramAppRuntime)
  {
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    localObject = i + j + k;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsInterruptedAdLocalConfigToday() failed");
      return false;
    }
    String str = paramAppRuntime.getString("VIDEO_FEEDS_SHUNT_BAR_LOCAL_CONFIG_DATE", null);
    QLog.d("Q.readinjoy.tt_report", 1, "checkIsVideoFeedsInterruptedAdLocalConfigToday localDate = " + str);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_SHUNT_BAR_LOCAL_CONFIG_DATE", (String)localObject);
    a(paramAppRuntime, true);
    return false;
  }
  
  public static int N(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBadgeSwitch() failed");
      return -1;
    }
    if (eBd != -1) {
      return eBd;
    }
    eBd = paramAppRuntime.getInt("kandian_badge_switch", 0);
    return eBd;
  }
  
  public static void N(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "VideoFeedsPlayActivity updateVideoFeedsUserGuideShowCount() failed");
    }
    do
    {
      return;
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("VIDEO_FEEDS_USER_GUIDE_SHOW_COUNT", paramInt);
      a(paramAppRuntime, true);
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "updateVideoFeedsUserGuideShowCount newCount = " + paramInt);
  }
  
  public static void N(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsDiscoverySwitch() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsDiscoverySwitch() value=" + paramString);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_DISCOVERY_SWITCH", paramString);
    a(paramAppRuntime, true);
  }
  
  public static boolean N(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianMsgStickFlag() failed");
      return false;
    }
    return paramAppRuntime.getBoolean(cQK, false);
  }
  
  public static int O(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    String str;
    do
    {
      return -1;
      str = paramAppRuntime.getAccount();
    } while (TextUtils.isEmpty(str));
    if (kg.get(str) == null)
    {
      i = a(paramAppRuntime, true, true).getInt("user_kandian_show_config", -1);
      kg.put(str, Integer.valueOf(i));
      QLog.d("ReadInJoyHelper", 2, "uin : " + str + " user kandiantab show config : " + i);
    }
    paramAppRuntime = (Integer)kg.get(str);
    if (paramAppRuntime != null) {}
    for (int i = paramAppRuntime.intValue();; i = -1) {
      return i;
    }
  }
  
  public static void O(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "increaseUgcDeliverVideoTipsShowCount: sp is null");
      return;
    }
    SharedPreferences.Editor localEditor = paramAppRuntime.edit();
    paramInt = paramAppRuntime.getInt("ugc_deliver_video_tips_show_count", 0) + paramInt;
    localEditor.putInt("ugc_deliver_video_tips_show_count", paramInt);
    a(localEditor, true);
    QLog.d("ReadInJoyHelper", 2, "increaseUgcDeliverVideoTipsShowCount: success, newCount = " + paramInt);
  }
  
  public static void O(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsAdConfigFromServer() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsAdConfigFromServer() value=" + paramString);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("video_feeds_ad_config", paramString);
    a(paramAppRuntime, true);
  }
  
  public static boolean O(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("kandianWebPreLoadData", false);
  }
  
  public static int P(AppRuntime paramAppRuntime)
  {
    int i = 0;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "VideoFeedsPlayActivity getVideoFeedsUserGuideShowCount() failed");
    }
    int j;
    do
    {
      return i;
      j = paramAppRuntime.getInt("VIDEO_FEEDS_USER_GUIDE_SHOW_COUNT", 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity getVideoFeedsUserGuideShowCount = " + j);
    return j;
  }
  
  public static void P(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("ReadInJoyHelper", 2, "is_show_weishi_entrance: sp is null");
    }
    do
    {
      return;
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("is_show_weishi_entrance", paramInt);
      a(paramAppRuntime, true);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyHelper", 2, "is_show_weishi_entrance = " + paramInt);
  }
  
  public static void P(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject = a(paramAppRuntime, true, true);
    if (localObject == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoFeedsAdConfigFromServer() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsAdConfigFromServer() value=" + paramString);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("readinjoy_my_tab_setting" + paramAppRuntime.getAccount(), paramString);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static boolean P(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return false;
      paramAppRuntime = a(paramAppRuntime, true, true).getString("kandian_my_tab_page", "0");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, new Object[] { "showKandianNewMyTabPage, value = ", paramAppRuntime });
      }
    } while (!"1".equals(paramAppRuntime));
    return true;
  }
  
  public static int Q(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateReadInJoyWeiShiJumpTarget: sp == null");
      return 0;
    }
    return paramAppRuntime.getInt("SP_KEY_WEISHI_JUMP_TARGET", 0);
  }
  
  public static void Q(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigAdExposureThreshold() failed");
      return;
    }
    if (paramInt <= 0)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigAdExposureThreshold() threshold <= 0");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("key_kandian_ad_exposure_threshold", paramInt);
    a(paramAppRuntime, true);
    eBf = paramInt;
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigAdExposureThreshold() threshold = " + paramInt);
  }
  
  public static void Q(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsInterruptedAsConfigFromServer() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsInterruptedAsConfigFromServer() value=" + paramString);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_INTERRUPTED_AD_CONFIG_NEW", paramString);
    a(paramAppRuntime, true);
  }
  
  public static boolean Q(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("nw_support", true);
  }
  
  public static int Qf()
  {
    SharedPreferences localSharedPreferences = a(kxm.getAppRuntime(), true, true);
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("IdleExitAioRptCntForReport", 0);
  }
  
  public static int Qg()
  {
    if (aqux.Mv() == 1) {
      return 1;
    }
    return 0;
  }
  
  public static int Qh()
  {
    int i = ((Integer)f("twoitem_title_label_number_of_lines", Integer.valueOf(2))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "getTitleNumberLines,limitNumber:" + i);
    }
    return i;
  }
  
  public static int Qi()
  {
    int i = ((Integer)f("readinjoy_video_recommend_entrance_direct", Integer.valueOf(2))).intValue();
    QLog.d("ReadInJoyHelper", 1, "getVideoRecommendEntranceDirect result=" + i);
    return i;
  }
  
  public static int Qj()
  {
    int i = ((Integer)f("readinjoy_preplay_time_limit", Integer.valueOf(6))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "getPreplayTimeLimit result=" + i);
    }
    return i;
  }
  
  public static int Qk()
  {
    int i = ((Integer)f("readinjoy_dynamic_buffer_switch", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "getDynamicBufferSwitch result=" + i);
    }
    return i;
  }
  
  public static int Ql()
  {
    int i = ((Integer)f("viola_sus_video_auto_play", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLog", 1, "getViolaSusAutoPlayConfig result=" + i);
    }
    return i;
  }
  
  public static int R(AppRuntime paramAppRuntime)
  {
    if (eBf > 0) {
      return eBf;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigAdExposureThreshold() failed");
      return kwt.aMn;
    }
    eBf = paramAppRuntime.getInt("key_kandian_ad_exposure_threshold", kwt.aMn);
    QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigAdExposureThreshold() threshold = " + eBf);
    return eBf;
  }
  
  public static void R(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsInterruptedAdConfigLocal() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsInterruptedAdConfigLocal() value=" + paramString);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG_NEW", paramString);
    a(paramAppRuntime, true);
  }
  
  public static boolean R(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("nw_preload", false);
  }
  
  public static void S(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsShuntBarConfigFromServer() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsShuntBarConfigFromServer() value=" + paramString);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_SHUNT_BAR_CONFIG", paramString);
    a(paramAppRuntime, true);
  }
  
  public static boolean S(AppRuntime paramAppRuntime)
  {
    return dqu;
  }
  
  public static void T(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("1"))
      {
        v(paramAppRuntime, true);
        u(paramAppRuntime, false);
      }
    }
    else {
      return;
    }
    if (paramString.equals("2"))
    {
      v(paramAppRuntime, true);
      u(paramAppRuntime, true);
      return;
    }
    u(paramAppRuntime, false);
    v(paramAppRuntime, false);
  }
  
  public static boolean T(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("exposure_strengthen", true);
  }
  
  public static void U(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("native_engine_timeout_config", paramString);
    a(paramAppRuntime, true);
  }
  
  public static boolean U(String paramString, boolean paramBoolean)
  {
    if (anwa.aze()) {
      return false;
    }
    return ((Boolean)a(paramString, Boolean.valueOf(paramBoolean), true)).booleanValue();
  }
  
  public static boolean U(AppRuntime paramAppRuntime)
  {
    boolean bool = true;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "is_show_weishi_entrance: sp is null");
      return false;
    }
    int i = paramAppRuntime.getInt("is_show_weishi_entrance", 0);
    QLog.d("ReadInJoyHelper", 2, "get_is_show_weishi_entrance : " + i);
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void V(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyTabAutoRefreshTimeDuration() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      i = i * 60 * 1000;
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyTabAutoRefreshTimeDuration() duration < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyTabAutoRefreshTimeDuration() parseInt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("ReadInJoy_Tab_Auto_Refresh_Time_Duration", i);
    a(paramAppRuntime, true);
    aBd = i;
  }
  
  public static boolean V(AppRuntime paramAppRuntime)
  {
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    localObject = i + j + k;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsGameAdComBarLocalConfigToday() failed");
      }
      return false;
    }
    String str = paramAppRuntime.getString("VIDEO_FEEDS_GAME_AD_COM_BAR_LOCAL_CONFIG_DATE", null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "checkIsVideoFeedsGameAdComBarLocalConfigToday localDate = " + str);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_GAME_AD_COM_BAR_LOCAL_CONFIG_DATE", (String)localObject);
    a(paramAppRuntime, true);
    return false;
  }
  
  public static boolean Vs()
  {
    return (aMG()) && (!aMH());
  }
  
  public static void W(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyMessageAutoRefreshTimeDuration() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      i = i * 60 * 1000;
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyMessageAutoRefreshTimeDuration() duration < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyMessageAutoRefreshTimeDuration() parseInt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("ReadInJoy_Message_Auto_Refresh_Time_Duration", i);
    a(paramAppRuntime, true);
    aBe = i;
  }
  
  public static void X(AppRuntime paramAppRuntime, String paramString)
  {
    try
    {
      i = Integer.valueOf(paramString).intValue();
      paramAppRuntime = a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("ReadInJoyHelper", 2, "updateReadInJoyWeiShiJumpTarget: sp == null");
        return;
      }
    }
    catch (Exception paramString)
    {
      int i;
      for (;;)
      {
        i = 0;
        QLog.e("ReadInJoyHelper", 2, "updateReadInJoyWeiShiJumpTarget: ", paramString);
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("SP_KEY_WEISHI_JUMP_TARGET", i);
      a(paramAppRuntime, true);
    }
  }
  
  public static void Xg(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = getAppRuntime();
    String str = "null";
    if (localAppRuntime != null)
    {
      str = localAppRuntime.getAccount();
      a(localAppRuntime, "local_kd_tab_has_set", Boolean.valueOf(paramBoolean));
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      f("local_kd_tab_has_set_prefix", Integer.valueOf(i));
      QLog.d("ReadInJoyHelper", 1, "updateKDHasSetSwitch   uin : " + str + "  hasSet:" + paramBoolean);
      return;
    }
  }
  
  public static void Xh(boolean paramBoolean)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("kd_icon_merge_biu_msg", paramBoolean);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void Xi(boolean paramBoolean)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("kd_icon_merge_interactive_msg", paramBoolean);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void Xj(boolean paramBoolean)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("proteus_enable", paramBoolean);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void Xk(boolean paramBoolean)
  {
    if ((paramBoolean) && (!ReadinjoyTabFrame.asp)) {
      eBe += 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, "inFeeds: " + paramBoolean + " inFeeds " + eBe);
      }
      return;
      if (eBe > 0) {
        eBe -= 1;
      }
    }
  }
  
  public static void Xl(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updataCachedViolaPageOpenData value=" + paramBoolean);
    }
    H("readinjoy_viola_page_open_count", Boolean.valueOf(paramBoolean));
  }
  
  public static float a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendDurationPercent() failed");
      return -1.0F;
    }
    float f = paramAppRuntime.getFloat("video_dynamic_recommend_duration_rate", -1.0F);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoDynamicRecommendDurationPercent() result=" + f);
    return f;
  }
  
  public static long a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder("last_req_article_time");
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong(k(paramActivity), 0L);
  }
  
  public static long a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianLocalRedShowDate() failed");
      return -1L;
    }
    if (aAY != -1L) {
      return aAY;
    }
    aAY = paramAppRuntime.getLong("kandian_tabdot_show_date", 0L);
    return aAY;
  }
  
  public static aevs a(QQAppInterface paramQQAppInterface)
  {
    List localList = zjq.a().dp();
    Object localObject;
    if (localList != null)
    {
      localObject = localList;
      if (!localList.isEmpty()) {}
    }
    else
    {
      paramQQAppInterface.a();
      zjq.a().a(paramQQAppInterface.getApplication().getApplicationContext(), paramQQAppInterface);
      localObject = zjq.a().dp();
    }
    if (localObject != null)
    {
      paramQQAppInterface = ((List)localObject).iterator();
      while (paramQQAppInterface.hasNext())
      {
        localObject = (aevs)paramQQAppInterface.next();
        if ((localObject != null) && (((aevs)localObject).a != null) && (((aevs)localObject).a.uiResId == 1130L)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    if (paramBoolean1) {
      paramAppRuntime = paramAppRuntime.getAccount();
    }
    for (paramAppRuntime = "readinjoy_sp" + "_" + paramAppRuntime;; paramAppRuntime = "readinjoy_sp")
    {
      int j = 0;
      int i = j;
      if (paramBoolean2)
      {
        i = j;
        if (Build.VERSION.SDK_INT >= 11) {
          i = 4;
        }
      }
      return BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, i);
    }
  }
  
  public static awit.a a(Node paramNode)
  {
    awit.a locala = new awit.a();
    if (TextUtils.equals("setting", paramNode.getNodeName()))
    {
      paramNode = paramNode.getFirstChild();
      if (paramNode != null)
      {
        String str2;
        if (paramNode.getNodeType() == 1)
        {
          String str1 = paramNode.getNodeName();
          str2 = paramNode.getFirstChild().getNodeValue();
          if (!TextUtils.equals(str1, "id")) {
            break label99;
          }
        }
        for (;;)
        {
          try
          {
            locala.id = Integer.parseInt(str2);
            paramNode = paramNode.getNextSibling();
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            localNumberFormatException1.printStackTrace();
            continue;
          }
          label99:
          if (TextUtils.equals(localNumberFormatException1, "title")) {
            locala.title = str2;
          } else if (TextUtils.equals(localNumberFormatException1, "hidden")) {
            try
            {
              locala.eBi = Integer.parseInt(str2);
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              localNumberFormatException2.printStackTrace();
            }
          }
        }
      }
    }
    return locala;
  }
  
  public static awit.b a(Node paramNode)
  {
    awit.b localb = new awit.b();
    if (TextUtils.equals("setting", paramNode.getNodeName()))
    {
      paramNode = paramNode.getFirstChild();
      if (paramNode != null)
      {
        String str1;
        String str2;
        if (paramNode.getNodeType() == 1)
        {
          str1 = paramNode.getNodeName();
          str2 = paramNode.getFirstChild().getNodeValue();
          if (!TextUtils.equals(str1, "title")) {
            break label88;
          }
          localb.title = str2;
        }
        for (;;)
        {
          paramNode = paramNode.getNextSibling();
          break;
          label88:
          if (TextUtils.equals(str1, "jumpurl"))
          {
            localb.jumpUrl = str2;
          }
          else if (TextUtils.equals(str1, "id"))
          {
            try
            {
              localb.id = Integer.parseInt(str2);
            }
            catch (NumberFormatException localNumberFormatException) {}
            if (QLog.isColorLevel()) {
              QLog.e("ReadInJoyHelper", 2, "parseOperatingSettingNodes:" + localNumberFormatException.toString());
            }
          }
        }
      }
    }
    return localb;
  }
  
  public static awit.c a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("Q.readinjoy.video", 1, "getVideoComponentConfig() failed");
    }
    awit.c localc;
    do
    {
      return null;
      localc = new awit.c();
      paramAppRuntime = paramAppRuntime.getString("sp_video_component_con", "");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, new Object[] { "getVideoComponentConfig()", paramAppRuntime });
      }
    } while (TextUtils.isEmpty(paramAppRuntime));
    for (;;)
    {
      Node localNode;
      Object localObject;
      String str1;
      String str2;
      try
      {
        paramAppRuntime = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramAppRuntime.getBytes("utf-8"))).getElementsByTagName("configs").item(0).getFirstChild();
        if (paramAppRuntime == null) {
          return localc;
        }
        if ((paramAppRuntime.getFirstChild() == null) || (!TextUtils.equals(paramAppRuntime.getNodeName(), "readinjoy_small_video_pack_ui_style"))) {
          break label528;
        }
        localNode = paramAppRuntime.getFirstChild();
        if (localNode == null) {
          break label528;
        }
        if (localNode.getNodeType() != 1) {
          break label446;
        }
        localObject = localNode.getNodeName();
        str1 = localNode.getFirstChild().getNodeValue();
        QLog.d("Q.readinjoy.tt_report", 1, "getVideoComponentConfig() result=" + str1);
        if (!TextUtils.equals((CharSequence)localObject, "multiple_video")) {
          break label342;
        }
        localObject = localNode.getFirstChild();
        if (localObject == null) {
          break label446;
        }
        if (((Node)localObject).getNodeType() == 1)
        {
          str1 = ((Node)localObject).getNodeName();
          str2 = ((Node)localObject).getFirstChild().getNodeValue();
          if (TextUtils.equals("video_width", str1)) {
            localc.eBk = Integer.parseInt(str2);
          }
        }
        else
        {
          localObject = ((Node)localObject).getNextSibling();
          continue;
        }
        if (!TextUtils.equals("aspect_ratio", str1)) {
          continue;
        }
        localc.DA = Float.parseFloat(str2);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramAppRuntime) {}
      QLog.d("ReadInJoyHelper", 2, "getVideoComponentConfig exception occurs", paramAppRuntime);
      return null;
      label342:
      if (TextUtils.equals((CharSequence)localObject, "double_video")) {
        for (localObject = localNode.getFirstChild(); localObject != null; localObject = ((Node)localObject).getNextSibling()) {
          if (((Node)localObject).getNodeType() == 1)
          {
            str1 = ((Node)localObject).getNodeName();
            str2 = ((Node)localObject).getFirstChild().getNodeValue();
            if (TextUtils.equals("aspect_ratio", str1)) {
              localc.Dz = Float.parseFloat(str2);
            }
          }
        }
      }
      if (TextUtils.equals((CharSequence)localObject, "is_play_button_show")) {
        localc.dqw = str1.equals("1");
      }
      for (;;)
      {
        label446:
        localNode = localNode.getNextSibling();
        break;
        if (TextUtils.equals((CharSequence)localObject, "title_label_number_of_lines")) {
          localc.eBj = Integer.parseInt(str1);
        } else if (TextUtils.equals((CharSequence)localObject, "title_hidden")) {
          localc.dqx = str1.equals("0");
        } else if (TextUtils.equals((CharSequence)localObject, "play_and_comment_hidden")) {
          localc.dqy = str1.equals("0");
        }
      }
      label528:
      paramAppRuntime = paramAppRuntime.getNextSibling();
    }
    return localc;
  }
  
  public static LikeAnimationInfo a()
  {
    Object localObject = a(kxm.getAppRuntime(), false, true);
    if (localObject == null) {
      localObject = null;
    }
    LikeAnimationInfo localLikeAnimationInfo;
    do
    {
      return localObject;
      localLikeAnimationInfo = new LikeAnimationInfo();
      int j = ((SharedPreferences)localObject).getInt("key_like_icon_length", 0);
      if (j > 0)
      {
        String[] arrayOfString = new String[j];
        int i = 0;
        while (i < j)
        {
          arrayOfString[i] = ((SharedPreferences)localObject).getString("key_like_icon" + i, "");
          i += 1;
        }
        localLikeAnimationInfo.bA = arrayOfString;
      }
      localLikeAnimationInfo.aTU = ((SharedPreferences)localObject).getInt("key_like_icon_next_req_interval", 0);
      localObject = localLikeAnimationInfo;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyHelper", 2, "loadLikeAnimationInfo: " + localLikeAnimationInfo.toString());
    return localLikeAnimationInfo;
  }
  
  public static com.tencent.util.Pair<Long, Integer> a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return new com.tencent.util.Pair(Long.valueOf(86400L), Integer.valueOf(5));
    }
    return new com.tencent.util.Pair(Long.valueOf(paramAppRuntime.getLong("kandian_delete_outdate_article_interval", 86400L)), Integer.valueOf(paramAppRuntime.getInt("kandian_delete_outdate_article_feeds_cnt", 5)));
  }
  
  public static Boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianSelfForbidden() failed");
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(paramAppRuntime.getBoolean("kandian_user_forbidden", false));
  }
  
  public static <T> T a(String paramString, T paramT, boolean paramBoolean)
  {
    QLog.d("ReadInJoyHelper", 2, "getReadInJoySpValue: " + paramString);
    SharedPreferences localSharedPreferences = a(kxm.getAppRuntime(), paramBoolean, true);
    if (localSharedPreferences == null) {
      QLog.d("ReadInJoyHelper", 2, "getReadInJoySpValue: sp is null");
    }
    do
    {
      return paramT;
      if ((paramT instanceof String)) {
        return localSharedPreferences.getString(paramString, (String)paramT);
      }
      if ((paramT instanceof Integer)) {
        return Integer.valueOf(localSharedPreferences.getInt(paramString, ((Integer)paramT).intValue()));
      }
      if ((paramT instanceof Long)) {
        return Long.valueOf(localSharedPreferences.getLong(paramString, ((Long)paramT).longValue()));
      }
      if ((paramT instanceof Boolean)) {
        return Boolean.valueOf(localSharedPreferences.getBoolean(paramString, ((Boolean)paramT).booleanValue()));
      }
    } while (!(paramT instanceof Float));
    return Float.valueOf(localSharedPreferences.getFloat(paramString, ((Float)paramT).floatValue()));
  }
  
  public static String a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    if ((paramLong1 > 0L) && (paramLong1 < 10000L)) {
      return String.valueOf(paramLong1);
    }
    if ((paramLong1 >= 10000L) && (paramLong1 < paramLong2))
    {
      double d = new BigDecimal(100L * paramLong1 / 100.0D / 10000.0D).setScale(1, 4).doubleValue();
      if (Math.round(d) - d == 0.0D) {
        return String.valueOf(d) + acfp.m(2131713626);
      }
      return String.valueOf(d) + acfp.m(2131713614);
    }
    if (paramLong1 >= paramLong2) {
      return paramString1;
    }
    return paramString2;
  }
  
  private static String a(double[] paramArrayOfDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0000");
    if (paramArrayOfDouble != null)
    {
      int i = 0;
      while (i < paramArrayOfDouble.length)
      {
        localStringBuilder.append(localDecimalFormat.format(paramArrayOfDouble[i]));
        if (i != paramArrayOfDouble.length - 1) {
          localStringBuilder.append("_");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private static HashMap<String, Boolean> a(AppRuntime paramAppRuntime)
  {
    HashMap localHashMap = new HashMap();
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return localHashMap;
    }
    paramAppRuntime = paramAppRuntime.getString("READINJOY_VIDEO_CHANNEL_LIKE_UNLIKE_SP2", "");
    if (TextUtils.isEmpty(paramAppRuntime)) {
      return localHashMap;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "getLikeUnLikeSP likeUnLikeSp:" + paramAppRuntime);
    }
    paramAppRuntime = paramAppRuntime.split(";");
    if ((paramAppRuntime != null) && (paramAppRuntime.length > 0))
    {
      int i = 0;
      while (i < paramAppRuntime.length)
      {
        if (!TextUtils.isEmpty(paramAppRuntime[i])) {
          localHashMap.put(paramAppRuntime[i], Boolean.valueOf(true));
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static kgj a(AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(cQJ))
    {
      paramAppRuntime = a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getUserMedalt() failed");
        return null;
      }
      cQJ = paramAppRuntime.getString("kandian_user_medal", null);
    }
    return kgj.a(cQJ);
  }
  
  public static void a(int paramInt, long paramLong, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder("last_req_article_time");
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putLong(localStringBuilder.toString(), paramLong);
    a(paramQQAppInterface, true);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((dc(paramActivity)) && (paramActivity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")))
    {
      paramIntent.setClassName("com.tencent.qqreadinjoy", "com.tencent.qqreadinjoy.ReadInJoyStartActivity");
      paramActivity.startActivityForResult(paramIntent, -1);
    }
    a(null, paramActivity, paramIntent, paramInt, paramOnDismissListener);
  }
  
  public static void a(SharedPreferences.Editor paramEditor, boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 9))
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = kxm.getLongAccountUin();
    localReportInfo.mSource = paramInt1;
    localReportInfo.mSourceArticleId = paramLong;
    localReportInfo.mOperation = paramInt2;
    localReportInfo.mOpSource = paramInt3;
    localArrayList.add(localReportInfo);
    new ljc(paramQQAppInterface, null, null, lun.a(), null).cA(localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, Activity paramActivity)
  {
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.edit().putLong(k(paramActivity), paramLong).commit();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramQQAppInterface = new Intent("notify_main_guide_clear");
    BaseApplication.getContext().sendBroadcast(paramQQAppInterface);
    kxm.pV(7);
    kgw.a(paramActivity, null, -1L, 7);
  }
  
  public static void a(AppRuntime paramAppRuntime, float paramFloat)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommendDurationPercent() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoDynamicRecommendDurationPercent() num=" + paramFloat);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putFloat("video_dynamic_recommend_duration_rate", paramFloat);
    a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, List<liw.a> paramList)
  {
    SharedPreferences localSharedPreferences = a(paramAppRuntime, true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianFollowAndFansCount() failed");
      return;
    }
    Object localObject = null;
    paramAppRuntime = (AppRuntime)localObject;
    if (paramList != null)
    {
      paramAppRuntime = (AppRuntime)localObject;
      if (paramList.size() > 0)
      {
        paramAppRuntime = new JSONArray();
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramAppRuntime.put(((liw.a)((Iterator)localObject).next()).toJson());
        }
        localObject = paramAppRuntime.toString();
        paramAppRuntime = (AppRuntime)localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyHelper", 2, "updateKandianFollowAndFansCount followNum:" + paramInt1 + ", userNickName:" + paramInt2 + ", fansInfoList = " + paramList.size());
          paramAppRuntime = (AppRuntime)localObject;
        }
      }
    }
    localObject = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putInt("kandian_user_follow_count", paramInt1);
    ((SharedPreferences.Editor)localObject).putInt("kandian_user_fans_count", paramInt2);
    if (paramAppRuntime != null) {
      ((SharedPreferences.Editor)localObject).putString("kandian_user_fans_info_list", paramAppRuntime);
    }
    a((SharedPreferences.Editor)localObject, true);
    eAZ = paramInt1;
    eBa = paramInt2;
    LT = paramList;
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianLocalRedShowDate() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putLong("kandian_tabdot_show_date", paramLong);
    a(paramAppRuntime, true);
    aAY = paramLong;
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return;
      paramAppRuntime = a(paramAppRuntime, true, true);
    } while (paramAppRuntime == null);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putLong("msg_info_pulse_report_x", paramLong1);
    paramAppRuntime.putLong("msg_info_pulse_report_y", paramLong2);
    paramAppRuntime.putLong("msg_info_pulse_report_z", paramLong3);
    a(paramAppRuntime, true);
    QLog.d("ReadInJoyHelper", 2, "update msg info pulse param x : " + paramLong1 + ", y : " + paramLong2 + ", z : " + paramLong3);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, long paramLong3)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateUserInfo() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    if (!TextUtils.isEmpty(paramString1))
    {
      paramAppRuntime.putString("kandian_user_head_url", paramString1);
      cQG = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramAppRuntime.putString("kandian_user_nick_name", paramString2);
      cQH = paramString2;
    }
    if (paramInt != -1)
    {
      paramAppRuntime.putInt("kandian_user_is_vip", paramInt);
      eBb = paramInt;
    }
    if (paramLong1 >= 0L)
    {
      paramAppRuntime.putLong("kandian_user_total_like", paramLong1);
      aAZ = paramLong1;
    }
    if (paramLong2 >= 0L)
    {
      paramAppRuntime.putLong("kandain_user_feeds_dynamic", paramLong2);
      aBa = paramLong2;
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      paramAppRuntime.putString("kandian_user_desc", paramString3);
      cQI = paramString3;
      paramAppRuntime.putLong("kandain_user_signin_status", paramLong3);
      a(paramAppRuntime, true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyHelper", 2, "updateUserInfo userHeadUrl:" + paramString1 + ", userNickName:" + paramString2 + ", userIsVip = " + paramInt);
      return;
      paramString3 = "";
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, kgj paramkgj)
  {
    if (paramAppRuntime == null) {
      QLog.d("ReadInJoyHelper", 1, "updateUserMedal error! app is null");
    }
    do
    {
      return;
      paramkgj.Zd = "1";
      paramkgj.Ze = "1";
      paramkgj.Zg = kxm.getAccount();
      paramkgj = paramkgj.jdMethod_if();
    } while (TextUtils.isEmpty(paramkgj));
    cQJ = paramkgj;
    J(paramAppRuntime, paramkgj);
    QLog.d("ReadInJoyHelper", 1, "updateUserMedal");
  }
  
  private static void a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (paramBoolean1) {}
    for (int i = 1;; i = 0)
    {
      if (paramBoolean2) {
        j = 1;
      }
      ThreadManager.executeOnSubThread(new ReadInJoyHelper.5(paramAppRuntime, i, j));
      QLog.d("ReadInJoyHelper", 1, paramAppRuntime.getAccount() + " pre_switch:" + i + "  correct_switch:" + j);
      return;
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo, long paramLong)
  {
    long l = ((Long)f("kandian_comment_limit_number", Long.valueOf(1L))).longValue();
    boolean bool2 = false;
    boolean bool1;
    if (paramBaseArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyHelper", 1, "shouldShowComment,limitNumber:" + l + " ,number:" + paramLong);
      return bool1;
      bool1 = bool2;
      if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
      {
        bool1 = bool2;
        if (paramLong >= 0L)
        {
          bool1 = bool2;
          if (paramLong >= l) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString, Object paramObject)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if ((paramAppRuntime == null) || (paramObject == null)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, new Object[] { "updateKDSPWithKeyAndValue, key = ", paramString, ", value = ", paramObject });
    }
    paramAppRuntime = paramAppRuntime.edit();
    if ((paramObject instanceof String)) {
      paramAppRuntime.putString(paramString, (String)paramObject);
    }
    for (;;)
    {
      a(paramAppRuntime, true);
      return true;
      if (!(paramObject instanceof Boolean)) {
        break;
      }
      paramAppRuntime.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
    QLog.d("ReadInJoyHelper", 2, "updateKDSPWithKeyAndValue, now not support this kind of instance.");
    return false;
  }
  
  public static boolean aMA()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean aMB()
  {
    return dqt;
  }
  
  public static boolean aMC()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = a(kxm.a(), true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp IndividualPushSwitch");
      return false;
    }
    if (localSharedPreferences.getInt("video_channel_feeds_type", 1) == 2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean aMD()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = a(kxm.a(), true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp IndividualPushSwitch");
      return false;
    }
    if (localSharedPreferences.getInt("multi_video_feeds_type", 1) == 2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean aME()
  {
    int j = 0;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null)
    {
      QLog.d("ReadInJoyHelper", 1, new Object[] { "app is null, isShowKandianTabNew, isShowKandian = ", Integer.valueOf(0) });
      return false;
    }
    SharedPreferences localSharedPreferences;
    if (f("local_kd_tab_switch").intValue() == -1)
    {
      localSharedPreferences = a((AppRuntime)localObject, true, true);
      if (localSharedPreferences == null) {
        break label207;
      }
    }
    label207:
    for (boolean bool = localSharedPreferences.getBoolean("local_kd_tab_switch", true);; bool = false)
    {
      int i;
      if (bool)
      {
        i = 1;
        acy(i);
        QLog.d("ReadInJoyHelper", 1, "isShowKandianTabNew cache is null, read from sp, " + ((AppRuntime)localObject).getAccount());
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          localObject = ((AppRuntime)localObject).getAccount() + " isShowKandianTab, isShowKandian = ";
          i = j;
          if (bool) {
            i = 1;
          }
          QLog.d("ReadInJoyHelper", 1, new Object[] { localObject, Integer.valueOf(i) });
        }
        return bool;
        i = 0;
        break;
        if (f("local_kd_tab_switch").intValue() == 1) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public static boolean aMF()
  {
    int j = 0;
    boolean bool;
    int i;
    if (aMG())
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime == null)
      {
        QLog.d("ReadInJoyHelper", 1, new Object[] { "app is null, isShowMainVideoTabNew, isShowMainVideo = ", Integer.valueOf(0) });
        return false;
      }
      if (f("local_kd_tab_type").intValue() == -1)
      {
        Object localObject = a(localAppRuntime, true, true);
        if (localObject == null) {
          break label220;
        }
        localObject = ((SharedPreferences)localObject).getString("local_kd_tab_type", "1");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals("0"))) {
          break label220;
        }
        bool = true;
        if (bool)
        {
          i = 0;
          label113:
          f("local_kd_tab_type", Integer.valueOf(i));
          QLog.d("ReadInJoyHelper", 2, "isShowMainVideoTabNew cache is null, read from sp, " + localAppRuntime.getAccount());
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        i = j;
        if (bool) {
          i = 1;
        }
        QLog.d("ReadInJoyHelper", 2, new Object[] { "isShowMainVideoTabNew, isShowMainVideo = ", Integer.valueOf(i) });
      }
      return bool;
      i = 1;
      break label113;
      if (f("local_kd_tab_type").intValue() == 0)
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        label220:
        bool = false;
        break;
        bool = false;
      }
    }
  }
  
  public static boolean aMG()
  {
    int i = O(getAppRuntime());
    if (i != -1)
    {
      Xg(true);
      if (i != 1) {
        break label73;
      }
    }
    label73:
    for (boolean bool = true;; bool = false)
    {
      bP(bool);
      kg.clear();
      Object localObject = a(getAppRuntime(), true, true);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("user_kandian_show_config");
        a((SharedPreferences.Editor)localObject, true);
      }
      return aME();
    }
  }
  
  public static boolean aMH()
  {
    return aMF();
  }
  
  public static boolean aMI()
  {
    Boolean localBoolean = (Boolean)y("sp_key_create_topic_switch");
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  public static boolean aMJ()
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return false;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getBoolean("kd_icon_merge_biu_msg", false);
  }
  
  public static boolean aMK()
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return false;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getBoolean("kd_icon_merge_interactive_msg", false);
  }
  
  public static boolean aML()
  {
    long l = ((Long)f("READINJOY_RED_PACKET_SHARE_GUIDE", Long.valueOf(0L))).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "needShowRedPacketShareGuide: lastTime=" + l);
    }
    return System.currentTimeMillis() - l > TimeUnit.DAYS.toMillis(1L);
  }
  
  public static boolean aMM()
  {
    return (eBe > 0) || (ReadinjoyTabFrame.Dx());
  }
  
  public static boolean aMN()
  {
    int i = ((Integer)f("is_play_comment_button_show", Integer.valueOf(1))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "isPlayCommentButtonShow,shouldShow:" + i);
    }
    return i == 1;
  }
  
  public static boolean aMO()
  {
    int i = ((Integer)f("readinjoy_video_is_ff_probelist_switch", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "isFFProbelistSwitch,isFFProbelistSwitch:" + i);
    }
    return i == 1;
  }
  
  public static boolean aMP()
  {
    int i = ((Integer)f("readinjoy_video_is_download_async_io", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "isDownloadAsyncIo,isDownloadAsyncIo:" + i);
    }
    return i == 1;
  }
  
  public static boolean aMQ()
  {
    return Qi() == 6;
  }
  
  public static boolean aMR()
  {
    int i = ((Integer)f("readinjoy_homepage_open_viola", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "getHomepageConfig result=" + i);
    }
    return i == 1;
  }
  
  public static boolean aMS()
  {
    int i = ((Integer)f("readinjoy_family_config", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "getFamilyConfig result=" + i);
    }
    return i == 1;
  }
  
  public static boolean aMT()
  {
    int i = ((Integer)f("readinjoy_kingcard_switch", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "getKingCardSwitch result=" + i);
    }
    return i != 0;
  }
  
  public static boolean aMU()
  {
    return true;
  }
  
  public static boolean aMV()
  {
    Object localObject1 = Calendar.getInstance();
    int i = ((Calendar)localObject1).get(1);
    int j = ((Calendar)localObject1).get(2);
    int k = ((Calendar)localObject1).get(5);
    localObject1 = i + j + k;
    Object localObject2 = a(kxm.getAppRuntime(), true, true);
    if (localObject2 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 1, "checkIsFirstNoDifferenceJumpAppToday() failed");
      }
    }
    do
    {
      return false;
      localObject2 = ((SharedPreferences)localObject2).getString("readinjoy_first_no_difference_jump_app", null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.tt_report", 1, "checkIsVideoFeedsGameAdComBarLocalConfigToday localDate = " + (String)localObject2);
      }
    } while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(localObject2)));
    return true;
  }
  
  public static boolean aMW()
  {
    return Aladdin.getConfig(227).getIntegerFromString("report_enable", 0) == 1;
  }
  
  public static boolean aMX()
  {
    return (((Boolean)f("sp_key_channel_list_dynamic_order_switch", Boolean.valueOf(false))).booleanValue()) && (((Boolean)f("sp_key_readinjoy_click_channel_view", Boolean.valueOf(false))).booleanValue());
  }
  
  public static boolean aMY()
  {
    return (((Boolean)f("sp_key_channel_list_dynamic_order_switch", Boolean.valueOf(false))).booleanValue()) && (((Boolean)f("sp_key_readinjoy_slide_channel_view", Boolean.valueOf(false))).booleanValue());
  }
  
  public static boolean aMZ()
  {
    return (((Boolean)f("sp_key_channel_list_dynamic_order_switch", Boolean.valueOf(false))).booleanValue()) && (((Boolean)f("sp_key_readinjoy_click_diversion_card", Boolean.valueOf(false))).booleanValue());
  }
  
  public static boolean aNa()
  {
    boolean bool = ((Boolean)f(Hg(), Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "isUGCAccountCreateComplete() result=" + bool);
    }
    return bool;
  }
  
  public static void abC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateSingleVideoConfig() value=" + paramString);
    }
    H("VIDEO_FEEDS_SINGLE_VIDEO_CONFIG", paramString);
  }
  
  public static void abD(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    while (!QLog.isColorLevel()) {
      try
      {
        H("weishi_recommend_delete_outdate_article_interval", Long.valueOf(Long.parseLong(paramString)));
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ReadInJoyHelper", 2, "parse weishi outdate time error, value from server: " + paramString);
        return;
      }
    }
    QLog.d("ReadInJoyHelper", 2, "updateWeishiRecommendDeleteOutArticleInterval: time is null");
  }
  
  public static void abE(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    while (!QLog.isColorLevel()) {
      try
      {
        H("weishi_recommend_delete_outdate_article_feeds_counts", Integer.valueOf(Integer.parseInt(paramString)));
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ReadInJoyHelper", 2, "parse weishi outdate article feeds counts error, value from server: " + paramString);
        return;
      }
    }
    QLog.d("ReadInJoyHelper", 2, "updateWeishiRecommendDeleteOutArticleFeedsCounts: counts is null");
  }
  
  public static void abF(String paramString)
  {
    Object localObject = kxm.getAppRuntime();
    if ((localObject == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putStringSet("kd_icon_merge_subscription_white_list", new HashSet(Arrays.asList(paramString.split("\\|"))));
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void abG(String paramString)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString)) {}
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          if (Integer.parseInt(paramString) == 1)
          {
            H("key_weishi_with_channel_and_discovery", Boolean.valueOf(bool));
            return;
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ReadInJoyHelper", 2, "parse weishi config error, value from server: " + paramString);
          return;
        }
        bool = false;
      }
    }
    QLog.d("ReadInJoyHelper", 2, "value in null");
  }
  
  public static void abH(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateDynamicBufferConfig value=" + paramString);
    }
    H("readinjoy_dynamic_buffer_config", paramString);
  }
  
  public static void abI(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateViolaPageOpenData value=" + paramString);
    }
    H("readinjoy_viola_page_open_data", paramString);
  }
  
  public static void abJ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKingCardGuideUrl value=" + paramString);
    }
    H("readinjoy_kingcard_gudieurl", paramString);
  }
  
  public static void abK(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKingCardTipText value=" + paramString);
    }
    H("readinjoy_kingcard_tiptext", paramString);
  }
  
  public static void abL(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKingCardJumpText value=" + paramString);
    }
    H("readinjoy_kingcard_jumptext", paramString);
  }
  
  public static void abM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    H("readinjoy_daily_refresh_cmd", paramString);
    QLog.d("ReadInJoyHelper", 1, "updateDailyRefreshCmd use0xcba=" + paramString);
  }
  
  public static void acA(int paramInt)
  {
    QLog.d("ReadInJoyHelper", 1, "updateCommentLimitNumber,number:" + paramInt);
    if (paramInt < 0) {
      return;
    }
    H("kandian_comment_limit_number", Long.valueOf(paramInt));
  }
  
  public static void acB(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "updateTitleNumberLines, lineNumber:" + paramInt);
    }
    if (paramInt < 0) {
      return;
    }
    H("twoitem_title_label_number_of_lines", Integer.valueOf(paramInt));
  }
  
  public static void acC(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "updateIsPlayCommentButtonShow, shouldShow:" + paramInt);
    }
    H("is_play_comment_button_show", Integer.valueOf(paramInt));
  }
  
  public static void acD(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateVideoRecommendEntranceDirect value=" + paramInt);
    }
    H("readinjoy_video_recommend_entrance_direct", Integer.valueOf(paramInt));
    lcc.a().aJI();
  }
  
  public static void acE(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updatePreplayTimeLimit value=" + paramInt);
    }
    H("readinjoy_preplay_time_limit", Integer.valueOf(paramInt));
  }
  
  public static void acF(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateDynamicBufferSwitch value=" + paramInt);
    }
    H("readinjoy_dynamic_buffer_switch", Integer.valueOf(paramInt));
  }
  
  public static void acG(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateHomePageConfig value=" + paramInt);
    }
    H("readinjoy_homepage_open_viola", Integer.valueOf(paramInt));
  }
  
  public static void acH(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateFamilyConfig value=" + paramInt);
    }
    H("readinjoy_family_config", Integer.valueOf(paramInt));
  }
  
  public static void acI(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKingCardSwitch value=" + paramInt);
    }
    H("readinjoy_kingcard_switch", Integer.valueOf(paramInt));
  }
  
  public static void acJ(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLog", 1, "updateViolaSusAutoPlayConfig value=" + paramInt);
    }
    H("viola_sus_video_auto_play", Integer.valueOf(paramInt));
  }
  
  public static void acv(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "updateVideoChannelFeedsType value=" + paramInt);
    }
    H("video_channel_feeds_type", Integer.valueOf(paramInt));
  }
  
  public static void acw(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "updateMultiVideoFeedsType value=" + paramInt);
    }
    H("multi_video_feeds_type", Integer.valueOf(paramInt));
  }
  
  public static void acx(int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateViolaPicDetailonfig value=" + paramInt);
    }
    if (paramInt == 1) {}
    for (;;)
    {
      H("VIOLA_DYNAMIC_PIC_DETAIL", Boolean.valueOf(bool));
      return;
      bool = false;
    }
  }
  
  public static void acy(int paramInt)
  {
    f("local_kd_tab_switch", Integer.valueOf(paramInt));
  }
  
  public static void acz(int paramInt)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("IdleExitAioRptCntForReport", paramInt);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static JSONObject ak()
  {
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject1 = new JSONObject();
    try
    {
      Object localObject = BaseApplicationImpl.getContext();
      localJSONObject2.put("bettery_level", mev.r());
      localJSONObject2.put("network_type", mev.getNetType());
      localJSONObject2.put("king_card", Qg());
      localJSONObject2.put("system_brightness", mev.a((Context)localObject));
      localJSONObject2.put("headset_on", mev.ar((Context)localObject));
      localJSONObject2.put("volume", mev.b((Context)localObject));
      localObject = kxt.a();
      localJSONObject2.put("acceleration", a(((kxt)localObject).b()));
      localJSONObject2.put("gyroscope", a(((kxt)localObject).a()));
      localObject = y("daily_cba_report_key");
      if ((localObject != null) && (!TextUtils.isEmpty(localObject.toString()))) {
        localJSONObject2.put("click_articles_list", new JSONArray(localObject.toString()));
      }
      return localJSONObject1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          localJSONObject1.put("cba_request_report_info", localJSONObject2);
          return localJSONObject1;
        }
        catch (Exception localException1)
        {
          QLog.e("ReadInJoyLog", 1, "exception ,msg=" + localException1.toString());
        }
        localException2 = localException2;
        QLog.e("ReadInJoyLog", 1, "getDailyCbaRequestData error,msg=" + localException2.toString());
      }
    }
  }
  
  /* Error */
  public static void ar(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iload_1
    //   4: putstatic 1645	awit:dqt	Z
    //   7: aload_0
    //   8: iconst_1
    //   9: invokestatic 1049	awit:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)Landroid/content/SharedPreferences;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: aload_2
    //   22: invokeinterface 302 1 0
    //   27: astore_2
    //   28: aload_2
    //   29: ldc_w 1988
    //   32: iload_1
    //   33: invokeinterface 361 3 0
    //   38: pop
    //   39: aload_2
    //   40: iconst_1
    //   41: invokestatic 313	awit:a	(Landroid/content/SharedPreferences$Editor;Z)V
    //   44: aload_0
    //   45: iload_1
    //   46: invokestatic 1990	kxm:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   49: goto -32 -> 17
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramQQAppInterface	QQAppInterface
    //   0	58	1	paramBoolean	boolean
    //   12	28	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	52	finally
    //   21	49	52	finally
  }
  
  public static void as(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("hot_shortvideo_multi_video_support", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static int at(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      return -1;
    }
    if (paramQQAppInterface.bo == 0) {
      return 1;
    }
    return 0;
  }
  
  public static void at(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = a(paramQQAppInterface, true, true);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("config_readinjoy_interested_push_switch", paramBoolean);
    a(paramQQAppInterface, true);
  }
  
  public static int au(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("readinjoy_video_channel_info_config_version" + paramQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public static void au(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("video_structmsg_play_switch", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static float b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsShortVideoWidthHeightRatio() failed");
      return 0.0F;
    }
    float f = paramAppRuntime.getFloat("readinjoy_short_video_width_height_ratio", -1.0F);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsShortVideoWidthHeightRatio() result=" + f);
    return f;
  }
  
  public static int b(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getVideoChannelAutoPlaySwitchDefaultValue failed to get sp");
      return paramInt;
    }
    return paramAppRuntime.getInt("video_channel_auto_play_switch", paramInt);
  }
  
  public static long b(AppRuntime paramAppRuntime)
  {
    if (aBa > 0L) {
      return aBa;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianFeedsCount() failed");
      return 0L;
    }
    aBa = paramAppRuntime.getLong("kandain_user_feeds_dynamic", 0L);
    return aBa;
  }
  
  @Deprecated
  public static SharedPreferences b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    while (paramInt == 2) {
      return null;
    }
    if ((paramInt == 0) && (Build.VERSION.SDK_INT >= 11)) {}
    for (int i = 4;; i = 0)
    {
      paramQQAppInterface = String.format("readinjoy_%s_%d", new Object[] { paramQQAppInterface.getAccount(), Integer.valueOf(paramInt) });
      return BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface, i);
    }
  }
  
  public static com.tencent.util.Pair<Long, Integer> b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return new com.tencent.util.Pair(Long.valueOf(86400L), Integer.valueOf(5));
    }
    return new com.tencent.util.Pair(Long.valueOf(paramAppRuntime.getLong("weishi_delete_outdate_article_interval", 86400L)), Integer.valueOf(paramAppRuntime.getInt("weishi_delete_outdate_article_feeds_cnt", 5)));
  }
  
  public static HashMap<String, Boolean> b(AppRuntime paramAppRuntime)
  {
    qO.clear();
    qO.putAll(a(paramAppRuntime));
    return qO;
  }
  
  public static List<liw.a> b(AppRuntime paramAppRuntime)
  {
    JSONObject localJSONObject = null;
    if (LT != null) {
      paramAppRuntime = LT;
    }
    for (;;)
    {
      return paramAppRuntime;
      paramAppRuntime = a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getFansInfoList() failed");
        return null;
      }
      Object localObject = paramAppRuntime.getString("kandian_user_fans_info_list", null);
      paramAppRuntime = localJSONObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONArray((String)localObject);
          int j = ((JSONArray)localObject).length();
          paramAppRuntime = localJSONObject;
          if (j > 0)
          {
            paramAppRuntime = new ArrayList(j);
            int i = 0;
            while (i < j)
            {
              localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              liw.a locala = new liw.a();
              locala.V(localJSONObject);
              paramAppRuntime.add(locala);
              i += 1;
            }
            LT = paramAppRuntime;
            return paramAppRuntime;
          }
        }
        catch (JSONException paramAppRuntime)
        {
          QLog.d("ReadInJoyHelper", 1, "getFansInfoList error. " + paramAppRuntime);
        }
      }
    }
    return null;
  }
  
  public static void b(LikeAnimationInfo paramLikeAnimationInfo)
  {
    int i = 0;
    if ((paramLikeAnimationInfo == null) || (paramLikeAnimationInfo.bA == null) || (paramLikeAnimationInfo.bA.length == 0)) {}
    do
    {
      do
      {
        return;
        localObject = a(kxm.getAppRuntime(), false, true);
      } while (localObject == null);
      Object localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("key_like_icon_length", paramLikeAnimationInfo.bA.length);
      while (i < paramLikeAnimationInfo.bA.length)
      {
        ((SharedPreferences.Editor)localObject).putString("key_like_icon" + i, paramLikeAnimationInfo.bA[i]);
        i += 1;
      }
      ((SharedPreferences.Editor)localObject).putInt("key_like_icon_next_req_interval", paramLikeAnimationInfo.aTU);
      a((SharedPreferences.Editor)localObject, true);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyHelper", 2, "saveLikeAnimationInfo: " + paramLikeAnimationInfo.toString());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt("readinjoy_video_channel_info_channel_id", paramInt1);
    paramQQAppInterface.putString("readinjoy_video_channel_info_channel_name", paramString);
    paramQQAppInterface.putInt("readinjoy_video_channel_info_channel_type", paramInt2);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent)
  {
    a(paramQQAppInterface, paramActivity, paramIntent, -1, null);
  }
  
  public static void b(AppRuntime paramAppRuntime, float paramFloat)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsShortVideoWidthHeightRatio() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsShortVideoWidthHeightRatio() value=" + paramFloat);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putFloat("readinjoy_short_video_width_height_ratio", paramFloat);
    a(paramAppRuntime, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianDeleteOutDateArticleInterval failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putLong("kandian_delete_outdate_article_interval", paramLong);
    a(paramAppRuntime, true);
  }
  
  public static boolean bP(boolean paramBoolean)
  {
    boolean bool2 = false;
    int i = 0;
    AppRuntime localAppRuntime = getAppRuntime();
    String str = "";
    boolean bool1 = bool2;
    if (localAppRuntime != null)
    {
      str = localAppRuntime.getAccount();
      Object localObject = a(localAppRuntime, true, true);
      if (localObject == null) {
        break label152;
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("local_kd_tab_switch", paramBoolean);
      bool1 = ((SharedPreferences.Editor)localObject).commit();
      if (bool1)
      {
        if (paramBoolean) {
          i = 1;
        }
        f("local_kd_tab_switch_prefix", Integer.valueOf(i));
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyHelper", 1, "updateKDTabSwitch app:" + localAppRuntime + "  account:" + str + "  switchOpen:" + paramBoolean + ", succ : " + bool1);
      return bool1;
      label152:
      bool1 = bool2;
    }
  }
  
  public static void br(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 4;
    try
    {
      int j = Integer.valueOf(paramString).intValue();
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.d("ReadInJoyHelper", 1, "updateReadInJoyFeedsGroupSetting failed " + paramString.toString());
      }
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("config_feeds_group_setting", i);
      a(paramQQAppInterface, true);
    }
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
  }
  
  public static void bs(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      i = Integer.valueOf(paramString).intValue();
      paramQQAppInterface = b(paramQQAppInterface, 1);
      if (paramQQAppInterface == null) {
        return;
      }
    }
    catch (Exception paramString)
    {
      int i;
      for (;;)
      {
        QLog.w("ReadInJoyHelper", 1, "updateReadInJoyPushMsgSwitch failed: " + paramString.toString());
        i = 1;
      }
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("readinjoy_config_push_msg_switch", i);
      a(paramQQAppInterface, true);
    }
  }
  
  public static void bt(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("config_smart_crop_pic_setting", "1".equals(paramString));
    a(paramQQAppInterface, true);
  }
  
  public static int c(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getVideoChannelAutoPlaySwitchDefaultValueVideoFlow failed to get sp");
      return paramInt;
    }
    return paramAppRuntime.getInt("video_channel_auto_play_switch_video_flow", paramInt);
  }
  
  public static long c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong(paramInt + "_" + "last_exit_channel_time", 0L);
  }
  
  public static long c(AppRuntime paramAppRuntime)
  {
    if (aAZ > 0L) {
      return aAZ;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianLikeCount() failed");
      return 0L;
    }
    aAZ = paramAppRuntime.getLong("kandian_user_total_like", 0L);
    return aAZ;
  }
  
  public static List<awit.a> c(AppRuntime paramAppRuntime)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramAppRuntime, true, true);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      paramAppRuntime = ((SharedPreferences)localObject).getString("readinjoy_my_tab_setting" + paramAppRuntime.getAccount(), "");
      try
      {
        for (paramAppRuntime = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramAppRuntime.getBytes("utf-8"))).getElementsByTagName("configs").item(0).getFirstChild();; paramAppRuntime = paramAppRuntime.getNextSibling())
        {
          localObject = localArrayList;
          if (paramAppRuntime == null) {
            break;
          }
          if ((paramAppRuntime.getFirstChild() != null) && (TextUtils.equals(paramAppRuntime.getNodeName(), "kandiansettings"))) {
            for (localObject = paramAppRuntime.getFirstChild(); localObject != null; localObject = ((Node)localObject).getNextSibling()) {
              if ((((Node)localObject).getNodeType() == 1) && (TextUtils.equals("defaultsettings", ((Node)localObject).getNodeName()))) {
                for (Node localNode = ((Node)localObject).getFirstChild(); localNode != null; localNode = localNode.getNextSibling()) {
                  if (localNode.getNodeType() == 1) {
                    localArrayList.add(a(localNode));
                  }
                }
              }
            }
          }
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramAppRuntime)
      {
        localObject = localArrayList;
      }
    }
    QLog.d("ReadInJoyHelper", 2, "exception occurs", paramAppRuntime);
    return localArrayList;
  }
  
  public static void c(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateWeishiDeleteOutdateArticleInterval failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putLong("weishi_delete_outdate_article_interval", paramLong);
    a(paramAppRuntime, true);
  }
  
  public static void c(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("readinjoy_social_weburl_" + paramString1, paramString2);
    a(paramAppRuntime, true);
  }
  
  public static boolean cA(QQAppInterface paramQQAppInterface)
  {
    return dqs;
  }
  
  public static boolean cB(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return false;
    }
    if ((aMA()) && (paramQQAppInterface.getBoolean("kandian_feeds", true))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean cC(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static boolean cD(QQAppInterface paramQQAppInterface)
  {
    return true;
  }
  
  public static boolean cE(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("video_structmsg_play_switch", true);
  }
  
  public static void cj(JSONObject paramJSONObject)
  {
    for (boolean bool = true;; bool = false) {
      try
      {
        String str1 = String.valueOf(cv.getAndIncrement());
        String str2 = String.valueOf("201809071320");
        if (paramJSONObject != null)
        {
          paramJSONObject.put("session_id", aBc);
          paramJSONObject.put("seq", str1);
          paramJSONObject.put("codeVersion", str2);
          QLog.d("ReadInJoyHelper", 1, "addExtraInfoInJson:  session_id:" + aBc + "  seq:" + str1 + "  codeVersion:" + str2 + " hasAdd:" + bool);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
  }
  
  public static void cu(int paramInt, boolean paramBoolean)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("exposed_channel_bg_consumed_" + paramInt, paramBoolean);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static long d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 10L;
    }
    return paramAppRuntime.getLong("msg_info_pulse_report_x", 10L);
  }
  
  public static List<awit.b> d(AppRuntime paramAppRuntime)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramAppRuntime, true, true);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      paramAppRuntime = ((SharedPreferences)localObject).getString("readinjoy_my_tab_setting" + paramAppRuntime.getAccount(), "");
      try
      {
        for (paramAppRuntime = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramAppRuntime.getBytes("utf-8"))).getElementsByTagName("configs").item(0).getFirstChild();; paramAppRuntime = paramAppRuntime.getNextSibling())
        {
          localObject = localArrayList;
          if (paramAppRuntime == null) {
            break;
          }
          if ((paramAppRuntime.getFirstChild() != null) && (TextUtils.equals(paramAppRuntime.getNodeName(), "kandiansettings"))) {
            for (localObject = paramAppRuntime.getFirstChild(); localObject != null; localObject = ((Node)localObject).getNextSibling()) {
              if ((((Node)localObject).getNodeType() == 1) && (TextUtils.equals("operatingsettings", ((Node)localObject).getNodeName()))) {
                for (Node localNode = ((Node)localObject).getFirstChild(); localNode != null; localNode = localNode.getNextSibling()) {
                  if (localNode.getNodeType() == 1) {
                    localArrayList.add(a(localNode));
                  }
                }
              }
            }
          }
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramAppRuntime)
      {
        localObject = localArrayList;
      }
    }
    QLog.d("ReadInJoyHelper", 2, "exception occurs", paramAppRuntime);
    return localArrayList;
  }
  
  public static void d(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("readinjoy_self_fragment_feedback_" + paramString1, paramString2);
    a(paramAppRuntime, true);
  }
  
  public static boolean dc(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.endsWith(":readinjoy"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean ds(long paramLong)
  {
    return ((Boolean)f("readinjoy_daily_child_refresh_channelID" + paramLong, Boolean.valueOf(false))).booleanValue();
  }
  
  public static long e(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 10L;
    }
    return paramAppRuntime.getLong("msg_info_pulse_report_y", 10L);
  }
  
  public static void e(long paramLong, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.edit().putLong("last_exit_kandian_time", paramLong).commit();
  }
  
  public static <T> void e(String paramString, T paramT, boolean paramBoolean)
  {
    QLog.d("ReadInJoyHelper", 2, "updateReadInJoySpValue: key - " + paramString + " value - " + paramT);
    Object localObject = a(kxm.getAppRuntime(), paramBoolean, true);
    if (localObject == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateReadInJoySpValue: sp is null");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramT instanceof String)) {
      ((SharedPreferences.Editor)localObject).putString(paramString, (String)paramT);
    }
    for (;;)
    {
      a((SharedPreferences.Editor)localObject, true);
      return;
      if ((paramT instanceof Integer))
      {
        ((SharedPreferences.Editor)localObject).putInt(paramString, ((Integer)paramT).intValue());
      }
      else if ((paramT instanceof Long))
      {
        ((SharedPreferences.Editor)localObject).putLong(paramString, ((Long)paramT).longValue());
      }
      else if ((paramT instanceof Float))
      {
        ((SharedPreferences.Editor)localObject).putFloat(paramString, ((Float)paramT).floatValue());
      }
      else
      {
        if (!(paramT instanceof Boolean)) {
          break;
        }
        ((SharedPreferences.Editor)localObject).putBoolean(paramString, ((Boolean)paramT).booleanValue());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("updateReadInJoySpValue: unsupported type ");
    if (paramT != null) {}
    for (paramString = paramT.getClass();; paramString = "null")
    {
      QLog.d("ReadInJoyHelper", 2, paramString);
      break;
    }
  }
  
  public static boolean e(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      m(paramAppRuntime, paramString);
      paramString = ((JSONObject)localObject).optString("app");
      localObject = ((JSONObject)localObject).optString("ver", null);
      if (!TextUtils.isEmpty(paramString)) {
        ThreadManager.executeOnSubThread(new ReadInJoyHelper.1(paramString, (String)localObject));
      }
      HashMap localHashMap = new HashMap();
      if (TextUtils.isEmpty(paramString)) {
        localHashMap.put("action", "configOff");
      }
      for (;;)
      {
        anpc.a(paramAppRuntime.getApplication()).collectPerformance(null, "actionReadInJoyArkConfig", true, 0L, 0L, localHashMap, null);
        return true;
        localHashMap.put("action", "configOn");
        localHashMap.put("appname", paramString);
        localHashMap.put("appver", localObject);
      }
      return false;
    }
    catch (Exception paramAppRuntime)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, "parse json error ", paramAppRuntime);
      }
    }
  }
  
  public static void eDI()
  {
    int i = 0;
    Object localObject = a(kxm.getAppRuntime(), false, true);
    if (localObject == null) {}
    int j;
    do
    {
      return;
      j = ((SharedPreferences)localObject).getInt("key_like_icon_length", 0);
    } while (j <= 0);
    localObject = ((SharedPreferences)localObject).edit();
    while (i < j)
    {
      ((SharedPreferences.Editor)localObject).remove("key_like_icon" + i);
      i += 1;
    }
    ((SharedPreferences.Editor)localObject).remove("key_like_icon_next_req_interval");
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void eDJ()
  {
    eAF = -1;
    eAG = -1;
    eAH = -1;
    eAI = -1;
    aAY = -1L;
    eAJ = -1;
    eAK = -1;
    eAL = -1;
    eAM = -1;
    eAO = -1;
    eAN = -1;
    eBc = -1;
    eBd = -1;
    eAY = -1;
    eAZ = 0;
    eBa = 0;
    LT = null;
    cQG = null;
    cQH = null;
    eBb = -1;
    eAT = -1;
    eBf = -1;
    aAZ = 0L;
    aBa = 0L;
    cQI = "";
    aBb = -1L;
  }
  
  public static void eDK()
  {
    int j = 0;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {}
    label180:
    label182:
    label187:
    label191:
    for (;;)
    {
      return;
      A(localAppRuntime);
      if (!kxm.AK())
      {
        int i = f("local_kd_tab_has_set_prefix").intValue();
        int k = f("local_kd_tab_switch_prefix").intValue();
        if ((i == -1) || (k == -1))
        {
          ThreadManager.executeOnSubThread(new ReadInJoyHelper.3(localAppRuntime));
          return;
        }
        label77:
        boolean bool1;
        if (i == 1)
        {
          i = 1;
          if (i != 0) {
            break label180;
          }
          if (k != 1) {
            break label182;
          }
          bool1 = true;
          label88:
          if (f("local_kd_tab_switch").intValue() != 1) {
            break label187;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          if (bool2 == bool1) {
            break label191;
          }
          i = j;
          if (bool1) {
            i = 1;
          }
          acy(i);
          a(localAppRuntime, bool2, bool1);
          QLog.d("ReadInJoyHelper", 1, localAppRuntime.getAccount() + " synSwitchCache now:" + bool1 + " pre :" + bool2);
          return;
          i = 0;
          break label77;
          break;
          bool1 = false;
          break label88;
        }
      }
    }
  }
  
  public static void eDL()
  {
    kg.clear();
    qp.clear();
  }
  
  public static void eDM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "updateShowRedPacketShareGuideTime: currentTime=" + System.currentTimeMillis());
    }
    H("READINJOY_RED_PACKET_SHARE_GUIDE", Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void eDN()
  {
    if (!dqv)
    {
      Aladdin.initialize(Aladdin.InitParams.newBuilder().withUserId(kxm.getAccount()).withAppVersion("3.4.4").withContext(BaseApplicationImpl.getContext()).withExecutor(kyj.a).withRequestHandler(new kyh()).withLogger(new kyf()).withAppFlavorId(AppSetting.getAppId() + "").build());
      Aladdin.registerBeanClass("AchillesParams", AchillesParams.class);
      Aladdin.registerConfigParser(140, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
      dqv = true;
    }
  }
  
  public static void eDO()
  {
    Object localObject1 = Calendar.getInstance();
    int i = ((Calendar)localObject1).get(1);
    int j = ((Calendar)localObject1).get(2);
    int k = ((Calendar)localObject1).get(5);
    localObject1 = i + j + k;
    Object localObject2 = a(kxm.getAppRuntime(), true, true);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 1, "saveFirstNoDifferenceJumpAppToday() failed");
      }
      return;
    }
    String str = ((SharedPreferences)localObject2).getString("readinjoy_first_no_difference_jump_app", null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 1, "saveFirstNoDifferenceJumpAppToday localDate = " + str);
    }
    localObject2 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject2).putString("readinjoy_first_no_difference_jump_app", (String)localObject1);
    a((SharedPreferences.Editor)localObject2, true);
  }
  
  public static void eDP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "updateUGCAccountCreateComplete value = true");
    }
    H(Hg(), Boolean.valueOf(true));
  }
  
  public static void eV(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface == null)
    {
      dqs = true;
      return;
    }
    dqs = paramQQAppInterface.getBoolean("readInJoy_subscribeAcc_gray_enable", true);
    QLog.d("SPLASH_ConfigServlet", 1, "ReadinjoyFolderMerge config " + dqs);
  }
  
  public static void eW(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("show_interest_label", false);
    a(paramQQAppInterface, true);
  }
  
  public static void eX(QQAppInterface paramQQAppInterface)
  {
    dqt = cC(paramQQAppInterface);
    QLog.d("SPLASH_ConfigServlet", 1, "ReadinjooyStopFunctionSwitch config:" + dqt);
  }
  
  public static int f(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getVideoChannelFeedsClickSwitch failed to get sp");
      return 1;
    }
    return paramAppRuntime.getInt("key_video_channel_feeds_click_switch", 0);
  }
  
  public static long f(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 10L;
    }
    return paramAppRuntime.getLong("msg_info_pulse_report_z", 10L);
  }
  
  public static Integer f(String paramString)
  {
    String str = getAccount();
    paramString = (Integer)qp.get(paramString + "_" + str);
    if (paramString == null) {}
    for (int i = -1;; i = paramString.intValue()) {
      return Integer.valueOf(i);
    }
  }
  
  public static <T> T f(String paramString, T paramT)
  {
    return a(paramString, paramT, true);
  }
  
  public static String f(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "checkLastScanTTDate() failed");
      return null;
    }
    return paramAppRuntime.getString("KANDIAN_LAST_SCAN_TT_DATE", "");
  }
  
  public static JSONArray f(List<String> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return localJSONArray;
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(paramList.get(i));
        i += 1;
      }
    }
  }
  
  public static void f(String paramString, Integer paramInteger)
  {
    String str = getAccount();
    qp.put(paramString + "_" + str, paramInteger);
    QLog.d("ReadInJoyHelper", 1, "updateKDTabConfigCache k: " + paramString + ", v: " + paramInteger + ", account" + str);
  }
  
  public static void f(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp IndividualPushSwitch");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_individual_push_switch", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean f(int paramInt, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, "isVideoFromTypeHint: config=" + paramString2 + ", videoFromType=" + paramInt);
      }
      boolean bool1 = bool2;
      int j;
      int i;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString2.split(paramString1);
        j = paramString1.length;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j)
        {
          bool1 = TextUtils.equals(String.valueOf(paramInt), paramString1[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      QLog.e("ReadInJoyHelper", 2, paramString2 + "isVideoFromTypeHint: ", paramString1);
    }
  }
  
  public static boolean f(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    localObject = i + j + k;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsAdLocalConfigToday() failed");
      return false;
    }
    String str = paramAppRuntime.getString(paramString, null);
    QLog.d("Q.readinjoy.tt_report", 1, "checkIsVideoFeedsAdLocalConfigToday localDate = " + str);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString(paramString, (String)localObject);
    a(paramAppRuntime, true);
    return false;
  }
  
  public static int g(AppRuntime paramAppRuntime)
  {
    return b(paramAppRuntime, 1);
  }
  
  public static long g(AppRuntime paramAppRuntime)
  {
    long l = 900000L;
    if (aBd != -1L) {
      l = aBd;
    }
    do
    {
      return l;
      paramAppRuntime = a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getReadInJoyTabAutoRefreshTimeDuration() failed");
        return 900000L;
      }
      aBd = paramAppRuntime.getInt("ReadInJoy_Tab_Auto_Refresh_Time_Duration", -1);
    } while (aBd == -1L);
    return aBd;
  }
  
  public static String g(AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(cQI))
    {
      paramAppRuntime = a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getUserDesc() failed");
        return null;
      }
      cQI = paramAppRuntime.getString("kandian_user_desc", "");
    }
    return cQI;
  }
  
  public static void g(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.edit().putLong(paramInt + "_" + "last_exit_channel_time", paramLong).commit();
  }
  
  public static void g(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowRecommendReasonInTitle");
      return;
    }
    SharedPreferences.Editor localEditor = paramAppRuntime.edit();
    if (paramBoolean) {}
    for (paramAppRuntime = "1";; paramAppRuntime = "0")
    {
      localEditor.putString("readinjoy_show_recommend_reason_in_title_b", paramAppRuntime);
      a(localEditor, true);
      return;
    }
  }
  
  public static boolean g(int paramInt, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, paramString2 + "invalid spilt or configKey");
      }
      return false;
    }
    return f(paramInt, paramString1, (String)f(paramString2, ""));
  }
  
  public static boolean g(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if ((paramAppRuntime == null) || (paramString == null)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, new Object[] { "updateKandianMyTabPage, value = ", paramString });
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("kandian_my_tab_page", paramString);
    a(paramAppRuntime, true);
    return true;
  }
  
  public static String gL(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    return String.format("%d万", new Object[] { Integer.valueOf((paramInt + 5000) / 10000) });
  }
  
  public static String gM(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    if (paramInt < 99989500)
    {
      if (paramInt % 10000 < 500) {
        return paramInt / 10000 + acfp.m(2131713618);
      }
      int i = paramInt;
      if (paramInt % 500 == 0) {
        i = paramInt + 1;
      }
      if (i % 10000 > 9500) {
        return (i + 500) / 10000 + acfp.m(2131713636);
      }
      return String.format("%.1f万", new Object[] { Float.valueOf(i / 10000.0F) });
    }
    return "9999万";
  }
  
  public static String gN(int paramInt)
  {
    int i = paramInt % 60;
    int j = paramInt / 60 % 60;
    paramInt /= 3600;
    if (paramInt > 0) {
      return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i) });
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
  }
  
  public static String gO(int paramInt)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getString("exposed_channel_bg_url_" + paramInt, null);
  }
  
  public static String getAccount()
  {
    Object localObject = getAppRuntime();
    if (localObject == null) {
      localObject = "0";
    }
    String str;
    do
    {
      return localObject;
      str = ((AppRuntime)localObject).getAccount();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
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
  
  public static int h(AppRuntime paramAppRuntime)
  {
    return c(paramAppRuntime, 0);
  }
  
  public static long h(AppRuntime paramAppRuntime)
  {
    long l = 600000L;
    if (aBe != -1L) {
      l = aBe;
    }
    do
    {
      return l;
      paramAppRuntime = a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getReadInJoyMessageAutoRefreshTimeDuration() failed");
        return 600000L;
      }
      aBe = paramAppRuntime.getInt("ReadInJoy_Message_Auto_Refresh_Time_Duration", -1);
    } while (aBe == -1L);
    return aBe;
  }
  
  public static com.tencent.util.Pair<Long, Integer> h()
  {
    long l = ((Integer)f("weishi_recommend_delete_outdate_article_interval", Integer.valueOf(86400))).intValue();
    int i = ((Integer)f("weishi_recommend_delete_outdate_article_feeds_counts", Integer.valueOf(10))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "getWeishiRecommendDeleteOutdatedArticleParam, time: " + l + ", counts: " + i);
    }
    return new com.tencent.util.Pair(Long.valueOf(l), Integer.valueOf(i));
  }
  
  public static String h(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsInterruptedAdfigFromServer() failed");
      return null;
    }
    paramAppRuntime = paramAppRuntime.getString("VIDEO_FEEDS_INTERRUPTED_AD_CONFIG_NEW", null);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsInterruptedAdfigFromServer() result=" + paramAppRuntime);
    return paramAppRuntime;
  }
  
  public static void h(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp READINJOY_SIMPLE_SWITCH_FM");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("READINJOY_SIMPLE_SWITCH_FM", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static void hc(String paramString, int paramInt)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("exposed_channel_bg_url_" + paramInt, paramString);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static int i(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getReadInJoyVideoJumpDefaultValue failed to get sp");
      return 0;
    }
    return paramAppRuntime.getInt("readinjoy_video_jump_default_value", 0);
  }
  
  public static String i(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsInterruptedAdConfigLocal() failed");
      return null;
    }
    paramAppRuntime = paramAppRuntime.getString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG_NEW", null);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsInterruptedAdConfigLocal() result=" + paramAppRuntime);
    return paramAppRuntime;
  }
  
  public static void i(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp subscribe list push config ");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_subscribe_list_push", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static long iS()
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {
      return -1L;
    }
    localObject = a((AppRuntime)localObject, true, true);
    if (localObject == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to  getVideoRealTimeLogDebug");
      return -1L;
    }
    return ((SharedPreferences)localObject).getLong("readinjoy_video_real_time_debug_log", -1L);
  }
  
  public static long iT()
  {
    long l = ((Long)f("readinjoy_video_ff_probesize", Long.valueOf(0L))).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "getFFProbesize,probesize:" + l);
    }
    return l;
  }
  
  public static boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public static int j(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 0;
    }
    return paramAppRuntime.getInt("readinjoy_video_videoinfo_anim_viewtop", 0);
  }
  
  public static String j(AppRuntime paramAppRuntime)
  {
    return Aladdin.getConfig(178).getString("native_engine_timeout_config", "1000,10000,10000,2000,15000");
  }
  
  public static void j(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_show_video_toast", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static void jD(String paramString1, String paramString2)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return;
      obr.aE(1, paramString2);
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static int k(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsAdConfigLocal() failed");
      return 60;
    }
    int i = paramAppRuntime.getInt("camera_capture_max_duration", 60);
    QLog.d("Q.readinjoy.video", 1, "getCameraCaptureMaxDuration() result=" + i);
    return i;
  }
  
  public static String k(Activity paramActivity)
  {
    int i = 0;
    if ((paramActivity instanceof ReadInJoyNewFeedsActivity)) {
      i = 1;
    }
    for (;;)
    {
      return "56_last_exit_channel_time" + cQD + i;
      if ((paramActivity instanceof SplashActivity)) {
        i = 2;
      } else if ((paramActivity instanceof ReadInJoyChannelActivity)) {
        i = 3;
      }
    }
  }
  
  public static void k(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoPreOutputFirstFrameSwitch");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_video_preoutput_first_frame_switch", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static int l(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigRedShowNum() failed");
      return -1;
    }
    if (eAG != -1) {
      return eAG;
    }
    eAG = paramAppRuntime.getInt("kandian_tabdot_show_num", 0);
    return eAG;
  }
  
  public static void l(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoChannelFeedsClickSwitchValue failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("key_video_channel_feeds_click_switch", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void l(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoPreDownloadSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_video_predownload_switch", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static void lk(int paramInt1, int paramInt2)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("kandian_aio_msg_received_duration", paramInt1);
    ((SharedPreferences.Editor)localObject).putInt("kandian_aio_msg_send_duration", paramInt2);
    a((SharedPreferences.Editor)localObject, true);
    QLog.d("ReadInJoyHelper", 2, "update aio msg receive & send duration A : " + paramInt1 + ", B : " + paramInt2);
  }
  
  public static void ll(int paramInt1, int paramInt2)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("ExitAioIdleReportUinLimitS", paramInt1);
    ((SharedPreferences.Editor)localObject).putInt("ExitAioIdleReportUinLimitE", paramInt2);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static int m(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigRedThreshold() failed");
      return -1;
    }
    if (eAH != -1) {
      return eAH;
    }
    eAH = paramAppRuntime.getInt("kandian_tabdot_threshold", 0);
    return eAH;
  }
  
  public static void m(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoChannelAutoPlaySwitchDefaultValue failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_channel_auto_play_switch", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void m(AppRuntime paramAppRuntime, String paramString)
  {
    SharedPreferences localSharedPreferences = a(paramAppRuntime, true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateArkChannelConfig");
      return;
    }
    paramAppRuntime = paramString;
    if (paramString == null) {
      paramAppRuntime = "";
    }
    paramString = localSharedPreferences.edit();
    paramString.putString("readinjoy_ark_channel_config", paramAppRuntime);
    a(paramString, true);
  }
  
  public static void m(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("Q.readinjoy.video", 1, "failed to update sp KandianVideoSocialSwitch");
    }
    do
    {
      return;
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putBoolean("kandian_video_social_switch", paramBoolean);
      a(paramAppRuntime, true);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "updateKandianVideoSocialSwitch():" + paramBoolean);
  }
  
  public static int n(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianLocalRedShowNum() failed");
      return -1;
    }
    if (eAI != -1) {
      return eAI;
    }
    eAI = paramAppRuntime.getInt("kandian_tabdot_has_show_num", 0);
    return eAI;
  }
  
  public static void n(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_channel_auto_play_switch_video_flow", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void n(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if ((paramAppRuntime == null) || (paramString == null)) {}
    do
    {
      return;
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putBoolean("readinjoy_ark_app_show_setting", paramString.equals("1"));
      a(paramAppRuntime, true);
      if (kpc.ao == null) {
        kpc.ao = new AtomicBoolean();
      }
      kpc.ao.set(paramString.equals("1"));
    } while (!paramString.equals("1"));
    kpc.aFG();
  }
  
  public static void n(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    int i = 1;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("free_time_refresh_push", paramBoolean);
    a(paramAppRuntime, true);
    if (paramBoolean) {}
    for (;;)
    {
      eAF = i;
      return;
      i = 0;
    }
  }
  
  public static boolean nJ(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "isReadinjoyVideoChannel() channelType=" + paramInt);
    }
    return paramInt == 3;
  }
  
  public static boolean nK(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    SharedPreferences localSharedPreferences = a(kxm.getAppRuntime(), false, true);
    if (localSharedPreferences == null) {
      return bool2;
    }
    long l1 = System.currentTimeMillis();
    long l2 = localSharedPreferences.getLong("key_like_icon_last_fetch_ts", 0L);
    if (l1 - l2 > paramInt * 1000) {}
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyHelper", 2, "isNeedFetchLikeAnimation, cts: " + l1 + ", lts: " + l2 + ", isNeedFetch: " + bool1);
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean nL(int paramInt)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {}
    do
    {
      return false;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getBoolean("exposed_channel_bg_consumed_" + paramInt, false);
  }
  
  public static boolean nM(int paramInt)
  {
    String str = Aladdin.getConfig(286).getString("loop_play_from_type", "");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "getVideoFeedsLoopPlayConfig: " + str);
    }
    return f(paramInt, ",", str);
  }
  
  public static boolean nN(int paramInt)
  {
    return g(paramInt, ",", "VIDEO_FEEDS_SINGLE_VIDEO_CONFIG");
  }
  
  public static void nQ(long paramLong)
  {
    Object localObject = a(kxm.getAppRuntime(), false, true);
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("key_like_icon_last_fetch_ts", paramLong);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void nR(long paramLong)
  {
    H("readinjoy_daily_child_refresh_channelID" + paramLong, Boolean.valueOf(true));
    QLog.d("ReadInJoyHelper", 1, "updateDailyChildRefreshCmd cba channelID=" + paramLong);
  }
  
  public static int o(AppRuntime paramAppRuntime)
  {
    if (eAK > 0) {
      return eAK;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBiuWordCount() failed");
      return kwt.aMj;
    }
    eAK = paramAppRuntime.getInt("kandian_biu_word_count", kwt.aMj);
    return eAK;
  }
  
  public static SharedPreferences o(String paramString)
  {
    paramString = "readinjoy_sp_" + paramString;
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0);
  }
  
  public static void o(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof ArticleInfo)) {}
    while (((!kys.dv((int)paramBaseArticleInfo.mChannelID)) && (!ds(paramBaseArticleInfo.mChannelID))) || (!aMW())) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyHelper.6(paramBaseArticleInfo));
  }
  
  public static void o(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateReadInJoyVideoJumpDefaultValue failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_video_jump_default_value", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void o(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "setLastScanTTDate() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("KANDIAN_LAST_SCAN_TT_DATE", paramString);
    a(paramAppRuntime, true);
  }
  
  public static void o(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "setKanDianReportTTSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("KANDIAN_REPORT_TT_SWITCH", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static int p(AppRuntime paramAppRuntime)
  {
    if (eAL > 0) {
      return eAL;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentWordCount() failed");
      return kwt.aMk;
    }
    eAL = paramAppRuntime.getInt("kandian_comment_word_count", kwt.aMk);
    return eAL;
  }
  
  public static void p(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateCUKingCardDlgSwitch failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("CUKingCard_dlg_enable_switch", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void p(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsName() failed");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsName() name is null");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("kandian_biu_feeds_name", paramString);
    a(paramAppRuntime, true);
    cQE = paramString;
  }
  
  public static void p(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianSelfForbidden() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("kandian_user_forbidden", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static int q(AppRuntime paramAppRuntime)
  {
    if ((eAM == 0) || (eAM == 1)) {
      return eAM;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentGifSwitch() failed");
      return 0;
    }
    eAM = paramAppRuntime.getInt("kandian_comment_gif_switch", 0);
    return eAM;
  }
  
  public static void q(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateInnerVideoInfoShowSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_video_videoinfo_anim_viewtop", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void q(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsWebUrl() failed");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsWebUrl() url is null");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("kandian_biu_feeds_web_url", paramString);
    a(paramAppRuntime, true);
    cQF = paramString;
  }
  
  public static void q(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsPrePlaySwitch() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsPrePlaySwitch() value=" + paramBoolean);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("VIDEO_FEEDS_PREPLAY_SWITCH", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean q(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("READINJOY_VIDEO_CHANNEL_AUTO_PLAY_NEXT_VIDEO_HINT", true);
    if (bool)
    {
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putBoolean("READINJOY_VIDEO_CHANNEL_AUTO_PLAY_NEXT_VIDEO_HINT", false);
      a(paramAppRuntime, true);
    }
    return bool;
  }
  
  public static int r(AppRuntime paramAppRuntime)
  {
    if ((eAO == 0) || (eAO == 1)) {
      return eAO;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentZhituSwitch() failed");
      return 0;
    }
    eAO = paramAppRuntime.getInt("kandian_comment_zhitu_switch", 0);
    return eAO;
  }
  
  public static void r(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateCameraCaptureMaxDuration() failed");
      return;
    }
    QLog.d("Q.readinjoy.video", 1, "updateCameraCaptureMaxDuration() value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    int i = paramInt;
    if (paramInt > 60) {
      i = 60;
    }
    paramAppRuntime.putInt("camera_capture_max_duration", i);
    a(paramAppRuntime, true);
  }
  
  public static void r(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuWordCount() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i <= 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuWordCount() count <= 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuWordCount() parseInt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_biu_word_count", i);
    a(paramAppRuntime, true);
    eAK = i;
  }
  
  public static void r(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianMsgStickFlag() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean(cQK, paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean r(AppRuntime paramAppRuntime)
  {
    return true;
  }
  
  public static int s(AppRuntime paramAppRuntime)
  {
    if ((eAP == 0) || (eAP == 1)) {
      return eAP;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConifgFastWebCloseBiuCntSwitch() failed");
      return 0;
    }
    eAP = paramAppRuntime.getInt("fast_web_close_biu_cnt_switch", 0);
    return eAP;
  }
  
  public static long s(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = b(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong("last_exit_kandian_time", 0L);
  }
  
  public static void s(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = b(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("share_to_news", bool);
    a(paramString, true);
  }
  
  public static void s(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigRedShowNum() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_tabdot_show_num", paramInt);
    a(paramAppRuntime, true);
    eAG = paramInt;
  }
  
  public static void s(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentWordCount() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i <= 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentWordCount() count <= 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentWordCount() parseInt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_comment_word_count", i);
    a(paramAppRuntime, true);
    eAL = i;
  }
  
  public static void s(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateVideoTabFakeReddotErasureByUser() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("videotab_fake_reddot_erasure_by_user", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean s(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return "1".equals(paramAppRuntime.getString("readinjoy_show_recommend_reason_in_title_b", ""));
  }
  
  public static String sn(String paramString)
  {
    Object localObject = kxm.getAppRuntime();
    if (localObject == null) {
      return "0";
    }
    localObject = a((AppRuntime)localObject, true, true);
    if (localObject != null) {
      return ((SharedPreferences)localObject).getString(paramString, "0");
    }
    return "0";
  }
  
  public static int t(AppRuntime paramAppRuntime)
  {
    if ((eAN == 0) || (eAN == 1)) {
      return eAN;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianUGCCommentGifSwitch() failed");
      return 0;
    }
    eAN = paramAppRuntime.getInt("kandian_ugc_gif_switch", 0);
    return eAN;
  }
  
  public static android.util.Pair<Integer, Integer> t()
  {
    SharedPreferences localSharedPreferences = a(kxm.getAppRuntime(), true, true);
    if (localSharedPreferences == null) {
      return new android.util.Pair(Integer.valueOf(60), Integer.valueOf(60));
    }
    return new android.util.Pair(Integer.valueOf(localSharedPreferences.getInt("kandian_aio_msg_received_duration", 60)), Integer.valueOf(localSharedPreferences.getInt("kandian_aio_msg_send_duration", 60)));
  }
  
  public static void t(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = b(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("synchronize_to_qzone", bool);
    a(paramString, true);
  }
  
  public static void t(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigRedThreshold() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_tabdot_threshold", paramInt);
    a(paramAppRuntime, true);
    eAH = paramInt;
  }
  
  public static void t(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() gifSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() parseInt failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() gifSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_comment_gif_switch", i);
    a(paramAppRuntime, true);
    eAM = i;
  }
  
  public static void t(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateWebCgiPreloadSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("kandianWebPreLoadData", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean t(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp subscribe list push config ");
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_subscribe_list_push", false);
  }
  
  public static boolean tZ(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = je;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (TextUtils.equals(arrayOfString[i], paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static int u(AppRuntime paramAppRuntime)
  {
    if ((eAR == 0) || (eAR == 1)) {
      return eAR;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigUgcAtSwitch() failed");
      return 0;
    }
    eAR = paramAppRuntime.getInt("kandian_ugc_at_switch", 0);
    return eAR;
  }
  
  public static android.util.Pair<Integer, Integer> u()
  {
    SharedPreferences localSharedPreferences = a(kxm.getAppRuntime(), true, true);
    if (localSharedPreferences == null) {
      return null;
    }
    return new android.util.Pair(Integer.valueOf(localSharedPreferences.getInt("ExitAioIdleReportUinLimitS", -1)), Integer.valueOf(localSharedPreferences.getInt("ExitAioIdleReportUinLimitE", -1)));
  }
  
  public static void u(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = "1".equals(paramString);
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("readInJoy_subscribeAcc_gray_enable", bool);
    a(paramString, true);
  }
  
  public static void u(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianLocalRedShowNum() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_tabdot_has_show_num", paramInt);
    a(paramAppRuntime, true);
    eAI = paramInt;
  }
  
  public static void u(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() gifSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() parseInt failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() gifSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_ugc_gif_switch", i);
    a(paramAppRuntime, true);
    eAN = i;
  }
  
  private static void u(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    QLog.d("ReadInJoyHelper", 2, "updateShowKandianTab show  " + paramBoolean);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateShowKandianTab() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("show_kandian_main_video_sp", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean u(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_show_video_toast", false);
  }
  
  public static boolean ua(String paramString)
  {
    return false;
  }
  
  public static boolean ub(String paramString)
  {
    Object localObject = kxm.getAppRuntime();
    if ((localObject == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getStringSet("kd_icon_merge_subscription_white_list", new HashSet()).contains(paramString);
  }
  
  public static int v(AppRuntime paramAppRuntime)
  {
    if ((eAS == 0) || (eAS == 1)) {
      return eAS;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBiuAtSwitch() failed");
      return 0;
    }
    eAS = paramAppRuntime.getInt("kandian_biu_at_switch", 0);
    return eAS;
  }
  
  public static void v(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = b(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("merge_feeds", bool);
    a(paramString, true);
  }
  
  public static void v(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      ndi.aYd = 1000;
      QLog.d("ReadInJoyHelper", 1, "app null update feeds group setting:" + ndi.aYd);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      paramAppRuntime = String.format("readinjoy_%s_%d", new Object[] { paramAppRuntime.getAccount(), Integer.valueOf(1) });
      paramAppRuntime = BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, i);
      if (paramAppRuntime == null)
      {
        ndi.aYd = 1000;
        QLog.d("ReadInJoyHelper", 1, "sp null update feeds group setting:" + ndi.aYd);
        return;
      }
      ndi.aYd = paramAppRuntime.getInt("config_feeds_group_setting", 1000);
      QLog.d("ReadInJoyHelper", 1, "update feeds group setting:" + ndi.aYd);
      return;
    }
  }
  
  public static void v(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_biu_feeds_switch", paramInt);
    a(paramAppRuntime, true);
    eAJ = paramInt;
  }
  
  public static void v(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() zhituSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() zhituSwitch failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() zhituSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_comment_zhitu_switch", i);
    a(paramAppRuntime, true);
    eAO = i;
  }
  
  private static void v(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    int i = 0;
    Object localObject = a(paramAppRuntime, true, true);
    QLog.d("ReadInJoyHelper", 2, "updateShowKandianTab show  " + paramBoolean);
    if (localObject == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateShowKandianTab() failed");
      return;
    }
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    localEditor.putBoolean("show_kandian_in_main_frame_sp", paramBoolean);
    int j = ((SharedPreferences)localObject).getInt("kandian_tab_switch_config_received_cnt", 0);
    QLog.d("ReadInJoyHelper", 2, "receiveKandiantTabConfig cnt : " + j);
    if (paramBoolean)
    {
      j += 1;
      localEditor.putInt("kandian_tab_switch_config_received_cnt", j);
      localObject = qq;
      paramAppRuntime = paramAppRuntime.getAccount();
      if (j == 1) {
        ((Map)localObject).put(paramAppRuntime, Integer.valueOf(i));
      }
    }
    for (;;)
    {
      a(localEditor, true);
      return;
      i = j;
      break;
      localEditor.remove("kandian_tab_switch_config_received_cnt");
      if (j != 1) {
        qq.put(paramAppRuntime.getAccount(), Integer.valueOf(j));
      }
    }
  }
  
  public static boolean v(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_video_preoutput_first_frame_switch", true);
  }
  
  public static int w(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getDianDianConfigRightButtonAtSwitch() failed");
      return 0;
    }
    return paramAppRuntime.getInt("diandian_right_button_at_switch_new", 0);
  }
  
  public static void w(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = b(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("kandian_feeds", bool);
    a(paramString, true);
  }
  
  public static void w(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp IndividualPushDate");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("readinjoy_individual_push_date", kxm.s.format(Long.valueOf(System.currentTimeMillis())));
    a(paramAppRuntime, true);
  }
  
  public static void w(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianNewChannelStyle() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt(cQC, paramInt);
    a(paramAppRuntime, true);
    eBc = paramInt;
  }
  
  public static void w(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigFastWebCloseBiuCntSwtich() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigFastWebCloseBiuCntSwtich() biuCntSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigFastWebCloseBiuCntSwtich() biuCntSwitch failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigFastWebCloseBiuCntSwtich() biuCntSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("fast_web_close_biu_cnt_switch", i);
    a(paramAppRuntime, true);
    eAP = i;
  }
  
  public static void w(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("nw_support", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean w(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_video_predownload_switch", true);
  }
  
  public static int x(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKanDianRightButtonAtSwitch() failed");
      return 0;
    }
    return paramAppRuntime.getInt("kandian_right_button_at_switch_new", 0);
  }
  
  public static void x(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {}
    do
    {
      return;
      String str = paramAppRuntime.getString("readinjoy_social_weburl_homepage", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acF = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_messagebox_V3", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acC = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_collectbox", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acO = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_messagebox_pendant_V3", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acG = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_commentpage", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acD = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_recommend_friends", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acE = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_accountpage", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acJ = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_mytopic", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acN = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_myhistory", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acM = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_myfollow", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acT = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_myfans", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acU = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_mynotify", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acP = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_collectbox_V2", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acQ = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_myliked", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acR = str;
      }
      paramAppRuntime = paramAppRuntime.getString("readinjoy_social_weburl_mycomment", "");
    } while (TextUtils.isEmpty(paramAppRuntime));
    kwt.acS = paramAppRuntime;
  }
  
  public static void x(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoChannelCoverStyle() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_channel_cover_style", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void x(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKDRedPntPushArticlePreloadSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKDRedPntPushArticlePreloadSwitch() preloadSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKDRedPntPushArticlePreloadSwitch() preloadSwitch failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKDRedPntPushArticlePreloadSwitch() preloadSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_preload_red_pnt_push_article_switch", i);
    a(paramAppRuntime, true);
    eAQ = i;
  }
  
  public static void x(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("nw_preload", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean x(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_video_videoinfo_switch", false);
  }
  
  public static int y(AppRuntime paramAppRuntime)
  {
    if ((eAU == 0) || (eAU == 1)) {
      return eAU;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getReadInjoyShareToWxAtSwitch() failed");
      return 0;
    }
    eAU = paramAppRuntime.getInt("readinjoy_share_to_WX_at_switch", 0);
    return eAU;
  }
  
  public static Object y(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject3 == null)
    {
      QLog.d("ReadInJoyHelper", 1, new Object[] { "app is null, getKDSPValueWithKey, key = ", paramString, ", value is null." });
      localObject2 = localObject1;
      return localObject2;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyHelper", 1, "key is null or empty, can not get value.");
      return null;
    }
    localObject3 = a((AppRuntime)localObject3, true, true);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      if ((!paramString.equals("remote_kd_tab_switch")) && (!paramString.equals("kd_topic_recommend_card_jump_switch")) && (!paramString.equals("sp_key_create_topic_switch"))) {
        break label161;
      }
      localObject1 = Boolean.valueOf(((SharedPreferences)localObject3).getBoolean(paramString, false));
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyHelper", 2, new Object[] { "getKDSPValueWithKey, key = ", paramString, ", value = ", localObject1 });
      return localObject1;
      label161:
      if ((paramString.equals("local_kd_tab_type")) || (paramString.equals("remote_kd_tab_type")) || (paramString.equals("kd_topic_recommend_card_jump_url")) || (paramString.equals("debug_kd_tab_type")))
      {
        if ((paramString.equals("local_kd_tab_type")) || (paramString.equals("remote_kd_tab_type"))) {
          localObject1 = ((SharedPreferences)localObject3).getString(paramString, "1");
        } else {
          localObject1 = ((SharedPreferences)localObject3).getString(paramString, "0");
        }
      }
      else if ((paramString == "local_kd_native_main_text_style") || ("daily_cba_report_key".equalsIgnoreCase(paramString)))
      {
        localObject1 = ((SharedPreferences)localObject3).getString(paramString, "");
      }
      else if (paramString.equals("local_kd_tab_switch"))
      {
        localObject1 = Boolean.valueOf(((SharedPreferences)localObject3).getBoolean(paramString, true));
      }
      else
      {
        localObject1 = localObject2;
        if (paramString.equals("local_kd_tab_has_set")) {
          localObject1 = Boolean.valueOf(((SharedPreferences)localObject3).getBoolean(paramString, false));
        }
      }
    }
  }
  
  public static void y(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {}
    do
    {
      return;
      String str = paramAppRuntime.getString("readinjoy_self_fragment_feedback_feedsbackName", "");
      if (!TextUtils.isEmpty(str)) {
        kwt.acK = str;
      }
      str = paramAppRuntime.getString("readinjoy_self_fragment_feedback_feedsbackSwitch", "");
      if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(str, "1"))) {
        kwt.aid = true;
      }
      paramAppRuntime = paramAppRuntime.getString("readinjoy_self_fragment_feedback_feedsbackWebUrl", "");
    } while (TextUtils.isEmpty(paramAppRuntime));
    kwt.acL = paramAppRuntime;
  }
  
  public static void y(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommmendStrategy() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoDynamicRecommmendStrategy() num=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_dynamic_recommend_strategyid", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void y(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() parseInt failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_ugc_at_switch", i);
    a(paramAppRuntime, true);
    eAR = i;
  }
  
  public static void y(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("exposure_strengthen", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean y(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_viola_message_box_switch", false);
  }
  
  public static int z(AppRuntime paramAppRuntime)
  {
    if ((eAV == 0) || (eAV == 1)) {
      return eAV;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentBiuSwitch() failed");
      return 0;
    }
    eAV = paramAppRuntime.getInt("kandian_comment_biu_switch", 0);
    return eAV;
  }
  
  public static void z(AppRuntime paramAppRuntime)
  {
    cQJ = null;
    J(paramAppRuntime, "");
    QLog.d("ReadInJoyHelper", 1, "clearMedalInfo");
  }
  
  public static void z(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommmendDurationLimit() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoDynamicRecommmendDurationLimit() num=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_dynamic_recommend_duration_limit", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void z(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() failed");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() parseInt failed");
      return;
    }
    if (i > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_biu_at_switch", i);
    a(paramAppRuntime, true);
    eAS = i;
  }
  
  public static boolean z(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_viola_column_entry_switch", false);
  }
  
  public static class a
  {
    public int eBi;
    public int id;
    public String title;
  }
  
  public static class b
  {
    public int id;
    public String jumpUrl;
    public String title;
  }
  
  public static class c
  {
    public float DA;
    public float Dz;
    public boolean dqw;
    public boolean dqx = true;
    public boolean dqy = true;
    public int eBj;
    public int eBk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awit
 * JD-Core Version:    0.7.0.1
 */