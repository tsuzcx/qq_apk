import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.NumRedPointManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.app.MobileQQ;

public class tht
  implements Runnable
{
  public tht(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    Object localObject = (RedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    this.a.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((RedTouchManager)localObject).a(String.valueOf(100190));
    int i = ((NumRedPointManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(100007, 100);
    SharedPreferences localSharedPreferences;
    if (i > 0)
    {
      this.a.b = ((RedTouchManager)localObject).a(1, 100007, "100007", i, false);
      this.a.c = ((RedTouchManager)localObject).a(String.valueOf(100005));
      localSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if ((this.a.c == null) || (this.a.c.iNewFlag.get() != 1)) {
        break label359;
      }
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", true).commit();
    }
    for (;;)
    {
      this.a.d = ((RedTouchManager)localObject).a(String.valueOf(100400));
      this.a.e = ((RedTouchManager)localObject).a(String.valueOf(100160));
      this.a.f = ((RedTouchManager)localObject).a(String.valueOf(100450));
      this.a.g = ((RedTouchManager)localObject).a(String.valueOf(100180));
      this.a.h = ((RedTouchManager)localObject).a(String.valueOf(103000));
      this.a.j = ((RedTouchManager)localObject).a(String.valueOf(100460));
      this.a.k = ((RedTouchManager)localObject).a(String.valueOf("200010.200012"));
      this.a.l = ((RedTouchManager)localObject).a(String.valueOf(100500));
      QQSettingMe.b(this.a);
      QQSettingMe.b(this.a);
      this.a.O();
      localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
      this.a.b = ((RedTouchManager)localObject).a(String.valueOf(100007));
      break;
      label359:
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tht
 * JD-Core Version:    0.7.0.1
 */