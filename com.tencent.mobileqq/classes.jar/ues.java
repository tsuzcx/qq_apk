import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.util.ProteusReportUtil.1;
import com.tencent.biz.pubaccount.util.ProteusReportUtil.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ues
{
  private static Set<String> a = ;
  
  public static List<String> a(TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null) {
      return null;
    }
    Object localObject = paramTemplateBean.getDataAttribute(null).get("extra_expose");
    if (localObject != null)
    {
      paramTemplateBean = new ArrayList();
      try
      {
        localObject = (JSONArray)localObject;
        if (((JSONArray)localObject).length() > 0)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            paramTemplateBean.add(((JSONArray)localObject).getJSONObject(i).getString("view_id"));
            i += 1;
          }
          return paramTemplateBean;
        }
      }
      catch (Exception paramTemplateBean)
      {
        QLog.d("ProteusReportUtil", 1, "getReportMultViewId", paramTemplateBean);
      }
    }
    return null;
  }
  
  private static Set<String> a()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("ReadInjoy_double_video_cell");
    localHashSet.add("ReadInjoy_zhitiao_view");
    return localHashSet;
  }
  
  public static void a(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("action");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramInt + "");
    localArrayList.add(localObject);
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("bid");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramString + "");
    localArrayList.add(localObject);
    localObject = nny.a(paramString) + "";
    if (paramInt != 1)
    {
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(3);
      localAttributeList.att_name.set("version");
      localAttributeList.att_value.set((String)localObject);
      localArrayList.add(localAttributeList);
    }
    paramString = paramString + (String)localObject;
    if (3 == paramInt)
    {
      if (((Boolean)bkwm.a(paramString, Boolean.valueOf(false))).booleanValue()) {
        return;
      }
      bkwm.a(paramString, Boolean.valueOf(true));
    }
    ugf.a(200, localArrayList);
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = pay.d(paramArticleInfo);
    try
    {
      localObject = pay.a(paramArticleInfo.mAlgorithmID, pay.a(paramArticleInfo), paramInt, NetworkUtil.isWifiConnected(null), (String)localObject, paramArticleInfo.innerUniqueID, pay.f(paramArticleInfo), 0, pay.d(), paramArticleInfo);
      if ((paramMap != null) && (paramMap.entrySet() != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while ((paramMap != null) && (paramMap.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          odq.a(null, pay.d(paramArticleInfo), paramString1, paramString2, 0, 0, phd.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramMap, false);
        }
      }
    }
    catch (Exception paramMap)
    {
      AIOUtils.catchedExceptionInReleaseV2("ProteusReportUtil", "reportClickEvent", new IllegalArgumentException(paramMap));
      paramMap = null;
    }
    for (;;)
    {
      uhz.a(paramArticleInfo, paramInt);
      return;
      paramMap = ((JSONObject)localObject).toString();
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mProteusTemplateBean == null) || (paramBaseArticleInfo.mProteusTemplateBean.getData() == null)) {
      QLog.d("ProteusReportUtil", 1, "ExposeReport UG is null");
    }
    do
    {
      do
      {
        return;
        paramBaseArticleInfo = paramBaseArticleInfo.mProteusTemplateBean;
      } while (paramBaseArticleInfo == null);
      paramBaseArticleInfo = paramBaseArticleInfo.getDataAttribute(null).get("ug_expose_report_url");
    } while (!(paramBaseArticleInfo instanceof JSONArray));
    a((JSONArray)paramBaseArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    paramBaseArticleInfo = rbt.a(paramBaseArticleInfo);
    if (paramBaseArticleInfo == null) {}
    for (;;)
    {
      return;
      paramBaseArticleInfo = paramBaseArticleInfo.iterator();
      while (paramBaseArticleInfo.hasNext())
      {
        String str = (String)paramBaseArticleInfo.next();
        str = str + "&acttype=" + paramInt;
        QLog.d("ProteusReportUtil", 1, "UG report url : " + str);
        ThreadManager.executeOnNetWorkThread(new ProteusReportUtil.2(str));
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (a.contains(paramString3)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("bid", paramString1);
    localHashMap.put("business_name", paramString2);
    localHashMap.put("style_id", paramString3);
    localHashMap.put("uin", pay.a());
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianProteusShowFail", false, 0L, 0L, localHashMap, null);
  }
  
  public static void a(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      QLog.d("ProteusReportUtil", 1, "handleUgClickReport UG is null");
    }
    for (;;)
    {
      return;
      if (a()) {}
      for (paramMap = paramMap.get("ug_click_schema_url"); (paramMap instanceof JSONArray); paramMap = paramMap.get("ug_click_default_url"))
      {
        a((JSONArray)paramMap);
        return;
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      QLog.d("ProteusReportUtil", 1, "handleHttpRequest jsarray is null");
      return;
    }
    ThreadManager.executeOnNetWorkThread(new ProteusReportUtil.1(paramJSONArray));
  }
  
  public static void a(JSONObject paramJSONObject, Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (paramMap.entrySet() != null))
    {
      paramMap = paramMap.entrySet().iterator();
      for (;;)
      {
        if (paramMap != null) {
          try
          {
            if (paramMap.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramMap.next();
              paramJSONObject.put((String)localEntry.getKey(), localEntry.getValue().toString());
            }
          }
          catch (JSONException paramJSONObject)
          {
            QLog.d("ProteusReportUtil", 1, "", paramJSONObject);
          }
        }
      }
    }
  }
  
  private static boolean a()
  {
    return bfwv.a(BaseApplicationImpl.getContext(), "com.tencent.weishi");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ues
 * JD-Core Version:    0.7.0.1
 */