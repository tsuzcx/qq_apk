import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class cgd
  implements DialogInterface.OnClickListener
{
  public cgd(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, boolean paramBoolean, Handler.Callback paramCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cgd
 * JD-Core Version:    0.7.0.1
 */