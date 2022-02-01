import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.util.ProteusReportUtil.1;
import com.tencent.biz.pubaccount.util.ProteusReportUtil.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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

public class obr
{
  private static Set<String> aw = ;
  
  private static boolean Gx()
  {
    return aqiz.isAppInstalled(BaseApplicationImpl.getContext(), "com.tencent.weishi");
  }
  
  public static void K(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      QLog.d("ProteusReportUtil", 1, "handleUgClickReport UG is null");
    }
    for (;;)
    {
      return;
      if (Gx()) {}
      for (paramMap = paramMap.get("ug_click_schema_url"); (paramMap instanceof JSONArray); paramMap = paramMap.get("ug_click_default_url"))
      {
        i((JSONArray)paramMap);
        return;
      }
    }
  }
  
  public static void M(String paramString1, String paramString2, String paramString3)
  {
    if (aw.contains(paramString3)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("bid", paramString1);
    localHashMap.put("business_name", paramString2);
    localHashMap.put("style_id", paramString3);
    localHashMap.put("uin", kxm.getAccount());
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianProteusShowFail", false, 0L, 0L, localHashMap, null);
  }
  
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
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = kxm.f(paramArticleInfo);
    try
    {
      localObject = kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), paramInt, aqiw.isWifiConnected(null), (String)localObject, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), 0, kxm.nQ(), paramArticleInfo);
      if ((paramMap != null) && (paramMap.entrySet() != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while ((paramMap != null) && (paramMap.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          kbp.a(null, kxm.f(paramArticleInfo), paramString1, paramString2, 0, 0, ndi.ay(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramMap, false);
        }
      }
    }
    catch (Exception paramMap)
    {
      wja.a("ProteusReportUtil", "reportClickEvent", new IllegalArgumentException(paramMap));
      paramMap = null;
    }
    for (;;)
    {
      odv.a.l(paramArticleInfo, paramInt);
      return;
      paramMap = ((JSONObject)localObject).toString();
    }
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
  
  public static void aE(int paramInt, String paramString)
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
    localObject = jpa.dL(paramString) + "";
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
      if (((Boolean)awit.f(paramString, Boolean.valueOf(false))).booleanValue()) {
        return;
      }
      awit.H(paramString, Boolean.valueOf(true));
    }
    ocp.y(200, localArrayList);
  }
  
  private static void i(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      QLog.d("ProteusReportUtil", 1, "handleHttpRequest jsarray is null");
      return;
    }
    ThreadManager.executeOnNetWorkThread(new ProteusReportUtil.1(paramJSONArray));
  }
  
  public static void k(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    paramBaseArticleInfo = mgn.a(paramBaseArticleInfo);
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
  
  public static void n(BaseArticleInfo paramBaseArticleInfo)
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
    i((JSONArray)paramBaseArticleInfo);
  }
  
  private static Set<String> u()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("ReadInjoy_double_video_cell");
    localHashSet.add("ReadInjoy_zhitiao_view");
    return localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obr
 * JD-Core Version:    0.7.0.1
 */