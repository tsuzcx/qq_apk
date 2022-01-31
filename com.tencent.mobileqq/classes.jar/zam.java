import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.form.GdtFormData;
import com.tencent.gdtad.views.form.framework.GdtFormCommitUtil.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;

public class zam
{
  public static void a(GdtAd paramGdtAd, GdtFormData paramGdtFormData, WeakReference<zal> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      ((zal)paramWeakReference.get()).a();
    }
    ThreadManager.post(new GdtFormCommitUtil.1(paramGdtAd, paramGdtFormData, paramWeakReference), 5, null, true);
  }
  
  private static zai b(GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    Object localObject;
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (paramGdtAd.actionSetId == -2147483648L) || (paramGdtFormData == null) || (!paramGdtFormData.isValid()))
    {
      yxs.d("GdtFormCommitUtil", "commit error");
      localObject = new zai(4, -1, null);
    }
    zai localzai;
    do
    {
      do
      {
        return localObject;
        zao.a(paramGdtAd, paramGdtFormData);
        localzai = zau.a(paramGdtFormData);
        localObject = localzai;
      } while (localzai == null);
      localObject = localzai;
    } while (localzai.a != 1);
    zcf.a(paramGdtAd, paramGdtFormData);
    return localzai;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zam
 * JD-Core Version:    0.7.0.1
 */