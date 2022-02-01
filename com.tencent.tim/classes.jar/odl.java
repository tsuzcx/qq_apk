import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

final class odl
  implements DialogInterface.OnClickListener
{
  odl(int paramInt1, int paramInt2, Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 1;
    awit.H("readinjoy_user_data_switch", Integer.valueOf(1));
    paramDialogInterface.dismiss();
    paramDialogInterface = new JSONObject();
    try
    {
      if (this.val$type == 1) {
        paramInt = 0;
      }
      paramDialogInterface.put("click_src", paramInt);
      paramDialogInterface.put("user_data_alert_interval", this.beu);
      paramDialogInterface.put("click_opt", 2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    kbp.a(null, "", "0X800A809", "0X800A809", 0, 0, "", "", "", paramDialogInterface.toString(), false);
    if (this.val$runnable != null) {
      this.val$runnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     odl
 * JD-Core Version:    0.7.0.1
 */