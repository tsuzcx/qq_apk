import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cca
  implements ActionSheet.OnButtonClickListener
{
  public cca(ChatHistory paramChatHistory, MessageRecord paramMessageRecord, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
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
      Utils.executeAsyncTaskOnThreadPool(new ccb(this), new MessageRecord[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cca
 * JD-Core Version:    0.7.0.1
 */