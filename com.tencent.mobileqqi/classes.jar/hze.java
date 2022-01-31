import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class hze
  extends WeakReference
{
  public Object a;
  
  public hze(Object paramObject1, Object paramObject2, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject2, paramReferenceQueue);
    this.a = paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hze
 * JD-Core Version:    0.7.0.1
 */