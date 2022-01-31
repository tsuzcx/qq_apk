import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class etr
  implements Runnable
{
  public etr(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, 0L, 0L, new HashMap(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     etr
 * JD-Core Version:    0.7.0.1
 */