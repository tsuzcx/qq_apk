import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class wgt
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public wgt(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.c) || (this.b <= 0)) {}
    while ((paramInt != 0) || (this.b > this.jdField_a_of_type_Int)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.a(21);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_Wgy.getCount();
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgt
 * JD-Core Version:    0.7.0.1
 */