import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.3;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
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
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class odv
{
  private static int aIW;
  public static String acA;
  private static boolean awA = true;
  private static boolean awB = true;
  public static volatile int bew;
  public static long counter;
  public static Map<Long, Pair<Long, Long>> dT;
  public static final Map<Long, Map<Long, odv.b>> fb;
  
  static
  {
    lcm.d.a(new odw());
    acA = "";
    dT = new HashMap();
    fb = new HashMap();
  }
  
  public static boolean GF()
  {
    return bew == 1;
  }
  
  public static void J(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    Object localObject2 = "";
    Object localObject1;
    if ((ndi.ak(paramArticleInfo)) || (ndi.S(paramArticleInfo)) || (ndi.T(paramArticleInfo)) || (ndi.U(paramArticleInfo)))
    {
      localObject1 = localObject2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        localObject1 = localObject2;
        if (paramArticleInfo.mSocialFeedInfo.a != null) {
          localObject1 = Long.toString(paramArticleInfo.mSocialFeedInfo.a.cuin);
        }
      }
    }
    for (;;)
    {
      long l1 = paramArticleInfo.mFeedId;
      long l2 = paramArticleInfo.mArticleID;
      long l3 = paramArticleInfo.mStrategyId;
      int i = kxm.c(paramArticleInfo);
      localObject2 = new JSONObject();
      try
      {
        kxm.a((JSONObject)localObject2, paramArticleInfo);
        ((JSONObject)localObject2).put("touin", localObject1);
        ((JSONObject)localObject2).put("entry_mode", String.valueOf(i));
        kbp.a(null, "", "0X8009846", "0X8009846", 0, 0, String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), ((JSONObject)localObject2).toString(), false);
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
  
  public static void L(Map<Long, odv.b> paramMap)
  {
    c(paramMap, false);
  }
  
  public static Pair<Long, Long> a(long paramLong)
  {
    if (dT.containsKey(Long.valueOf(paramLong))) {
      return (Pair)dT.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", kvp.U(paramContext));
      localJSONObject.put("version", kct.XU);
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
      localJSONObject.put("network", kvp.U(paramContext));
      localJSONObject.put("channel_id", paramInt2);
      localJSONObject.put("version", kct.XU);
      localJSONObject.put("os", "1");
      localJSONObject.put("vid", paramString2);
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("algorithm_id", paramLong2);
      localJSONObject.put("feeds_type", paramInt1);
      localJSONObject.put("star_logo", "0");
      localJSONObject.put("is_ugc_as_pgc", paramInt3);
      localJSONObject.put("r_session_id", acA);
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
        if (kys.dv(paramInt2))
        {
          paramLong1 = ((Long)awit.f("readinjoy_daily_article_first_exposure_" + paramLong1, Long.valueOf(0L))).longValue();
          if (paramLong1 != 0L) {
            localJSONObject.put("daily_article_first_timestamp", paramLong1 + "");
          }
        }
        kct.e(localJSONObject);
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
  
  public static Map<Long, odv.b> a(int paramInt)
  {
    Map localMap1 = fb;
    long l = paramInt;
    try
    {
      Map localMap2 = a(l);
      fb.remove(Long.valueOf(paramInt));
      return localMap2;
    }
    finally {}
  }
  
  public static Map<Long, odv.b> a(long paramLong)
  {
    synchronized (fb)
    {
      Map localMap1 = (Map)fb.get(Long.valueOf(paramLong));
      Object localObject1 = localMap1;
      if (localMap1 == null)
      {
        localObject1 = new HashMap();
        fb.put(Long.valueOf(paramLong), localObject1);
      }
      return localObject1;
    }
  }
  
  public static kxm.b a(TemplateBean paramTemplateBean, String paramString)
  {
    if (paramTemplateBean == null) {
      return null;
    }
    kxm.b localb = new kxm.b();
    if (paramTemplateBean != null)
    {
      paramTemplateBean = paramTemplateBean.getDataAttribute(paramString);
      if ((paramTemplateBean != null) && (paramTemplateBean.entrySet() != null))
      {
        paramTemplateBean = paramTemplateBean.entrySet().iterator();
        while ((paramTemplateBean != null) && (paramTemplateBean.hasNext()))
        {
          paramString = (Map.Entry)paramTemplateBean.next();
          localb.b((String)paramString.getKey(), paramString.getValue().toString());
        }
      }
    }
    return localb;
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong, HashMap<String, Object> paramHashMap)
  {
    kxm.b localb = kxm.a();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = String.valueOf(((Map.Entry)localObject).getKey());
        localObject = String.valueOf(((Map.Entry)localObject).getValue());
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localb.b(str, (String)localObject);
        }
      }
    }
    paramHashMap = localb.build();
    QLog.d("ReadinjoyReportUtils", 1, "reportQualityDataDimension id = " + paramInt2 + " resultCode = " + paramInt1 + " cost = " + paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyReportUtils", 2, "reportQualityDataDimension id = " + paramInt2 + " r5String = " + paramHashMap);
    }
    kbp.a(null, "", "0X800ACB9", "0X800ACB9", paramInt2, 0, String.valueOf(paramInt1), String.valueOf(paramLong), "", paramHashMap, false);
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
      if ((!awB) && (3 == paramInt1))
      {
        qx(true);
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
    if ((paramInt == 1008) && (acbn.blP.equals(paramString1)))
    {
      if (!aqft.equalsWithNullCheck(paramString2, paramResources.getString(aakb.fy[3]))) {
        break label57;
      }
      kbp.a(null, null, "0X8009884", "0X8009884", 0, 0, "", "", "", lj(), false);
    }
    label57:
    while (!aqft.equalsWithNullCheck(paramString2, paramResources.getString(aakb.fy[2]))) {
      return;
    }
    kbp.a(null, null, "0X8009885", "0X8009885", 0, 0, "", "", "", lj(), false);
  }
  
  public static void a(int paramInt1, boolean paramBoolean, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramBoolean, paramLong, paramInt2, paramInt3, true);
  }
  
  public static void a(int paramInt1, boolean paramBoolean1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    lcm.a().a.nm(paramBoolean1);
    long l;
    if (paramBoolean1)
    {
      lcm.aKg();
      lcm.d.qJ(4);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("EnterType");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(bh(paramInt1));
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
        if (kxm.aMw != 1)
        {
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("StrategyID");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(kxm.a.ahf);
          localArrayList.add(localObject);
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(4);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("AlgorithmID");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(kxm.a.aeN);
          localArrayList.add(localObject);
          paramLong = NetConnInfoCenter.getServerTime();
          l = kxm.a.vk;
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("costtime");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + (paramLong - l));
          localArrayList.add(localObject);
        }
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(6);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("durationBeforeEnter");
        if (lcm.a().cB() <= 0L) {
          break label483;
        }
      }
      label483:
      for (paramLong = System.currentTimeMillis() - lcm.a().cB();; paramLong = System.currentTimeMillis() - lcm.tw)
      {
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramLong + "");
        localArrayList.add(localObject);
        paramInt2 = 4;
        ocp.y(paramInt2, localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("ReadinjoyReportUtils", 2, "report kandian exit or enter ! from : " + paramInt1);
        }
        return;
        localObject = kxm.aMw + "";
        break;
      }
    }
    if (paramBoolean2) {
      lcm.d.aKh();
    }
    Object localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("ExitType");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(bh(paramInt1));
    localArrayList.add(localObject);
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("FolderStatus");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(paramInt2));
    localArrayList.add(localObject);
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("Time");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(lcm.B(paramLong)));
    localArrayList.add(localObject);
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(4);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("OperationBitmap");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramInt3 + "");
    localArrayList.add(localObject);
    if (kxm.a.aRV != 1)
    {
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("StrategyID");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(kxm.a.ahf);
      localArrayList.add(localObject);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(6);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("AlgorithmID");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(kxm.a.aeN);
      localArrayList.add(localObject);
      paramLong = NetConnInfoCenter.getServerTime();
      l = kxm.a.vk;
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(7);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("costtime");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + (paramLong - l));
      localArrayList.add(localObject);
    }
    localObject = lcm.a().b;
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(8);
    localAttributeList.att_name.set("staticDurationAfterEnter");
    if (((lcm.k)localObject).tQ > 0L)
    {
      paramLong = ((lcm.k)localObject).tQ - ((lcm.k)localObject).enterTime;
      label971:
      localAttributeList.att_value.set(paramLong + "");
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(9);
      localAttributeList.att_name.set("staticDurationBeforeExit");
      if (((lcm.k)localObject).tS <= 0L) {
        break label1206;
      }
    }
    label1206:
    for (paramLong = ((lcm.k)localObject).tT - ((lcm.k)localObject).tS;; paramLong = 0L)
    {
      localAttributeList.att_value.set(paramLong + "");
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(10);
      localAttributeList.att_name.set("articleInfoList");
      localAttributeList.att_value.set(((lcm.k)localObject).jj());
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(11);
      localAttributeList.att_name.set("scrollInfoList");
      localAttributeList.att_value.set(((lcm.k)localObject).jk());
      localArrayList.add(localAttributeList);
      paramInt2 = 5;
      break;
      paramLong = 0L;
      break label971;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, long paramLong)
  {
    if (((Long)awit.f("readinjoy_daily_article_first_exposure_" + paramBaseArticleInfo.mArticleID, Long.valueOf(0L))).longValue() == 0L) {
      awit.H("readinjoy_daily_article_first_exposure_" + paramBaseArticleInfo.mArticleID, Long.valueOf(System.currentTimeMillis() / 1000L));
    }
    synchronized (fb)
    {
      Map localMap2 = a(paramBaseArticleInfo.mChannelID);
      odv.b localb = (odv.b)localMap2.get(Long.valueOf(paramBaseArticleInfo.mArticleID));
      if (localb != null)
      {
        long l = paramLong;
        if (localb.duringTime > paramLong) {
          l = localb.duringTime;
        }
        localb.duringTime = l;
        return;
      }
      localb = new odv.b(kxm.nQ());
      localb.d = paramBaseArticleInfo;
      localb.duringTime = paramLong;
      localMap2.put(Long.valueOf(paramBaseArticleInfo.mArticleID), localb);
    }
  }
  
  public static void a(TemplateBean paramTemplateBean, String paramString1, String paramString2)
  {
    if ((paramTemplateBean == null) || (paramString2 == null)) {}
    kxm.b localb;
    do
    {
      return;
      localb = a(paramTemplateBean, paramString1);
      paramTemplateBean = a(paramTemplateBean, paramString1, paramString2);
    } while (paramTemplateBean == null);
    kbp.a(null, "CliOper", "", "", paramTemplateBean, paramTemplateBean, 0, 0, "", "", "", localb.build(), false);
  }
  
  public static void a(RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (!awA) {}
    while ((paramRecentItemChatMsgData == null) || (paramRecentItemChatMsgData.mUser == null) || (!acbn.blO.equals(paramRecentItemChatMsgData.mUser.uin))) {
      return;
    }
    awA = false;
    ThreadManager.executeOnSubThread(new ReadinjoyReportUtils.4(paramRecentItemChatMsgData));
  }
  
  public static void a(List<ArticleInfo> paramList, List<Long> paramList1, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    Collections.sort(paramList, new odx());
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
        localMap = dT;
        l2 = localArticleInfo.mArticleID;
        l3 = counter;
        counter = l3 + 1L;
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
  
  public static String aA(long paramLong)
  {
    if ((kys.dt((int)paramLong)) || (awit.ds(paramLong))) {
      return "0X8009CCB";
    }
    if (aT(paramLong)) {
      return "0X8009356";
    }
    return "0X8009332";
  }
  
  public static String aB(long paramLong)
  {
    if ((kys.dt((int)paramLong)) || (awit.ds(paramLong))) {
      return "0X8009CC9";
    }
    if (aT(paramLong)) {
      return "0X8009355";
    }
    return "0X8007625";
  }
  
  public static void aHz()
  {
    aIW = 0;
  }
  
  public static boolean aT(long paramLong)
  {
    return (paramLong == 70L) || (paramLong == 41403L);
  }
  
  public static void bdI()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("FolderStatus");
    localAttributeList.att_value.set(kxm.aMw + "");
    localArrayList.add(localAttributeList);
    ocp.y(10, localArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyReportUtils", 2, "reportKandianDelete  , foldStatus :  " + kxm.aMw);
    }
  }
  
  public static void bdJ()
  {
    bew = 1;
  }
  
  public static void bdK()
  {
    bew = 0;
  }
  
  private static String bh(int paramInt)
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
  
  public static void c(Map<Long, odv.b> paramMap, boolean paramBoolean)
  {
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext())
    {
      odv.b localb = (odv.b)localIterator.next();
      ArticleInfo localArticleInfo = (ArticleInfo)localb.d;
      if ((!kxm.B(localArticleInfo)) || (!localArticleInfo.mNewPolymericInfo.amx))
      {
        String str1 = kxm.f(localArticleInfo);
        paramMap = localArticleInfo.innerUniqueID;
        Object localObject = paramMap;
        if (kxm.s(localArticleInfo))
        {
          localObject = paramMap;
          if (localArticleInfo.mGroupSubArticleList.size() >= 1) {
            localObject = ((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        String str2 = kxm.h(localArticleInfo);
        if (((ndi.ak(localArticleInfo)) || (ndi.S(localArticleInfo)) || (ndi.T(localArticleInfo)) || (ndi.U(localArticleInfo))) && (!ndi.Y(localArticleInfo))) {
          paramMap = String.valueOf(localArticleInfo.mSocialFeedInfo.a.cuin);
        }
        for (;;)
        {
          for (;;)
          {
            localObject = kxm.a(localArticleInfo.mAlgorithmID, kxm.a(localArticleInfo), (int)localArticleInfo.mChannelID, NetworkState.isWifiConn(), str1, (String)localObject, str2, 0, localb.bez, localArticleInfo);
            str1 = aA(localArticleInfo.mChannelID);
            try
            {
              ((JSONObject)localObject).put("exposure_time", "" + (float)localb.duringTime / 1000.0F);
              if (kys.dv((int)localArticleInfo.mChannelID)) {
                ((JSONObject)localObject).put("cmd", awit.Hf());
              }
              kbp.a(null, "CliOper", "", paramMap, str1, str1, 0, 0, Long.toString(localArticleInfo.mFeedId), localArticleInfo.mArticleID + "", localArticleInfo.mStrategyId + "", ((JSONObject)localObject).toString(), false);
            }
            catch (JSONException paramMap)
            {
              paramMap.printStackTrace();
            }
          }
          break;
          if ((kxm.r(localArticleInfo)) && (localArticleInfo.mPolymericInfo.aRX == 6)) {
            paramMap = localArticleInfo.mPolymericInfo.uin + "";
          } else if (kxm.u(localArticleInfo)) {
            paramMap = "";
          } else {
            paramMap = localArticleInfo.mSubscribeID;
          }
        }
      }
    }
  }
  
  public static void d(AppRuntime paramAppRuntime)
  {
    long l1 = 0L;
    counter = 0L;
    dT.clear();
    if (paramAppRuntime == null) {}
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      acA = String.valueOf(l1) + "_" + String.valueOf(l2);
      return;
      l1 = paramAppRuntime.getLongAccountUin();
    }
  }
  
  public static void du(List<ArticleInfo> paramList)
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
      Collections.sort(paramList, new ody());
      localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)paramList.get(i);
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mAlgorithmId = ((int)localArticleInfo.mAlgorithmID);
        localReportInfo.mStrategyId = localArticleInfo.mStrategyId;
        localReportInfo.mSourceArticleId = localArticleInfo.mArticleID;
        localReportInfo.mInnerId = localArticleInfo.innerUniqueID;
        localReportInfo.mServerContext = localArticleInfo.mServerContext;
        localReportInfo.mUin = kxm.getLongAccountUin();
        localReportInfo.mChannelId = 0;
        localReportInfo.replyUin = i;
        localReportInfo.replyID = (NetConnInfoCenter.getServerTime() + "");
        localReportInfo.mSource = 3;
        localReportInfo.mOperation = 57;
        localArrayList.add(localReportInfo);
        i += 1;
      }
    } while (localArrayList.size() <= 0);
    lbz.a().cb(localArrayList);
  }
  
  public static void e(String paramString, boolean paramBoolean, long paramLong)
  {
    int i = 1;
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
      ((PBStringField)localObject).set(String.valueOf(i));
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("Time");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(lcm.B(paramLong)));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localAttributeList1);
      localArrayList.add(localAttributeList2);
      localArrayList.add(localObject);
      ocp.y(2, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyReportUtils", 2, "report dt entry ! busiName : " + paramString + " , redDot : " + paramBoolean);
      }
      return;
      i = 0;
    }
  }
  
  public static void h(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt == 1008) && (acbn.blP.equals(paramString)))
    {
      if (paramBoolean) {
        kbp.a(null, null, "0X8009884", "0X8009884", 0, 0, "", "", "", lj(), false);
      }
    }
    else {
      return;
    }
    kbp.a(null, null, "0X8009885", "0X8009885", 0, 0, "", "", "", lj(), false);
  }
  
  public static int l(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 0;
    int i = j;
    if ((paramBaseArticleInfo instanceof ArticleInfo))
    {
      i = j;
      if (!ndi.aa((ArticleInfo)paramBaseArticleInfo)) {
        i = 1;
      }
    }
    return i;
  }
  
  public static void l(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = (KandianMergeManager)paramQQAppInterface.getManager(162);
    kxm.b localb = new kxm.b();
    localb.c();
    localb.f();
    Object localObject = paramQQAppInterface.a();
    paramQQAppInterface = "";
    int i;
    if (localObject != null)
    {
      i = ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt;
      paramQQAppInterface = ((KandianMsgBoxRedPntInfo)localObject).mUin + "";
    }
    for (;;)
    {
      if (i > 0) {}
      try
      {
        localb.l(i);
        localb.b("message_reddot_style", kxm.nX());
        if (paramBoolean)
        {
          localObject = "0X8009A85";
          kbp.a(null, paramQQAppInterface, (String)localObject, (String)localObject, 0, 0, "", "", "", localb.build(), false);
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
      i = 0;
    }
  }
  
  public static String lj()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", kct.XU);
      localJSONObject.put("os", "1");
      localJSONObject.put("channel_id", kvs.getChannelId());
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
  
  public static int nM()
  {
    return aIW;
  }
  
  public static void pw(String paramString)
  {
    if (acbn.blO.equals(paramString))
    {
      kbp.a(null, null, "0X800978D", "0X800978D", 0, 0, "", "", "", lj(), false);
      lcm.aKe();
    }
    while (!acbn.blP.equals(paramString)) {
      return;
    }
    kbp.a(null, null, "0X8009886", "0X8009886", 0, 0, "", "", "", lj(), false);
    lcm.aKf();
  }
  
  public static void qx(boolean paramBoolean)
  {
    awB = paramBoolean;
  }
  
  public static String r(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = "";
    if (paramBaseArticleInfo != null) {
      str = "" + paramBaseArticleInfo.innerUniqueID;
    }
    return str;
  }
  
  public static int rj()
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
  
  public static void uy(int paramInt)
  {
    aIW |= paramInt;
    lcm.qI(3);
  }
  
  public static class a
  {
    public static void l(ArticleInfo paramArticleInfo, int paramInt)
    {
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = kxm.getLongAccountUin();
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
        localObject1 = new ReportInfo.a();
        ((ReportInfo.a)localObject1).vd = paramArticleInfo.mSocialFeedInfo.mFeedId;
        if (paramArticleInfo.mSocialFeedInfo.a != null) {
          ((ReportInfo.a)localObject1).vg = paramArticleInfo.mSocialFeedInfo.a.uin;
        }
        ((ReportInfo.a)localObject1).aSx = paramArticleInfo.mSocialFeedInfo.mLikeCount;
        ((ReportInfo.a)localObject1).aSy = paramArticleInfo.mSocialFeedInfo.mCommentCount;
        Object localObject2 = paramArticleInfo.mSocialFeedInfo.iS;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((ReportInfo.a)localObject1).iR = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SocializeFeedsInfo.e locale = (SocializeFeedsInfo.e)((Iterator)localObject2).next();
            if (locale != null) {
              ((ReportInfo.a)localObject1).iR.add(Long.valueOf(locale.uin));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((ReportInfo.a)localObject1);
      }
      if (kys.dv((int)paramArticleInfo.mChannelID)) {
        localReportInfo.mSearchTagName = kxm.i(paramArticleInfo);
      }
      Object localObject1 = kxj.a().a();
      if (localObject1 != null) {
        localReportInfo.srtClickInfo = ((oidb_cmd0x64e.SRTClickInfo)localObject1);
      }
      if ((paramArticleInfo != null) && (!mgn.Z(paramArticleInfo)) && (!kxj.a().AH()) && (kxm.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        localReportInfo.noDifferenceJump = 1;
      }
      paramArticleInfo = new ArrayList();
      paramArticleInfo.add(localReportInfo);
      lbz.a().cb(paramArticleInfo);
    }
  }
  
  public static class b
  {
    public final int bez;
    public BaseArticleInfo d;
    public long duringTime;
    
    public b(int paramInt)
    {
      this.bez = paramInt;
    }
    
    public String toString()
    {
      return this.d + "_duration : " + this.duringTime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     odv
 * JD-Core Version:    0.7.0.1
 */