import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;

public class eex
  implements AnimationTextView.OnDoubleClick
{
  public eex(MixedMsgItemBuilder paramMixedMsgItemBuilder) {}
  
  public void a(View paramView)
  {
    ChatActivityUtils.a(MixedMsgItemBuilder.a(this.a), paramView, (ChatActivity)MixedMsgItemBuilder.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eex
 * JD-Core Version:    0.7.0.1
 */