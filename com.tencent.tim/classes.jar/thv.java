import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.ark.open.ArkView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;
import com.tencent.gdtad.api.interstitial.GdtInterstitialView.2;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class thv
  implements tgn
{
  private ArkView a;
  
  public thv(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    this.a = a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus);
  }
  
  private static ArkView a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    WeakReference localWeakReference = new WeakReference(paramGdtInterstitialStatus);
    if (paramGdtInterstitialParams != null) {}
    for (paramGdtInterstitialStatus = paramGdtInterstitialParams.getTraceId();; paramGdtInterstitialStatus = null)
    {
      try
      {
        localthi = tho.a().a();
        str = a(paramContext, paramGdtInterstitialParams);
        tkw.i("GdtInterstitialView", String.format("load appName:%s view:%s minver:%s", new Object[] { localthi.appName, localthi.appView, localthi.minVersion }));
        l = System.currentTimeMillis();
        paramContext = new ArkView(paramContext, null);
        if (paramGdtInterstitialParams == null) {}
      }
      catch (Throwable paramGdtInterstitialParams)
      {
        thi localthi;
        String str;
        long l;
        paramContext = null;
      }
      try
      {
        if ((paramGdtInterstitialParams.width >= 0) && (paramGdtInterstitialParams.height >= 0))
        {
          paramGdtInterstitialParams = new ArkAppInfo.Size(paramGdtInterstitialParams.width, paramGdtInterstitialParams.height);
          paramContext.setSize(paramGdtInterstitialParams, paramGdtInterstitialParams, paramGdtInterstitialParams);
        }
        paramContext.setBorderType(0);
        paramContext.load(localthi.appName, localthi.appView, localthi.minVersion, str, null, new thw(l, paramGdtInterstitialStatus, localWeakReference));
        return paramContext;
      }
      catch (Throwable paramGdtInterstitialParams)
      {
        break;
      }
    }
    AdLog.e("GdtInterstitialView", "createView", paramGdtInterstitialParams);
    return paramContext;
  }
  
  private static String a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    if ((paramGdtInterstitialParams == null) || (!paramGdtInterstitialParams.iD()))
    {
      tkw.e("GdtInterstitialView", "getMetaData error");
      return null;
    }
    String str;
    if (paramGdtInterstitialParams.orientation == 1) {
      str = "vertical";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str))
      {
        tkw.e("GdtInterstitialView", "getMetaData error");
        return null;
        if ((paramGdtInterstitialParams.orientation == 0) || (paramGdtInterstitialParams.orientation == 8)) {
          str = "horizontal";
        }
      }
      else
      {
        int i = tls.pxToDp(paramContext, paramGdtInterstitialParams.width);
        int j = tls.pxToDp(paramContext, paramGdtInterstitialParams.height);
        tkw.i("GdtInterstitialView", String.format("getMetaData width:%d height:%d ptWidth:%d ptHeight:%d", new Object[] { Integer.valueOf(paramGdtInterstitialParams.width), Integer.valueOf(paramGdtInterstitialParams.height), Integer.valueOf(i), Integer.valueOf(j) }));
        try
        {
          paramContext = new JSONObject();
          paramContext.put("screenType", str);
          paramGdtInterstitialParams = tkv.pbToJson(paramGdtInterstitialParams.a.ad.info);
          if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams != JSONObject.NULL)) {
            paramContext.put("adInfo", paramGdtInterstitialParams);
          }
          paramContext.put("viewWidth", i);
          paramContext.put("viewHeight", j);
          paramGdtInterstitialParams = new JSONObject();
          paramGdtInterstitialParams.put("gdt", paramContext);
          paramContext = paramGdtInterstitialParams.toString();
          return paramContext;
        }
        catch (Throwable paramContext)
        {
          tkw.e("GdtInterstitialView", "getMetaData", paramContext);
          return null;
        }
      }
      str = null;
    }
  }
  
  private static void r(int paramInt1, int paramInt2, String paramString)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialView.2(paramString, paramInt1, paramInt2), 0);
  }
  
  public void destroy(Context paramContext)
  {
    tkw.i("GdtInterstitialView", "destroy");
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public View getView()
  {
    return this.a;
  }
  
  public void pause(Context paramContext)
  {
    tkw.i("GdtInterstitialView", "pause");
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void resume(Context paramContext)
  {
    tkw.i("GdtInterstitialView", "resume");
    if (this.a != null) {
      this.a.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thv
 * JD-Core Version:    0.7.0.1
 */