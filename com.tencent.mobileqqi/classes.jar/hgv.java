import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.MicroPhoneClipImageView;
import com.tencent.mobileqq.widget.MicroPhoneDialog;
import com.tencent.mobileqq.widget.OvalProgress;

public class hgv
  extends Handler
{
  public hgv(MicroPhoneDialog paramMicroPhoneDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b();
      }
      AudioUtil.a(this.a.jdField_a_of_type_AndroidContentContext, false);
      return;
    case 2: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setSoundWave(paramMessage.arg1);
      return;
    case 3: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetMicroPhoneClipImageView.setSoundWave(0);
      return;
    case 4: 
      this.a.a(true);
      return;
    case 5: 
      this.a.a(false);
      return;
    case 6: 
      this.a.a();
      return;
    case 7: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setProgressParams(0L, 0L);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839032);
      return;
    case 9: 
      MicroPhoneDialog.a(this.a);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839032);
      return;
    case 8: 
      MicroPhoneDialog.b(this.a);
      return;
    case 10: 
      MicroPhoneDialog.a(this.a);
      MicroPhoneDialog.c(this.a);
      return;
    case 11: 
      this.a.c.setText(Integer.toString((int)Math.round(this.a.g * 1.0D / 1000.0D)) + "\"");
      return;
    }
    MicroPhoneDialog.a(this.a, 2131562618, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgv
 * JD-Core Version:    0.7.0.1
 */