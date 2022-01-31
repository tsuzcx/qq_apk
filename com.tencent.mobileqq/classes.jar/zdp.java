import org.json.JSONObject;

class zdp
  implements biab
{
  zdp(zdj paramzdj, String paramString) {}
  
  public void a(biaa parambiaa)
  {
    JSONObject localJSONObject = new JSONObject();
    switch (parambiaa.a)
    {
    default: 
      return;
    case 0: 
      try
      {
        localJSONObject.put("index", 0);
        this.jdField_a_of_type_Zdj.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception parambiaa)
      {
        parambiaa.printStackTrace();
        return;
      }
    }
    try
    {
      localJSONObject.put("index", 1);
      this.jdField_a_of_type_Zdj.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception parambiaa)
    {
      parambiaa.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zdp
 * JD-Core Version:    0.7.0.1
 */