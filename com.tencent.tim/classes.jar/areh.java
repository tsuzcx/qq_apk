import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class areh
  implements Handler.Callback
{
  public static boolean czx;
  public static int eeJ = 42080;
  QQAppInterface app;
  public boolean cZl;
  public volatile boolean cZm;
  int eeK = 0;
  auru i;
  
  public areh(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      this.app = paramQQAppInterface;
      this.i = new auru(ThreadManager.getSubThreadLooper(), this);
      this.cZl = paramQQAppInterface.getPreferences().getBoolean(paramQQAppInterface.getCurrentAccountUin() + "whole_people_vote_switch", false);
      if (QLog.isColorLevel()) {
        QLog.i("WholePeopleLebaEntryChecker", 2, "WholePeopleLebaEntryChecker init switch:" + this.cZl);
      }
    } while (!czx);
    this.cZl = true;
  }
  
  public static boolean ct(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    Object localObject = paramQQAppInterface.ed();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow, list is null, return false");
      }
      return false;
    }
    int j = 0;
    if (j < ((List)localObject).size())
    {
      LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)((List)localObject).get(j);
      if ((localLebaPluginInfo == null) || (localLebaPluginInfo.uiResId != 770L)) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow, is=770, find=" + bool1);
      }
      if (!bool1) {
        break;
      }
      localObject = paramQQAppInterface.a().a;
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow, campusLebaEntryChecker is null");
        }
      }
      while (((areh)localObject).cZm)
      {
        paramQQAppInterface = ((altq)paramQQAppInterface.getManager(36)).fV().iterator();
        do
        {
          bool1 = bool2;
          if (!paramQQAppInterface.hasNext()) {
            break;
          }
          localObject = (BusinessInfoCheckUpdate.AppSetting)paramQQAppInterface.next();
        } while (((BusinessInfoCheckUpdate.AppSetting)localObject).appid.get() != 770);
        bool2 = ((BusinessInfoCheckUpdate.AppSetting)localObject).setting.get();
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow find appid 770");
          bool1 = bool2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow return " + bool1);
        }
        return bool1;
        j += 1;
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow, switch is off, return false");
      return false;
    }
  }
  
  public void TA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeopleLebaEntryChecker", 2, "setEntryIsOn " + paramBoolean);
    }
    if (this.cZm != paramBoolean)
    {
      this.cZm = paramBoolean;
      acks.cw((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
    }
  }
  
  public void aCG()
  {
    if (this.i.hasMessages(0)) {
      this.i.removeMessages(0);
    }
    this.eeK += 1;
    this.i.sendEmptyMessageDelayed(0, 2000L);
  }
  
  public void ao(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      this.cZl = paramBoolean;
      if (czx) {
        this.cZl = true;
      }
      paramQQAppInterface.getPreferences().edit().putBoolean(paramQQAppInterface.getCurrentAccountUin() + "whole_people_vote_switch", paramBoolean).apply();
    } while (!QLog.isColorLevel());
    QLog.i("WholePeopleLebaEntryChecker", 2, String.format(Locale.getDefault(), "update show: %b", new Object[] { Boolean.valueOf(this.cZl) }));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    anot.b(this.app, "dc00898", "", "", "0X8008824", "0X8008824", 0, this.eeK, 0, "", "", "", "");
    this.eeK = 0;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     areh
 * JD-Core Version:    0.7.0.1
 */