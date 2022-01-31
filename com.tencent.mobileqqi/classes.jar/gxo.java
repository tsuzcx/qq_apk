import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class gxo
  extends Handler
{
  public gxo(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      case 1002: 
      default: 
        return;
      case 1001: 
        this.a.a(false);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        QQToast.a(this.a, 2131560744, 1).b(this.a.d());
      }
    } while (!(paramMessage.obj instanceof String));
    paramMessage = (String)paramMessage.obj;
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMessage);
    this.a.jdField_a_of_type_JavaUtilArrayList.remove(i);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(i);
    this.a.i();
    return;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.a.a(false);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxo
 * JD-Core Version:    0.7.0.1
 */