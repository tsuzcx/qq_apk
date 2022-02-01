import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.16.1;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

public class umt
  implements DialogInterface.OnClickListener
{
  public umt(ChatHistory paramChatHistory, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.this$0.app.b().k(this.this$0.mUin, this.this$0.mType);
    if ((paramDialogInterface != null) && (!paramDialogInterface.isEmpty())) {
      if ((1 != this.this$0.mType) && (3000 != this.this$0.mType)) {}
    }
    for (long l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).shmsgseq;; l1 = 0L) {
      for (;;)
      {
        ThreadManager.getSubThreadHandler().post(new ChatHistory.16.1(this));
        this.this$0.app.b().cc(this.this$0.mUin, this.this$0.mType);
        abrb.F(this.this$0.app, "chat_history_confirm_del_msg");
        if (this.aLU != null) {}
        try
        {
          l2 = Long.parseLong(this.aLU);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.this$0.app.a().F(this.this$0.mUin, this.this$0.mType, l1);
          }
          paramDialogInterface = this.this$0.app.getHandler(Conversation.class);
          Message localMessage = paramDialogInterface.obtainMessage(1017);
          localMessage.obj = this.this$0.mUin;
          localMessage.arg1 = this.this$0.mType;
          paramDialogInterface.sendMessage(localMessage);
          this.this$0.E.dismiss();
          this.this$0.setResult(-1);
          this.this$0.finish();
          return;
          if (((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).isSendFromLocal()) {
            l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).time + 2L;
          } else {
            l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).time;
          }
        }
        catch (Exception paramDialogInterface)
        {
          for (;;)
          {
            paramDialogInterface.printStackTrace();
            long l2 = 0L;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umt
 * JD-Core Version:    0.7.0.1
 */