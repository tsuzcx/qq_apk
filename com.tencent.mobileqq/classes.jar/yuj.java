import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.1;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.2;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.3;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.4;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.5;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.6;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.7;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class yuj
  implements alpx
{
  private static int a(int paramInt)
  {
    int j = 1;
    int i;
    if ((paramInt == 101) || (paramInt == 102) || (paramInt == 106)) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        if (paramInt == 103) {
          return 207;
        }
        i = j;
      } while (paramInt == 104);
      i = j;
    } while (paramInt == 105);
    yxp.d("GdtInterstitialNotifyReg", String.format("getError arkScriptError:%d not working", new Object[] { Integer.valueOf(paramInt) }));
    return 1;
  }
  
  private static int a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if ((localJSONObject != null) && (localJSONObject != JSONObject.NULL))
        {
          int i = localJSONObject.getInt("errCode");
          return i;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      yxp.d("GdtInterstitialNotifyReg", String.format("getError params:%s", new Object[] { paramString }), localThrowable);
    }
    return -2147483648;
  }
  
  private static GdtAd a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new JSONObject(paramString);
        if ((localObject != null) && (localObject != JSONObject.NULL))
        {
          localObject = ((JSONObject)localObject).getJSONObject("adInfo");
          if ((localObject != null) && (localObject != JSONObject.NULL))
          {
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
            if (localObject != null)
            {
              localObject = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
              boolean bool = ((GdtAd)localObject).isValid();
              if (bool) {
                return localObject;
              }
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      yxp.b("GdtInterstitialNotifyReg", String.format("getAd params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new JSONObject(paramString);
        if ((localObject != null) && (localObject != JSONObject.NULL))
        {
          localObject = ((JSONObject)localObject).getString("url");
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      yxp.d("GdtInterstitialNotifyReg", String.format("getUrl params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    paramContext = new WeakReference(paramContext);
    ArkAppCenter.a().postToArkThread(new GdtInterstitialNotifyReg.1(paramContext, paramGdtInterstitialParams));
  }
  
  private boolean a(String paramString)
  {
    paramString = a(paramString);
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      yxp.b("GdtInterstitialNotifyReg", String.format("receiveHTTPGet %b %s", new Object[] { Boolean.valueOf(bool), paramString }));
      return bool;
      AdHttp.Params localParams = new AdHttp.Params();
      localParams.setUrl(paramString);
      localParams.method = "GET";
      if (!localParams.canSend()) {
        bool = false;
      } else {
        bool = AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.3(this, localParams), 4);
      }
    }
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    paramContext = new WeakReference(paramContext);
    ArkAppCenter.a().postToArkThread(new GdtInterstitialNotifyReg.2(paramContext, paramGdtInterstitialParams));
  }
  
  private boolean b(String paramString)
  {
    paramString = a(paramString);
    boolean bool;
    if (paramString != null) {
      if (!paramString.isValid()) {
        bool = false;
      }
    }
    for (;;)
    {
      yxp.b("GdtInterstitialNotifyReg", String.format("receiveClick %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      paramString = paramString.getTraceId();
      if (TextUtils.isEmpty(paramString))
      {
        bool = false;
      }
      else
      {
        paramString = yui.a().a(paramString);
        if (paramString != null)
        {
          if (paramString.get() == null)
          {
            bool = false;
          }
          else
          {
            AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.4(this, paramString), 0);
            bool = true;
          }
        }
        else {
          bool = false;
        }
      }
    }
  }
  
  private boolean c(String paramString)
  {
    paramString = a(paramString);
    boolean bool;
    if (paramString != null) {
      if (!paramString.isValid()) {
        bool = false;
      }
    }
    for (;;)
    {
      yxp.b("GdtInterstitialNotifyReg", String.format("receiveClose %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      paramString = paramString.getTraceId();
      if (TextUtils.isEmpty(paramString))
      {
        bool = false;
      }
      else
      {
        paramString = yui.a().a(paramString);
        if (paramString != null)
        {
          if (paramString.get() == null)
          {
            bool = false;
          }
          else
          {
            AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.5(this, paramString), 0);
            bool = true;
          }
        }
        else {
          bool = false;
        }
      }
    }
  }
  
  private boolean d(String paramString)
  {
    paramString = a(paramString);
    boolean bool;
    if (paramString != null) {
      if (!paramString.isValid()) {
        bool = false;
      }
    }
    for (;;)
    {
      yxp.b("GdtInterstitialNotifyReg", String.format("receiveLoaded %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      paramString = paramString.getTraceId();
      paramString = yui.a().a(paramString);
      if (paramString != null)
      {
        if (paramString.get() == null)
        {
          bool = false;
        }
        else
        {
          AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.6(this, paramString), 0);
          bool = true;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  private boolean e(String paramString)
  {
    GdtAd localGdtAd = a(paramString);
    int i = a(paramString);
    int j = a(i);
    yxp.d("GdtInterstitialNotifyReg", String.format("receiveError error:%d arkScriptError:%d params:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramString }));
    if ((j != 4) && (j != 207)) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while ((localGdtAd == null) || (!localGdtAd.isValid()));
        paramString = localGdtAd.getTraceId();
      } while (TextUtils.isEmpty(paramString));
      paramString = yui.a().a(paramString);
    } while ((paramString == null) || (paramString.get() == null));
    AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.7(this, paramString, j, i), 0);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    yxp.b("GdtInterstitialNotifyReg", String.format("notify appName:%s eventName:%s params:%s", new Object[] { paramString1, paramString2, paramString3 }));
    AdReporterForAnalysis.reportForARKReceiveNotification(BaseApplicationImpl.getApplication(), true, paramString2, paramString1, a(paramString3));
    if (!yui.a().a().a.equals(paramString1)) {}
    do
    {
      return false;
      if ("interstitial_http_get_event".equals(paramString2)) {
        return a(paramString3);
      }
      if ("interstitial_jump_click_event".equals(paramString2)) {
        return b(paramString3);
      }
      if ("interstitial_close_click_event".equals(paramString2)) {
        return c(paramString3);
      }
      if ("interstitial_success_event".equals(paramString2)) {
        return d(paramString3);
      }
    } while (!"interstitial_error_event".equals(paramString2));
    return e(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yuj
 * JD-Core Version:    0.7.0.1
 */