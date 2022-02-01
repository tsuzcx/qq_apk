import android.graphics.Bitmap;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class iud
  implements aqdf.a
{
  public iud(QQServiceForAV paramQQServiceForAV) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onDecodeTaskCompleted");
    }
    new iuq(((QQAppInterface)this.a.getAppRuntime()).getApp().getApplicationContext()).a(new iue(this, paramString, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iud
 * JD-Core Version:    0.7.0.1
 */