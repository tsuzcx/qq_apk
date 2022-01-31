public class wrw
{
  private static int jdField_b_of_type_Int;
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private static wrw jdField_b_of_type_Wrw;
  public int a;
  public Object a;
  private wrw a;
  
  public wrw(int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public static wrw a(int paramInt, Object paramObject)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Wrw != null)
      {
        wrw localwrw = jdField_b_of_type_Wrw;
        jdField_b_of_type_Wrw = localwrw.jdField_a_of_type_Wrw;
        localwrw.jdField_a_of_type_Wrw = null;
        jdField_b_of_type_Int -= 1;
        localwrw.jdField_a_of_type_Int = paramInt;
        localwrw.jdField_a_of_type_JavaLangObject = paramObject;
        return localwrw;
      }
      return new wrw(paramInt, paramObject);
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
        this.jdField_a_of_type_Wrw = jdField_b_of_type_Wrw;
        jdField_b_of_type_Wrw = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wrw
 * JD-Core Version:    0.7.0.1
 */