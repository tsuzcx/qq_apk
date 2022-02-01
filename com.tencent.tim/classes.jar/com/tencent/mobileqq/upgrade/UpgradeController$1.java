package com.tencent.mobileqq.upgrade;

import accy;
import anaz;
import android.text.TextUtils;
import aqap;
import aqar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeController$1
  implements Runnable
{
  public UpgradeController$1(aqap paramaqap, boolean paramBoolean) {}
  
  public void run()
  {
    if ((aqap.a(this.this$0) == null) || (aqap.a(this.this$0).b == null) || (aqap.a(this.this$0).b.dialog == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!aqap.a(this.this$0).b.dialog.csb.equals("1")) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("UpgradeController", 2, "showUpgradeTip config do not allow to tip");
                return;
                if (anaz.gQ() >= aqap.a(this.this$0).b.dialog.showTime / 1000L) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("UpgradeController", 2, "showUpgradeTip want to tip but is not time to show");
              return;
              localObject = (QQAppInterface)aqap.a(this.this$0).getRuntime();
            } while (localObject == null);
            if ((this.this$0.getDownloadState() != 4) || (!this.this$0.aBM())) {
              break;
            }
          } while ((aqap.a(this.this$0) == null) || (TextUtils.isEmpty(aqap.a(this.this$0).filePath)));
          aqap.a(this.this$0, true);
          localObject = new File(aqap.a(this.this$0).filePath);
        } while (!((File)localObject).exists());
        ((File)localObject).delete();
      } while (!QLog.isColorLevel());
      QLog.d("UpgradeController", 2, "showUpgradeTip the jacked apk has been removed.");
      return;
      aqar.a((QQAppInterface)localObject);
      if (!accy.ad((QQAppInterface)localObject))
      {
        bool = aqap.a(this.this$0, (QQAppInterface)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, String.format("showUpgradeTip not wifi download needDialog=%s showDialog=%s", new Object[] { Boolean.valueOf(this.cTr), Boolean.valueOf(bool) }));
        }
        if ((this.cTr) && (bool))
        {
          this.this$0.ac((QQAppInterface)localObject, false);
          return;
        }
        this.this$0.es((QQAppInterface)localObject);
        return;
      }
    } while ((aqap.a(this.this$0).a == null) || (aqap.a(this.this$0).a.iUpgradeType != 1));
    boolean bool = aqap.a(this.this$0, (QQAppInterface)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, String.format("showUpgradeTip wifi download showDialog=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    if (bool)
    {
      this.this$0.ac((QQAppInterface)localObject, true);
      return;
    }
    this.this$0.es((QQAppInterface)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.1
 * JD-Core Version:    0.7.0.1
 */