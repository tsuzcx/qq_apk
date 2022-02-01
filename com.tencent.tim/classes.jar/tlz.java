import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasDataBuilderV2;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.gdtad.aditem.GdtAd;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class tlz
{
  private static tlz.a a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    tlz.a locala = new tlz.a(null);
    locala.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
    locala.method = "POST";
    locala.contentType = "application/json";
    locala.connectTimeoutMillis = 5000;
    locala.readTimeoutMillis = 5000;
    locala.requestData = a(paramContext, paramGdtAd, paramAdFormData);
    return locala;
  }
  
  private static void a(GdtAd paramGdtAd, AdFormData paramAdFormData, tlz.a parama)
  {
    if ((parama == null) || (!parama.isSuccess()) || (!a(paramGdtAd, paramAdFormData)))
    {
      tkw.e("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramGdtAd = new JSONObject(new String(parama.responseData, "UTF-8"));
      parama.returnCode = paramGdtAd.getInt("code");
      String str = paramGdtAd.optString("message");
      tkw.i("GdtFormPrefetchTokenUtil", "onResponse code:" + parama.returnCode + " message:" + str);
      if (parama.returnCode == 0)
      {
        paramAdFormData.tokenForUpload = paramGdtAd.getJSONObject("data").getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramGdtAd)
    {
      tkw.e("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
      return;
      tkw.e("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramGdtAd)
    {
      tkw.e("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
    }
  }
  
  private static boolean a(GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    return (paramGdtAd != null) && (paramGdtAd.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId())) && (paramAdFormData != null) && (paramAdFormData.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId()));
  }
  
  private static byte[] a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = tmd.a(paramAdFormData);
    if ((!a(paramGdtAd, paramAdFormData)) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      tkw.e("GdtFormPrefetchTokenUtil", "getRequestData error");
      return null;
    }
    paramContext = AdCanvasDataBuilderV2.build(paramContext, paramGdtAd);
    long l;
    if (paramContext != null) {
      if (!paramContext.isValid()) {
        l = -2147483648L;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = new JSONObject();
        if (l != -2147483648L) {
          paramContext.put("pageId", l);
        }
        paramContext.put("traceId", paramGdtAd.getTraceId());
        paramContext.put("formId", paramAdFormData.formId);
        paramContext.put("formValue", localJSONArray.toString());
        paramContext = paramContext.toString().getBytes("UTF-8");
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        tkw.e("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        tkw.e("GdtFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      l = paramContext.pageId;
      continue;
      l = -2147483648L;
    }
  }
  
  public static void b(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    if (!a(paramGdtAd, paramAdFormData))
    {
      tkw.e("GdtFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    for (;;)
    {
      tlz.a locala;
      if (i < 3)
      {
        if (!a(paramGdtAd, paramAdFormData))
        {
          tkw.e("GdtFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        locala = a(paramContext, paramGdtAd, paramAdFormData);
        if (locala != null) {}
      }
      else
      {
        tkw.e("GdtFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      AdHttp.send(locala);
      a(paramGdtAd, paramAdFormData, locala);
      if ((locala.isSuccess()) && (locala.returnCode == 0)) {
        break;
      }
      i += 1;
    }
  }
  
  static class a
    extends AdHttp.Params
  {
    public int returnCode = -2147483648;
    
    public boolean isSuccess()
    {
      return (super.isSuccess()) && (this.responseData != null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlz
 * JD-Core Version:    0.7.0.1
 */