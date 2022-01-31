import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;

public class wvk
{
  private static volatile wvk jdField_a_of_type_Wvk;
  private final int jdField_a_of_type_Int = 2000;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 60000;
  private long jdField_b_of_type_Long;
  private final int c = 1000;
  private int d;
  
  public static wvk a()
  {
    if (jdField_a_of_type_Wvk == null) {}
    try
    {
      if (jdField_a_of_type_Wvk == null) {
        jdField_a_of_type_Wvk = new wvk();
      }
      return jdField_a_of_type_Wvk;
    }
    finally {}
  }
  
  private void b()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    if (localAppInterface != null)
    {
      avzm localavzm = (avzm)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new wvm(this, localAppInterface));
      localavzm.c();
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      LogicDataManager.getInstance().setOnGetQQNumberEventListener(new wvl(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wvk
 * JD-Core Version:    0.7.0.1
 */