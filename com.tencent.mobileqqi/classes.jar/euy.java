import com.tencent.mobileqq.activity.selectmember.RenMaiQuanMemberListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.service.circle.IGroupObserver;

public class euy
  implements IGroupObserver
{
  public euy(RenMaiQuanMemberListInnerFrame paramRenMaiQuanMemberListInnerFrame) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 2) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k();
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      this.a.jdField_a_of_type_Euz.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     euy
 * JD-Core Version:    0.7.0.1
 */