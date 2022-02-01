import org.json.JSONObject;

public class tse
{
  private final String fileName;
  private final int height;
  private final String id;
  private final int width;
  
  private tse(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.id = paramString1;
    this.fileName = paramString2;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  static class a
  {
    static tse a(JSONObject paramJSONObject)
    {
      return new tse(paramJSONObject.optInt("w"), paramJSONObject.optInt("h"), paramJSONObject.optString("id"), paramJSONObject.optString("p"), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tse
 * JD-Core Version:    0.7.0.1
 */