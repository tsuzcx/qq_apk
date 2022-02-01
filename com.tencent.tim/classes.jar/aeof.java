import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeof
{
  public aepa a = new aepa();
  public boolean bVl;
  
  public static aeof a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aeof localaeof = new aeof();
        paramString = new JSONObject(paramString);
        localaeof.bVl = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          aepa localaepa = new aepa();
          localaepa.setVersion(paramString.optInt("version"));
          localaepa.LX(paramString.optInt("jumpType"));
          localaepa.setJumpUrl(paramString.optString("jumpUrl"));
          localaepa.Hs(paramString.optString("jumpExtensionInfo"));
          localaeof.a = localaepa;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localaeof.toString());
        return localaeof;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.bVl).append(", watchTogether=");
    if (this.a == null) {}
    for (String str = "null";; str = this.a.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeof
 * JD-Core Version:    0.7.0.1
 */