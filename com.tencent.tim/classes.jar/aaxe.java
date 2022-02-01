import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;

public class aaxe
  implements aozi.a
{
  public aaxe(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public ArrayList<ResultRecord> ce()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.ci();
  }
  
  public ArrayList<String> cf()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.cf();
  }
  
  public void czX()
  {
    FriendTeamListInnerFrame.a(this.a).notifyDataSetChanged();
    if (FriendTeamListInnerFrame.a(this.a).getGroupCount() > 0)
    {
      Groups localGroups1 = FriendTeamListInnerFrame.a(this.a).a(1007L);
      Groups localGroups2 = FriendTeamListInnerFrame.a(this.a).a(1008L);
      if ((localGroups1 != null) || (localGroups2 != null))
      {
        FriendTeamListInnerFrame.a(this.a).expandGroup(0);
        FriendTeamListInnerFrame.a(this.a).setIsNeedScrollPositionTop(true);
        FriendTeamListInnerFrame.a(this.a).smoothScrollToPositionFromTop(1, 0, 0);
        if (localGroups1 != null) {
          this.a.jdField_a_of_type_Aozi.dYb();
        }
        if (localGroups2 != null) {
          this.a.jdField_a_of_type_Aozi.dYd();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxe
 * JD-Core Version:    0.7.0.1
 */