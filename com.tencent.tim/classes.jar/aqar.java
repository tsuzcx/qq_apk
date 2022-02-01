import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig.a;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class aqar
  implements Manager
{
  private final QQAppInterface app;
  
  public aqar(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public static aqar a(QQAppInterface paramQQAppInterface)
  {
    return (aqar)paramQQAppInterface.getManager(189);
  }
  
  public boolean a(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper == null) || (paramUpgradeDetailWrapper.b == null) || (paramUpgradeDetailWrapper.a == null) || (paramUpgradeDetailWrapper.b.dialog == null)) {}
    int i;
    int j;
    int k;
    long l1;
    long l2;
    do
    {
      return false;
      i = aqmj.bx(this.app.getApp(), this.app.getCurrentUin());
      j = paramUpgradeDetailWrapper.b.dialog.dYf;
      k = paramUpgradeDetailWrapper.b.dialog.dYg;
      l1 = aqmj.t(this.app.getApp(), this.app.getCurrentUin());
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "needShowDownloadDialog: invoked. ", " downloadDialogMaxTimes: ", Integer.valueOf(j), " downloadDialogShownTimes: ", Integer.valueOf(i), " downloadDialogDayRate: ", Integer.valueOf(k), " downloadDialogShownTimestamp: ", Long.valueOf(l1), " now: ", Long.valueOf(l2) });
      }
    } while ((i >= j) || (l2 - l1 < k * 86400000L));
    return true;
  }
  
  public boolean aBN()
  {
    if (aqap.a().getDownloadState() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "hasNewApkDownloaded: invoked. ", " hasDl: ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean b(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper == null) || (paramUpgradeDetailWrapper.b == null) || (paramUpgradeDetailWrapper.a == null) || (paramUpgradeDetailWrapper.b.dialog == null)) {}
    int i;
    int j;
    int k;
    long l1;
    long l2;
    do
    {
      return false;
      i = aqmj.by(this.app.getApp(), this.app.getCurrentUin());
      j = paramUpgradeDetailWrapper.b.dialog.dYh;
      k = paramUpgradeDetailWrapper.b.dialog.dYi;
      l1 = aqmj.u(this.app.getApp(), this.app.getCurrentUin());
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "needShowInstallDialog: invoked. ", " installDialogMaxTimes: ", Integer.valueOf(j), " installDialogShownTimes: ", Integer.valueOf(i), " installDialogDayRate: ", Integer.valueOf(k), " installDialogShownTimestamp: ", Long.valueOf(l1), " now: ", Long.valueOf(l2) });
      }
    } while ((i >= j) || (l2 - l1 < k * 86400000L));
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqar
 * JD-Core Version:    0.7.0.1
 */