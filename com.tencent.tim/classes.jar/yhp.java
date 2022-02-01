import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class yhp
{
  private static yho a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject2 = paramJSONObject.optString("scene", "");
    String str3 = paramJSONObject.optString("title", "");
    String str4 = paramJSONObject.optString("sceneId", "");
    String str5 = paramJSONObject.optString("kvo", "");
    String str1 = paramJSONObject.optString("startDate", "");
    String str2 = paramJSONObject.optString("expiryDate", "");
    int i = paramJSONObject.optInt("switch");
    Object localObject1 = paramJSONObject.optJSONArray("keywords");
    yho.a locala = new yho.a();
    locala.bZc = i;
    locala.aXU = str4;
    locala.aXV = ((String)localObject2);
    locala.title = str3;
    locala.aXW = str5;
    if ((!aqmr.isEmpty(str1)) && (!aqmr.isEmpty(str2))) {
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    }
    try
    {
      locala.startDate = ((SimpleDateFormat)localObject2).parse(str1);
      locala.e = ((SimpleDateFormat)localObject2).parse(str2);
      if (localObject1 != null)
      {
        locala.sF = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          str1 = ((JSONArray)localObject1).optString(i);
          if (!aqmr.isEmpty(str1)) {
            locala.sF.add(str1);
          }
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ScenesRecommendUtils", 2, "parse invalidTime failed!", localException);
      }
      localObject1 = a(locala);
      if (localObject1 == null) {
        return null;
      }
      if (!paramJSONObject.has("extra")) {}
    }
    try
    {
      ((yho)localObject1).aB(paramJSONObject.getJSONObject("extra"));
      return new yho(locala);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  private static yho a(yho.a parama)
  {
    if ((parama == null) || (parama.aXU == null)) {
      return null;
    }
    if (parama.aXU.equalsIgnoreCase("redpacket_id001")) {
      return new yhm(parama);
    }
    return new yho(parama);
  }
  
  public static List<yho> ag(String paramString)
  {
    Object localObject1;
    if (aqmr.isEmpty(paramString)) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("ScenesRecommendUtils", 2, "parseJson  strJson = " + paramString);
      }
      localArrayList = new ArrayList();
      try
      {
        Object localObject2 = new JSONObject(paramString);
        localObject1 = localArrayList;
        if (!((JSONObject)localObject2).has("scenes")) {
          continue;
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("scenes");
        int i = 0;
        for (;;)
        {
          localObject1 = localArrayList;
          if (i >= ((JSONArray)localObject2).length()) {
            break;
          }
          localObject1 = a(((JSONArray)localObject2).getJSONObject(i));
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        QLog.e("ScenesRecommendUtils", 2, "parseJson has exception strJson = " + paramString, localJSONException);
      }
    }
  }
  
  public static String n(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("MOBILEQQ_SCENESRECOMMEND_CONFIG", 4).getString("SCENESRECOMMEND_CONTEXT" + paramQQAppInterface.getCurrentAccountUin(), "");
  }
  
  public static void r(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("MOBILEQQ_SCENESRECOMMEND_CONFIG", 4).edit();
    localEditor.putString("SCENESRECOMMEND_CONTEXT" + paramQQAppInterface.getCurrentAccountUin(), paramString);
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhp
 * JD-Core Version:    0.7.0.1
 */