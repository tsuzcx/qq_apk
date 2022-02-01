import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aeuh
{
  public String bBL = acfp.m(2131715218);
  public String bBM = acfp.m(2131715225);
  public String bBN = acfp.m(2131715221);
  public String bBO = acfp.m(2131715223);
  public String bBP = acfp.m(2131715216);
  
  public static aeuh a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aeuh localaeuh = new aeuh();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content).optJSONObject("MyFileNameConfig");
      localaeuh.bBL = paramArrayOfaeic.optString("tdfileTabName");
      localaeuh.bBM = paramArrayOfaeic.optString("wyfileTabName");
      localaeuh.bBN = paramArrayOfaeic.optString("tdlistTabviewName");
      localaeuh.bBO = paramArrayOfaeic.optString("createTXDocTitle");
      localaeuh.bBP = paramArrayOfaeic.optString("safeShareToastWording");
      return localaeuh;
    }
    catch (JSONException paramArrayOfaeic)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfaeic.getLocalizedMessage(), paramArrayOfaeic);
    }
    return localaeuh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeuh
 * JD-Core Version:    0.7.0.1
 */