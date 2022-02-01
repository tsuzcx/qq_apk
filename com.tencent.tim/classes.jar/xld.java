import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xld
  implements View.OnClickListener
{
  xld(xlc paramxlc) {}
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = this.a.b(paramView);
    this.a.a.S(localChatMessage);
    this.a.a.dhd();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xld
 * JD-Core Version:    0.7.0.1
 */