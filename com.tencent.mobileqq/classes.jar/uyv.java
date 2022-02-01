import org.json.JSONObject;

public class uyv
  extends JSONObject
{
  public uyv(uyu paramuyu, String paramString)
  {
    super(paramString);
  }
  
  public int getInt(String paramString)
  {
    if (!has(paramString)) {
      return 0;
    }
    return super.getInt(paramString);
  }
  
  public String getString(String paramString)
  {
    if (!has(paramString)) {
      return "";
    }
    return super.getString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyv
 * JD-Core Version:    0.7.0.1
 */