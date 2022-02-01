import java.util.List;

public abstract class zhi<T>
{
  private int jdField_a_of_type_Int;
  private List<T> jdField_a_of_type_JavaUtilList;
  
  public zhi(int paramInt, List<T> paramList)
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
  
  public abstract void a(int paramInt, T paramT, yhc paramyhc);
  
  public void a(int paramInt, yhc paramyhc)
  {
    a(paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt), paramyhc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhi
 * JD-Core Version:    0.7.0.1
 */