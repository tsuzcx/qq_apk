package cooperation.qhuanji;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;

public class QHuanjiPluginProxyActivity
  extends PluginProxyActivity
{
  public static boolean ddT;
  
  public static ClassLoader a(Context paramContext)
    throws Exception
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qhuanji_plugin.apk");
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i("miles", "QHuanjiPluginProxyActivity >> onPause.");
    ddT = false;
  }
  
  public void onResume()
  {
    super.onResume();
    Log.i("miles", "QHuanjiPluginProxyActivity >> onResume.");
    ddT = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qhuanji.QHuanjiPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */