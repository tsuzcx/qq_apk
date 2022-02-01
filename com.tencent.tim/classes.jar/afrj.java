import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afrj
  implements View.OnClickListener
{
  public afrj(ChatHistoryEmotionAdapter paramChatHistoryEmotionAdapter, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ChatHistoryEmotionAdapter.a(this.b).ab(this.val$title) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = ChatHistoryEmotionAdapter.a(this.b).c(this.val$title, this.b.mColumnCount, this.b.sm);
    String str2 = ChatHistoryEmotionAdapter.a(this.b) + "";
    if (bool) {}
    for (String str1 = "1";; str1 = "2")
    {
      anot.a(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 2, 0, str2, str1, "", "");
      this.b.notifyDataSetChanged();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrj
 * JD-Core Version:    0.7.0.1
 */