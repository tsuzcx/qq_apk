package android.arch.lifecycle;

import com.tencent.token.as;
import com.tencent.token.as.a;
import com.tencent.token.au.a;
import com.tencent.token.aw;
import java.util.List;
import java.util.Map;

public class ReflectiveGenericLifecycleObserver
  implements GenericLifecycleObserver
{
  private final Object a;
  private final as.a b;
  
  public ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    this.a = paramObject;
    this.b = as.a.b(this.a.getClass());
  }
  
  public final void a(aw paramaw, au.a parama)
  {
    as.a locala = this.b;
    Object localObject = this.a;
    as.a.a((List)locala.a.get(parama), paramaw, parama, localObject);
    as.a.a((List)locala.a.get(au.a.ON_ANY), paramaw, parama, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.ReflectiveGenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */