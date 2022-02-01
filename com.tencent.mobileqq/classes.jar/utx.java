import org.json.JSONException;
import org.json.JSONObject;

class utx
  implements srb
{
  utx(uta paramuta) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_vid", paramString1);
      localJSONObject.put("retCode", paramInt);
      this.a.callJs(paramString2, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utx
 * JD-Core Version:    0.7.0.1
 */