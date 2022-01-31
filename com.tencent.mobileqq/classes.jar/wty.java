import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimJumpHelper;
import cooperation.qqpim.QQPimTipsInfo;
import cooperation.qqpim.QQPimTipsInfoHelper;

public class wty
  implements View.OnClickListener
{
  public wty(ContactListView paramContactListView) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006710", "0X8006710", 0, 0, "", "", "", "");
    ContactListView.a(this.a).removeHeaderView(ContactListView.a(this.a));
    ContactListView.a(this.a, null);
    QQPimTipsInfoHelper.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    QQPimGetTipsInfoIPC.a().c();
    paramView = ContactListView.a(this.a).getAccount();
    Bundle localBundle = new Bundle();
    localBundle.putString(QQPimDefineList.o, QQPimDefineList.j);
    localBundle.putInt(QQPimDefineList.p, QQPimGetTipsInfoIPC.a().a.b);
    localBundle.putString(QQPimDefineList.l, paramView);
    new QQPimJumpHelper().a(ContactListView.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wty
 * JD-Core Version:    0.7.0.1
 */