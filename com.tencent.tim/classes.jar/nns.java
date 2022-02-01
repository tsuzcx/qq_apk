import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class nns
{
  public static final float[] as = { 4.0F, 4.1F, 8.0F, 2.147484E+009F };
  private static final String[] bF;
  private static final String[] bG;
  public static final int[] dz = { 0, 1, 2, 3 };
  private static Map<String, nns.a> eJ = new HashMap();
  
  static
  {
    bF = new String[] { "article_", "interactive_", "recommend_", "comment_" };
    bG = new String[] { "_area_body", "_area_interactive", "_area_recommend", "_area_comment" };
  }
  
  private static int C(long paramLong)
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
  
  public static int W(int paramInt1, int paramInt2)
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
  
  public static kxm.b a(ArticleInfo paramArticleInfo, boolean paramBoolean, long paramLong, int paramInt)
  {
    kxm.b localb = kxm.a();
    localb.b("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
    localb.b("strategy_id", "" + paramArticleInfo.mStrategyId);
    if (paramBoolean) {}
    for (String str = "2";; str = "1")
    {
      localb.b("feeds_channel_entrance", str);
      localb.b("mp_article_id", "" + paramArticleInfo.mArticleID);
      localb.b("rowkey", paramArticleInfo.innerUniqueID);
      localb.b("channel_id", "" + a(paramBoolean, paramLong));
      if (paramInt != -1) {
        localb.b("source_extratype", paramInt);
      }
      return localb;
    }
  }
  
  private static nns.a a(String paramString)
  {
    nns.a locala2 = (nns.a)eJ.get(paramString);
    nns.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new nns.a(kxy.E(paramString));
      eJ.put(paramString, locala1);
    }
    return locala1;
  }
  
  public static JSONObject a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("card_info");
        localJSONObject.put("source", C(paramArticleInfo.mChannelID));
        localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localJSONObject.put("rowkey", paramJSONObject.optString("rowKey"));
        localJSONObject.put("rec_articleid", paramJSONObject.optString("articleID"));
        localJSONObject.put("rec_puin", paramJSONObject.optString("subscribeID"));
        localJSONObject.put("mp_article_id", "" + paramArticleInfo.mArticleID);
        localJSONObject.put("kandian_mode", "" + kxm.nR());
        if (NetworkState.isWifiConn())
        {
          i = 1;
          localJSONObject.put("network_type", i);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "3.4.4".replace(".", ""));
          localJSONObject.put("imei", kxm.iT());
          localJSONObject.put("imsi", kxm.iU());
          localJSONObject.put("rcmInfo", paramJSONObject.optString("rcmInfo"));
          localJSONObject.put("content_type", paramJSONObject.optString("type"));
          localJSONObject.put("net_type", jqc.getNetWorkType() + "");
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
  
  public static void a(long paramLong, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, Context paramContext)
  {
    if ((paramArticleInfo == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReportUtil.3(paramContext, paramArticleInfo, paramFastWebArticleInfo, paramLong));
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramAppInterface, paramArticleInfo, paramInt1, paramInt2, paramBoolean, false);
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramArticleInfo == null) || (paramAppInterface == null)) {
      return;
    }
    int i = W((int)paramArticleInfo.mChannelID, paramArticleInfo.mFeedType);
    paramContext = kvp.a(paramContext, paramAppInterface.getCurrentAccountUin(), i, paramArticleInfo.mArticleID, paramArticleInfo.innerUniqueID, paramInt1, paramInt2, paramBoolean1, null);
    if (paramBoolean2) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        paramContext.put("is_redpack", paramInt1);
        kbp.a(null, "", "0X8009544", "0X8009544", 0, 0, "", String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mAlgorithmID), paramContext.toString(), false);
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
    int i = W((int)paramArticleInfo.mChannelID, paramArticleInfo.mFeedType);
    paramContext = kvp.a(paramContext, paramAppInterface.getCurrentAccountUin(), i, paramArticleInfo.mArticleID, paramArticleInfo.innerUniqueID, paramInt1, paramInt2, paramBoolean1, Boolean.valueOf(paramBoolean2));
    if (paramBoolean3) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        paramContext.put("is_redpack", paramInt1);
        kbp.a(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mAlgorithmID), paramContext.toString(), false);
        odg.d.a.nV(paramBoolean2);
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
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, kxm.b paramb)
  {
    int j = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    int i = Utils.px2dp(paramInt1);
    j = Utils.px2dp(j);
    paramb.b("read_area", "" + j * i);
    paramb.b("article_page", "" + Utils.px2dp(paramInt2));
    paramb.b("read_page", "" + Utils.px2dp(paramInt1));
    kbp.a(null, "CliOper", "", "", "0X8009782", "0X8009782", 0, 0, "" + paramArticleInfo.mArticleID, "", "", paramb.build(), false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    kxm.b localb = a(paramArticleInfo, paramBoolean, paramLong, paramInt3);
    a(paramArticleInfo, paramInt2, localb);
    b(paramArticleInfo, localb);
    a(paramArticleInfo, paramInt1, paramInt2, localb);
    c(paramArticleInfo, localb);
    a(paramArticleInfo, a(paramArticleInfo, paramBoolean, paramLong, paramInt3));
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt, kxm.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("body_show_time");
    long l3 = kxy.F(e(paramArticleInfo, 0));
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
    if (!paramArticleInfo.ks.isEmpty())
    {
      localObject3 = paramArticleInfo.ks.iterator();
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
    if (!paramArticleInfo.ks.isEmpty())
    {
      paramArticleInfo = paramArticleInfo.ks.iterator();
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
        ocp.y(201, localArrayList);
      }
      try
      {
        paramb.a("body_show_time", String.valueOf(l3));
        paramb.a("body_height", String.valueOf(paramInt));
        paramb.a("scroll_time", String.valueOf(l2));
        paramb.a("scroll_list", localStringBuilder.toString());
        kbp.a(null, "", "0X800A467", "0X800A467", 0, 0, "", "", "", paramb.build(), false);
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
  
  public static void a(ArticleInfo paramArticleInfo, long paramLong1, long paramLong2, kxm.b paramb)
  {
    if (paramArticleInfo == null) {
      return;
    }
    paramb.b("read_duration", "" + paramLong1 / 1000L);
    paramb.b("read_begin_timestamp", "" + paramLong2 / 1000L);
    paramb.b("read_end_timestamp", "" + NetConnInfoCenter.getServerTime());
    kbp.a(null, "CliOper", "", "" + paramArticleInfo.mSubscribeID, "0X8009781", "0X8009781", 0, 0, "" + paramArticleInfo.mArticleID, "", "", paramb.build(), false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, BaseData paramBaseData)
  {
    switch (paramBaseData.type)
    {
    default: 
      return;
    }
    try
    {
      paramBaseData = (ProteusRecommendItemData)paramBaseData;
      JSONObject localJSONObject = a(paramArticleInfo, paramBaseData.aD);
      String str = paramBaseData.aD.optJSONObject("card_info").optJSONObject("reportInfo").getString("article_exposure_T");
      localJSONObject.put("rec_location", "" + paramBaseData.bae);
      localJSONObject.put("rec_total", "" + paramBaseData.baf);
      localJSONObject.put("ad", "0");
      c(paramArticleInfo, str, localJSONObject.toString());
      return;
    }
    catch (Exception paramArticleInfo) {}
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, Context paramContext)
  {
    if ((paramArticleInfo == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReportUtil.2(paramContext, paramArticleInfo, paramFastWebArticleInfo));
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
        if (((ProteusItemData)localObject).mModuleType != 1) {}
      }
      int k;
      switch (((ProteusItemData)localObject).bad)
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
    paramList.put("param_uin", kxm.getAccount());
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebItemCount", true, 0L, 0L, paramList, null);
  }
  
  private static void a(ArticleInfo paramArticleInfo, kxm.b paramb)
  {
    paramb.c().f();
    int[] arrayOfInt = dz;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      Integer localInteger = Integer.valueOf(arrayOfInt[i]);
      String str = e(paramArticleInfo, localInteger.intValue());
      long l = kxy.F(str);
      paramb.a(bF[localInteger.intValue()] + "_duration_millis", l);
      kxy.mI(str);
      i += 1;
    }
    kbp.a(null, "CliOper", "", "" + paramArticleInfo.mSubscribeID, "0X80099D2", "0X80099D2", 0, 0, "", "" + paramArticleInfo.mArticleID, "", paramb.build(), false);
  }
  
  public static void a(BaseData paramBaseData, String paramString)
  {
    if ((paramBaseData == null) || (paramBaseData.d == null) || (paramBaseData.articleInfo == null)) {}
    while (!(paramBaseData instanceof ProteusBookData)) {
      return;
    }
    ProteusBookData localProteusBookData = (ProteusBookData)paramBaseData;
    FastWebArticleInfo localFastWebArticleInfo = paramBaseData.d;
    paramBaseData = paramBaseData.articleInfo;
    kxm.b localb = new kxm.b();
    localb.b("card_source", localProteusBookData.ama);
    localb.b("topic_id", localProteusBookData.amb);
    localb.b("source_id", localProteusBookData.amc);
    kbp.a(null, "CliOper", "", "" + localFastWebArticleInfo.puin, paramString, paramString, 0, 0, localFastWebArticleInfo.articleId + "", paramBaseData.mAlgorithmID + "", paramBaseData.innerUniqueID, localb.build(), false);
  }
  
  public static void a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {}
    byte[] arrayOfByte;
    do
    {
      do
      {
        return;
      } while (paramColorNote.getServiceType() != 16908290);
      arrayOfByte = paramColorNote.getReserve();
    } while (arrayOfByte == null);
    long l = paramColorNote.mTime;
    ThreadManager.getSubThreadHandler().post(new ReportUtil.1(arrayOfByte, l));
  }
  
  public static void a(AbsListView paramAbsListView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramAbsListView = a(paramString);
    if (paramInt1 == 0)
    {
      paramAbsListView.Z(paramInt2, paramBoolean);
      return;
    }
    paramAbsListView.Y(paramInt2, paramBoolean);
  }
  
  public static void a(String paramString, ProteusRecommendItemData paramProteusRecommendItemData, JSONObject paramJSONObject)
  {
    if ((paramProteusRecommendItemData == null) || (paramProteusRecommendItemData.articleInfo == null)) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = paramProteusRecommendItemData.aD;
        String str = localJSONObject.optJSONObject("card_info").optJSONObject("reportInfo").getString("click_T");
        if (!TextUtils.isEmpty(str))
        {
          localJSONObject = a(paramProteusRecommendItemData.articleInfo, localJSONObject);
          c(localJSONObject, paramJSONObject);
          localJSONObject.put("rec_location", "" + paramProteusRecommendItemData.bae);
          localJSONObject.put("rec_total", "" + paramProteusRecommendItemData.baf);
          localJSONObject.put("ad", "0");
          localJSONObject.put("click_area", paramString);
          c(paramProteusRecommendItemData.articleInfo, str, localJSONObject.toString());
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
        b(localJSONObject1, localJSONObject2);
        localJSONObject2.put("click_area", paramString);
        c(localJSONObject2, paramJSONObject2);
        if (kxm.AU()) {
          i = 1;
        }
        localJSONObject2.put("ad_relative_pos", i);
        paramString = new kxm.b(localJSONObject2);
        paramString.f();
        kbp.a(null, "", str, str, 0, 0, "", "", "", paramString.build(), false);
        boolean bool = "0X800983F".equals(str);
        if (!bool) {
          continue;
        }
        try
        {
          if (!paramJSONObject1.has("kdschSessionId")) {
            paramJSONObject1.put("kdschSessionId", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin() + System.currentTimeMillis());
          }
          amub.a(null, new ReportModelDC02528().module("all_search").action("clk_jingtan_list").obj1("2049").ver2("kandian").ver4(paramJSONObject2.getString("searchWord")).ver6(localJSONObject1.getString("articleRowKey")).ver7("{\"scroe\":\"" + paramJSONObject2.getString("score") + "\",\"title\":\"" + localJSONObject1.getString("articleTitle") + "\",\"position\":\"" + paramJSONObject2.getString("position") + "\"}").session_id(paramJSONObject1.getString("kdschSessionId")));
          return;
        }
        catch (Exception paramString) {}
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public static void ag(JSONObject paramJSONObject)
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
        b(localJSONObject, (JSONObject)localObject1);
        if (!kxm.AU()) {
          break label390;
        }
        i = 1;
        ((JSONObject)localObject1).put("ad_relative_pos", i);
        Object localObject2 = new kxm.b((JSONObject)localObject1);
        ((kxm.b)localObject2).f();
        kbp.a(null, "", str, str, 0, 0, "", "", "", ((kxm.b)localObject2).build(), false);
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
            amub.a(null, new ReportModelDC02528().module("all_search").action("exp_jingtan_list").obj1("2049").ver2("kandian").ver4(str).ver6(localJSONObject.getString("articleRowKey")).ver7("{\"title\":\"" + localJSONObject.getString("articleTitle") + "\"}").session_id(paramJSONObject.getString("kdschSessionId")));
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
  
  public static void ah(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("card_info");
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optJSONObject("reportInfo").getString("info"));
      b(paramJSONObject, localJSONObject);
      if (kxm.AU()) {
        i = 1;
      }
      localJSONObject.put("ad_relative_pos", i);
      paramJSONObject = new kxm.b(localJSONObject);
      paramJSONObject.f();
      kbp.a(null, "", "0X8009A7D", "0X8009A7D", 0, 0, "", "", "", paramJSONObject.build(), false);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public static kxm.b b(ArticleInfo paramArticleInfo)
  {
    kxm.b localb = new kxm.b();
    localb.b("folder_status", kxm.aMw);
    localb.b("feeds_source", paramArticleInfo.mSubscribeID);
    localb.b("feeds_type", paramArticleInfo.mFeedType);
    localb.b("kandian_mode", kxm.nR());
    localb.b("tab_source", kxm.nQ());
    localb.b("rowkey", paramArticleInfo.innerUniqueID);
    localb.a("channel_id", paramArticleInfo.mChannelID);
    return localb;
  }
  
  public static void b(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramAppInterface, paramArticleInfo, paramInt1, paramInt2, paramBoolean1, paramBoolean2, false);
  }
  
  public static void b(ArticleInfo paramArticleInfo, kxm.b paramb)
  {
    if (paramArticleInfo != null)
    {
      a(paramArticleInfo, kxy.F(paramArticleInfo.innerUniqueID), kxy.E(paramArticleInfo.innerUniqueID), paramb);
      kxy.mI(paramArticleInfo.innerUniqueID);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, AdData paramAdData, float paramFloat, long paramLong)
  {
    if ((paramQQAppInterface != null) && (paramAdData != null))
    {
      if ((!(paramAdData instanceof ProteusInnerData)) || (!((ProteusInnerData)paramAdData).zG())) {
        break label103;
      }
      kjz.a(paramQQAppInterface.getApp(), paramAdData, jzk.aEK, 0, -1, 2);
    }
    for (;;)
    {
      QLog.d("Q.readinjoy.fast_web", 2, " doReportAdShowExtra " + paramAdData.title + "  : " + paramAdData.content + " exposureArea = " + paramFloat + " exposureTime = " + paramLong);
      return;
      label103:
      jzk.a(paramQQAppInterface, paramAdData, paramFloat, paramLong);
    }
  }
  
  public static void b(ColorNote paramColorNote) {}
  
  public static void b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
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
  
  public static void c(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    kbp.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, paramString1, paramString1, 0, 0, paramArticleInfo.mArticleID + "", paramArticleInfo.mAlgorithmID + "", paramArticleInfo.innerUniqueID, paramString2, false);
  }
  
  public static void c(ArticleInfo paramArticleInfo, kxm.b paramb)
  {
    nns.a locala = a(paramArticleInfo.innerUniqueID);
    if (locala.kr.isEmpty()) {
      return;
    }
    paramb.j();
    paramb.b("read_begin_timestamp", "" + locala.xP / 1000L);
    paramb.b("read_end_timestamp", "" + locala.xQ / 1000L);
    String str1 = "";
    Iterator localIterator = locala.kr.iterator();
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
    paramb.b("read_speed_array", str1);
    paramb.b("avg_speed", "" + l / locala.kr.size());
    kbp.a(null, "CliOper", "", "", "0X8009783", "0X8009783", 0, 0, "" + paramArticleInfo.mArticleID, "", "", paramb.build(), false);
    oj(paramArticleInfo.innerUniqueID);
  }
  
  public static void c(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
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
  
  public static void d(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if (paramArticleInfo == null) {
      return;
    }
    str = "";
    for (;;)
    {
      try
      {
        kxm.b localb = b(paramArticleInfo);
        localb.b("source_from", paramString2);
        if (!kxm.AT()) {
          continue;
        }
        i = 1;
        localb.b("artical_interact_area", i);
        localb.b("artical_interact_type", kxm.nU());
        paramString2 = localb.build();
      }
      catch (Exception paramString2)
      {
        int i;
        paramString2.printStackTrace();
        paramString2 = str;
        continue;
      }
      kbp.a(null, paramArticleInfo.mSubscribeID, paramString1, paramString1, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "", paramString2, false);
      return;
      i = 0;
    }
  }
  
  public static void d(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    do
    {
      return;
      if (paramBaseData.type == 18) {
        a(paramBaseData, "0X800974A");
      }
    } while (!(paramBaseData instanceof ProteusItemData));
    paramBaseData = (ProteusItemData)paramBaseData;
    ag(paramBaseData.aD);
    ah(paramBaseData.aD);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if ((paramQQAppInterface != null) && (paramAdData != null))
    {
      jzk.a(paramQQAppInterface, paramAdData);
      QLog.d("Q.readinjoy.fast_web", 2, " doReportAdShow " + paramAdData.title + "  : " + paramAdData.content);
    }
  }
  
  public static void dl(List<ColorNote> paramList)
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
  
  public static String e(ArticleInfo paramArticleInfo, int paramInt)
  {
    return paramArticleInfo.innerUniqueID + bG[paramInt];
  }
  
  public static void e(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if ((paramQQAppInterface != null) && (paramAdData != null))
    {
      jzk.b(paramQQAppInterface, paramAdData);
      QLog.d("Q.readinjoy.fast_web", 2, " doReportAdInvalidShow " + paramAdData.title + "  : " + paramAdData.content);
    }
  }
  
  public static boolean f(BaseData paramBaseData)
  {
    switch (paramBaseData.type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static void oj(String paramString)
  {
    eJ.remove(paramString);
  }
  
  static class a
  {
    private boolean atB;
    public List<Pair<Long, Long>> kr = new ArrayList();
    public List<Pair<Long, Long>> ks = new ArrayList();
    public long xO;
    public long xP;
    public long xQ;
    public long xR;
    public long xS;
    
    public a(long paramLong)
    {
      this.xO = paramLong;
      if (this.xO <= 0L) {
        this.xO = NetConnInfoCenter.getServerTimeMillis();
      }
    }
    
    public void Y(long paramLong, boolean paramBoolean)
    {
      if (this.kr.size() >= 30) {
        return;
      }
      this.xR = NetConnInfoCenter.getServerTimeMillis();
      if (this.xP == 0L) {
        this.xP = this.xR;
      }
      this.xS = paramLong;
      this.atB = paramBoolean;
    }
    
    public void Z(long paramLong, boolean paramBoolean)
    {
      this.xQ = NetConnInfoCenter.getServerTimeMillis();
      if (this.kr.size() >= 30) {}
      do
      {
        return;
        l3 = (this.xQ - this.xR) / 100L;
      } while (l3 == 0L);
      long l1 = paramLong - this.xS;
      long l2 = (this.xQ - this.xO) / 100L;
      long l3 = Utils.px2dp((float)(l1 / l3));
      this.kr.add(new Pair(Long.valueOf(l3), Long.valueOf(l2)));
      if ((this.atB) || (paramBoolean)) {
        this.ks.add(new Pair(Long.valueOf(this.xQ - this.xR), Long.valueOf(l1)));
      }
      this.xS = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nns
 * JD-Core Version:    0.7.0.1
 */