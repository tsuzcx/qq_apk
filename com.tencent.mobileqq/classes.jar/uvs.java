import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.3;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.4;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class uvs
{
  public static int a;
  public static long a;
  public static String a;
  public static Map<Long, Pair<Long, Long>> a;
  private static boolean a;
  public static int b;
  public static final Map<Long, Map<Long, uvx>> b;
  private static boolean b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static volatile int h;
  private static int i;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    c = 1;
    d = 2;
    e = 10;
    f = 11;
    g = 12;
    pwf.a(new uvt());
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_Boolean = true;
  }
  
  public static int a()
  {
    switch ()
    {
    default: 
      return 1;
    case 1: 
      return 4;
    case 2: 
      return 3;
    }
    return 5;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int k = 0;
    int j = k;
    if ((paramBaseArticleInfo instanceof ArticleInfo))
    {
      j = k;
      if (!ppe.q((ArticleInfo)paramBaseArticleInfo)) {
        j = 1;
      }
    }
    return j;
  }
  
  public static Pair<Long, Long> a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return (Pair)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public static String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", omx.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("channel_id", pin.b());
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Other";
    case 2: 
      return "KDTAB";
    case 4: 
      return "MsgTab";
    case 3: 
      return "FromDTTab";
    case 5: 
      return "Lock";
    }
    return "Daily";
  }
  
  public static String a(long paramLong)
  {
    if ((plm.a((int)paramLong)) || (bmhv.a(paramLong))) {
      return "0X8009CCB";
    }
    if (a(paramLong)) {
      return "0X8009356";
    }
    return "0X8009332";
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", pih.a(paramContext));
      localJSONObject.put("version", omx.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("ads_source", paramInt1);
      localJSONObject.put("card_pos ", paramInt2);
      localJSONObject.put("os", "1");
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("feeds_type", paramInt3);
      localJSONObject.put("is_ugc_as_pgc", paramInt4);
      if (TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("video_report_info", "");
      }
      for (;;)
      {
        return localJSONObject.toString();
        localJSONObject.put("video_report_info", paramString2);
      }
      return "";
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyReportUtils", 2, "getSmallVideoPolymericR5Str:" + paramContext.toString());
      }
    }
  }
  
  public static String a(Context paramContext, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", pih.a(paramContext));
      localJSONObject.put("channel_id", paramInt2);
      localJSONObject.put("version", omx.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("vid", paramString2);
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("algorithm_id", paramLong2);
      localJSONObject.put("feeds_type", paramInt1);
      localJSONObject.put("star_logo", "0");
      localJSONObject.put("is_ugc_as_pgc", paramInt3);
      localJSONObject.put("r_session_id", jdField_a_of_type_JavaLangString);
      paramContext = a(paramLong1);
      if (paramContext != null)
      {
        localJSONObject.put("r_session_position", paramContext.first);
        localJSONObject.put("r_session_ispush", paramContext.second);
      }
      if (TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("video_report_info", "");
      }
      for (;;)
      {
        if (plm.c(paramInt2))
        {
          paramLong1 = ((Long)bmhv.a("readinjoy_daily_article_first_exposure_" + paramLong1, Long.valueOf(0L))).longValue();
          if (paramLong1 != 0L) {
            localJSONObject.put("daily_article_first_timestamp", paramLong1 + "");
          }
        }
        omx.a(localJSONObject);
        return localJSONObject.toString();
        localJSONObject.put("video_report_info", paramString3);
      }
      return "";
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyReportUtils", 2, "getSmallVideoWrapperPolymericR5Str:" + paramContext.toString());
      }
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo, String paramString, int paramInt)
  {
    String str = paramString;
    if (paramArticleInfo != null) {
      str = paramString + "&last_rowkey=" + paramArticleInfo.innerUniqueID + "&last_scene_type=" + paramInt;
    }
    return str;
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = "";
    if (paramBaseArticleInfo != null) {
      str = "" + paramBaseArticleInfo.innerUniqueID;
    }
    return str;
  }
  
  public static String a(TemplateBean paramTemplateBean, String paramString1, String paramString2)
  {
    if ((paramTemplateBean == null) || (paramString2 == null)) {}
    do
    {
      do
      {
        return null;
        paramTemplateBean = paramTemplateBean.getDataAttribute(paramString1);
      } while (paramTemplateBean == null);
      paramTemplateBean = paramTemplateBean.get(paramString2);
    } while (paramTemplateBean == null);
    return paramTemplateBean.toString();
  }
  
  public static Map<Long, uvx> a(int paramInt)
  {
    Map localMap1 = jdField_b_of_type_JavaUtilMap;
    long l = paramInt;
    try
    {
      Map localMap2 = a(l);
      jdField_b_of_type_JavaUtilMap.remove(Long.valueOf(paramInt));
      return localMap2;
    }
    finally {}
  }
  
  public static Map<Long, uvx> a(long paramLong)
  {
    synchronized (jdField_b_of_type_JavaUtilMap)
    {
      Map localMap1 = (Map)jdField_b_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      Object localObject1 = localMap1;
      if (localMap1 == null)
      {
        localObject1 = new HashMap();
        jdField_b_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localObject1);
      }
      return localObject1;
    }
  }
  
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo, int paramInt, boolean paramBoolean)
  {
    localJSONObject = new JSONObject();
    if (paramBaseArticleInfo != null) {}
    try
    {
      localJSONObject.put("app_type", c());
      localJSONObject.put("channel_id", paramBaseArticleInfo.mChannelID);
      localJSONObject.put("scene_type", paramInt);
      if (paramBoolean)
      {
        paramInt = 1;
        localJSONObject.put("is_intensify", paramInt);
        localJSONObject.put("feeds_type", pqw.a(paramBaseArticleInfo));
        localJSONObject.put("rowkey", paramBaseArticleInfo.innerUniqueID);
        localJSONObject.put("puin", paramBaseArticleInfo.getSubscribeUin());
        if ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy == null)) {
          break label171;
        }
      }
      label171:
      for (long l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;; l = 0L)
      {
        localJSONObject.put("ugcuin", l);
        localJSONObject.put("algorithm_id", paramBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("button_type", paramBaseArticleInfo.showFollowButtonType);
        return localJSONObject;
        paramInt = 0;
        break;
      }
      return localJSONObject;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.d("ReadinjoyReportUtils", 1, paramBaseArticleInfo.getMessage());
    }
  }
  
  public static pqg a(TemplateBean paramTemplateBean, String paramString)
  {
    if (paramTemplateBean == null) {
      return null;
    }
    pqg localpqg = new pqg();
    if (paramTemplateBean != null)
    {
      paramTemplateBean = paramTemplateBean.getDataAttribute(paramString);
      if ((paramTemplateBean != null) && (paramTemplateBean.entrySet() != null))
      {
        paramTemplateBean = paramTemplateBean.entrySet().iterator();
        while ((paramTemplateBean != null) && (paramTemplateBean.hasNext()))
        {
          paramString = (Map.Entry)paramTemplateBean.next();
          localpqg.b((String)paramString.getKey(), paramString.getValue().toString());
        }
      }
    }
    return localpqg;
  }
  
  public static void a()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("FolderStatus");
    localAttributeList.att_value.set(prp.jdField_a_of_type_Int + "");
    localArrayList.add(localAttributeList);
    uuc.a(10, localArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyReportUtils", 2, "reportKandianDelete  , foldStatus :  " + prp.jdField_a_of_type_Int);
    }
  }
  
  public static void a(int paramInt)
  {
    i |= paramInt;
    pwb.e(3);
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong, HashMap<String, Object> paramHashMap)
  {
    pqg localpqg = pqf.a();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = String.valueOf(((Map.Entry)localObject).getKey());
        localObject = String.valueOf(((Map.Entry)localObject).getValue());
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localpqg.b(str, (String)localObject);
        }
      }
    }
    paramHashMap = localpqg.a();
    QLog.d("ReadinjoyReportUtils", 1, "reportQualityDataDimension id = " + paramInt2 + " resultCode = " + paramInt1 + " cost = " + paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyReportUtils", 2, "reportQualityDataDimension id = " + paramInt2 + " r5String = " + paramHashMap);
    }
    olh.a(null, "", "0X800ACB9", "0X800ACB9", paramInt2, 0, String.valueOf(paramInt1), String.valueOf(paramLong), "", paramHashMap, false);
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, int paramInt3)
  {
    a(paramInt1, paramInt2, paramActivity, false, paramInt3);
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, boolean paramBoolean, int paramInt3)
  {
    QLog.d("ReadinjoyReportUtils", 2, " type : " + paramInt1);
    if (paramInt1 == 0) {}
    do
    {
      return;
      if ((!jdField_b_of_type_Boolean) && (3 == paramInt1))
      {
        a(true);
        return;
      }
    } while (paramInt2 == 40677);
    switch (paramInt1)
    {
    }
    for (paramBoolean = true;; paramBoolean = true)
    {
      a(paramInt2, paramActivity, paramBoolean, paramInt3);
      return;
    }
  }
  
  private static void a(int paramInt1, Activity paramActivity, boolean paramBoolean, int paramInt2)
  {
    ThreadManager.executeOnSubThread(new ReadinjoyReportUtils.3(paramInt1, paramActivity, paramBoolean, paramInt2));
  }
  
  public static void a(int paramInt1, ToServiceMsg paramToServiceMsg, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    QLog.d("ReadinjoyReportUtils", 1, "reportQuality id = " + paramInt2);
    if (paramToServiceMsg == null)
    {
      QLog.e("ReadinjoyReportUtils", 1, "reportQuality req = null ");
      return;
    }
    long l = 0L;
    if (paramToServiceMsg.extraData != null) {
      l = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey");
    }
    a(paramInt1, paramInt2, l, paramHashMap);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Resources paramResources)
  {
    if ((paramInt == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(paramString1)))
    {
      if (!bhbx.a(paramString2, paramResources.getString(alhd.a[3]))) {
        break label57;
      }
      olh.a(null, null, "0X8009884", "0X8009884", 0, 0, "", "", "", a(), false);
    }
    label57:
    while (!bhbx.a(paramString2, paramResources.getString(alhd.a[2]))) {
      return;
    }
    olh.a(null, null, "0X8009885", "0X8009885", 0, 0, "", "", "", a(), false);
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(paramString)))
    {
      if (paramBoolean) {
        olh.a(null, null, "0X8009884", "0X8009884", 0, 0, "", "", "", a(), false);
      }
    }
    else {
      return;
    }
    olh.a(null, null, "0X8009885", "0X8009885", 0, 0, "", "", "", a(), false);
  }
  
  public static void a(int paramInt1, boolean paramBoolean, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramBoolean, paramLong, paramInt2, paramInt3, true);
  }
  
  public static void a(int paramInt1, boolean paramBoolean1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    pwb.a().jdField_a_of_type_Pwq.a(paramBoolean1);
    long l;
    if (paramBoolean1)
    {
      pwb.n();
      pwf.a(4);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("EnterType");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(a(paramInt1));
      localArrayList.add(localObject);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(2);
      localAttributeList.att_name.set("FolderStatus");
      PBStringField localPBStringField = localAttributeList.att_value;
      if (paramInt1 == 0)
      {
        localObject = "1024";
        localPBStringField.set((String)localObject);
        localArrayList.add(localAttributeList);
        if (prp.jdField_a_of_type_Int != 1)
        {
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("StrategyID");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(prp.jdField_a_of_type_Rpn.b);
          localArrayList.add(localObject);
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(4);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("AlgorithmID");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(prp.jdField_a_of_type_Rpn.jdField_a_of_type_JavaLangString);
          localArrayList.add(localObject);
          paramLong = NetConnInfoCenter.getServerTime();
          l = prp.jdField_a_of_type_Rpn.jdField_a_of_type_Long;
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("costtime");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + (paramLong - l));
          localArrayList.add(localObject);
        }
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(6);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("durationBeforeEnter");
        if (pwb.a().d() <= 0L) {
          break label483;
        }
      }
      label483:
      for (paramLong = System.currentTimeMillis() - pwb.a().d();; paramLong = System.currentTimeMillis() - pwb.jdField_a_of_type_Long)
      {
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramLong + "");
        localArrayList.add(localObject);
        paramInt2 = 4;
        uuc.a(paramInt2, localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("ReadinjoyReportUtils", 2, "report kandian exit or enter ! from : " + paramInt1);
        }
        return;
        localObject = prp.jdField_a_of_type_Int + "";
        break;
      }
    }
    if (paramBoolean2) {
      pwf.a();
    }
    Object localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("ExitType");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(a(paramInt1));
    localArrayList.add(localObject);
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("FolderStatus");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(paramInt2));
    localArrayList.add(localObject);
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("Time");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(pwb.a(paramLong)));
    localArrayList.add(localObject);
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(4);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("OperationBitmap");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramInt3 + "");
    localArrayList.add(localObject);
    if (prp.jdField_a_of_type_Rpn.jdField_a_of_type_Int != 1)
    {
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("StrategyID");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(prp.jdField_a_of_type_Rpn.b);
      localArrayList.add(localObject);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(6);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("AlgorithmID");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(prp.jdField_a_of_type_Rpn.jdField_a_of_type_JavaLangString);
      localArrayList.add(localObject);
      paramLong = NetConnInfoCenter.getServerTime();
      l = prp.jdField_a_of_type_Rpn.jdField_a_of_type_Long;
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(7);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("costtime");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + (paramLong - l));
      localArrayList.add(localObject);
    }
    localObject = pwb.a().b;
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(8);
    localAttributeList.att_name.set("staticDurationAfterEnter");
    if (((pwq)localObject).jdField_a_of_type_Long > 0L)
    {
      paramLong = ((pwq)localObject).jdField_a_of_type_Long - ((pwq)localObject).d;
      label971:
      localAttributeList.att_value.set(paramLong + "");
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(9);
      localAttributeList.att_name.set("staticDurationBeforeExit");
      if (((pwq)localObject).c <= 0L) {
        break label1206;
      }
    }
    label1206:
    for (paramLong = ((pwq)localObject).e - ((pwq)localObject).c;; paramLong = 0L)
    {
      localAttributeList.att_value.set(paramLong + "");
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(10);
      localAttributeList.att_name.set("articleInfoList");
      localAttributeList.att_value.set(((pwq)localObject).a());
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(11);
      localAttributeList.att_name.set("scrollInfoList");
      localAttributeList.att_value.set(((pwq)localObject).b());
      localArrayList.add(localAttributeList);
      paramInt2 = 5;
      break;
      paramLong = 0L;
      break label971;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    Object localObject2 = "";
    Object localObject1;
    if ((ppe.g(paramArticleInfo)) || (ppe.i(paramArticleInfo)) || (ppe.j(paramArticleInfo)) || (ppe.k(paramArticleInfo)))
    {
      localObject1 = localObject2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        localObject1 = localObject2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null) {
          localObject1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long);
        }
      }
    }
    for (;;)
    {
      long l1 = paramArticleInfo.mFeedId;
      long l2 = paramArticleInfo.mArticleID;
      long l3 = paramArticleInfo.mStrategyId;
      int j = ppe.d(paramArticleInfo);
      localObject2 = new JSONObject();
      try
      {
        pqf.a((JSONObject)localObject2, paramArticleInfo);
        ((JSONObject)localObject2).put("touin", localObject1);
        ((JSONObject)localObject2).put("entry_mode", String.valueOf(j));
        olh.a(null, "", "0X8009846", "0X8009846", 0, 0, String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), ((JSONObject)localObject2).toString(), false);
        return;
        localObject1 = paramArticleInfo.mSubscribeID;
      }
      catch (Exception paramArticleInfo)
      {
        for (;;)
        {
          paramArticleInfo.printStackTrace();
        }
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramArticleInfo, paramInt, false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if (paramArticleInfo != null) {
      localJSONObject = a(paramArticleInfo, paramInt, paramBoolean);
    }
    try
    {
      if (qrm.a(paramArticleInfo)) {}
      for (paramInt = 2;; paramInt = 1)
      {
        localJSONObject.put("click_type", paramInt);
        olh.a(null, null, "0X800B1A7", "0X800B1A7", 0, 0, "", "", "", localJSONObject.toString(), false);
        return;
      }
      return;
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.d("ReadinjoyReportUtils", 1, paramArticleInfo.getMessage());
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.bindShowFollowButton)) {
      olh.a(null, null, "0X800B1A6", "0X800B1A6", 0, 0, "", "", "", a(paramBaseArticleInfo, paramInt, paramBoolean).toString(), false);
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, long paramLong)
  {
    if (((Long)bmhv.a("readinjoy_daily_article_first_exposure_" + paramBaseArticleInfo.mArticleID, Long.valueOf(0L))).longValue() == 0L) {
      bmhv.a("readinjoy_daily_article_first_exposure_" + paramBaseArticleInfo.mArticleID, Long.valueOf(System.currentTimeMillis() / 1000L));
    }
    synchronized (jdField_b_of_type_JavaUtilMap)
    {
      Map localMap2 = a(paramBaseArticleInfo.mChannelID);
      uvx localuvx = (uvx)localMap2.get(Long.valueOf(paramBaseArticleInfo.mArticleID));
      if (localuvx != null)
      {
        long l = paramLong;
        if (localuvx.jdField_a_of_type_Long > paramLong) {
          l = localuvx.jdField_a_of_type_Long;
        }
        localuvx.jdField_a_of_type_Long = l;
        return;
      }
      localuvx = new uvx(pqf.a());
      localuvx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      localuvx.jdField_a_of_type_Long = paramLong;
      localMap2.put(Long.valueOf(paramBaseArticleInfo.mArticleID), localuvx);
    }
  }
  
  public static void a(TemplateBean paramTemplateBean, String paramString1, String paramString2)
  {
    if ((paramTemplateBean == null) || (paramString2 == null)) {}
    pqg localpqg;
    do
    {
      return;
      localpqg = a(paramTemplateBean, paramString1);
      paramTemplateBean = a(paramTemplateBean, paramString1, paramString2);
    } while (paramTemplateBean == null);
    olh.a(null, "CliOper", "", "", paramTemplateBean, paramTemplateBean, 0, 0, "", "", "", localpqg.a(), false);
  }
  
  public static void a(RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (!jdField_a_of_type_Boolean) {}
    while ((paramRecentItemChatMsgData == null) || (paramRecentItemChatMsgData.mUser == null) || (!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramRecentItemChatMsgData.mUser.uin))) {
      return;
    }
    jdField_a_of_type_Boolean = false;
    ThreadManager.executeOnSubThread(new ReadinjoyReportUtils.4(paramRecentItemChatMsgData));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = (KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    pqg localpqg = new pqg();
    localpqg.b();
    localpqg.e();
    Object localObject = paramQQAppInterface.a();
    paramQQAppInterface = "";
    int j;
    if (localObject != null)
    {
      j = ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt;
      paramQQAppInterface = ((KandianMsgBoxRedPntInfo)localObject).mUin + "";
    }
    for (;;)
    {
      if (j > 0) {}
      try
      {
        localpqg.l(j);
        localpqg.b("message_reddot_style", pro.b());
        if (paramBoolean)
        {
          localObject = "0X8009A85";
          olh.a(null, paramQQAppInterface, (String)localObject, (String)localObject, 0, 0, "", "", "", localpqg.a(), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ReadinjoyReportUtils", 2, localJSONException, new Object[0]);
          continue;
          String str = "0X8009A84";
        }
      }
      j = 0;
    }
  }
  
  public static void a(String paramString)
  {
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString))
    {
      olh.a(null, null, "0X800978D", "0X800978D", 0, 0, "", "", "", a(), false);
      pwb.l();
    }
    while (!AppConstants.KANDIAN_DAILY_UIN.equals(paramString)) {
      return;
    }
    olh.a(null, null, "0X8009886", "0X8009886", 0, 0, "", "", "", a(), false);
    pwb.m();
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    int j = 1;
    oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
    localAttributeList1.att_id.set(1);
    localAttributeList1.att_name.set("BusiType");
    localAttributeList1.att_value.set(paramString);
    oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
    localAttributeList2.att_id.set(2);
    localAttributeList2.att_name.set("HasRedPnt");
    Object localObject = localAttributeList2.att_value;
    if (paramBoolean) {}
    for (;;)
    {
      ((PBStringField)localObject).set(String.valueOf(j));
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("Time");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(pwb.a(paramLong)));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localAttributeList1);
      localArrayList.add(localAttributeList2);
      localArrayList.add(localObject);
      uuc.a(2, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyReportUtils", 2, "report dt entry ! busiName : " + paramString + " , redDot : " + paramBoolean);
      }
      return;
      j = 0;
    }
  }
  
  public static void a(List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (Aladdin.getConfig(183).getIntegerFromString("allow_report", 0) == 0)
      {
        QLog.d("ReadinjoyReportUtils", 1, "reportRefreshArticleInfoFor64e config not allow!");
        return;
      }
      Collections.sort(paramList, new uvv());
      localArrayList = new ArrayList();
      int j = 0;
      while (j < paramList.size())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)paramList.get(j);
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mAlgorithmId = ((int)localArticleInfo.mAlgorithmID);
        localReportInfo.mStrategyId = localArticleInfo.mStrategyId;
        localReportInfo.mSourceArticleId = localArticleInfo.mArticleID;
        localReportInfo.mInnerId = localArticleInfo.innerUniqueID;
        localReportInfo.mServerContext = localArticleInfo.mServerContext;
        localReportInfo.mUin = pkh.a();
        localReportInfo.mChannelId = 0;
        localReportInfo.replyUin = j;
        localReportInfo.replyID = (NetConnInfoCenter.getServerTime() + "");
        localReportInfo.mSource = 3;
        localReportInfo.mOperation = 57;
        localArrayList.add(localReportInfo);
        j += 1;
      }
    } while (localArrayList.size() <= 0);
    pvj.a().a(localArrayList);
  }
  
  public static void a(List<ArticleInfo> paramList, List<Long> paramList1, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    Collections.sort(paramList, new uvu());
    paramList = paramList.iterator();
    label27:
    Map localMap;
    long l2;
    long l3;
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      if (paramList1.contains(Long.valueOf(localArticleInfo.mRecommendSeq)))
      {
        localMap = jdField_a_of_type_JavaUtilMap;
        l2 = localArticleInfo.mArticleID;
        l3 = jdField_a_of_type_Long;
        jdField_a_of_type_Long = l3 + 1L;
        if (!paramBoolean) {
          break label126;
        }
      }
    }
    label126:
    for (long l1 = 1L;; l1 = 0L)
    {
      localMap.put(Long.valueOf(l2), new Pair(Long.valueOf(l3), Long.valueOf(l1)));
      break label27;
      break;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    long l1 = 0L;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaUtilMap.clear();
    if (paramAppRuntime == null) {}
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      jdField_a_of_type_JavaLangString = String.valueOf(l1) + "_" + String.valueOf(l2);
      return;
      l1 = paramAppRuntime.getLongAccountUin();
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return h == 1;
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == 70L) || (paramLong == 41403L);
  }
  
  public static int b()
  {
    return i;
  }
  
  public static String b(long paramLong)
  {
    if ((plm.a((int)paramLong)) || (bmhv.a(paramLong))) {
      return "0X8009CC9";
    }
    if (a(paramLong)) {
      return "0X8009355";
    }
    return "0X8007625";
  }
  
  public static void b()
  {
    i = 0;
  }
  
  public static int c()
  {
    if (ReadinjoyTabFrame.d_()) {
      return jdField_a_of_type_Int;
    }
    if (ReadInJoyDailyFragment.a()) {
      return jdField_b_of_type_Int;
    }
    return c;
  }
  
  public static void c()
  {
    h = 1;
  }
  
  public static void d()
  {
    h = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvs
 * JD-Core Version:    0.7.0.1
 */