import org.json.JSONObject;

class xkh
  implements bfux
{
  xkh(xkb paramxkb, String paramString) {}
  
  public void a(bfuw parambfuw)
  {
    JSONObject localJSONObject = new JSONObject();
    switch (parambfuw.a)
    {
    default: 
      return;
    case 0: 
      try
      {
        localJSONObject.put("index", 0);
        this.jdField_a_of_type_Xkb.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception parambfuw)
      {
        parambfuw.printStackTrace();
        return;
      }
    }
    try
    {
      localJSONObject.put("index", 1);
      this.jdField_a_of_type_Xkb.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception parambfuw)
    {
      parambfuw.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xkh
 * JD-Core Version:    0.7.0.1
 */