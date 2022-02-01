import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class keo
{
  public static kem.a a(int paramInt)
  {
    Object localObject = b().ka;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        kem.a locala = (kem.a)((Iterator)localObject).next();
        if (locala.aCj == paramInt) {
          return locala;
        }
      }
    }
    return new kem.a();
  }
  
  public static boolean a(kem paramkem)
  {
    return a(paramkem, 1, 1);
  }
  
  public static boolean a(kem paramkem, int paramInt1, int paramInt2)
  {
    if ((paramkem == null) || (paramkem.ka == null) || (paramkem.ka.isEmpty())) {
      return false;
    }
    paramkem = paramkem.ka.iterator();
    while (paramkem.hasNext())
    {
      kem.a locala = (kem.a)paramkem.next();
      if ((locala.pageType == paramInt1) && (locala.aCj == paramInt2)) {
        return true;
      }
    }
    return false;
  }
  
  public static kem b()
  {
    kem localkem2 = ken.a();
    kem localkem1 = localkem2;
    if (localkem2 == null) {
      localkem1 = new kem();
    }
    return localkem1;
  }
  
  public static boolean za()
  {
    kem localkem = ken.a();
    if (localkem == null) {}
    for (String str = "false";; str = localkem.aIm + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localkem != null) {
        break;
      }
      return false;
    }
    if (localkem.aIm == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean zb()
  {
    kem localkem = ken.a();
    if (localkem == null) {}
    for (String str = "false";; str = localkem.aIn + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localkem != null) {
        break;
      }
      return false;
    }
    if (localkem.aIn == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean zc()
  {
    return (za()) && (a(ken.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     keo
 * JD-Core Version:    0.7.0.1
 */