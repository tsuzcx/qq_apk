public class wej
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public wej(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public wej(String paramString, boolean paramBoolean, int paramInt)
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
    wem localwem = new wem();
    localwem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localwem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Int != -1) {
      localwem.c = this.jdField_a_of_type_Int;
    }
    ung.a().a(localwem, new wek(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wej
 * JD-Core Version:    0.7.0.1
 */