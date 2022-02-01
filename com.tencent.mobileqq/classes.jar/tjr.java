import org.json.JSONException;
import org.json.JSONObject;

public class tjr
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
  
  public static phi a(int paramInt)
  {
    return new phi().b().a(paramInt);
  }
  
  public static phi a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    localphi = a(paramInt);
    try
    {
      paramString1 = localphi.b(paramString1).a("URL", paramString2);
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString1 = paramString1.a("ad_page", paramInt);
        return paramString1;
      }
      return localphi;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, rib paramrib)
  {
    if ((paramrib instanceof rid)) {}
    for (String str = ((rid)paramrib).f;; str = "0")
    {
      oat.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramrib.jdField_a_of_type_Int), a(paramInt2, paramrib.e, str, paramrib.jdField_a_of_type_Boolean).a(), false);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    phi localphi = a(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        localphi.a("ad_page_include", paramInt1);
        oat.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localphi.a(), false);
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
  
  public static void a(String paramString, int paramInt, rib paramrib)
  {
    if ((paramrib instanceof rid)) {}
    for (paramrib = ((rid)paramrib).f;; paramrib = "0")
    {
      oat.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", a(paramInt, paramrib), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tjr
 * JD-Core Version:    0.7.0.1
 */