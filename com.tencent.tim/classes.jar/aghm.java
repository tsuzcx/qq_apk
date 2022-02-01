import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aghm
  implements View.OnClickListener
{
  aghm(aghl paramaghl) {}
  
  public void onClick(View paramView)
  {
    BaseBubbleBuilder.e locale = (BaseBubbleBuilder.e)wja.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (locale != null)
    {
      i = -1;
      localChatMessage = ahav.e(locale.mMessage);
      if (!this.b.J(localChatMessage)) {
        break label57;
      }
      i = 0;
    }
    for (;;)
    {
      this.b.b(paramView, locale, localChatMessage, i);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label57:
      if (this.b.K(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aghm
 * JD-Core Version:    0.7.0.1
 */