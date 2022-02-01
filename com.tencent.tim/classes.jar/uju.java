import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade.16;
import com.tencent.mobileqq.activity.ChatActivityFacade.16.1.1;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class uju
  implements ausj.a
{
  public uju(ChatActivityFacade.16 param16) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (ujt.T != null) {
        ujt.T.dismiss();
      }
      return;
      ujt.c(this.a.val$app, this.a.b);
      if ((((this.a.I instanceof SplashActivity)) || ((this.a.I instanceof ChatActivity))) && (((FragmentActivity)this.a.I).getChatFragment() != null) && (((FragmentActivity)this.a.I).getChatFragment().a() != null))
      {
        ((FragmentActivity)this.a.I).getChatFragment().a().a(this.a.b);
        if ((this.a.b instanceof MessageForArkApp)) {
          adrm.a().iU(this.a.b.uniseq);
        }
        if (((StructLongMessageDownloadProcessor.aZ(this.a.b)) || (StructLongMessageDownloadProcessor.bb(this.a.b))) && ((this.a.b instanceof MessageForStructing)))
        {
          paramView = (MessageForStructing)this.a.b;
          StructLongMessageDownloadProcessor.u(this.a.val$app, paramView.uniseq);
        }
        if ((this.a.b instanceof MessageForApollo))
        {
          paramView = (MessageForApollo)this.a.b;
          if (paramView != null)
          {
            abrb.a(paramView.uniseq, this.a.val$app, "del_msg");
            if ((paramView.mApolloMessage != null) && ((this.a.I instanceof FragmentActivity)))
            {
              BaseChatPie localBaseChatPie = ((FragmentActivity)this.a.I).getChatFragment().a();
              if ((localBaseChatPie != null) && (localBaseChatPie.sessionInfo != null)) {
                VipUtils.a(this.a.val$app, "cmshow", "Apollo", "del_success", ApolloUtil.gi(localBaseChatPie.sessionInfo.cZ), 0, new String[] { Integer.toString(paramView.mApolloMessage.id) });
              }
            }
          }
        }
        if ((this.a.b instanceof MessageForFile))
        {
          paramView = ahav.a(this.a.val$app, (MessageForFile)this.a.b);
          this.a.val$app.a().ca(paramView.nSessionId);
          anot.a(this.a.val$app, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
        }
        if ((this.a.b instanceof MessageForLightVideo)) {
          ainb.d(this.a.val$app, this.a.b);
        }
        paramView = this.a.b.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isDebugVersion()) {
          QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramView + "],targetId[" + this.a.b.msgUid + "], hashCode:" + this.a.b.hashCode());
        }
        if (TextUtils.isEmpty(paramView)) {}
      }
      try
      {
        long l = Long.parseLong(paramView);
        this.a.val$app.b().d(this.a.b.frienduin, this.a.b.istroop, l, true);
        ((aqrc)this.a.val$app.getManager(235)).c.ah(this.a.b);
        continue;
        ThreadManager.post(new ChatActivityFacade.16.1.1(this), 8, null, true);
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
          QLog.e("ChatActivityFacade", 1, paramView.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uju
 * JD-Core Version:    0.7.0.1
 */