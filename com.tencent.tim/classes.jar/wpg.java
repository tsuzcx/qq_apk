import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import java.io.File;
import java.util.WeakHashMap;

class wpg
  implements ImageAssetDelegate
{
  wpg(wpe paramwpe, String paramString) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inScaled = true;
    ((BitmapFactory.Options)localObject).inDensity = wpe.a(this.a).mContext.getResources().getDisplayMetrics().densityDpi;
    try
    {
      String str = this.aTM + File.separator + paramLottieImageAsset.getFileName();
      if (wpe.a(this.a) != null)
      {
        paramLottieImageAsset = (Bitmap)wpe.a(this.a).get(str);
        if (paramLottieImageAsset != null) {
          localObject = paramLottieImageAsset;
        }
        for (;;)
        {
          return localObject;
          try
          {
            Bitmap localBitmap = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
            localObject = localBitmap;
            paramLottieImageAsset = localBitmap;
            if (wpe.a(this.a) != null)
            {
              paramLottieImageAsset = localBitmap;
              wpe.a(this.a).put(str, localBitmap);
              return localBitmap;
            }
          }
          catch (Exception localException1) {}
        }
        localException1.printStackTrace();
        return paramLottieImageAsset;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramLottieImageAsset = null;
        continue;
        paramLottieImageAsset = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpg
 * JD-Core Version:    0.7.0.1
 */