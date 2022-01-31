public class wrs
{
  private volatile int jdField_a_of_type_Int = 0;
  private wsc jdField_a_of_type_Wsc;
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Wsc != null) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_Wsc.n();
      return;
    case 1: 
      this.jdField_a_of_type_Wsc.l();
      return;
    case 2: 
      this.jdField_a_of_type_Wsc.k();
      return;
    }
    this.jdField_a_of_type_Wsc.m();
  }
  
  public void a(wsc paramwsc)
  {
    this.jdField_a_of_type_Wsc = paramwsc;
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
 * Qualified Name:     wrs
 * JD-Core Version:    0.7.0.1
 */