import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.qphone.base.util.QLog;

public class app
  extends Handler
{
  public app(FriendProfileImageAvatar paramFriendProfileImageAvatar) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "refresh progress : " + paramMessage.arg1);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.i = paramMessage.arg1;
        this.a.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "start progress : " + paramMessage.arg1);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.i = 0;
        this.a.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "end result : " + paramMessage.arg1);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.i = 100;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.a = false;
        this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
        if (paramMessage.arg1 == 1)
        {
          this.a.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.h = 5;
        this.a.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
      } while (this.a.f >= 3);
      paramMessage = this.a;
      paramMessage.f += 1;
      this.a.jdField_a_of_type_JavaLangString = null;
      return;
    }
    this.a.a(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     app
 * JD-Core Version:    0.7.0.1
 */