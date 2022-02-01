public abstract class wzl
{
  protected int a;
  protected wzj a;
  
  public abstract void a();
  
  public void a(wzj paramwzj)
  {
    this.jdField_a_of_type_Wzj = paramwzj;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < 1)
    {
      this.jdField_a_of_type_Int += 1;
      yuk.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Wzj != null) {
      this.jdField_a_of_type_Wzj.a(this);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Wzj != null) {
      this.jdField_a_of_type_Wzj.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzl
 * JD-Core Version:    0.7.0.1
 */