import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class vza
  extends BroadcastReceiver
{
  public vza(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while (!"changeGroupTribe".equals(paramIntent.getStringExtra("event")));
      paramContext = paramIntent.getStringExtra("data");
    } while (paramContext == null);
    try
    {
      paramContext = new JSONObject(paramContext);
      this.this$0.a.tribeId = paramContext.optInt("bid");
      this.this$0.a.tribeName = paramContext.optString("bname");
      this.this$0.fk = true;
      paramContext = new ArrayList();
      if (!TextUtils.isEmpty(this.this$0.a.tribeName)) {
        paramContext.add(this.this$0.a.tribeName);
      }
      this.this$0.a(9, paramContext, true, 1, true);
      return;
    }
    catch (JSONException paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vza
 * JD-Core Version:    0.7.0.1
 */