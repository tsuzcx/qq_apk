import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aelk
{
  private boolean bUX;
  
  public static aelk a(aeic[] paramArrayOfaeic)
  {
    aelk localaelk = new aelk();
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
          if (localJSONObject.has("enable_d55"))
          {
            if (localJSONObject.optInt("enable_d55", 0) == 1)
            {
              bool = true;
              localaelk.bUX = bool;
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
          QLog.d("OpenSdkD55Processor", 1, "parse, content:" + localStringBuilder.toString());
          return localaelk;
        }
      }
      catch (JSONException paramArrayOfaeic)
      {
        QLog.e("OpenSdkD55Processor", 1, "JSONException", paramArrayOfaeic);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean ahg()
  {
    return this.bUX;
  }
  
  public String toString()
  {
    new StringBuilder().append("isSwitchOpen:").append(this.bUX);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelk
 * JD-Core Version:    0.7.0.1
 */