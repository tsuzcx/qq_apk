import java.util.ArrayList;

public abstract class zil
  implements zja
{
  protected long a;
  protected ArrayList<zja> a;
  protected boolean a;
  public boolean b = true;
  public boolean c;
  
  public zil()
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
  
  public void a(zja paramzja)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramzja)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramzja);
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
 * Qualified Name:     zil
 * JD-Core Version:    0.7.0.1
 */