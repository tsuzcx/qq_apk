import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aeuj
{
  private boolean bWx;
  private boolean bWy;
  private boolean bWz;
  
  public static aeuj a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aeuj localaeuj = new aeuj();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      localaeuj.bWx = paramArrayOfaeic.getBoolean("fastload");
      localaeuj.bWy = paramArrayOfaeic.getBoolean("prefetch");
      localaeuj.bWz = paramArrayOfaeic.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localaeuj.bWx + ", prefetch = " + localaeuj.bWy + ", preloadWebView = " + localaeuj.bWz);
      return localaeuj;
    }
    catch (JSONException paramArrayOfaeic)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfaeic.getLocalizedMessage(), paramArrayOfaeic);
    }
    return localaeuj;
  }
  
  public boolean ahY()
  {
    return this.bWx;
  }
  
  public boolean ahZ()
  {
    return this.bWy;
  }
  
  public boolean aia()
  {
    return this.bWz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeuj
 * JD-Core Version:    0.7.0.1
 */