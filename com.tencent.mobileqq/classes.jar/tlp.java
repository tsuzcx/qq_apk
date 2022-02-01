import android.text.TextUtils;
import org.json.JSONObject;

public class tlp
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("adDownloadApiUrl");
      this.b = paramJSONObject.optString("pkg_name");
      this.c = paramJSONObject.optString("appid");
      this.d = paramJSONObject.optString("appname");
      this.e = paramJSONObject.optString("pkgurl");
      this.jdField_a_of_type_Int = paramJSONObject.optInt("business_type", 0);
      paramJSONObject = paramJSONObject.optString("apk_url");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.e = paramJSONObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tlp
 * JD-Core Version:    0.7.0.1
 */