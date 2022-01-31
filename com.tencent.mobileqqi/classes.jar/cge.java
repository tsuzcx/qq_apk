import android.content.Intent;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.qphone.base.util.QLog;

public class cge
  extends CardObserver
{
  public cge(DetailProfileActivity paramDetailProfileActivity) {}
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    if (!paramBoolean)
    {
      this.a.a(2131561424, 1);
      if (paramCard != null)
      {
        this.a.jdField_b_of_type_JavaLangString = paramCard.strNick;
        this.a.jdField_a_of_type_Int = ((int)paramCard.lBirthday);
        this.a.jdField_a_of_type_Byte = ((byte)paramCard.shGender);
        this.a.b(this.a.jdField_b_of_type_JavaLangString);
        this.a.a(this.a.jdField_a_of_type_Byte);
        this.a.a(this.a.jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.Detail", 2, "onSetUserInfo isSuccess = " + paramBoolean + ", id = " + paramCard.getId() + ", nick = " + paramCard.strNick + ", gender = " + paramCard.shGender + ", birthday = " + paramCard.lBirthday + ", sig = " + paramCard.strSign + ", label = " + ProfileUtil.a(paramCard.getTagInfoArray()));
        }
      }
      return;
    }
    paramCard = new Intent();
    paramCard.putExtra("changed", true);
    this.a.setResult(-1, paramCard);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramObject.uin)))
      {
        this.a.jdField_b_of_type_JavaLangString = paramObject.strNick;
        this.a.jdField_a_of_type_Int = ((int)paramObject.lBirthday);
        this.a.jdField_a_of_type_Byte = ((byte)paramObject.shGender);
        this.a.jdField_a_of_type_JavaLangString = paramObject.strSign;
        this.a.b(this.a.jdField_b_of_type_JavaLangString);
        this.a.a(this.a.jdField_a_of_type_Byte);
        this.a.a(this.a.jdField_a_of_type_Int);
        this.a.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.Detail", 2, "onCardDownload isSuccess = " + paramBoolean + ", id = " + paramObject.getId() + ", nick = " + paramObject.strNick + ", gender = " + paramObject.shGender + ", birthday = " + paramObject.lBirthday + ", sig = " + paramObject.strSign + ", label = " + ProfileUtil.a(paramObject.getTagInfoArray()));
        }
      }
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramCard.uin)))
    {
      this.a.jdField_a_of_type_JavaLangString = paramCard.strSign;
      this.a.jdField_b_of_type_JavaLangString = paramCard.strNick;
      this.a.jdField_a_of_type_Int = ((int)paramCard.lBirthday);
      this.a.jdField_a_of_type_Byte = ((byte)paramCard.shGender);
      this.a.b(this.a.jdField_b_of_type_JavaLangString);
      this.a.a(this.a.jdField_a_of_type_Byte);
      this.a.a(this.a.jdField_a_of_type_Int);
      this.a.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Detail", 2, "onGotFullInfo isSuccess = " + paramBoolean + ", id = " + paramCard.getId() + ", nick = " + paramCard.strNick + ", gender = " + paramCard.shGender + ", birthday = " + paramCard.lBirthday + ", sig = " + paramCard.strSign + ", label = " + ProfileUtil.a(paramCard.getTagInfoArray()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cge
 * JD-Core Version:    0.7.0.1
 */