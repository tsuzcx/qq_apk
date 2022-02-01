import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aeoo
{
  public boolean bVn = false;
  public String bzY = "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=$GCODE$&role=$ROLE$&actionIcon=1&from=troop_profile";
  public String bzZ = "https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting";
  
  public static aeoo a(aeic[] paramArrayOfaeic)
  {
    aeoo localaeoo = new aeoo();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      int j = paramArrayOfaeic.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfaeic[i];
        if (localObject == null)
        {
          i += 1;
        }
        else
        {
          localObject = ((aeic)localObject).content;
          for (;;)
          {
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject);
              if (localJSONObject.has("announcementUrl")) {
                localaeoo.bzY = localJSONObject.optString("announcementUrl");
              }
              if (localJSONObject.has("autoApprovalUrl")) {
                localaeoo.bzZ = localJSONObject.optString("autoApprovalUrl");
              }
              if (!localJSONObject.has("frequencyLimitVisible")) {
                continue;
              }
              if (localJSONObject.getInt("frequencyLimitVisible") != 1) {
                continue;
              }
              bool = true;
              localaeoo.bVn = bool;
            }
            catch (JSONException localJSONException)
            {
              boolean bool;
              localJSONException.printStackTrace();
              continue;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("TroopUrlConfBean", 2, "parse: " + (String)localObject);
            break;
            bool = false;
            continue;
            localaeoo.bVn = false;
          }
        }
      }
    }
    if (TextUtils.isEmpty(localaeoo.bzY)) {
      localaeoo.bzY = "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=$GCODE$&role=$ROLE$&actionIcon=1&from=troop_profile";
    }
    if (TextUtils.isEmpty(localaeoo.bzZ)) {
      localaeoo.bzZ = "https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting";
    }
    return localaeoo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("TroopUrlConfBean [announcement: ").append(this.bzY).append(", autoApproval: ").append(this.bzZ).append(", freqLimitVisible: ").append(this.bVn).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeoo
 * JD-Core Version:    0.7.0.1
 */