package cooperation.plugin;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class PluginBaseActivity2
  extends BasePluginActivity
{
  public boolean mActNeedImmersive = true;
  public boolean mNeedStatusTrans = true;
  public SystemBarCompact mSystemBarComp;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.mActNeedImmersive) {
        this.mSystemBarComp = new SystemBarCompact(this, true, getResources().getColor(2131167361));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginBaseActivity2
 * JD-Core Version:    0.7.0.1
 */