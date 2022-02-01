import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aeqh
  implements aehx<String>
{
  public boolean bVO;
  public boolean bVP;
  public boolean bVQ;
  public boolean bVR;
  public boolean bVS;
  public int strategy;
  
  private void cXn()
  {
    this.bVO = false;
    this.bVP = false;
    this.bVQ = false;
    this.bVR = false;
    this.bVS = false;
    this.strategy = 0;
  }
  
  public void lR(String paramString)
  {
    QLog.i("QFileIPv6ConfigBean", 1, "configID:449 onParse FileIPv6Config:" + paramString);
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.toLowerCase();
    }
    if (TextUtils.isEmpty(str))
    {
      QLog.w("QFileIPv6ConfigBean", 1, "FileIPv6ConfigContent is empty, configID:449 use default value");
      cXn();
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(str).getJSONObject("ipv6config");
        if (paramString == null) {
          break label252;
        }
        if (paramString.has("allswitch"))
        {
          this.bVO = paramString.getBoolean("allswitch");
          if (!paramString.has("c2cenable")) {
            break label214;
          }
          this.bVP = paramString.getBoolean("c2cenable");
          if (!paramString.has("groupenable")) {
            break label222;
          }
          this.bVQ = paramString.getBoolean("groupenable");
          if (!paramString.has("discenable")) {
            break label230;
          }
          this.bVR = paramString.getBoolean("discenable");
          if (!paramString.has("datalineenable")) {
            break label238;
          }
          this.bVS = paramString.getBoolean("datalineenable");
          if (!paramString.has("strategy")) {
            break;
          }
          this.strategy = paramString.getInt("strategy");
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("QFileIPv6ConfigBean", 1, paramString, new Object[0]);
        return;
      }
      this.bVO = false;
      continue;
      label214:
      this.bVP = false;
      continue;
      label222:
      this.bVQ = false;
      continue;
      label230:
      this.bVR = false;
      continue;
      label238:
      this.bVS = false;
    }
    this.strategy = 0;
    return;
    label252:
    QLog.w("QFileIPv6ConfigBean", 1, "FileIPv6ConfigContent is no ipv6config. use default value");
    cXn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqh
 * JD-Core Version:    0.7.0.1
 */