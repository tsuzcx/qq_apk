import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.form.GdtFormData;
import com.tencent.gdtad.views.form.framework.GdtFormCommitUtil.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;

public class zaj
{
  public static void a(GdtAd paramGdtAd, GdtFormData paramGdtFormData, WeakReference<zai> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      ((zai)paramWeakReference.get()).a();
    }
    ThreadManager.post(new GdtFormCommitUtil.1(paramGdtAd, paramGdtFormData, paramWeakReference), 5, null, true);
  }
  
  private static zaf b(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    Object localObject;
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (paramGdtAd.actionSetId == -2147483648L) || (paramGdtFormData == null) || (!paramGdtFormData.isValid()))
    {
      yxp.d("GdtFormCommitUtil", "commit error");
      localObject = new zaf(4, -1, null);
    }
    zaf localzaf;
    do
    {
      do
      {
        return localObject;
        zal.a(paramGdtAd, paramGdtFormData);
        localzaf = zar.a(paramGdtFormData);
        localObject = localzaf;
      } while (localzaf == null);
      localObject = localzaf;
    } while (localzaf.a != 1);
    zcc.a(paramGdtAd, paramGdtFormData);
    return localzaf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zaj
 * JD-Core Version:    0.7.0.1
 */