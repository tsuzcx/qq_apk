import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class tvy
  extends FriendListObserver
{
  public tvy(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  void a(String paramString)
  {
    if (!paramString.equals(this.a.app.getAccount())) {
      return;
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1).sendToTarget();
    this.a.runOnUiThread(new tvz(this));
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    label129:
    do
    {
      return;
      int i;
      if (("batch_setting".equals(this.a.b)) && (this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 0) && (this.a.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController != null))
      {
        i = 0;
        for (;;)
        {
          if (i >= this.a.jdField_a_of_type_JavaUtilList.size()) {
            break label129;
          }
          paramMap = String.valueOf(this.a.jdField_a_of_type_JavaUtilList.get(i));
          if (((Boolean)this.a.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.get(paramMap)).booleanValue()) {
            break;
          }
          i += 1;
        }
        QQToast.a(this.a.app.getApp(), 2, "设置成功", 0).b(this.a.getTitleBarHeight());
        TroopAssistantActivity.a(this.a);
        return;
      }
      paramMap = paramMap.entrySet().iterator();
      if (paramMap.hasNext())
      {
        String str = (String)((Map.Entry)paramMap.next()).getKey();
        i = this.a.app.b(str);
        if ((i == 1) || (i == 4)) {
          TroopAssistantManager.a().c(str, this.a.app);
        }
        for (;;)
        {
          this.a.c();
          break;
          if (i == 3) {
            TroopAssistantManager.a().b(str, this.a.app);
          }
        }
      }
    } while (!this.a.isResume());
    if (paramBoolean)
    {
      QQToast.a(this.a.app.getApp(), 2, this.a.getString(2131434513), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.app.getApp(), 1, this.a.getString(2131434514), 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("head", 2, "ContactsActivity.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if ((this.a.app.getCurrentAccountUin() != null) && (this.a.app.getCurrentAccountUin().equals(paramString)))
    {
      ThreadManager.post(new twa(this, paramString), 8, null, true);
      return;
    }
    this.a.c();
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (paramBoolean) {
      ThreadManager.post(new twb(this), 5, null, true);
    }
  }
  
  protected void onUpdateRecentList()
  {
    this.a.c();
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvy
 * JD-Core Version:    0.7.0.1
 */