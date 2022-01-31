public class wmm
{
  private static int jdField_b_of_type_Int;
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private static wmm jdField_b_of_type_Wmm;
  public int a;
  public Object a;
  private wmm a;
  
  public wmm(int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public static wmm a(int paramInt, Object paramObject)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Wmm != null)
      {
        wmm localwmm = jdField_b_of_type_Wmm;
        jdField_b_of_type_Wmm = localwmm.jdField_a_of_type_Wmm;
        localwmm.jdField_a_of_type_Wmm = null;
        jdField_b_of_type_Int -= 1;
        localwmm.jdField_a_of_type_Int = paramInt;
        localwmm.jdField_a_of_type_JavaLangObject = paramObject;
        return localwmm;
      }
      return new wmm(paramInt, paramObject);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangObject = null;
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Int < 50)
      {
        this.jdField_a_of_type_Wmm = jdField_b_of_type_Wmm;
        jdField_b_of_type_Wmm = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmm
 * JD-Core Version:    0.7.0.1
 */