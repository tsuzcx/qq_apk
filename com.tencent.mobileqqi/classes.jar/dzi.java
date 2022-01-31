import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;

public class dzi
  implements AnimationTextView.OnDoubleClick
{
  public dzi(LongMsgItemBuilder paramLongMsgItemBuilder) {}
  
  public void a(View paramView)
  {
    ChatActivityUtils.a(LongMsgItemBuilder.a(this.a), paramView, (ChatActivity)LongMsgItemBuilder.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dzi
 * JD-Core Version:    0.7.0.1
 */