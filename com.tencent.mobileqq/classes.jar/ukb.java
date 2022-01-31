import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ukb
{
  public List<ukb> a;
  public ukc a;
  private boolean a;
  
  public ukb()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ukc = new ukc();
    this.jdField_a_of_type_Ukc.jdField_a_of_type_Int = 0;
    ukc.a(this.jdField_a_of_type_Ukc, 0);
    this.jdField_a_of_type_Ukc.jdField_a_of_type_JavaLangString = null;
  }
  
  public ukb(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    String str = paramString.substring(0, paramInt1);
    this.jdField_a_of_type_Ukc = new ukc();
    this.jdField_a_of_type_Ukc.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Ukc.jdField_a_of_type_Int = paramInt1;
    ukc.a(this.jdField_a_of_type_Ukc, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new ukb(paramString, paramInt1 + 1, paramInt2);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      j = ukc.a(this.jdField_a_of_type_Ukc);
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
    ukb localukb = (ukb)localIterator.next();
    if (!localukb.jdField_a_of_type_Boolean) {
      i = localukb.a() + i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<ukb> a()
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
        ukb localukb = (ukb)localIterator.next();
        if (!localukb.jdField_a_of_type_Boolean) {
          if (localukb.jdField_a_of_type_JavaUtilList.size() == 0) {
            localArrayList.add(localukb);
          } else {
            localArrayList.addAll(localukb.a());
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
      ((ukb)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Ukc.jdField_a_of_type_Int != 0) && ((paramString.length() <= this.jdField_a_of_type_Ukc.jdField_a_of_type_Int) || (!TextUtils.equals(this.jdField_a_of_type_Ukc.jdField_a_of_type_JavaLangString, String.valueOf(paramString.substring(0, this.jdField_a_of_type_Ukc.jdField_a_of_type_Int)))))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ukb)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.jdField_a_of_type_Ukc;
        ukc.a(paramString, ukc.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new ukb(paramString, this.jdField_a_of_type_Ukc.jdField_a_of_type_Int + 1, paramInt);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    paramString = this.jdField_a_of_type_Ukc;
    ukc.a(paramString, ukc.a(paramString) + paramInt);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ").append(this.jdField_a_of_type_Ukc).append(" ");
    localStringBuilder.append("child count:").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukb
 * JD-Core Version:    0.7.0.1
 */