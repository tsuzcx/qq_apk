import com.tencent.gdtad.views.form.GdtFormData;
import com.tencent.gdtad.views.form.framework.GdtFormItemData;
import com.tencent.gdtad.views.form.framework.GdtFormTableData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.gdtad.views.xijing.GdtButtonData;
import com.tencent.gdtad.views.xijing.GdtTextData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zah
{
  public static GdtFormData a(JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yxs.d("GdtFormDataBuilder", "getFormComponent error");
      return null;
    }
    GdtFormData localGdtFormData = new GdtFormData();
    Object localObject;
    try
    {
      localGdtFormData.formId = paramJSONObject.getLong("formId");
      localGdtFormData.padding = yze.b(paramInt, 60);
      localGdtFormData.backgroundColor = yze.a(paramJSONObject.getString("backgroundColor"), 0);
      localObject = paramJSONObject.getJSONObject("title");
      if (((JSONObject)localObject).getBoolean("visible"))
      {
        localGdtFormData.title = new GdtTextData();
        localGdtFormData.title.text = ((JSONObject)localObject).getString("text");
        localGdtFormData.title.color = yze.a(((JSONObject)localObject).getString("fontColor"), 0);
        localGdtFormData.title.size = yze.b(paramInt, ((JSONObject)localObject).getInt("fontSize"));
      }
      localObject = paramJSONObject.getJSONObject("submitButton");
      localGdtFormData.button.text.text = ((JSONObject)localObject).getString("text");
      localGdtFormData.button.text.color = yze.a(((JSONObject)localObject).getString("fontColor"), 0);
      localGdtFormData.button.text.size = yze.b(paramInt, 40);
      localGdtFormData.button.borderCornerRadius = yze.b(paramInt, 6);
      localGdtFormData.button.backgroundColor = yze.a(((JSONObject)localObject).getString("backgroundColor"), 0);
      localGdtFormData.buttonHeight = yze.b(paramInt, 124);
      localGdtFormData.table.borderCornerRadius = yze.b(paramInt, 6);
      localGdtFormData.table.borderWidth = yze.b(paramInt, 3);
      localGdtFormData.table.borderColor = yze.a("#EAEAEB", 0);
      localGdtFormData.table.borderColorError = yze.a("#FE6C6C", 0);
      paramJSONObject = paramJSONObject.getJSONArray("items");
      if (paramJSONObject.length() <= 0)
      {
        yxs.d("GdtFormDataBuilder", "getFormComponent error");
        return null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      yxs.d("GdtFormDataBuilder", "getFormComponent", paramJSONObject);
      return null;
    }
    while (i < paramJSONObject.length())
    {
      localObject = a(paramJSONObject.getJSONObject(i), paramInt);
      if (!localGdtFormData.table.addItem((GdtFormItemData)localObject)) {
        yxs.d("GdtFormDataBuilder", "getFormComponent error");
      }
      i += 1;
    }
    return localGdtFormData;
  }
  
  private static GdtFormItemData a(JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yxs.d("GdtFormDataBuilder", "getFormItem error");
      return null;
    }
    int i;
    try
    {
      i = paramJSONObject.getInt("type");
      switch (i)
      {
      default: 
        yxs.d("GdtFormDataBuilder", "getFormItem error");
        return null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      yxs.d("GdtFormDataBuilder", "getFormItem", paramJSONObject);
      return null;
    }
    return a(paramJSONObject, paramInt, i);
  }
  
  private static GdtFormItemTextBoxData a(JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yxs.d("GdtFormDataBuilder", "getFormItemTextBox error");
      return null;
    }
    GdtFormItemTextBoxData localGdtFormItemTextBoxData = new GdtFormItemTextBoxData();
    if (!a(paramJSONObject, paramInt1, localGdtFormItemTextBoxData, paramInt2))
    {
      yxs.d("GdtFormDataBuilder", "getFormItemTextBox error");
      return null;
    }
    localGdtFormItemTextBoxData.regexType = paramJSONObject.optInt("regexType", -2147483648);
    localGdtFormItemTextBoxData.content.color = yze.a("#333333", 0);
    localGdtFormItemTextBoxData.content.size = yze.b(paramInt1, 40);
    localGdtFormItemTextBoxData.content.lengthMax = paramJSONObject.optInt("maxLength", -2147483648);
    return localGdtFormItemTextBoxData;
  }
  
  private static boolean a(JSONObject paramJSONObject, int paramInt1, GdtFormItemData paramGdtFormItemData, int paramInt2)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL) || (paramGdtFormItemData == null))
    {
      yxs.d("GdtFormDataBuilder", "initFormItem error");
      return false;
    }
    try
    {
      if (paramJSONObject.getInt("type") != paramInt2)
      {
        yxs.d("GdtFormDataBuilder", "initFormItem type error");
        return false;
      }
    }
    catch (JSONException paramJSONObject)
    {
      yxs.d("GdtFormDataBuilder", "initFormItem", paramJSONObject);
      return false;
    }
    paramGdtFormItemData.paddingTop = yze.b(paramInt1, 60);
    paramGdtFormItemData.paddingBottom = yze.b(paramInt1, 60);
    paramGdtFormItemData.backgroundColor = yze.a("#FDFEFF", 0);
    paramGdtFormItemData.required = paramJSONObject.getBoolean("require");
    paramGdtFormItemData.title.text = paramJSONObject.getString("name");
    paramGdtFormItemData.title.color = yze.a("#333333", 0);
    paramGdtFormItemData.title.size = yze.b(paramInt1, 40);
    paramGdtFormItemData.titlePaddingLeft = yze.b(paramInt1, 60);
    paramGdtFormItemData.titlePaddingRight = yze.b(paramInt1, 15);
    paramGdtFormItemData.contentPaddingLeft = yze.b(paramInt1, 15);
    paramGdtFormItemData.contentPaddingRight = yze.b(paramInt1, 60);
    if (paramJSONObject.has("placeholder"))
    {
      paramGdtFormItemData.placeholder = new GdtTextData();
      paramGdtFormItemData.placeholder.text = paramJSONObject.optString("placeholder");
      paramGdtFormItemData.placeholder.color = yze.a("#B9BDC2", 0);
      paramGdtFormItemData.placeholder.size = yze.b(paramInt1, 40);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zah
 * JD-Core Version:    0.7.0.1
 */