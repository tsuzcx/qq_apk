import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.olympic.activity.PromotionEntry;
import com.tencent.mobileqq.olympic.activity.PromotionEntry.UpdateOperateBtnStatusRunnable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class akqt
  implements ImageAssetDelegate
{
  akqt(akqs paramakqs) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject = (ImageView)PromotionEntry.UpdateOperateBtnStatusRunnable.a(this.a.b).get();
    int i;
    int j;
    if (localObject != null)
    {
      paramLottieImageAsset = paramLottieImageAsset.getFileName();
      i = ((ImageView)localObject).getResources().getDisplayMetrics().densityDpi;
      j = ((ImageView)localObject).getResources().getDisplayMetrics().densityDpi;
      localObject = this.a.val$entryPath + "entry_images" + File.separator + paramLottieImageAsset;
    }
    for (;;)
    {
      try
      {
        paramLottieImageAsset = jik.i((String)localObject, i, j);
        localObject = paramLottieImageAsset;
        if (paramLottieImageAsset == null) {
          localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
        }
        return localObject;
      }
      catch (Exception paramLottieImageAsset)
      {
        if (AudioHelper.aCz()) {
          QLog.w(PromotionEntry.TAG, 1, "UpdateOperateBtnStatusRunnable Exception, imagePath[" + (String)localObject + "]", paramLottieImageAsset);
        }
      }
      paramLottieImageAsset = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqt
 * JD-Core Version:    0.7.0.1
 */