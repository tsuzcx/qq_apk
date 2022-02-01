import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vyi
{
  public List<vyi> a;
  public vyj a;
  private boolean a;
  
  public vyi()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Vyj = new vyj();
    this.jdField_a_of_type_Vyj.jdField_a_of_type_Int = 0;
    vyj.a(this.jdField_a_of_type_Vyj, 0);
    this.jdField_a_of_type_Vyj.jdField_a_of_type_JavaLangString = null;
  }
  
  public vyi(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    String str = paramString.substring(0, paramInt1);
    this.jdField_a_of_type_Vyj = new vyj();
    this.jdField_a_of_type_Vyj.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Vyj.jdField_a_of_type_Int = paramInt1;
    vyj.a(this.jdField_a_of_type_Vyj, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new vyi(paramString, paramInt1 + 1, paramInt2);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      j = vyj.a(this.jdField_a_of_type_Vyj);
    }
    Iterator localIterator;
    int i;
    do
    {
      return j;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      j = i;
    } while (!localIterator.hasNext());
    vyi localvyi = (vyi)localIterator.next();
    if (!localvyi.jdField_a_of_type_Boolean) {
      i = localvyi.a() + i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<vyi> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      localArrayList.add(this);
    }
    for (;;)
    {
      return localArrayList;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        vyi localvyi = (vyi)localIterator.next();
        if (!localvyi.jdField_a_of_type_Boolean) {
          if (localvyi.jdField_a_of_type_JavaUtilList.size() == 0) {
            localArrayList.add(localvyi);
          } else {
            localArrayList.addAll(localvyi.a());
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vyi)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Vyj.jdField_a_of_type_Int != 0) && ((paramString.length() <= this.jdField_a_of_type_Vyj.jdField_a_of_type_Int) || (!TextUtils.equals(this.jdField_a_of_type_Vyj.jdField_a_of_type_JavaLangString, String.valueOf(paramString.substring(0, this.jdField_a_of_type_Vyj.jdField_a_of_type_Int)))))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((vyi)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.jdField_a_of_type_Vyj;
        vyj.a(paramString, vyj.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new vyi(paramString, this.jdField_a_of_type_Vyj.jdField_a_of_type_Int + 1, paramInt);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    paramString = this.jdField_a_of_type_Vyj;
    vyj.a(paramString, vyj.a(paramString) + paramInt);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ").append(this.jdField_a_of_type_Vyj).append(" ");
    localStringBuilder.append("child count:").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyi
 * JD-Core Version:    0.7.0.1
 */