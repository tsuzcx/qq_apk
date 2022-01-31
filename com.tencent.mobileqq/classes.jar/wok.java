import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.troopplugin.PluginJumpManager;

public class wok
  implements moc
{
  public wok(PluginJumpManager paramPluginJumpManager) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      mof.a("urlplugin.cfg", this.a.mContext, "1007", new wol(this));
    }
    while (!TextUtils.isEmpty(this.a.mPref.getString("config_file_version", ""))) {
      return;
    }
    this.a.loadConfigFromFile();
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wok
 * JD-Core Version:    0.7.0.1
 */