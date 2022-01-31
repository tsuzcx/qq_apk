import android.view.View;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class wgi
  implements Runnable
{
  wgi(wgh paramwgh, List paramList) {}
  
  public void run()
  {
    int j = 1;
    int i = 0;
    if (this.jdField_a_of_type_Wgh.jdField_a_of_type_Int != this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("chatHistory.troop.msgList", 2, "loadingContext changed, ignored result local=" + this.jdField_a_of_type_Wgh.jdField_a_of_type_Int + ", global=" + this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_Int);
      }
      return;
    }
    ChatHistoryBubbleListAdapter localChatHistoryBubbleListAdapter = this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
    List localList = this.jdField_a_of_type_JavaUtilList;
    boolean bool;
    label115:
    int i1;
    label237:
    int m;
    if (this.jdField_a_of_type_JavaUtilList.size() < 20)
    {
      bool = true;
      i1 = localChatHistoryBubbleListAdapter.a(localList, bool);
      if (this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() > 0)
      {
        this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(0)).shmsgseq;
        this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.b = ((MessageRecord)this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() - 1)).shmsgseq;
      }
      if ((i1 == 0) || (this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() <= 0)) {
        break label458;
      }
      if (j == 0) {
        break label463;
      }
      m = this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0).getTop();
      k = m;
      i = n;
      if (this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY() < 0) {
        i = n - this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
      }
    }
    label458:
    label463:
    for (int k = m;; k = 0)
    {
      this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
      this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.a(this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.a, this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.b);
      this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
      if (j == 0) {
        break;
      }
      this.jdField_a_of_type_Wgh.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(k + i1, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("chatHistory.troop.msgList", 2, "update position pos=" + k + ", offset=" + i1 + ", top=" + i);
      return;
      bool = false;
      break label115;
      j = 0;
      break label237;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgi
 * JD-Core Version:    0.7.0.1
 */