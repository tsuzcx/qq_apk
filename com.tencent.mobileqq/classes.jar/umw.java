import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class umw
{
  public static WeakReference<QQAppInterface> a = new WeakReference(null);
  
  public static boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
    if (localQQAppInterface == null) {
      throw new IllegalStateException(alpo.a(2131714784));
    }
    return localQQAppInterface.a().a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     umw
 * JD-Core Version:    0.7.0.1
 */