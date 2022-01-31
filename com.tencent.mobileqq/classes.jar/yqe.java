import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class yqe
  extends nbq
{
  public boolean a;
  
  public yqe(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public String a()
  {
    return "key_for_troop_config_for_all_cfg";
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    this.a = true;
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
        this.a = bool;
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
  
  public String b()
  {
    return "key_for_troop_config_for_all_cfg_version";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yqe
 * JD-Core Version:    0.7.0.1
 */