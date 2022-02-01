import java.util.List;

public abstract class zte<T>
{
  private int jdField_a_of_type_Int;
  private List<T> jdField_a_of_type_JavaUtilList;
  
  public zte(int paramInt, List<T> paramList)
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
  
  public abstract void a(int paramInt, T paramT, yqw paramyqw);
  
  public void a(int paramInt, yqw paramyqw)
  {
    a(paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt), paramyqw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zte
 * JD-Core Version:    0.7.0.1
 */