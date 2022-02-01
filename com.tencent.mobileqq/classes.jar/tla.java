import org.json.JSONObject;

public class tla
{
  private static String d;
  public float a;
  public int a;
  public String a;
  public float b;
  public String b = jdField_d_of_type_JavaLangString;
  public float c;
  public String c;
  public float d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  public float j;
  public float k;
  public float l;
  
  static
  {
    jdField_d_of_type_JavaLangString = "#40A0FF";
  }
  
  public tla()
  {
    this.jdField_a_of_type_JavaLangString = jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_Int = 14;
    this.jdField_c_of_type_JavaLangString = jdField_d_of_type_JavaLangString;
  }
  
  public static tla a(JSONObject paramJSONObject)
  {
    tla localtla = new tla();
    if (paramJSONObject == null) {
      return localtla;
    }
    localtla.jdField_a_of_type_JavaLangString = nzv.a(paramJSONObject, "buttonTextColor", jdField_d_of_type_JavaLangString);
    localtla.b = paramJSONObject.optString("buttonBorderColor");
    localtla.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonBackgroundColor");
    localtla.jdField_a_of_type_Int = nzv.a(paramJSONObject.optString("buttonTextSize"), 14);
    localtla.jdField_a_of_type_Float = nzv.a(paramJSONObject.optString("buttonTextBold"), 0.0F);
    localtla.jdField_c_of_type_Float = nzv.a(paramJSONObject.optString("buttonBorderSize"), 0.0F);
    localtla.jdField_d_of_type_Float = nzv.a(paramJSONObject.optString("buttonCornerSize"), 0.0F);
    localtla.e = nzv.a(paramJSONObject.optString("buttonHorizontalPadding"), 0.0F);
    localtla.f = nzv.a(paramJSONObject.optString("buttonVerticalPadding"), 0.0F);
    localtla.g = nzv.a(paramJSONObject.optString("drawablePadding"), 0.0F);
    localtla.h = nzv.a(paramJSONObject.optString("iconSize"), 0.0F);
    localtla.i = nzv.a(paramJSONObject.optString("buttonAlignment"), 0.0F);
    localtla.i = nzv.a(paramJSONObject.optString("showBunttonLeftIconOrNot"), 0.0F);
    localtla.k = nzv.a(paramJSONObject.optString("buttonWidth"), 0.0F);
    localtla.l = nzv.a(paramJSONObject.optString("buttonHeight"), 0.0F);
    localtla.j = nzv.a(paramJSONObject.optString("width"), 0.0F);
    return localtla;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tla
 * JD-Core Version:    0.7.0.1
 */