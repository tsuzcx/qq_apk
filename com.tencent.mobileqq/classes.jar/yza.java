import org.json.JSONObject;

class yza
  implements bhvu
{
  yza(yyu paramyyu, String paramString) {}
  
  public void a(bhvt parambhvt)
  {
    JSONObject localJSONObject = new JSONObject();
    switch (parambhvt.a)
    {
    default: 
      return;
    case 0: 
      try
      {
        localJSONObject.put("index", 0);
        this.jdField_a_of_type_Yyu.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception parambhvt)
      {
        parambhvt.printStackTrace();
        return;
      }
    }
    try
    {
      localJSONObject.put("index", 1);
      this.jdField_a_of_type_Yyu.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception parambhvt)
    {
      parambhvt.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yza
 * JD-Core Version:    0.7.0.1
 */