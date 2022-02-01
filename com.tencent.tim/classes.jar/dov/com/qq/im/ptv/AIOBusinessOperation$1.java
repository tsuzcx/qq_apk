package dov.com.qq.im.ptv;

import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class AIOBusinessOperation$1
  implements Runnable
{
  public AIOBusinessOperation$1(ImageView paramImageView, boolean paramBoolean) {}
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    String str = ThemeUtil.getCurrentThemeId();
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("AIOBusinessOperation", 2, "updateLightVideoEntry themeId cost:" + (l2 - l1) + " ms");
    }
    ThreadManager.getUIHandler().post(new AIOBusinessOperation.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOBusinessOperation.1
 * JD-Core Version:    0.7.0.1
 */