import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uet
{
  private List<uev> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ueu jdField_a_of_type_Ueu;
  private uey jdField_a_of_type_Uey;
  
  public long a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      long l2 = ((uev)localIterator.next()).a();
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
  
  public List<uev> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public uew a(boolean paramBoolean)
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    label24:
    uev localuev;
    label46:
    uew localuew;
    if (i == 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject1 = null;
      i = 0;
      if (localIterator.hasNext())
      {
        localuev = (uev)localIterator.next();
        localuew = localuev.a();
        if (localuew == null) {
          break label151;
        }
        if (localuev == this.jdField_a_of_type_Uey)
        {
          localObject1 = localuew;
          label70:
          if (localuev.a(false)) {
            break label152;
          }
          if (!localuev.b()) {
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
      localuev.a(localuew, 0L);
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
  
  public uey a()
  {
    return this.jdField_a_of_type_Uey;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uev)localIterator.next()).e();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(uev paramuev)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramuev);
    if ((paramuev instanceof uey)) {
      this.jdField_a_of_type_Uey = ((uey)paramuev);
    }
    while (!(paramuev instanceof ueu)) {
      return;
    }
    this.jdField_a_of_type_Ueu = ((ueu)paramuev);
  }
  
  public void a(ufc paramufc, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uev)localIterator.next()).a(paramufc, paramLong);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((uev)localIterator.next()).b()) {
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
    for (long l1 = 9223372036854775807L; localIterator.hasNext(); l1 = Math.min(((uev)localIterator.next()).b(), l1)) {}
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
      ((uev)localIterator.next()).c();
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((uev)localIterator.next()).d()) {
        return false;
      }
    }
    return true;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uev)localIterator.next()).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uet
 * JD-Core Version:    0.7.0.1
 */