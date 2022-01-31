import org.json.JSONObject;

public class tqq
  extends JSONObject
{
  public tqq(tqp paramtqp, String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqq
 * JD-Core Version:    0.7.0.1
 */