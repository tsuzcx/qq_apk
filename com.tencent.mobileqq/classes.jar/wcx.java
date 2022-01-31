import java.util.List;

public abstract class wcx<T>
{
  private int jdField_a_of_type_Int;
  private List<T> jdField_a_of_type_JavaUtilList;
  
  public wcx(int paramInt, List<T> paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List<T> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public abstract void a(int paramInt, T paramT, vap paramvap);
  
  public void a(int paramInt, vap paramvap)
  {
    a(paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt), paramvap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wcx
 * JD-Core Version:    0.7.0.1
 */