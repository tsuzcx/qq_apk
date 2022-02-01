import android.graphics.Bitmap;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class akqw
  implements ImageAssetDelegate
{
  akqw(akqv paramakqv) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject = null;
    paramLottieImageAsset = paramLottieImageAsset.getFileName();
    String str = this.a.Kw + "guide_images" + File.separator + paramLottieImageAsset;
    try
    {
      paramLottieImageAsset = jik.i(str, this.a.doT, this.a.doU);
      return paramLottieImageAsset;
    }
    catch (Exception localException)
    {
      do
      {
        paramLottieImageAsset = localObject;
      } while (!AudioHelper.aCz());
      QLog.w(akqu.TAG, 1, "PromotionGuide Exception, imagePath[" + str + "]", localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqw
 * JD-Core Version:    0.7.0.1
 */