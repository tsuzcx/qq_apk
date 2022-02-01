import android.content.Context;
import android.graphics.Paint.FontMetricsInt;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusInteractiveItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.4;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.5;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.6;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.7;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class tjm
{
  public static String a;
  private static Map<String, String> a;
  public static String b = "https://kandian.qq.com/kandian_article/get_article_recomm?from=native";
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://c.mp.qq.com/cgi-bin/ad/get_mp_ads?";
  }
  
  private static long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(Uri.parse(paramString).getQueryParameter("article_id"));
      return l;
    }
    catch (Exception localException)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("which", "3");
      localHashMap.put("article_url", "" + paramString);
      localHashMap.put("error", "" + localException.toString());
      localHashMap.put("param_uin", pkh.a());
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", false, 0L, 0L, localHashMap, null);
    }
    return -1L;
  }
  
  private static AdData a(JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramJSONObject == null) {}
    Object localObject2;
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
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return localObject1;
                          if (paramInt == 2) {
                            return new ProteusInnerData();
                          }
                        } while (paramInt != 1);
                        if ((paramJSONObject.has("type")) && (paramJSONObject.optInt("type") == 100)) {
                          return new AttachedAdData();
                        }
                        if (!paramBoolean) {
                          break label366;
                        }
                        if (TextUtils.isEmpty(paramJSONObject.optString("video"))) {
                          break;
                        }
                        localObject2 = new ProteusBannerVideoItemData();
                        localObject1 = localObject2;
                      } while (!paramJSONObject.has("video_file_size"));
                      ((ProteusBannerVideoItemData)localObject2).f = paramJSONObject.optLong("video_file_size");
                      return localObject2;
                      localObject2 = new ProteusBannerBigPicItemData();
                      localObject1 = localObject2;
                    } while (!paramJSONObject.has("local_info"));
                    paramJSONObject = paramJSONObject.optJSONObject("local_info");
                    if (QLog.isColorLevel()) {
                      QLog.d("FastWebRequestUtil", 2, "has local info ->" + paramJSONObject);
                    }
                    localObject1 = localObject2;
                  } while (paramJSONObject == null);
                  ((ProteusBannerBigPicItemData)localObject2).W = paramJSONObject.optString("store_name");
                  ((ProteusBannerBigPicItemData)localObject2).X = paramJSONObject.optString("store_addr");
                  ((ProteusBannerBigPicItemData)localObject2).Y = paramJSONObject.optString("store_url");
                  ((ProteusBannerBigPicItemData)localObject2).aa = paramJSONObject.optString("store_long");
                  ((ProteusBannerBigPicItemData)localObject2).Z = paramJSONObject.optString("store_lat");
                  ((ProteusBannerBigPicItemData)localObject2).ab = paramJSONObject.optString("dist_desc");
                  ((ProteusBannerBigPicItemData)localObject2).ac = paramJSONObject.optString("corporate_image_name");
                  ((ProteusBannerBigPicItemData)localObject2).ad = paramJSONObject.optString("distance_limit");
                  localObject1 = localObject2;
                } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).W));
                localObject1 = localObject2;
              } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).X));
              localObject1 = localObject2;
            } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).Y));
            localObject1 = localObject2;
          } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).aa));
          localObject1 = localObject2;
        } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).Z));
        localObject1 = localObject2;
      } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).ab));
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).ad));
    ((ProteusBannerBigPicItemData)localObject2).f = true;
    return localObject2;
    label366:
    return new RecommendAdData();
  }
  
  private static AdData a(JSONObject paramJSONObject, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3)
  {
    AdData localAdData = a(paramJSONObject, paramInt1, paramBoolean);
    if (localAdData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastWebRequestUtil", 1, "parseAdItem failed");
      }
      return null;
    }
    localAdData.q = paramInt3;
    localAdData.a(paramJSONObject, paramString);
    if (localAdData.a(paramJSONObject, paramInt2))
    {
      localAdData.a();
      return localAdData;
    }
    localAdData.a();
    return null;
  }
  
  private static ProteusItemData a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return new ProteusRecommendItemData();
    }
    return new ProteusInteractiveItemData();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (paramString.startsWith("http:"));
        str = paramString;
      } while (paramString.startsWith("https"));
      str = paramString;
    } while (paramString.startsWith("mqqapi:"));
    if (paramBoolean) {
      return "https:" + paramString;
    }
    return "http:" + paramString;
  }
  
  private static String a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("card_info");
    if (paramJSONObject == null) {
      return "null";
    }
    return paramJSONObject.optString("rowKey", "null");
  }
  
  public static List<BaseData> a(String paramString, int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = localArrayList;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      localObject = localArrayList;
      if (paramList.hasNext()) {
        localObject = b(paramString, paramInt, (String)paramList.next());
      }
    }
    return localObject;
  }
  
  public static Map<String, String> a(Context paramContext)
  {
    if (jdField_a_of_type_JavaUtilMap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastWebRequestUtil", 2, "getDisplayParams : " + jdField_a_of_type_JavaUtilMap);
      }
      return jdField_a_of_type_JavaUtilMap;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = tmh.a("native_article", true);
    if (localObject1 == null) {
      return localHashMap;
    }
    localObject1 = ((tmh)localObject1).getTemplate("ReadInjoy_article_text_cell");
    if (localObject1 == null) {
      return localHashMap;
    }
    Object localObject2 = ((TemplateBean)localObject1).getViewBean().findViewById("id_article_paragraph");
    String str1;
    String str2;
    if (localObject2 != null)
    {
      localObject1 = (String)((ViewBean)localObject2).valueBean.normalValue.get("margin_left");
      str1 = (String)((ViewBean)localObject2).valueBean.normalValue.get("margin_top");
      str2 = (String)((ViewBean)localObject2).valueBean.normalValue.get("setLineSpace:");
      localObject2 = (String)((ViewBean)localObject2).valueBean.normalValue.get("setFontSizeString:");
    }
    try
    {
      int i = (int)tjg.a();
      int i1 = Utils.dp2px(Integer.valueOf(str2).intValue());
      int j = Utils.dp2px(Integer.valueOf((String)localObject1).intValue());
      int k = Utils.dp2px(Integer.valueOf(str1).intValue());
      int m = ScreenUtil.getInstantScreenHeight(paramContext);
      int n = ScreenUtil.getInstantScreenWidth(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = Utils.dp2px(Integer.valueOf((String)localObject2).intValue());
        paramContext = new TextPaint();
        paramContext.setTextSize(Utils.dp2px(i));
        i = paramContext.getFontMetricsInt(new Paint.FontMetricsInt());
        i1 = (int)(i1 * 2 / 3.0D);
        int i2 = (int)paramContext.measureText("我");
        localHashMap.put("screenWidth", String.valueOf(n));
        localHashMap.put("screenHeight", String.valueOf(m));
        localHashMap.put("lineHeight", String.valueOf(i + i1));
        localHashMap.put("contentPadding", String.valueOf(j));
        localHashMap.put("paragraphSpace", String.valueOf(k));
        localHashMap.put("fontSize", String.valueOf(i2));
        jdField_a_of_type_JavaUtilMap = localHashMap;
        if (QLog.isColorLevel()) {
          QLog.d("FastWebRequestUtil", 2, "getDisplayParams : " + localHashMap.toString());
        }
        return localHashMap;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("FastWebRequestUtil", 2, paramContext, new Object[0]);
        localHashMap.clear();
      }
    }
  }
  
  private static void a(int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    if (paramInt1 == 0) {}
    try
    {
      paramJSONObject.put("label_separator_line_top_bg_color", paramJSONObject.optString("label_separator_line_top_bg_color", "#E5E5E5"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebRequestUtil", 1, "parseProteusItem msg=" + paramJSONObject);
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramJSONObject.put("label_separator_line_bottom_bg_color", paramJSONObject.optString("label_separator_line_bottom_bg_color", "#E5E5E5"));
      return;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, ProteusItemData paramProteusItemData, int paramInt, SparseArray<Float> paramSparseArray)
  {
    if ((paramArticleInfo == null) || (paramProteusItemData == null) || (paramProteusItemData.c == null)) {
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = paramProteusItemData.c.optJSONObject("card_info");
        if (localJSONObject == null) {
          break label164;
        }
        localJSONObject.put("strategyId", paramArticleInfo.mStrategyId);
        localJSONObject.put("algorithmID", paramArticleInfo.mAlgorithmID);
        localJSONObject.put("articleTitle", paramArticleInfo.mTitle);
        localJSONObject.put("articleRowKey", paramArticleInfo.innerUniqueID);
      }
      catch (Exception paramArticleInfo)
      {
        Object localObject;
        QLog.d("FastWebRequestUtil", 1, "addExtraInfo error! msg=" + paramArticleInfo);
        return;
      }
      paramProteusItemData.b = localObject;
      paramProteusItemData.v = paramInt;
      return;
      if (localJSONObject != null) {
        localJSONObject.put("channelID", paramArticleInfo.mChannelID);
      }
      float f1 = tjf.b(paramSparseArray);
      continue;
      f1 = tjf.c(paramSparseArray);
      continue;
      label164:
      float f2 = -1000.0F;
      f1 = f2;
      switch (paramInt)
      {
      }
      f1 = f2;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, tpy paramtpy)
  {
    if (paramArticleInfo == null) {
      return;
    }
    QLog.d("FastWebRequestUtil", 2, "deleteFeeds.");
    ThreadManager.excute(new FastWebRequestUtil.6(paramArticleInfo, paramtpy), 128, null, true);
  }
  
  public static void a(String paramString, FastWebArticleInfo paramFastWebArticleInfo)
  {
    QLog.d("Q.readinjoy.fast_web", 2, "" + paramString);
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    try
    {
      long l = a(paramString);
      if (l == -1L) {
        return;
      }
      localObject = arrayOfByte;
      paramString = new Bundle();
      localObject = arrayOfByte;
      paramString.putString("articleId", String.valueOf(l));
      localObject = arrayOfByte;
      QLog.d("Q.readinjoy.fast_web", 2, "" + "https://c.mp.qq.com/review/img-txt-comment/list?source=1" + "  articleId " + l);
      localObject = arrayOfByte;
      Bundle localBundle = new Bundle();
      localObject = arrayOfByte;
      HttpUtil.addCookie(localBundle);
      localObject = arrayOfByte;
      arrayOfByte = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), "https://c.mp.qq.com/review/img-txt-comment/list?source=1", "POST", paramString, localBundle);
      localObject = "";
      paramString = (String)localObject;
      if (arrayOfByte != null) {
        paramString = new String(arrayOfByte);
      }
      localObject = paramString;
      QLog.d("Q.readinjoy.fast_web", 2, "https://c.mp.qq.com/review/img-txt-comment/list?source=1" + "  articleId " + l + " " + paramString);
      localObject = paramString;
      int i = new JSONObject(paramString).getInt("readCount");
      localObject = paramString;
      if (i > paramFastWebArticleInfo.a)
      {
        localObject = paramString;
        paramFastWebArticleInfo.a = i;
        localObject = paramString;
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.5());
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("Q.readinjoy.fast_web", 2, paramString, new Object[] { "" + (String)localObject });
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, int paramInt1, long paramLong, tjr paramtjr, int paramInt2)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebRequestUtil.4(paramString1, paramString2, paramString3, paramString4, paramString6, paramString7, paramBoolean, paramInt1, paramLong, paramString5, paramInt2, paramtjr));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, tjq paramtjq, int paramInt1, int paramInt2, long paramLong)
  {
    paramtjq = new tjp(paramString1, paramtjq);
    a(paramString1, paramString2, paramString3, new tjn(paramtjq), paramInt2);
    a(paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5, paramString6, paramString7, paramInt1, paramLong, new tjo(paramtjq), paramInt2);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, tjr paramtjr, int paramInt)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebRequestUtil.3(paramString1, paramString2, paramInt, paramtjr));
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.optString("kd_ug_rsp_info");
    Object localObject2;
    if ((localObject1 != null) && (paramJSONObject.opt("id_recommend_category_txt") != null) && (paramJSONObject.opt("kd_ug_download_url") != null))
    {
      localObject1 = new tjl((String)localObject1, tgb.a(paramJSONObject));
      a(paramJSONObject, (tjl)localObject1);
      localObject2 = ((tjl)localObject1).b;
      paramJSONObject = paramJSONObject.getJSONObject("id_recommend_category_txt");
      paramJSONObject.put("text_color", "#FF4A2D");
      paramJSONObject.put("label_ug_progress_bgcolor", "#FFE9E9");
      paramJSONObject.put("label_ug_progress_fgcolor", "#FFCECE");
      if (bhfn.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0")) {
        break label165;
      }
      if ((((tjl)localObject1).b()) && (!TextUtils.isEmpty(((tjl)localObject1).c)))
      {
        paramJSONObject.put("text", ((tjl)localObject1).e);
        paramJSONObject.put("label_ug_progress_progress", 100);
      }
    }
    else
    {
      return;
    }
    paramJSONObject.put("text", "");
    return;
    label165:
    if ((((tjl)localObject1).a()) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject2 = bjjq.a().b((String)localObject2);
      if (localObject2 == null)
      {
        paramJSONObject.put("text", ((tjl)localObject1).f);
        paramJSONObject.put("label_ug_progress_progress", 0);
        return;
      }
      if (((DownloadInfo)localObject2).a() == 4)
      {
        paramJSONObject.put("text", ((tjl)localObject1).g);
        paramJSONObject.put("label_ug_progress_progress", 100);
        return;
      }
      if ((((DownloadInfo)localObject2).a() == 20) || (((DownloadInfo)localObject2).a() == 1) || (((DownloadInfo)localObject2).a() == 2))
      {
        paramJSONObject.put("text", ((tjl)localObject1).h + ((DownloadInfo)localObject2).f + "%");
        paramJSONObject.put("label_ug_progress_progress", ((DownloadInfo)localObject2).f);
        return;
      }
      paramJSONObject.put("text", ((tjl)localObject1).j);
      paramJSONObject.put("label_ug_progress_progress", ((DownloadInfo)localObject2).f);
      return;
    }
    paramJSONObject.put("text", "");
  }
  
  private static void a(JSONObject paramJSONObject, tjl paramtjl)
  {
    str2 = "";
    str1 = str2;
    if (paramJSONObject.opt("card_info") != null) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("card_info");
      str1 = str2;
      if (paramJSONObject.opt("rowKey") != null) {
        str1 = paramJSONObject.getString("rowKey");
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
        str1 = str2;
      }
    }
    oqt.a(oqt.a(paramtjl.jdField_a_of_type_JavaLangString, str1, "1"));
  }
  
  private static String b(Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    ukq.a("REPORT_LINK", "requestAdData start");
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("ext=" + URLEncoder.encode(paramJSONObject.toString(), "utf-8"));
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        paramJSONObject = (Map.Entry)paramMap.next();
        localStringBuilder.append("&" + (String)paramJSONObject.getKey() + "=" + URLEncoder.encode((String)paramJSONObject.getValue(), "utf-8"));
      }
      paramMap = ((QQAppInterface)pkh.a()).getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.fast_web", 2, "requestAdData:" + localStringBuilder + "    uin : " + paramMap);
      }
      paramMap = new Bundle();
      HttpUtil.addCookie(paramMap);
      paramJSONObject = localStringBuilder.toString();
      paramJSONObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), paramJSONObject, "GET", null, paramMap);
      if (paramJSONObject == null)
      {
        QLog.e("Q.readinjoy.fast_web", 2, "requestAdData bytes null");
        return null;
      }
      paramMap = "";
      if (paramJSONObject != null) {
        paramMap = new String(paramJSONObject);
      }
      paramJSONObject = paramMap;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.fast_web", 2, "requestAdData result:" + paramMap);
        return paramMap;
      }
    }
    catch (Exception paramMap)
    {
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
  
  private static List<BaseData> b(String paramString1, int paramInt, String paramString2)
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(paramString2).getJSONArray("data");
      int i = 0;
      Object localObject1 = null;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
        if (paramInt == 6)
        {
          localJSONObject.put("dt_parent_rowkey", paramString1);
          localJSONObject.put("dt_rowkey", a(localJSONObject));
          a(i, localJSONArray.length(), localJSONObject);
          a(localJSONObject);
        }
        Object localObject2 = tmh.a("native_article", true);
        if (localObject2 != null) {}
        for (localObject2 = ((tmh)localObject2).getTemplateBean(localJSONObject);; localObject2 = null)
        {
          if (localObject2 != null)
          {
            ProteusItemData localProteusItemData = a(paramInt);
            localObject1 = localProteusItemData;
            if (localProteusItemData != null)
            {
              localProteusItemData.a = ((TemplateBean)localObject2);
              localProteusItemData.c = localJSONObject;
              localArrayList.add(localProteusItemData);
              localObject1 = localProteusItemData;
            }
          }
          tjj.a(localObject1);
          i += 1;
          break;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      QLog.e("FastWebRequestUtil", 1, new Object[] { "parseProteusData error:", paramString1.toString(), " item:" + paramString2 });
      QLog.d("FastWebRequestUtil", 1, "parseProteusItem,type=" + paramInt + " item=" + paramString2 + " datasSize=" + localArrayList.size());
    }
  }
  
  private static Map<String, String> b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    paramString5 = (QQAppInterface)pkh.a();
    paramString6 = paramString5.getAccount();
    paramString6 = ((TicketManager)paramString5.getManager(2)).getSkey(paramString6);
    paramString5 = new HashMap();
    if (paramBoolean) {
      paramString3 = "0";
    }
    paramString5.put("puin", paramString3);
    paramString5.put("id", paramString1);
    paramString5.put("tag", paramString4);
    if (paramString6 == null) {}
    for (paramString1 = "";; paramString1 = sfq.a(paramString6))
    {
      paramString5.put("token", paramString1);
      paramString5.put("cookie", ois.a());
      paramString5.put("scene", String.valueOf(3));
      paramString5.put("rowkey", paramString2);
      paramString5.put("source_channel_id", String.valueOf(paramLong));
      if (paramInt2 > 0) {
        paramString5.put("contentCount", String.valueOf(paramInt2));
      }
      paramString1 = a(BaseApplication.getContext());
      if (paramString1 != null) {}
      try
      {
        paramString2 = new JSONObject();
        if (paramString1.containsKey("fontSize")) {
          paramString2.put("fontSize", paramString1.get("fontSize"));
        }
        if (paramString1.containsKey("lineHeight")) {
          paramString2.put("lineHeight", paramString1.get("lineHeight"));
        }
        if (paramString1.containsKey("paragraphSpace")) {
          paramString2.put("paragraphSpace", paramString1.get("paragraphSpace"));
        }
        if (paramString1.containsKey("screenWidth")) {
          paramString2.put("screenWidth", paramString1.get("screenWidth"));
        }
        if (paramString1.containsKey("screenHeight")) {
          paramString2.put("screenHeight", paramString1.get("screenHeight"));
        }
        if (paramString1.containsKey("contentPadding")) {
          paramString2.put("contentPadding", paramString1.get("contentPadding"));
        }
        paramString5.put("article_display_params", paramString2.toString());
        paramString5.put("noExposeList", odz.a().a());
        return paramString5;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return paramString5;
  }
  
  private static JSONObject b(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject1).businessIdForAidTicketAndTaidTicket = "ce2d9f";
        localObject1 = GdtDeviceInfoHelper.create(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).deviceInfo;
          localJSONObject.put("muidtype", 1);
          localObject3 = ujw.b();
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label645;
          }
          localObject2 = "0000000000000000";
          localJSONObject.put("muid", localObject2);
          localJSONObject.put("carrier", acil.a(BaseApplicationImpl.getContext()));
          localJSONObject.put("c_os", "android");
          localJSONObject.put("appid", String.valueOf(AppSetting.a()));
          localJSONObject.put("app_version_id", AppSetting.a());
          localJSONObject.put("imei", localObject3);
          if (localObject1 != null)
          {
            localJSONObject.put("conn", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn.get());
            localJSONObject.put("hostver", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qq_ver.get());
            localJSONObject.put("c_osver", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver.get());
            localJSONObject.put("qadid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
            localJSONObject.put("oaid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
            localJSONObject.put("taid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
            localJSONObject.put("androidid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
            localJSONObject.put("mac_addr", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
            if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
              localJSONObject.put("ipv4", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
            }
            localJSONObject.put("muid_from_gdt", "1");
            localJSONObject.put("muidtype", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type.get());
            if (!TextUtils.isEmpty(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get())) {
              continue;
            }
            localObject2 = "";
            localJSONObject.put("muid", localObject2);
            localJSONObject.put("bytes_wx_ver", ujw.a(BaseApplication.getContext()));
            if (QLog.isColorLevel()) {
              QLog.i("FastWebRequestUtil", 2, "makePhoneInfo0x6cf: deviceInfo: oa=" + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).oaid.get() + ", ta=" + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
            }
          }
          localObject2 = Build.BRAND;
          localObject3 = Build.MODEL;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localJSONObject.put("c_mf", localObject2);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            localJSONObject.put("c_device", localObject3);
          }
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = new JSONArray(paramString);
            localObject2 = new JSONArray();
            int i = 0;
            if (i < paramString.length())
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("qie_context", paramString.getJSONObject(i).toString());
              ((JSONArray)localObject2).put(localObject3);
              i += 1;
              continue;
              localObject2 = ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get();
              continue;
            }
            if (((JSONArray)localObject2).length() > 0) {
              localJSONObject.put("pos", localObject2);
            }
          }
          localJSONObject.put("present_from", paramInt);
          if (bdvn.a()) {
            localJSONObject.put("reqLearningPatternFlag", 1);
          }
          if (localObject1 != null) {
            localJSONObject.put("device_ext", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext.get());
          }
          return localJSONObject;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return localJSONObject;
      }
      Object localObject1 = null;
      continue;
      label645:
      Object localObject2 = localObject3;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, tpy paramtpy)
  {
    if (paramArticleInfo == null) {
      return;
    }
    QLog.d("FastWebRequestUtil", 2, "shieldFeedSource");
    ThreadManager.excute(new FastWebRequestUtil.7(paramArticleInfo, paramtpy), 128, null, true);
  }
  
  private static void b(List<BaseData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    HashSet localHashSet = new HashSet(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AdData localAdData = (AdData)paramList.next();
      if ((localAdData != null) && (localAdData.n == 32) && (localAdData.a != null)) {
        localHashSet.add(Long.valueOf(localAdData.a.mAdAid));
      }
    }
    odz.a().a("RIJAdRefreshSceneNativeArticle", localHashSet);
  }
  
  private static boolean b(String paramString1, String paramString2, List<BaseData> paramList, JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (paramList == null)) {
      bool1 = false;
    }
    Object localObject;
    String str;
    int k;
    int j;
    int i;
    for (;;)
    {
      return bool1;
      try
      {
        localObject = new JSONObject(paramString1);
        ois.a(((JSONObject)localObject).optString("cookie"));
        str = ((JSONObject)localObject).optString("ad_switchs");
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("result");
        k = ((JSONObject)localObject).optInt("req_type", 0);
        j = 0;
        bool1 = bool2;
        if (j < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(j);
          if (((JSONObject)localObject).isNull("ad_pos_type"))
          {
            ((JSONObject)localObject).put("rowkey", paramString2);
            i = ((JSONObject)localObject).getInt("ad_pos");
            localObject = a(ukp.a((JSONObject)localObject, paramJSONObject), 1, false, str, i, k);
            uks.a((AdData)localObject);
            if (localObject != null)
            {
              ((AdData)localObject).d = false;
              paramList.add(localObject);
            }
          }
          else
          {
            i = ((JSONObject)localObject).getInt("ad_pos_type");
            if (i == 1)
            {
              ((JSONObject)localObject).put("rowkey", paramString2);
              localObject = a(ukp.a((JSONObject)localObject, paramJSONObject), 1, true, str, -1, k);
              uks.a((AdData)localObject);
              if (localObject == null) {
                break label439;
              }
              ((AdData)localObject).d = false;
              paramList.add(localObject);
            }
          }
        }
      }
      catch (Exception paramString2)
      {
        QLog.e("Q.readinjoy.fast_web", 2, paramString2, new Object[] { "" + paramString1 });
        return false;
      }
    }
    Iterator localIterator;
    if (i == 2)
    {
      ((JSONObject)localObject).put("rowkey", paramString2);
      localObject = a(ukp.a((JSONObject)localObject, paramJSONObject), 2, false, str, -1, k);
      if (localObject != null)
      {
        ((AdData)localObject).d = true;
        localIterator = paramList.iterator();
        i = 0;
      }
    }
    label439:
    label448:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if (((localBaseData instanceof ProteusInnerData)) && (((ProteusInnerData)localBaseData).e()))
        {
          i = 1;
          break label448;
        }
      }
      else
      {
        if (((localObject instanceof ProteusInnerData)) && (((ProteusInnerData)localObject).e()))
        {
          if (i != 0) {
            break label439;
          }
          paramList.add(localObject);
          break label439;
        }
        paramList.add(localObject);
        break label439;
      }
      break label448;
      j += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tjm
 * JD-Core Version:    0.7.0.1
 */