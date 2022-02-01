import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class whi
{
  public List<whi> a;
  public whj a;
  private boolean a;
  
  public whi()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Whj = new whj();
    this.jdField_a_of_type_Whj.jdField_a_of_type_Int = 0;
    whj.a(this.jdField_a_of_type_Whj, 0);
    this.jdField_a_of_type_Whj.jdField_a_of_type_JavaLangString = null;
  }
  
  public whi(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    String str = paramString.substring(0, paramInt1);
    this.jdField_a_of_type_Whj = new whj();
    this.jdField_a_of_type_Whj.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Whj.jdField_a_of_type_Int = paramInt1;
    whj.a(this.jdField_a_of_type_Whj, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new whi(paramString, paramInt1 + 1, paramInt2);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      j = whj.a(this.jdField_a_of_type_Whj);
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
    whi localwhi = (whi)localIterator.next();
    if (!localwhi.jdField_a_of_type_Boolean) {
      i = localwhi.a() + i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<whi> a()
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
        whi localwhi = (whi)localIterator.next();
        if (!localwhi.jdField_a_of_type_Boolean) {
          if (localwhi.jdField_a_of_type_JavaUtilList.size() == 0) {
            localArrayList.add(localwhi);
          } else {
            localArrayList.addAll(localwhi.a());
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
      ((whi)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Whj.jdField_a_of_type_Int != 0) && ((paramString.length() <= this.jdField_a_of_type_Whj.jdField_a_of_type_Int) || (!TextUtils.equals(this.jdField_a_of_type_Whj.jdField_a_of_type_JavaLangString, String.valueOf(paramString.substring(0, this.jdField_a_of_type_Whj.jdField_a_of_type_Int)))))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((whi)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.jdField_a_of_type_Whj;
        whj.a(paramString, whj.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new whi(paramString, this.jdField_a_of_type_Whj.jdField_a_of_type_Int + 1, paramInt);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    paramString = this.jdField_a_of_type_Whj;
    whj.a(paramString, whj.a(paramString) + paramInt);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ").append(this.jdField_a_of_type_Whj).append(" ");
    localStringBuilder.append("child count:").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whi
 * JD-Core Version:    0.7.0.1
 */