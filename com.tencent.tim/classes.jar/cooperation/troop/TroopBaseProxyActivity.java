package cooperation.troop;

import acfp;
import android.app.Activity;
import android.app.Dialog;
import android.widget.TextView;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class TroopBaseProxyActivity
  extends PluginProxyActivity
{
  public static Dialog a(Activity paramActivity)
  {
    do
    {
      try
      {
        paramActivity = new ReportDialog(paramActivity, 2131756467);
        Activity localActivity = paramActivity;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          paramActivity.setCancelable(true);
          paramActivity.setContentView(2131559761);
          paramActivity.show();
          ((TextView)paramActivity.findViewById(2131373180)).setText(acfp.m(2131715609));
          localActivity = paramActivity;
          return localActivity;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          continue;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        paramActivity = null;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopBaseProxyActivity", 2, localOutOfMemoryError1.getStackTrace());
    return paramActivity;
  }
  
  public String getPluginID()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop.TroopBaseProxyActivity
 * JD-Core Version:    0.7.0.1
 */