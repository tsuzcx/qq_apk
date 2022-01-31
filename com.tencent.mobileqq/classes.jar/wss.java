import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class wss
  implements Runnable
{
  public wss(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    Bitmap localBitmap2 = null;
    localObject1 = null;
    if (ProfileCardUtil.a()) {
      localBitmap1 = localBitmap2;
    }
    try
    {
      localObject1 = ProfileCardUtil.b();
      localBitmap1 = localBitmap2;
      Object localObject2 = new File((String)localObject1);
      localBitmap1 = localBitmap2;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localBitmap1 = localBitmap2;
      localObject2 = new BufferedInputStream(new FileInputStream((File)localObject2));
      localBitmap1 = localBitmap2;
      localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject2, 120, 120));
      localBitmap1 = localBitmap2;
      ((BufferedInputStream)localObject2).close();
      localBitmap1 = localBitmap2;
      localBitmap2 = BitmapManager.a((String)localObject1, localOptions);
      localObject1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        localObject1 = this.a.app.a(localBitmap2, localBitmap2.getWidth(), localBitmap2.getHeight());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localBitmap1;
        if (QLog.isColorLevel())
        {
          QLog.d("AvatarPendantActivity", 2, localException.toString());
          localObject1 = localBitmap1;
        }
      }
    }
    this.a.runOnUiThread(new wst(this, (Bitmap)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wss
 * JD-Core Version:    0.7.0.1
 */