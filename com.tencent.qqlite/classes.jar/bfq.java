import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qqfav.QfavHelper;

public class bfq
  implements View.OnClickListener
{
  public bfq(QQSettingMe paramQQSettingMe) {}
  
  public void onClick(View paramView)
  {
    QfavHelper.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1);
    if ((QQSettingMe.a(this.a) != null) && (QQSettingMe.a(this.a).isShowing()))
    {
      QQSettingMe.a(this.a).dismiss();
      QQSettingMe.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bfq
 * JD-Core Version:    0.7.0.1
 */