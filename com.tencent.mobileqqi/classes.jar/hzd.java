import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class hzd
  extends WeakReference
{
  public Object a;
  
  public hzd(Object paramObject1, Object paramObject2, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject2, paramReferenceQueue);
    this.a = paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hzd
 * JD-Core Version:    0.7.0.1
 */