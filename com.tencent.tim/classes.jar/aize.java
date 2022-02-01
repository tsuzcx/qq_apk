import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PushSwitchGrayTipsInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.managers.PushNotificationManager.1;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.Manager;

public class aize
  implements Manager
{
  public static int dha = 1;
  public static int dhb = 1;
  public static int dhc = 2;
  private aemm a;
  private long aca;
  private int dhd = -1;
  private QQAppInterface mApp;
  private EntityManager mEntityManager;
  
  public aize(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mEntityManager = paramQQAppInterface.a().createEntityManager();
    ThreadManager.executeOnSubThread(new PushNotificationManager.1(this, paramQQAppInterface));
  }
  
  private int Ge()
  {
    Long localLong = Long.valueOf(System.currentTimeMillis());
    if ((this.dhd >= 0) && (localLong.longValue() - this.aca < 86400000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("PushNotificationManager", 2, "mTodayHadShowCount=" + this.dhd + " mTodayZeroTimeMillis=" + this.aca);
      }
    }
    for (;;)
    {
      return this.dhd;
      if (this.aca == 0L) {
        this.aca = aqmj.w(this.mApp.getApplication(), this.mApp.getAccount());
      }
      if (localLong.longValue() - this.aca > 86400000L)
      {
        this.aca = aqmu.Z(localLong.longValue());
        aqmj.A(this.mApp.getApplication(), this.mApp.getAccount(), this.aca);
        aqmj.aM(this.mApp.getApplication(), this.mApp.getAccount(), 0);
        this.dhd = 0;
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "Today First Query, mTodayHadShowCount=" + this.dhd + " mTodayZeroTimeMillis=" + this.aca);
        }
      }
      else
      {
        this.dhd = aqmj.bF(this.mApp.getApplication(), this.mApp.getAccount());
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "Query, mTodayHadShowCount=" + this.dhd + " mTodayZeroTimeMillis=" + this.aca);
        }
      }
    }
  }
  
  private void b(SessionInfo paramSessionInfo, int paramInt)
  {
    String str2 = "";
    String str1 = "";
    if (paramSessionInfo.cZ == 0) {
      str2 = a().ty();
    }
    for (str1 = a().tz();; str1 = a().tB())
    {
      do
      {
        ahwa localahwa = new ahwa(paramSessionInfo.aTl, this.mApp.getCurrentAccountUin(), str2, paramSessionInfo.cZ, -5023, 655383, 0L);
        if (paramSessionInfo.cZ == 0) {
          localahwa.time = (anaz.gQ() + 1L);
        }
        int i = str2.indexOf(str1);
        if (i >= 0)
        {
          paramSessionInfo = new Bundle();
          paramSessionInfo.putInt("key_action", 40);
          paramSessionInfo.putString("textColor", "");
          paramSessionInfo.putString("image_resource", null);
          paramSessionInfo.putString("key_action_DATA", paramInt + "");
          localahwa.addHightlightItem(i, str1.length() + i, paramSessionInfo);
        }
        paramSessionInfo = new MessageForUniteGrayTip();
        paramSessionInfo.initGrayTipMsg(this.mApp, localahwa);
        ahwb.a(this.mApp, paramSessionInfo);
        anot.a(null, "dc00898", "", "", "0X8009ACE", "0X8009ACE", paramInt, paramInt, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "add gray tip =" + str2 + " fromType=" + paramInt);
        }
        return;
      } while ((paramSessionInfo.cZ != 1) && (paramSessionInfo.cZ != 3000));
      str2 = a().tA();
    }
  }
  
  private boolean g(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.cZ == 0) {}
    for (String str = paramSessionInfo.aTl;; str = "") {
      for (;;)
      {
        if ((QLog.isColorLevel()) && (TextUtils.isEmpty(str))) {
          QLog.d("PushNotificationManager", 2, "sessionInfo.curType=" + paramSessionInfo.cZ + " uin==null sessionInfo.realTroopUin=" + paramSessionInfo.aTm);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "uin=" + str + "mApp.getAccount()=" + this.mApp.getAccount());
        }
        try
        {
          List localList = this.mEntityManager.query(PushSwitchGrayTipsInfo.class, true, "uin=? and toUin=?", new String[] { this.mApp.getAccount(), str }, null, null, null, null);
          if ((localList == null) || (localList.size() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PushNotificationManager", 2, "result == null || result.size() == 0");
            }
            paramSessionInfo = new PushSwitchGrayTipsInfo(this.mApp.getCurrentUin(), str, paramSessionInfo.cZ, this.aca, 1);
            this.mEntityManager.persistOrReplace(paramSessionInfo);
            return true;
            if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000)) {
              str = paramSessionInfo.aTl;
            }
          }
          else
          {
            paramSessionInfo = (PushSwitchGrayTipsInfo)localList.get(0);
            if (QLog.isColorLevel()) {
              QLog.d("PushNotificationManager", 2, "pushSwitchGrayTipsInfo.lastShowTime=" + paramSessionInfo.lastShowTime + " mTodayZeroTimeMillis=" + this.aca);
            }
            if (paramSessionInfo.lastShowTime >= this.aca) {
              return false;
            }
            paramSessionInfo.lastShowTime = this.aca;
            paramSessionInfo.showCount += 1;
            this.mEntityManager.update(paramSessionInfo);
            return true;
          }
        }
        finally {}
      }
    }
  }
  
  public aemm a()
  {
    if (this.a == null)
    {
      this.a = new aemm();
      this.a.setEnable(false);
      if (QLog.isColorLevel()) {
        QLog.d("PushNotificationManager", 2, "pushNotificationBean=null, general new bean");
      }
    }
    return this.a;
  }
  
  public void a(SessionInfo paramSessionInfo, int paramInt)
  {
    if (QQToast.MK() == 0) {
      if (a().isEnable())
      {
        if (Ge() < a().Cr()) {
          break label46;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "getmTodayHadShowCount > showCount");
        }
      }
    }
    label46:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!g(paramSessionInfo));
      this.dhd += 1;
      aqmj.aM(this.mApp.getApplication(), this.mApp.getAccount(), this.dhd);
      b(paramSessionInfo, paramInt);
      return;
    }
    QLog.d("PushNotificationManager", 2, "isNotificationEnabled=" + QQToast.MK());
  }
  
  public void b(aemm paramaemm)
  {
    this.a = paramaemm;
  }
  
  public void onDestroy()
  {
    this.dhd = -1;
    this.aca = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aize
 * JD-Core Version:    0.7.0.1
 */