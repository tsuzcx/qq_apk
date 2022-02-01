import org.json.JSONException;
import org.json.JSONObject;

public class trw
{
  public static String a(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramString);
      localJSONObject.put("num", paramInt);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static pqg a(int paramInt)
  {
    return new pqg().b().a(paramInt);
  }
  
  public static pqg a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    localpqg = a(paramInt);
    try
    {
      paramString1 = localpqg.b(paramString1).a("URL", paramString2);
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString1 = paramString1.a("ad_page", paramInt);
        return paramString1;
      }
      return localpqg;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, rsa paramrsa)
  {
    if ((paramrsa instanceof rsc)) {}
    for (String str = ((rsc)paramrsa).f;; str = "0")
    {
      olh.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramrsa.jdField_a_of_type_Int), a(paramInt2, paramrsa.e, str, paramrsa.jdField_a_of_type_Boolean).a(), false);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    pqg localpqg = a(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        localpqg.a("ad_page_include", paramInt1);
        olh.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localpqg.a(), false);
        return;
        paramInt1 = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void a(String paramString, int paramInt, rsa paramrsa)
  {
    if ((paramrsa instanceof rsc)) {}
    for (paramrsa = ((rsc)paramrsa).f;; paramrsa = "0")
    {
      olh.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", a(paramInt, paramrsa), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trw
 * JD-Core Version:    0.7.0.1
 */