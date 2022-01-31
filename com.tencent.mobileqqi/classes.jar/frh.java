import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import mqq.app.AppRuntime;

public class frh
  extends Thread
{
  public frh(ConfigServlet paramConfigServlet, String paramString1, String paramString2, int paramInt, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, String paramString4, float paramFloat4) {}
  
  public void run()
  {
    int j = 1;
    if (HttpDownloadUtil.a((AppInterface)this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime(), this.jdField_a_of_type_JavaLangString, new File(this.jdField_b_of_type_JavaLangString)))
    {
      SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime().getApplication(), this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, ConfigServlet.jdField_d_of_type_JavaLangString);
      float f1 = ConfigServlet.a(this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet, this.jdField_a_of_type_Float, (float)DeviceInfoUtil.f());
      float f2 = ConfigServlet.a(this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet, this.jdField_b_of_type_Float, (float)DeviceInfoUtil.g(), (float)DeviceInfoUtil.f());
      float f3 = ConfigServlet.a(this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet, this.jdField_c_of_type_Float);
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          return;
        }
        localBitmap = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, true);
        ((Bitmap)localObject).recycle();
        if ((localBitmap == null) || (localBitmap.isRecycled())) {
          return;
        }
        localCanvas = new Canvas(localBitmap);
        localTextPaint = new TextPaint();
        localTextPaint.setAntiAlias(true);
        localTextPaint.setColor(Color.parseColor(this.jdField_d_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "final_x = " + f1 + "  ,final_y = " + f2 + " ,fontColor = " + this.jdField_d_of_type_JavaLangString);
        }
        localTextPaint.setTextSize(Utils.a(this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime().getApplication(), this.jdField_d_of_type_Float));
        if (localTextPaint.measureText(ConfigServlet.a()) <= f3) {
          break label432;
        }
        localObject = "";
        i = 1;
      }
      catch (Exception localException)
      {
        Object localObject;
        Bitmap localBitmap;
        Canvas localCanvas;
        TextPaint localTextPaint;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "decode birthday-splash bitmap exception:" + localException.getMessage());
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        int i;
        label432:
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "decode birthday-splash bitmap OOM Error Catched");
        return;
        for (;;)
        {
          break;
          i = 0;
          j = 0;
        }
      }
      if (j != 0)
      {
        localObject = ConfigServlet.a().substring(0, ConfigServlet.a().length() - i) + "..";
        if (localTextPaint.measureText((String)localObject) <= f3) {
          break label505;
        }
        i += 1;
      }
      else
      {
        localCanvas.drawText((String)localObject, f1, f2, localTextPaint);
        for (;;)
        {
          localCanvas.save(31);
          localCanvas.restore();
          localObject = new BufferedOutputStream(new FileOutputStream(new File(this.jdField_b_of_type_JavaLangString)));
          localBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
          ((BufferedOutputStream)localObject).flush();
          ((BufferedOutputStream)localObject).close();
          localBitmap.recycle();
          return;
          localCanvas.drawText(ConfigServlet.a(), f1, f2, localTextPaint);
        }
      }
    }
    label505:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     frh
 * JD-Core Version:    0.7.0.1
 */