import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class plx
{
  public static abstract class a<T>
    implements plx.b<T>
  {
    private plx.c<T> a;
    
    public void a(plx.c<T> paramc)
    {
      this.a = paramc;
    }
    
    public abstract void ah(T paramT);
    
    public void blL()
    {
      Object localObject = this.a.C();
      if (localObject != null)
      {
        ah(localObject);
        ram.b("Q.qqstory.home.data.Producer", "start one consumer:%s", localObject);
        return;
      }
      ram.w("Q.qqstory.home.data.Producer", "no data return");
    }
    
    public void blM()
    {
      blL();
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(plx.c<T> paramc);
    
    public abstract void blL();
    
    public abstract void destroy();
  }
  
  public static abstract interface c<T>
  {
    public abstract T C();
  }
  
  public static class d<T>
    implements plx.c<T>
  {
    private final plx.b<T> a;
    private AtomicBoolean mIsDestroy = new AtomicBoolean(false);
    private List<T> mg = new ArrayList();
    
    public d(plx.b<T> paramb)
    {
      this.a = paramb;
      this.a.a(this);
    }
    
    /* Error */
    public T C()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 35	plx$d:mIsDestroy	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   6: invokevirtual 51	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   9: ifne +17 -> 26
      //   12: aload_0
      //   13: getfield 28	plx$d:mg	Ljava/util/List;
      //   16: invokeinterface 57 1 0
      //   21: istore_1
      //   22: iload_1
      //   23: ifne +9 -> 32
      //   26: aconst_null
      //   27: astore_2
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_2
      //   31: areturn
      //   32: aload_0
      //   33: getfield 28	plx$d:mg	Ljava/util/List;
      //   36: iconst_0
      //   37: invokeinterface 61 2 0
      //   42: astore_2
      //   43: goto -15 -> 28
      //   46: astore_2
      //   47: aload_0
      //   48: monitorexit
      //   49: aload_2
      //   50: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	51	0	this	d
      //   21	2	1	i	int
      //   27	16	2	localObject1	Object
      //   46	4	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	22	46	finally
      //   32	43	46	finally
    }
    
    public void dR(List<T> paramList)
    {
      if (paramList != null) {}
      try
      {
        this.mg.addAll(paramList);
        this.a.blL();
        return;
      }
      finally
      {
        paramList = finally;
        throw paramList;
      }
    }
    
    public void destroy()
    {
      try
      {
        this.mIsDestroy.set(true);
        this.a.destroy();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plx
 * JD-Core Version:    0.7.0.1
 */