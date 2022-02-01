import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class xmt
  implements Cloneable
{
  public int a;
  @Nullable
  public String a;
  public List<String> a;
  public Map<String, String> a;
  public xms a;
  private boolean a;
  
  public xmt(xms paramxms)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Xms = paramxms;
    znw.a(paramxms);
    if ((paramxms instanceof xng))
    {
      paramxms = ((xng)paramxms).a;
      if ((paramxms != null) && (paramxms.jdField_a_of_type_Int == 12)) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public xmt a()
  {
    xmt localxmt = new xmt(this.jdField_a_of_type_Xms);
    localxmt.jdField_a_of_type_JavaUtilMap.putAll(this.jdField_a_of_type_JavaUtilMap);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localxmt.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    }
    localxmt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    return localxmt;
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
      paramObject = (xmt)paramObject;
      if (this.jdField_a_of_type_Xms != null) {
        return this.jdField_a_of_type_Xms.equals(paramObject.jdField_a_of_type_Xms);
      }
    } while (paramObject.jdField_a_of_type_Xms == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Xms != null) {
      return this.jdField_a_of_type_Xms.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    if ("gi{g=" + this.jdField_a_of_type_Xms + ", fv=" + this.jdField_a_of_type_JavaLangString + ", vlist=" + this.jdField_a_of_type_JavaUtilList != null) {
      return String.valueOf(this.jdField_a_of_type_JavaUtilList.size());
    }
    return "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmt
 * JD-Core Version:    0.7.0.1
 */