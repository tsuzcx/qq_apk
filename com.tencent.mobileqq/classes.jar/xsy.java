import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;

public class xsy
  implements DialogInterface.OnClickListener
{
  public xsy(LoginView paramLoginView, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a, "dc00898", "", "", "0X8006796", "0X8006796", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new xsz(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsy
 * JD-Core Version:    0.7.0.1
 */