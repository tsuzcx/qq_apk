import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class ljp
{
  public static float ah()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(217);
    if (Build.MODEL.startsWith("NXT")) {
      return localAladdinConfig.getFloatFromString("blow_level_android_huawei_mate_8", 0.95F);
    }
    return localAladdinConfig.getFloatFromString("blow_level_android", 1.0F);
  }
  
  public static void g(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt("ReadInJoyNoteCardShowGuideCountByRowKey_" + paramString, paramInt).apply();
  }
  
  public static void i(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("count", paramLong);
      paramContext.putString("ReadInJoyNoteCardRspCount_" + paramString, localJSONObject.toString());
      paramContext.apply();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void j(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("count", paramLong);
      paramContext.putString("ReadInJoyTodayShowGuideCount_" + paramString, localJSONObject.toString());
      paramContext.apply();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static String jv()
  {
    return Aladdin.getConfig(217).getString("zhitiao_feeds_return_maintext", "");
  }
  
  public static String jw()
  {
    return Aladdin.getConfig(217).getString("zhitiao_feeds_return_smalltext", "");
  }
  
  public static String jx()
  {
    return Aladdin.getConfig(217).getString("zhitiao_feeds_text", "");
  }
  
  public static int n(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("ReadInJoyNoteCardRspCount_" + paramString, "");
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      return 0;
      try
      {
        paramContext = new JSONObject(paramContext);
        if (DateUtils.isToday(paramContext.optLong("timeStamp")))
        {
          int i = paramContext.optInt("count");
          return i;
        }
      }
      catch (JSONException paramContext) {}
    }
    return 0;
  }
  
  public static int o(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ReadInJoyNoteCardShowGuideCountByRowKey_" + paramString, 0);
  }
  
  public static int oH()
  {
    int i = 0;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(217);
    if (localAladdinConfig != null) {
      i = localAladdinConfig.getIntegerFromString("zhitiao_feedsrefresh_type", 0);
    }
    return i;
  }
  
  public static int oI()
  {
    return Aladdin.getConfig(217).getIntegerFromString("guide_card_max_sum", 5);
  }
  
  public static int oJ()
  {
    return Aladdin.getConfig(217).getIntegerFromString("guide_card_max_daily", 3);
  }
  
  public static int p(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("ReadInJoyTodayShowGuideCount_" + paramString, "");
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      return 0;
      try
      {
        paramContext = new JSONObject(paramContext);
        if (DateUtils.isToday(paramContext.optLong("timeStamp")))
        {
          int i = paramContext.optInt("count");
          return i;
        }
      }
      catch (JSONException paramContext) {}
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljp
 * JD-Core Version:    0.7.0.1
 */