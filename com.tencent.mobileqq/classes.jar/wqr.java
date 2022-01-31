import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimJumpHelper;
import cooperation.qqpim.QQPimTipsInfoHelper;
import mqq.app.TicketManagerImpl;

public class wqr
  implements View.OnClickListener
{
  public wqr(ContactListView paramContactListView) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80066FF", "0X80066FF", 0, 0, "", "", "", "");
    ContactListView.a(this.a).setVisibility(4);
    QQPimTipsInfoHelper.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    paramView = ContactListView.a(this.a).getAccount();
    Object localObject = (TicketManagerImpl)ContactListView.a(this.a).getManager(2);
    if (localObject == null) {
      return;
    }
    localObject = ((TicketManagerImpl)localObject).getA2(paramView);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "a2 = " + (String)localObject);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(QQPimDefineList.o, QQPimDefineList.i);
    localBundle.putString(QQPimDefineList.l, paramView);
    localBundle.putString(QQPimDefineList.m, (String)localObject);
    new QQPimJumpHelper().a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqr
 * JD-Core Version:    0.7.0.1
 */