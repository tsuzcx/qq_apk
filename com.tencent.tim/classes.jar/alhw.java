import android.os.Handler;
import android.view.animation.Animation;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.mobileqq.ptt.LSRecordPanel.2.1;
import com.tencent.qphone.base.util.QLog;

public class alhw
  extends alhu.c
{
  public alhw(LSRecordPanel paramLSRecordPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecordingBarAnimation onAnimationEnd");
    }
    LSRecordPanel.a(this.this$0).post(new LSRecordPanel.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhw
 * JD-Core Version:    0.7.0.1
 */