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

class zar
{
  public static JSONArray a(GdtFormData paramGdtFormData)
  {
    if ((paramGdtFormData == null) || (!paramGdtFormData.isValid()))
    {
      yxp.d("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramGdtFormData.table.getSize())
    {
      Object localObject = paramGdtFormData.table.getItem(i);
      if ((localObject == null) || (!((GdtFormItemData)localObject).isValid())) {
        yxp.d("GdtFormUploadUtil", "toJson error");
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
          yxp.d("GdtFormUploadUtil", "toJson", localJSONException);
        }
      }
    }
    return localJSONArray;
  }
  
  public static zaf a(GdtFormData paramGdtFormData)
  {
    byte[] arrayOfByte = a(paramGdtFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      yxp.d("GdtFormUploadUtil", "upload error");
      localObject = new zaf(4, -1, null);
      return localObject;
    }
    zaf localzaf = new zaf(4, -1, null);
    int i = 0;
    for (;;)
    {
      zat localzat;
      if (i < 3)
      {
        localzat = a(arrayOfByte);
        if (localzat != null) {}
      }
      else
      {
        yxp.d("GdtFormUploadUtil", "upload error");
        return localzaf;
      }
      AdHttp.send(localzat);
      if (localzat.isSuccess()) {
        localzaf = a(paramGdtFormData, localzat);
      }
      localObject = localzaf;
      if (localzat.a == 0) {
        break;
      }
      localObject = localzaf;
      if (localzat.a == 1) {
        break;
      }
      localObject = localzaf;
      if (localzat.a == 2) {
        break;
      }
      localObject = localzaf;
      if (localzat.a == 4) {
        break;
      }
      i += 1;
    }
  }
  
  private static zaf a(GdtFormData paramGdtFormData, zat paramzat)
  {
    if ((paramGdtFormData == null) || (!paramGdtFormData.isValid()) || (paramzat == null) || (!paramzat.isSuccess()))
    {
      yxp.d("GdtFormUploadUtil", "commit error");
      paramzat = new zaf(4, -1, null);
      return paramzat;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(paramzat.responseData, "UTF-8"));
      paramzat.a = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      yxp.b("GdtFormUploadUtil", "parseResponse code:" + paramzat.a + " message:" + (String)localObject1);
      if (paramzat.a == 0)
      {
        paramGdtFormData = new zaf(1, -1, null);
        return paramGdtFormData;
      }
    }
    catch (UnsupportedEncodingException paramGdtFormData)
    {
      yxp.d("GdtFormUploadUtil", "parseResponse", paramGdtFormData);
      return new zaf(4, -1, null);
      if (paramzat.a != 1) {
        break label446;
      }
      localObject1 = new zaf(4, -1, null);
      paramzat = ((JSONObject)localObject2).getJSONObject("data");
      if ((paramzat == null) || (paramzat == JSONObject.NULL))
      {
        yxp.d("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramGdtFormData)
    {
      yxp.d("GdtFormUploadUtil", "parseResponse", paramGdtFormData);
      return new zaf(4, -1, null);
    }
    Object localObject2 = paramzat.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramGdtFormData.table.getSize())
    {
      yxp.d("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      paramzat = (zat)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      paramzat = paramGdtFormData.table.getItem(i);
      if ((paramzat == null) || (!paramzat.isValid()))
      {
        yxp.d("GdtFormUploadUtil", "parseResponse error");
        return new zaf(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (localJSONObject == JSONObject.NULL))
      {
        yxp.d("GdtFormUploadUtil", "parseResponse error");
        return new zaf(4, i, paramzat.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new zaf(5, i, paramzat.title.text);
        }
        if (j == 2) {
          return new zaf(6, i, paramzat.title.text);
        }
        yxp.d("GdtFormUploadUtil", "parseResponse error");
        return new zaf(4, i, paramzat.title.text);
        label446:
        if (paramzat.a == 3) {
          return new zaf(4, -1, null);
        }
        if (paramzat.a == 4) {
          return new zaf(7, -1, null);
        }
        paramGdtFormData = new zaf(4, -1, null);
        return paramGdtFormData;
        i = 0;
      }
    }
  }
  
  private static zat a(byte[] paramArrayOfByte)
  {
    zat localzat = new zat(null);
    localzat.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    localzat.method = "POST";
    localzat.contentType = "application/json";
    localzat.connectTimeoutMillis = 5000;
    localzat.readTimeoutMillis = 5000;
    localzat.requestData = paramArrayOfByte;
    return localzat;
  }
  
  private static byte[] a(GdtFormData paramGdtFormData)
  {
    JSONArray localJSONArray = a(paramGdtFormData);
    if ((paramGdtFormData == null) || (!paramGdtFormData.isValid()) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      yxp.d("GdtFormUploadUtil", "getRequestData error");
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
        yxp.d("GdtFormUploadUtil", "getRequestData", paramGdtFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramGdtFormData)
      {
        yxp.d("GdtFormUploadUtil", "getRequestData", paramGdtFormData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zar
 * JD-Core Version:    0.7.0.1
 */