import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.DisplayMode;
import com.tencent.mobileqq.gesturelock.LockPatternView.OnPatternListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class apx
  implements LockPatternView.OnPatternListener
{
  public apx(GesturePWDCreateActivity paramGesturePWDCreateActivity) {}
  
  public void a() {}
  
  public void a(List paramList)
  {
    if (paramList != null) {
      switch (this.a.b)
      {
      }
    }
    do
    {
      return;
      if ((paramList != null) && (paramList.size() >= 3))
      {
        this.a.a(paramList);
        this.a.jdField_a_of_type_JavaLangString = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.app.a());
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131364013);
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new apy(this), 500L);
        this.a.b = 1;
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
      this.a.a(1, this.a.getString(2131364016));
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new apz(this), 500L);
      return;
      paramList = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.app.a());
      if ((this.a.jdField_a_of_type_JavaLangString == null) || (paramList == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramList))) {
        break;
      }
      GesturePWDUtils.setGesturePWD(this.a, this.a.app.a(), this.a.jdField_a_of_type_JavaLangString);
      GesturePWDUtils.setGesturePWDState(this.a, this.a.app.a(), 2);
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Gesture_password", 0, 1, "", "", "", "");
      this.a.a(2, this.a.getString(2131364014));
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new aqa(this), 300L);
    } while (!QLog.isColorLevel());
    QLog.d("Q.gesturelock.creat", 2, "gesture lock create success...");
    return;
    this.a.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new aqb(this), 500L);
    this.a.a(1, this.a.getString(2131364015));
  }
  
  public void b() {}
  
  public void b(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.creat", 2, "celladd.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     apx
 * JD-Core Version:    0.7.0.1
 */