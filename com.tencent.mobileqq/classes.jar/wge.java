import android.widget.TextView;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class wge
  implements Runnable
{
  wge(wgd paramwgd, List paramList) {}
  
  public void run()
  {
    ChatHistoryBubbleListAdapter localChatHistoryBubbleListAdapter = this.jdField_a_of_type_Wgd.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (this.jdField_a_of_type_JavaUtilList.size() < 21) {}
    for (boolean bool = true;; bool = false)
    {
      localChatHistoryBubbleListAdapter.b(localList, bool);
      if (this.jdField_a_of_type_Wgd.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() > 0)
      {
        this.jdField_a_of_type_Wgd.a.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_Wgd.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(0)).shmsgseq;
        this.jdField_a_of_type_Wgd.a.b = ((MessageRecord)this.jdField_a_of_type_Wgd.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(this.jdField_a_of_type_Wgd.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() - 1)).shmsgseq;
      }
      this.jdField_a_of_type_Wgd.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.a = true;
      this.jdField_a_of_type_Wgd.a.jdField_a_of_type_AndroidWidgetTextView.setText("点击加载更多");
      this.jdField_a_of_type_Wgd.a.a(this.jdField_a_of_type_Wgd.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.a, this.jdField_a_of_type_Wgd.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.b);
      this.jdField_a_of_type_Wgd.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wge
 * JD-Core Version:    0.7.0.1
 */