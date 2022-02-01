import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xlg
{
  private List<xli> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xlh jdField_a_of_type_Xlh;
  private xll jdField_a_of_type_Xll;
  
  public long a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      long l2 = ((xli)localIterator.next()).a();
      if ((l2 == -9223372036854775808L) || (l1 <= l2)) {
        break label60;
      }
      l1 = l2;
    }
    label60:
    for (;;)
    {
      break;
      return l1;
    }
  }
  
  public List<xli> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public xlj a(boolean paramBoolean)
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    label24:
    xli localxli;
    label46:
    xlj localxlj;
    if (i == 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject1 = null;
      i = 0;
      if (localIterator.hasNext())
      {
        localxli = (xli)localIterator.next();
        localxlj = localxli.a();
        if (localxlj == null) {
          break label151;
        }
        if (localxli == this.jdField_a_of_type_Xll)
        {
          localObject1 = localxlj;
          label70:
          if (localxli.a(false)) {
            break label152;
          }
          if (!localxli.b()) {
            break label154;
          }
          i += 1;
        }
      }
    }
    label151:
    label152:
    label154:
    for (;;)
    {
      break label24;
      localxli.a(localxlj, 0L);
      break label46;
      if (localObject1 != null) {}
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (!paramBoolean);
      if (i == this.jdField_a_of_type_JavaUtilList.size())
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      Log.d("Decoders", "EOS NULL");
      return null;
      break label70;
      break label70;
    }
  }
  
  public xll a()
  {
    return this.jdField_a_of_type_Xll;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).e();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(xli paramxli)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramxli);
    if ((paramxli instanceof xll)) {
      this.jdField_a_of_type_Xll = ((xll)paramxli);
    }
    while (!(paramxli instanceof xlh)) {
      return;
    }
    this.jdField_a_of_type_Xlh = ((xlh)paramxli);
  }
  
  public void a(xlp paramxlp, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).a(paramxlp, paramLong);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((xli)localIterator.next()).b()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      break;
      if (i == this.jdField_a_of_type_JavaUtilList.size()) {
        bool = true;
      }
      return bool;
    }
  }
  
  public long b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (long l1 = 9223372036854775807L; localIterator.hasNext(); l1 = Math.min(((xli)localIterator.next()).b(), l1)) {}
    long l2 = l1;
    if (l1 == 9223372036854775807L) {
      l2 = -1L;
    }
    return l2;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).c();
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((xli)localIterator.next()).d()) {
        return false;
      }
    }
    return true;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlg
 * JD-Core Version:    0.7.0.1
 */