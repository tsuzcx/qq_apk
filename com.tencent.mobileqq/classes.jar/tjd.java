public abstract class tjd
{
  protected int a;
  protected tjb a;
  
  public abstract void a();
  
  public void a(tjb paramtjb)
  {
    this.jdField_a_of_type_Tjb = paramtjb;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < 1)
    {
      this.jdField_a_of_type_Int += 1;
      ved.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Tjb != null) {
      this.jdField_a_of_type_Tjb.a(this);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Tjb != null) {
      this.jdField_a_of_type_Tjb.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjd
 * JD-Core Version:    0.7.0.1
 */