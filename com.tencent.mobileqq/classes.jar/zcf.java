import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.form.GdtFormData;
import com.tencent.gdtad.views.form.framework.GdtFormItemData;
import com.tencent.gdtad.views.xijing.GdtDMPReportUtil.1;
import com.tencent.gdtad.views.xijing.GdtDMPReportUtil.2;
import com.tencent.gdtad.views.xijing.GdtDMPReportUtil.3;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zcf
{
  private static AdHttp.Params a(byte[] paramArrayOfByte)
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl("https://h5.gdt.qq.com/player/actionset/report");
    localParams.method = "POST";
    localParams.contentType = "application/json";
    localParams.referer = "http://fv.gdt.qq.com";
    localParams.connectTimeoutMillis = 5000;
    localParams.readTimeoutMillis = 5000;
    localParams.requestData = paramArrayOfByte;
    return localParams;
  }
  
  private static JSONObject a(GdtAd paramGdtAd)
  {
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()))
    {
      yxs.d("GdtDMPReportUtil", "getActionParamsForDownload error");
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("app_id", paramGdtAd.getAppId());
      return localJSONObject;
    }
    catch (JSONException paramGdtAd)
    {
      yxs.d("GdtDMPReportUtil", "getActionParamsForDownload", paramGdtAd);
    }
    return null;
  }
  
  private static JSONObject a(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (paramGdtFormData == null) || (!paramGdtFormData.isValid()))
    {
      yxs.d("GdtDMPReportUtil", "getActionParamsForUpload error");
      return null;
    }
    GdtCanvasData localGdtCanvasData = yzi.a(paramGdtAd);
    for (;;)
    {
      int i;
      try
      {
        paramGdtAd = new JSONObject();
        i = 0;
        if (i < paramGdtFormData.getSize())
        {
          localObject = paramGdtFormData.getItem(i);
          if ((localObject == null) || (!((GdtFormItemData)localObject).isValid())) {
            yxs.d("GdtDMPReportUtil", "getActionParamsForUpload error");
          } else {
            paramGdtAd.put(((GdtFormItemData)localObject).title.text, ((GdtFormItemData)localObject).getResult());
          }
        }
      }
      catch (JSONException paramGdtAd)
      {
        yxs.d("GdtDMPReportUtil", "getActionParamsForUpload", paramGdtAd);
        return null;
      }
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("component_id", paramGdtFormData.formId);
      ((JSONObject)localObject).put("component_type", 1);
      ((JSONObject)localObject).put("bundle", paramGdtAd);
      if (localGdtCanvasData != null)
      {
        if (!TextUtils.isEmpty(localGdtCanvasData.commonPageId)) {
          ((JSONObject)localObject).put("common_page_id", localGdtCanvasData.commonPageId);
        }
        if (!TextUtils.isEmpty(localGdtCanvasData.name)) {
          ((JSONObject)localObject).put("page_name", localGdtCanvasData.name);
        }
        if (localGdtCanvasData.pageId != -2147483648L) {
          ((JSONObject)localObject).put("page_id", localGdtCanvasData.pageId);
        }
        if (!TextUtils.isEmpty(localGdtCanvasData.pageType)) {
          ((JSONObject)localObject).put("page_type", localGdtCanvasData.pageType);
        }
        if (!TextUtils.isEmpty(localGdtCanvasData.pageUrl)) {
          ((JSONObject)localObject).put("page_url", localGdtCanvasData.pageUrl);
        }
      }
      paramGdtFormData = new JSONObject();
      paramGdtFormData.put("form_info", paramGdtAd.toString());
      paramGdtAd = new JSONObject();
      paramGdtAd.put("custom_info", paramGdtFormData.toString());
      paramGdtAd.put("leads_standard_form_info", ((JSONObject)localObject).toString());
      return paramGdtAd;
      i += 1;
    }
  }
  
  public static JSONObject a(GdtAd paramGdtAd, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (paramGdtAd.actionSetId == -2147483648L) || (paramGdtAd.getAdvertiserId() == -2147483648L) || (TextUtils.isEmpty(paramGdtAd.getTraceId())))
    {
      yxs.d("GdtDMPReportUtil", "getRequestData error");
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("click_id", paramGdtAd.getTraceId());
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("action_time", l / 1000L);
      localJSONObject1.put("action_type", paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject1.put("custom_action", paramString2);
      }
      if ((paramJSONObject != null) && (paramJSONObject != JSONObject.NULL)) {
        localJSONObject1.put("action_param", paramJSONObject);
      }
      localJSONObject1.put("user_action_set_id", paramGdtAd.actionSetId);
      localJSONObject1.put("url", paramString3);
      localJSONObject1.put("trace", localJSONObject2);
      paramJSONObject = new JSONArray();
      paramJSONObject.put(0, localJSONObject1);
      paramString1 = new JSONObject();
      paramString1.put("account_id", paramGdtAd.getAdvertiserId());
      paramString1.put("actions", paramJSONObject);
      paramString1.put("signature", paramGdtAd.getTraceId() + l);
      return paramString1;
    }
    catch (JSONException paramGdtAd)
    {
      yxs.d("GdtDMPReportUtil", "getRequestData", paramGdtAd);
    }
    return null;
  }
  
  public static zai a(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    paramGdtFormData = a(paramGdtAd, paramGdtFormData);
    paramGdtAd = a(a(paramGdtAd, paramGdtFormData, "RESERVATION", null, "http://fv.gdt.qq.com"));
    if ((paramGdtFormData == null) || (paramGdtFormData == JSONObject.NULL) || (paramGdtAd == null) || (paramGdtAd.length <= 0))
    {
      yxs.d("GdtDMPReportUtil", "reportUpload error");
      return new zai(4, -1, null);
    }
    int i = 0;
    for (;;)
    {
      if (i < 3)
      {
        paramGdtFormData = a(paramGdtAd);
        if (paramGdtFormData != null) {}
      }
      else
      {
        yxs.d("GdtDMPReportUtil", "reportUpload error");
        return new zai(4, -1, null);
      }
      AdHttp.send(paramGdtFormData);
      if (paramGdtFormData.isSuccess()) {
        return new zai(1, -1, null);
      }
      i += 1;
    }
  }
  
  public static void a(GdtAd paramGdtAd)
  {
    AdThreadManager.INSTANCE.post(new GdtDMPReportUtil.1(paramGdtAd), 4);
  }
  
  public static byte[] a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL)) {
      return null;
    }
    try
    {
      paramJSONObject = paramJSONObject.toString().getBytes("UTF-8");
      return paramJSONObject;
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      yxs.d("GdtDMPReportUtil", "getRequestData", paramJSONObject);
    }
    return null;
  }
  
  public static void b(GdtAd paramGdtAd)
  {
    AdThreadManager.INSTANCE.post(new GdtDMPReportUtil.2(paramGdtAd), 4);
  }
  
  public static void c(GdtAd paramGdtAd)
  {
    AdThreadManager.INSTANCE.post(new GdtDMPReportUtil.3(paramGdtAd), 4);
  }
  
  private static boolean d(GdtAd paramGdtAd)
  {
    paramGdtAd = a(a(paramGdtAd, a(paramGdtAd), "CUSTOM", "DOWNLOAD_CLICK", "http://fv.gdt.qq.com"));
    if ((paramGdtAd == null) || (paramGdtAd.length <= 0)) {
      yxs.d("GdtDMPReportUtil", "reportAppBtnClick error");
    }
    for (;;)
    {
      return false;
      int i = 0;
      while (i < 3)
      {
        AdHttp.Params localParams = a(paramGdtAd);
        AdHttp.send(localParams);
        if ((localParams != null) && (localParams.isSuccess()))
        {
          yxs.b("GdtDMPReportUtil", "reportAppBtnClick success");
          return true;
        }
        yxs.d("GdtDMPReportUtil", "reportAppBtnClick error");
        i += 1;
      }
    }
  }
  
  private static boolean e(GdtAd paramGdtAd)
  {
    if ((paramGdtAd == null) || (TextUtils.isEmpty(paramGdtAd.getCanvas()))) {}
    for (;;)
    {
      return false;
      Object localObject1 = new JSONObject();
      int i;
      try
      {
        Object localObject2 = new JSONObject(paramGdtAd.getCanvas()).getJSONObject("content").getJSONObject("pageConfig");
        String str = ((JSONObject)localObject2).getString("pageId");
        localObject2 = ((JSONObject)localObject2).getString("pageUrl");
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          continue;
        }
        ((JSONObject)localObject1).put("object", "product");
        ((JSONObject)localObject1).put("page_id", str);
        ((JSONObject)localObject1).put("page_url", localObject2);
        paramGdtAd = a(a(paramGdtAd, (JSONObject)localObject1, "VIEW_CONTENT", null, null));
        if ((paramGdtAd == null) || (paramGdtAd.length <= 0))
        {
          yxs.d("GdtDMPReportUtil", "reportOpenWebPage error");
          return false;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        i = 0;
      }
      while (i < 3)
      {
        localObject1 = a(paramGdtAd);
        AdHttp.send((AdHttp.Params)localObject1);
        if ((localObject1 != null) && (((AdHttp.Params)localObject1).isSuccess())) {
          return true;
        }
        yxs.d("GdtDMPReportUtil", "reportOpenWebPage error");
        i += 1;
      }
    }
  }
  
  private static boolean f(GdtAd paramGdtAd)
  {
    paramGdtAd = a(a(paramGdtAd, null, "VIEW_CONTENT", null, "http://fv.gdt.qq.com"));
    if ((paramGdtAd == null) || (paramGdtAd.length <= 0)) {
      yxs.d("GdtDMPReportUtil", "reportLoad error");
    }
    for (;;)
    {
      return false;
      int i = 0;
      while (i < 3)
      {
        AdHttp.Params localParams = a(paramGdtAd);
        AdHttp.send(localParams);
        if ((localParams != null) && (localParams.isSuccess())) {
          return true;
        }
        yxs.d("GdtDMPReportUtil", "reportLoad error");
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zcf
 * JD-Core Version:    0.7.0.1
 */