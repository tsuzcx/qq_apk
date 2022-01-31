import android.view.View;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class wgs
  implements AdapterView.OnItemClickListener
{
  public wgs(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Wgy != null)
    {
      paramAdapterView = this.a.getActivity();
      if (paramAdapterView != null) {
        break label23;
      }
    }
    label23:
    do
    {
      return;
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "res_clk", 0, 0, this.a.b, "", "", "");
      paramView = ((wgx)this.a.jdField_a_of_type_Wgy.getItem(paramInt)).a;
      ChatHistoryBubbleListForTroopFragment.a(paramAdapterView, this.a.b, paramView, 100, 1);
    } while (!QLog.isColorLevel());
    QLog.i(TroopMemberHistoryFragment.jdField_a_of_type_JavaLangString, 2, "onItemClick, message = " + paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgs
 * JD-Core Version:    0.7.0.1
 */