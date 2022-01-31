import org.json.JSONObject;

public class zpn
{
  public int a;
  public String a;
  public String b;
  
  public zpn(zpm paramzpm) {}
  
  public boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramJSONObject.getString("type"));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("lib_name").trim();
      this.b = paramJSONObject.getString("func_name").trim();
      return true;
    }
    catch (Exception paramJSONObject)
    {
      zph.a("KingKongNativePatch", "Parse fingerprint error!");
    }
    return false;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_JavaLangString + ", " + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zpn
 * JD-Core Version:    0.7.0.1
 */