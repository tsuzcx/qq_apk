import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class cgs
  implements DialogInterface.OnClickListener
{
  public cgs(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, Handler.Callback paramCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_Boolean, this.d, this.e);
    if (this.jdField_a_of_type_AndroidOsHandler$Callback != null) {
      this.jdField_a_of_type_AndroidOsHandler$Callback.handleMessage(null);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cgs
 * JD-Core Version:    0.7.0.1
 */