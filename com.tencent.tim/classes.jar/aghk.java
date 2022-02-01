import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aghk
  implements View.OnClickListener
{
  aghk(aghj paramaghj) {}
  
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
        break label83;
      }
      i = 0;
    }
    for (;;)
    {
      this.b.a(paramView, locale, localChatMessage, i);
      if (this.b.a != null) {
        this.b.a.I(locale.mMessage);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      if (this.b.I(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aghk
 * JD-Core Version:    0.7.0.1
 */