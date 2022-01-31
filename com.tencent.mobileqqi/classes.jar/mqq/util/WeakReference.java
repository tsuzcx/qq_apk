package mqq.util;

import java.lang.ref.ReferenceQueue;

public class WeakReference<T>
  extends java.lang.ref.WeakReference<T>
{
  public WeakReference(T paramT)
  {
    super(paramT);
  }
  
  public WeakReference(T paramT, ReferenceQueue<? super T> paramReferenceQueue)
  {
    super(paramT, paramReferenceQueue);
  }
  
  public boolean equals(Object paramObject)
  {
    Object localObject2 = get();
    Object localObject1 = paramObject;
    if ((paramObject instanceof WeakReference)) {
      localObject1 = ((WeakReference)paramObject).get();
    }
    if ((localObject2 != null) && (localObject1 != null)) {
      return localObject2.equals(localObject1);
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = get();
    if (localObject != null) {
      return localObject.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.util.WeakReference
 * JD-Core Version:    0.7.0.1
 */