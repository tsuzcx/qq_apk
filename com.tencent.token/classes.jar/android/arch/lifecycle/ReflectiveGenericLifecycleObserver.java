package android.arch.lifecycle;

import com.tencent.token.bg;
import com.tencent.token.bg.a;
import com.tencent.token.bj.a;
import com.tencent.token.bm;
import java.util.List;
import java.util.Map;

public class ReflectiveGenericLifecycleObserver
  implements GenericLifecycleObserver
{
  private final Object a;
  private final bg.a b;
  
  public ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    this.a = paramObject;
    this.b = bg.a.b(this.a.getClass());
  }
  
  public final void a(bm parambm, bj.a parama)
  {
    bg.a locala = this.b;
    Object localObject = this.a;
    bg.a.a((List)locala.a.get(parama), parambm, parama, localObject);
    bg.a.a((List)locala.a.get(bj.a.ON_ANY), parambm, parama, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.ReflectiveGenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */