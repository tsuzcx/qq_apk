import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

public class wqi
  implements Runnable
{
  public wqi(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).c();
      if (localRedTypeInfo != null) {
        localRedTypeInfo.red_type.set(0);
      }
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.obtainMessage(4);
      localMessage.obj = localRedTypeInfo;
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MainAssistObserver", 2, "WL_DEBUG updateTabCallNotify.run error : " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqi
 * JD-Core Version:    0.7.0.1
 */