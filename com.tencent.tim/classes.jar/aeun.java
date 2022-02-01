import org.json.JSONException;
import org.json.JSONObject;

public class aeun
{
  private boolean bWA;
  
  public static aeun a(aeic[] paramArrayOfaeic)
  {
    boolean bool = true;
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0))
    {
      paramArrayOfaeic = null;
      return paramArrayOfaeic;
    }
    aeun localaeun = new aeun();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaeic[0].content);
        paramArrayOfaeic = localaeun;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localaeun.bWA = bool;
          return localaeun;
        }
      }
      catch (JSONException paramArrayOfaeic)
      {
        paramArrayOfaeic.printStackTrace();
        return localaeun;
      }
      bool = false;
    }
  }
  
  public boolean aib()
  {
    return this.bWA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeun
 * JD-Core Version:    0.7.0.1
 */