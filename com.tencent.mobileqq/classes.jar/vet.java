import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

final class vet
  implements ImageAssetDelegate
{
  vet(Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  @Nullable
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (TextUtils.equals(paramLottieImageAsset.getFileName(), "img_1.jpg")) {
      return veq.a(this.a, 108, 108);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vet
 * JD-Core Version:    0.7.0.1
 */