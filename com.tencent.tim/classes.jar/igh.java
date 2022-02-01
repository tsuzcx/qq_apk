import com.tencent.qphone.base.util.Cryptor;
import org.json.JSONObject;

public class igh
{
  public final String LJ = "uid";
  public final String LK = "ukey";
  public final String LL = "^%QAI$I+j{2HuP0L";
  public String LM;
  public String LN;
  
  public static igh a(String paramString)
  {
    igh localigh = new igh();
    if (localigh.ch(paramString)) {
      return localigh;
    }
    return null;
  }
  
  private boolean ch(String paramString)
  {
    try
    {
      paramString = aqgo.decode(paramString, 0);
      paramString = new JSONObject(new String(new Cryptor().decrypt(paramString, "^%QAI$I+j{2HuP0L".getBytes())));
      if (paramString.has("uid")) {
        this.LM = paramString.getString("uid");
      }
      for (int i = 1; (i != 0) && (paramString.has("ukey")); i = 0)
      {
        this.LN = paramString.getString("ukey");
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igh
 * JD-Core Version:    0.7.0.1
 */