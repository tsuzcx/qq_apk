import org.json.JSONObject;

public class uei
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
  
  public uei()
  {
    this.jdField_a_of_type_JavaLangString = jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_Int = 14;
    this.jdField_c_of_type_JavaLangString = jdField_d_of_type_JavaLangString;
  }
  
  public static uei a(JSONObject paramJSONObject)
  {
    uei localuei = new uei();
    if (paramJSONObject == null) {
      return localuei;
    }
    localuei.jdField_a_of_type_JavaLangString = oix.a(paramJSONObject, "buttonTextColor", jdField_d_of_type_JavaLangString);
    localuei.b = paramJSONObject.optString("buttonBorderColor");
    localuei.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonBackgroundColor");
    localuei.jdField_a_of_type_Int = oix.a(paramJSONObject.optString("buttonTextSize"), 14);
    localuei.jdField_a_of_type_Float = oix.a(paramJSONObject.optString("buttonTextBold"), 0.0F);
    localuei.jdField_c_of_type_Float = oix.a(paramJSONObject.optString("buttonBorderSize"), 0.0F);
    localuei.jdField_d_of_type_Float = oix.a(paramJSONObject.optString("buttonCornerSize"), 0.0F);
    localuei.e = oix.a(paramJSONObject.optString("buttonHorizontalPadding"), 0.0F);
    localuei.f = oix.a(paramJSONObject.optString("buttonVerticalPadding"), 0.0F);
    localuei.g = oix.a(paramJSONObject.optString("drawablePadding"), 0.0F);
    localuei.h = oix.a(paramJSONObject.optString("iconSize"), 0.0F);
    localuei.i = oix.a(paramJSONObject.optString("buttonAlignment"), 0.0F);
    localuei.i = oix.a(paramJSONObject.optString("showBunttonLeftIconOrNot"), 0.0F);
    localuei.k = oix.a(paramJSONObject.optString("buttonWidth"), 0.0F);
    localuei.l = oix.a(paramJSONObject.optString("buttonHeight"), 0.0F);
    localuei.j = oix.a(paramJSONObject.optString("width"), 0.0F);
    return localuei;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uei
 * JD-Core Version:    0.7.0.1
 */