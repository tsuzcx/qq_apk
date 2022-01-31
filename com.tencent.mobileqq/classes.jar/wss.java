import com.tencent.mobileqq.activity.contacts.adapter.ContactsDisAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.activity.contacts.fragment.DiscussionFragment;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class wss
  extends DiscussionObserver
{
  private wss(DiscussionFragment paramDiscussionFragment) {}
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.c)
    {
      this.a.c = false;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener.a(9999, paramBoolean, null);
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DiscussionFragment", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
    if ((paramBoolean) && (this.a.isResumed())) {
      QQToast.a(this.a.getActivity(), 2, "成功设为常用群聊", 0).a();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DiscussionFragment", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
    if ((paramBoolean) && (this.a.isResumed())) {
      QQToast.a(this.a.getActivity(), 2, "成功取消常用群聊", 0).a();
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wss
 * JD-Core Version:    0.7.0.1
 */