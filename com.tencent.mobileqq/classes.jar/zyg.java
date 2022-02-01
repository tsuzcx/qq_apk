public class zyg
{
  private volatile int jdField_a_of_type_Int = 0;
  private zyq jdField_a_of_type_Zyq;
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Zyq != null) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_Zyq.p();
      return;
    case 1: 
      this.jdField_a_of_type_Zyq.n();
      return;
    case 2: 
      this.jdField_a_of_type_Zyq.m();
      return;
    }
    this.jdField_a_of_type_Zyq.o();
  }
  
  public void a(zyq paramzyq)
  {
    this.jdField_a_of_type_Zyq = paramzyq;
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
 * Qualified Name:     zyg
 * JD-Core Version:    0.7.0.1
 */