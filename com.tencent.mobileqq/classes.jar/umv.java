import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class umv
{
  public static void a(Object paramObject)
  {
    if ((paramObject instanceof QQAppInterface)) {
      umw.a = new WeakReference((QQAppInterface)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     umv
 * JD-Core Version:    0.7.0.1
 */