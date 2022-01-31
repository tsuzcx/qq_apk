import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.form.GdtFormData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class yqw
{
  private static yqy a(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    yqy localyqy = new yqy(null);
    localyqy.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
    localyqy.method = "POST";
    localyqy.contentType = "application/json";
    localyqy.connectTimeoutMillis = 5000;
    localyqy.readTimeoutMillis = 5000;
    localyqy.requestData = a(paramGdtAd, paramGdtFormData);
    return localyqy;
  }
  
  public static void a(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    if (!a(paramGdtAd, paramGdtFormData))
    {
      yny.d("GdtFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    for (;;)
    {
      yqy localyqy;
      if (i < 3)
      {
        if (!a(paramGdtAd, paramGdtFormData))
        {
          yny.d("GdtFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        localyqy = a(paramGdtAd, paramGdtFormData);
        if (localyqy != null) {}
      }
      else
      {
        yny.d("GdtFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      AdHttp.send(localyqy);
      a(paramGdtAd, paramGdtFormData, localyqy);
      if ((localyqy.isSuccess()) && (localyqy.a == 0)) {
        break;
      }
      i += 1;
    }
  }
  
  private static void a(GdtAd paramGdtAd, GdtFormData paramGdtFormData, yqy paramyqy)
  {
    if ((paramyqy == null) || (!paramyqy.isSuccess()) || (!a(paramGdtAd, paramGdtFormData)))
    {
      yny.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramGdtAd = new JSONObject(new String(paramyqy.responseData, "UTF-8"));
      paramyqy.a = paramGdtAd.getInt("code");
      String str = paramGdtAd.optString("message");
      yny.b("GdtFormPrefetchTokenUtil", "onResponse code:" + paramyqy.a + " message:" + str);
      if (paramyqy.a == 0)
      {
        paramGdtFormData.tokenForUpload = paramGdtAd.getJSONObject("data").getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramGdtAd)
    {
      yny.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
      return;
      yny.d("GdtFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramGdtAd)
    {
      yny.d("GdtFormPrefetchTokenUtil", "onResponse", paramGdtAd);
    }
  }
  
  private static boolean a(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    return (paramGdtAd != null) && (paramGdtAd.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId())) && (paramGdtFormData != null) && (paramGdtFormData.isValid()) && (!TextUtils.isEmpty(paramGdtAd.getTraceId()));
  }
  
  private static byte[] a(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    JSONArray localJSONArray = yrc.a(paramGdtFormData);
    if ((!a(paramGdtAd, paramGdtFormData)) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      yny.d("GdtFormPrefetchTokenUtil", "getRequestData error");
      return null;
    }
    Object localObject = ypo.a(paramGdtAd);
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
        yny.d("GdtFormPrefetchTokenUtil", "getRequestData", paramGdtAd);
        return null;
      }
      catch (UnsupportedEncodingException paramGdtAd)
      {
        yny.d("GdtFormPrefetchTokenUtil", "getRequestData", paramGdtAd);
        return null;
      }
      l = ((GdtCanvasData)localObject).pageId;
      continue;
      l = -2147483648L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yqw
 * JD-Core Version:    0.7.0.1
 */