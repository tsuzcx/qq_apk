import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

public class ccn
  implements View.OnClickListener
{
  public ccn(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      paramView = paramView.getTag();
      String str = EmosmUtils.getEmoticonSoundPath(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a = new ChatHistory.PlayingPttHistoryInfo(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a.a(1, localView, paramView, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ccn
 * JD-Core Version:    0.7.0.1
 */