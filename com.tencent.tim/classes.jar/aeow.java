import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeow
{
  public String bAc = "0";
  public String bAd = "0";
  public String bAe = "0";
  public String bAf = "";
  public boolean bVo;
  public boolean bVp;
  public boolean bVq = true;
  
  public static aeow a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        aeow localaeow = new aeow();
        paramString = new JSONObject(paramString);
        if (paramString.has("wvShouldReportPerf"))
        {
          if (paramString.optInt("wvShouldReportPerf") == 1)
          {
            bool = true;
            localaeow.bVo = bool;
          }
        }
        else
        {
          if (paramString.has("wvShouldReportJsapiCall"))
          {
            if (paramString.optInt("wvShouldReportJsapiCall") != 1) {
              break label212;
            }
            bool = true;
            label70:
            localaeow.bVp = bool;
          }
          if (paramString.has("wvShouldReportOpenapiCall")) {
            if (paramString.optInt("wvShouldReportOpenapiCall") != 1) {
              break label217;
            }
          }
        }
        label212:
        label217:
        for (boolean bool = true;; bool = false)
        {
          localaeow.bVq = bool;
          if (paramString.has("wvPerformanceRate")) {
            localaeow.bAc = paramString.optString("wvPerformanceRate");
          }
          if (paramString.has("wvJsapiCallRate")) {
            localaeow.bAd = paramString.optString("wvJsapiCallRate");
          }
          if (paramString.has("wvSchemeRate")) {
            localaeow.bAe = paramString.optString("wvSchemeRate");
          }
          if (paramString.has("recogniseText")) {
            localaeow.bAf = paramString.optString("recogniseText");
          }
          QLog.d("ConfBean", 2, "confBean = " + localaeow.toString());
          return localaeow;
          bool = false;
          break;
          bool = false;
          break label70;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("reportPerformance:").append(this.bVo);
    localStringBuilder.append(" reportJsapi:").append(this.bVp);
    localStringBuilder.append(" reportOpenapi:").append(this.bVq);
    localStringBuilder.append(" performanceRate:").append(this.bAc);
    localStringBuilder.append(" jsapiRate:").append(this.bAd);
    localStringBuilder.append(" schemeRate:").append(this.bAe);
    localStringBuilder.append(" recogniseText:").append(this.bAf);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeow
 * JD-Core Version:    0.7.0.1
 */