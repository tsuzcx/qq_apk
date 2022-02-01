package android.arch.lifecycle;

import com.tencent.token.bj.a;
import com.tencent.token.bm;

public class FullLifecycleObserverAdapter
  implements GenericLifecycleObserver
{
  private final FullLifecycleObserver a;
  
  public FullLifecycleObserverAdapter(FullLifecycleObserver paramFullLifecycleObserver)
  {
    this.a = paramFullLifecycleObserver;
  }
  
  public final void a(bm parambm, bj.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default: 
    case 7: 
      throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.7.0.1
 */