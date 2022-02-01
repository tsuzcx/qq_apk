import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class uft
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public static uft a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new uft();
      try
      {
        paramString.jdField_a_of_type_Int = localJSONObject.optInt("gift_id", 0);
        paramString.jdField_a_of_type_JavaLangString = localJSONObject.optString("gift_name", "");
        paramString.b = localJSONObject.optString("activity_id", "");
        paramString.c = localJSONObject.optString("gift_icon", "");
        paramString.g = localJSONObject.optString("gift_desc", "");
        paramString.d = localJSONObject.optString("bag_item_icon_1", "");
        paramString.e = localJSONObject.optString("bag_item_icon_2", "");
        paramString.f = localJSONObject.optString("bag_item_icon_3", "");
        paramString.h = localJSONObject.optString("need_role", "");
        return paramString;
      }
      catch (JSONException localJSONException1) {}
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        paramString = null;
      }
    }
    localJSONException1.printStackTrace();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uft
 * JD-Core Version:    0.7.0.1
 */