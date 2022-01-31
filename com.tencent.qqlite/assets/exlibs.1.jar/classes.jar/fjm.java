import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class fjm
  extends WeakReference
{
  public Object a;
  
  public fjm(Object paramObject1, Object paramObject2, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject2, paramReferenceQueue);
    this.a = paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fjm
 * JD-Core Version:    0.7.0.1
 */