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

public class cor
  implements LockPatternView.OnPatternListener
{
  public cor(GesturePWDCreateActivity paramGesturePWDCreateActivity) {}
  
  public void a() {}
  
  public void a(List paramList)
  {
    if (paramList != null) {
      switch (this.a.jdField_b_of_type_Int)
      {
      }
    }
    do
    {
      return;
      if ((paramList != null) && (paramList.size() >= 3))
      {
        this.a.a(paramList);
        this.a.jdField_a_of_type_JavaLangString = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131561865);
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new cos(this), 500L);
        this.a.jdField_b_of_type_Int = 1;
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
      this.a.a(1, this.a.getString(2131563296));
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new cot(this), 500L);
      return;
      paramList = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((this.a.jdField_a_of_type_JavaLangString == null) || (paramList == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramList))) {
        break;
      }
      GesturePWDUtils.setGesturePWD(this.a, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.jdField_a_of_type_JavaLangString);
      GesturePWDUtils.setGesturePWDState(this.a, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2);
      ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Gesture_password", 0, 1, "", "", "", "");
      this.a.a(2, this.a.getString(2131562892));
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new cou(this), 300L);
    } while (!QLog.isColorLevel());
    QLog.d("Q.gesturelock.creat", 2, "gesture lock create success...");
    return;
    this.a.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new cov(this), 500L);
    this.a.a(1, this.a.getString(2131562232));
  }
  
  public void b() {}
  
  public void b(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.creat", 2, "celladd.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cor
 * JD-Core Version:    0.7.0.1
 */