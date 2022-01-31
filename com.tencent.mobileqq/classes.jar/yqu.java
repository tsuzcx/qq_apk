import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.form.GdtFormData;
import com.tencent.gdtad.views.form.framework.GdtFormCommitUtil.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;

public class yqu
{
  public static void a(GdtAd paramGdtAd, GdtFormData paramGdtFormData, WeakReference<yqt> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      ((yqt)paramWeakReference.get()).a();
    }
    ThreadManager.post(new GdtFormCommitUtil.1(paramGdtAd, paramGdtFormData, paramWeakReference), 5, null, true);
  }
  
  private static yqq b(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    Object localObject;
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (paramGdtAd.actionSetId == -2147483648L) || (paramGdtFormData == null) || (!paramGdtFormData.isValid()))
    {
      yny.d("GdtFormCommitUtil", "commit error");
      localObject = new yqq(4, -1, null);
    }
    yqq localyqq;
    do
    {
      do
      {
        return localObject;
        yqw.a(paramGdtAd, paramGdtFormData);
        localyqq = yrc.a(paramGdtFormData);
        localObject = localyqq;
      } while (localyqq == null);
      localObject = localyqq;
    } while (localyqq.a != 1);
    ysn.a(paramGdtAd, paramGdtFormData);
    return localyqq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yqu
 * JD-Core Version:    0.7.0.1
 */