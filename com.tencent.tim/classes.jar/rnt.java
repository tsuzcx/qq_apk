import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class rnt
  extends jov
{
  public boolean aJb;
  
  public rnt(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public String hJ()
  {
    return "key_for_troop_dynamic";
  }
  
  public String hK()
  {
    return "key_for_troop_dynamic_version";
  }
  
  public void kX(String paramString)
  {
    boolean bool = true;
    this.aJb = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).getInt("isShowTroopDynamic") != 1) {
          break label56;
        }
        this.aJb = bool;
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("readQuickShotShareToStoryConfig", 2, paramString.getMessage());
      return;
      label56:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rnt
 * JD-Core Version:    0.7.0.1
 */