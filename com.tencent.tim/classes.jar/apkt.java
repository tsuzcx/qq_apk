import org.json.JSONException;
import org.json.JSONObject;

public class apkt
  extends apkn
{
  public boolean cRf;
  public boolean cRg;
  public int dUT;
  public String mText;
  
  public apkt(String paramString)
  {
    this.mText = paramString;
    this.mData = new JSONObject();
    try
    {
      this.mData.put("type", "str");
      this.mData.put("text", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public apkt(JSONObject paramJSONObject)
    throws JSONException
  {
    bN(paramJSONObject);
  }
  
  public void bN(JSONObject paramJSONObject)
    throws JSONException
  {
    this.mData = paramJSONObject;
    this.mText = paramJSONObject.optString("text");
    this.dUT = this.mText.length();
  }
  
  public int getSize()
  {
    return this.mText.length();
  }
  
  public int getType()
  {
    return 0;
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
    try
    {
      this.mData.put("text", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkt
 * JD-Core Version:    0.7.0.1
 */