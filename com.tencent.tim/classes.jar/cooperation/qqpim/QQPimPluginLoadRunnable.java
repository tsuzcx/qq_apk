package cooperation.qqpim;

import anot;
import avfw;
import avli;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class QQPimPluginLoadRunnable
  implements Runnable
{
  private avfw jdField_a_of_type_Avfw;
  private a jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a;
  private boolean isStop;
  private long mStartTime;
  
  public QQPimPluginLoadRunnable(a parama)
  {
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a = parama;
  }
  
  private QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void run()
  {
    this.mStartTime = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = getAppInterface();
    if (localQQAppInterface == null) {}
    label114:
    label249:
    do
    {
      do
      {
        do
        {
          PluginInfo localPluginInfo;
          do
          {
            do
            {
              do
              {
                return;
                this.jdField_a_of_type_Avfw = ((avfw)localQQAppInterface.getManager(27));
              } while (this.jdField_a_of_type_Avfw == null);
              localPluginInfo = this.jdField_a_of_type_Avfw.b("qqpim_plugin.apk");
              if (localPluginInfo != null)
              {
                if (localPluginInfo.mState != 4) {
                  break label182;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.i(avli.TAG, 1, "onPluginManagerLoaded has installed");
                }
                anot.a(localQQAppInterface, "CliOper", "", "", "0X8006716", "0X8006716", 0, 0, "", "", "", "");
                if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a != null) {
                  this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.eAB();
                }
              }
              do
              {
                for (;;)
                {
                  if (this.isStop) {
                    break label460;
                  }
                  if (System.currentTimeMillis() - this.mStartTime <= 30000L) {
                    break label249;
                  }
                  anot.a(getAppInterface(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
                  if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a == null) {
                    break;
                  }
                  this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.abL(-5);
                  return;
                  if (QLog.isDevelopLevel()) {
                    QLog.i(avli.TAG, 1, "onPluginManagerLoaded start down or install...");
                  }
                  anot.a(localQQAppInterface, "CliOper", "", "", "0X8006717", "0X8006717", 0, 0, "", "", "", "");
                  this.jdField_a_of_type_Avfw.installPlugin("qqpim_plugin.apk");
                  if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a != null) {
                    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.eAC();
                  }
                }
                localPluginInfo = this.jdField_a_of_type_Avfw.b("qqpim_plugin.apk");
                if (localPluginInfo != null) {
                  break label333;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.d(avli.TAG, 4, "null == pluginInfo");
                }
              } while (!this.jdField_a_of_type_Avfw.isReady());
              anot.a(getAppInterface(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
            } while (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a == null);
            this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.abL(-1);
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d(avli.TAG, 4, "queryPluginInfo mState : " + localPluginInfo.mState + " progress:" + localPluginInfo.mDownloadProgress);
            }
            if (localPluginInfo.mState != 4) {
              break;
            }
            anot.a(localQQAppInterface, "CliOper", "", "", "0X8006718", "0X8006718", 0, 0, "", "", "", "");
          } while (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a == null);
          this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.eAB();
          return;
          if (localPluginInfo.mState == 0) {
            this.jdField_a_of_type_Avfw.installPlugin("qqpim_plugin.apk");
          }
          for (;;)
          {
            try
            {
              Thread.sleep(500L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
            break label114;
            break;
            if (localInterruptedException.mState == 3)
            {
              if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a != null) {
                this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.bm(localInterruptedException.mDownloadProgress);
              }
            }
            else if (localInterruptedException.mState == 1)
            {
              if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a != null) {
                this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.bm(localInterruptedException.mDownloadProgress);
              }
            }
            else
            {
              if (localInterruptedException.mState != 2) {
                break label555;
              }
              if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a != null) {
                this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.bm(localInterruptedException.mDownloadProgress);
              }
            }
          }
          if (localInterruptedException.mState != -1) {
            break;
          }
          anot.a(getAppInterface(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
        } while (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a == null);
        this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.abL(-6);
        return;
        if (localInterruptedException.mState != -2) {
          break;
        }
        anot.a(getAppInterface(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
      } while (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a == null);
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.abL(-3);
      return;
      anot.a(getAppInterface(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
    } while (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a == null);
    label182:
    label333:
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a.abL(-2);
    label460:
  }
  
  public void stop()
  {
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a = null;
    this.isStop = true;
  }
  
  public static abstract interface a
  {
    public abstract void abL(int paramInt);
    
    public abstract void bm(float paramFloat);
    
    public abstract void eAB();
    
    public abstract void eAC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginLoadRunnable
 * JD-Core Version:    0.7.0.1
 */