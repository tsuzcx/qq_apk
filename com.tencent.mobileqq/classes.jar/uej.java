import org.json.JSONObject;

public class uej
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  public float b;
  public int b;
  public String b;
  public float c;
  public int c;
  public String c;
  public float d;
  public int d;
  public String d;
  public float e;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g = 12;
  public int h = 10;
  public int i = 16;
  public int j = 2;
  public int k = 270;
  public int l = 0;
  
  public uej(int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "#12B7F5";
    this.jdField_b_of_type_Int = 100;
    this.jdField_c_of_type_Int = 50;
    this.jdField_d_of_type_Int = 50;
    this.jdField_e_of_type_Int = 20;
    this.jdField_f_of_type_Int = 22;
    this.jdField_a_of_type_Float = 2.0F;
    this.jdField_b_of_type_JavaLangString = "#F2F2F2";
    this.jdField_c_of_type_JavaLangString = "#F2F2F2";
    this.jdField_d_of_type_JavaLangString = "#ffffff";
    this.jdField_e_of_type_JavaLangString = "#12B7F5";
    this.jdField_b_of_type_Float = 2.0F;
    this.jdField_f_of_type_JavaLangString = "#CCE5E5E5";
    this.jdField_c_of_type_Float = 1.5F;
    this.jdField_d_of_type_Float = 1.5F;
    this.jdField_e_of_type_Float = 7.0F;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static uej a(int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    paramJSONObject = new uej(paramInt);
    paramJSONObject.jdField_a_of_type_Int = paramInt;
    paramJSONObject.jdField_c_of_type_Int = oix.a(localJSONObject.optString("width"), 50);
    paramJSONObject.jdField_d_of_type_Int = oix.a(localJSONObject.optString("minWidth"), 50);
    if (paramJSONObject.jdField_c_of_type_Int < paramJSONObject.jdField_d_of_type_Int)
    {
      paramJSONObject.jdField_c_of_type_Int = paramJSONObject.jdField_d_of_type_Int;
      paramJSONObject.jdField_e_of_type_Int = oix.a(localJSONObject.optString("height"), 20);
      paramJSONObject.jdField_f_of_type_Int = oix.a(localJSONObject.optString("maxHeight"), 22);
      if (paramJSONObject.jdField_e_of_type_Int >= 18) {
        break label275;
      }
      paramJSONObject.jdField_e_of_type_Int = 18;
      label122:
      paramJSONObject.jdField_a_of_type_Float = oix.a(localJSONObject.optString("corner"), 2.0F);
      if (paramJSONObject.jdField_a_of_type_Float >= 2.0F) {
        break label297;
      }
      paramJSONObject.jdField_a_of_type_Float = 2.0F;
    }
    for (;;)
    {
      paramJSONObject.jdField_b_of_type_JavaLangString = oix.a(localJSONObject, "progressBg", "#F2F2F2");
      paramJSONObject.jdField_c_of_type_JavaLangString = oix.a(localJSONObject, "secondaryProgressBg", "#F2F2F2");
      paramJSONObject.jdField_a_of_type_JavaLangString = oix.a(localJSONObject, "progressColor", "#12B7F5");
      paramJSONObject.jdField_d_of_type_JavaLangString = oix.a(localJSONObject, "textColor", "#ffffff");
      paramJSONObject.g = localJSONObject.optInt("textSize", 12);
      paramJSONObject.h = 10;
      paramJSONObject.i = 16;
      paramJSONObject.jdField_e_of_type_JavaLangString = oix.a(localJSONObject, "buttonBorderColor", "#12B7F5");
      paramJSONObject.jdField_b_of_type_Float = oix.a(localJSONObject.optString("buttonBorderSize", "0"), 0.0F);
      paramJSONObject.j = 2;
      return paramJSONObject;
      if (paramJSONObject.jdField_c_of_type_Int <= 100) {
        break;
      }
      paramJSONObject.jdField_c_of_type_Int = 100;
      break;
      label275:
      if (paramJSONObject.jdField_e_of_type_Int <= paramJSONObject.jdField_f_of_type_Int) {
        break label122;
      }
      paramJSONObject.jdField_e_of_type_Int = paramJSONObject.jdField_f_of_type_Int;
      break label122;
      label297:
      if (paramJSONObject.jdField_a_of_type_Float > 20.0F) {
        paramJSONObject.jdField_a_of_type_Float = 20.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uej
 * JD-Core Version:    0.7.0.1
 */