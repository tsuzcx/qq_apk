import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vjn
{
  public List<vjn> a;
  public vjo a;
  private boolean a;
  
  public vjn()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Vjo = new vjo();
    this.jdField_a_of_type_Vjo.jdField_a_of_type_Int = 0;
    vjo.a(this.jdField_a_of_type_Vjo, 0);
    this.jdField_a_of_type_Vjo.jdField_a_of_type_JavaLangString = null;
  }
  
  public vjn(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    String str = paramString.substring(0, paramInt1);
    this.jdField_a_of_type_Vjo = new vjo();
    this.jdField_a_of_type_Vjo.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Vjo.jdField_a_of_type_Int = paramInt1;
    vjo.a(this.jdField_a_of_type_Vjo, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new vjn(paramString, paramInt1 + 1, paramInt2);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      j = vjo.a(this.jdField_a_of_type_Vjo);
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
    vjn localvjn = (vjn)localIterator.next();
    if (!localvjn.jdField_a_of_type_Boolean) {
      i = localvjn.a() + i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<vjn> a()
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
        vjn localvjn = (vjn)localIterator.next();
        if (!localvjn.jdField_a_of_type_Boolean) {
          if (localvjn.jdField_a_of_type_JavaUtilList.size() == 0) {
            localArrayList.add(localvjn);
          } else {
            localArrayList.addAll(localvjn.a());
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
      ((vjn)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Vjo.jdField_a_of_type_Int != 0) && ((paramString.length() <= this.jdField_a_of_type_Vjo.jdField_a_of_type_Int) || (!TextUtils.equals(this.jdField_a_of_type_Vjo.jdField_a_of_type_JavaLangString, String.valueOf(paramString.substring(0, this.jdField_a_of_type_Vjo.jdField_a_of_type_Int)))))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((vjn)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.jdField_a_of_type_Vjo;
        vjo.a(paramString, vjo.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new vjn(paramString, this.jdField_a_of_type_Vjo.jdField_a_of_type_Int + 1, paramInt);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    paramString = this.jdField_a_of_type_Vjo;
    vjo.a(paramString, vjo.a(paramString) + paramInt);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ").append(this.jdField_a_of_type_Vjo).append(" ");
    localStringBuilder.append("child count:").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjn
 * JD-Core Version:    0.7.0.1
 */