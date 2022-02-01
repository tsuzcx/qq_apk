import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ugp
{
  private static int jdField_a_of_type_Int;
  private static final String jdField_a_of_type_JavaLangString = ugp.class.getSimpleName();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String b;
  
  public ugp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = pkh.a();
    jdField_a_of_type_Int = 0;
  }
  
  private int c()
  {
    int i = 0;
    boolean bool = bmhv.G(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (!bool) {
      bmhv.a(this.b + "VideoFeedsGameAdComBarConfigure_DALIY", Integer.valueOf(0));
    }
    if (bool) {
      i = ((Integer)bmhv.a(this.b + "VideoFeedsGameAdComBarConfigure_DALIY", Integer.valueOf(0))).intValue();
    }
    return i;
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public void a()
  {
    try
    {
      int i = c();
      jdField_a_of_type_Int += 1;
      bmhv.a(this.b + "VideoFeedsGameAdComBarConfigure_DALIY", Integer.valueOf(i + 1));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "解析引流条出现的条件出错: " + localException.getMessage());
    }
  }
  
  public int b()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugp
 * JD-Core Version:    0.7.0.1
 */