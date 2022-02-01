import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.managers.TroopRemindSettingManager.1;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;

public class aizr
{
  private static aizr a;
  
  public static aizr a()
  {
    if (a == null) {
      a = new aizr();
    }
    return a;
  }
  
  public static void destroy()
  {
    if (a != null) {
      a = null;
    }
  }
  
  public boolean ba(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troop_remind", true);
  }
  
  public void d(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troop_remind", false).commit();
  }
  
  public boolean h(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = (TroopRemindSettingData)paramQQAppInterface.a().createEntityManager().find(TroopRemindSettingData.class, paramString);
    return (paramString != null) && (paramString.isOpenState == 0);
  }
  
  public void m(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    TroopRemindSettingData localTroopRemindSettingData = new TroopRemindSettingData();
    localTroopRemindSettingData.troopUin = paramString;
    localTroopRemindSettingData.isOpenState = 1;
    paramQQAppInterface.persistOrReplace(localTroopRemindSettingData);
  }
  
  public void n(String paramString, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new TroopRemindSettingManager.1(this, paramQQAppInterface, paramString), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizr
 * JD-Core Version:    0.7.0.1
 */