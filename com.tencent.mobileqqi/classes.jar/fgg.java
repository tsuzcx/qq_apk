import com.tencent.mobileqq.app.SaveTrafficHandler;

public class fgg
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  public boolean b = false;
  
  public fgg(SaveTrafficHandler paramSaveTrafficHandler, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = false;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSaveTrafficHandler.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fgg
 * JD-Core Version:    0.7.0.1
 */