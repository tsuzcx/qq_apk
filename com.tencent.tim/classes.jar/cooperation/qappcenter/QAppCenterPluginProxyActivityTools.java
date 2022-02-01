package cooperation.qappcenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QAppCenterPluginProxyActivityTools
  extends PluginProxyActivity
{
  public static boolean ddT;
  
  public static void cG(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getIntent();
      if ((paramActivity != null) && (paramActivity.getExtras() != null)) {
        paramActivity.putExtra("fling_action_key", 0);
      }
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    cG(this);
    Intent localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("big_brother_source_key", "biz_src_yyb");
    }
    super.onCreate(paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    ddT = false;
  }
  
  public void onResume()
  {
    super.onResume();
    ddT = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qappcenter.QAppCenterPluginProxyActivityTools
 * JD-Core Version:    0.7.0.1
 */