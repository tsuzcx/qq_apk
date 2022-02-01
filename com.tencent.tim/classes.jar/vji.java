import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.mobileqq.activity.NotificationActivity;
import org.json.JSONObject;

public class vji
  implements DialogInterface.OnClickListener
{
  public vji(NotificationActivity paramNotificationActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = new JSONObject();
      paramDialogInterface.put("appid", "100686848");
      paramDialogInterface.put("apkId", "6633");
      paramDialogInterface.put("versionCode", String.valueOf(this.this$0.getPackageManager().getPackageInfo(this.val$packageName, 16384).versionCode));
      paramDialogInterface.put("via", "ANDROIDQQ.NEICE.OTHER");
      paramDialogInterface.put("appPackageName", this.val$packageName);
      paramDialogInterface.put("channel", "000316053134377c30");
      paramDialogInterface.put("appAuthorizedStr", NotificationActivity.a(this.this$0));
      paramDialogInterface = paramDialogInterface.toString();
      arzk.a().a(paramDialogInterface, new vjj(this), this.this$0);
      NotificationActivity.a(this.this$0, true);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vji
 * JD-Core Version:    0.7.0.1
 */