import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class erj
  extends WeakReference
{
  private final String a;
  
  public erj(String paramString, Object paramObject, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject, paramReferenceQueue);
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     erj
 * JD-Core Version:    0.7.0.1
 */