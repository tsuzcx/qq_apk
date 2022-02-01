import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

final class ntq
  implements ntp.b
{
  public void bbp()
  {
    Object localObject = ntp.fc("https://viola/viola_config.json?v_bid=3192");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONObject((String)localObject);
        JSONArray localJSONArray = (JSONArray)((JSONObject)localObject).get("preload_bids");
        int i = 0;
        while (i < localJSONArray.length())
        {
          ntp.a((String)localJSONArray.get(i), null);
          i += 1;
        }
        ntp.uin = kxm.getAccount();
        ntp.yi = System.currentTimeMillis();
        if (((JSONObject)localObject).has("use_main")) {
          ntp.auK = ((Boolean)((JSONObject)localObject).get("use_main")).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is success!");
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ViolaAccessHelper", 2, "pre load all offline from offline is exception:" + localException.getMessage());
        }
        ntp.bbo();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is empty!");
    }
    ntp.bbo();
  }
  
  public void bbq() {}
  
  public void uk(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntq
 * JD-Core Version:    0.7.0.1
 */