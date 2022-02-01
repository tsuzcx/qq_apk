import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aeoy
{
  public String bAg = "";
  public String bAh = "";
  public String bAi = "";
  public String bAj = "";
  public String bAk = "";
  public String bAl = "";
  public int cOn;
  public int cOo = -1;
  
  public static aeoy a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aeoy localaeoy = new aeoy();
        paramString = new JSONObject(paramString);
        Object localObject = paramString.optJSONArray("whiteList");
        if (localObject != null) {
          localaeoy.bAg = ((JSONArray)localObject).toString();
        }
        localObject = paramString.optJSONObject("jumpLimit");
        if (localObject != null) {
          localaeoy.bAh = ((JSONObject)localObject).toString();
        }
        localObject = paramString.optJSONArray("whiteListv2");
        if (localObject != null) {
          localaeoy.bAi = ((JSONArray)localObject).toString();
        }
        int i = paramString.optInt("aio_pre_safecheck", -1);
        if (i != -1) {
          localaeoy.cOn = i;
        }
        localObject = paramString.optJSONArray("kbWhiteList");
        if (localObject != null) {
          localaeoy.bAj = ((JSONArray)localObject).toString();
        }
        i = paramString.optInt("force_https_enable", -1);
        if (i != -1) {
          localaeoy.cOo = i;
        }
        localObject = paramString.optJSONArray("force_https_whitelist");
        if (localObject != null) {
          localaeoy.bAk = ((JSONArray)localObject).toString();
        }
        paramString = paramString.optJSONArray("force_https_blacklist");
        if (paramString != null) {
          localaeoy.bAl = paramString.toString();
        }
        QLog.d("ConfBean", 2, "confBean = " + localaeoy.toString());
        return localaeoy;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("whitelistStr:").append(this.bAg);
    localStringBuilder.append(" limit:").append(this.bAh);
    localStringBuilder.append(" whiteListV2:").append(this.bAi);
    localStringBuilder.append(" aioPreCheckSwitch:").append(this.cOn);
    localStringBuilder.append(" kbWhiteList:").append(this.bAj);
    localStringBuilder.append(" forceHttpsEnable:").append(this.cOo);
    localStringBuilder.append(" forceHttpsWhitelist:").append(this.bAk);
    localStringBuilder.append(" forceHttpsBlacklist:").append(this.bAl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeoy
 * JD-Core Version:    0.7.0.1
 */