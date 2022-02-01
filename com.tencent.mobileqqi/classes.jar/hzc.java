import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class hzc
  extends WeakReference
{
  public Object a;
  
  public hzc(Object paramObject1, Object paramObject2, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject2, paramReferenceQueue);
    this.a = paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hzc
 * JD-Core Version:    0.7.0.1
 */