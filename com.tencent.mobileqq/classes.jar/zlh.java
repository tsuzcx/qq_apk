import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;

public class zlh
  extends FriendListObserver
{
  public zlh(QQAppInterface paramQQAppInterface) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface_friendListObserver", 2, "onUpdateFriendInfo uin:" + paramString + ",isSuccess:" + paramBoolean);
    }
    if (this.a.jdField_a_of_type_JavaUtilSet.contains(paramString))
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.a() == 1) && (paramString != null) && (paramString.equals(((QQMessageFacade.Message)this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.a().get(0)).frienduin)) && (this.a.isBackground_Pause) && (this.a.f()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface_friendListObserver", 2, "update notifcation");
        }
        QQAppInterface.a(this.a, (QQMessageFacade.Message)this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.a().get(0), false);
      }
      this.a.jdField_a_of_type_JavaUtilSet.remove(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface_friendListObserver", 2, "removeObserver");
    }
    this.a.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zlh
 * JD-Core Version:    0.7.0.1
 */