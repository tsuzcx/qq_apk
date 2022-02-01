import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class acye
  implements acyf
{
  acyd a;
  acyc b;
  QQAppInterface mApp;
  
  acye(QQAppInterface paramQQAppInterface, acyd paramacyd)
  {
    this.mApp = paramQQAppInterface;
    this.a = paramacyd;
    this.b = this.a.a;
  }
  
  public static boolean ak(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("fts_troop_upgrade_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static void w(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("fts_troop_upgrade_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public boolean acV()
  {
    return !ak(this.mApp);
  }
  
  public boolean acW()
  {
    this.mApp.a().createEntityManager().drop(FTSTroopSync.class.getSimpleName());
    Object localObject = ((TroopManager)this.mApp.getManager(52)).cE();
    ArrayList localArrayList = new ArrayList(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject).next();
      try
      {
        localArrayList.add(new FTSTroopSync(5, Long.parseLong(localTroopInfo.troopuin)));
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("FTSTroopUpgrader", 2, "startUpgrade exception : " + localException.toString());
      }
    }
    if (this.a.H(localArrayList))
    {
      w(this.mApp, true);
      return true;
    }
    return false;
  }
  
  public void destroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acye
 * JD-Core Version:    0.7.0.1
 */