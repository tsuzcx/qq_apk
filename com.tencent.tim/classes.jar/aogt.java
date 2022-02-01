import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.theme.ThemeSwitcher.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aogt
  extends ThemeSwitcher.a
{
  aogt(aogs paramaogs) {}
  
  public boolean a(aogy paramaogy)
  {
    this.b.themeSwitchManager.dUB();
    return false;
  }
  
  public void beginSwitch()
  {
    if (aogs.a(this.b) == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)aogs.a(this.b).get())
    {
      if (localActivity != null) {
        this.b.themeSwitchManager.ci(localActivity);
      }
      return;
    }
  }
  
  public boolean bu(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("start_status", 2);
    if (paramInt == 0) {
      this.b.mUiHandler.sendMessage(Message.obtain(this.b.mUiHandler, 4099, 1, 0, localBundle));
    }
    for (;;)
    {
      return super.bu(paramInt);
      this.b.themeSwitchManager.dUC();
      this.b.mUiHandler.sendEmptyMessage(4100);
      this.b.mUiHandler.sendMessage(Message.obtain(this.b.mUiHandler, 4099, -2, 0, localBundle));
    }
  }
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    int i = 100;
    if (paramLong2 <= 0L)
    {
      QLog.e("NightModeLogic", 1, "mThemeDownloadListener onDownloadProgress dwProgressMax <= 0");
      i = 4;
    }
    if (paramLong1 <= paramLong2) {
      i = (int)(100.0D * paramLong1 / paramLong2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("NightModeLogic", 2, "mThemeDownloadListener onDownloadProgress readSize:" + paramLong1 + ", allSize:" + paramLong2 + ", percent:" + i);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("percent", i);
    localBundle.putInt("start_status", 3);
    this.b.mUiHandler.sendMessage(Message.obtain(this.b.mUiHandler, 4099, 1, 0, localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogt
 * JD-Core Version:    0.7.0.1
 */