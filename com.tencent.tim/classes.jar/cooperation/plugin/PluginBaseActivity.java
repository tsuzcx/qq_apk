package cooperation.plugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qphone.base.util.QLog;

public class PluginBaseActivity
  extends BasePluginActivity
{
  protected boolean mIsAttachedToWindow;
  public boolean mNeedStatusTrans = true;
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  @TargetApi(24)
  public boolean isInMultiWindow()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      bool1 = isInMultiWindowMode();
      if (QLog.isDebugVersion()) {
        QLog.i("PluginBaseActivity", 2, " fight...isInMultiWindowMode = " + bool1);
      }
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    return false;
  }
  
  protected String setLastActivityName()
  {
    return getString(2131691039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginBaseActivity
 * JD-Core Version:    0.7.0.1
 */