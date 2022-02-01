import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;

public class ffm
  extends FriendListObserver
{
  public ffm(QQAppInterface paramQQAppInterface) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQAppInterface.b + "_friendListObserver", 2, "onUpdateFriendInfo uin:" + paramString + ",isSuccess:" + paramBoolean);
    }
    if (this.a.jdField_a_of_type_JavaUtilSet.contains(paramString))
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c() == 1) && (paramString != null) && (paramString.equals(((QQMessageFacade.Message)this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().get(0)).frienduin)) && (this.a.isBackground_Pause) && (this.a.f()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(QQAppInterface.b + "_friendListObserver", 2, "update notifcation");
        }
        this.a.a((QQMessageFacade.Message)this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().get(0), false);
      }
      this.a.jdField_a_of_type_JavaUtilSet.remove(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d(QQAppInterface.b + "_friendListObserver", 2, "removeObserver");
    }
    this.a.c(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffm
 * JD-Core Version:    0.7.0.1
 */