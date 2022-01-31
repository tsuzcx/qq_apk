import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class czf
  extends CardObserver
{
  public czf(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramString)) {
      return;
    }
    if (!paramBoolean1) {
      this.a.a(2131562080, 1);
    }
    if (paramBoolean2)
    {
      PermisionPrivacyActivity.a(this.a, this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean3);
      return;
    }
    PermisionPrivacyActivity.a(this.a, PermisionPrivacyActivity.a(this.a), paramBoolean3);
  }
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramString)) {
      return;
    }
    PermisionPrivacyActivity.a(this.a, this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean2);
    PermisionPrivacyActivity.a(this.a, PermisionPrivacyActivity.a(this.a), paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czf
 * JD-Core Version:    0.7.0.1
 */