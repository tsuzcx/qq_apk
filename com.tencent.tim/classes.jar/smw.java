import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class smw
  extends jov
{
  public boolean aMd;
  
  public smw(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public String hJ()
  {
    return "key_for_troop_config_for_all_cfg";
  }
  
  public String hK()
  {
    return "key_for_troop_config_for_all_cfg_version";
  }
  
  public void kX(String paramString)
  {
    boolean bool = true;
    this.aMd = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("isShow3kTroopTips") != 1) {
          break label56;
        }
        this.aMd = bool;
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("TroopConfigForAllUser", 2, paramString.getMessage());
      return;
      label56:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smw
 * JD-Core Version:    0.7.0.1
 */