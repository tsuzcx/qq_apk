import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public final class avof
{
  @Deprecated
  public static String ju = "qqreader_1.0." + "3.4.4".replace(".", "") + ".0001_android_qqplugin";
  private static String mResolution;
  public static String ml = "VIP_QQREADER";
  
  static
  {
    mResolution = "0x0";
  }
  
  public static void M(Context paramContext, int paramInt, String paramString)
  {
    h(paramContext, paramInt, paramString, null);
  }
  
  public static void N(Context paramContext, int paramInt, String paramString)
  {
    b(null, "dc05135", new String[] { "109", Build.VERSION.RELEASE, "mobile qq", "3.4.4.3058", "", "", aqgz.a(paramContext).networkType, "", bL(paramContext), "2", "/h5/BlankScreen", String.valueOf(paramInt), paramString, "", "0", "" });
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, float paramFloat, int paramInt2, long paramLong, int paramInt3, String paramString4)
  {
    b(null, "dc05133", new String[] { "109", Build.VERSION.RELEASE, "mobile qq", "3.4.4.3058", "", "", paramString1, ju, avoh.FW(), paramString2, paramString3, String.valueOf(paramInt1), String.valueOf(paramFloat), String.valueOf(paramInt2), String.valueOf(paramLong), paramString4, "", "", "", "", "", "", "", "", "", "", String.valueOf(paramInt3) });
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, float paramFloat, int paramInt2, long paramLong, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramInt1, paramFloat, paramInt2, paramLong, 0, paramString4);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a(paramString1, paramString2, "52", paramString3, paramString4, paramString5, "", paramString6, "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    a("109", Build.VERSION.RELEASE, "mobile qq", "3.4.4", "", "", "android", paramString1, "", "", ju, paramString2, paramString3, paramString4, "", paramString5, "", paramString6, paramString7, paramString8, paramString9, paramString10, "", "", "", "");
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26)
  {
    String str1;
    if ("1".equals(paramString18))
    {
      str1 = "1";
      if (!avmr.da()) {
        break label254;
      }
    }
    label254:
    for (String str2 = "1";; str2 = "0")
    {
      b(null, "dc00547", new String[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, str1, paramString18, "0", paramString19, paramString20, paramString21, paramString22, paramString23, paramString24, paramString26, "", "", "", "", "", str2, paramString25 });
      return;
      if ("2".equals(paramString18))
      {
        str1 = "2";
        break;
      }
      str1 = "3";
      break;
    }
  }
  
  public static void ar(Context paramContext, String paramString1, String paramString2)
  {
    b(null, "dc05133", new String[] { "109", Build.VERSION.RELEASE, "mobile qq", "3.4.4.3058", "", "", aqgz.a(paramContext).networkType, "5", bL(paramContext), "10", "", "", "", "", paramString1, "", "", "", "", "", "", "", "", "", "", "", paramString2 });
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, String... paramVarArgs)
  {
    String str2 = "";
    String str1 = str2;
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      for (;;)
      {
        str1 = str2;
        if (i >= j) {
          break;
        }
        str1 = paramVarArgs[i];
        str2 = str2 + str1 + "|";
        i += 1;
      }
    }
    paramVarArgs = str1;
    if (str1.length() > 0) {
      paramVarArgs = str1.substring(0, str1.length() - 1);
    }
    Log.d("ReportUtils", "dcId=" + paramString + ";detail=" + paramVarArgs);
    annx.b(paramQQAppInterface, paramString, paramVarArgs, false);
  }
  
  private static String bL(Context paramContext)
  {
    if (("0x0".equals(mResolution)) && ((paramContext instanceof Activity))) {
      mResolution = avoh.j((Activity)paramContext);
    }
    return mResolution;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    a("109", Build.VERSION.RELEASE, "mobile qq", "3.4.4", "", "", "android", paramString1, "", "", ju, paramString2, paramString3, paramString4, "", paramString5, "", paramString6, paramString7, "", "", "", paramString8, paramString9, "", "");
  }
  
  public static void dk(Context paramContext, String paramString)
  {
    b(null, "dc05133", new String[] { "109", Build.VERSION.RELEASE, "mobile qq", "3.4.4.3058", "", "", aqgz.a(paramContext).networkType, "5", bL(paramContext), "11", "", "", "", "", "", "", paramString, "", "", "", "", "", "", "", "", "", "" });
  }
  
  public static void e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    c(paramString1, paramString2, "66", paramString3, paramString4, paramString5, "", paramString6, paramString7);
  }
  
  public static void h(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    b(null, "dc05135", new String[] { "109", Build.VERSION.RELEASE, "mobile qq", "3.4.4.3058", "", "", aqgz.a(paramContext).networkType, "ReaderShadowPlugin_5", bL(paramContext), "2", "/plugin/ReaderHost", String.valueOf(paramInt), paramString1, "", "0", rJ(paramString2) });
  }
  
  public static String rJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("message", paramString);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.e("ReportUtils", "[wrapperException] json error", paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avof
 * JD-Core Version:    0.7.0.1
 */