import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class hej
  extends WeakReference
{
  private final String a;
  
  public hej(String paramString, Object paramObject, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject, paramReferenceQueue);
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hej
 * JD-Core Version:    0.7.0.1
 */