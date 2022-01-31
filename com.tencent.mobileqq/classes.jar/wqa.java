import android.content.Intent;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class wqa
  implements Runnable
{
  wqa(wpz paramwpz, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Wpz.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(32, 16, Integer.valueOf(this.jdField_a_of_type_Int));
    Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
    this.jdField_a_of_type_Wpz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqa
 * JD-Core Version:    0.7.0.1
 */