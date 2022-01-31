import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader.1;
import com.tencent.gdtad.aditem.GdtPreLoader.2;
import org.json.JSONException;
import org.json.JSONObject;

public final class ysx
{
  private static volatile ysx a;
  
  public static ysx a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ysx();
      }
      return a;
    }
    finally {}
  }
  
  private void b(GdtAd paramGdtAd)
  {
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (TextUtils.isEmpty(paramGdtAd.getCanvas()))) {}
    for (;;)
    {
      return;
      int i = paramGdtAd.getDestType();
      int j = paramGdtAd.getProductType();
      if (((i == 4) && (j == 1000)) || (paramGdtAd.isAppXiJing()) || (paramGdtAd.isAppXiJingDefault())) {}
      for (i = 1; i != 0; i = 0) {
        try
        {
          Object localObject = new JSONObject(paramGdtAd.getCanvas());
          String str = ((JSONObject)localObject).optString("canvas_json_key");
          localObject = ((JSONObject)localObject).optString("canvas_json_url");
          if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject))) {
            break label138;
          }
          yyr.a().a(paramGdtAd, str, (String)localObject);
          return;
        }
        catch (JSONException paramGdtAd)
        {
          yxs.d("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error", paramGdtAd);
          return;
        }
      }
    }
    label138:
    yxs.d("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error");
  }
  
  private void c(GdtAd paramGdtAd)
  {
    yxs.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: ad = [" + paramGdtAd + "]");
    if (!paramGdtAd.isVideoSplice()) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.2(this, paramGdtAd));
  }
  
  public void a(GdtAd paramGdtAd)
  {
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.1(this, paramGdtAd));
    c(paramGdtAd);
    b(paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ysx
 * JD-Core Version:    0.7.0.1
 */