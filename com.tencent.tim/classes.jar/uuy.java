import android.app.Dialog;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

public class uuy
  implements arfj.a
{
  public uuy(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    this.this$0.app.b().N(DiscussionInfoCardActivity.a(this.this$0), 3000);
    this.this$0.app.b().cc(DiscussionInfoCardActivity.a(this.this$0), 3000);
    abrb.F(this.this$0.app, "chat_history_confirm_del_msg");
    paramDialog = this.this$0.app.getHandler(Conversation.class);
    paramView = paramDialog.obtainMessage(1017);
    paramView.obj = DiscussionInfoCardActivity.a(this.this$0);
    paramView.arg1 = 3000;
    paramDialog.sendMessage(paramView);
    QQToast.a(this.this$0, 2, this.this$0.getString(2131691525), 0).show();
    if (this.this$0.so != null) {
      ((TextView)this.this$0.so.findViewById(2131379769)).setTextColor(Color.parseColor("#cccccc"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uuy
 * JD-Core Version:    0.7.0.1
 */