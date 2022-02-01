import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.List;

public class vhh<T>
{
  private int jdField_a_of_type_Int;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  private final vhi<T> jdField_a_of_type_Vhi = new vhi();
  
  public vhh(Comparator<T> paramComparator)
  {
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  public List<T> a(T paramT, List<T> paramList)
  {
    for (vhi localvhi = this.jdField_a_of_type_Vhi.jdField_a_of_type_Vhi; (localvhi != this.jdField_a_of_type_Vhi) && (this.jdField_a_of_type_JavaUtilComparator.compare(localvhi.jdField_a_of_type_JavaLangObject, paramT) <= 0); localvhi = localvhi.jdField_a_of_type_Vhi)
    {
      QLog.d("PhotoDanmakuDataSource", 2, "befor removeLessThanData - mDrawingDanmakuList - added");
      paramList.add(localvhi.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Int -= 1;
    }
    this.jdField_a_of_type_Vhi.jdField_a_of_type_Vhi = localvhi;
    localvhi.b = this.jdField_a_of_type_Vhi;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vhi.jdField_a_of_type_Vhi = this.jdField_a_of_type_Vhi;
    this.jdField_a_of_type_Vhi.b = this.jdField_a_of_type_Vhi;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a(T paramT)
  {
    for (vhi localvhi = this.jdField_a_of_type_Vhi.b; (localvhi != this.jdField_a_of_type_Vhi) && (this.jdField_a_of_type_JavaUtilComparator.compare(localvhi.jdField_a_of_type_JavaLangObject, paramT) > 0); localvhi = localvhi.b) {}
    paramT = new vhi(paramT, localvhi.jdField_a_of_type_Vhi, localvhi);
    localvhi.jdField_a_of_type_Vhi.b = paramT;
    localvhi.jdField_a_of_type_Vhi = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public boolean b(T paramT)
  {
    for (vhi localvhi = this.jdField_a_of_type_Vhi.jdField_a_of_type_Vhi; (localvhi != this.jdField_a_of_type_Vhi) && (this.jdField_a_of_type_JavaUtilComparator.compare(localvhi.jdField_a_of_type_JavaLangObject, paramT) < 0); localvhi = localvhi.jdField_a_of_type_Vhi) {}
    paramT = new vhi(paramT, localvhi, localvhi.b);
    localvhi.b.jdField_a_of_type_Vhi = paramT;
    localvhi.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhh
 * JD-Core Version:    0.7.0.1
 */