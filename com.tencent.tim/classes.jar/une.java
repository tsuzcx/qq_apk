import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;

class une
  extends AsyncTask<MessageRecord, Object, Object>
{
  une(und paramund) {}
  
  protected Object a(MessageRecord... paramVarArgs)
  {
    if (this.a.this$0.aTP) {
      if (this.a.this$0.b != null) {
        this.a.this$0.b.c(paramVarArgs[0], true);
      }
    }
    for (;;)
    {
      if ((paramVarArgs[0] instanceof MessageForApollo)) {
        abrb.F(this.a.this$0.app, "chat_history_start_del_msg");
      }
      return null;
      this.a.this$0.app.b().b(paramVarArgs[0], true);
    }
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    this.a.this$0.bK.removeMessages(1);
    if ((this.a.this$0.z != null) && (this.a.this$0.z.isShowing())) {
      this.a.this$0.z.dismiss();
    }
    if (this.a.this$0.aTP) {
      this.a.this$0.az(11, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     une
 * JD-Core Version:    0.7.0.1
 */