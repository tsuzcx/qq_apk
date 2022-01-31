import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.adapter.AllBuddyListAdapter;
import com.tencent.mobileqq.data.Friends;

public class exj
  implements View.OnClickListener
{
  public exj(AllBuddyListAdapter paramAllBuddyListAdapter, Friends paramFriends) {}
  
  public void onClick(View paramView)
  {
    paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 1);
    paramView.f = 59;
    ProfileActivity.a(AllBuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     exj
 * JD-Core Version:    0.7.0.1
 */