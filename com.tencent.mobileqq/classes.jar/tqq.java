import org.json.JSONObject;

public class tqq
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
  
  public tqq()
  {
    this.jdField_a_of_type_JavaLangString = jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_Int = 14;
    this.jdField_c_of_type_JavaLangString = jdField_d_of_type_JavaLangString;
  }
  
  public static tqq a(JSONObject paramJSONObject)
  {
    tqq localtqq = new tqq();
    if (paramJSONObject == null) {
      return localtqq;
    }
    localtqq.jdField_a_of_type_JavaLangString = obg.a(paramJSONObject, "buttonTextColor", jdField_d_of_type_JavaLangString);
    localtqq.b = paramJSONObject.optString("buttonBorderColor");
    localtqq.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonBackgroundColor");
    localtqq.jdField_a_of_type_Int = obg.a(paramJSONObject.optString("buttonTextSize"), 14);
    localtqq.jdField_a_of_type_Float = obg.a(paramJSONObject.optString("buttonTextBold"), 0.0F);
    localtqq.jdField_c_of_type_Float = obg.a(paramJSONObject.optString("buttonBorderSize"), 0.0F);
    localtqq.jdField_d_of_type_Float = obg.a(paramJSONObject.optString("buttonCornerSize"), 0.0F);
    localtqq.e = obg.a(paramJSONObject.optString("buttonHorizontalPadding"), 0.0F);
    localtqq.f = obg.a(paramJSONObject.optString("buttonVerticalPadding"), 0.0F);
    localtqq.g = obg.a(paramJSONObject.optString("drawablePadding"), 0.0F);
    localtqq.h = obg.a(paramJSONObject.optString("iconSize"), 0.0F);
    localtqq.i = obg.a(paramJSONObject.optString("buttonAlignment"), 0.0F);
    localtqq.i = obg.a(paramJSONObject.optString("showBunttonLeftIconOrNot"), 0.0F);
    localtqq.k = obg.a(paramJSONObject.optString("buttonWidth"), 0.0F);
    localtqq.l = obg.a(paramJSONObject.optString("buttonHeight"), 0.0F);
    localtqq.j = obg.a(paramJSONObject.optString("width"), 0.0F);
    return localtqq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqq
 * JD-Core Version:    0.7.0.1
 */