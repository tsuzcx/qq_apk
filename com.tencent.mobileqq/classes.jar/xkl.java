import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.qphone.base.util.QLog;

public class xkl
  implements Runnable
{
  public xkl(EditLocalVideoActivity paramEditLocalVideoActivity, float paramFloat) {}
  
  public void run()
  {
    if (EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "onCurrentRangeTimeChanged, time=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity.b((int)this.jdField_a_of_type_Float));
      }
      EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).setText(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity.b((int)this.jdField_a_of_type_Float));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkl
 * JD-Core Version:    0.7.0.1
 */