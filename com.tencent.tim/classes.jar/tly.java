import android.content.Context;
import com.tencent.ad.tangram.canvas.report.AdDMPReportUtil;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormCommitListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.form.framework.GdtFormCommitUtil.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;

public class tly
{
  private static AdFormError a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    Object localObject;
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (paramGdtAd.actionSetId == -2147483648L) || (paramAdFormData == null) || (!paramAdFormData.isValid()))
    {
      tkw.e("GdtFormCommitUtil", "commit error");
      localObject = new AdFormError(4, -1, null);
    }
    AdFormError localAdFormError;
    do
    {
      do
      {
        return localObject;
        tlz.b(paramContext, paramGdtAd, paramAdFormData);
        localAdFormError = tmd.a(paramAdFormData);
        localObject = localAdFormError;
      } while (localAdFormError == null);
      localObject = localAdFormError;
    } while (localAdFormError.type != 1);
    AdDMPReportUtil.reportUpload(paramContext, paramGdtAd, paramAdFormData);
    return localAdFormError;
  }
  
  public static void a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData, WeakReference<AdFormCommitListener> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      ((AdFormCommitListener)paramWeakReference.get()).beforeCommit();
    }
    ThreadManager.post(new GdtFormCommitUtil.1(paramContext, paramGdtAd, paramAdFormData, paramWeakReference), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tly
 * JD-Core Version:    0.7.0.1
 */