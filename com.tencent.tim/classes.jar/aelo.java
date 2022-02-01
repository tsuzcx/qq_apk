import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aelo
{
  private boolean bUZ = true;
  
  public static aelo a(aeic[] paramArrayOfaeic)
  {
    aelo localaelo = new aelo();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        int j = paramArrayOfaeic.length;
        int i = 0;
        if (i < j)
        {
          String str = paramArrayOfaeic[i].content;
          QLog.d("OpenSdkD55Processor", 1, new Object[] { "content=", str });
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enableIframe"))
          {
            if (localJSONObject.optInt("enableIframe", 1) != 0)
            {
              bool = true;
              localaelo.bUZ = bool;
            }
          }
          else
          {
            localStringBuilder.append("config: ").append(str).append(",");
            i += 1;
          }
        }
        else
        {
          QLog.d("OpenSdkIFrameProcessor", 1, "parse, content:" + localStringBuilder.toString());
          return localaelo;
        }
      }
      catch (JSONException paramArrayOfaeic)
      {
        QLog.e("OpenSdkIFrameProcessor", 1, "JSONException", paramArrayOfaeic);
        return null;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelo
 * JD-Core Version:    0.7.0.1
 */