import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;

class cyq
  extends BizTroopObserver
{
  cyq(cyo paramcyo) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (!paramString2.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      cyo.a(this.a);
      return;
    }
    if (!this.a.jdField_b_of_type_Boolean)
    {
      this.a.jdField_c_of_type_Boolean = true;
      this.a.jdField_a_of_type_JavaLangString = paramString1;
      this.a.jdField_b_of_type_JavaLangString = paramString2;
      this.a.d = paramBoolean;
      this.a.jdField_c_of_type_JavaLangString = paramString3;
      return;
    }
    cyo.a(this.a, paramString1, paramString2, paramBoolean, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cyq
 * JD-Core Version:    0.7.0.1
 */