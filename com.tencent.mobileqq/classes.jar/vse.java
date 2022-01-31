import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.adapter.HotChatPostListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public class vse
  implements AbsListView.OnScrollListener
{
  public vse(HotChatPie paramHotChatPie) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.a.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition() == this.a.jdField_a_of_type_ComTencentWidgetXListView.getCount() - 1) && (this.a.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.a() != 0) && (this.a.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.a()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.b();
      HotChatPie.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.a(), 10);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vse
 * JD-Core Version:    0.7.0.1
 */