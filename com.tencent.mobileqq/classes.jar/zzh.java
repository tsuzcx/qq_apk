import org.json.JSONObject;

public class zzh
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public zzh(zze paramzze) {}
  
  public boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramJSONObject.getString("param_index"));
      this.jdField_b_of_type_Int = Integer.parseInt(paramJSONObject.getString("param_type"));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("param_value1").trim();
      this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("param_value2").trim();
      return true;
    }
    catch (Exception paramJSONObject)
    {
      zyz.a("KingKongNativePatch", "Parse parameter error!");
    }
    return false;
  }
  
  public String toString()
  {
    return "Index " + this.jdField_a_of_type_Int + ": " + this.jdField_b_of_type_Int + ", " + this.jdField_a_of_type_JavaLangString + ", " + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zzh
 * JD-Core Version:    0.7.0.1
 */