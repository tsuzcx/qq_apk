import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.gdtad.views.form.GdtFormData;
import com.tencent.gdtad.views.form.framework.GdtFormItemData;
import com.tencent.gdtad.views.form.framework.GdtFormTableData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zau
{
  public static JSONArray a(GdtFormData paramGdtFormData)
  {
    if ((paramGdtFormData == null) || (!paramGdtFormData.isValid()))
    {
      yxs.d("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramGdtFormData.table.getSize())
    {
      Object localObject = paramGdtFormData.table.getItem(i);
      if ((localObject == null) || (!((GdtFormItemData)localObject).isValid())) {
        yxs.d("GdtFormUploadUtil", "toJson error");
      }
      for (;;)
      {
        i += 1;
        break;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("name", ((GdtFormItemData)localObject).title.text);
          localJSONObject.put("require", ((GdtFormItemData)localObject).required);
          if ((localObject instanceof GdtFormItemTextBoxData))
          {
            localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
            localJSONObject.put("regexType", ((GdtFormItemTextBoxData)localObject).regexType);
            localJSONObject.put("value", ((GdtFormItemTextBoxData)localObject).getResult());
          }
          localJSONArray.put(i, localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          yxs.d("GdtFormUploadUtil", "toJson", localJSONException);
        }
      }
    }
    return localJSONArray;
  }
  
  public static zai a(GdtFormData paramGdtFormData)
  {
    byte[] arrayOfByte = a(paramGdtFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      yxs.d("GdtFormUploadUtil", "upload error");
      localObject = new zai(4, -1, null);
      return localObject;
    }
    zai localzai = new zai(4, -1, null);
    int i = 0;
    for (;;)
    {
      zaw localzaw;
      if (i < 3)
      {
        localzaw = a(arrayOfByte);
        if (localzaw != null) {}
      }
      else
      {
        yxs.d("GdtFormUploadUtil", "upload error");
        return localzai;
      }
      AdHttp.send(localzaw);
      if (localzaw.isSuccess()) {
        localzai = a(paramGdtFormData, localzaw);
      }
      localObject = localzai;
      if (localzaw.a == 0) {
        break;
      }
      localObject = localzai;
      if (localzaw.a == 1) {
        break;
      }
      localObject = localzai;
      if (localzaw.a == 2) {
        break;
      }
      localObject = localzai;
      if (localzaw.a == 4) {
        break;
      }
      i += 1;
    }
  }
  
  private static zai a(GdtFormData paramGdtFormData, zaw paramzaw)
  {
    if ((paramGdtFormData == null) || (!paramGdtFormData.isValid()) || (paramzaw == null) || (!paramzaw.isSuccess()))
    {
      yxs.d("GdtFormUploadUtil", "commit error");
      paramzaw = new zai(4, -1, null);
      return paramzaw;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(paramzaw.responseData, "UTF-8"));
      paramzaw.a = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      yxs.b("GdtFormUploadUtil", "parseResponse code:" + paramzaw.a + " message:" + (String)localObject1);
      if (paramzaw.a == 0)
      {
        paramGdtFormData = new zai(1, -1, null);
        return paramGdtFormData;
      }
    }
    catch (UnsupportedEncodingException paramGdtFormData)
    {
      yxs.d("GdtFormUploadUtil", "parseResponse", paramGdtFormData);
      return new zai(4, -1, null);
      if (paramzaw.a != 1) {
        break label446;
      }
      localObject1 = new zai(4, -1, null);
      paramzaw = ((JSONObject)localObject2).getJSONObject("data");
      if ((paramzaw == null) || (paramzaw == JSONObject.NULL))
      {
        yxs.d("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramGdtFormData)
    {
      yxs.d("GdtFormUploadUtil", "parseResponse", paramGdtFormData);
      return new zai(4, -1, null);
    }
    Object localObject2 = paramzaw.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramGdtFormData.table.getSize())
    {
      yxs.d("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      paramzaw = (zaw)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      paramzaw = paramGdtFormData.table.getItem(i);
      if ((paramzaw == null) || (!paramzaw.isValid()))
      {
        yxs.d("GdtFormUploadUtil", "parseResponse error");
        return new zai(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (localJSONObject == JSONObject.NULL))
      {
        yxs.d("GdtFormUploadUtil", "parseResponse error");
        return new zai(4, i, paramzaw.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new zai(5, i, paramzaw.title.text);
        }
        if (j == 2) {
          return new zai(6, i, paramzaw.title.text);
        }
        yxs.d("GdtFormUploadUtil", "parseResponse error");
        return new zai(4, i, paramzaw.title.text);
        label446:
        if (paramzaw.a == 3) {
          return new zai(4, -1, null);
        }
        if (paramzaw.a == 4) {
          return new zai(7, -1, null);
        }
        paramGdtFormData = new zai(4, -1, null);
        return paramGdtFormData;
        i = 0;
      }
    }
  }
  
  private static zaw a(byte[] paramArrayOfByte)
  {
    zaw localzaw = new zaw(null);
    localzaw.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    localzaw.method = "POST";
    localzaw.contentType = "application/json";
    localzaw.connectTimeoutMillis = 5000;
    localzaw.readTimeoutMillis = 5000;
    localzaw.requestData = paramArrayOfByte;
    return localzaw;
  }
  
  private static byte[] a(GdtFormData paramGdtFormData)
  {
    JSONArray localJSONArray = a(paramGdtFormData);
    if ((paramGdtFormData == null) || (!paramGdtFormData.isValid()) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      yxs.d("GdtFormUploadUtil", "getRequestData error");
      return null;
    }
    if (TextUtils.isEmpty(paramGdtFormData.tokenForUpload)) {}
    for (String str = "";; str = paramGdtFormData.tokenForUpload) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("token", str);
        localJSONObject.put("formId", paramGdtFormData.formId);
        localJSONObject.put("formValue", localJSONArray.toString());
        paramGdtFormData = localJSONObject.toString().getBytes("UTF-8");
        return paramGdtFormData;
      }
      catch (JSONException paramGdtFormData)
      {
        yxs.d("GdtFormUploadUtil", "getRequestData", paramGdtFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramGdtFormData)
      {
        yxs.d("GdtFormUploadUtil", "getRequestData", paramGdtFormData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zau
 * JD-Core Version:    0.7.0.1
 */