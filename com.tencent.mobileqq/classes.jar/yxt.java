import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class yxt
  implements Runnable
{
  public yxt(CmGameCommonShare paramCmGameCommonShare, int paramInt, File paramFile) {}
  
  public void run()
  {
    int n;
    Object localObject2;
    int i;
    int j;
    int k;
    try
    {
      m = (int)DeviceInfoUtil.j() / 4;
      localBitmap = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localObject1 = QRUtils.a("http://cmshow.qq.com/apollo/html/game-platform/scan-game.html?gameId=" + this.jdField_a_of_type_Int, -1);
      n = ((BitMatrix)localObject1).a();
      localObject2 = new int[n * n];
      i = 0;
    }
    catch (Exception localException)
    {
      int m;
      Bitmap localBitmap;
      Canvas localCanvas;
      Object localObject1;
      QLog.e("apollo_cmGame_CmGameCommonShare", 1, "drawQRBitmap e:", localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      return;
    }
    if (j < n) {
      if (((BitMatrix)localObject1).a(j, i)) {
        k = -16777216;
      }
    }
    label365:
    for (;;)
    {
      localObject1 = Bitmap.createBitmap(n, n, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject1).setPixels((int[])localObject2, 0, n, 0, 0, n, n);
      localObject2 = new Rect(0, 0, m, m);
      localCanvas.drawBitmap((Bitmap)localObject1, new Rect(0, 0, n, n), (Rect)localObject2, null);
      if (CmGameCommonShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare) != null)
      {
        localObject2 = CmGameCommonShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare).getCallback();
        CmGameCommonShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare).setCallback(null);
        i = m * 8 / 41;
        j = (m - i) / 2;
        k = (m - i) / 2;
        localCanvas.save();
        CmGameCommonShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare).setBounds(0, 0, i, i);
        localCanvas.translate(j, k);
        CmGameCommonShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare).draw(localCanvas);
        localCanvas.restore();
        CmGameCommonShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameCommonShare).setCallback((Drawable.Callback)localObject2);
      }
      ((Bitmap)localObject1).recycle();
      ImageUtil.a(localBitmap, this.jdField_a_of_type_JavaIoFile);
      QLog.d("apollo_cmGame_CmGameCommonShare", 2, "checkDefaultQRSharePic end");
      return;
      for (;;)
      {
        if (i >= n) {
          break label365;
        }
        j = 0;
        break;
        for (;;)
        {
          localObject2[(i * n + j)] = k;
          j += 1;
          break;
          k = -1;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxt
 * JD-Core Version:    0.7.0.1
 */