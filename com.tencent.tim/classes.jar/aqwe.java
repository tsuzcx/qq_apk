import android.os.Looper;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class aqwe
  implements aqwf.a
{
  public aqwe(RegisterLHAssistant.2 param2) {}
  
  public void SY(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(aqwc.TAG, 4, String.format(Locale.getDefault(), "checkVipQQStatus, needShow: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    aqwc.a(this.a.this$0, paramBoolean);
    if ((aqwc.a(this.a.this$0)) && (aqwc.a(this.a.this$0).isEnabled()) && (Thread.currentThread() == Looper.getMainLooper().getThread()) && (aqwc.a(this.a.this$0).getVisibility() == 8)) {
      this.a.this$0.SX(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwe
 * JD-Core Version:    0.7.0.1
 */