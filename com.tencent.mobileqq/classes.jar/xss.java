import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.qphone.base.util.QLog;

public class xss
  implements Runnable
{
  public xss(NewPreFlowCamera paramNewPreFlowCamera, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewPreFlowCamera.a.setText(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "setTipsTextData: textData=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xss
 * JD-Core Version:    0.7.0.1
 */