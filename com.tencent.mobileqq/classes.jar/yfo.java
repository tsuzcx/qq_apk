import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class yfo
  extends Handler
{
  public yfo(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      return;
      this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      QQToast.a(BaseApplication.getContext(), 1, 2131434811, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131436896);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yfo
 * JD-Core Version:    0.7.0.1
 */