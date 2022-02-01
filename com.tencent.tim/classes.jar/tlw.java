import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormTableData;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.canvas.views.xijing.a;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class tlw
{
  public static AdFormData a(JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      tkw.e("AdFormDataBuilder", "getFormComponent error");
      return null;
    }
    AdFormData localAdFormData = new AdFormData();
    Object localObject;
    try
    {
      localAdFormData.formId = paramJSONObject.getLong("formId");
      localAdFormData.padding = tls.af(paramInt, 60);
      localAdFormData.backgroundColor = tls.z(paramJSONObject.getString("backgroundColor"), 0);
      localObject = paramJSONObject.getJSONObject("title");
      if (((JSONObject)localObject).getBoolean("visible"))
      {
        localAdFormData.title = new AdTextData();
        localAdFormData.title.text = ((JSONObject)localObject).getString("text");
        localAdFormData.title.color = tls.z(((JSONObject)localObject).getString("fontColor"), 0);
        localAdFormData.title.size = tls.af(paramInt, ((JSONObject)localObject).getInt("fontSize"));
      }
      localObject = paramJSONObject.getJSONObject("submitButton");
      localAdFormData.button.text.text = ((JSONObject)localObject).getString("text");
      localAdFormData.button.text.color = tls.z(((JSONObject)localObject).getString("fontColor"), 0);
      localAdFormData.button.text.size = tls.af(paramInt, 40);
      localAdFormData.button.borderCornerRadius = tls.af(paramInt, 6);
      localAdFormData.button.backgroundColor = tls.z(((JSONObject)localObject).getString("backgroundColor"), 0);
      localAdFormData.buttonHeight = tls.af(paramInt, 124);
      localAdFormData.table.borderCornerRadius = tls.af(paramInt, 6);
      localAdFormData.table.borderWidth = tls.af(paramInt, 3);
      localAdFormData.table.borderColor = tls.z("#EAEAEB", 0);
      localAdFormData.table.borderColorError = tls.z("#FE6C6C", 0);
      paramJSONObject = paramJSONObject.getJSONArray("items");
      if (paramJSONObject.length() <= 0)
      {
        tkw.e("AdFormDataBuilder", "getFormComponent error");
        return null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      tkw.e("AdFormDataBuilder", "getFormComponent", paramJSONObject);
      return null;
    }
    while (i < paramJSONObject.length())
    {
      localObject = a(paramJSONObject.getJSONObject(i), paramInt);
      if (!localAdFormData.table.addItem((AdFormItemData)localObject)) {
        tkw.e("AdFormDataBuilder", "getFormComponent error");
      }
      i += 1;
    }
    return localAdFormData;
  }
  
  private static AdFormItemData a(JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      tkw.e("AdFormDataBuilder", "getFormItem error");
      return null;
    }
    int i;
    try
    {
      i = paramJSONObject.getInt("type");
      switch (i)
      {
      default: 
        tkw.e("AdFormDataBuilder", "getFormItem error");
        return null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      tkw.e("AdFormDataBuilder", "getFormItem", paramJSONObject);
      return null;
    }
    return a(paramJSONObject, paramInt, i);
  }
  
  private static GdtFormItemTextBoxData a(JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      tkw.e("AdFormDataBuilder", "getFormItemTextBox error");
      return null;
    }
    GdtFormItemTextBoxData localGdtFormItemTextBoxData = new GdtFormItemTextBoxData();
    if (!a(paramJSONObject, paramInt1, localGdtFormItemTextBoxData, paramInt2))
    {
      tkw.e("AdFormDataBuilder", "getFormItemTextBox error");
      return null;
    }
    localGdtFormItemTextBoxData.regexType = paramJSONObject.optInt("regexType", -2147483648);
    localGdtFormItemTextBoxData.content.color = tls.z("#333333", 0);
    localGdtFormItemTextBoxData.content.size = tls.af(paramInt1, 40);
    localGdtFormItemTextBoxData.content.lengthMax = paramJSONObject.optInt("maxLength", -2147483648);
    return localGdtFormItemTextBoxData;
  }
  
  private static boolean a(JSONObject paramJSONObject, int paramInt1, AdFormItemData paramAdFormItemData, int paramInt2)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL) || (paramAdFormItemData == null))
    {
      tkw.e("AdFormDataBuilder", "initFormItem error");
      return false;
    }
    try
    {
      if (paramJSONObject.getInt("type") != paramInt2)
      {
        tkw.e("AdFormDataBuilder", "initFormItem type error");
        return false;
      }
    }
    catch (JSONException paramJSONObject)
    {
      tkw.e("AdFormDataBuilder", "initFormItem", paramJSONObject);
      return false;
    }
    paramAdFormItemData.paddingTop = tls.af(paramInt1, 60);
    paramAdFormItemData.paddingBottom = tls.af(paramInt1, 60);
    paramAdFormItemData.backgroundColor = tls.z("#FDFEFF", 0);
    paramAdFormItemData.required = paramJSONObject.getBoolean("require");
    paramAdFormItemData.title.text = paramJSONObject.getString("name");
    paramAdFormItemData.title.color = tls.z("#333333", 0);
    paramAdFormItemData.title.size = tls.af(paramInt1, 40);
    paramAdFormItemData.titlePaddingLeft = tls.af(paramInt1, 60);
    paramAdFormItemData.titlePaddingRight = tls.af(paramInt1, 15);
    paramAdFormItemData.contentPaddingLeft = tls.af(paramInt1, 15);
    paramAdFormItemData.contentPaddingRight = tls.af(paramInt1, 60);
    if (paramJSONObject.has("placeholder"))
    {
      paramAdFormItemData.placeholder = new AdTextData();
      paramAdFormItemData.placeholder.text = paramJSONObject.optString("placeholder");
      paramAdFormItemData.placeholder.color = tls.z("#B9BDC2", 0);
      paramAdFormItemData.placeholder.size = tls.af(paramInt1, 40);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlw
 * JD-Core Version:    0.7.0.1
 */