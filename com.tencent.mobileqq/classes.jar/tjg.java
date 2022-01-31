public abstract class tjg
{
  protected int a;
  protected tje a;
  
  public abstract void a();
  
  public void a(tje paramtje)
  {
    this.jdField_a_of_type_Tje = paramtje;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < 1)
    {
      this.jdField_a_of_type_Int += 1;
      veg.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Tje != null) {
      this.jdField_a_of_type_Tje.a(this);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Tje != null) {
      this.jdField_a_of_type_Tje.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjg
 * JD-Core Version:    0.7.0.1
 */