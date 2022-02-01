package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.RC4;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import java.util.Random;
import org.json.JSONObject;

public class e
{
  public static String a(Context paramContext)
  {
    Object localObject2 = d.a(paramContext, "xg.mta.ui", "");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = CustomDeviceInfos.getFacilityIdentity(paramContext);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = Integer.toString(new Random().nextInt(2147483647));
    }
    d.b(paramContext, "xg.mta.ui", (String)localObject2);
    return localObject2;
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (Build.VERSION.SDK_INT < 8);
    try
    {
      str = new String(RC4.decrypt(Base64.decode(paramString.getBytes("UTF-8"), 0)), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("XgStat", "decode error", localThrowable);
    }
    return paramString;
  }
  
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramString2 != null) {}
    try
    {
      if (paramString2.length() > 0) {
        paramJSONObject.put(paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      TLogger.e("XgStat", "jsonPut error", paramJSONObject);
    }
  }
  
  public static Context b(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext != null)
    {
      localContext = paramContext;
      if (paramContext.getApplicationContext() != null) {
        localContext = paramContext.getApplicationContext();
      }
    }
    return localContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.b.e
 * JD-Core Version:    0.7.0.1
 */