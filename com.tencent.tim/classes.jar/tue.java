import org.json.JSONObject;

public class tue
{
  private final float ascent;
  private final String family;
  private final String name;
  private final String style;
  
  tue(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    this.family = paramString1;
    this.name = paramString2;
    this.style = paramString3;
    this.ascent = paramFloat;
  }
  
  public String getFamily()
  {
    return this.family;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getStyle()
  {
    return this.style;
  }
  
  public static class a
  {
    public static tue a(JSONObject paramJSONObject)
    {
      return new tue(paramJSONObject.optString("fFamily"), paramJSONObject.optString("fName"), paramJSONObject.optString("fStyle"), (float)paramJSONObject.optDouble("ascent"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tue
 * JD-Core Version:    0.7.0.1
 */