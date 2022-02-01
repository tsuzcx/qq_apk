import android.support.v4.util.Pools.SynchronizedPool;

public class mmd
  extends mmc<mmf.a, mmf, mmd.a>
{
  private static final Pools.SynchronizedPool<mmd.a> a = new Pools.SynchronizedPool(10);
  private static final mmc.a<mmf.a, mmf, mmd.a> b = new mme();
  
  public mmd()
  {
    super(b);
  }
  
  private static mmd.a a(int paramInt1, int paramInt2, int paramInt3)
  {
    mmd.a locala2 = (mmd.a)a.acquire();
    mmd.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new mmd.a();
    }
    locala1.start = paramInt1;
    locala1.to = paramInt2;
    locala1.count = paramInt3;
    return locala1;
  }
  
  public void a(mmf parammmf, int paramInt1, int paramInt2)
  {
    a(parammmf, 1, a(paramInt1, 0, paramInt2));
  }
  
  public void a(mmf parammmf, int paramInt, mmd.a parama)
  {
    try
    {
      super.a(parammmf, paramInt, parama);
      if (parama != null) {
        a.release(parama);
      }
      return;
    }
    finally {}
  }
  
  public void b(mmf parammmf, int paramInt1, int paramInt2)
  {
    a(parammmf, 2, a(paramInt1, 0, paramInt2));
  }
  
  public void c(mmf parammmf, int paramInt1, int paramInt2)
  {
    a(parammmf, 4, a(paramInt1, 0, paramInt2));
  }
  
  static class a
  {
    public int count;
    public int start;
    public int to;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmd
 * JD-Core Version:    0.7.0.1
 */