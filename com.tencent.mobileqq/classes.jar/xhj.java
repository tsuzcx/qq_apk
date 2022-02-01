public class xhj
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public xhj(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public xhj(String paramString, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 0));
  }
  
  public void a(boolean paramBoolean)
  {
    xhm localxhm = new xhm();
    localxhm.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localxhm.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Int != -1) {
      localxhm.c = this.jdField_a_of_type_Int;
    }
    vqn.a().a(localxhm, new xhk(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhj
 * JD-Core Version:    0.7.0.1
 */