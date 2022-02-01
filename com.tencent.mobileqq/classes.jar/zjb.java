public class zjb
{
  private volatile int jdField_a_of_type_Int = 0;
  private zjl jdField_a_of_type_Zjl;
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Zjl != null) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_Zjl.p();
      return;
    case 1: 
      this.jdField_a_of_type_Zjl.n();
      return;
    case 2: 
      this.jdField_a_of_type_Zjl.m();
      return;
    }
    this.jdField_a_of_type_Zjl.o();
  }
  
  public void a(zjl paramzjl)
  {
    this.jdField_a_of_type_Zjl = paramzjl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjb
 * JD-Core Version:    0.7.0.1
 */