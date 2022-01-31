import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class pg
  implements Runnable
{
  public pg(QRCardActivity paramQRCardActivity) {}
  
  public void run()
  {
    int k = 0;
    int m;
    int n;
    try
    {
      localObject1 = HttpUtil.a(this.a, this.a.n, "GET", null, null);
      if (localObject1 == null) {
        return;
      }
      localBitmap = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
      if (localBitmap == null) {
        break label440;
      }
      m = localBitmap.getWidth();
      n = localBitmap.getHeight();
      if (m <= n) {
        break label379;
      }
      i = n;
    }
    catch (IOException localIOException)
    {
      Object localObject1;
      Bitmap localBitmap;
      int i;
      int j;
      while (QLog.isColorLevel())
      {
        QLog.d("QrcodeScannerCard", 2, localIOException.getMessage());
        return;
        i = m;
        continue;
        j = 0;
        break label441;
        k = (n - m) / 2;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (!QLog.isColorLevel()) {
        break label440;
      }
      QLog.d("QrcodeScannerCard", 2, localIllegalArgumentException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (!QLog.isColorLevel()) {
        break label440;
      }
      QLog.d("QrcodeScannerCard", 2, localOutOfMemoryError.getMessage());
    }
    if (m > n) {
      j = (m - n) / 2;
    }
    label440:
    label441:
    for (;;)
    {
      m = (int)(75 * this.a.jdField_a_of_type_Float);
      n = (int)(75 * this.a.jdField_a_of_type_Float);
      Object localObject2 = new Rect(0, 0, i, i);
      localObject1 = new Rect(0, 0, m, n);
      RectF localRectF = new RectF((Rect)localObject1);
      Object localObject3 = new Matrix();
      ((Matrix)localObject3).setRectToRect(new RectF((Rect)localObject2), new RectF((Rect)localObject1), Matrix.ScaleToFit.FILL);
      localObject2 = Bitmap.createBitmap(localBitmap, j, k, i, i, (Matrix)localObject3, false);
      localBitmap.recycle();
      i = (int)(6.0D * this.a.jdField_a_of_type_Float);
      localBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
      localObject3 = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      ((Canvas)localObject3).drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      ((Canvas)localObject3).drawRoundRect(localRectF, i, i, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject3).drawBitmap((Bitmap)localObject2, (Rect)localObject1, (Rect)localObject1, localPaint);
      ((Bitmap)localObject2).recycle();
      localObject1 = new Message();
      ((Message)localObject1).what = 0;
      ((Message)localObject1).obj = localBitmap;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      return;
      label379:
      do
      {
        return;
      } while (m <= n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pg
 * JD-Core Version:    0.7.0.1
 */