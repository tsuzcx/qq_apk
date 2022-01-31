import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import java.io.IOException;
import java.util.Map;

public class dwr
  implements Runnable
{
  public dwr(QQApiPlugin paramQQApiPlugin, String paramString, Map paramMap, Runnable paramRunnable) {}
  
  public void run()
  {
    label143:
    try
    {
      localObject = HttpUtil.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString), "GET", null, null);
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      if (localObject == null) {
        break label115;
      }
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if (i * j <= 8000) {
        break label143;
      }
      double d = Math.sqrt(8000.0D / (i * j));
      Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
      ((Bitmap)localObject).recycle();
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      break label115;
    }
    catch (IOException localIOException)
    {
      label115:
      for (;;) {}
    }
    this.jdField_a_of_type_JavaUtilMap.put("image", localObject);
    this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.mRuntime.a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dwr
 * JD-Core Version:    0.7.0.1
 */