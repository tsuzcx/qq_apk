import com.tencent.mobileqq.activity.contacts.base.CardController;
import com.tencent.mobileqq.activity.contacts.utils.CardUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessObserver;
import com.tencent.qphone.base.util.QLog;

public class wrx
  extends ConfessObserver
{
  public wrx(CardController paramCardController) {}
  
  private void c()
  {
    int j = 1;
    int i = 0;
    if (this.a.jdField_a_of_type_Int == 1) {
      if (!ConfessConfig.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_contact_show")) {
        break label68;
      }
    }
    label68:
    for (i = j;; i = 0)
    {
      i = 0 + i;
      CardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
      RedpointHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.C();
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardController", 2, "onConfessConfigChanged");
    }
    c();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardController", 2, String.format("onContactCardShowChanged curType=%d oldType=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    this.a.jdField_a_of_type_Int = paramInt1;
    c();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardController", 2, "onConfessRedPointChanged");
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wrx
 * JD-Core Version:    0.7.0.1
 */