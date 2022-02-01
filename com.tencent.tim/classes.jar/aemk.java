import org.json.JSONObject;

public class aemk
{
  private long WA = 2000L;
  private long WB = 60000L;
  private boolean bVb = true;
  private boolean bVc = false;
  private boolean compressAndEncrypt = false;
  private boolean useNewLog = true;
  
  public static aemk a(String paramString)
  {
    boolean bool2 = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      aemk localaemk = new aemk();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("useNewLog", 1) == 1)
      {
        bool1 = true;
        localaemk.useNewLog = bool1;
        if (paramString.optInt("compressAndEncrypt", 0) != 1) {
          break label130;
        }
        bool1 = true;
        label56:
        localaemk.compressAndEncrypt = bool1;
        if (paramString.optInt("enableConsole", 1) != 1) {
          break label135;
        }
        bool1 = true;
        label74:
        localaemk.bVb = bool1;
        if (paramString.optInt("enableCheckPermission", 1) != 1) {
          break label140;
        }
      }
      label130:
      label135:
      label140:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localaemk.bVc = bool1;
        localaemk.WA = paramString.optLong("locationSdkCallbackIntervalMillis", 2000L);
        localaemk.WB = paramString.optLong("locationBgTimeoutMillis", 60000L);
        return localaemk;
        bool1 = false;
        break;
        bool1 = false;
        break label56;
        bool1 = false;
        break label74;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean ahk()
  {
    return this.useNewLog;
  }
  
  public boolean ahl()
  {
    return this.bVc;
  }
  
  public long fv()
  {
    if (this.WA < 0L) {
      return 2000L;
    }
    return this.WA;
  }
  
  public long fw()
  {
    if (this.WB < 0L) {
      return 60000L;
    }
    return this.WB;
  }
  
  public String toString()
  {
    return "QConfLogBean{useNewLog=" + this.useNewLog + ", compressAndEncrypt=" + this.compressAndEncrypt + ", enableConsole=" + this.bVb + ",enableCheckPermission=" + this.bVc + ",locationSdkCallbackIntervalMillis=" + this.WA + ",locationBgTimeoutMillis=" + this.WB + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemk
 * JD-Core Version:    0.7.0.1
 */