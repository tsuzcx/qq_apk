import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.form.GdtFormData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zal
{
  private static zan a(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    zan localzan = new zan(null);
    localzan.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
    localzan.method = "POST";
    localzan.contentType = "application/json";
    localzan.connectTimeoutMillis = 5000;
    localzan.readTimeoutMillis = 5000;
    localzan.requestData = a(paramGdtAd, paramGdtFormData);
    return localzan;
  }
  
  public static void a(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    if (!a(paramGdtAd, paramGdtFormData))
    {
      yxp.d("GdtFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    for (;;)
    {
      zan localzan;
      if (i < 3)
      {
        if (!a(paramGdtAd, paramGdtFormData))
        {
          yxp.d("GdtFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        localzan = a(paramGdtAd, paramGdtFormData);
        if (localzan != null) {}
      }
      else
      {
        yxp.d("GdtFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      AdHttp.send(localzan);
      a(paramGdtAd, paramGdtFormData, localzan);
      if ((localzan.isSuccess()) && (localzan.a == 0)) {
        break;
      }
      i += 1;
    }
  }
  
  private static void a(GdtAd paramGdtAd, GdtFormData paramGdtFormData, zan paramzan)
  {
    if ((paramzan == null) || (!paramzan.isSuccess()) || (!a(paramGdtAd, paramGdtFormData)))
    {
      yxp.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramGdtAd = new JSONObject(new String(paramzan.responseData, "UTF-8"));
      paramzan.a = paramGdtAd.getInt("code");
      String str = paramGdtAd.optString("message");
      yxp.b("GdtFormPrefetchTokenUtil", "onResponse code:" + paramzan.a + " message:" + str);
      if (paramzan.a == 0)
      {
        paramGdtFormData.tokenForUpload = paramGdtAd.getJSONObject("data").getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramGdtAd)
    {
      yxp.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
      return;
      yxp.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramGdtAd)
    {
      yxp.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
    }
  }
  
  private static boolean a(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    return (paramGdtAd != null) && (paramGdtAd.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId())) && (paramGdtFormData != null) && (paramGdtFormData.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId()));
  }
  
  private static byte[] a(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    JSONArray localJSONArray = zar.a(paramGdtFormData);
    if ((!a(paramGdtAd, paramGdtFormData)) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      yxp.d("GdtFormPrefetchTokenUtil", "getRequestData error");
      return null;
    }
    Object localObject = yzf.a(paramGdtAd);
    long l;
    if (localObject != null) {
      if (!((GdtCanvasData)localObject).isValid()) {
        l = -2147483648L;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (l != -2147483648L) {
          ((JSONObject)localObject).put("pageId", l);
        }
        ((JSONObject)localObject).put("traceId", paramGdtAd.getTraceId());
        ((JSONObject)localObject).put("formId", paramGdtFormData.formId);
        ((JSONObject)localObject).put("formValue", localJSONArray.toString());
        paramGdtAd = ((JSONObject)localObject).toString().getBytes("UTF-8");
        return paramGdtAd;
      }
      catch (JSONException paramGdtAd)
      {
        yxp.d("GdtFormPrefetchTokenUtil", "getRequestData", paramGdtAd);
        return null;
      }
      catch (UnsupportedEncodingException paramGdtAd)
      {
        yxp.d("GdtFormPrefetchTokenUtil", "getRequestData", paramGdtAd);
        return null;
      }
      l = ((GdtCanvasData)localObject).pageId;
      continue;
      l = -2147483648L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zal
 * JD-Core Version:    0.7.0.1
 */