import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class kys
  implements AladdinConfigHandler
{
  private static int aML = 41505;
  private static int aMM;
  private static String adN;
  private static String adO;
  private static String adP;
  private static String adQ;
  private static boolean aiM;
  
  public static boolean Bk()
  {
    return aiM;
  }
  
  public static boolean Bl()
  {
    boolean bool = true;
    if (Bk()) {
      return false;
    }
    if (Aladdin.getConfig(157).getIntegerFromString("enable_dynamic_header", 0) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void aIj()
  {
    aiM = "1".equals((String)awit.f("readinjoy_daily_mode_refresh_mode", "0"));
    aML = ((Integer)awit.f("readinjoy_daily_mode_channel_id", Integer.valueOf(41505))).intValue();
    if (!awit.aME())
    {
      QLog.i("DailyModeConfigHandler", 1, "非独立看点->进入无限流 refreshDailyConfig   " + aML);
      aML = 41697;
    }
    if (du(aML)) {
      aiM = true;
    }
    QLog.i("DailyModeConfigHandler", 1, "refreshDailyConfig " + aiM + "  " + aML);
    aMM = aML;
    if (kxm.isFromAIO) {
      aML = 41697;
    }
  }
  
  public static void aIk()
  {
    aML = aMM;
  }
  
  public static float af()
  {
    Float localFloat = (Float)awit.f("readinjoy_daily_mode_drag_threshold", Float.valueOf(1.0F));
    QLog.d("DailyModeConfigHandler", 1, "[getJumpThreshold] " + localFloat);
    if ((localFloat.floatValue() > 0.001D) && (localFloat.floatValue() < 10.0F)) {
      return localFloat.floatValue();
    }
    return 1.0F;
  }
  
  public static boolean dt(int paramInt)
  {
    return paramInt == 41505;
  }
  
  public static boolean du(int paramInt)
  {
    if (dt(aML)) {}
    while (aML != paramInt) {
      return false;
    }
    return true;
  }
  
  public static boolean dv(int paramInt)
  {
    if (dt(paramInt)) {
      return true;
    }
    return du(paramInt);
  }
  
  public static int getChannelId()
  {
    return aML;
  }
  
  public static String getJumpUrl()
  {
    if (adO != null) {
      return adO;
    }
    adO = (String)awit.f("readinjoy_daily_mode_bottom_jump", "");
    return adO;
  }
  
  public static int getMode()
  {
    if (du(aML))
    {
      QLog.d("DailyModeConfigHandler", 1, "[getMode] isDailyUnlimitChannel MODE_LOAD_MORE");
      return 2;
    }
    Integer localInteger = (Integer)awit.f("readinjoy_daily_mode_plan_number", Integer.valueOf(-1));
    QLog.d("DailyModeConfigHandler", 1, "[getMode] " + localInteger);
    if (localInteger.intValue() == 2) {
      return 2;
    }
    if (localInteger.intValue() == 1) {
      return 1;
    }
    return 3;
  }
  
  public static String ja()
  {
    if (kge.getMode() == 1) {
      return "1";
    }
    if (adP != null) {
      return adP;
    }
    adP = (String)awit.f("readinjoy_daily_mode_bottom_jump_src", "0");
    return adP;
  }
  
  public static void mM(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        adN = paramString.optString("bottom_text");
        adO = paramString.optString("jump_url");
        adP = paramString.optString("jump_src");
        adQ = paramString.optString("ReadInjoy_daily_footer_pts");
        if (adN != null) {
          awit.H("readinjoy_daily_mode_bottom_text", adN);
        }
        if (adO != null) {
          awit.H("readinjoy_daily_mode_bottom_jump", adO);
        }
        if (adP != null) {
          awit.H("readinjoy_daily_mode_bottom_jump_src", adP);
        }
        if (adQ != null)
        {
          awit.H("readinjoy_daily_mode_footer_pts", adQ);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void reset()
  {
    QLog.d("DailyModeConfigHandler", 1, "DailyModeConfigHandler reset.");
    adN = null;
    adO = null;
    adP = null;
    adQ = null;
  }
  
  public static JSONObject z()
  {
    if (TextUtils.isEmpty(adQ)) {
      adQ = (String)awit.f("readinjoy_daily_mode_footer_pts", "");
    }
    QLog.i("DailyModeConfigHandler", 1, "getFooterData pts = " + adQ);
    try
    {
      JSONObject localJSONObject1 = new JSONObject(adQ);
      return localJSONObject1;
    }
    catch (JSONException localJSONException1)
    {
      QLog.e("DailyModeConfigHandler", 1, "getFooterData e = " + localJSONException1);
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("style_ID", "ReadInjoy_daily_footer");
        localJSONObject2.put("title_EN", "TENCENT KANDIAN");
        return localJSONObject2;
      }
      catch (JSONException localJSONException2)
      {
        QLog.e("DailyModeConfigHandler", 1, "getFooterData e = " + localJSONException2);
      }
      return localJSONObject2;
    }
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("DailyModeConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = kye.i(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("DailyModeConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "daily_plan_number")) {
        awit.H("readinjoy_daily_mode_plan_number", Integer.valueOf(str2));
      } else if (TextUtils.equals(str1, "daily_drag_threshold")) {
        awit.H("readinjoy_daily_mode_drag_threshold", Float.valueOf(str2));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("DailyModeConfigHandler", 1, "[onWipeConfig]");
    awit.H("readinjoy_daily_mode_plan_number", Integer.valueOf(-1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kys
 * JD-Core Version:    0.7.0.1
 */