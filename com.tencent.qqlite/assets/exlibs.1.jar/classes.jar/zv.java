import android.view.Window;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class zv
  implements Runnable
{
  public zv(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.a.c(true);
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
    this.a.i(0);
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131363139, 1).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     zv
 * JD-Core Version:    0.7.0.1
 */