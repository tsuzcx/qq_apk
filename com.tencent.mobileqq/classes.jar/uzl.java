import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class uzl
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private List<String> jdField_b_of_type_JavaUtilList;
  
  public uzl(List<String> paramList1, int paramInt1, List<String> paramList2, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaUtilList = paramList2;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List<String> a()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      localLinkedHashSet.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
      localLinkedHashSet.addAll(this.jdField_b_of_type_JavaUtilList);
    }
    return new ArrayList(localLinkedHashSet);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return c() > 0;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int + this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzl
 * JD-Core Version:    0.7.0.1
 */