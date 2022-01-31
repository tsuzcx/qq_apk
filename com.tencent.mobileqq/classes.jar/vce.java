public abstract class vce
{
  protected int a;
  protected vcc a;
  
  public abstract void a();
  
  public void a(vcc paramvcc)
  {
    this.jdField_a_of_type_Vcc = paramvcc;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < 1)
    {
      this.jdField_a_of_type_Int += 1;
      wxe.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Vcc != null) {
      this.jdField_a_of_type_Vcc.a(this);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Vcc != null) {
      this.jdField_a_of_type_Vcc.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vce
 * JD-Core Version:    0.7.0.1
 */