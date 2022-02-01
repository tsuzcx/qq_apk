import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneVideoDownloadActivity;
import java.util.concurrent.atomic.AtomicBoolean;

public class avqx
  extends Handler
{
  public avqx(QZoneVideoDownloadActivity paramQZoneVideoDownloadActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1000: 
            if (QLog.isDevelopLevel()) {
              QLog.d("QZoneVideoDownloadActivity", 4, "mIsUIInited=" + QZoneVideoDownloadActivity.a(this.this$0));
            }
            break;
          }
        } while (QZoneVideoDownloadActivity.a(this.this$0).get());
        this.this$0.setContentView(2131563398);
        this.this$0.initUI();
        QZoneVideoDownloadActivity.a(this.this$0).set(true);
        return;
      } while ((this.this$0.agi == null) || (this.this$0.mDownloadingBar == null));
      i = paramMessage.arg1;
      this.this$0.agi.setText(acfp.m(2131713475) + i + acfp.m(2131713471));
      this.this$0.mDownloadingBar.setProgress(i);
      return;
    } while ((this.this$0.agi == null) || (this.this$0.mDownloadingBar == null));
    int i = paramMessage.arg1;
    this.this$0.agi.setText(acfp.m(2131713490) + i + acfp.m(2131713468));
    this.this$0.mDownloadingBar.setProgress(i);
    return;
    String str2 = acfp.m(2131713494);
    String str1 = str2;
    if (paramMessage != null)
    {
      str1 = str2;
      if (paramMessage.obj != null)
      {
        str1 = str2;
        if ((paramMessage.obj instanceof String)) {
          str1 = (String)paramMessage.obj;
        }
      }
    }
    Toast.makeText(this.this$0.getApplicationContext(), str1, 1).show();
    awed.ad(this.this$0.uin, "qzone_video_recordtrim", "1005", null);
    this.this$0.finish();
    return;
    Toast.makeText(this.this$0.getApplicationContext(), acfp.m(2131713534), 1).show();
    awed.ad(this.this$0.uin, "qzone_video_recordtrim", "1006", null);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqx
 * JD-Core Version:    0.7.0.1
 */