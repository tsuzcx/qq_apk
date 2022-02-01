import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class wkq
{
  public static void a(Object paramObject)
  {
    if ((paramObject instanceof QQAppInterface)) {
      wkr.a = new WeakReference((QQAppInterface)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkq
 * JD-Core Version:    0.7.0.1
 */