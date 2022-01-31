public class ygf
{
  private volatile int jdField_a_of_type_Int = 0;
  private ygp jdField_a_of_type_Ygp;
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Ygp != null) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_Ygp.n();
      return;
    case 1: 
      this.jdField_a_of_type_Ygp.l();
      return;
    case 2: 
      this.jdField_a_of_type_Ygp.k();
      return;
    }
    this.jdField_a_of_type_Ygp.m();
  }
  
  public void a(ygp paramygp)
  {
    this.jdField_a_of_type_Ygp = paramygp;
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
 * Qualified Name:     ygf
 * JD-Core Version:    0.7.0.1
 */