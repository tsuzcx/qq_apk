import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;

public class apr
  extends FriendListObserver
{
  public apr(FriendProfileImageAvatar paramFriendProfileImageAvatar) {}
  
  protected void a(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting == null) || (!this.a.b.equals(paramSetting.uin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Avatar", 2, "onGetHeadInfo: uin=" + paramSetting.uin);
      }
    } while ((!this.a.jdField_a_of_type_Boolean) || (paramSetting.url == null) || (paramSetting.url.length() <= 0));
    this.a.a(paramSetting.uin, paramSetting.bFaceFlags, paramSetting.url);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!this.a.b.equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Avatar", 2, "onUpdateCustomHead: uin=" + paramString);
    }
    this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo, false);
      this.a.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.h = 2;
    this.a.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     apr
 * JD-Core Version:    0.7.0.1
 */