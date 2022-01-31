import com.tencent.gdtad.views.form.GdtFormData;
import com.tencent.gdtad.views.form.framework.GdtFormItemData;
import com.tencent.gdtad.views.form.framework.GdtFormTableData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.gdtad.views.xijing.GdtButtonData;
import com.tencent.gdtad.views.xijing.GdtTextData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zae
{
  public static GdtFormData a(JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yxp.d("GdtFormDataBuilder", "getFormComponent error");
      return null;
    }
    GdtFormData localGdtFormData = new GdtFormData();
    Object localObject;
    try
    {
      localGdtFormData.formId = paramJSONObject.getLong("formId");
      localGdtFormData.padding = yzb.b(paramInt, 60);
      localGdtFormData.backgroundColor = yzb.a(paramJSONObject.getString("backgroundColor"), 0);
      localObject = paramJSONObject.getJSONObject("title");
      if (((JSONObject)localObject).getBoolean("visible"))
      {
        localGdtFormData.title = new GdtTextData();
        localGdtFormData.title.text = ((JSONObject)localObject).getString("text");
        localGdtFormData.title.color = yzb.a(((JSONObject)localObject).getString("fontColor"), 0);
        localGdtFormData.title.size = yzb.b(paramInt, ((JSONObject)localObject).getInt("fontSize"));
      }
      localObject = paramJSONObject.getJSONObject("submitButton");
      localGdtFormData.button.text.text = ((JSONObject)localObject).getString("text");
      localGdtFormData.button.text.color = yzb.a(((JSONObject)localObject).getString("fontColor"), 0);
      localGdtFormData.button.text.size = yzb.b(paramInt, 40);
      localGdtFormData.button.borderCornerRadius = yzb.b(paramInt, 6);
      localGdtFormData.button.backgroundColor = yzb.a(((JSONObject)localObject).getString("backgroundColor"), 0);
      localGdtFormData.buttonHeight = yzb.b(paramInt, 124);
      localGdtFormData.table.borderCornerRadius = yzb.b(paramInt, 6);
      localGdtFormData.table.borderWidth = yzb.b(paramInt, 3);
      localGdtFormData.table.borderColor = yzb.a("#EAEAEB", 0);
      localGdtFormData.table.borderColorError = yzb.a("#FE6C6C", 0);
      paramJSONObject = paramJSONObject.getJSONArray("items");
      if (paramJSONObject.length() <= 0)
      {
        yxp.d("GdtFormDataBuilder", "getFormComponent error");
        return null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      yxp.d("GdtFormDataBuilder", "getFormComponent", paramJSONObject);
      return null;
    }
    while (i < paramJSONObject.length())
    {
      localObject = a(paramJSONObject.getJSONObject(i), paramInt);
      if (!localGdtFormData.table.addItem((GdtFormItemData)localObject)) {
        yxp.d("GdtFormDataBuilder", "getFormComponent error");
      }
      i += 1;
    }
    return localGdtFormData;
  }
  
  private static GdtFormItemData a(JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yxp.d("GdtFormDataBuilder", "getFormItem error");
      return null;
    }
    int i;
    try
    {
      i = paramJSONObject.getInt("type");
      switch (i)
      {
      default: 
        yxp.d("GdtFormDataBuilder", "getFormItem error");
        return null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      yxp.d("GdtFormDataBuilder", "getFormItem", paramJSONObject);
      return null;
    }
    return a(paramJSONObject, paramInt, i);
  }
  
  private static GdtFormItemTextBoxData a(JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yxp.d("GdtFormDataBuilder", "getFormItemTextBox error");
      return null;
    }
    GdtFormItemTextBoxData localGdtFormItemTextBoxData = new GdtFormItemTextBoxData();
    if (!a(paramJSONObject, paramInt1, localGdtFormItemTextBoxData, paramInt2))
    {
      yxp.d("GdtFormDataBuilder", "getFormItemTextBox error");
      return null;
    }
    localGdtFormItemTextBoxData.regexType = paramJSONObject.optInt("regexType", -2147483648);
    localGdtFormItemTextBoxData.content.color = yzb.a("#333333", 0);
    localGdtFormItemTextBoxData.content.size = yzb.b(paramInt1, 40);
    localGdtFormItemTextBoxData.content.lengthMax = paramJSONObject.optInt("maxLength", -2147483648);
    return localGdtFormItemTextBoxData;
  }
  
  private static boolean a(JSONObject paramJSONObject, int paramInt1, GdtFormItemData paramGdtFormItemData, int paramInt2)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL) || (paramGdtFormItemData == null))
    {
      yxp.d("GdtFormDataBuilder", "initFormItem error");
      return false;
    }
    try
    {
      if (paramJSONObject.getInt("type") != paramInt2)
      {
        yxp.d("GdtFormDataBuilder", "initFormItem type error");
        return false;
      }
    }
    catch (JSONException paramJSONObject)
    {
      yxp.d("GdtFormDataBuilder", "initFormItem", paramJSONObject);
      return false;
    }
    paramGdtFormItemData.paddingTop = yzb.b(paramInt1, 60);
    paramGdtFormItemData.paddingBottom = yzb.b(paramInt1, 60);
    paramGdtFormItemData.backgroundColor = yzb.a("#FDFEFF", 0);
    paramGdtFormItemData.required = paramJSONObject.getBoolean("require");
    paramGdtFormItemData.title.text = paramJSONObject.getString("name");
    paramGdtFormItemData.title.color = yzb.a("#333333", 0);
    paramGdtFormItemData.title.size = yzb.b(paramInt1, 40);
    paramGdtFormItemData.titlePaddingLeft = yzb.b(paramInt1, 60);
    paramGdtFormItemData.titlePaddingRight = yzb.b(paramInt1, 15);
    paramGdtFormItemData.contentPaddingLeft = yzb.b(paramInt1, 15);
    paramGdtFormItemData.contentPaddingRight = yzb.b(paramInt1, 60);
    if (paramJSONObject.has("placeholder"))
    {
      paramGdtFormItemData.placeholder = new GdtTextData();
      paramGdtFormItemData.placeholder.text = paramJSONObject.optString("placeholder");
      paramGdtFormItemData.placeholder.color = yzb.a("#B9BDC2", 0);
      paramGdtFormItemData.placeholder.size = yzb.b(paramInt1, 40);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zae
 * JD-Core Version:    0.7.0.1
 */