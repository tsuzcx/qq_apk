import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

public class ths
  implements Runnable
{
  public ths(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    Object localObject = (RedTouchManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    this.a.j = ((RedTouchManager)localObject).a(String.valueOf(100460));
    if ((this.a.j != null) && (this.a.j.iNewFlag.has()) && (this.a.j.iNewFlag.get() == 1)) {}
    boolean bool = QQSettingMe.b(this.a);
    if (QQSettingMe.c(this.a) != bool)
    {
      localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ths
 * JD-Core Version:    0.7.0.1
 */