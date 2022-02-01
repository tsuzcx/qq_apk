import android.content.Intent;
import com.tencent.biz.pubaccount.PublicAccountReportUtils.1;
import com.tencent.biz.pubaccount.PublicAccountReportUtils.2;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class kbp
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, AccountDetail paramAccountDetail)
  {
    if ((paramQQAppInterface == null) && (paramAccountDetail == null)) {}
    Object localObject;
    do
    {
      return 1;
      localObject = paramAccountDetail;
      if (paramAccountDetail == null)
      {
        paramQQAppInterface = (acja)paramQQAppInterface.getManager(56);
        localObject = paramAccountDetail;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString);
          localObject = paramQQAppInterface;
          if (QLog.isColorLevel())
          {
            QLog.d("PublicAccountReportUtils", 2, "getReportAccountType--> input accountdetail null");
            localObject = paramQQAppInterface;
          }
        }
      }
    } while (localObject == null);
    int i;
    if (((AccountDetail)localObject).accountFlag < 0)
    {
      i = -9;
      switch (i)
      {
      case -8: 
      case -7: 
      default: 
        i = 1;
      }
    }
    for (;;)
    {
      return i;
      i = ocp.getAccountType(((AccountDetail)localObject).accountFlag);
      break;
      i = 3;
      continue;
      i = 4;
      if (ocp.F(((AccountDetail)localObject).accountFlag2) == -8L)
      {
        i = 8;
        continue;
        i = 5;
        continue;
        i = 6;
        continue;
        i = 7;
        continue;
        i = 9;
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    Object localObject1 = "";
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", kxm.aMw);
      ((JSONObject)localObject2).put("feeds_source", kxm.f(paramArticleInfo));
      ((JSONObject)localObject2).put("rowkey", paramArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("feeds_type", "" + kxm.a(paramArticleInfo));
      ((JSONObject)localObject2).put("kandian_mode", "" + kxm.nR());
      ((JSONObject)localObject2).put("tab_source", "" + kxm.nQ());
      ((JSONObject)localObject2).put("topic_id", "" + paramArticleInfo.businessId);
      ((JSONObject)localObject2).put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
      ((JSONObject)localObject2).put("mark_type", "" + kxm.b(paramArticleInfo));
      ((JSONObject)localObject2).put("channel_id", paramArticleInfo.mChannelID);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        String str2;
        localJSONException.printStackTrace();
        continue;
        String str1 = paramArticleInfo.mArticleID + "";
      }
    }
    if ((ndi.ak(paramArticleInfo)) || (ndi.S(paramArticleInfo)) || (ndi.T(paramArticleInfo)) || (ndi.U(paramArticleInfo)))
    {
      localObject2 = "0";
      str2 = "0X8008201";
      if (odv.aT(paramArticleInfo.mChannelID)) {
        str2 = "0X8009362";
      }
      a(null, kxm.f(paramArticleInfo), str2, str2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), (String)localObject2, "" + paramArticleInfo.mStrategyId, (String)localObject1, false);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    bq(paramString3, paramString7);
    paramString7 = eg(paramString7);
    paramString4 = ef(paramString4);
    paramString5 = ef(paramString5);
    paramString6 = ef(paramString6);
    paramString7 = ef(paramString7);
    anot.a(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    bq(paramString3, paramString7);
    paramString7 = eg(paramString7);
    if (paramBoolean)
    {
      a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
      return;
    }
    anot.a(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    bq(paramString5, paramString9);
    paramString9 = eg(paramString9);
    if (paramBoolean)
    {
      b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
      return;
    }
    anot.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    anot.a(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      c(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7, paramBoolean);
      return;
    }
    paramQQAppInterface = new Intent("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO");
    paramQQAppInterface.putExtra("VIDEO_REPORT_TOUIN", paramString1);
    paramQQAppInterface.putExtra("VIDEO_REPORT_SUBACTION", paramString2);
    paramQQAppInterface.putExtra("VIDEO_REPORT_ACTION_NAME", paramString3);
    paramQQAppInterface.putExtra("VIDEO_REPORT_FROM_TYPE", paramInt1);
    paramQQAppInterface.putExtra("VIDEO_REPORT_RESULT", paramInt2);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R2", paramString4);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R3", paramString5);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R4", paramString6);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R5", paramString7);
    paramQQAppInterface.putExtra("VIDEO_REPORT_SHOULD_ENCODE", paramBoolean);
    BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    bq(paramString5, paramString9);
    paramString9 = eg(paramString9);
    paramString6 = ef(paramString6);
    paramString7 = ef(paramString7);
    paramString8 = ef(paramString8);
    paramString9 = ef(paramString9);
    anot.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    anot.a(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void bp(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    a(localQQAppInterface, "", paramString1, paramString1, 0, 0, "", "", "", paramString2, false);
  }
  
  public static void bq(String paramString1, String paramString2)
  {
    if ("0X8007625".equals(paramString1)) {
      ThreadManager.executeOnSubThread(new PublicAccountReportUtils.2(paramString2));
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    ThreadManager.post(new PublicAccountReportUtils.1(paramString7, paramString1, paramQQAppInterface, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramBoolean), 5, null, true);
  }
  
  public static void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = "kandian_" + paramString1;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    HashMap localHashMap = new HashMap();
    localHashMap.put("department", "publicaccount");
    localHashMap.put("fromuin", str);
    localHashMap.put("touin", paramString2);
    localHashMap.put("d1", paramString3);
    localHashMap.put("d2", paramString4);
    localHashMap.put("d3", paramString5);
    localHashMap.put("d4", paramString6);
    anpc.a(BaseApplication.getContext()).collectPerformance(str, paramString1, true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("reportPAinfoToLighthouse", 2, new Object[] { "reportPAinfoToLighthouse-->", "kandianT" + paramString1 + ", fromuin:" + str + ", touin:" + paramString2 + ", d1:" + paramString3 + ", d2:" + paramString4 + ", d3:" + paramString5 + ", d4:" + paramString6 });
    }
  }
  
  public static String ef(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      try
      {
        String str = URLEncoder.encode(paramString, "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return paramString;
      }
    }
  }
  
  private static String eg(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        ((JSONObject)localObject).put("version_standard", "3.4.4");
        ((JSONObject)localObject).put("os_standard", "1");
        ((JSONObject)localObject).put("user_mode", kxm.getUserMode());
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (Exception localException)
      {
        Object localObject = paramString;
        if (!(localException instanceof JSONException))
        {
          QLog.e("PublicAccountReportUtils", 1, localException, new Object[0]);
          return paramString;
        }
      }
    }
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int i = a(paramQQAppInterface, String.valueOf(paramString), null);
    if ((i != 2) && (ocp.d(paramQQAppInterface, paramString) != -7)) {
      a(null, paramString, "0X800827B", "0X800827B", 0, 0, "" + paramInt, "" + i, "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbp
 * JD-Core Version:    0.7.0.1
 */