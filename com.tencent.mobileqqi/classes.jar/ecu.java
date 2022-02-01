import com.tencent.mobileqq.activity.contact.CircleMemberListActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.service.circle.IGroupObserver;

public class ecu
  implements IGroupObserver
{
  public ecu(CircleMemberListActivity paramCircleMemberListActivity) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 2) {
      CircleMemberListActivity.a(this.a);
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.a.b, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      this.a.jdField_a_of_type_Edd.notifyDataSetChanged();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.a(this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(-1000, 1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ecu
 * JD-Core Version:    0.7.0.1
 */