import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class xiy
  implements Cloneable
{
  public int a;
  @Nullable
  public String a;
  public List<String> a;
  public Map<String, String> a;
  public xix a;
  private boolean a;
  
  public xiy(xix paramxix)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Xix = paramxix;
    zkb.a(paramxix);
    if ((paramxix instanceof xjl))
    {
      paramxix = ((xjl)paramxix).a;
      if ((paramxix != null) && (paramxix.jdField_a_of_type_Int == 12)) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public xiy a()
  {
    xiy localxiy = new xiy(this.jdField_a_of_type_Xix);
    localxiy.jdField_a_of_type_JavaUtilMap.putAll(this.jdField_a_of_type_JavaUtilMap);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localxiy.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    }
    localxiy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    return localxiy;
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaUtilList != null;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      paramObject = (xiy)paramObject;
      if (this.jdField_a_of_type_Xix != null) {
        return this.jdField_a_of_type_Xix.equals(paramObject.jdField_a_of_type_Xix);
      }
    } while (paramObject.jdField_a_of_type_Xix == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Xix != null) {
      return this.jdField_a_of_type_Xix.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    if ("gi{g=" + this.jdField_a_of_type_Xix + ", fv=" + this.jdField_a_of_type_JavaLangString + ", vlist=" + this.jdField_a_of_type_JavaUtilList != null) {
      return String.valueOf(this.jdField_a_of_type_JavaUtilList.size());
    }
    return "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xiy
 * JD-Core Version:    0.7.0.1
 */