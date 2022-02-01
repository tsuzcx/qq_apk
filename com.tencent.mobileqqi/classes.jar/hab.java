import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class hab
  extends WeakReference
{
  private final String a;
  
  public hab(String paramString, Object paramObject, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject, paramReferenceQueue);
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hab
 * JD-Core Version:    0.7.0.1
 */