import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.QfavFilePreviewController.3;
import cooperation.qqfav.QfavPluginProxyService;

public class atum
  extends attt
{
  private avjv.a a;
  private Handler mHandler;
  private String mHost;
  private String mKey;
  private int mPort;
  private int mState;
  private String mUid;
  private long zl;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atum
 * JD-Core Version:    0.7.0.1
 */