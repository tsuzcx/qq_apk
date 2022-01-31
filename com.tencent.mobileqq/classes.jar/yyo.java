import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class yyo
  implements Manager
{
  protected static BaseApplicationImpl a;
  public static boolean a;
  private AppInterface a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public yyo(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a();
  }
  
  public void a()
  {
    try
    {
      jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if (jdField_a_of_type_Boolean) {
        jdField_a_of_type_Boolean = false;
      }
      yyw.a();
      QLog.i("Q.videostory.VSManager", 1, "init");
      return;
    }
    finally {}
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyo
 * JD-Core Version:    0.7.0.1
 */