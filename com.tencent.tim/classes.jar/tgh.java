import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.AdCanvas;
import com.tencent.ad.tangram.canvas.AdCanvasJsonManager;
import com.tencent.ad.tangram.offline.AdOffline;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader.1;
import com.tencent.gdtad.aditem.GdtPreLoader.2;
import org.json.JSONException;
import org.json.JSONObject;

public final class tgh
{
  private static volatile tgh a;
  
  public static tgh a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new tgh();
      }
      return a;
    }
    finally {}
  }
  
  private void b(GdtAd paramGdtAd)
  {
    int i = 0;
    AdCanvasJsonManager.getInstance().init(BaseApplicationImpl.getContext());
    if (!AdCanvas.INSTANCE.isEnable(BaseApplicationImpl.getContext())) {}
    do
    {
      do
      {
        return;
      } while ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (TextUtils.isEmpty(paramGdtAd.getCanvas())));
      if ((paramGdtAd.isWebXiJing()) || (paramGdtAd.isAppXiJing()) || (paramGdtAd.isAppXiJingDefault())) {
        i = 1;
      }
    } while (i == 0);
    try
    {
      Object localObject = new JSONObject(paramGdtAd.getCanvas());
      String str = ((JSONObject)localObject).optString("canvas_json_key");
      localObject = ((JSONObject)localObject).optString("canvas_json_url");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramGdtAd, str, false))))
      {
        AdCanvasJsonManager.getInstance().preloadCanvasJson(paramGdtAd, str, (String)localObject);
        return;
      }
    }
    catch (JSONException paramGdtAd)
    {
      tkw.e("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error", paramGdtAd);
      return;
    }
    tkw.e("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error");
  }
  
  private void c(GdtAd paramGdtAd)
  {
    if (!AdOffline.INSTANCE.isEnable(BaseApplicationImpl.getContext())) {}
    do
    {
      do
      {
        return;
      } while ((paramGdtAd == null) || (!paramGdtAd.isValid()) || ((!paramGdtAd.isAppXiJingOffline()) && (!paramGdtAd.isWebXiJingOffline())));
      AdThreadManager.INSTANCE.post(new GdtPreLoader.2(this, paramGdtAd), 5);
      AdCanvasJsonManager.getInstance().init(BaseApplicationImpl.getContext());
    } while (!TextUtils.isEmpty(AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramGdtAd, paramGdtAd.getJSONKeyForXiJingOffline(), false)));
    AdCanvasJsonManager.getInstance().preloadCanvasJson(paramGdtAd, paramGdtAd.getJSONKeyForXiJingOffline(), paramGdtAd.getJSONUrlForXiJingOffline());
  }
  
  private void d(GdtAd paramGdtAd)
  {
    tlo.a().a(BaseApplicationImpl.getContext(), null);
    if ((paramGdtAd != null) && (paramGdtAd.isInterstitial())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = tho.a().aF(BaseApplicationImpl.getContext());
      tkw.i("GdtPreLoader", String.format("preDownloadInterstitialAfterAdLoaded isInterstitial:%b isEnabled:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      if ((bool1) && (bool2)) {
        thr.a().cW(BaseApplicationImpl.getContext());
      }
      return;
    }
  }
  
  public void a(GdtAd paramGdtAd)
  {
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.1(this, paramGdtAd));
    b(paramGdtAd);
    c(paramGdtAd);
    d(paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgh
 * JD-Core Version:    0.7.0.1
 */