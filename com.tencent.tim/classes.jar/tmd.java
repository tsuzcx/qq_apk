import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormTableData;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class tmd
{
  public static AdFormError a(AdFormData paramAdFormData)
  {
    byte[] arrayOfByte = a(paramAdFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      tkw.e("GdtFormUploadUtil", "upload error");
      localObject = new AdFormError(4, -1, null);
      return localObject;
    }
    AdFormError localAdFormError = new AdFormError(4, -1, null);
    int i = 0;
    for (;;)
    {
      tmd.a locala;
      if (i < 3)
      {
        locala = a(arrayOfByte);
        if (locala != null) {}
      }
      else
      {
        tkw.e("GdtFormUploadUtil", "upload error");
        return localAdFormError;
      }
      AdHttp.send(locala);
      if (locala.isSuccess()) {
        localAdFormError = a(paramAdFormData, locala);
      }
      localObject = localAdFormError;
      if (locala.returnCode == 0) {
        break;
      }
      localObject = localAdFormError;
      if (locala.returnCode == 1) {
        break;
      }
      localObject = localAdFormError;
      if (locala.returnCode == 2) {
        break;
      }
      localObject = localAdFormError;
      if (locala.returnCode == 4) {
        break;
      }
      i += 1;
    }
  }
  
  private static AdFormError a(AdFormData paramAdFormData, tmd.a parama)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (parama == null) || (!parama.isSuccess()))
    {
      tkw.e("GdtFormUploadUtil", "commit error");
      parama = new AdFormError(4, -1, null);
      return parama;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(parama.responseData, "UTF-8"));
      parama.returnCode = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      tkw.i("GdtFormUploadUtil", "parseResponse code:" + parama.returnCode + " message:" + (String)localObject1);
      if (parama.returnCode == 0)
      {
        paramAdFormData = new AdFormError(1, -1, null);
        return paramAdFormData;
      }
    }
    catch (UnsupportedEncodingException paramAdFormData)
    {
      tkw.e("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
      if (parama.returnCode != 1) {
        break label446;
      }
      localObject1 = new AdFormError(4, -1, null);
      parama = ((JSONObject)localObject2).getJSONObject("data");
      if ((parama == null) || (parama == JSONObject.NULL))
      {
        tkw.e("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramAdFormData)
    {
      tkw.e("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
    }
    Object localObject2 = parama.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramAdFormData.table.getSize())
    {
      tkw.e("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      parama = (tmd.a)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      parama = paramAdFormData.table.getItem(i);
      if ((parama == null) || (!parama.isValid()))
      {
        tkw.e("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (localJSONObject == JSONObject.NULL))
      {
        tkw.e("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, parama.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new AdFormError(5, i, parama.title.text);
        }
        if (j == 2) {
          return new AdFormError(6, i, parama.title.text);
        }
        tkw.e("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, parama.title.text);
        label446:
        if (parama.returnCode == 3) {
          return new AdFormError(4, -1, null);
        }
        if (parama.returnCode == 4) {
          return new AdFormError(7, -1, null);
        }
        paramAdFormData = new AdFormError(4, -1, null);
        return paramAdFormData;
        i = 0;
      }
    }
  }
  
  public static JSONArray a(AdFormData paramAdFormData)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()))
    {
      tkw.e("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramAdFormData.table.getSize())
    {
      Object localObject = paramAdFormData.table.getItem(i);
      if ((localObject == null) || (!((AdFormItemData)localObject).isValid())) {
        tkw.e("GdtFormUploadUtil", "toJson error");
      }
      for (;;)
      {
        i += 1;
        break;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("name", ((AdFormItemData)localObject).title.text);
          localJSONObject.put("require", ((AdFormItemData)localObject).required);
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
          tkw.e("GdtFormUploadUtil", "toJson", localJSONException);
        }
      }
    }
    return localJSONArray;
  }
  
  private static tmd.a a(byte[] paramArrayOfByte)
  {
    tmd.a locala = new tmd.a(null);
    locala.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    locala.method = "POST";
    locala.contentType = "application/json";
    locala.connectTimeoutMillis = 5000;
    locala.readTimeoutMillis = 5000;
    locala.requestData = paramArrayOfByte;
    return locala;
  }
  
  private static byte[] a(AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = a(paramAdFormData);
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (localJSONArray == null) || (localJSONArray == JSONObject.NULL))
    {
      tkw.e("GdtFormUploadUtil", "getRequestData error");
      return null;
    }
    if (TextUtils.isEmpty(paramAdFormData.tokenForUpload)) {}
    for (String str = "";; str = paramAdFormData.tokenForUpload) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("token", str);
        localJSONObject.put("formId", paramAdFormData.formId);
        localJSONObject.put("formValue", localJSONArray.toString());
        paramAdFormData = localJSONObject.toString().getBytes("UTF-8");
        return paramAdFormData;
      }
      catch (JSONException paramAdFormData)
      {
        tkw.e("GdtFormUploadUtil", "getRequestData", paramAdFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramAdFormData)
      {
        tkw.e("GdtFormUploadUtil", "getRequestData", paramAdFormData);
      }
    }
    return null;
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
 * Qualified Name:     tmd
 * JD-Core Version:    0.7.0.1
 */