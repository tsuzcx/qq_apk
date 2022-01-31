import android.app.Activity;
import com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView.INewFriendContext;
import com.tencent.mobileqq.activity.contact.newfriend.ContactRecommendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class eev
  extends ContactBindObserver
{
  public eev(RecommendListView paramRecommendListView, PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp != null) && (RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView) == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new eew(this));
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView)) {
      RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView);
    }
    if ((RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView) == 1) && (!paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.a(2131562083, 1);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView)) {
      RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView);
    }
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendListView", 2, "onGetRecommendedList ");
    }
    if (RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView) == 1)
    {
      if (RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView)) {
        RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.c();
      if (!paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.a(2131562083, 1);
      }
      if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a() == 0)
      {
        Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a();
        if ((localActivity instanceof ContactRecommendActivity))
        {
          ((ContactRecommendActivity)localActivity).d();
          if (QLog.isColorLevel()) {
            QLog.d("RecommendListView", 2, "onGetRecommendedList startMainActivity");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eev
 * JD-Core Version:    0.7.0.1
 */