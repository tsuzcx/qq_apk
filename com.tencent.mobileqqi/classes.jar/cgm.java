import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class cgm
  implements DialogInterface.OnClickListener
{
  public cgm(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, boolean paramBoolean, Context paramContext, String paramString3, String paramString4, Handler.Callback paramCallback, String paramString5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, true);
    if (this.jdField_a_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.c, this.b, this.jdField_a_of_type_Boolean, this.d, false, true, this.jdField_a_of_type_AndroidOsHandler$Callback, this.e);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cgm
 * JD-Core Version:    0.7.0.1
 */