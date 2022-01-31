import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bmi
  implements Runnable
{
  public bmi(TipsManager paramTipsManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "tipsRunnable");
    }
    this.a.b();
    if (this.a.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    if (this.a.jdField_b_of_type_Boolean) {
      this.a.a();
    }
    if (this.a.jdField_c_of_type_Boolean)
    {
      if (this.a.jdField_a_of_type_Int != 2) {
        break label174;
      }
      this.a.jdField_b_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560256);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_b_of_type_JavaLangString);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.a(false, false);
      if (this.a.e)
      {
        this.a.a(this.a.jdField_c_of_type_ComTencentAvUtilsTipsManager$TYPE, true);
        this.a.e = false;
      }
      return;
      label174:
      if (this.a.jdField_a_of_type_Int == 1) {
        this.a.jdField_b_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560255);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmi
 * JD-Core Version:    0.7.0.1
 */