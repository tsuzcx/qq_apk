package cooperation.comic;

import avcv;
import aveb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class VipComicJumpActivity$1
  extends VipComicJumpActivity.PluginCheckJob
{
  VipComicJumpActivity$1(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.mAppRef.get();
    if (localQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!aveb.p(localQQAppInterface)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQComicDebug", 2, "plugin is installed.");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "wait for plugin installation...");
        }
        avcv.n(2, localQQAppInterface);
        if (aveb.a(localQQAppInterface, true, null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQComicDebug", 2, "plugin install failed.");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("QQComicDebug", 2, "plugin is installed now.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity.1
 * JD-Core Version:    0.7.0.1
 */