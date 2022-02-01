import java.lang.ref.WeakReference;

public class aaso
{
  private static WeakReference<aaso.b> eV;
  private static WeakReference<aaso.a> eW;
  
  public static void AO(String paramString)
  {
    if (eW != null) {}
    for (aaso.a locala = (aaso.a)eW.get();; locala = null)
    {
      if (locala != null) {
        locala.AI(paramString);
      }
      return;
    }
  }
  
  public static void Gt(int paramInt)
  {
    if (eW != null) {}
    for (aaso.a locala = (aaso.a)eW.get();; locala = null)
    {
      if (locala != null) {
        locala.onFailed(paramInt);
      }
      return;
    }
  }
  
  public static void a(aaso.a parama)
  {
    eW = new WeakReference(parama);
  }
  
  public static void a(aaso.b paramb)
  {
    eV = new WeakReference(paramb);
  }
  
  public static void cX(String paramString, int paramInt)
  {
    if (eV != null) {}
    for (aaso.b localb = (aaso.b)eV.get();; localb = null)
    {
      if (localb != null) {
        localb.cX(paramString, paramInt);
      }
      return;
    }
  }
  
  public static void cxR()
  {
    if (eW != null) {}
    for (aaso.a locala = (aaso.a)eW.get();; locala = null)
    {
      if (locala != null) {
        locala.cwQ();
      }
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void AI(String paramString);
    
    public abstract void cwQ();
    
    public abstract void onFailed(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void cX(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaso
 * JD-Core Version:    0.7.0.1
 */