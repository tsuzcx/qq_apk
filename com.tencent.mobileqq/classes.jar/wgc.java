import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class wgc
  implements Runnable
{
  wgc(wgb paramwgb, List paramList) {}
  
  public void run()
  {
    ChatHistoryBubbleListAdapter localChatHistoryBubbleListAdapter = this.jdField_a_of_type_Wgb.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (this.jdField_a_of_type_JavaUtilList.size() < 20) {}
    for (boolean bool = true;; bool = false)
    {
      localChatHistoryBubbleListAdapter.a(localList, bool);
      if (this.jdField_a_of_type_Wgb.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() > 0)
      {
        this.jdField_a_of_type_Wgb.a.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_Wgb.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(0)).shmsgseq;
        this.jdField_a_of_type_Wgb.a.b = ((MessageRecord)this.jdField_a_of_type_Wgb.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(this.jdField_a_of_type_Wgb.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() - 1)).shmsgseq;
      }
      this.jdField_a_of_type_Wgb.a.a(this.jdField_a_of_type_Wgb.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.a, this.jdField_a_of_type_Wgb.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.b);
      this.jdField_a_of_type_Wgb.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_Wgb.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_Wgb.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() - 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgc
 * JD-Core Version:    0.7.0.1
 */