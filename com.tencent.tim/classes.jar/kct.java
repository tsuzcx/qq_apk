import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter.1;
import com.tencent.biz.pubaccount.VideoReporter.2;
import com.tencent.biz.pubaccount.VideoReporter.3;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class kct
{
  public static String XU = "3.4.4".replace(".", "");
  public static int aHF;
  public static HashMap<Class<?>, String> cZ = new HashMap();
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return -1;
    }
    if (paramArticleInfo.videoJumpChannelID > 0) {
      return paramArticleInfo.videoJumpChannelID;
    }
    if (awit.i(BaseApplicationImpl.getApplication().getRuntime()) == 1) {
      return 56;
    }
    return 409409;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int j = 2;
    if (paramInt == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if (paramQQAppInterface == null) {
        break label74;
      }
      paramQQAppInterface = paramQQAppInterface.c(paramString);
      if (paramQQAppInterface == null) {
        break label74;
      }
    }
    label74:
    for (paramInt = paramQQAppInterface.wMemberNum;; paramInt = 2)
    {
      int i = paramInt;
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramInt != 3000);
        paramQQAppInterface = (acdu)paramQQAppInterface.getManager(53);
        i = j;
      } while (paramQQAppInterface == null);
      return paramQQAppInterface.cn(paramString);
    }
  }
  
  public static Bundle a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    int j = 0;
    int i = 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("makeAdVideoPlayParam(in) ");
      ((StringBuilder)localObject).append("autoPlay:").append(paramBoolean1).append(", ");
      ((StringBuilder)localObject).append("bt:").append(paramInt1).append(", ");
      ((StringBuilder)localObject).append("et:").append(paramInt2).append(", ");
      ((StringBuilder)localObject).append("bf:").append(paramBoolean2).append(", ");
      ((StringBuilder)localObject).append("ef:").append(paramBoolean3).append(", ");
      ((StringBuilder)localObject).append("pa:").append(paramInt3);
      QLog.d("VideoReporter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("arg_video_bt", paramInt1);
    ((Bundle)localObject).putInt("arg_video_et", paramInt2);
    if (paramBoolean2)
    {
      paramInt1 = 1;
      ((Bundle)localObject).putInt("arg_video_bf", paramInt1);
      paramInt1 = j;
      if (paramBoolean3) {
        paramInt1 = 1;
      }
      ((Bundle)localObject).putInt("arg_video_ef", paramInt1);
      ((Bundle)localObject).putInt("arg_video_pp", 2);
      ((Bundle)localObject).putInt("arg_video_pa", paramInt3);
      if (!paramBoolean1) {
        break label265;
      }
    }
    label265:
    for (paramInt1 = i;; paramInt1 = 2)
    {
      ((Bundle)localObject).putInt("arg_video_pb", paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("VideoReporter", 2, "makeAdVideoPlayParam(out) param:" + ((Bundle)localObject).toString());
      }
      return localObject;
      paramInt1 = 0;
      break;
    }
  }
  
  public static String a(int paramInt, JSONObject paramJSONObject)
  {
    return a(null, null, null, null, paramInt, paramJSONObject);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, JSONObject paramJSONObject)
  {
    return a(null, null, paramString1, paramString2, paramInt, paramJSONObject);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channel_id", paramInt);
      label28:
      return a(paramString1, paramString2, paramString3, paramString4, localJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      break label28;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("video_duration", paramLong2);
        return a(paramString1, paramString2, paramString3, paramString4, paramLong1, paramJSONObject);
      }
      catch (Exception localException) {}
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("current_duration", paramLong);
      label28:
      return a(paramString1, paramString2, paramString3, paramString4, localJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      break label28;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      a(paramString1, paramString2, paramString3, paramString4, localJSONObject);
      if (paramJSONObject != null)
      {
        paramString1 = paramJSONObject.keys();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          localJSONObject.put(paramString2, paramJSONObject.getString(paramString2));
        }
      }
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      return "";
    }
    return paramString1;
  }
  
  public static JSONObject a(JSONObject paramJSONObject, int paramInt)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("oper_time", System.currentTimeMillis());
      localJSONObject.put("company_id", paramInt);
      return localJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ReportInfo.b paramb, int paramInt7, String paramString2, String paramString3)
  {
    ThreadManager.post(new VideoReporter.1(paramInt1, paramLong, paramString1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramb, paramInt7, paramString2, paramString3), 5, null, true);
  }
  
  public static void a(long paramLong1, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, ReportInfo.b paramb, int paramInt5, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = kxm.getLongAccountUin();
    localReportInfo.mSource = 0;
    if (paramInt1 == 56)
    {
      localReportInfo.mOpSource = 11;
      localReportInfo.mSourceArticleId = paramLong1;
      localReportInfo.mInnerId = paramString1;
      localReportInfo.mChannelId = paramInt1;
      localReportInfo.mAlgorithmId = paramInt2;
      localReportInfo.mStrategyId = paramInt3;
      localReportInfo.mOperation = paramInt4;
      localReportInfo.mPlayTimeLength = ((int)paramLong2);
      localReportInfo.mVideoExtraRepoerData = paramb;
      localReportInfo.mColumnID = paramInt5;
      localReportInfo.videoReportInfo = paramString2;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder().append("reportVideoUserOperationByOidbOfFeed--mUin:").append(localReportInfo.mUin).append("; mSourceArticleId:").append(localReportInfo.mSourceArticleId).append("; mSource:").append(localReportInfo.mSource).append("; mOpSource:").append(localReportInfo.mOpSource).append("; mInnerId:").append(localReportInfo.mInnerId).append("; mChannelId:").append(localReportInfo.mChannelId).append("; mAlgorithmId:").append(localReportInfo.mAlgorithmId).append("; mStrategyId:").append(localReportInfo.mStrategyId).append("; mOperation:").append(localReportInfo.mOperation).append("; mPlayTimeLength:").append(localReportInfo.mPlayTimeLength).append("; mColumnID:").append(localReportInfo.mColumnID).append("; videoReportInfo:").append(localReportInfo.videoReportInfo).append("; videoExtraRepoerData:");
        if (paramb == null) {
          break label366;
        }
      }
    }
    label366:
    for (paramString1 = paramb.toString();; paramString1 = "null")
    {
      QLog.d("VideoReporter", 2, paramString1);
      localArrayList.add(localReportInfo);
      new ljc(null, null, lun.a(), null).cA(localArrayList);
      return;
      localReportInfo.mOpSource = 0;
      break;
    }
  }
  
  public static void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, ReportInfo.b paramb, String paramString)
  {
    long l = paramVideoInfo.rz;
    String str = paramVideoInfo.Wz;
    int j = (int)paramVideoInfo.algorithmID;
    int k = paramVideoInfo.strategyID;
    if (paramVideoInfo.a != null) {}
    for (int i = paramVideoInfo.a.aHc;; i = -1)
    {
      a(18, l, str, paramInt1, j, k, paramInt2, paramInt3, paramb, i, paramVideoInfo.videoReportInfo, paramString);
      return;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2, long paramLong, ReportInfo.b paramb)
  {
    long l = paramBaseArticleInfo.mArticleID;
    String str = paramBaseArticleInfo.innerUniqueID;
    int j = (int)paramBaseArticleInfo.mAlgorithmID;
    int k = paramBaseArticleInfo.mStrategyId;
    if (paramBaseArticleInfo.mVideoColumnInfo != null) {}
    for (int i = paramBaseArticleInfo.mVideoColumnInfo.aHc;; i = -1)
    {
      a(l, str, paramInt1, j, k, paramInt2, paramLong, paramb, i, paramBaseArticleInfo.videoReportInfo);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    ThreadManager.executeOnSubThread(new VideoReporter.2(paramInt1, paramQQAppInterface, paramString, paramInt2, paramLong));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, JSONObject paramJSONObject)
  {
    i = 1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        paramJSONObject.put("md5", paramString1);
        paramJSONObject.put("network_type", ib());
        paramJSONObject.put("os", "1");
        if (XU == null) {
          XU = "3.4.4".replace(".", "");
        }
        paramJSONObject.put("version", XU);
        paramJSONObject.put("imei", kxm.iT());
        paramJSONObject.put("imsi", kxm.iU());
        paramJSONObject.put("kandian_mode_new", nd());
        paramJSONObject.put("kandian_mode", kxm.nR());
        paramJSONObject.put("report_timestamp", System.currentTimeMillis());
        if (aqux.Mv() != 1) {
          continue;
        }
        paramString1 = "1";
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        continue;
        paramString1 = "0";
        continue;
        i = 0;
        continue;
      }
      paramJSONObject.put("simCardType", paramString1);
      paramJSONObject.put("diandianfeeds_type", RecommendFeedsDiandianEntranceManager.a().qE());
      if (!kxm.isFromAIO) {
        continue;
      }
      paramJSONObject.put("from_aio", i);
      e(paramJSONObject);
      return;
      paramJSONObject.put("aid", paramString4);
      paramJSONObject.put("vid", paramString3);
      paramJSONObject.put("puin", paramString2);
    }
  }
  
  public static void b(VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, ReportInfo.b paramb, String paramString)
  {
    long l = paramVideoInfo.rz;
    String str = paramVideoInfo.Wz;
    int j = (int)paramVideoInfo.algorithmID;
    int k = paramVideoInfo.strategyID;
    if (paramVideoInfo.a != null) {}
    for (int i = paramVideoInfo.a.aHc;; i = -1)
    {
      a(5, l, str, paramInt1, j, k, paramInt2, paramInt3, paramb, i, paramVideoInfo.videoReportInfo, paramString);
      return;
    }
  }
  
  public static void b(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    String str = "";
    if (paramInt1 == 1008) {
      str = "1";
    }
    if (paramInt1 == 0) {
      str = "2";
    }
    for (;;)
    {
      kbp.a(null, "CliOper", "", "", paramString1, paramString1, 0, 0, str, Integer.toString(paramInt2), paramString3, paramString2, false);
      return;
      if (paramInt1 == 1) {
        str = "3";
      } else if (paramInt1 == 3000) {
        str = "4";
      }
    }
  }
  
  public static void c(MessageRecord paramMessageRecord)
  {
    ThreadManager.executeOnSubThread(new VideoReporter.3(paramMessageRecord));
  }
  
  public static int cR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 4: 
      return 2;
    }
    return 3;
  }
  
  public static String d(JSONObject paramJSONObject)
  {
    return a(null, null, null, null, paramJSONObject);
  }
  
  public static String e(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      localJSONObject.put("jump_to_channel", paramInt);
      localJSONObject.put("video_session_id", paramString1);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (Exception paramString1) {}
    return paramString2;
  }
  
  public static JSONObject e(JSONObject paramJSONObject)
  {
    double d1 = 0.0D;
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
        paramJSONObject = kxm.a();
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.a;
          if (paramJSONObject != null)
          {
            d2 = paramJSONObject.ce;
            d1 = paramJSONObject.cd;
            localJSONObject.put("longitude", d2);
            localJSONObject.put("latitude", d1);
            if (localContext != null)
            {
              paramJSONObject = kxm.V(localContext);
              localJSONObject.put("wifi_ssid", kxm.W(localContext));
              localJSONObject.put("wifi_mac", paramJSONObject);
            }
            localJSONObject.put("imei", kxm.iT());
            localJSONObject.put("imsi", kxm.iU());
            localJSONObject.put("androidid", aqgz.getAndroidID());
            return localJSONObject;
          }
        }
        else
        {
          paramJSONObject = null;
          continue;
        }
        double d2 = 0.0D;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localJSONObject;
      }
    }
  }
  
  public static String eh(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("download", paramString);
      a(localJSONObject, 2);
      paramString = d(localJSONObject);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String ib()
  {
    int i = aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
    if (i == 1) {
      return "0";
    }
    if ((i == 3) || (i == 4)) {
      return "1";
    }
    return "2";
  }
  
  public static String ic()
  {
    if ((kxm.getAppRuntime() instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
      return arwv.toMD5(localQQAppInterface.getCurrentUin() + "_" + System.currentTimeMillis());
    }
    return arwv.toMD5("_" + System.currentTimeMillis());
  }
  
  public static String ie()
  {
    return d(null);
  }
  
  public static String j(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("jump_to_channel", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static int l(int paramInt, String paramString)
  {
    int j = 1;
    int i;
    if (paramInt != 2)
    {
      i = j;
      if (paramInt != 3) {}
    }
    else
    {
      i = j;
      if (!TextUtils.isEmpty(paramString)) {
        i = paramString.hashCode();
      }
    }
    return i;
  }
  
  public static int nd()
  {
    boolean bool1 = awit.aMG();
    boolean bool2 = awit.aMH();
    if (!bool1) {
      return 0;
    }
    if (bool2) {
      return 3;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kct
 * JD-Core Version:    0.7.0.1
 */