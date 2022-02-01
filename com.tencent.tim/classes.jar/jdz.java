import android.os.Build;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class jdz
  extends jkr
{
  public jdz(VideoControlUI paramVideoControlUI) {}
  
  public void avb() {}
  
  public void avc() {}
  
  public void onAnimationEnd()
  {
    this.this$0.ass();
  }
  
  public void onAnimationStart()
  {
    if (!this.this$0.Ya) {
      this.this$0.ml(0);
    }
    if ("GT-I9100G".equals(Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "Model is 9100G, don't do animation");
      }
      return;
    }
    this.this$0.ari();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdz
 * JD-Core Version:    0.7.0.1
 */