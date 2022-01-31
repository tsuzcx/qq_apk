import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ese
  implements Runnable
{
  public ese(RedDotImageView paramRedDotImageView, AppInterface paramAppInterface, String paramString) {}
  
  public void run()
  {
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    int i = SharedPreUtils.c(localMobileQQ);
    if (SharedPreUtils.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), i, this.jdField_a_of_type_JavaLangString))
    {
      SharedPreUtils.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), i, this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, this.jdField_a_of_type_JavaLangString + " close redDot");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ese
 * JD-Core Version:    0.7.0.1
 */