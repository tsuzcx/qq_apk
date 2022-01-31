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

class yrc
{
  public static JSONArray a(GdtFormData paramGdtFormData)
  {
    if ((paramGdtFormData == null) || (!paramGdtFormData.isValid()))
    {
      yny.d("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramGdtFormData.table.getSize())
    {
      Object localObject = paramGdtFormData.table.getItem(i);
      if ((localObject == null) || (!((GdtFormItemData)localObject).isValid())) {
        yny.d("GdtFormUploadUtil", "toJson error");
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
          yny.d("GdtFormUploadUtil", "toJson", localJSONException);
        }
      }
    }
    return localJSONArray;
  }
  
  public static yqq a(GdtFormData paramGdtFormData)
  {
    byte[] arrayOfByte = a(paramGdtFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      yny.d("GdtFormUploadUtil", "upload error");
      localObject = new yqq(4, -1, null);
      return localObject;
    }
    yqq localyqq = new yqq(4, -1, null);
    int i = 0;
    for (;;)
    {
      yre localyre;
      if (i < 3)
      {
        localyre = a(arrayOfByte);
        if (localyre != null) {}
      }
      else
      {
        yny.d("GdtFormUploadUtil", "upload error");
        return localyqq;
      }
      AdHttp.send(localyre);
      if (localyre.isSuccess()) {
        localyqq = a(paramGdtFormData, localyre);
      }
      localObject = localyqq;
      if (localyre.a == 0) {
        break;
      }
      localObject = localyqq;
      if (localyre.a == 1) {
        break;
      }
      localObject = localyqq;
      if (localyre.a == 2) {
        break;
      }
      localObject = localyqq;
      if (localyre.a == 4) {
        break;
      }
      i += 1;
    }
  }
  
  private static yqq a(GdtFormData paramGdtFormData, yre paramyre)
  {
    if ((paramGdtFormData == null) || (!paramGdtFormData.isValid()) || (paramyre == null) || (!paramyre.isSuccess()))
    {
      yny.d("GdtFormUploadUtil", "commit error");
      paramyre = new yqq(4, -1, null);
      return paramyre;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(paramyre.responseData, "UTF-8"));
      paramyre.a = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      yny.b("GdtFormUploadUtil", "parseResponse code:" + paramyre.a + " message:" + (String)localObject1);
      if (paramyre.a == 0)
      {
        paramGdtFormData = new yqq(1, -1, null);
        return paramGdtFormData;
      }
    }
    catch (UnsupportedEncodingException paramGdtFormData)
    {
      yny.d("GdtFormUploadUtil", "parseResponse", paramGdtFormData);
      return new yqq(4, -1, null);
      if (paramyre.a != 1) {
        break label446;
      }
      localObject1 = new yqq(4, -1, null);
      paramyre = ((JSONObject)localObject2).getJSONObject("data");
      if ((paramyre == null) || (paramyre == JSONObject.NULL))
      {
        yny.d("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramGdtFormData)
    {
      yny.d("GdtFormUploadUtil", "parseResponse", paramGdtFormData);
      return new yqq(4, -1, null);
    }
    Object localObject2 = paramyre.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramGdtFormData.table.getSize())
    {
      yny.d("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      paramyre = (yre)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      paramyre = paramGdtFormData.table.getItem(i);
      if ((paramyre == null) || (!paramyre.isValid()))
      {
        yny.d("GdtFormUploadUtil", "parseResponse error");
        return new yqq(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (localJSONObject == JSONObject.NULL))
      {
        yny.d("GdtFormUploadUtil", "parseResponse error");
        return new yqq(4, i, paramyre.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new yqq(5, i, paramyre.title.text);
        }
        if (j == 2) {
          return new yqq(6, i, paramyre.title.text);
        }
        yny.d("GdtFormUploadUtil", "parseResponse error");
        return new yqq(4, i, paramyre.title.text);
        label446:
        if (paramyre.a == 3) {
          return new yqq(4, -1, null);
        }
        if (paramyre.a == 4) {
          return new yqq(7, -1, null);
        }
        paramGdtFormData = new yqq(4, -1, null);
        return paramGdtFormData;
        i = 0;
      }
    }
  }
  
  private static yre a(byte[] paramArrayOfByte)
  {
    yre localyre = new yre(null);
    localyre.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    localyre.method = "POST";
    localyre.contentType = "application/json";
    localyre.connectTimeoutMillis = 5000;
    localyre.readTimeoutMillis = 5000;
    localyre.requestData = paramArrayOfByte;
    return localyre;
  }
  
  private static byte[] a(GdtFormData paramGdtFormData)
  {
    JSONArray localJSONArray = a(paramGdtFormData);
    if ((paramGdtFormData == null) || (!paramGdtFormData.isValid()) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      yny.d("GdtFormUploadUtil", "getRequestData error");
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
        yny.d("GdtFormUploadUtil", "getRequestData", paramGdtFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramGdtFormData)
      {
        yny.d("GdtFormUploadUtil", "getRequestData", paramGdtFormData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yrc
 * JD-Core Version:    0.7.0.1
 */