import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xva
{
  private List<xvc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xvb jdField_a_of_type_Xvb;
  private xvf jdField_a_of_type_Xvf;
  
  public long a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      long l2 = ((xvc)localIterator.next()).a();
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
  
  public List<xvc> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public xvd a(boolean paramBoolean)
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    label24:
    xvc localxvc;
    label46:
    xvd localxvd;
    if (i == 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject1 = null;
      i = 0;
      if (localIterator.hasNext())
      {
        localxvc = (xvc)localIterator.next();
        localxvd = localxvc.a();
        if (localxvd == null) {
          break label151;
        }
        if (localxvc == this.jdField_a_of_type_Xvf)
        {
          localObject1 = localxvd;
          label70:
          if (localxvc.a(false)) {
            break label152;
          }
          if (!localxvc.b()) {
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
      localxvc.a(localxvd, 0L);
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
  
  public xvf a()
  {
    return this.jdField_a_of_type_Xvf;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xvc)localIterator.next()).e();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(xvc paramxvc)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramxvc);
    if ((paramxvc instanceof xvf)) {
      this.jdField_a_of_type_Xvf = ((xvf)paramxvc);
    }
    while (!(paramxvc instanceof xvb)) {
      return;
    }
    this.jdField_a_of_type_Xvb = ((xvb)paramxvc);
  }
  
  public void a(xvj paramxvj, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xvc)localIterator.next()).a(paramxvj, paramLong);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((xvc)localIterator.next()).b()) {
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
    for (long l1 = 9223372036854775807L; localIterator.hasNext(); l1 = Math.min(((xvc)localIterator.next()).b(), l1)) {}
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
      ((xvc)localIterator.next()).c();
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((xvc)localIterator.next()).d()) {
        return false;
      }
    }
    return true;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xvc)localIterator.next()).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xva
 * JD-Core Version:    0.7.0.1
 */