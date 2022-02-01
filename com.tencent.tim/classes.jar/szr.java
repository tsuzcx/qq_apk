import android.view.View;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

class szr
  implements ausj.a
{
  szr(szq paramszq, MessageForPtt paramMessageForPtt, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.this$0.app.b().t(this.a.frienduin, this.a.istroop, this.a.uniseq);
    paramView = null;
    if (this.this$0.sessionInfo != null)
    {
      paramView = anbi.e(this.a);
      ((MessageForPtt)paramView).fileSize = -3L;
      this.this$0.app.b().b(paramView, this.this$0.app.getCurrentAccountUin());
    }
    if (paramView != null)
    {
      if (!"device_groupchat".equals(paramView.extStr)) {
        break label256;
      }
      if ((!aqiw.isNetSupport(BaseApplication.getContext())) && ((paramView instanceof MessageForDevPtt)))
      {
        paramView = (MessageForDevPtt)paramView;
        paramView.fileSize = -1L;
        paramView.extraflag = 32768;
        paramView.extStr = "device_groupchat";
        paramView.serial();
        this.this$0.app.b().c(paramView.frienduin, paramView.istroop, paramView.uniseq, paramView.msgData);
        this.this$0.notifyDataSetChanged();
        this.c.dismiss();
        return;
      }
      xya.b(((syw)this.this$0.app.getBusinessHandler(51)).a(Long.parseLong(this.this$0.sessionInfo.aTl), this.a.url, this.a.voiceLength), paramView);
    }
    for (;;)
    {
      this.this$0.notifyDataSetChanged();
      this.c.dismiss();
      return;
      label256:
      ((szy)this.this$0.app.getBusinessHandler(49)).a().a(szy.aIn, this.a.url, Long.parseLong(this.this$0.sessionInfo.aTl), paramView.uniseq, paramView.istroop, (int)this.a.msgRecTime / 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szr
 * JD-Core Version:    0.7.0.1
 */