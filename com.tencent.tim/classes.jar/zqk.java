import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimTipsInfo;

public class zqk
  implements View.OnClickListener
{
  public zqk(ContactListView paramContactListView) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.a.app, "CliOper", "", "", "0X8006710", "0X8006710", 0, 0, "", "", "", "");
    ContactListView.a(this.a).removeHeaderView(ContactListView.a(this.a));
    ContactListView.a(this.a, null);
    avlr.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    QQPimGetTipsInfoIPC.a().eAD();
    String str = ContactListView.a(this.a).getAccount();
    Bundle localBundle = new Bundle();
    localBundle.putString(avli.cLU, avli.cLP);
    localBundle.putInt(avli.cLV, QQPimGetTipsInfoIPC.a().a.ext);
    localBundle.putString(avli.cLR, str);
    new avln().a(ContactListView.a(this.a), this.a.mActivity, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqk
 * JD-Core Version:    0.7.0.1
 */