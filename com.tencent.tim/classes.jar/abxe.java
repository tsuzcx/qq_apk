import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.1;
import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.2;
import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.3;
import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.4;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class abxe
{
  private static HashSet<String> aO;
  private static HashSet<String> aP;
  private static HashSet<String> aQ;
  private static JSONObject bj;
  
  private static JSONObject W()
  {
    Object localObject1 = aqhq.readFile(ApolloUtil.bkc);
    if (localObject1 == null)
    {
      QLog.e("ApolloConfigDataReport", 1, "parseBasicJson file is null");
      return null;
    }
    localObject1 = new String((byte[])localObject1);
    try
    {
      localObject1 = new JSONObject((String)localObject1).optJSONArray("terminalForword");
      if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
        break label77;
      }
      localObject1 = ((JSONArray)localObject1).optJSONObject(0);
      if (localObject1 == null) {
        break label77;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloConfigDataReport", 1, "parseBasicJson Exception e:", localException);
        Object localObject2 = null;
      }
    }
    return localObject1;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dwtuin=").append(paramString1).append("&sop_type=").append(paramString2).append("&sop_name=").append(paramString3).append("&dwop_via=").append(paramInt1).append("&dwop_cnt=").append(1).append("&dwop_result=").append(paramInt2).append("&dwflag2=").append(paramString4).append("&dwflag3=").append(paramString5).append("&dwflag4=").append(paramString6).append("&dwflag5=").append(paramString7);
    return localStringBuilder.toString();
  }
  
  private static HashSet<String> a(int paramInt, JSONObject paramJSONObject)
  {
    HashSet localHashSet = new HashSet();
    if (paramJSONObject == null)
    {
      QLog.e("ApolloConfigDataReport", 1, "storeStabilityWatchCMDList mBaseJSONObj is null");
      return localHashSet;
    }
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("store_stable_watch_cmd_list");
        if ((paramJSONObject == null) || (paramJSONObject.length() <= 0)) {
          break;
        }
        paramInt = 0;
        if (paramInt >= paramJSONObject.length()) {
          break;
        }
        String str = paramJSONObject.optString(paramInt);
        if (TextUtils.isEmpty(str)) {
          break label109;
        }
        localHashSet.add(str);
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ApolloConfigDataReport", 1, "storeStabilityWatchCMDList Exception e:", paramJSONObject);
        return localHashSet;
      }
      if (paramInt == 2)
      {
        paramJSONObject = paramJSONObject.optJSONArray("store_stable_watch_url_list");
      }
      else
      {
        paramJSONObject = null;
        continue;
        label109:
        paramInt += 1;
      }
    }
  }
  
  private static HashSet<String> a(JSONObject paramJSONObject)
  {
    localHashSet = new HashSet();
    if (paramJSONObject == null) {
      QLog.e("ApolloConfigDataReport", 1, "parseReportConfigJson mBaseJSONObj is null");
    }
    for (;;)
    {
      return localHashSet;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("644_opname");
        if ((paramJSONObject == null) || (paramJSONObject.length() <= 0)) {
          continue;
        }
        int i = 0;
        while (i < paramJSONObject.length())
        {
          String str = paramJSONObject.optString(i);
          if (!TextUtils.isEmpty(str)) {
            localHashSet.add(str);
          }
          i += 1;
        }
        return localHashSet;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ApolloConfigDataReport", 1, "parseReportConfigJson Exception e:", paramJSONObject);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (((paramAppInterface == null) || (!(paramAppInterface instanceof QQAppInterface))) && (aO == null)) {
      ThreadManager.excute(new ApolloConfigDataReport.4(), 64, null, true);
    }
    if ((aO != null) && (aO.contains(paramString3))) {
      try
      {
        paramAppInterface = BaseApplicationImpl.sApplication.getRuntime();
        if (paramAppInterface == null)
        {
          QLog.e("ApolloConfigDataReport", 1, "interceptReport appRuntime is null");
          return;
        }
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
        paramString1 = new WebSSOAgent.UniSsoServerReq();
        paramString1.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_dc_report.forward_data");
        ((JSONObject)localObject).put("from", "android");
        ((JSONObject)localObject).put("dcId", "644");
        paramString2 = a(paramString4, paramString2, paramString3, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
        ((JSONObject)localObject).put("fields_data", paramString2);
        paramString1.reqdata.set(((JSONObject)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfigDataReport", 2, new Object[] { "interceptReport sop_name:", paramString3, ",fields_data:", paramString2 });
        }
        paramString2 = new NewIntent(BaseApplicationImpl.sApplication.getApplicationContext(), ailu.class);
        paramString2.putExtra("extra_cmd", "apollo_dc_report.forward_data");
        paramString2.putExtra("extra_data", paramString1.toByteArray());
        paramString2.putExtra("extra_timeout", 15000);
        paramString2.setObserver(new abxg());
        paramAppInterface.startServlet(paramString2);
        return;
      }
      catch (Exception paramAppInterface)
      {
        QLog.e("ApolloConfigDataReport", 1, "interceptReport Exception:", paramAppInterface);
        paramAppInterface.printStackTrace();
      }
    }
  }
  
  private static void cFY()
  {
    bj = W();
    aO = a(bj);
    aP = a(1, bj);
    aQ = a(2, bj);
  }
  
  public static void cj(QQAppInterface paramQQAppInterface)
  {
    cFY();
    ck(paramQQAppInterface);
  }
  
  public static void ck(QQAppInterface paramQQAppInterface)
  {
    if (!aqiw.isNetworkAvailable(null)) {
      return;
    }
    ThreadManager.excute(new ApolloConfigDataReport.1(paramQQAppInterface), 128, null, true);
  }
  
  public static void clear()
  {
    if (aO != null) {
      aO.clear();
    }
    if (aP != null) {
      aP.clear();
    }
    if (aQ != null) {
      aQ.clear();
    }
  }
  
  public static HashSet<String> e()
  {
    if (aP == null) {
      ThreadManager.excute(new ApolloConfigDataReport.2(), 64, null, true);
    }
    return aP;
  }
  
  public static HashSet<String> f()
  {
    if (aQ == null) {
      ThreadManager.excute(new ApolloConfigDataReport.3(), 64, null, true);
    }
    return aQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxe
 * JD-Core Version:    0.7.0.1
 */