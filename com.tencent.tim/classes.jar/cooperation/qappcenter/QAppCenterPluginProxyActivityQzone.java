package cooperation.qappcenter;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QAppCenterPluginProxyActivityQzone
  extends PluginProxyActivity
{
  public static boolean ddT;
  
  public void onCreate(Bundle paramBundle)
  {
    QAppCenterPluginProxyActivityTools.cG(this);
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
 * Qualified Name:     cooperation.qappcenter.QAppCenterPluginProxyActivityQzone
 * JD-Core Version:    0.7.0.1
 */