import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public final class cgp
  implements DialogInterface.OnClickListener
{
  public cgp(boolean paramBoolean, int paramInt1, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, Handler.Callback paramCallback, String paramString5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label131;
      }
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "1", "", "", "");
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_Boolean, this.d, false, false, this.jdField_a_of_type_AndroidOsHandler$Callback, this.e);
      if (QLog.isColorLevel()) {
        QLog.d("chenlong", 2, "" + (System.currentTimeMillis() - l));
      }
      paramDialogInterface.dismiss();
      return;
      label131:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "1", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cgp
 * JD-Core Version:    0.7.0.1
 */