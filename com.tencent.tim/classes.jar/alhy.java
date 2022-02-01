import android.view.animation.Animation;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.qphone.base.util.QLog;

public class alhy
  extends alhu.c
{
  public alhy(LSRecordPanel paramLSRecordPanel) {}
  
  public void a(Animation paramAnimation, float paramFloat)
  {
    if ((this.this$0.aQ == null) && (this.this$0.aO != null) && (paramFloat >= 0.5F)) {
      this.this$0.dGc();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startExpandAnimation onAnimationEnd");
    }
    if (paramAnimation == this.this$0.aO) {
      this.this$0.startRecord();
    }
    this.this$0.aO = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhy
 * JD-Core Version:    0.7.0.1
 */