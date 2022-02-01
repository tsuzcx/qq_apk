import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import java.util.ArrayList;
import java.util.List;

public class zeu
  implements ausj.a
{
  public zeu(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment, MessageRecord paramMessageRecord, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      if (this.this$0.ue == null) {
        this.this$0.ue = new ArrayList();
      }
      if ((this.a instanceof MessageForPtt))
      {
        paramView = MediaPlayerManager.a(this.this$0.mApp).a();
        if ((paramView == this.a) || (((paramView instanceof MessageForPtt)) && (paramView.uniseq == this.a.uniseq))) {
          MediaPlayerManager.a(this.this$0.mApp).yB(false);
        }
      }
      this.this$0.bra = true;
      this.this$0.ue.add(this.a);
      paramView = this.this$0.bK.obtainMessage(1);
      this.this$0.bK.sendMessageDelayed(paramView, 800L);
      Utils.executeAsyncTaskOnThreadPool(new zev(this), new MessageRecord[] { this.a });
      VipUtils.a(this.this$0.mApp, "chat_history", "ChatHistory", "Clk_deleteOne", 1, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zeu
 * JD-Core Version:    0.7.0.1
 */