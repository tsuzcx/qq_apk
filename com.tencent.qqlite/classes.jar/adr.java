import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class adr
  implements ActionSheet.OnButtonClickListener
{
  public adr(ChatHistory paramChatHistory, MessageRecord paramMessageRecord, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).obtainMessage(1);
      ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).sendMessageDelayed(paramView, 800L);
      Utils.executeAsyncTaskOnThreadPool(new ads(this), new MessageRecord[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     adr
 * JD-Core Version:    0.7.0.1
 */