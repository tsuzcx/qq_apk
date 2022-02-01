import android.net.Uri;
import android.net.Uri.Builder;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class aodb
{
  private static JSONObject bK = new JSONObject();
  public static String cke = "";
  private static String[] hi = new String[2];
  private static HashMap<String, Long> nM = new HashMap();
  
  public static void Q(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.d(paramString1, 2, "tencentdoc log:" + paramString2 + " - " + paramString3 + " - " + paramString4);
  }
  
  public static void R(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (pS(paramString1))
    {
      paramString1 = oa(paramString1);
      if (TextUtils.isEmpty(paramString1)) {
        aX(paramString2, paramString3, paramString4);
      }
    }
    else
    {
      return;
    }
    Q(paramString2, paramString3, paramString4, paramString1);
  }
  
  private static void a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      bK.put("trace", paramString1);
      bK.put("value", paramString2);
      bK.put("extra1", paramString3);
      bK.put("extra2", paramString4);
      paramString1 = bK.toString();
      int i = paramString1.length();
      int j = i / 2;
      paramArrayOfString[0] = paramString1.substring(0, j);
      paramArrayOfString[1] = paramString1.substring(j, i);
      return;
    }
    catch (JSONException paramArrayOfString)
    {
      QLog.e("TenDocLogReportHelper", 2, "report fail", paramArrayOfString);
    }
  }
  
  public static void aN(QQAppInterface paramQQAppInterface, String paramString)
  {
    anot.a(paramQQAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static long aO(String paramString)
  {
    paramString = (Long)nM.remove(paramString);
    if (paramString != null) {
      return SystemClock.elapsedRealtime() - paramString.longValue();
    }
    return 0L;
  }
  
  public static void aX(String paramString1, String paramString2, String paramString3)
  {
    QLog.d(paramString1, 2, "tencentdoc log:" + paramString2 + " - " + paramString3);
  }
  
  public static void aY(String paramString1, String paramString2, String paramString3)
  {
    String str;
    if (pS(paramString1))
    {
      str = "ps_key:" + pT(paramString1);
      paramString1 = oa(paramString1);
      if (TextUtils.isEmpty(paramString1)) {
        aX(paramString2, paramString3, str);
      }
    }
    else
    {
      return;
    }
    Q(paramString2, paramString3, str, paramString1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a(hi, paramString1, paramString3, paramString4, paramString5);
    anot.a(paramQQAppInterface, "dc00898", "", "", paramString2, paramString2, 0, 0, "", "", hi[0], hi[1]);
    if (QLog.isColorLevel()) {
      QLog.d("TenDocLogReportHelper", 2, "reportTDW: traceId=" + paramString1 + " T=" + paramString2 + " value=" + paramString3 + " extra1=" + paramString4 + " extra2=" + paramString5);
    }
  }
  
  public static String bF(String paramString1, String paramString2)
  {
    String str;
    if (paramString1 == null) {
      str = null;
    }
    Uri localUri;
    do
    {
      return str;
      localUri = Uri.parse(paramString1);
      str = paramString1;
    } while (!TextUtils.isEmpty(localUri.getQueryParameter("xiaolv_wy_tdoc_tid")));
    QLog.d("TenDocLogReportHelper", 2, "trace url: " + paramString1 + ",traceId: " + paramString2);
    paramString1 = localUri.buildUpon();
    paramString1.appendQueryParameter("xiaolv_wy_tdoc_tid", paramString2);
    return paramString1.toString();
  }
  
  public static void fy(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    nM.put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
  }
  
  public static String nY(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = paramString.hashCode() + "_" + System.currentTimeMillis())
    {
      cke = paramString;
      QLog.d("TenDocLogReportHelper", 2, "init trace id: " + cke);
      return cke;
    }
  }
  
  public static String nZ(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    Uri localUri;
    do
    {
      return paramString;
      localUri = Uri.parse(paramString);
    } while (!TextUtils.isEmpty(localUri.getQueryParameter("showDiscuss")));
    paramString = localUri.buildUpon();
    paramString.appendQueryParameter("showDiscuss", "true");
    return paramString.toString();
  }
  
  public static String oa(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString).getQueryParameter("xiaolv_wy_tdoc_tid");
  }
  
  public static String ob(String paramString)
  {
    String str = oa(paramString);
    if (!TextUtils.isEmpty(str)) {}
    int i;
    do
    {
      return str;
      i = paramString.indexOf("?");
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public static boolean pS(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.contains("docs.qq.com"))
      {
        bool1 = bool2;
        if (!paramString.contains("docx.qq.com")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean pT(String paramString)
  {
    paramString = CookieManager.getInstance().getCookie(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i];
        if ((arrayOfString != null) && (arrayOfString.contains("p_skey")))
        {
          arrayOfString = arrayOfString.split("=");
          if ((arrayOfString.length > 1) && (!TextUtils.isEmpty(arrayOfString[1]))) {
            return true;
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static void t(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramTeamWorkFileImportInfo.traceId))
    {
      paramTeamWorkFileImportInfo.traceId = nY(paramTeamWorkFileImportInfo.fileName);
      return;
    }
    QLog.d("TenDocLogReportHelper", 2, "has setted trace Id: " + paramTeamWorkFileImportInfo.traceId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodb
 * JD-Core Version:    0.7.0.1
 */