public abstract class wvq
{
  protected int a;
  protected wvo a;
  
  public abstract void a();
  
  public void a(wvo paramwvo)
  {
    this.jdField_a_of_type_Wvo = paramwvo;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < 1)
    {
      this.jdField_a_of_type_Int += 1;
      yqp.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Wvo != null) {
      this.jdField_a_of_type_Wvo.a(this);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Wvo != null) {
      this.jdField_a_of_type_Wvo.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvq
 * JD-Core Version:    0.7.0.1
 */