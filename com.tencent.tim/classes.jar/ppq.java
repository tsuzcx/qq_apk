import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class ppq
{
  public static WeakReference<QQAppInterface> cR = new WeakReference(null);
  
  public static boolean IC()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)cR.get();
    if (localQQAppInterface == null) {
      throw new IllegalStateException(acfp.m(2131714822));
    }
    return localQQAppInterface.a().abu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppq
 * JD-Core Version:    0.7.0.1
 */