import android.view.View;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class thx
  implements Runnable
{
  public thx(QQSettingMe paramQQSettingMe, String paramString) {}
  
  public void run()
  {
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, (byte)3);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFaceDrawable, 1, this.jdField_a_of_type_JavaLangString, 100, true, true, 6);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.b.setVisibility(VasFaceManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.A();
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "updateFace, " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     thx
 * JD-Core Version:    0.7.0.1
 */