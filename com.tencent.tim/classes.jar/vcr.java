import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity.2.1;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity.2.2;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity.2.3;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity.2.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.DisplayMode;
import com.tencent.mobileqq.gesturelock.LockPatternView.a;
import com.tencent.mobileqq.gesturelock.LockPatternView.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class vcr
  implements LockPatternView.b
{
  public vcr(GesturePWDCreateActivity paramGesturePWDCreateActivity) {}
  
  public void Z(List<LockPatternView.a> paramList)
  {
    if (paramList != null) {
      switch (this.a.bHE)
      {
      }
    }
    do
    {
      return;
      if ((paramList != null) && (paramList.size() >= 3))
      {
        this.a.fR(paramList);
        this.a.aNs = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.app.getCurrentAccountUin());
        this.a.jg.setText(2131694285);
        this.a.mHandler.postDelayed(new GesturePWDCreateActivity.2.1(this), 500L);
        this.a.bHE = 1;
        return;
      }
      this.a.a.setDisplayMode(LockPatternView.DisplayMode.Wrong);
      QQToast.a(this.a, 1, this.a.getString(2131694305), 0).show(this.a.getTitleBarHeight());
      this.a.mHandler.postDelayed(new GesturePWDCreateActivity.2.2(this), 500L);
      return;
      paramList = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.app.getCurrentAccountUin());
      if ((this.a.aNs == null) || (paramList == null) || (!this.a.aNs.equals(paramList))) {
        break;
      }
      GesturePWDUtils.setGesturePWD(this.a, this.a.app.getCurrentAccountUin(), this.a.aNs);
      GesturePWDUtils.setGesturePWDState(this.a, this.a.app.getCurrentAccountUin(), 2);
      anot.a(this.a.app, "CliOper", "", "", "Setting_tab", "Gesture_password", 0, 1, "", "", "", "");
      QQToast.a(this.a, 2, this.a.getString(2131694287), 0).show(this.a.getTitleBarHeight());
      this.a.mHandler.postDelayed(new GesturePWDCreateActivity.2.3(this), 300L);
    } while (!QLog.isColorLevel());
    QLog.d("Q.gesturelock.creat", 2, "gesture lock create success...");
    return;
    this.a.a.setDisplayMode(LockPatternView.DisplayMode.Wrong);
    this.a.mHandler.postDelayed(new GesturePWDCreateActivity.2.4(this), 500L);
    QQToast.a(this.a, 1, this.a.getString(2131694286), 0).show(this.a.getTitleBarHeight());
  }
  
  public void aa(List<LockPatternView.a> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.creat", 2, "celladd.");
    }
  }
  
  public void qM() {}
  
  public void qN() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcr
 * JD-Core Version:    0.7.0.1
 */