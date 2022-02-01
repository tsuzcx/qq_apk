import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class xcz
  implements Cloneable
{
  public int a;
  @Nullable
  public String a;
  public List<String> a;
  public Map<String, String> a;
  public xcy a;
  private boolean a;
  
  public xcz(xcy paramxcy)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Xcy = paramxcy;
    zdl.a(paramxcy);
    if ((paramxcy instanceof xdm))
    {
      paramxcy = ((xdm)paramxcy).a;
      if ((paramxcy != null) && (paramxcy.jdField_a_of_type_Int == 12)) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public xcz a()
  {
    xcz localxcz = new xcz(this.jdField_a_of_type_Xcy);
    localxcz.jdField_a_of_type_JavaUtilMap.putAll(this.jdField_a_of_type_JavaUtilMap);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localxcz.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    }
    localxcz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    return localxcz;
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
      paramObject = (xcz)paramObject;
      if (this.jdField_a_of_type_Xcy != null) {
        return this.jdField_a_of_type_Xcy.equals(paramObject.jdField_a_of_type_Xcy);
      }
    } while (paramObject.jdField_a_of_type_Xcy == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Xcy != null) {
      return this.jdField_a_of_type_Xcy.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    if ("gi{g=" + this.jdField_a_of_type_Xcy + ", fv=" + this.jdField_a_of_type_JavaLangString + ", vlist=" + this.jdField_a_of_type_JavaUtilList != null) {
      return String.valueOf(this.jdField_a_of_type_JavaUtilList.size());
    }
    return "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcz
 * JD-Core Version:    0.7.0.1
 */