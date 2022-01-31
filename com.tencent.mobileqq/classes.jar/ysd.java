import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.troopplugin.PluginJumpManager;

public class ysd
  implements nbs
{
  public ysd(PluginJumpManager paramPluginJumpManager) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      nbv.a("urlplugin.cfg", this.a.mContext, "1007", new yse(this));
    }
    while (!TextUtils.isEmpty(this.a.mPref.getString("config_file_version", ""))) {
      return;
    }
    this.a.loadConfigFromFile();
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysd
 * JD-Core Version:    0.7.0.1
 */