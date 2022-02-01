public abstract class wpw
{
  protected int a;
  protected wpu a;
  
  public abstract void a();
  
  public void a(wpu paramwpu)
  {
    this.jdField_a_of_type_Wpu = paramwpu;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < 1)
    {
      this.jdField_a_of_type_Int += 1;
      ykq.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Wpu != null) {
      this.jdField_a_of_type_Wpu.a(this);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Wpu != null) {
      this.jdField_a_of_type_Wpu.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpw
 * JD-Core Version:    0.7.0.1
 */