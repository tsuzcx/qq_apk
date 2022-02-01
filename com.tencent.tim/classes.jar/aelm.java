import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aelm
{
  private boolean bUY;
  
  public static aelm a(aeic[] paramArrayOfaeic)
  {
    aelm localaelm = new aelm();
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
          QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "content=", str });
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_fake_msg"))
          {
            if (localJSONObject.optInt("enable_fake_msg", 0) == 1)
            {
              bool = true;
              localaelm.bUY = bool;
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
          QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, "parse, content:" + localStringBuilder.toString());
          return localaelm;
        }
      }
      catch (JSONException paramArrayOfaeic)
      {
        QLog.e("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, "JSONException", paramArrayOfaeic);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean ahi()
  {
    return this.bUY;
  }
  
  public String toString()
  {
    new StringBuilder().append("isEnableFakeMsg:").append(this.bUY);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelm
 * JD-Core Version:    0.7.0.1
 */