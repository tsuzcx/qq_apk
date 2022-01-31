public class vqa
  extends vpm
{
  public int a;
  public uyg a;
  public boolean a;
  public String c = "";
  public String d = "";
  
  public vqa(String paramString)
  {
    super(paramString);
  }
  
  static vqa a(uyg paramuyg)
  {
    vqa localvqa = new vqa(paramuyg.jdField_a_of_type_JavaLangString);
    localvqa.jdField_a_of_type_Uyg = paramuyg;
    if (paramuyg.jdField_a_of_type_Int == 12)
    {
      localvqa.d = paramuyg.e;
      localvqa.c = paramuyg.i;
    }
    return localvqa;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Uyg != null) {
      return this.jdField_a_of_type_Uyg.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Uyg != null) && (this.jdField_a_of_type_Uyg.jdField_a_of_type_Int == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqa
 * JD-Core Version:    0.7.0.1
 */