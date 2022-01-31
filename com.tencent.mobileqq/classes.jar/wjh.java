public class wjh
{
  private static int jdField_b_of_type_Int;
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private static wjh jdField_b_of_type_Wjh;
  public int a;
  public Object a;
  private wjh a;
  
  public wjh(int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public static wjh a(int paramInt, Object paramObject)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Wjh != null)
      {
        wjh localwjh = jdField_b_of_type_Wjh;
        jdField_b_of_type_Wjh = localwjh.jdField_a_of_type_Wjh;
        localwjh.jdField_a_of_type_Wjh = null;
        jdField_b_of_type_Int -= 1;
        localwjh.jdField_a_of_type_Int = paramInt;
        localwjh.jdField_a_of_type_JavaLangObject = paramObject;
        return localwjh;
      }
      return new wjh(paramInt, paramObject);
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
        this.jdField_a_of_type_Wjh = jdField_b_of_type_Wjh;
        jdField_b_of_type_Wjh = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjh
 * JD-Core Version:    0.7.0.1
 */