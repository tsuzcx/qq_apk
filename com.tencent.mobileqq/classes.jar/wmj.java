import android.view.View;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class wmj
  implements ActionSheet.OnButtonClickListener
{
  public wmj(ContactsTroopAdapter paramContactsTroopAdapter, DiscussionHandler paramDiscussionHandler, DiscussionInfo paramDiscussionInfo, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.a((DiscussionInfo)localObject, bool);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      if (!this.jdField_a_of_type_Boolean) {
        break label154;
      }
      paramInt = 1;
      label43:
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.a.a(22)).a(18, true, new Object[] { paramView, Integer.valueOf(paramInt), Integer.valueOf(0), null });
      localObject = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.a).a("dc00899").b("Grp_Dis_set").c("Grp_contactlist");
      if (!this.jdField_a_of_type_Boolean) {
        break label159;
      }
    }
    label154:
    label159:
    for (paramView = "Clk_unstick";; paramView = "Clk_stick")
    {
      ((ReportTask)localObject).d(paramView).a();
      return;
      bool = false;
      break;
      paramInt = 0;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmj
 * JD-Core Version:    0.7.0.1
 */