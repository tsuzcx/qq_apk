import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aeuf
{
  private String bBK = "";
  private boolean bWw;
  
  public static aeuf a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aeuf localaeuf = new aeuf();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      localaeuf.bWw = paramArrayOfaeic.getBoolean("enable");
      localaeuf.bBK = paramArrayOfaeic.getString("content");
      return localaeuf;
    }
    catch (JSONException paramArrayOfaeic)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfaeic.getLocalizedMessage(), paramArrayOfaeic);
    }
    return localaeuf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeuf
 * JD-Core Version:    0.7.0.1
 */