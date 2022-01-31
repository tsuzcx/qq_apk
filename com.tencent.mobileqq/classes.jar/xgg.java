import java.util.ArrayList;

public abstract class xgg
  implements xgv
{
  protected long a;
  protected ArrayList<xgv> a;
  protected boolean a;
  public boolean b = true;
  public boolean c;
  
  public xgg()
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
  
  public void a(xgv paramxgv)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramxgv)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramxgv);
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
 * Qualified Name:     xgg
 * JD-Core Version:    0.7.0.1
 */