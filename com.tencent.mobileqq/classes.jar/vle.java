import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class vle
  implements Cloneable
{
  public int a;
  @Nullable
  public String a;
  public List<String> a;
  public Map<String, String> a;
  public vld a;
  private boolean a;
  
  public vle(vld paramvld)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Vld = paramvld;
    xmh.a(paramvld);
    if ((paramvld instanceof vlr))
    {
      paramvld = ((vlr)paramvld).a;
      if ((paramvld != null) && (paramvld.jdField_a_of_type_Int == 12)) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public vle a()
  {
    vle localvle = new vle(this.jdField_a_of_type_Vld);
    localvle.jdField_a_of_type_JavaUtilMap.putAll(this.jdField_a_of_type_JavaUtilMap);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localvle.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    }
    localvle.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    return localvle;
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
      paramObject = (vle)paramObject;
      if (this.jdField_a_of_type_Vld != null) {
        return this.jdField_a_of_type_Vld.equals(paramObject.jdField_a_of_type_Vld);
      }
    } while (paramObject.jdField_a_of_type_Vld == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Vld != null) {
      return this.jdField_a_of_type_Vld.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    if ("gi{g=" + this.jdField_a_of_type_Vld + ", fv=" + this.jdField_a_of_type_JavaLangString + ", vlist=" + this.jdField_a_of_type_JavaUtilList != null) {
      return String.valueOf(this.jdField_a_of_type_JavaUtilList.size());
    }
    return "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vle
 * JD-Core Version:    0.7.0.1
 */