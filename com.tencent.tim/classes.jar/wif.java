import Wallet.AcsMsg;
import android.app.AlarmManager;
import android.app.AlarmManager.AlarmClockInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderAlarmReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class wif
  implements Manager
{
  private AlarmManager jdField_a_of_type_AndroidAppAlarmManager;
  private ReminderAlarmReceiver jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver;
  private CopyOnWriteArraySet<String> f;
  private QQAppInterface mApp;
  private Context mContext;
  private SharedPreferences pref;
  
  public wif(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "ActivateFriends.Manager--onCreate---");
    }
    this.f = new CopyOnWriteArraySet();
    this.mApp = paramQQAppInterface;
    this.pref = this.mApp.getApp().getSharedPreferences("pref_act_frd" + this.mApp.getCurrentAccountUin(), 0);
    this.mContext = this.mApp.getApplication().getApplicationContext();
    this.jdField_a_of_type_AndroidAppAlarmManager = ((AlarmManager)this.mContext.getSystemService("alarm"));
    bYl();
  }
  
  private void bYl()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver = new ReminderAlarmReceiver(this.mApp);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("notification_alram_action");
    this.mContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver, localIntentFilter);
  }
  
  private void bYm()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver != null) {
      this.mContext.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver);
    }
  }
  
  public void Cb(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "cancelAlarmById alarmId: " + paramInt);
      }
      Object localObject = String.valueOf(paramInt);
      if (this.f.contains(localObject)) {
        this.f.remove(localObject);
      }
      this.pref.edit().putStringSet("sp_key_alarmids" + this.mApp.getCurrentAccountUin(), this.f).apply();
      localObject = new Intent();
      ((Intent)localObject).setAction("notification_alram_action");
      localObject = PendingIntent.getBroadcast(this.mContext, paramInt, (Intent)localObject, 0);
      this.jdField_a_of_type_AndroidAppAlarmManager.cancel((PendingIntent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ActivateFriends.Manager", 2, "cancelAlarmById throw an exceptio: " + localThrowable);
    }
  }
  
  public void bYn()
  {
    try
    {
      if (!this.pref.getStringSet("sp_key_alarmids" + this.mApp.getCurrentAccountUin(), new HashSet()).isEmpty())
      {
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          Cb(Integer.parseInt((String)localIterator.next()));
        }
      }
      if (this.f == null) {
        break label136;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ActivateFriends.Manager", 2, "clearAllAlarm throw an exception: " + localException);
      return;
    }
    if (!this.f.isEmpty()) {
      this.f.clear();
    }
    label136:
    this.pref.edit().remove("sp_key_alarmids" + this.mApp.getCurrentAccountUin()).apply();
  }
  
  public void d(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg == null) {}
    long l;
    label332:
    do
    {
      do
      {
        Object localObject1;
        do
        {
          for (;;)
          {
            return;
            try
            {
              l = paramAcsMsg.notice_time * 1000L;
              int i = paramAcsMsg.hashCode();
              localObject1 = paramAcsMsg.title;
              if (l <= NetConnInfoCenter.getServerTimeMillis()) {
                break label431;
              }
              Object localObject2 = String.valueOf(i);
              if (this.pref.getStringSet("sp_key_alarmids" + this.mApp.getCurrentAccountUin(), new CopyOnWriteArraySet()).contains(localObject2)) {
                break label392;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Manager", 2, "setAlarmTimer at " + whn.h(l, "yyyyMMdd HH:mm:ss") + " msg: " + (String)localObject1 + " alarmId: " + i);
              }
              if (!this.f.contains(localObject2))
              {
                this.f.add(localObject2);
                this.pref.edit().putStringSet("sp_key_alarmids" + this.mApp.getCurrentAccountUin(), this.f).apply();
              }
              localObject2 = new Intent();
              ((Intent)localObject2).setAction("notification_alram_action");
              ((Intent)localObject2).putExtra("msg", (String)localObject1);
              ((Intent)localObject2).putExtra("msg_id", paramAcsMsg.msg_id);
              paramAcsMsg = PendingIntent.getBroadcast(this.mContext, i, (Intent)localObject2, 0);
              if (this.jdField_a_of_type_AndroidAppAlarmManager != null)
              {
                if (Build.VERSION.SDK_INT < 23) {
                  break label332;
                }
                this.jdField_a_of_type_AndroidAppAlarmManager.setExactAndAllowWhileIdle(0, l, paramAcsMsg);
                return;
              }
            }
            catch (Throwable paramAcsMsg) {}
          }
        } while (!QLog.isColorLevel());
        QLog.e("ActivateFriends.Manager", 2, "setAlarmTimer throw an exceptio: " + paramAcsMsg);
        return;
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject1 = new AlarmManager.AlarmClockInfo(l, paramAcsMsg);
          this.jdField_a_of_type_AndroidAppAlarmManager.setAlarmClock((AlarmManager.AlarmClockInfo)localObject1, paramAcsMsg);
          return;
        }
        if (Build.VERSION.SDK_INT >= 19)
        {
          this.jdField_a_of_type_AndroidAppAlarmManager.setExact(0, l, paramAcsMsg);
          return;
        }
        this.jdField_a_of_type_AndroidAppAlarmManager.set(0, l, paramAcsMsg);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ActivateFriends.Manager", 2, "has already setAlarmTimer at " + whn.h(l, "yyyyMMdd HH:mm:ss"));
      return;
    } while (!QLog.isColorLevel());
    label392:
    label431:
    QLog.d("ActivateFriends.Manager", 2, "has already setAlarmTimer at " + whn.h(l, "yyyyMMdd HH:mm:ss"));
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "ActivateFriends.Manager--onDestroy---");
    }
    bYm();
    bYn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wif
 * JD-Core Version:    0.7.0.1
 */