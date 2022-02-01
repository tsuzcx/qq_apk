package cooperation.qzone;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import avpw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class QZoneHelper$4
  implements Runnable
{
  public QZoneHelper$4(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 26)
      {
        avpw.b(avpw.b(this.val$app, this.fm, this.iW), this.val$app, this.fm, this.rK, this.hb);
        return;
      }
      avpw.d(this.hb, this.val$app, this.fm, this.iW, this.rK);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QZoneHelper", 2, "updateAlbumShortCut error! exception e = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.4
 * JD-Core Version:    0.7.0.1
 */