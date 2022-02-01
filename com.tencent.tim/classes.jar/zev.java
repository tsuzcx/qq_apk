import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;

class zev
  extends AsyncTask<MessageRecord, Object, Object>
{
  zev(zeu paramzeu) {}
  
  protected Object a(MessageRecord... paramVarArgs)
  {
    int i;
    if (paramVarArgs[0].time <= this.a.this$0.b.eT())
    {
      i = ((akwh)this.a.this$0.mApp.getManager(201)).c(paramVarArgs[0], true);
      if (i > 0) {
        this.a.this$0.aTP = true;
      }
    }
    for (;;)
    {
      if ((paramVarArgs[0] instanceof MessageForApollo)) {
        abrb.F(this.a.this$0.mApp, "chat_history_c2c_del_all_msg");
      }
      return null;
      if ((i == 0) && (paramVarArgs[0].time == this.a.this$0.b.eT()))
      {
        this.a.this$0.mApp.b().b(paramVarArgs[0], true);
        continue;
        this.a.this$0.mApp.b().b(paramVarArgs[0], true);
      }
    }
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    this.a.this$0.bK.removeMessages(1);
    if ((this.a.this$0.z != null) && (this.a.this$0.z.isShowing())) {
      this.a.this$0.z.dismiss();
    }
    if ((this.a.this$0.aTP) && (this.a.this$0.bra))
    {
      this.a.this$0.bra = false;
      this.a.this$0.b.cKz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zev
 * JD-Core Version:    0.7.0.1
 */