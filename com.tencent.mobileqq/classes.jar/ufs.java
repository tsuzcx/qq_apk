import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ufs
{
  public List<ufs> a;
  public uft a;
  private boolean a;
  
  public ufs()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Uft = new uft();
    this.jdField_a_of_type_Uft.jdField_a_of_type_Int = 0;
    uft.a(this.jdField_a_of_type_Uft, 0);
    this.jdField_a_of_type_Uft.jdField_a_of_type_JavaLangString = null;
  }
  
  public ufs(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    String str = paramString.substring(0, paramInt1);
    this.jdField_a_of_type_Uft = new uft();
    this.jdField_a_of_type_Uft.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Uft.jdField_a_of_type_Int = paramInt1;
    uft.a(this.jdField_a_of_type_Uft, paramInt2);
    if (paramInt1 < paramString.length())
    {
      paramString = new ufs(paramString, paramInt1 + 1, paramInt2);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      j = uft.a(this.jdField_a_of_type_Uft);
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
    ufs localufs = (ufs)localIterator.next();
    if (!localufs.jdField_a_of_type_Boolean) {
      i = localufs.a() + i;
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<ufs> a()
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
        ufs localufs = (ufs)localIterator.next();
        if (!localufs.jdField_a_of_type_Boolean) {
          if (localufs.jdField_a_of_type_JavaUtilList.size() == 0) {
            localArrayList.add(localufs);
          } else {
            localArrayList.addAll(localufs.a());
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
      ((ufs)localIterator.next()).a();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Uft.jdField_a_of_type_Int != 0) && ((paramString.length() <= this.jdField_a_of_type_Uft.jdField_a_of_type_Int) || (!TextUtils.equals(this.jdField_a_of_type_Uft.jdField_a_of_type_JavaLangString, String.valueOf(paramString.substring(0, this.jdField_a_of_type_Uft.jdField_a_of_type_Int)))))) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ufs)localIterator.next()).a(paramString, paramInt))
      {
        paramString = this.jdField_a_of_type_Uft;
        uft.a(paramString, uft.a(paramString) + paramInt);
        return true;
      }
    }
    paramString = new ufs(paramString, this.jdField_a_of_type_Uft.jdField_a_of_type_Int + 1, paramInt);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    paramString = this.jdField_a_of_type_Uft;
    uft.a(paramString, uft.a(paramString) + paramInt);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNodeBean: ").append(this.jdField_a_of_type_Uft).append(" ");
    localStringBuilder.append("child count:").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufs
 * JD-Core Version:    0.7.0.1
 */