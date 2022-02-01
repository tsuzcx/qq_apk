public abstract class wbb
{
  protected int a;
  protected waz a;
  
  public abstract void a();
  
  public void a(waz paramwaz)
  {
    this.jdField_a_of_type_Waz = paramwaz;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < 1)
    {
      this.jdField_a_of_type_Int += 1;
      xvv.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Waz != null) {
      this.jdField_a_of_type_Waz.a(this);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Waz != null) {
      this.jdField_a_of_type_Waz.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbb
 * JD-Core Version:    0.7.0.1
 */