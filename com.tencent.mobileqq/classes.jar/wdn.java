import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wdn
{
  public List<wdn> a;
  public wdo a;
  private boolean a;
  
  public wdn()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Wdo = new wdo();
    this.jdField_a_of_type_Wdo.jdField_a_of_type_Int = 0;
    wdo.a(this.jdField_a_of_type_Wdo, 0);
    this.jdField_a_of_type_Wdo.jdField_a_of_type_JavaLangString = null;
  }
  
  public wdn(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    String str = paramString.substring(0, paramInt1);
    this.jdField_a_of_type_Wdo = new wdo();
    this.jdField_a_of_type_Wdo.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Wdo.jdField_a_of_type_Int = paramInt1;
    wdo.a(this.jdField_a_of_type_Wdo, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new wdn(paramString, paramInt1 + 1, paramInt2);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      j = wdo.a(this.jdField_a_of_type_Wdo);
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
    wdn localwdn = (wdn)localIterator.next();
    if (!localwdn.jdField_a_of_type_Boolean) {
      i = localwdn.a() + i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<wdn> a()
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
        wdn localwdn = (wdn)localIterator.next();
        if (!localwdn.jdField_a_of_type_Boolean) {
          if (localwdn.jdField_a_of_type_JavaUtilList.size() == 0) {
            localArrayList.add(localwdn);
          } else {
            localArrayList.addAll(localwdn.a());
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
      ((wdn)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Wdo.jdField_a_of_type_Int != 0) && ((paramString.length() <= this.jdField_a_of_type_Wdo.jdField_a_of_type_Int) || (!TextUtils.equals(this.jdField_a_of_type_Wdo.jdField_a_of_type_JavaLangString, String.valueOf(paramString.substring(0, this.jdField_a_of_type_Wdo.jdField_a_of_type_Int)))))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((wdn)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.jdField_a_of_type_Wdo;
        wdo.a(paramString, wdo.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new wdn(paramString, this.jdField_a_of_type_Wdo.jdField_a_of_type_Int + 1, paramInt);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    paramString = this.jdField_a_of_type_Wdo;
    wdo.a(paramString, wdo.a(paramString) + paramInt);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ").append(this.jdField_a_of_type_Wdo).append(" ");
    localStringBuilder.append("child count:").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdn
 * JD-Core Version:    0.7.0.1
 */