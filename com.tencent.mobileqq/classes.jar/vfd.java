import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.List;

public class vfd<T>
{
  private int jdField_a_of_type_Int;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  private final vfe<T> jdField_a_of_type_Vfe = new vfe();
  
  public vfd(Comparator<T> paramComparator)
  {
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  public List<T> a(T paramT, List<T> paramList)
  {
    for (vfe localvfe = this.jdField_a_of_type_Vfe.jdField_a_of_type_Vfe; (localvfe != this.jdField_a_of_type_Vfe) && (this.jdField_a_of_type_JavaUtilComparator.compare(localvfe.jdField_a_of_type_JavaLangObject, paramT) <= 0); localvfe = localvfe.jdField_a_of_type_Vfe)
    {
      QLog.d("PhotoDanmakuDataSource", 2, "befor removeLessThanData - mDrawingDanmakuList - added");
      paramList.add(localvfe.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Int -= 1;
    }
    this.jdField_a_of_type_Vfe.jdField_a_of_type_Vfe = localvfe;
    localvfe.b = this.jdField_a_of_type_Vfe;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vfe.jdField_a_of_type_Vfe = this.jdField_a_of_type_Vfe;
    this.jdField_a_of_type_Vfe.b = this.jdField_a_of_type_Vfe;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a(T paramT)
  {
    for (vfe localvfe = this.jdField_a_of_type_Vfe.b; (localvfe != this.jdField_a_of_type_Vfe) && (this.jdField_a_of_type_JavaUtilComparator.compare(localvfe.jdField_a_of_type_JavaLangObject, paramT) > 0); localvfe = localvfe.b) {}
    paramT = new vfe(paramT, localvfe.jdField_a_of_type_Vfe, localvfe);
    localvfe.jdField_a_of_type_Vfe.b = paramT;
    localvfe.jdField_a_of_type_Vfe = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public boolean b(T paramT)
  {
    for (vfe localvfe = this.jdField_a_of_type_Vfe.jdField_a_of_type_Vfe; (localvfe != this.jdField_a_of_type_Vfe) && (this.jdField_a_of_type_JavaUtilComparator.compare(localvfe.jdField_a_of_type_JavaLangObject, paramT) < 0); localvfe = localvfe.jdField_a_of_type_Vfe) {}
    paramT = new vfe(paramT, localvfe, localvfe.b);
    localvfe.b.jdField_a_of_type_Vfe = paramT;
    localvfe.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfd
 * JD-Core Version:    0.7.0.1
 */