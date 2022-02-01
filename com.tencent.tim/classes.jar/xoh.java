import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.17.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class xoh
  implements auuw.b
{
  public xoh(StructingMsgItemBuilder paramStructingMsgItemBuilder, Activity paramActivity, ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, String paramString, ArrayList paramArrayList) {}
  
  public void a(auuw.a parama)
  {
    Object localObject = new ReportDialog(this.val$activity);
    ((Dialog)localObject).requestWindowFeature(1);
    ((Dialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
    ((Dialog)localObject).setContentView(2131559846);
    ((Dialog)localObject).show();
    new Handler(this.val$activity.getMainLooper()).postDelayed(new StructingMsgItemBuilder.17.1(this, (Dialog)localObject), 1500L);
    ujt.c(this.this$0.app, this.b);
    int i;
    if ((((this.val$activity instanceof SplashActivity)) || ((this.val$activity instanceof ChatActivity))) && (((FragmentActivity)this.val$activity).getChatFragment() != null) && (((FragmentActivity)this.val$activity).getChatFragment().a() != null))
    {
      ((FragmentActivity)this.this$0.mContext).getChatFragment().a().a(this.b);
      if (((StructLongMessageDownloadProcessor.aZ(this.b)) || (StructLongMessageDownloadProcessor.bb(this.b))) && ((this.b instanceof MessageForStructing)))
      {
        localObject = (MessageForStructing)this.b;
        StructLongMessageDownloadProcessor.u(this.this$0.app, ((MessageForStructing)localObject).uniseq);
      }
      i = parama.id;
      if (this.a == null) {
        break label537;
      }
    }
    label537:
    for (long l = this.a.msgId;; l = 0L)
    {
      i = parama.id;
      anot.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.VD, "0X8006320", "0X8006320", 0, 0, "" + l, "", "" + (i + 1), parama.title);
      if (this.qH.size() <= parama.id)
      {
        return;
        this.this$0.app.b().b(this.b, false);
        return;
      }
      localObject = (obl.a)this.qH.get(parama.id);
      parama = new JSONObject();
      try
      {
        parama.put("puin", ((obl.a)localObject).puin);
        parama.put("type", ((obl.a)localObject).type);
        parama.put("index", ((obl.a)localObject).index);
        parama.put("name", ((obl.a)localObject).name);
        parama.put("net", ((obl.a)localObject).aoY);
        parama.put("mobile_imei", aqgz.getIMEI());
        parama.put("obj", "");
        parama.put("gdt_cli_data", this.b.getExtInfoFromExtStr("gdt_msgClick"));
        parama.put("view_id", this.b.getExtInfoFromExtStr("gdt_view_id"));
        obl.a(this.this$0.app, this.b.selfuin, parama.toString(), "" + l);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xoh
 * JD-Core Version:    0.7.0.1
 */