import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.newfriend.CircleGroupListView;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import java.util.ArrayList;

public class eiy
  implements IGroupObserver
{
  public eiy(CircleGroupListView paramCircleGroupListView) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.a.jdField_a_of_type_JavaUtilArrayList);
      this.a.jdField_a_of_type_Ejd.notifyDataSetChanged();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.a(this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(-1000, 1));
      }
    }
    CircleGroupListView localCircleGroupListView;
    if (paramInt == 2)
    {
      this.a.c();
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        if (!paramBoolean) {
          break label143;
        }
        localCircleGroupListView = this.a;
        if (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label138;
        }
      }
    }
    label138:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      CircleGroupListView.a(localCircleGroupListView, paramBoolean);
      return;
    }
    label143:
    this.a.a(2131562785, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eiy
 * JD-Core Version:    0.7.0.1
 */