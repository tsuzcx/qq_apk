public class yks
{
  private volatile int jdField_a_of_type_Int = 0;
  private ylc jdField_a_of_type_Ylc;
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Ylc != null) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_Ylc.d();
      return;
    case 1: 
      this.jdField_a_of_type_Ylc.b();
      return;
    case 2: 
      this.jdField_a_of_type_Ylc.a();
      return;
    }
    this.jdField_a_of_type_Ylc.c();
  }
  
  public void a(ylc paramylc)
  {
    this.jdField_a_of_type_Ylc = paramylc;
    a(this.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yks
 * JD-Core Version:    0.7.0.1
 */