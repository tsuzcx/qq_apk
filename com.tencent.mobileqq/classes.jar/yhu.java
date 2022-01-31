import android.view.View;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;

class yhu
  implements Runnable
{
  yhu(yht paramyht, ArrayList paramArrayList) {}
  
  public void run()
  {
    NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.getCount() > 0)
    {
      NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter).setVisibility(0);
      NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter).setVisibility(8);
      if ((this.jdField_a_of_type_Yht.jdField_a_of_type_Boolean) && (NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter) < this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.getCount())) {
        NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter).setSelection(NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter));
      }
      return;
    }
    NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter).setVisibility(0);
    NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_Yht.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yhu
 * JD-Core Version:    0.7.0.1
 */