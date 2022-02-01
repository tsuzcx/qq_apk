package cooperation.qzone;

import android.graphics.Bitmap;
import arxa;
import avpw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class QZoneHelper$3
  implements Runnable
{
  public QZoneHelper$3(Bitmap paramBitmap, QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2) {}
  
  public void run()
  {
    try
    {
      avpw.c(this.hb, this.val$app, this.fm, this.iW, this.rK);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QZoneHelper", 2, "createAlbumShortCut error! exception e = " + localException.getMessage());
      arxa.a().showToast(2131690359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.3
 * JD-Core Version:    0.7.0.1
 */