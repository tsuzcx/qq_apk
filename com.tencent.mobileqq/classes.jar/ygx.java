import android.view.View;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ygx
  implements ActionSheet.OnButtonClickListener
{
  public ygx(BuddyListAdapter paramBuddyListAdapter, boolean paramBoolean, Friends paramFriends, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a, 1, 2131433009, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      return;
      paramView = (FriendListHandler)BuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter).a(1);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.a(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
        ReportController.b(BuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter), "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.a(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
        ReportController.b(BuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter), "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ygx
 * JD-Core Version:    0.7.0.1
 */