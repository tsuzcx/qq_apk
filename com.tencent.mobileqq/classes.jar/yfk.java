import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.OnTroopListClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListViewItemTag;
import com.tencent.mobileqq.statistics.ReportTask;

public class yfk
  implements View.OnClickListener
{
  public yfk(TroopListAdapter2 paramTroopListAdapter2) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof TroopListAdapter2.TroopListViewItemTag)) {
      return;
    }
    paramView = (TroopListAdapter2.TroopListViewItemTag)paramView;
    if ((paramView.a != null) && (paramView.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener.a(paramView.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramView.a.jdField_a_of_type_Int);
    }
    if ((paramView.a != null) && (paramView.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener.a(paramView.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
    }
    new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "1" }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yfk
 * JD-Core Version:    0.7.0.1
 */