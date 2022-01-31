import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter.ViewHolder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class cda
  implements View.OnClickListener
{
  public cda(SystemMsgListView paramSystemMsgListView) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(SystemMsgListView.a(this.a)))
    {
      QQToast.a(SystemMsgListView.a(this.a), SystemMsgListView.a(this.a).getResources().getString(2131362916), 0).b(this.a.a());
      return;
    }
    paramView = (SystemMsgListAdapter.ViewHolder)paramView.getTag();
    SystemMsgListView.a(this.a, (structmsg.StructMsg)paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramView.c);
    if (paramView.jdField_a_of_type_Int == -1011) {
      this.a.a(paramView.jdField_a_of_type_JavaLangString, 0L, null, paramView.jdField_b_of_type_JavaLangString, paramView.jdField_b_of_type_Long, paramView.jdField_a_of_type_Long);
    }
    for (;;)
    {
      ReportController.b(this.a.a, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
      return;
      this.a.a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_b_of_type_Long, null, paramView.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cda
 * JD-Core Version:    0.7.0.1
 */