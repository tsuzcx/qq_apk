import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xof
  implements View.OnClickListener
{
  public xof(StructingMsgItemBuilder paramStructingMsgItemBuilder, ImageView paramImageView, ChatMessage paramChatMessage, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (StructingMsgItemBuilder.a(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      StructingMsgItemBuilder.a(this.this$0, true);
      StructingMsgItemBuilder.a(this.this$0, (Activity)this.this$0.mContext, this.tB, this.b);
      anot.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.VD, "0X800631E", "0X800631E", 0, 0, "" + this.Jg, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xof
 * JD-Core Version:    0.7.0.1
 */