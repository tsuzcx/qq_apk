import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeko
{
  public boolean bUC;
  public boolean bUD;
  public boolean bUE;
  public boolean bUF;
  public boolean bUG;
  public boolean bUH;
  public boolean bUI;
  public String byQ = "0.0f|0.0f|0.0f|0.0f";
  public String byR = "-1";
  public String byS = "-1";
  
  public static aeko a(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    for (;;)
    {
      try
      {
        aeko localaeko = new aeko();
        Object localObject = new JSONObject(paramString);
        localaeko.byQ = ((JSONObject)localObject).optString("userratio_new", "0.0f|0.0f|0.0f|0.0f");
        localaeko.byR = ((JSONObject)localObject).optString("extralsteps_new", "-1");
        localaeko.byS = ((JSONObject)localObject).optString("predownloadwhitelist_new", "-1");
        localaeko.bUG = ((JSONObject)localObject).optBoolean("useapm_new", false);
        paramString = Float.valueOf(Float.parseFloat(((JSONObject)localObject).optString("suspend_user_ratio", "0.0f")));
        if (paramString != null)
        {
          if (paramString.floatValue() > Math.random())
          {
            bool = true;
            localaeko.bUH = bool;
          }
        }
        else
        {
          localObject = Float.valueOf(Float.parseFloat(((JSONObject)localObject).optString("fake_suspend_user_ratio", "0.0f")));
          if (localObject != null)
          {
            if (((Float)localObject).floatValue() <= Math.random()) {
              break label459;
            }
            bool = true;
            localaeko.bUI = bool;
          }
          if (!localaeko.byQ.isEmpty())
          {
            String[] arrayOfString = localaeko.byQ.split("\\|");
            if (arrayOfString.length == 4)
            {
              float f1 = Float.parseFloat(arrayOfString[0]);
              float f2 = Float.parseFloat(arrayOfString[1]);
              float f3 = Float.parseFloat(arrayOfString[2]);
              float f4 = Float.parseFloat(arrayOfString[3]);
              if (f1 <= Math.random()) {
                break label465;
              }
              bool = true;
              localaeko.bUC = bool;
              if (f2 <= Math.random()) {
                break label471;
              }
              bool = true;
              localaeko.bUD = bool;
              if (f3 <= Math.random()) {
                break label477;
              }
              bool = true;
              localaeko.bUE = bool;
              if (f4 <= Math.random()) {
                break label483;
              }
              bool = true;
              localaeko.bUF = bool;
              QLog.d("Perf", 1, "disable_preload_user_ratio = " + f1 + ",disable_predownload_user_ratio = " + f2 + ",disable_gettroop_user_ratio = " + f3 + ",enable_auto_user_ratio = " + f4 + ",suspend_user_ratio = " + paramString + ",fake_suspend_user_ratio = " + localObject);
            }
          }
          paramString = localaeko;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Perf", 2, "confBean = " + localaeko.toString());
          return localaeko;
        }
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Perf", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
      continue;
      label459:
      bool = false;
      continue;
      label465:
      bool = false;
      continue;
      label471:
      bool = false;
      continue;
      label477:
      bool = false;
      continue;
      label483:
      bool = false;
    }
  }
  
  public boolean agM()
  {
    return !this.bUG;
  }
  
  public String toString()
  {
    return "LowEndPerfBean{mDisablePreloadProcess=" + this.bUC + ",mDisablePredownload=" + this.bUD + ",mDisableGetTroopList=" + this.bUE + ",mEnableAutomatorDelay=" + this.bUF + ",mUserRatio=" + this.byQ + ",mExtraSteps=" + this.byR + ",mPredownLoadWhiteList=" + this.byS + ",mUseApmConfig=" + this.bUG + ",mSuspend_Thread=" + this.bUH + ",mFake_Suspend_Thread = " + this.bUI + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeko
 * JD-Core Version:    0.7.0.1
 */