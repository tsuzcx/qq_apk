import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.proxyimpl.BannerAdAntiSpamReportUtil.1;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class asts
{
  private static long axJ;
  private static long axK;
  private static long gameStartTime;
  private static HashMap<String, Long> pY = new HashMap();
  
  public static void F(Context paramContext, String paramString, long paramLong)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramContext = GameRuntimeLoaderManager.g().getBindRuntimeLoader(paramContext);
    } while (paramContext == null);
    String str = paramContext.getJsVersion();
    paramContext = paramContext.getGameEngine();
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getLastClicks())
    {
      jdMethod_do(a(paramString, 5, str, paramContext, paramLong));
      return;
    }
  }
  
  private static Bundle a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        paramString1 = rk(paramString1);
        localBundle.putString("viewid", paramString1);
        localBundle.putInt("lt", paramInt);
        localBundle.putInt("ig", 0);
        localBundle.putString("refer", "");
        localBundle.putInt("at", 0);
        localBundle.putInt("fh", 1);
        localBundle.putString("wlf", paramString2);
        localBundle.putString("dl", "");
        localBundle.putInt("s", 0);
        localBundle.putString("lc", paramString3);
        if (paramInt == 0)
        {
          long l2 = System.currentTimeMillis();
          l1 = l2;
          if (!TextUtils.isEmpty(paramString1))
          {
            pY.put(paramString1, Long.valueOf(l2));
            l1 = l2;
          }
          localBundle.putLong("it", l1);
          localBundle.putLong("st", gameStartTime);
          localBundle.putLong("ent", io());
          localBundle.putLong("et", paramLong);
          localBundle.putLong("ct", 0L);
          localBundle.putLong("ud", ip());
          return localBundle;
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = (Long)pY.get(paramString1);
          if (paramString1 != null)
          {
            l1 = paramString1.longValue();
            continue;
          }
        }
        long l1 = 0L;
      }
      catch (Exception paramString1)
      {
        QLog.e("BannerAdAntiSpamReportUtil", 1, "createReportString error.", paramString1);
        return localBundle;
      }
    }
  }
  
  public static JSONObject a(IMiniAppContext paramIMiniAppContext, String paramString)
  {
    Object localObject = null;
    if ((!(paramIMiniAppContext instanceof GameRuntime)) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramIMiniAppContext = (GameRuntime)paramIMiniAppContext;
    String str = paramIMiniAppContext.getJsVersion();
    paramIMiniAppContext = paramIMiniAppContext.getGameEngine();
    if (paramIMiniAppContext == null) {}
    for (paramIMiniAppContext = localObject;; paramIMiniAppContext = paramIMiniAppContext.getLastClicks()) {
      return a(paramString, 3, str, paramIMiniAppContext, 0L);
    }
  }
  
  private static JSONObject a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    return e(a(paramString1, paramInt, paramString2, paramString3, paramLong));
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if ((!(paramIMiniAppContext instanceof GameRuntime)) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramIMiniAppContext = (GameRuntime)paramIMiniAppContext;
    String str = paramIMiniAppContext.getJsVersion();
    paramIMiniAppContext = paramIMiniAppContext.getGameEngine();
    if (paramIMiniAppContext == null) {}
    for (paramIMiniAppContext = null;; paramIMiniAppContext = paramIMiniAppContext.getLastClicks())
    {
      a(paramString, 0, str, paramIMiniAppContext, 0L);
      return;
    }
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext, String paramString, long paramLong)
  {
    if ((!(paramIMiniAppContext instanceof GameRuntime)) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramIMiniAppContext = (GameRuntime)paramIMiniAppContext;
    String str = paramIMiniAppContext.getJsVersion();
    paramIMiniAppContext = paramIMiniAppContext.getGameEngine();
    if (paramIMiniAppContext == null) {}
    for (paramIMiniAppContext = null;; paramIMiniAppContext = paramIMiniAppContext.getLastClicks())
    {
      jdMethod_do(a(paramString, 5, str, paramIMiniAppContext, paramLong));
      return;
    }
  }
  
  public static JSONObject b(Context paramContext, String paramString)
  {
    Object localObject = null;
    paramContext = GameRuntimeLoaderManager.g().getBindRuntimeLoader(paramContext);
    if (paramContext == null) {
      return null;
    }
    String str = paramContext.getJsVersion();
    paramContext = paramContext.getGameEngine();
    if (paramContext == null) {}
    for (paramContext = localObject;; paramContext = paramContext.getLastClicks()) {
      return a(paramString, 3, str, paramContext, 0L);
    }
  }
  
  public static void de(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramContext = GameRuntimeLoaderManager.g().getBindRuntimeLoader(paramContext);
    } while (paramContext == null);
    String str = paramContext.getJsVersion();
    paramContext = paramContext.getGameEngine();
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getLastClicks())
    {
      a(paramString, 0, str, paramContext, 0L);
      return;
    }
  }
  
  public static void jdMethod_do(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    QLog.i("BannerAdAntiSpamReportUtil", 1, "reportParams=" + paramBundle.toString());
    ThreadManager.excute(new BannerAdAntiSpamReportUtil.1(paramBundle), 128, null, true);
  }
  
  private static JSONObject e(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      String str;
      Object localObject;
      try
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = paramBundle.get(str);
          if ((localObject instanceof String)) {
            localJSONObject.put(str, paramBundle.getString(str));
          }
        }
        else
        {
          return localJSONObject;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("BannerAdAntiSpamReportUtil", 1, "paramsToJson error.", paramBundle);
      }
      if ((localObject instanceof Integer)) {
        localJSONObject.put(str, paramBundle.getInt(str));
      } else if ((localObject instanceof Long)) {
        localJSONObject.put(str, paramBundle.getLong(str));
      }
    }
  }
  
  public static void esi()
  {
    gameStartTime = System.currentTimeMillis();
    axJ = System.currentTimeMillis();
    axK = 0L;
  }
  
  private static long io()
  {
    return Math.max(axJ, gameStartTime);
  }
  
  private static long ip()
  {
    return axK + System.currentTimeMillis() - io();
  }
  
  public static void onStart()
  {
    axJ = System.currentTimeMillis();
  }
  
  public static void onStop()
  {
    axK += System.currentTimeMillis() - axJ;
  }
  
  private static String rk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = Uri.parse(paramString).getQueryParameter("viewid");
      paramString = str;
    } while (str != null);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asts
 * JD-Core Version:    0.7.0.1
 */