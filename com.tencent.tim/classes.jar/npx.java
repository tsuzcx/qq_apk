import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.ProteusCDNUtils.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.ProteusCDNUtils.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class npx
{
  private static void C(String paramString1, String paramString2)
  {
    QLog.i("ProteusCDNUtils", 1, "[reportData], eventType = " + paramString1 + ", bid = " + paramString2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bid", paramString2);
      kbp.a(null, "", paramString1, paramString1, 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        QLog.e("ProteusCDNUtils", 1, "[reportData], e = " + paramString2);
      }
    }
  }
  
  public static void bO(String paramString1, String paramString2)
  {
    QLog.i("ProteusCDNUtils", 1, "[updateCDNUrl], bid = " + paramString1 + ", cdn url = " + paramString2);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      awit.H(eZ(paramString1), paramString2);
    }
  }
  
  public static String eZ(String paramString)
  {
    return "sp_key_readinjoy_cdn_url_" + paramString;
  }
  
  private static boolean ef(String paramString)
  {
    bool2 = false;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("ProteusCDNUtils", 1, "[shouldDownloadByCDN], retStr is null, no need download by CDN.");
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("data");
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.length() > 0)
        {
          paramString = paramString.optJSONObject(0);
          bool1 = bool2;
          if (paramString != null)
          {
            int i = paramString.optInt("code");
            if (i < 10)
            {
              bool1 = bool2;
              if (i > 0) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("ProteusCDNUtils", 1, "[shouldDownloadByCDN] parse json exception, e = " + paramString);
        bool1 = bool2;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("ProteusCDNUtils", 1, "[shouldDownloadByCDN], e = " + paramString);
        boolean bool1 = bool2;
      }
    }
    QLog.i("ProteusCDNUtils", 1, "[shouldDownloadByCDN], ret = " + bool1);
    return bool1;
  }
  
  private static boolean eg(String paramString)
  {
    long l2 = 0L;
    Object localObject = fa(paramString);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.equals("0", (CharSequence)localObject)))
    {
      QLog.i("ProteusCDNUtils", 1, "[isAbleToDownloadByCDN], cdn url is null or 0.");
      return false;
    }
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("/");
        if (localObject.length > 0)
        {
          localObject = Pattern.compile("\\d+").matcher(localObject[(localObject.length - 1)]);
          if (((Matcher)localObject).find())
          {
            localObject = ((Matcher)localObject).group();
            try
            {
              l1 = Long.valueOf((String)localObject).longValue();
              paramString = jpa.b(paramString);
              if (paramString != null) {
                l2 = paramString.optLong("version", 0L);
              }
              QLog.i("ProteusCDNUtils", 1, "[isAbleToDownloadByCDN], urlVersion = " + l1 + ", localVersion = " + l2);
              if (l1 <= l2) {
                break label216;
              }
              return true;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              QLog.e("ProteusCDNUtils", 1, "[isAbleToDownloadByCDN], e = " + localNumberFormatException);
            }
          }
        }
      }
      catch (Exception localException)
      {
        long l1;
        QLog.e("ProteusCDNUtils", 1, "[isAbleToDownloadByCDN], e = " + localException);
        continue;
      }
      l1 = 0L;
    }
    label216:
    return false;
  }
  
  private static String fa(String paramString)
  {
    String str = (String)awit.f(eZ(paramString), "");
    QLog.i("ProteusCDNUtils", 1, "[getCDNUrl], bid = " + paramString + ", cdnUrl = " + str);
    return str;
  }
  
  public static void n(String paramString1, String paramString2, int paramInt)
  {
    QLog.i("ProteusCDNUtils", 1, "[checkUpdate], bid = " + paramString1 + ", retStr = " + paramString2 + ", retCode = " + paramInt);
    try
    {
      if (ef(paramString2)) {
        oz(paramString1);
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("ProteusCDNUtils", 1, "[checkUpdate], e = " + paramString1);
    }
  }
  
  private static void oA(String paramString)
  {
    ThreadManager.excute(new ProteusCDNUtils.2(paramString), 64, null, false);
  }
  
  private static void oz(String paramString)
  {
    if (!eg(paramString))
    {
      QLog.i("ProteusCDNUtils", 1, "[downloadByCDN], no need to download by cdn, bid = " + paramString);
      return;
    }
    String str1 = aqul.getSDKPrivatePath(acbn.bny + paramString + ".7z");
    String str2 = fa(paramString);
    QLog.i("ProteusCDNUtils", 1, "[downloadByCDN], bid = " + paramString + ", localPath = " + str1 + ", cdnUrl = " + str2);
    ThreadManager.excute(new ProteusCDNUtils.1(str1, paramString, str2), 128, null, false);
    C("0X800ABFE", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npx
 * JD-Core Version:    0.7.0.1
 */