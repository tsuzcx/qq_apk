import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.1;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.2;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.3;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.4;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.5;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.6;
import com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.7;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.b;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class thp
  implements ArkAppNotifyCenter.b
{
  private static long R(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if ((localJSONObject != null) && (localJSONObject != JSONObject.NULL))
        {
          long l = localJSONObject.getLong("videopositionmillis");
          return l;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      tkw.e("GdtInterstitialNotifyReg", String.format("getVideoPositionMillis params:%s", new Object[] { paramString }), localThrowable);
    }
    return -2147483648L;
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
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
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
      tkw.i("GdtInterstitialNotifyReg", String.format("getAd params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  private static WeakReference<GdtInterstitialFragment> a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (!paramString.isValid())) {}
    do
    {
      return null;
      paramString = paramString.getTraceId();
    } while (TextUtils.isEmpty(paramString));
    return tho.a().a(paramString);
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus, "interstitial_view_resume_event");
  }
  
  private static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, String paramString)
  {
    ArkAppCenter.a().postToArkThread(new GdtInterstitialNotifyReg.1(paramGdtInterstitialParams, paramString));
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus, "interstitial_view_pause_event");
  }
  
  private static int by(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if ((localJSONObject != null) && (localJSONObject != JSONObject.NULL))
        {
          int i = localJSONObject.getInt("reason");
          return i;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      tkw.e("GdtInterstitialNotifyReg", String.format("getReasonForClose params:%s", new Object[] { paramString }), localThrowable);
    }
    return -2147483648;
  }
  
  private static int bz(String paramString)
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
      tkw.e("GdtInterstitialNotifyReg", String.format("getError params:%s", new Object[] { paramString }), localThrowable);
    }
    return -2147483648;
  }
  
  public static void c(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus, "interstitial_view_destroy_event");
  }
  
  private static int ew(int paramInt)
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
        do
        {
          do
          {
            do
            {
              return i;
              i = j;
            } while (paramInt == 103);
            i = j;
          } while (paramInt == 104);
          i = j;
        } while (paramInt == 105);
        i = j;
      } while (paramInt == 107);
      i = j;
    } while (paramInt == 108);
    tkw.e("GdtInterstitialNotifyReg", String.format("getError arkScriptError:%d not working", new Object[] { Integer.valueOf(paramInt) }));
    return 1;
  }
  
  private boolean gB(String paramString)
  {
    paramString = getUrl(paramString);
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      tkw.i("GdtInterstitialNotifyReg", String.format("receiveHTTPGet %b %s", new Object[] { Boolean.valueOf(bool), paramString }));
      return bool;
      AdHttp.Params localParams = new AdHttp.Params();
      localParams.setUrl(paramString);
      localParams.method = "GET";
      if (!localParams.canSend()) {
        bool = false;
      } else {
        bool = AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.2(this, localParams), 4);
      }
    }
  }
  
  private boolean gC(String paramString)
  {
    paramString = a(paramString);
    boolean bool;
    if (paramString != null) {
      if (paramString.get() == null) {
        bool = false;
      }
    }
    for (;;)
    {
      tkw.i("GdtInterstitialNotifyReg", String.format("receiveClick %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.3(this, paramString), 0);
      bool = true;
      continue;
      bool = false;
    }
  }
  
  private boolean gD(String paramString)
  {
    int i = by(paramString);
    long l = R(paramString);
    paramString = a(paramString);
    boolean bool;
    if (paramString != null) {
      if (paramString.get() == null) {
        bool = false;
      }
    }
    for (;;)
    {
      tkw.i("GdtInterstitialNotifyReg", String.format("receiveClose %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.4(this, paramString, i, l), 0);
      bool = true;
      continue;
      bool = false;
    }
  }
  
  private boolean gE(String paramString)
  {
    paramString = a(paramString);
    boolean bool;
    if (paramString != null) {
      if (paramString.get() == null) {
        bool = false;
      }
    }
    for (;;)
    {
      tkw.i("GdtInterstitialNotifyReg", String.format("receiveLoaded %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.5(this, paramString), 0);
      bool = true;
      continue;
      bool = false;
    }
  }
  
  private boolean gF(String paramString)
  {
    int i = bz(paramString);
    int j = ew(i);
    tkw.e("GdtInterstitialNotifyReg", String.format("receiveError error:%d arkScriptError:%d params:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramString }));
    if ((j != 4) && (j != 207)) {}
    do
    {
      return true;
      paramString = a(paramString);
    } while ((paramString == null) || (paramString.get() == null));
    AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.6(this, paramString, j, i), 0);
    return true;
  }
  
  private boolean gG(String paramString)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.7(this, paramString), 0);
    return true;
  }
  
  private static String getKey(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new JSONObject(paramString);
        if ((localObject != null) && (localObject != JSONObject.NULL))
        {
          localObject = ((JSONObject)localObject).getString("key");
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      tkw.e("GdtInterstitialNotifyReg", String.format("getKey params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  private static String getUrl(String paramString)
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
      tkw.e("GdtInterstitialNotifyReg", String.format("getUrl params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  public boolean notify(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    tkw.i("GdtInterstitialNotifyReg", String.format("notify appName:%s eventName:%s params:%s", new Object[] { paramString1, paramString2, paramString3 }));
    boolean bool1 = bool2;
    if (tho.a().a().appName.equals(paramString1))
    {
      if (!"interstitial_http_get_event".equals(paramString2)) {
        break label70;
      }
      bool1 = gB(paramString3);
    }
    label70:
    do
    {
      return bool1;
      if ("interstitial_jump_click_event".equals(paramString2)) {
        return gC(paramString3);
      }
      if ("interstitial_close_click_event".equals(paramString2)) {
        return gD(paramString3);
      }
      if ("interstitial_success_event".equals(paramString2)) {
        return gE(paramString3);
      }
      if ("interstitial_error_event".equals(paramString2)) {
        return gF(paramString3);
      }
      bool1 = bool2;
    } while (!"interstitial_report_event".equals(paramString2));
    getKey(paramString3);
    return gG(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thp
 * JD-Core Version:    0.7.0.1
 */