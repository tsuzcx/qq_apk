import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class wpp
  extends Handler
{
  public wpp(CommonRecordSoundPanel paramCommonRecordSoundPanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 16711687: 
      this.this$0.zV(102);
      return;
    case 16711686: 
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
      }
      CommonRecordSoundPanel.a(this.this$0).stop();
      aqge.ce(2131230757, false);
      this.this$0.bR.sendEmptyMessage(16711686);
      aqge.m(this.this$0.i, false);
      return;
    }
    this.this$0.zV(1);
    this.this$0.reset();
    QQToast.a(this.this$0.i, this.this$0.i.getString(2131700683), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpp
 * JD-Core Version:    0.7.0.1
 */