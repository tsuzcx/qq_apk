import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.TicketManager;

public class uns
  implements View.OnClickListener
{
  public uns(ChatHistory.a parama, int paramInt, vea paramvea, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.bFt == -3000) && ((this.a.b.istroop == 1001) || (this.a.b.istroop == 10002)))
    {
      localObject = aqoj.pL(this.aLW);
      localObject = aqik.c(this.b.this$0.app, this.b.this$0, (String)localObject);
      if (localObject != null) {
        ((aqhv)localObject).ace();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.bFt == -3000) || (this.bFt == -3004) || (this.bFt == -30002) || (this.bFt == -30003))
      {
        ChatActivityUtils.a(this.b.this$0, this.b.this$0.app, this.a.b.action, this.a.b.shareAppID, this.a.b.msgtype);
      }
      else if (this.bFt == -3005)
      {
        ChatActivityUtils.a(this.b.this$0, this.b.this$0.app, this.a.b.action, this.a.b.shareAppID, this.a.b.msgtype);
      }
      else if (this.bFt == -3001)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("schemaurl", this.aLW);
        String str = this.b.this$0.app.getCurrentAccountUin();
        ((Bundle)localObject).putString("uin", str);
        ((Bundle)localObject).putString("vkey", ((TicketManager)this.b.this$0.app.getManager(2)).getSkey(str));
        OpenAppClient.q(this.b.this$0, (Bundle)localObject);
      }
      else if (xkl.a(this.a.b))
      {
        AIOEmotionFragment.a(paramView.getContext(), this.a.b, this.b.this$0.c, sxx.getViewRect(paramView));
      }
      else
      {
        if ((this.bFt == -30002) || (this.bFt == -30003)) {
          this.a.b.isInMixedMsg = true;
        }
        xkl.a(this.b.this$0.app, paramView.getContext(), paramView, this.a.b, this.b.this$0.c, false, true, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uns
 * JD-Core Version:    0.7.0.1
 */