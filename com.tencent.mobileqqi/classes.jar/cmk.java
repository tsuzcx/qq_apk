import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;

public class cmk
  extends Thread
{
  public cmk(DetailProfileActivity paramDetailProfileActivity, String paramString) {}
  
  public void run()
  {
    Card localCard = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    if (localCard != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_JavaLangString = localCard.strSign;
      this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_b_of_type_JavaLangString = localCard.strNick;
      this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Int = ((int)localCard.lBirthday);
      this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Byte = ((byte)localCard.shGender);
      this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.runOnUiThread(new cml(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Detail", 2, "需要去拉取出生日期信息");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(localCard.uin, null);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(150);
      localStringBuilder.append("initCard| uin = ").append(this.jdField_a_of_type_JavaLangString);
      if (localCard != null) {
        localStringBuilder.append(", id = ").append(localCard.getId()).append(", nick = ").append(localCard.strNick).append(", gender = ").append(localCard.shGender).append(", birthday = ").append(localCard.lBirthday).append(", sig = ").append(localCard.strSign).append(", label = ").append(ProfileUtil.a(localCard.getTagInfoArray()));
      }
      QLog.d("Q.profilecard.Detail", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cmk
 * JD-Core Version:    0.7.0.1
 */