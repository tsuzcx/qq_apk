import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.OvalProgress;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.QfavMicroPhoneDialog;

public class fli
  extends Handler
{
  public fli(QfavMicroPhoneDialog paramQfavMicroPhoneDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 8: 
    case 10: 
    default: 
      return;
    case 7: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setProgressParams(0L, 0L);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838831);
      return;
    case 9: 
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838831);
      return;
    case 11: 
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(Integer.toString((int)Math.round(this.a.e * 1.0D / 1000.0D)) + "\"");
      return;
    }
    QfavUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 2131362728, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fli
 * JD-Core Version:    0.7.0.1
 */