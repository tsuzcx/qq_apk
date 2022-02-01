import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aljk
{
  public static void Ok(String paramString)
  {
    String str2 = Build.BRAND;
    String str1 = str2;
    if (aqmr.isEmpty(str2)) {
      str1 = Build.MANUFACTURER;
    }
    if (aqmr.isEmpty(str1)) {
      str1 = Build.PRODUCT;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAssistantConfigUtils", 2, "reportQAssistantJump openAction: " + paramString + " strBrand: " + str1);
      }
      str2 = "" + dJ(paramString);
      if (str1 == null) {}
      for (paramString = "";; paramString = str1)
      {
        anot.a(null, "dc00898", "", "", "0X800A99A", "0X800A99A", 0, 0, str2, "", paramString, Build.MODEL);
        return;
      }
    }
  }
  
  public static void R(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigUtils", 2, "reportQAssistantJumpMonitor host: " + paramString1 + " openAction: " + paramString2 + " result: " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localHashMap.put("host", str);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localHashMap.put("openJumpAction", paramString1);
    localHashMap.put("result", paramInt + "");
    paramString1 = anpc.a(BaseApplication.getContext());
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.collectPerformance(null, "qAudioAssistantJumpMonitor", bool, 0L, 0L, localHashMap, null);
      return;
    }
  }
  
  public static alji a(Intent paramIntent)
  {
    String[] arrayOfString1 = null;
    int j = 0;
    if ((paramIntent == null) || (!paramIntent.hasExtra("q_qssistant_str_name"))) {
      return null;
    }
    alji localalji = aljj.a(paramIntent.getStringExtra("q_qssistant_openaction"));
    localalji.strName = paramIntent.getStringExtra("q_qssistant_str_name");
    localalji.bWD = paramIntent.getStringExtra("q_qssistant_str_scheme");
    localalji.bWG = paramIntent.getStringExtra("q_qssistant_str_package");
    localalji.bWE = paramIntent.getStringExtra("q_qssistant_str_server");
    localalji.bWF = paramIntent.getStringExtra("q_qssistant_str_action");
    localalji.cxs = paramIntent.getBooleanExtra("q_qssistant_openenable", false);
    localalji.host = paramIntent.getStringExtra("q_qssistant_jump_host");
    if (paramIntent.hasExtra("q_qssistant_extra_field_key"))
    {
      String[] arrayOfString2 = paramIntent.getStringArrayExtra("q_qssistant_extra_field_key");
      int i = j;
      if (paramIntent.hasExtra("q_qssistant_extra_field_value"))
      {
        arrayOfString1 = paramIntent.getStringArrayExtra("q_qssistant_extra_field_value");
        i = j;
      }
      if (i < arrayOfString2.length)
      {
        HashMap localHashMap = localalji.attributes;
        String str = arrayOfString2[i];
        if ((arrayOfString1 == null) || (arrayOfString1.length <= i)) {}
        for (paramIntent = "";; paramIntent = arrayOfString1[i])
        {
          localHashMap.put(str, paramIntent);
          i += 1;
          break;
        }
      }
    }
    return localalji;
  }
  
  public static alji a(JSONObject paramJSONObject)
  {
    int i = 0;
    if ((paramJSONObject == null) || (!paramJSONObject.has("str_name"))) {
      return null;
    }
    Object localObject = paramJSONObject.optString("str_name", "");
    String str1 = paramJSONObject.optString("str_scheme", "");
    String str2 = paramJSONObject.optString("str_server", "");
    String str3 = paramJSONObject.optString("str_action", "");
    String str4 = paramJSONObject.optString("str_package", "");
    boolean bool = paramJSONObject.optBoolean("openenable", false);
    String str5 = paramJSONObject.optString("openaction", "");
    alji localalji = aljj.a(str5);
    localalji.strName = ((String)localObject);
    if (!aqmr.isEmpty(str1)) {
      localalji.bWD = str1;
    }
    if (!aqmr.isEmpty(str2)) {
      localalji.bWE = str2;
    }
    if (!aqmr.isEmpty(str3)) {
      localalji.bWF = str3;
    }
    if (!aqmr.isEmpty(str4)) {
      localalji.bWG = str4;
    }
    localalji.cxs = bool;
    if (!aqmr.isEmpty(str5)) {
      localalji.bWH = str5;
    }
    if (paramJSONObject.has("extra_field_key"))
    {
      localObject = paramJSONObject.optJSONArray("extra_field_key");
      if (paramJSONObject.has("extra_field_value")) {
        paramJSONObject = paramJSONObject.optJSONArray("extra_field_value");
      }
    }
    for (;;)
    {
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        if (i < ((JSONArray)localObject).length())
        {
          str2 = ((JSONArray)localObject).optString(i, null);
          if (!aqmr.isEmpty(str2)) {
            if ((paramJSONObject == null) || (paramJSONObject.length() <= i)) {
              break label288;
            }
          }
        }
      }
      label288:
      for (str1 = paramJSONObject.optString(i, null);; str1 = null)
      {
        localalji.attributes.put(str2, str1);
        i += 1;
        break;
        return localalji;
      }
      paramJSONObject = null;
      continue;
      paramJSONObject = null;
      localObject = null;
    }
  }
  
  public static void a(alji paramalji, boolean paramBoolean, Intent paramIntent)
  {
    if ((paramalji == null) || (paramIntent == null)) {
      return;
    }
    paramIntent.putExtra("q_qssistant_debug_mode", paramBoolean);
    if (paramalji.strName == null)
    {
      localObject = "";
      label28:
      paramIntent.putExtra("q_qssistant_str_name", (String)localObject);
      if (paramalji.bWD != null) {
        break label290;
      }
      localObject = "";
      label48:
      paramIntent.putExtra("q_qssistant_str_scheme", (String)localObject);
      if (paramalji.bWG != null) {
        break label299;
      }
      localObject = "";
      label68:
      paramIntent.putExtra("q_qssistant_str_package", (String)localObject);
      if (paramalji.bWE != null) {
        break label308;
      }
      localObject = "";
      label88:
      paramIntent.putExtra("q_qssistant_str_server", (String)localObject);
      if (paramalji.bWF != null) {
        break label317;
      }
      localObject = "";
      label108:
      paramIntent.putExtra("q_qssistant_str_action", (String)localObject);
      paramIntent.putExtra("q_qssistant_openenable", paramalji.cxs);
      if (paramalji.bWH != null) {
        break label326;
      }
      localObject = "";
      label139:
      paramIntent.putExtra("q_qssistant_openaction", (String)localObject);
      if (paramalji.host != null) {
        break label335;
      }
    }
    String[] arrayOfString1;
    String[] arrayOfString2;
    label290:
    label299:
    label308:
    label317:
    label326:
    label335:
    for (Object localObject = "";; localObject = paramalji.host)
    {
      paramIntent.putExtra("q_qssistant_jump_host", (String)localObject);
      int i = paramalji.attributes.size();
      if (i <= 0) {
        break;
      }
      arrayOfString1 = new String[i];
      arrayOfString2 = new String[i];
      Iterator localIterator = paramalji.attributes.entrySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        paramalji = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        arrayOfString1[i] = paramalji;
        paramalji = (alji)localObject;
        if (localObject == null) {
          paramalji = "";
        }
        arrayOfString2[i] = paramalji;
        i += 1;
      }
      localObject = paramalji.strName;
      break label28;
      localObject = paramalji.bWD;
      break label48;
      localObject = paramalji.bWG;
      break label68;
      localObject = paramalji.bWE;
      break label88;
      localObject = paramalji.bWF;
      break label108;
      localObject = paramalji.bWH;
      break label139;
    }
    paramIntent.putExtra("q_qssistant_extra_field_key", arrayOfString1);
    paramIntent.putExtra("q_qssistant_extra_field_value", arrayOfString2);
  }
  
  private static int dJ(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (paramString.equalsIgnoreCase("scan")) {
        return 8;
      }
      if (paramString.equalsIgnoreCase("openreadinjoy")) {
        return 11;
      }
      if (paramString.equalsIgnoreCase("qassistantnearby")) {
        return 14;
      }
      if (paramString.equalsIgnoreCase("qsettings")) {
        return 6;
      }
      if (paramString.equalsIgnoreCase("searchpage")) {
        return 7;
      }
      if (paramString.equalsIgnoreCase("qinterest")) {
        return 12;
      }
      if (paramString.equalsIgnoreCase("ecchat")) {
        return 16;
      }
      if (paramString.equalsIgnoreCase("confessmsg")) {
        return 17;
      }
      if (paramString.equalsIgnoreCase("weishi")) {
        return 18;
      }
    } while (!paramString.equalsIgnoreCase("qqgame"));
    return 19;
  }
  
  public static List<alji> f(String paramString, List<String> paramList)
  {
    int j = 0;
    Object localObject1;
    if (aqmr.isEmpty(paramString))
    {
      localObject1 = null;
      return localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigUtils", 2, "parseJson  strJson = " + paramString);
    }
    ArrayList localArrayList = new ArrayList();
    label236:
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("qassistantconfigs"))
        {
          localObject1 = ((JSONObject)localObject2).getJSONArray("qassistantconfigs");
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            alji localalji = a(((JSONArray)localObject1).getJSONObject(i));
            if (localalji == null) {
              break label236;
            }
            localArrayList.add(localalji);
            break label236;
          }
        }
        localObject1 = localArrayList;
        if (!((JSONObject)localObject2).has("qassistantsupporthost")) {
          break;
        }
        localObject1 = localArrayList;
        if (paramList == null) {
          break;
        }
        paramList.clear();
        localObject2 = ((JSONObject)localObject2).getJSONArray("qassistantsupporthost");
        int i = j;
        localObject1 = localArrayList;
        if (i >= ((JSONArray)localObject2).length()) {
          break;
        }
        paramList.add(((JSONArray)localObject2).getString(i));
        i += 1;
        continue;
        i += 1;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        QLog.e("QAssistantConfigUtils", 2, "parseJson has exception strJson = " + paramString, paramList);
        return localArrayList;
      }
    }
  }
  
  public static String n(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("MOBILEQQ_QASSISTANT_CONFIG", 4).getString("QASSISTANT_CONTEXT" + paramQQAppInterface.getCurrentAccountUin(), "");
  }
  
  public static void r(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("MOBILEQQ_QASSISTANT_CONFIG", 4).edit();
    localEditor.putString("QASSISTANT_CONTEXT" + paramQQAppInterface.getCurrentAccountUin(), paramString);
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljk
 * JD-Core Version:    0.7.0.1
 */