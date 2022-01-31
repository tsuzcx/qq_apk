public abstract class uxv
{
  protected int a;
  protected uxt a;
  
  public abstract void a();
  
  public void a(uxt paramuxt)
  {
    this.jdField_a_of_type_Uxt = paramuxt;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < 1)
    {
      this.jdField_a_of_type_Int += 1;
      wsv.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Uxt != null) {
      this.jdField_a_of_type_Uxt.a(this);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Uxt != null) {
      this.jdField_a_of_type_Uxt.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxv
 * JD-Core Version:    0.7.0.1
 */