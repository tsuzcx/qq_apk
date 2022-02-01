import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.util.Achilles;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class kgw
{
  public static String Zh = "https://kandian.qq.com/mqq/html/settingInterest.html?_wv=1027&_bid=2378";
  private static int aII = -1;
  
  public static void L(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://kandian.qq.com/mqq/watchspot/sticker.html?_wwv=265&_wv=1027&_wvSb=0&_nav_titleclr=000000&_bid=3002");
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramContext.startActivity(localIntent);
    kbp.a(null, "CliOper", "", "", "0X8008C89", "0X8008C89", 0, 0, paramInt + "", "", "", ReadInJoyBaseDeliverActivity.ig(), false);
  }
  
  public static void M(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("launch_from", paramInt);
    localIntent.putExtra("tab_index", MainFragment.bIr);
    localIntent.putExtra("open_kandian_tab_fragment", true);
    localIntent.setFlags(335544320);
    if ((paramInt == 9) || (paramInt == 6))
    {
      kxm.mO(true);
      kxs.aQ(localIntent);
    }
    if (paramContext != null) {
      paramContext.startActivity(localIntent);
    }
  }
  
  private static String N(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return paramString2;
      try
      {
        if ("com.tencent.rijvideo".equalsIgnoreCase(paramString1))
        {
          paramString1 = Uri.parse(paramString2);
          Object localObject = paramString1.getQueryParameterNames();
          Uri.Builder localBuilder = paramString1.buildUpon().clearQuery();
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            localBuilder.appendQueryParameter(str, URLEncoder.encode(paramString1.getQueryParameter(str), "utf-8"));
          }
          return localBuilder.toString();
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("ReadInJoyActivityHelper", 1, paramString1, new Object[0]);
        return paramString2;
      }
    } while (!"com.tencent.reading".equalsIgnoreCase(paramString1));
    paramString1 = lwg.a().eO(paramString2);
    return paramString1;
  }
  
  public static Intent a(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, 0);
  }
  
  public static Intent a(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = null;
    if (paramInt1 != -1) {
      localIntent = new Intent(paramContext, ReadInJoyFeedsActivity.class);
    }
    if (paramInt1 != -1) {
      localIntent.putExtra("readinjoy_show_tab", paramInt1);
    }
    if (paramInt2 != -1) {
      localIntent.putExtra("tab_tab_index", paramInt2);
    }
    return localIntent;
  }
  
  public static Intent a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = a(paramContext, paramInt);
    paramContext.putExtra("arg_channel_rowkey", paramString1);
    paramContext.putExtra("arg_channel_article_url", paramString2);
    return paramContext;
  }
  
  private static void a(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("sourceFrom");
    j = -1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramHashMap)) {
          continue;
        }
        boolean bool = "nativeArticleRecommend".equalsIgnoreCase(paramHashMap);
        if (!bool) {
          continue;
        }
        i = 10;
      }
      catch (Exception paramHashMap)
      {
        paramHashMap.printStackTrace();
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ReadInJoyActivityHelper", 2, "openEmptyFullPlayActivity: ", paramHashMap);
        i = j;
        continue;
        i = -1;
        continue;
      }
      muj.a(paramActivity, null, true, i);
      return;
      i = Integer.valueOf(paramHashMap).intValue();
    }
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramContext == null) {}
    while (lvx.aq(paramContext)) {
      return;
    }
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if (!(paramContext instanceof BaseActivity)) {
      localIntent.setFlags(268435456);
    }
    if (paramBoolean)
    {
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
    }
    localIntent.putExtra("launch_from", paramInt);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.start(paramContext, localIntent, ReadInJoyDailyFragment.class);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    a(paramContext, paramInt1, paramString, paramInt2, paramInt3, null);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Map<String, Object> paramMap)
  {
    a(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramMap, false);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Map<String, Object> paramMap, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
      localIntent.putExtra("channel_id", paramInt1);
      localIntent.putExtra("channel_name", paramString);
      localIntent.putExtra("channel_type", paramInt2);
      localIntent.putExtra("channel_from", paramInt3);
      localIntent.putExtra("is_channel_activity", true);
      if ((paramMap != null) && (!paramMap.isEmpty()))
      {
        paramString = new ReadInJoyChannelActivity.SerializableMap();
        paramString.setMap(paramMap);
        localIntent.putExtra("channel_map_data", paramString);
      }
      if (paramBoolean) {
        localIntent.addFlags(67108864);
      }
      paramContext.startActivity(localIntent);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130771993, 0);
      }
      return;
    }
    paramMap = new Intent();
    paramMap.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramMap.putExtra("channel_id", paramInt1);
    paramMap.putExtra("sub_channel_name", paramString);
    paramMap.putExtra("is_sub_channel", true);
    PublicFragmentActivity.start(paramContext, paramMap, ReadInJoyPicWaterFallFragment.class);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", 1);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo2.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo1.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    if (paramArticleInfo1 != paramArticleInfo2)
    {
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 2);
      if (ndi.aa(paramArticleInfo2)) {
        break label200;
      }
    }
    label200:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo2);
      localIntent.putExtra("is_need_show_animation_adapter", paramBoolean);
      paramContext.startActivity(localIntent);
      kct.cZ.put(ReadInJoyChannelActivity.class, kct.ic());
      mzj.a().g(false, "jumpFromKandianFeed", 1);
      return;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 1);
      break;
    }
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    int j = 0;
    if ((paramContext == null) || (paramHashMap == null)) {
      return;
    }
    String str2 = (String)paramHashMap.get("appSchema");
    String str1 = (String)paramHashMap.get("appPackageName");
    String str3 = (String)paramHashMap.get("isCancelJump");
    if ((str3 != null) && ("1".equals(str3))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = aqiz.isAppInstalled(paramContext, str1);
      str3 = (String)paramHashMap.get("defaultURL");
      paramHashMap = (String)paramHashMap.get("channelID");
      int i;
      if ((!TextUtils.isEmpty(paramHashMap)) && (TextUtils.isDigitsOnly(paramHashMap)))
      {
        i = Integer.valueOf(paramHashMap).intValue();
        label119:
        paramHashMap = new StringBuilder();
        if (!dt(str1)) {
          break;
        }
      }
      for (;;)
      {
        try
        {
          paramContext = (Context)new WeakReference(paramContext).get();
          if (paramContext == null) {
            break;
          }
          str3 = URLDecoder.decode(str3, "utf-8");
          str2 = N(str1, URLDecoder.decode(str2, "utf-8"));
          paramHashMap.append("appSchema:" + str2 + " appPackageName:" + str1 + " defaultUrl:" + str3);
          if (!bool2) {
            continue;
          }
          b(paramContext, str2, i, str3, bool1);
          paramHashMap.append("hasInstalled:" + bool2 + " configSwitch:" + 0);
        }
        catch (Exception paramContext)
        {
          paramHashMap.append(" startApp error:" + paramContext.toString());
          continue;
        }
        paramHashMap.append(" hasInstalled:" + bool2);
        QLog.e("ReadInJoyActivityHelper", 1, paramHashMap.toString());
        return;
        i = 0;
        break label119;
        if (!Achilles.p(str1, true))
        {
          kxm.aM(paramContext, str3);
          i = j;
          if (bool1) {
            i = 1;
          }
          kxm.n(str2, 2, i);
        }
      }
    }
  }
  
  public static void a(Context paramContext, List<Long> paramList, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIntent.putExtra("subscription_all_article_id", (Serializable)paramList);
      QLog.i("ReadInJoyActivityHelper", 1, paramList.toString());
    }
    if (paramLong != -1L) {
      localIntent.putExtra("subscription_click_article_id", paramLong);
    }
    if (paramInt == 1) {
      localIntent.putExtra("from_search", true);
    }
    for (;;)
    {
      localIntent.putExtra("launch_from", paramInt);
      if (!(paramContext instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      ((KandianMergeManager)BaseApplicationImpl.getApplication().getRuntime().getManager(162)).aIH();
      return;
      localIntent.putExtra("from_search", false);
    }
  }
  
  private static void a(@NonNull Intent paramIntent, @NonNull Bundle paramBundle)
  {
    paramBundle.putBoolean("daily_lock_screen_param", paramIntent.getBooleanExtra("daily_lock_screen_param", false));
    paramBundle.putBoolean("kan_dian_lock_screen_param", paramIntent.getBooleanExtra("kan_dian_lock_screen_param", false));
    paramBundle.putInt("daily_lock_screen_article_report_jump_type", paramIntent.getIntExtra("jumpType", 0));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    localIntent.putExtra("readinjoy_show_tab", 0);
    if (paramInt1 == 2) {
      localIntent.setFlags(131072);
    }
    if (paramInt2 != -1) {
      localIntent.putExtra("tab_tab_index", paramInt2);
    }
    if (awit.cC(paramQQAppInterface)) {}
    for (localIntent = new Intent(paramContext, ReadInJoySettingActivity.class);; localIntent = a(paramContext, paramInt1))
    {
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      paramContext.startActivity(localIntent);
      if ((paramInt2 == 0) && (!awit.Vs())) {
        ((KandianMergeManager)paramQQAppInterface.getManager(162)).aIH();
      }
      return;
      if (!awit.Vs()) {
        break;
      }
    }
    if (paramInt1 == 1) {
      localIntent.putExtra("from_search", true);
    }
    for (;;)
    {
      localIntent.putExtra("launch_from", paramInt1);
      mzj.a().g(true, "init", 1);
      break;
      if (paramInt1 == 9)
      {
        kxm.mO(true);
        localIntent.putExtra("from_lock_screen", true);
        kxs.aQ(localIntent);
        QLog.d(kgw.class.getSimpleName(), 2, "start kandian activity, launch from lock screen");
      }
      else
      {
        localIntent.putExtra("from_search", false);
      }
    }
  }
  
  public static Intent b(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent2 = new Intent(paramContext, SplashActivity.class);
    localIntent2.putExtra("fragment_id", 1);
    localIntent2.putExtra("launch_from", paramInt1);
    localIntent2.putExtra("tab_index", MainFragment.bIr);
    localIntent2.putExtra("open_kandian_tab_fragment", true);
    localIntent2.putExtra("arg_channel_cover_id", paramInt2);
    localIntent2.setFlags(335544320);
    Intent localIntent1;
    if (paramInt1 != 9)
    {
      localIntent1 = localIntent2;
      if (paramInt1 != 6) {}
    }
    else
    {
      kxm.mO(true);
      kxs.aQ(localIntent2);
      localIntent1 = ReadInJoyLockScreenJumpDelegate.c(paramContext, paramInt1, paramInt2);
    }
    return localIntent1;
  }
  
  public static Intent b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    paramContext = new Intent(paramContext, FastWebActivity.class);
    try
    {
      String str1 = (String)paramHashMap.get("channelID");
      String str2 = (String)paramHashMap.get("strategyId");
      String str3 = (String)paramHashMap.get("algorithmID");
      String str4 = (String)paramHashMap.get("title");
      String str5 = (String)paramHashMap.get("firstPagePicUrl");
      String str6 = (String)paramHashMap.get("articleContentUrl");
      String str7 = (String)paramHashMap.get("articleID");
      String str8 = (String)paramHashMap.get("subscribeID");
      String str9 = (String)paramHashMap.get("subscribeName");
      paramHashMap = (String)paramHashMap.get("rowKey");
      if (paramHashMap != null) {
        localArticleInfo.innerUniqueID = paramHashMap;
      }
      if (str6 != null) {
        localArticleInfo.mArticleContentUrl = URLDecoder.decode(str6, "utf-8");
      }
      if (str5 != null) {
        localArticleInfo.mFirstPagePicUrl = URLDecoder.decode(str5, "utf-8");
      }
      if (str1 != null) {
        localArticleInfo.mChannelID = Long.valueOf(str1).longValue();
      }
      if (str2 != null) {
        localArticleInfo.mStrategyId = Integer.valueOf(str2).intValue();
      }
      if (str3 != null) {
        localArticleInfo.mAlgorithmID = Long.valueOf(str3).longValue();
      }
      if (str4 != null) {
        localArticleInfo.mTitle = str4;
      }
      if (str7 != null) {
        localArticleInfo.mArticleID = Long.valueOf(str7).longValue();
      }
      if (str8 != null) {
        localArticleInfo.mSubscribeID = str8;
      }
      if (str9 != null) {
        localArticleInfo.mSubscribeName = str9;
      }
    }
    catch (Exception paramHashMap)
    {
      label278:
      break label278;
    }
    paramContext.putExtra("fast_web_article_info", localArticleInfo);
    return paramContext;
  }
  
  public static void b(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    b(paramContext, paramInt1, paramString, paramInt2, paramInt3, null);
  }
  
  public static void b(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Map<String, Object> paramMap)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyVideoSubChannelActivity.class);
    localIntent.putExtra("channel_id", paramInt1);
    localIntent.putExtra("channel_name", paramString);
    localIntent.putExtra("channel_type", paramInt2);
    localIntent.putExtra("channel_from", paramInt3);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramString = new ReadInJoyChannelActivity.SerializableMap();
      paramString.setMap(paramMap);
      localIntent.putExtra("channel_map_data", paramString);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void b(Context paramContext, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (BaseActivity.sTopActivity != null) {
      paramContext = BaseActivity.sTopActivity;
    }
    if (paramContext == null) {}
    while (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString1));
    localIntent.putExtra("big_brother_source_key", kxm.bg(paramInt));
    localIntent.putExtra("launch_app_time", System.currentTimeMillis());
    paramString1 = new kgx(new WeakReference(paramContext), paramBoolean, paramString2, paramString1);
    aII = adxf.a().a(paramString1);
    localIntent.putExtra("key_callback_id", aII);
    paramContext.startActivity(localIntent);
  }
  
  public static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if ((paramContext == null) || (paramHashMap == null)) {
      return;
    }
    if ("1".equals(paramHashMap.get("isEmptyVideo"))) {
      a((Activity)paramContext, paramHashMap);
    }
    String str4 = (String)paramHashMap.get("rowKey");
    String str5 = (String)paramHashMap.get("videoType");
    String str6 = (String)paramHashMap.get("videoVid");
    String str7 = (String)paramHashMap.get("videoWidth");
    String str8 = (String)paramHashMap.get("videoHeight");
    String str9 = (String)paramHashMap.get("videoDuration");
    String str10 = (String)paramHashMap.get("title");
    String str2 = (String)paramHashMap.get("firstPagePicUrl");
    String str3 = (String)paramHashMap.get("articleContentUrl");
    String str11 = (String)paramHashMap.get("subscribeID");
    String str12 = (String)paramHashMap.get("subscribeName");
    String str13 = (String)paramHashMap.get("sourceFrom");
    Object localObject = (String)paramHashMap.get("commentId");
    String str18 = (String)paramHashMap.get("subCommentId");
    String str19 = (String)paramHashMap.get("isAwesome");
    String str20 = (String)paramHashMap.get("jumpCommentType");
    String str14 = (String)paramHashMap.get("strategyId");
    String str15 = (String)paramHashMap.get("algorithmID");
    String str16 = (String)paramHashMap.get("channelID");
    if (paramHashMap.containsKey("percentage")) {}
    for (String str1 = (String)paramHashMap.get("percentage");; str1 = null)
    {
      String str17 = (String)paramHashMap.get("columnId");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        AnchorData localAnchorData = new AnchorData();
        localAnchorData.acb = ((String)localObject);
        localAnchorData.acd = str18;
        localAnchorData.ahJ = "1".equals(str19);
        localAnchorData.ahK = "0".equals(str20);
        paramHashMap = new Bundle();
        paramHashMap.putBoolean("VIDEO_SHOW_COMMENT", true);
        paramHashMap.putParcelable("VIDEO_COMMENT_ANCHOR", localAnchorData);
      }
      for (;;)
      {
        localObject = paramHashMap;
        if (paramHashMap == null) {
          localObject = new Bundle();
        }
        if (str3 != null) {}
        for (;;)
        {
          try
          {
            paramHashMap = URLDecoder.decode(str3, "utf-8");
            if (str2 == null) {
              break label687;
            }
            str2 = URLDecoder.decode(str2, "utf-8");
            int j = 0;
            int k = 0;
            if (!TextUtils.isEmpty(str5)) {
              j = Integer.parseInt(str5);
            }
            if (!TextUtils.isEmpty(str7)) {
              k = Integer.parseInt(str7);
            }
            if (TextUtils.isEmpty(str8)) {
              break label681;
            }
            m = Integer.parseInt(str8);
            if (TextUtils.isEmpty(str9)) {
              break label675;
            }
            n = Integer.parseInt(str9);
            if (TextUtils.isEmpty(str13)) {
              break label670;
            }
            if ("nativeArticleRecommend".equalsIgnoreCase(str13))
            {
              i = 10;
              if (!TextUtils.isEmpty(str14)) {
                ((Bundle)localObject).putInt("VIDEO_STRATEGY_ID", Integer.parseInt(str14));
              }
              if (!TextUtils.isEmpty(str15)) {
                ((Bundle)localObject).putLong("VIDEO_ALGORITHM_ID", Long.parseLong(str15));
              }
              if (!TextUtils.isEmpty(str16)) {
                ((Bundle)localObject).putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", Integer.parseInt(str16));
              }
              if (!TextUtils.isEmpty(str1)) {
                ((Bundle)localObject).putLong("VIDEO_PLAY_POSITION", Long.parseLong(str1));
              }
              if (!TextUtils.isEmpty(str17)) {
                ((Bundle)localObject).putInt("VIDEO_COLUMN_ID", Integer.parseInt(str17));
              }
              muj.a((Activity)paramContext, (Bundle)localObject, i, str4, j, str6, k, m, n, str10, str2, paramHashMap, str12, str11, 0L, false, 0L, 0, null, null, null, null, null);
              return;
            }
          }
          catch (Exception paramContext)
          {
            QLog.e("ReadInJoyActivityHelper", 1, "openFullVideoPlayerror ", paramContext);
            return;
          }
          int i = Integer.parseInt(str13);
          continue;
          label670:
          i = -1;
          continue;
          label675:
          int n = 0;
          continue;
          label681:
          int m = 0;
          continue;
          label687:
          continue;
          paramHashMap = str3;
        }
        paramHashMap = null;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramContext, paramInt1, paramInt2, null);
  }
  
  public static void bM(Context paramContext)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", Zh);
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    ((Intent)localObject).putExtra("hide_more_button", true);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static int c(@NonNull Intent paramIntent)
  {
    int i = 0;
    if (paramIntent.getBooleanExtra("daily_lock_screen_param", false)) {
      i = kys.getChannelId();
    }
    return i;
  }
  
  public static Intent c(Context paramContext, int paramInt)
  {
    if ((paramInt == 9) || (paramInt == 6)) {
      return ReadInJoyLockScreenJumpDelegate.c(paramContext, paramInt, 0);
    }
    return new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
  }
  
  public static Intent c(Context paramContext, HashMap<String, String> paramHashMap)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    Intent localIntent = new Intent(paramContext, FastWebActivity.class);
    try
    {
      Object localObject = (String)paramHashMap.get("strategyId");
      String str1 = (String)paramHashMap.get("algorithmID");
      String str2 = (String)paramHashMap.get("url");
      String str3 = (String)paramHashMap.get("rowkey");
      paramContext = (String)paramHashMap.get("fromType");
      paramContext = (String)paramHashMap.get("commenId");
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = (String)paramHashMap.get("commentId");
        String str4 = (String)paramHashMap.get("subCommentId");
        String str5 = (String)paramHashMap.get("jumpCommentType");
        paramHashMap = (String)paramHashMap.get("isAwesome");
        if (str3 != null) {
          localArticleInfo.innerUniqueID = str3;
        }
        if (str2 != null) {
          localArticleInfo.mArticleContentUrl = new String(aqgo.decode(str2, 0));
        }
        if (localObject != null) {
          localArticleInfo.mStrategyId = Integer.valueOf((String)localObject).intValue();
        }
        if (str1 != null) {
          localArticleInfo.mAlgorithmID = Long.valueOf(str1).longValue();
        }
        localObject = new AnchorData();
        ((AnchorData)localObject).acb = paramContext;
        ((AnchorData)localObject).acd = str4;
        ((AnchorData)localObject).ahK = "0".equals(str5);
        ((AnchorData)localObject).ahJ = "1".equals(paramHashMap);
        localIntent.putExtra("intent_key_anchor_data", (Parcelable)localObject);
        localIntent.putExtra("fast_web_article_info", localArticleInfo);
        return localIntent;
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public static void c(@NonNull Activity paramActivity, @NonNull Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("pushRowKey");
    if (TextUtils.isEmpty(str))
    {
      QLog.d("ReadInJoyActivityHelper", 1, "lockScreenJumpFloatingWindow: open native article detail rowKey is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("floating_window_rowkey", paramIntent.getStringExtra("pushRowKey"));
    localBundle.putString("float_layer_topic_id", paramIntent.getStringExtra("topicId"));
    localBundle.putString("float_layer_article_url", paramIntent.getStringExtra("articleUrl"));
    a(paramIntent, localBundle);
    localBundle.putInt("RETURN_SCENE", paramIntent.getIntExtra("return_scene", 0));
    localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", c(paramIntent));
    if ((paramInt != 1) || (awix.J(localBundle))) {
      kvs.oT(32);
    }
    awix.a(paramActivity, 3, paramInt, localBundle, c(paramIntent));
    QLog.d("ReadInJoyActivityHelper", 1, "jumpFloatingWindow: rowKey:" + str);
  }
  
  public static void c(Context paramContext, HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramHashMap == null)
    {
      QLog.d("ReadInJoyActivityHelper", 1, new Object[] { "openDailyDynamicChildFeeds log=", localStringBuilder.toString() });
      return;
    }
    label244:
    for (;;)
    {
      try
      {
        String str1 = (String)paramHashMap.get("channelID");
        String str2 = (String)paramHashMap.get("channelName");
        if (paramContext != null) {
          break label244;
        }
        paramContext = BaseActivity.sTopActivity;
        if ((paramContext == null) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
          break;
        }
        Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
        localIntent.putExtra("channel_id", Integer.valueOf(str1));
        localIntent.putExtra("channel_name", str2);
        localIntent.putExtra("channel_map_data", paramHashMap);
        localIntent.putExtra("is_daily_dynamic_child_channel", true);
        paramContext.startActivity(localIntent);
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2130771993, 0);
        }
        paramContext = (String)paramHashMap.get("requestData");
        if (!TextUtils.isEmpty(paramContext)) {
          awit.H("DAILY_CHILD_FEEDS_REQUEST_CONFIG" + str1, paramContext);
        }
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
        localStringBuilder.append(paramContext);
      }
      catch (Exception paramContext)
      {
        localStringBuilder.append(paramContext.toString());
      }
      break;
    }
  }
  
  public static boolean dt(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if ((!"com.tencent.reading".equalsIgnoreCase(paramString)) && (!"com.tencent.rijvideo".equalsIgnoreCase(paramString)))
      {
        bool1 = bool2;
        if (!"com.tencent.weishi".equalsIgnoreCase(paramString)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  public static void f(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +173 -> 182
    //   12: new 884	org/json/JSONObject
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 887	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: ldc_w 889
    //   23: iconst_m1
    //   24: invokevirtual 892	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   27: i2l
    //   28: lstore_3
    //   29: new 226	java/util/HashMap
    //   32: dup
    //   33: invokespecial 893	java/util/HashMap:<init>	()V
    //   36: astore 5
    //   38: lload_3
    //   39: ldc2_w 501
    //   42: lcmp
    //   43: ifeq +18 -> 61
    //   46: aload 5
    //   48: ldc_w 612
    //   51: lload_3
    //   52: invokestatic 896	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   55: invokeinterface 897 3 0
    //   60: pop
    //   61: aload 5
    //   63: ldc_w 899
    //   66: aload_1
    //   67: invokeinterface 897 3 0
    //   72: pop
    //   73: ldc 2
    //   75: invokevirtual 581	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   78: iconst_1
    //   79: new 58	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 901
    //   89: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: lload_3
    //   93: invokevirtual 904	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   96: ldc_w 906
    //   99: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 586	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload 5
    //   114: astore_1
    //   115: aconst_null
    //   116: ldc 52
    //   118: ldc 54
    //   120: ldc 54
    //   122: ldc_w 908
    //   125: ldc_w 908
    //   128: iconst_0
    //   129: iconst_0
    //   130: ldc 54
    //   132: iload_2
    //   133: invokestatic 910	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   136: ldc 54
    //   138: invokestatic 75	com/tencent/biz/pubaccount/readinjoy/activity/ReadInJoyBaseDeliverActivity:ig	()Ljava/lang/String;
    //   141: iconst_0
    //   142: invokestatic 81	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   145: aload_0
    //   146: ldc_w 911
    //   149: ldc 54
    //   151: iconst_0
    //   152: iload_2
    //   153: aload_1
    //   154: invokestatic 294	kgw:a	(Landroid/content/Context;ILjava/lang/String;IILjava/util/Map;)V
    //   157: return
    //   158: astore 5
    //   160: aconst_null
    //   161: astore_1
    //   162: aload 5
    //   164: invokevirtual 912	org/json/JSONException:printStackTrace	()V
    //   167: goto -52 -> 115
    //   170: astore 6
    //   172: aload 5
    //   174: astore_1
    //   175: aload 6
    //   177: astore 5
    //   179: goto -17 -> 162
    //   182: aconst_null
    //   183: astore_1
    //   184: goto -69 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramContext	Context
    //   0	187	1	paramString	String
    //   0	187	2	paramInt	int
    //   28	65	3	l	long
    //   36	77	5	localHashMap	HashMap
    //   158	15	5	localJSONException1	org.json.JSONException
    //   177	1	5	localObject	Object
    //   170	6	6	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   12	38	158	org/json/JSONException
    //   46	61	170	org/json/JSONException
    //   61	112	170	org/json/JSONException
  }
  
  public static void m(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("pushRowKey");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("VIDEO_FEEDS_ANIM_ENABLE", false);
    localBundle.putInt("RETURN_SCENE", paramIntent.getIntExtra("return_scene", 0));
    localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", c(paramIntent));
    muj.a(paramActivity, localBundle, paramIntent.getStringExtra("pushRowKey"), 27);
    QLog.d("ReadInJoyActivityHelper", 1, "lockScreenJumpVideoFeedsPlayActivity: rowKey:" + str);
  }
  
  public static void n(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("pushRowKey");
    if (TextUtils.isEmpty(str1))
    {
      QLog.d("ReadInJoyActivityHelper", 1, "jumpFastWebActivity: open native article detail rowKey is null");
      return;
    }
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent(paramActivity, FastWebActivity.class);
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.innerUniqueID = str1;
    localArticleInfo.mChannelID = c(paramIntent);
    String str2 = paramIntent.getStringExtra("articleUrl");
    if (!TextUtils.isEmpty(str2)) {
      localArticleInfo.mArticleContentUrl = str2;
    }
    localIntent.putExtra("fast_web_article_info", localArticleInfo);
    a(paramIntent, localBundle);
    localIntent.putExtras(localBundle);
    paramActivity.startActivity(localIntent);
    QLog.d("ReadInJoyActivityHelper", 1, "lockScreenJumpFastWebActivity: rowKey:" + str1 + " articleUrl: " + str2);
  }
  
  public static void p(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent;
    if (paramBoolean)
    {
      localIntent = new Intent(paramContext, ReadInJoyMessagesActivity.class);
      localIntent.putExtra("shouldBackSelfAct", true);
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
      localIntent = new Intent(paramContext, ReadInJoySelfActivity.class);
    }
  }
  
  public static void q(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoySelfActivity.class);
    localIntent.putExtra("redTouch", paramBoolean);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgw
 * JD-Core Version:    0.7.0.1
 */