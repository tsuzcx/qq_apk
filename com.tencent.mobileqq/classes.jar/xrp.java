import java.util.List;

public abstract class xrp<T>
{
  private int jdField_a_of_type_Int;
  private List<T> jdField_a_of_type_JavaUtilList;
  
  public xrp(int paramInt, List<T> paramList)
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
  
  public abstract void a(int paramInt, T paramT, wph paramwph);
  
  public void a(int paramInt, wph paramwph)
  {
    a(paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt), paramwph);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xrp
 * JD-Core Version:    0.7.0.1
 */