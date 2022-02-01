public class wor
  extends wod
{
  public int a;
  public vxd a;
  public boolean a;
  public String c = "";
  public String d = "";
  
  public wor(String paramString)
  {
    super(paramString);
  }
  
  static wor a(vxd paramvxd)
  {
    wor localwor = new wor(paramvxd.jdField_a_of_type_JavaLangString);
    localwor.jdField_a_of_type_Vxd = paramvxd;
    if (paramvxd.jdField_a_of_type_Int == 12)
    {
      localwor.d = paramvxd.e;
      localwor.c = paramvxd.i;
    }
    return localwor;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Vxd != null) {
      return this.jdField_a_of_type_Vxd.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Vxd != null) && (this.jdField_a_of_type_Vxd.jdField_a_of_type_Int == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wor
 * JD-Core Version:    0.7.0.1
 */