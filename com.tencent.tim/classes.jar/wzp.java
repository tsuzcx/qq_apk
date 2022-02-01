import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;

public class wzp
  extends wzj
{
  private long IM;
  private long IN;
  
  public wzp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    if (paramChatMessage.istroop == 1038)
    {
      long l = System.currentTimeMillis();
      if ((this.IM != paramChatMessage.msgUid) || (l - this.IN > 1000L))
      {
        this.IM = paramChatMessage.msgUid;
        this.IN = l;
        if ((paramChatMessage instanceof MessageForArkApp))
        {
          MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
          if (localMessageForArkApp.ark_app_message != null)
          {
            this.IN = System.currentTimeMillis();
            MiniProgramLpReportDC04239.reportByQQ("message", "message_aio", "expo", "com.tencent.miniapp", localMessageForArkApp.ark_app_message.appView, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("xiaoyong", 2, "ArkAppPublicAccountItemBuilder report");
            }
          }
        }
      }
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    if ((this.sessionInfo != null) && ("3046055438".equals(this.sessionInfo.aTl))) {
      kds.a(this.app, paramChatMessage, paramView);
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzp
 * JD-Core Version:    0.7.0.1
 */