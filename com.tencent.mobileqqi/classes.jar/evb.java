import com.tencent.mobileqq.activity.selectmember.RenMaiQuanTeamListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.service.circle.IGroupObserver;

public class evb
  implements IGroupObserver
{
  public evb(RenMaiQuanTeamListInnerFrame paramRenMaiQuanTeamListInnerFrame) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.a.jdField_a_of_type_JavaUtilArrayList);
      RenMaiQuanTeamListInnerFrame.a(this.a).notifyDataSetChanged();
    }
    if (paramInt == 2) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evb
 * JD-Core Version:    0.7.0.1
 */