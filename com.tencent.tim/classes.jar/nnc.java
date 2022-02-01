import android.content.Context;
import android.graphics.Paint.FontMetricsInt;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
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

public class nnc
{
  public static String amo = "https://c.mp.qq.com/cgi-bin/ad/get_mp_ads?";
  public static String amp = "https://kandian.qq.com/kandian_article/get_article_recomm?from=native";
  private static Map<String, String> eH;
  
  private static long I(String paramString)
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
      localHashMap.put("param_uin", kxm.getAccount());
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", false, 0L, 0L, localHashMap, null);
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
                          break label384;
                        }
                        if (TextUtils.isEmpty(paramJSONObject.optString("video"))) {
                          break;
                        }
                        localObject2 = new ProteusBannerVideoItemData();
                        localObject1 = localObject2;
                      } while (!paramJSONObject.has("video_file_size"));
                      ((ProteusBannerVideoItemData)localObject2).mXGFileSize = paramJSONObject.optLong("video_file_size");
                      return localObject2;
                      if (paramJSONObject.optInt("img_type") == 3) {
                        return new ProteusBannerTriplePicItemData();
                      }
                      localObject2 = new ProteusBannerBigPicItemData();
                      localObject1 = localObject2;
                    } while (!paramJSONObject.has("local_info"));
                    paramJSONObject = paramJSONObject.optJSONObject("local_info");
                    if (QLog.isColorLevel()) {
                      QLog.d("FastWebRequestUtil", 2, "has local info ->" + paramJSONObject);
                    }
                    localObject1 = localObject2;
                  } while (paramJSONObject == null);
                  ((ProteusBannerBigPicItemData)localObject2).store_name = paramJSONObject.optString("store_name");
                  ((ProteusBannerBigPicItemData)localObject2).aaS = paramJSONObject.optString("store_addr");
                  ((ProteusBannerBigPicItemData)localObject2).store_url = paramJSONObject.optString("store_url");
                  ((ProteusBannerBigPicItemData)localObject2).aaU = paramJSONObject.optString("store_long");
                  ((ProteusBannerBigPicItemData)localObject2).aaT = paramJSONObject.optString("store_lat");
                  ((ProteusBannerBigPicItemData)localObject2).aaV = paramJSONObject.optString("dist_desc");
                  ((ProteusBannerBigPicItemData)localObject2).corporate_image_name = paramJSONObject.optString("corporate_image_name");
                  ((ProteusBannerBigPicItemData)localObject2).aaW = paramJSONObject.optString("distance_limit");
                  localObject1 = localObject2;
                } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).store_name));
                localObject1 = localObject2;
              } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).aaS));
              localObject1 = localObject2;
            } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).store_url));
            localObject1 = localObject2;
          } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).aaU));
          localObject1 = localObject2;
        } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).aaT));
        localObject1 = localObject2;
      } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).aaV));
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).aaW));
    ((ProteusBannerBigPicItemData)localObject2).agg = true;
    return localObject2;
    label384:
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
    localAdData.req_type = paramInt3;
    localAdData.d(paramJSONObject, paramString);
    if (localAdData.a(paramJSONObject, paramInt2))
    {
      localAdData.aDY();
      return localAdData;
    }
    localAdData.aDY();
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
  
  private static String a(Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(amo);
      localStringBuilder.append("ext=" + URLEncoder.encode(paramJSONObject.toString(), "utf-8"));
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        paramJSONObject = (Map.Entry)paramMap.next();
        localStringBuilder.append("&" + (String)paramJSONObject.getKey() + "=" + URLEncoder.encode((String)paramJSONObject.getValue(), "utf-8"));
      }
      paramMap = ((QQAppInterface)kxm.getAppRuntime()).getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.fast_web", 2, "requestAdData:" + localStringBuilder + "    uin : " + paramMap);
      }
      paramMap = new Bundle();
      jqc.an(paramMap);
      paramJSONObject = localStringBuilder.toString();
      paramMap = jqc.a(BaseApplicationImpl.getContext(), paramJSONObject, "GET", null, paramMap);
      if (paramMap == null)
      {
        QLog.e("Q.readinjoy.fast_web", 2, "requestAdData bytes null");
        return null;
      }
      paramJSONObject = new String(paramMap);
      paramMap = paramJSONObject;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.fast_web", 2, "requestAdData result:" + paramJSONObject);
        return paramJSONObject;
      }
    }
    catch (Exception paramMap)
    {
      paramMap = null;
    }
    return paramMap;
  }
  
  private static Map<String, String> a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    paramString5 = (QQAppInterface)kxm.getAppRuntime();
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
    for (paramString1 = "";; paramString1 = msg.ej(paramString6))
    {
      paramString5.put("token", paramString1);
      paramString5.put("cookie", jzk.cZ());
      paramString5.put("scene", String.valueOf(3));
      paramString5.put("rowkey", paramString2);
      paramString5.put("source_channel_id", String.valueOf(paramLong));
      if (paramInt2 > 0) {
        paramString5.put("contentCount", String.valueOf(paramInt2));
      }
      paramString1 = f(BaseApplication.getContext());
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
        return paramString5;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return paramString5;
  }
  
  private static JSONObject a(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      String str;
      try
      {
        localObject1 = new tlm.a();
        ((tlm.a)localObject1).aJy = "ce2d9f";
        localObject1 = tlm.a(BaseApplication.getContext(), (tlm.a)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((tlm.b)localObject1).b;
          localJSONObject.put("muidtype", 1);
          str = kms.it();
          if (!TextUtils.isEmpty(str)) {
            break label618;
          }
          localObject2 = "0000000000000000";
          localJSONObject.put("muid", localObject2);
          localJSONObject.put("carrier", tln.ac(BaseApplicationImpl.getContext()));
          localJSONObject.put("c_os", "android");
          localJSONObject.put("appid", String.valueOf(AppSetting.getAppId()));
          localJSONObject.put("app_version_id", AppSetting.getAppId());
          localJSONObject.put("imei", str);
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
            localJSONObject.put("bytes_wx_ver", kms.T(BaseApplication.getContext()));
            if (QLog.isColorLevel()) {
              QLog.i("FastWebRequestUtil", 2, "makePhoneInfo0x6cf: deviceInfo: oa=" + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).oaid.get() + ", ta=" + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
            }
          }
          localObject1 = Build.BRAND;
          localObject2 = Build.MODEL;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localJSONObject.put("c_mf", localObject1);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localJSONObject.put("c_device", localObject2);
          }
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = new JSONArray(paramString);
            localObject1 = new JSONArray();
            int i = 0;
            if (i < paramString.length())
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("qie_context", paramString.getJSONObject(i).toString());
              ((JSONArray)localObject1).put(localObject2);
              i += 1;
              continue;
              localObject2 = ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get();
              continue;
            }
            if (((JSONArray)localObject1).length() > 0) {
              localJSONObject.put("pos", localObject1);
            }
          }
          localJSONObject.put("present_from", paramInt);
          if (anwa.aze()) {
            localJSONObject.put("reqLearningPatternFlag", 1);
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
      label618:
      Object localObject2 = str;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, ProteusItemData paramProteusItemData, int paramInt, SparseArray<Float> paramSparseArray)
  {
    if ((paramArticleInfo == null) || (paramProteusItemData == null) || (paramProteusItemData.aD == null)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = paramProteusItemData.aD.optJSONObject("card_info");
      if (localJSONObject != null)
      {
        localJSONObject.put("channelID", paramArticleInfo.mChannelID);
        localJSONObject.put("strategyId", paramArticleInfo.mStrategyId);
        localJSONObject.put("algorithmID", paramArticleInfo.mAlgorithmID);
        localJSONObject.put("articleTitle", paramArticleInfo.mTitle);
        localJSONObject.put("articleRowKey", paramArticleInfo.innerUniqueID);
      }
      for (;;)
      {
        Object localObject;
        paramProteusItemData.kC = localObject;
        paramProteusItemData.mModuleType = paramInt;
        return;
        float f1 = nmx.b(paramSparseArray);
        continue;
        f1 = nmx.c(paramSparseArray);
        continue;
        float f2 = -1000.0F;
        f1 = f2;
        switch (paramInt)
        {
        }
        f1 = f2;
      }
      return;
    }
    catch (Exception paramArticleInfo) {}
  }
  
  public static void a(ArticleInfo paramArticleInfo, nrl.a parama)
  {
    if (paramArticleInfo == null) {
      return;
    }
    QLog.d("FastWebRequestUtil", 2, "deleteFeeds.");
    ThreadManager.excute(new FastWebRequestUtil.6(paramArticleInfo, parama), 128, null, true);
  }
  
  public static void a(String paramString, FastWebArticleInfo paramFastWebArticleInfo)
  {
    QLog.d("Q.readinjoy.fast_web", 2, "" + paramString);
    try
    {
      l = I(paramString);
      if (l == -1L) {
        return;
      }
      paramString = new Bundle();
      paramString.putString("articleId", String.valueOf(l));
      QLog.d("Q.readinjoy.fast_web", 2, "" + "https://c.mp.qq.com/review/img-txt-comment/list?source=1" + "  articleId " + l);
      Bundle localBundle = new Bundle();
      jqc.an(localBundle);
      paramString = new String(jqc.a(BaseApplicationImpl.getContext(), "https://c.mp.qq.com/review/img-txt-comment/list?source=1", "POST", paramString, localBundle));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        long l;
        int i;
        paramFastWebArticleInfo = null;
      }
    }
    try
    {
      QLog.d("Q.readinjoy.fast_web", 2, "https://c.mp.qq.com/review/img-txt-comment/list?source=1" + "  articleId " + l + " " + paramString);
      i = new JSONObject(paramString).getInt("readCount");
      if (i > paramFastWebArticleInfo.xK)
      {
        paramFastWebArticleInfo.xK = i;
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.5());
        return;
      }
    }
    catch (Exception localException)
    {
      paramFastWebArticleInfo = paramString;
      paramString = localException;
      QLog.e("Q.readinjoy.fast_web", 2, paramString, new Object[] { "" + paramFastWebArticleInfo });
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, int paramInt1, long paramLong, nnc.c paramc, int paramInt2)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebRequestUtil.4(paramString1, paramString2, paramString3, paramString4, paramString6, paramString7, paramBoolean, paramInt1, paramLong, paramString5, paramInt2, paramc));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, nnc.b paramb, int paramInt1, int paramInt2, long paramLong)
  {
    paramb = new nnc.a(paramString1, paramb);
    a(paramString1, paramString2, paramString3, new nnd(paramb), paramInt2);
    a(paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5, paramString6, paramString7, paramInt1, paramLong, new nne(paramb), paramInt2);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, nnc.c paramc, int paramInt)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebRequestUtil.3(paramString3, paramString1, paramString2, paramInt, paramc));
  }
  
  private static boolean a(String paramString1, String paramString2, List<BaseData> paramList, JSONObject paramJSONObject)
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
        jzk.lA(((JSONObject)localObject).optString("cookie"));
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
            localObject = a(knb.a((JSONObject)localObject, paramJSONObject), 1, false, str, i, k);
            knd.b((AdData)localObject);
            if (localObject != null)
            {
              ((AdData)localObject).ato = false;
              paramList.add(localObject);
            }
          }
          else
          {
            i = ((JSONObject)localObject).getInt("ad_pos_type");
            if (i == 1)
            {
              ((JSONObject)localObject).put("rowkey", paramString2);
              localObject = a(knb.a((JSONObject)localObject, paramJSONObject), 1, true, str, -1, k);
              knd.b((AdData)localObject);
              if (localObject == null) {
                break label439;
              }
              ((AdData)localObject).ato = false;
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
      localObject = a(knb.a((JSONObject)localObject, paramJSONObject), 2, false, str, -1, k);
      if (localObject != null)
      {
        ((AdData)localObject).ato = true;
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
        if (((localBaseData instanceof ProteusInnerData)) && (((ProteusInnerData)localBaseData).zG()))
        {
          i = 1;
          break label448;
        }
      }
      else
      {
        if (((localObject instanceof ProteusInnerData)) && (((ProteusInnerData)localObject).zG()))
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
  
  private static List<BaseData> b(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Object localObject4;
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("data");
        int i = 0;
        Object localObject1 = null;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          if ((paramInt != 6) || (i == 0)) {}
          try
          {
            localJSONObject.put("label_separator_line_top_bg_color", localJSONObject.optString("label_separator_line_top_bg_color", "#E5E5E5"));
            Object localObject2;
            if ((localJSONObject.opt("id_recommend_category_txt") != null) && (localJSONObject.opt("kd_ug_download_url") != null))
            {
              localObject4 = localJSONObject.optString("kd_ug_download_url");
              localObject2 = localJSONObject.getJSONObject("id_recommend_category_txt");
              ((JSONObject)localObject2).put("text_color", "#FF4A2D");
              ((JSONObject)localObject2).put("label_ug_progress_bgcolor", "#FFE9E9");
              ((JSONObject)localObject2).put("label_ug_progress_fgcolor", "#FFCECE");
              if (!aqiz.O(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0"))
              {
                ((JSONObject)localObject2).put("text", "前往快报阅读");
                ((JSONObject)localObject2).put("label_ug_progress_progress", 100);
              }
            }
            else
            {
              localObject2 = npi.a("native_article", true);
              if (localObject2 == null) {
                break label634;
              }
              localObject2 = ((npi)localObject2).getTemplateBean(localJSONObject);
              if (localObject2 != null)
              {
                localObject4 = a(paramInt);
                localObject1 = localObject4;
                if (localObject4 != null)
                {
                  ((ProteusItemData)localObject4).mTemplateBean = ((TemplateBean)localObject2);
                  ((ProteusItemData)localObject4).aD = localJSONObject;
                  localArrayList.add(localObject4);
                  localObject1 = localObject4;
                }
              }
              nna.a(localObject1);
              i += 1;
              continue;
              if (i != localJSONArray.length() - 1) {
                continue;
              }
              localJSONObject.put("label_separator_line_bottom_bg_color", localJSONObject.optString("label_separator_line_bottom_bg_color", "#E5E5E5"));
              continue;
            }
          }
          catch (Exception localException2)
          {
            QLog.d("FastWebRequestUtil", 1, "parseProteusItem msg=" + localException2);
            continue;
          }
        }
        localObject4 = arvv.a().e((String)localObject4);
      }
      catch (Exception localException1)
      {
        QLog.e("FastWebRequestUtil", 1, new Object[] { "parseProteusData error:", localException1.toString(), " item:" + paramString });
        QLog.d("FastWebRequestUtil", 1, "parseProteusItem,type=" + paramInt + " item=" + paramString + " datasSize=" + localArrayList.size());
        return localArrayList;
      }
      if (localObject4 == null)
      {
        localException2.put("text", "下载快报阅读");
        localException2.put("label_ug_progress_progress", 0);
      }
      else if (((DownloadInfo)localObject4).getState() == 4)
      {
        localException2.put("text", "安装快报阅读");
        localException2.put("label_ug_progress_progress", 100);
      }
      else if ((((DownloadInfo)localObject4).getState() == 20) || (((DownloadInfo)localObject4).getState() == 1) || (((DownloadInfo)localObject4).getState() == 2))
      {
        localException2.put("text", "下载中..." + ((DownloadInfo)localObject4).progress + "%");
        localException2.put("label_ug_progress_progress", ((DownloadInfo)localObject4).progress);
      }
      else
      {
        localException2.put("text", "下载已暂停");
        localException2.put("label_ug_progress_progress", ((DownloadInfo)localObject4).progress);
        continue;
        label634:
        Object localObject3 = null;
      }
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, nrl.a parama)
  {
    if (paramArticleInfo == null) {
      return;
    }
    QLog.d("FastWebRequestUtil", 2, "shieldFeedSource");
    ThreadManager.excute(new FastWebRequestUtil.7(paramArticleInfo, parama), 128, null, true);
  }
  
  public static List<BaseData> e(int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = localArrayList;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      localObject = localArrayList;
      if (paramList.hasNext()) {
        localObject = b(paramInt, (String)paramList.next());
      }
    }
    return localObject;
  }
  
  public static String f(String paramString, boolean paramBoolean)
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
  
  public static Map<String, String> f(Context paramContext)
  {
    if (eH != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastWebRequestUtil", 2, "getDisplayParams : " + eH);
      }
      return eH;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = npi.a("native_article", true);
    if (localObject1 == null) {
      return localHashMap;
    }
    localObject1 = ((npi)localObject1).getTemplate("ReadInjoy_article_text_cell");
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
      int i = (int)nmy.getTextSize();
      int i1 = Utils.dp2px(Integer.valueOf(str2).intValue());
      int j = Utils.dp2px(Integer.valueOf((String)localObject1).intValue());
      int k = Utils.dp2px(Integer.valueOf(str1).intValue());
      int m = ankt.aC(paramContext);
      int n = ankt.aD(paramContext);
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
        eH = localHashMap;
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
  
  public static class a
  {
    private nnc.b a;
    private final String articleId;
    private List<BaseData> kp = new ArrayList();
    private List<BaseData> kq = new ArrayList();
    
    public a(String paramString, nnc.b paramb)
    {
      this.a = paramb;
      this.articleId = paramString;
    }
    
    private void Gr()
    {
      try
      {
        if ((this.kq != null) && (this.kp != null) && (this.a != null)) {
          this.a.c(true, this.articleId, this.kp, this.kq);
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void dc(List<BaseData> paramList)
    {
      this.kq = paramList;
      Gr();
    }
    
    public void dd(List<BaseData> paramList)
    {
      this.kp = paramList;
      Gr();
    }
  }
  
  public static abstract interface b
  {
    public abstract void c(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2);
  }
  
  public static abstract interface c
  {
    public abstract void q(boolean paramBoolean, List<BaseData> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnc
 * JD-Core Version:    0.7.0.1
 */