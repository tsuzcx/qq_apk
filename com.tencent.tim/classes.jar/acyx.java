import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_BASE.sweet_rsp_comm;
import SWEET_NEW_ICON.lighting_sweet_key_rsp;
import SWEET_NEW_ICON.sweet_upgrade_key_notify_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class acyx
  implements BusinessObserver
{
  private static volatile acyx a;
  private static Object cK = new Object();
  private volatile boolean bKr;
  private volatile boolean bKs;
  
  private void G(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (sweet_upgrade_key_notify_rsp)paramBundle.getSerializable("rsp_data");
    if ((paramBundle == null) || (!paramBoolean) || (paramBundle.req_comm == null))
    {
      QLog.i("QzoneLoverService", 1, "onGetLoverCheckData succed(false)");
      cPe();
    }
    Object localObject;
    long l;
    do
    {
      do
      {
        return;
        if ((paramBundle.rsp_comm == null) || (paramBundle.rsp_comm.retcode != 0))
        {
          localObject = new StringBuilder().append("onGetLoverCheckData succed(false), ret code: ");
          if (paramBundle.rsp_comm == null) {}
          for (paramBundle = "null";; paramBundle = String.valueOf(paramBundle.rsp_comm.retcode))
          {
            QLog.i("QzoneLoverService", 1, paramBundle);
            cPe();
            return;
          }
        }
        if (paramBundle.req_comm.uin != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())
        {
          QLog.i("QzoneLoverService", 1, "onGetLoverCheckData succed(" + paramBoolean + "), uin: " + paramBundle.req_comm.uin + ", loginUin: " + BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
          return;
        }
        cPd();
        l = paramBundle.req_comm.loveuin;
      } while (l <= 10000L);
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    ((FriendListHandler)((QQAppInterface)localObject).getBusinessHandler(1)).DF(String.valueOf(l));
    QLog.i("QzoneLoverService", 1, "onGetLoverCheckData succed(" + paramBoolean + "), uin:" + paramBundle.req_comm.uin);
  }
  
  private void H(boolean paramBoolean, Bundle paramBundle)
  {
    this.bKs = false;
    paramBundle = (lighting_sweet_key_rsp)paramBundle.getSerializable("rsp_data");
    if ((paramBundle == null) || (!paramBoolean))
    {
      QLog.i("QzoneLoverService", 1, "onGetLoverLightingData succed(false)");
      cPh();
      return;
    }
    if ((paramBundle.rsp_comm == null) || (paramBundle.rsp_comm.retcode != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetLoverLightingData succed(false), ret code: ");
      if (paramBundle.rsp_comm == null) {}
      for (paramBundle = "null";; paramBundle = String.valueOf(paramBundle.rsp_comm.retcode))
      {
        QLog.i("QzoneLoverService", 1, paramBundle);
        cPh();
        return;
      }
    }
    cPg();
    QLog.i("QzoneLoverService", 1, "onGetLoverLightingData succed(" + paramBoolean + ")");
  }
  
  public static acyx a()
  {
    if (a == null) {}
    synchronized (cK)
    {
      if (a == null) {
        a = new acyx();
      }
      return a;
    }
  }
  
  private boolean ade()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    if (System.currentTimeMillis() / 1000L / 3600L / 24L != localSharedPreferences.getLong("lightingQzoneLoverLastFailTime", 0L)) {}
    while (localSharedPreferences.getInt("lightingQzoneLoverFailCount", 0) < QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLoverMaxFailCount", 10)) {
      return false;
    }
    return true;
  }
  
  private void cPd()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0).edit().putBoolean("checkQzoneLoverSend2", true).apply();
  }
  
  private void cPe()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    long l = System.currentTimeMillis() / 1000L / 3600L / 24L;
    if (l != localSharedPreferences.getLong("checkQzoneLoverLastFailTime", 0L)) {
      localSharedPreferences.edit().putInt("checkQzoneLoverFailCount", 1);
    }
    for (;;)
    {
      localSharedPreferences.edit().putLong("checkQzoneLoverLastFailTime", l);
      localSharedPreferences.edit().apply();
      return;
      int i = localSharedPreferences.getInt("checkQzoneLoverFailCount", 0);
      localSharedPreferences.edit().putInt("checkQzoneLoverFailCount", i + 1);
    }
  }
  
  private void cPg()
  {
    long l = System.currentTimeMillis() / 1000L / 3600L / 24L;
    BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0).edit().putLong("lightingQzoneLoverTime", l).apply();
  }
  
  private void cPh()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    long l = System.currentTimeMillis() / 1000L / 3600L / 24L;
    if (l != localSharedPreferences.getLong("lightingQzoneLoverLastFailTime", 0L)) {
      localSharedPreferences.edit().putInt("lightingQzoneLoverFailCount", 1);
    }
    for (;;)
    {
      localSharedPreferences.edit().putLong("lightingQzoneLoverLastFailTime", l);
      localSharedPreferences.edit().apply();
      return;
      int i = localSharedPreferences.getInt("lightingQzoneLoverFailCount", 0);
      localSharedPreferences.edit().putInt("lightingQzoneLoverFailCount", i + 1);
    }
  }
  
  public boolean add()
  {
    boolean bool = false;
    long l1 = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0).getLong("lightingQzoneLoverTime", 0L);
    long l2 = System.currentTimeMillis() / 1000L / 3600L / 24L;
    if (QLog.isColorLevel()) {
      QLog.i("QzoneLoverService", 2, "startQzoneLoverLightingRequest curDay(" + l2 + "), lastDay(" + l1 + ")");
    }
    if (l2 != l1) {
      bool = true;
    }
    return bool;
  }
  
  public void cPf()
  {
    if (this.bKs) {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest sending...");
      }
    }
    do
    {
      do
      {
        return;
        if (add()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest false");
      return;
      if (!ade()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest fail count hit max count!!!");
    return;
    this.bKs = true;
    QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest true");
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext(), acyw.class);
    acyw.a(localNewIntent, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    if (!this.bKr)
    {
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
      this.bKr = true;
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1) {
      G(paramBoolean, paramBundle);
    }
    while (paramInt != 291) {
      return;
    }
    H(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyx
 * JD-Core Version:    0.7.0.1
 */