public class wrp
{
  private volatile int jdField_a_of_type_Int = 0;
  private wrz jdField_a_of_type_Wrz;
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Wrz != null) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_Wrz.n();
      return;
    case 1: 
      this.jdField_a_of_type_Wrz.l();
      return;
    case 2: 
      this.jdField_a_of_type_Wrz.k();
      return;
    }
    this.jdField_a_of_type_Wrz.m();
  }
  
  public void a(wrz paramwrz)
  {
    this.jdField_a_of_type_Wrz = paramwrz;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wrp
 * JD-Core Version:    0.7.0.1
 */