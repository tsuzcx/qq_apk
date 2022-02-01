import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.2;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavPluginProxyService;

public class aglu
  extends agku
{
  private avjv.a a = new aglv(this);
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private String mHost;
  private String mKey;
  private int mPort = 80;
  private int mState = 0;
  private String mUid;
  private long zl;
  
  public aglu(Bundle paramBundle)
  {
    QfavPluginProxyService.a().a(3, this.a);
    this.mState = 2;
    this.mHandler.postDelayed(new QfavFilePreviewController.2(this), 300000L);
  }
  
  public int Em()
  {
    return 4;
  }
  
  public boolean alr()
  {
    if (3 != this.mState)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QfavFilePreviewController", 4, "sendCS: oldState = " + this.mState + ", newState = STATE_REQUESTING.");
      }
      this.mState = 1;
      return true;
    }
    this.mHandler.postDelayed(new QfavFilePreviewController.3(this), 2000L);
    return true;
  }
  
  public void clear()
  {
    this.mHandler.removeCallbacksAndMessages(null);
    QfavPluginProxyService.a().b(3, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aglu
 * JD-Core Version:    0.7.0.1
 */