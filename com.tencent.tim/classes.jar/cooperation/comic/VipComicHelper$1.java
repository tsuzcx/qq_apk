package cooperation.comic;

import avcw;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jpa;

public final class VipComicHelper$1
  implements Runnable
{
  public VipComicHelper$1(WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    int j = 0;
    QQAppInterface localQQAppInterface = (QQAppInterface)this.eJ.get();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      String str = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.comic_plugin_profile.name(), "");
      Integer[] arrayOfInteger = new Integer[7];
      int i = j;
      if (DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.e()) >= arrayOfInteger.length)
      {
        i = j;
        if ((arrayOfInteger[4].intValue() & this.ewF) != 0) {
          i = 1;
        }
      }
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ComicHelper", 2, "Skip update offline pkg. entry = " + this.ewF);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ComicHelper", 2, "Do update offline pkg. entry = " + this.ewF);
    }
    jpa.b("354", localQQAppInterface, true, new avcw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicHelper.1
 * JD-Core Version:    0.7.0.1
 */