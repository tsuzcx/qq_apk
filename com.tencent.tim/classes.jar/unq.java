import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.a;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class unq
  implements View.OnClickListener
{
  public unq(ChatHistory.a parama, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    AIOEmotionFragment.a(paramView.getContext(), this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_b_of_type_ComTencentMobileqqActivityChatHistory$a.this$0.c, sxx.getViewRect(paramView));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unq
 * JD-Core Version:    0.7.0.1
 */