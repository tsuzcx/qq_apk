import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class wey
{
  public static WeakReference<QQAppInterface> a = new WeakReference(null);
  
  public static boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
    if (localQQAppInterface == null) {
      throw new IllegalStateException(anvx.a(2131713785));
    }
    return localQQAppInterface.getNowLiveManager().a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wey
 * JD-Core Version:    0.7.0.1
 */