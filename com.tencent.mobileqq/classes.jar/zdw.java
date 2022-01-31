import java.util.ArrayList;

public abstract class zdw
  implements zel
{
  protected long a;
  protected ArrayList<zel> a;
  protected boolean a;
  public boolean b = true;
  public boolean c;
  
  public zdw()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 350L;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 350L;
  }
  
  public void a(zel paramzel)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramzel)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramzel);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public abstract boolean b();
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdw
 * JD-Core Version:    0.7.0.1
 */