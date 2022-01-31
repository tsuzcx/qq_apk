import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class vpn
  implements Cloneable
{
  public int a;
  @Nullable
  public String a;
  public List<String> a;
  public Map<String, String> a;
  public vpm a;
  private boolean a;
  
  public vpn(vpm paramvpm)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Vpm = paramvpm;
    xqq.a(paramvpm);
    if ((paramvpm instanceof vqa))
    {
      paramvpm = ((vqa)paramvpm).a;
      if ((paramvpm != null) && (paramvpm.jdField_a_of_type_Int == 12)) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public vpn a()
  {
    vpn localvpn = new vpn(this.jdField_a_of_type_Vpm);
    localvpn.jdField_a_of_type_JavaUtilMap.putAll(this.jdField_a_of_type_JavaUtilMap);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localvpn.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    }
    localvpn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    return localvpn;
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
      paramObject = (vpn)paramObject;
      if (this.jdField_a_of_type_Vpm != null) {
        return this.jdField_a_of_type_Vpm.equals(paramObject.jdField_a_of_type_Vpm);
      }
    } while (paramObject.jdField_a_of_type_Vpm == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Vpm != null) {
      return this.jdField_a_of_type_Vpm.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    if ("gi{g=" + this.jdField_a_of_type_Vpm + ", fv=" + this.jdField_a_of_type_JavaLangString + ", vlist=" + this.jdField_a_of_type_JavaUtilList != null) {
      return String.valueOf(this.jdField_a_of_type_JavaUtilList.size());
    }
    return "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpn
 * JD-Core Version:    0.7.0.1
 */