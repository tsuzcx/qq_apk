public class ucy
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public ucy(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public ucy(String paramString, boolean paramBoolean, int paramInt)
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
    udb localudb = new udb();
    localudb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localudb.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Int != -1) {
      localudb.c = this.jdField_a_of_type_Int;
    }
    slv.a().a(localudb, new ucz(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucy
 * JD-Core Version:    0.7.0.1
 */