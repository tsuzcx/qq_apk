public class upu
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public upu(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public upu(String paramString, boolean paramBoolean, int paramInt)
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
    upx localupx = new upx();
    localupx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localupx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Int != -1) {
      localupx.c = this.jdField_a_of_type_Int;
    }
    syr.a().a(localupx, new upv(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upu
 * JD-Core Version:    0.7.0.1
 */