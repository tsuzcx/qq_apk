import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade.17;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.List;

public class ujv
  implements ausj.a
{
  public ujv(ChatActivityFacade.17 param17) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if ((ujt.U != null) && (ujt.U.isShowing())) {
        ujt.U.dismiss();
      }
      return;
    }
    if ((ujt.U != null) && (ujt.U.isShowing())) {
      ujt.U.dismiss();
    }
    paramInt = 0;
    Object localObject;
    for (;;)
    {
      if (paramInt < ujt.qn.size())
      {
        paramView = (ChatMessage)ujt.qn.get(paramInt);
        if (paramView.msgtype == -2005)
        {
          localObject = ahav.a(this.a.val$app, (MessageForFile)paramView);
          this.a.val$app.a().ca(((FileManagerEntity)localObject).nSessionId);
        }
        localObject = paramView.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isDebugVersion()) {
          QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + (String)localObject + "],targetId[" + paramView.msgUid + "], hashCode:" + paramView.hashCode());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        try
        {
          long l = Long.parseLong((String)localObject);
          this.a.val$app.b().d(paramView.frienduin, paramView.istroop, l, true);
          paramInt += 1;
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
    if (BaseChatItemLayout.bdx)
    {
      paramView = ((FragmentActivity)this.a.I).getChatFragment().a();
      paramView.a(false, null, true);
      if (paramView.sessionInfo.cZ == 1008)
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        anot.a(this.a.val$app, "dc00899", "Pb_account_lifeservice", paramView.sessionInfo.aTl, "0X80064FA", "0X80064FA", 0, 0, (String)localObject, "", "", "");
      }
    }
    if ((((this.a.I instanceof SplashActivity)) || ((this.a.I instanceof ChatActivity))) && (((FragmentActivity)this.a.I).getChatFragment() != null) && (((FragmentActivity)this.a.I).getChatFragment().a() != null))
    {
      if (ujt.qn.size() == 1) {
        ((FragmentActivity)this.a.I).getChatFragment().a().a((ChatMessage)ujt.qn.get(0));
      }
      for (;;)
      {
        abrb.F(this.a.val$app, "del_multi_msg");
        return;
        ((FragmentActivity)this.a.I).getChatFragment().a().fC(ujt.qn);
      }
    }
    paramInt = 0;
    while (paramInt < ujt.qn.size())
    {
      ujt.c(this.a.val$app, (ChatMessage)ujt.qn.get(paramInt));
      paramInt += 1;
    }
    this.a.val$app.b().V(ujt.qn, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujv
 * JD-Core Version:    0.7.0.1
 */