import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.Utils;

public class ddt
  extends CardObserver
{
  public ddt(QQSettingMe paramQQSettingMe) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ((paramObject instanceof Card)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(((Card)paramObject).uin))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new ddu(this));
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      this.a.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ddt
 * JD-Core Version:    0.7.0.1
 */