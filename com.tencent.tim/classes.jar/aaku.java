import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.manager.Manager;

public class aaku
  implements Manager
{
  public static aaku a;
  private Set<String> bC = new HashSet();
  private boolean bwf;
  
  public aaku()
  {
    cvg();
  }
  
  public static aaku a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aaku();
      }
      return a;
    }
    finally {}
  }
  
  private void cvg()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      this.bwf = aqmj.aH(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin());
      this.bC = localQQAppInterface.getApp().getSharedPreferences("RecentPubAccManager" + localQQAppInterface.getCurrentAccountUin(), 0).getStringSet("white_list_key", null);
    } while (!QLog.isColorLevel());
    QLog.d("RecentPubAccManager", 2, "loadFromSp   mBlackUinList:" + this.bC + ",  Switch: " + this.bwf);
  }
  
  public boolean WB()
  {
    return this.bwf;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Set<String> paramSet)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentPubAccManager", 2, "setUnFollowPubAccWhiteList: " + paramSet);
        }
        this.bC = paramSet;
        paramQQAppInterface.getApp().getSharedPreferences("RecentPubAccManager" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putStringSet("white_list_key", paramSet).apply();
      }
      finally {}
    }
  }
  
  public boolean ew(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.bC != null)
    {
      bool1 = bool2;
      if (this.bC.contains(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onDestroy() {}
  
  public void s(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccManager", 2, "setUnFollowPubAccSwitch: " + paramBoolean);
    }
    this.bwf = paramBoolean;
    aqmj.t(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaku
 * JD-Core Version:    0.7.0.1
 */