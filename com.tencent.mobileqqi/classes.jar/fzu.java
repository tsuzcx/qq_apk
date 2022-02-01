import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import java.io.IOException;
import java.util.Map;

public class fzu
  implements Runnable
{
  public fzu(QQApiPlugin paramQQApiPlugin, String paramString, Map paramMap, Runnable paramRunnable) {}
  
  public void run()
  {
    label138:
    try
    {
      localObject = HttpUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, "GET", null, null);
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      if (localObject == null) {
        break label110;
      }
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if (i * j <= 8000) {
        break label138;
      }
      double d = Math.sqrt(8000.0D / (i * j));
      Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
      ((Bitmap)localObject).recycle();
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      break label110;
    }
    catch (IOException localIOException)
    {
      label110:
      for (;;) {}
    }
    this.jdField_a_of_type_JavaUtilMap.put("image", localObject);
    this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.mRuntime.a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fzu
 * JD-Core Version:    0.7.0.1
 */