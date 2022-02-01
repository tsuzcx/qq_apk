import java.util.Comparator;
import java.util.List;

public class ilz
{
  private static ilz b;
  public static final Comparator<ilz> comparator = new ima();
  private static int sPoolSize;
  public static final Object sPoolSync = new Object();
  public aofk.a a;
  private ilz a;
  public int end;
  public int start;
  
  private ilz(aofk.a parama, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aofk$a = parama;
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  public static ilz a(aofk.a parama, int paramInt1, int paramInt2)
  {
    synchronized (sPoolSync)
    {
      if (b != null)
      {
        ilz localilz = b;
        b = localilz.jdField_a_of_type_Ilz;
        localilz.a(parama, paramInt1, paramInt2);
        sPoolSize -= 1;
        return localilz;
      }
      return new ilz(parama, paramInt1, paramInt2);
    }
  }
  
  private void a(aofk.a parama, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ilz = null;
    this.jdField_a_of_type_Aofk$a = parama;
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  public static void bz(List<ilz> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ilz localilz = (ilz)paramList.remove(i);
        if (localilz != null) {
          localilz.recycle();
        }
        i -= 1;
      }
    }
  }
  
  public void recycle()
  {
    a(null, -1, -1);
    synchronized (sPoolSync)
    {
      if (sPoolSize < 50)
      {
        this.jdField_a_of_type_Ilz = b;
        b = this;
        sPoolSize += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilz
 * JD-Core Version:    0.7.0.1
 */