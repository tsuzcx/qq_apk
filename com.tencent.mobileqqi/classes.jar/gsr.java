import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopBarImagePreviewAdapter;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class gsr
  extends Handler
{
  public gsr(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
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
        this.a.b(false);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        TroopBarPublishActivity.a(this.a).setEnabled(true);
        QQToast.a(this.a, 2131560743, 1).b(this.a.d());
      }
    } while (!(paramMessage.obj instanceof String));
    paramMessage = (String)paramMessage.obj;
    this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramMessage);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList);
    paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
    if (this.a.jdField_a_of_type_JavaUtilArrayList.size() < 8) {}
    for (boolean bool = true;; bool = false)
    {
      paramMessage.a(bool, true);
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.a.b(false);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gsr
 * JD-Core Version:    0.7.0.1
 */