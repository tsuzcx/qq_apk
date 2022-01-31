import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.Friends;

public class exq
  implements View.OnClickListener
{
  public exq(BuddyListAdapter paramBuddyListAdapter, Friends paramFriends) {}
  
  public void onClick(View paramView)
  {
    if (AppConstants.P.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
    {
      BuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter).startActivity(new Intent(BuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter), LiteAdvanceActivity.class));
      return;
    }
    paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 1);
    paramView.f = 59;
    ProfileActivity.a(BuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     exq
 * JD-Core Version:    0.7.0.1
 */