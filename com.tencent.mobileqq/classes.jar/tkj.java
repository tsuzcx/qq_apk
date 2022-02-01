import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusBookData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.4;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.5;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class tkj
{
  private static Map<String, tkk> jdField_a_of_type_JavaUtilMap = new HashMap();
  public static final float[] a;
  public static final int[] a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static final String[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "article_", "interactive_", "recommend_", "comment_" };
    b = new String[] { "_area_body", "_area_interactive", "_area_recommend", "_area_comment" };
    jdField_a_of_type_ArrayOfFloat = new float[] { 4.0F, 4.1F, 8.0F, 2.147484E+009F };
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (paramInt2 == 1) {
        return 1;
      }
      return 0;
    }
    if (paramInt1 == 70)
    {
      if (paramInt2 == 1) {
        return 2;
      }
      return 3;
    }
    return 0;
  }
  
  private static int a(long paramLong)
  {
    switch ((int)paramLong)
    {
    default: 
      return 8;
    case 0: 
      return 1;
    case 56: 
      return 2;
    }
    return 3;
  }
  
  public static long a(boolean paramBoolean, long paramLong)
  {
    long l;
    if (!paramBoolean)
    {
      l = paramLong;
      if (paramLong >= 0L) {}
    }
    else
    {
      l = -1024L;
    }
    return l;
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b.length)) {
      return paramArticleInfo.innerUniqueID + b[paramInt];
    }
    a(paramArticleInfo);
    return paramArticleInfo.innerUniqueID;
  }
  
  public static JSONObject a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("card_info");
        localJSONObject.put("source", a(paramArticleInfo.mChannelID));
        localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localJSONObject.put("rowkey", paramJSONObject.optString("rowKey"));
        localJSONObject.put("rec_articleid", paramJSONObject.optString("articleID"));
        localJSONObject.put("rec_puin", paramJSONObject.optString("subscribeID"));
        localJSONObject.put("mp_article_id", "" + paramArticleInfo.mArticleID);
        localJSONObject.put("kandian_mode", "" + pqu.a());
        if (NetworkState.isWifiConn())
        {
          i = 1;
          localJSONObject.put("network_type", i);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "8.4.10".replace(".", ""));
          localJSONObject.put("imei", pkh.b());
          localJSONObject.put("imsi", pkh.c());
          localJSONObject.put("rcmInfo", paramJSONObject.optString("rcmInfo"));
          localJSONObject.put("content_type", paramJSONObject.optString("type"));
          localJSONObject.put("net_type", HttpUtil.getNetWorkType() + "");
          paramArticleInfo = paramJSONObject.optJSONObject("reportInfo").getJSONObject("info");
          if (paramArticleInfo != null)
          {
            paramJSONObject = paramArticleInfo.keys();
            if (paramJSONObject.hasNext())
            {
              String str = (String)paramJSONObject.next();
              localJSONObject.put(str, paramArticleInfo.getString(str));
              continue;
            }
          }
          return localJSONObject;
        }
      }
      catch (Exception paramArticleInfo) {}
      int i = 2;
    }
  }
  
  public static JSONObject a(TemplateBean paramTemplateBean, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramTemplateBean = new JSONObject(String.valueOf(paramTemplateBean.findViewById(paramString).getDynamicValue("setProteusReportInfo:"))).getJSONObject("info");
      return paramTemplateBean;
    }
    catch (Exception paramTemplateBean) {}
    return localJSONObject;
  }
  
  public static pqg a(ArticleInfo paramArticleInfo)
  {
    pqg localpqg = new pqg();
    localpqg.b("folder_status", prp.a);
    localpqg.b("feeds_source", paramArticleInfo.mSubscribeID);
    localpqg.b("feeds_type", paramArticleInfo.mFeedType);
    localpqg.b("kandian_mode", pqu.a());
    localpqg.b("tab_source", pqf.a());
    localpqg.b("rowkey", paramArticleInfo.innerUniqueID);
    localpqg.a("channel_id", paramArticleInfo.mChannelID);
    return localpqg;
  }
  
  public static pqg a(ArticleInfo paramArticleInfo, boolean paramBoolean, long paramLong, int paramInt)
  {
    pqg localpqg = pqf.a();
    localpqg.b("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
    localpqg.b("strategy_id", "" + paramArticleInfo.mStrategyId);
    if (paramBoolean) {}
    for (String str = "2";; str = "1")
    {
      localpqg.b("feeds_channel_entrance", str);
      localpqg.b("mp_article_id", "" + paramArticleInfo.mArticleID);
      localpqg.b("rowkey", paramArticleInfo.innerUniqueID);
      localpqg.b("channel_id", "" + a(paramBoolean, paramLong));
      if (paramInt != -1) {
        localpqg.b("source_extratype", paramInt);
      }
      return localpqg;
    }
  }
  
  private static tkk a(String paramString)
  {
    tkk localtkk2 = (tkk)jdField_a_of_type_JavaUtilMap.get(paramString);
    tkk localtkk1 = localtkk2;
    if (localtkk2 == null)
    {
      localtkk1 = new tkk(pkn.a(paramString));
      jdField_a_of_type_JavaUtilMap.put(paramString, localtkk1);
    }
    return localtkk1;
  }
  
  public static void a(long paramLong, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, Context paramContext)
  {
    if ((paramArticleInfo == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReportUtil.5(paramContext, paramArticleInfo, paramFastWebArticleInfo, paramLong));
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramAppInterface, paramArticleInfo, paramInt1, paramInt2, paramBoolean, false);
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramAppInterface, paramArticleInfo, paramInt1, paramInt2, paramBoolean1, paramBoolean2, null);
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, JSONObject paramJSONObject)
  {
    if ((paramArticleInfo == null) || (paramAppInterface == null)) {
      return;
    }
    int i = a((int)paramArticleInfo.mChannelID, paramArticleInfo.mFeedType);
    paramContext = pih.a(paramContext, paramAppInterface.getCurrentAccountUin(), i, paramArticleInfo.mArticleID, paramArticleInfo.innerUniqueID, paramInt1, paramInt2, paramBoolean1, null);
    if (paramBoolean2) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        paramContext.put("is_redpack", paramInt1);
        pjc.a(paramContext, paramJSONObject);
        olh.a(null, "", "0X8009544", "0X8009544", 0, 0, "", String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mAlgorithmID), paramContext.toString(), false);
        return;
        paramInt1 = 0;
      }
    }
    catch (JSONException paramAppInterface)
    {
      for (;;)
      {
        QLog.e("ReportUtil", 1, paramAppInterface.toString());
      }
    }
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramArticleInfo == null) || (paramAppInterface == null)) {
      return;
    }
    int i = a((int)paramArticleInfo.mChannelID, paramArticleInfo.mFeedType);
    paramContext = pih.a(paramContext, paramAppInterface.getCurrentAccountUin(), i, paramArticleInfo.mArticleID, paramArticleInfo.innerUniqueID, paramInt1, paramInt2, paramBoolean1, Boolean.valueOf(paramBoolean2));
    if (paramBoolean3) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        paramContext.put("is_redpack", paramInt1);
        olh.a(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mAlgorithmID), paramContext.toString(), false);
        uva.a.a(paramBoolean2);
        return;
        paramInt1 = 0;
      }
    }
    catch (JSONException paramAppInterface)
    {
      for (;;)
      {
        QLog.e("ReportUtil", 1, paramAppInterface.toString());
      }
    }
  }
  
  public static void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (paramVideoInfo == null) {
      return;
    }
    paramVideoInfo = new suu(paramVideoInfo).i(paramVideoInfo.g).n(3);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      olh.a(null, null, "0X800A731", "0X800A731", 0, 0, "", "", "", paramVideoInfo.o(i).a().a(), false);
      return;
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("PAGE_AREA_KEY_POSTFIXES", Arrays.toString(b));
      localJSONObject.put("PAGE_AREA_INDICES", Arrays.toString(jdField_a_of_type_ArrayOfInt));
      if (paramArticleInfo != null)
      {
        localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
        localJSONObject.put("title", paramArticleInfo.mTitle);
      }
      olh.a(null, "CliOper", "", "", "0X800B554", "0X800B554", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramArticleInfo)
    {
      QLog.e("ReportUtil", 1, "monitorIndexError error, e = ", paramArticleInfo);
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, pqg parampqg)
  {
    int j = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    int i = Utils.px2dp(paramInt1);
    j = Utils.px2dp(j);
    parampqg.b("read_area", "" + j * i);
    parampqg.b("article_page", "" + Utils.px2dp(paramInt2));
    parampqg.b("read_page", "" + Utils.px2dp(paramInt1));
    olh.a(null, "CliOper", "", "", "0X8009782", "0X8009782", 0, 0, "" + paramArticleInfo.mArticleID, "", "", parampqg.a(), false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    pqg localpqg = a(paramArticleInfo, paramBoolean, paramLong, paramInt3);
    a(paramArticleInfo, paramInt2, localpqg);
    a(paramArticleInfo, localpqg);
    a(paramArticleInfo, paramInt1, paramInt2, localpqg);
    b(paramArticleInfo, localpqg);
    c(paramArticleInfo, a(paramArticleInfo, paramBoolean, paramLong, paramInt3));
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt, pqg parampqg)
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("body_show_time");
    long l3 = pkn.b(a(paramArticleInfo, 0));
    localAttributeList.att_value.set(String.valueOf(l3));
    localArrayList.add(localAttributeList);
    Object localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("body_height");
    paramInt = Utils.px2dp(paramInt);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(paramInt));
    localArrayList.add(localObject1);
    Object localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(3);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("scroll_time");
    paramArticleInfo = a(paramArticleInfo.innerUniqueID);
    long l1;
    if (!paramArticleInfo.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject3 = paramArticleInfo.jdField_b_of_type_JavaUtilList.iterator();
      for (l1 = 0L;; l1 = ((Long)((Pair)((Iterator)localObject3).next()).first).longValue() + l1)
      {
        l2 = l1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
      }
    }
    long l2 = 0L;
    ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(String.valueOf(l2));
    localArrayList.add(localObject2);
    Object localObject3 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(4);
    ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("scroll_list");
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramArticleInfo.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramArticleInfo = paramArticleInfo.jdField_b_of_type_JavaUtilList.iterator();
      while (paramArticleInfo.hasNext())
      {
        Pair localPair = (Pair)paramArticleInfo.next();
        l1 = Utils.px2dp((float)((Long)localPair.second).longValue());
        localStringBuilder.append(((Long)localPair.first).longValue() / 100L).append("_").append(l1).append(";");
      }
    }
    ((oidb_cmd0x80a.AttributeList)localObject3).att_value.set(localStringBuilder.toString());
    localArrayList.add(localObject3);
    if (QLog.isColorLevel())
    {
      if (localAttributeList.att_value.get() == null) {
        break label666;
      }
      paramArticleInfo = localAttributeList.att_value.get();
    }
    for (;;)
    {
      if (((oidb_cmd0x80a.AttributeList)localObject1).att_value.get() != null)
      {
        localObject1 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value.get();
        label461:
        if (((oidb_cmd0x80a.AttributeList)localObject2).att_value.get() == null) {
          break label681;
        }
        localObject2 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value.get();
        label482:
        if (((oidb_cmd0x80a.AttributeList)localObject3).att_value.get() == null) {
          break label689;
        }
        localObject3 = ((oidb_cmd0x80a.AttributeList)localObject3).att_value.get();
        QLog.d("Q.readinjoy.fast_web", 2, new Object[] { "reportRealTime, body_show_time = ", paramArticleInfo, " ms", ", body_height = ", localObject1, " dp", ", scroll_time = ", localObject2, " ms", ", scroll_list = ", localObject3 });
        uuc.a(201, localArrayList);
      }
      try
      {
        parampqg.a("body_show_time", String.valueOf(l3));
        parampqg.a("body_height", String.valueOf(paramInt));
        parampqg.a("scroll_time", String.valueOf(l2));
        parampqg.a("scroll_list", localStringBuilder.toString());
        olh.a(null, "", "0X800A467", "0X800A467", 0, 0, "", "", "", parampqg.a(), false);
        return;
        label666:
        paramArticleInfo = "null";
        continue;
        localObject1 = "null";
        break label461;
        label681:
        localObject2 = "null";
        break label482;
        label689:
        localObject3 = "null";
      }
      catch (JSONException paramArticleInfo)
      {
        for (;;)
        {
          QLog.e("Q.readinjoy.fast_web", 1, "reportRealTime, e = ", paramArticleInfo);
        }
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, long paramLong1, long paramLong2, pqg parampqg)
  {
    if (paramArticleInfo == null) {
      return;
    }
    parampqg.b("read_duration", "" + paramLong1 / 1000L);
    parampqg.b("read_begin_timestamp", "" + paramLong2 / 1000L);
    parampqg.b("read_end_timestamp", "" + NetConnInfoCenter.getServerTime());
    olh.a(null, "CliOper", "", "" + paramArticleInfo.mSubscribeID, "0X8009781", "0X8009781", 0, 0, "" + paramArticleInfo.mArticleID, "", "", parampqg.a(), false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, BaseData paramBaseData)
  {
    switch (paramBaseData.r)
    {
    default: 
      return;
    }
    try
    {
      paramBaseData = (ProteusRecommendItemData)paramBaseData;
      JSONObject localJSONObject = a(paramArticleInfo, paramBaseData.c);
      String str = paramBaseData.c.optJSONObject("card_info").optJSONObject("reportInfo").getString("article_exposure_T");
      localJSONObject.put("rec_location", "" + paramBaseData.a);
      localJSONObject.put("rec_total", "" + paramBaseData.jdField_b_of_type_Int);
      localJSONObject.put("ad", "0");
      a(paramArticleInfo, str, localJSONObject.toString());
      return;
    }
    catch (Exception paramArticleInfo) {}
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, Context paramContext)
  {
    if ((paramArticleInfo == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReportUtil.4(paramContext, paramArticleInfo, paramFastWebArticleInfo));
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    olh.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, paramString1, paramString1, 0, 0, paramArticleInfo.mArticleID + "", paramArticleInfo.mAlgorithmID + "", paramArticleInfo.innerUniqueID, paramString2, false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString, JSONObject paramJSONObject)
  {
    if ((paramArticleInfo == null) || (paramJSONObject == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    olh.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), paramArticleInfo.innerUniqueID, paramJSONObject.toString(), false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    int j = 0;
    int i = 0;
    if (paramList.hasNext())
    {
      Object localObject = (BaseData)paramList.next();
      if ((localObject instanceof ProteusItemData))
      {
        localObject = (ProteusItemData)localObject;
        if (((ProteusItemData)localObject).v != 1) {}
      }
      int k;
      switch (((ProteusItemData)localObject).u)
      {
      default: 
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = i + 1;
        i = j;
        j = k;
        continue;
        k = j + 1;
        j = i;
        i = k;
      }
    }
    paramList = new HashMap();
    paramList.put("rowkey", paramArticleInfo.innerUniqueID);
    paramList.put("url", paramArticleInfo.mArticleContentUrl);
    paramList.put("imgCount", "" + i);
    paramList.put("videoCount", "" + j);
    paramList.put("textCount", "-1");
    paramList.put("param_uin", pkh.a());
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebItemCount", true, 0L, 0L, paramList, null);
  }
  
  public static void a(ArticleInfo paramArticleInfo, pqg parampqg)
  {
    if (paramArticleInfo != null)
    {
      a(paramArticleInfo, pkn.b(paramArticleInfo.innerUniqueID), pkn.a(paramArticleInfo.innerUniqueID), parampqg);
      pkn.a(paramArticleInfo.innerUniqueID);
    }
  }
  
  public static void a(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    do
    {
      return;
      if (paramBaseData.r == 18) {
        a(paramBaseData, "0X800974A");
      }
    } while (!(paramBaseData instanceof ProteusItemData));
    paramBaseData = (ProteusItemData)paramBaseData;
    a(paramBaseData.c);
    b(paramBaseData.c);
  }
  
  public static void a(BaseData paramBaseData, String paramString)
  {
    if ((paramBaseData == null) || (paramBaseData.a == null) || (paramBaseData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {}
    while (!(paramBaseData instanceof ProteusBookData)) {
      return;
    }
    ProteusBookData localProteusBookData = (ProteusBookData)paramBaseData;
    FastWebArticleInfo localFastWebArticleInfo = paramBaseData.a;
    paramBaseData = paramBaseData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    pqg localpqg = new pqg();
    localpqg.b("card_source", localProteusBookData.c);
    localpqg.b("topic_id", localProteusBookData.d);
    localpqg.b("source_id", localProteusBookData.e);
    olh.a(null, "CliOper", "", "" + localFastWebArticleInfo.d, paramString, paramString, 0, 0, localFastWebArticleInfo.o + "", paramBaseData.mAlgorithmID + "", paramBaseData.innerUniqueID, localpqg.a(), false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if ((paramQQAppInterface != null) && (paramAdData != null))
    {
      if ((!(paramAdData instanceof ProteusInnerData)) || (!((ProteusInnerData)paramAdData).e())) {
        break label87;
      }
      uec.a(paramQQAppInterface.getApp().getApplicationContext(), ukt.a(paramAdData), 18, 2, 3);
    }
    for (;;)
    {
      QLog.d("Q.readinjoy.fast_web", 2, " doReportAdInvalidShow " + paramAdData.b + "  : " + paramAdData.c);
      return;
      label87:
      ois.a(paramQQAppInterface, paramAdData);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, float paramFloat, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramAdData == null)) {
      return;
    }
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).e())) {
      uec.a(ReportAction.EXPOSE, JumpMode.UNKNOWN, paramQQAppInterface.getApp().getApplicationContext(), ukt.a(paramAdData), 18, 2, 3, paramBoolean);
    }
    for (;;)
    {
      QLog.d("Q.readinjoy.fast_web", 2, " doReportAdShowExtra " + paramAdData.b + "  : " + paramAdData.c + " exposureArea = " + paramFloat + " exposureTime = " + paramLong);
      return;
      ois.a(paramQQAppInterface, paramAdData, paramFloat, paramLong, paramBoolean);
    }
  }
  
  public static void a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {}
    while (paramColorNote.getServiceType() != 16908290) {
      return;
    }
    if (paramColorNote.mSubType.startsWith(aqpb.a))
    {
      d(paramColorNote);
      return;
    }
    if (paramColorNote.mSubType.startsWith("viola:"))
    {
      e(paramColorNote);
      return;
    }
    f(paramColorNote);
  }
  
  public static void a(AbsListView paramAbsListView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramAbsListView = a(paramString);
    if (paramInt1 == 0)
    {
      paramAbsListView.b(paramInt2, paramBoolean);
      return;
    }
    paramAbsListView.a(paramInt2, paramBoolean);
  }
  
  private static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static void a(String paramString, ProteusRecommendItemData paramProteusRecommendItemData, JSONObject paramJSONObject)
  {
    if ((paramProteusRecommendItemData == null) || (paramProteusRecommendItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = paramProteusRecommendItemData.c;
        String str = localJSONObject.optJSONObject("card_info").optJSONObject("reportInfo").getString("click_T");
        if (!TextUtils.isEmpty(str))
        {
          localJSONObject = a(paramProteusRecommendItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localJSONObject);
          b(localJSONObject, paramJSONObject);
          localJSONObject.put("rec_location", "" + paramProteusRecommendItemData.a);
          localJSONObject.put("rec_total", "" + paramProteusRecommendItemData.jdField_b_of_type_Int);
          localJSONObject.put("ad", "0");
          localJSONObject.put("click_area", paramString);
          a(paramProteusRecommendItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, str, localJSONObject.toString());
          return;
        }
      }
      catch (Exception paramString) {}
    }
  }
  
  public static void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    int i = 0;
    if (paramJSONObject1 == null) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject1 = paramJSONObject1.optJSONObject("card_info");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("reportInfo");
        String str = localJSONObject2.getString("click_T");
        localJSONObject2 = new JSONObject(localJSONObject2.getString("info"));
        a(localJSONObject1, localJSONObject2);
        localJSONObject2.put("click_area", paramString);
        b(localJSONObject2, paramJSONObject2);
        if (pqt.c()) {
          i = 1;
        }
        localJSONObject2.put("ad_relative_pos", i);
        paramString = new pqg(localJSONObject2);
        paramString.e();
        olh.a(null, "", str, str, 0, 0, "", "", "", paramString.a(), false);
        boolean bool = "0X800983F".equals(str);
        if (!bool) {
          continue;
        }
        try
        {
          if (!paramJSONObject1.has("kdschSessionId")) {
            paramJSONObject1.put("kdschSessionId", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin() + System.currentTimeMillis());
          }
          bcjs.a(null, new ReportModelDC02528().module("all_search").action("clk_jingtan_list").obj1("2049").ver2("kandian").ver4(paramJSONObject2.getString("searchWord")).ver6(localJSONObject1.getString("articleRowKey")).ver7("{\"scroe\":\"" + paramJSONObject2.getString("score") + "\",\"title\":\"" + localJSONObject1.getString("articleTitle") + "\",\"position\":\"" + paramJSONObject2.getString("position") + "\"}").session_id(paramJSONObject1.getString("kdschSessionId")));
          return;
        }
        catch (Exception paramString) {}
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public static void a(List<ColorNote> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ColorNote localColorNote = (ColorNote)paramList.next();
        if (localColorNote.getServiceType() == 16908290) {
          a(localColorNote);
        }
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("card_info");
        Object localObject1 = localJSONObject.optJSONObject("reportInfo");
        String str = ((JSONObject)localObject1).getString("exposure_T");
        localObject1 = new JSONObject(((JSONObject)localObject1).getString("info"));
        if (TextUtils.isEmpty(str)) {
          break;
        }
        a(localJSONObject, (JSONObject)localObject1);
        if (!pqt.c()) {
          break label390;
        }
        i = 1;
        ((JSONObject)localObject1).put("ad_relative_pos", i);
        Object localObject2 = new pqg((JSONObject)localObject1);
        ((pqg)localObject2).e();
        olh.a(null, "", str, str, 0, 0, "", "", "", ((pqg)localObject2).a(), false);
        boolean bool = "0X8009857".equals(str);
        if (!bool) {
          break;
        }
        try
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("searchWords");
          i = 0;
          str = "";
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            if (TextUtils.isEmpty(str)) {
              str = str + ((JSONObject)localObject2).getString("searchWord");
            } else {
              str = str + "::" + ((JSONObject)localObject2).getString("searchWord");
            }
          }
          else
          {
            if (!paramJSONObject.has("kdschSessionId")) {
              paramJSONObject.put("kdschSessionId", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin() + System.currentTimeMillis());
            }
            bcjs.a(null, new ReportModelDC02528().module("all_search").action("exp_jingtan_list").obj1("2049").ver2("kandian").ver4(str).ver6(localJSONObject.getString("articleRowKey")).ver7("{\"title\":\"" + localJSONObject.getString("articleTitle") + "\"}").session_id(paramJSONObject.getString("kdschSessionId")));
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          return;
        }
        i += 1;
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      continue;
      label390:
      int i = 0;
    }
  }
  
  public static void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    try
    {
      paramJSONObject2.put("articleRowKey", paramJSONObject1.optString("articleRowKey"));
      paramJSONObject2.put("channel_id", paramJSONObject1.get("channelID"));
      paramJSONObject2.put("articleTitle", paramJSONObject1.get("articleTitle"));
      return;
    }
    catch (Exception paramJSONObject1) {}
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    switch (paramBaseData.r)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static void b(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramAppInterface, paramArticleInfo, paramInt1, paramInt2, paramBoolean1, paramBoolean2, false);
  }
  
  public static void b(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if (paramArticleInfo == null) {
      return;
    }
    str = "";
    for (;;)
    {
      try
      {
        pqg localpqg = a(paramArticleInfo);
        localpqg.b("source_from", paramString2);
        if (!pqt.b()) {
          continue;
        }
        i = 1;
        localpqg.b("artical_interact_area", i);
        localpqg.b("artical_interact_type", pqt.d());
        paramString2 = localpqg.a();
      }
      catch (Exception paramString2)
      {
        int i;
        paramString2.printStackTrace();
        paramString2 = str;
        continue;
      }
      olh.a(null, paramArticleInfo.mSubscribeID, paramString1, paramString1, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "", paramString2, false);
      return;
      i = 0;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, pqg parampqg)
  {
    tkk localtkk = a(paramArticleInfo.innerUniqueID);
    if (localtkk.a.isEmpty()) {
      return;
    }
    parampqg.i();
    parampqg.b("read_begin_timestamp", "" + localtkk.jdField_b_of_type_Long / 1000L);
    parampqg.b("read_end_timestamp", "" + localtkk.c / 1000L);
    String str1 = "";
    Iterator localIterator = localtkk.a.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      String str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        str2 = str1 + ",";
      }
      l += Math.abs(((Long)localPair.first).longValue());
      str1 = str2 + localPair.first + "_" + localPair.second;
    }
    parampqg.b("read_speed_array", str1);
    parampqg.b("avg_speed", "" + l / localtkk.a.size());
    olh.a(null, "CliOper", "", "", "0X8009783", "0X8009783", 0, 0, "" + paramArticleInfo.mArticleID, "", "", parampqg.a(), false);
    a(paramArticleInfo.innerUniqueID);
  }
  
  public static void b(ColorNote paramColorNote)
  {
    paramColorNote = tty.b(paramColorNote);
    if ((paramColorNote == null) || (paramColorNote.length() == 0)) {
      return;
    }
    olh.a(null, null, "0X800A731", "0X800A731", 0, 0, "", "", "", new suu(paramColorNote.toString()).a().a(), false);
  }
  
  public static void b(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("card_info");
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optJSONObject("reportInfo").getString("info"));
      a(paramJSONObject, localJSONObject);
      if (pqt.c()) {
        i = 1;
      }
      localJSONObject.put("ad_relative_pos", i);
      paramJSONObject = new pqg(localJSONObject);
      paramJSONObject.e();
      olh.a(null, "", "0X8009A7D", "0X8009A7D", 0, 0, "", "", "", paramJSONObject.a(), false);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public static void b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = paramJSONObject2.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramJSONObject1.put(str, paramJSONObject2.getString(str));
        }
        return;
      }
      catch (Exception paramJSONObject1) {}
    }
  }
  
  private static void c(ArticleInfo paramArticleInfo, pqg parampqg)
  {
    int i = 0;
    try
    {
      parampqg.b().e();
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      int j = arrayOfInt.length;
      while (i < j)
      {
        Integer localInteger = Integer.valueOf(arrayOfInt[i]);
        String str = a(paramArticleInfo, localInteger.intValue());
        long l = pkn.b(str);
        parampqg.a(jdField_a_of_type_ArrayOfJavaLangString[localInteger.intValue()] + "_duration_millis", l);
        pkn.a(str);
        i += 1;
      }
      olh.a(null, "CliOper", "", "" + paramArticleInfo.mSubscribeID, "0X80099D2", "0X80099D2", 0, 0, "", "" + paramArticleInfo.mArticleID, "", parampqg.a(), false);
      return;
    }
    catch (Exception paramArticleInfo)
    {
      QLog.e("ReportUtil", 1, "reportPageAreaExposure error, e = ", paramArticleInfo);
    }
  }
  
  public static void c(ColorNote paramColorNote) {}
  
  private static void d(ColorNote paramColorNote)
  {
    byte[] arrayOfByte = paramColorNote.getReserve();
    if (arrayOfByte == null) {
      return;
    }
    long l = paramColorNote.mTime;
    ThreadManager.getSubThreadHandler().post(new ReportUtil.1(arrayOfByte, l));
  }
  
  private static void e(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (paramColorNote.getReserve() == null)) {
      return;
    }
    long l = paramColorNote.mTime;
    ThreadManager.getSubThreadHandler().post(new ReportUtil.2(paramColorNote, l));
  }
  
  private static void f(ColorNote paramColorNote)
  {
    byte[] arrayOfByte = paramColorNote.getReserve();
    if (arrayOfByte == null) {
      return;
    }
    long l = paramColorNote.mTime;
    ThreadManager.getSubThreadHandler().post(new ReportUtil.3(arrayOfByte, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tkj
 * JD-Core Version:    0.7.0.1
 */